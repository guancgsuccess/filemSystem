package com.tz.film.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.film.film.entity.PageBean;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.entity.User;
import com.tz.film.sys.service.RoleService;
import com.tz.film.sys.service.UserService;
import com.tz.film.sys.vo.UserVo;


/**   
*    
* 项目名称：filmSystem   
* 类名称：UserController   
* 类描述：   用户控制器
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午12:01:35   
*       
*/
@Controller
@RequestMapping(value="/sys/user")
public class UserController {
	private static final Integer pageSize = 4;
	private static final Integer firstPage = 1;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	//用户请求登陆页面
	@RequestMapping("/login")
	public String login() throws Exception{
		return "user/login";
	}
	
	//处理登陆请求
	@RequestMapping(value="/loginHandler",produces="text/html;charset=utf-8")
	@ResponseBody
	public String loginHandler(@Validated User user,BindingResult bindingResult,
			HttpSession session) throws Exception{
		//获取校验的错误信息
		if(bindingResult.hasErrors()){
			//输出错误信息
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError objectError: errors){
				System.out.println(objectError.getDefaultMessage());
			}
			//错误时留在当前页面
			return errors.get(0).getDefaultMessage();
		}
				
		String flag = userService.checkUser(user.getUsername(), user.getPassword());
		if(flag.equals("101")){//登陆成功将用户名保存到session中
			session.setAttribute("user", userService.queryUserByName(user.getUsername()));
		}
		return flag;
	}
	
	//安全退出
	@RequestMapping("/safeExit")
	public String safeExit(HttpSession session) throws Exception{
		session.invalidate();
		//重定向到列表页
		return "redirect:/back/filmList";
	}
	
	//用户列表
	@RequestMapping("/userList")
	public String userList() throws Exception{
		return "sys/userList";
	}
	
	//角色列表
	@RequestMapping("/getUserData")
	public String getRoleData(Model model,UserVo userVo,HttpServletRequest request) throws Exception{
		String pageNo = request.getParameter("page");
		if(pageNo == null){
			pageNo = String.valueOf(firstPage);
		}
		PageBean<User> pageBean = userService.queryUserListByCondition(Integer.valueOf(pageNo), pageSize, userVo);
		model.addAttribute("page", pageBean);
		return "sys/userListDataPage";
	}
	
	//用户表单
	@RequestMapping("/form")
	public String form(User user,Model model) throws Exception{
		if(user.getId() != null){
			user = userService.queryUserByPrimaryKey(user);
		}
		List<Role> roleList = roleService.queryAllRoles();
		model.addAttribute("user", user);
		model.addAttribute("roleList", roleList);
		return "sys/userForm";
	}
	
	//保存用户
	@ResponseBody
	@RequestMapping("/save")
	public String save(HttpServletRequest request) throws Exception{
		userService.saveUser(request);
		return "success";
	}
}
