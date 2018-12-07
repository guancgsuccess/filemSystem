package com.tz.film.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tz.film.sys.dao.MenuDao;
import com.tz.film.sys.dao.RoleDao;
import com.tz.film.sys.entity.Menu;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.entity.User;
import com.tz.film.sys.service.UserService;


/**   
*    
* 项目名称：filmSystem   
* 类名称：LoginInterceptor   
* 类描述：用户登录认知
* 创建人：jzhang  
* 创建时间：2017年10月15日 下午6:31:47   
* 联系方式：1104975916@qq.com 
*      
*/
public class

LoginInterceptor implements HandlerInterceptor{
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserService userService;
	
	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor1===>afterCompletion");
		
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
		//判断响应的数据是否是json方式，普通方式为null，不需要再次加载菜单
		if(response.getContentType() == null){
			//判断session
			HttpSession session = request.getSession();
			//从session中获取用户信息
			User user = (User) session.getAttribute("user");
			if(user != null && user.getUsername() != null && user.getUsername() != ""){
				List<Menu> menuList = new ArrayList<>();
				System.out.println("===============>"+userService.isAdmin(user));
				if(userService.isAdmin(user)){//超级管理加载所有菜单
					menuList = menuDao.selectAllMenu(new Menu());
				}else{
					Set<Role> roles = user.getRoles();
					if(!roles.isEmpty()){//根据角色加载菜单,暂时一个用户只能拥有一个角色
						//如果是多角色需重新处理
						Iterator<Role> iterator = roles.iterator();
						while(iterator.hasNext()){
							menuList = new ArrayList<>(roleDao.selectRoleByPrimaryKey(iterator.next()).getMenus());
						}
					}else{
						//新增的用户，还未给角色时，加载一个默认的菜单
						//TODO
					}
				}
				modelAndView.addObject("menuList", menuList);
			}
		}
		System.out.println("HandlerInterceptor1===>postHandle");
		
	}

	////进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		//获取请求的url
		String url = request.getRequestURI();
		
		//判断url地址是否公开地址（实际开发中再配置文件中配置）
		//这里是登陆提交地址
		if(url.indexOf("login") >= 0){
			//如果进行登陆提交，则放行
			return true;
		}
		
		//判断session
		HttpSession session = request.getSession();
		//从session中获取用户信息
		User user = (User) session.getAttribute("user");
		if(user != null && user.getUsername() != null && user.getUsername() != ""){
			//身份存在，放行
			return true;
		}
		
		//此时需要校验用户身份验证，跳转到登陆页面
		//request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/sys/user/login");
		 //return false表示拦截，不向下执行
		//return true表示放行
		return false;
	}

}
