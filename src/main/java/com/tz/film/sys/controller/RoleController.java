package com.tz.film.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.film.film.entity.PageBean;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.service.RoleService;
import com.tz.film.sys.vo.RoleVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：RoleController   
* 类描述：   角色控制器
* 创建人：edwarder   
* 创建时间：2017年10月26日 上午10:42:02   
*       
*/
@Controller
@RequestMapping("/sys/role")
public class RoleController {
	private static final Integer pageSize = 4;
	private static final Integer firstPage = 1;
	
	@Autowired
	private RoleService roleService;
	
	//角色列表页
	@RequestMapping("/roleList")
	public String roleList() throws Exception{
		return "sys/roleList";
	}
	
	//角色列表
	@RequestMapping("/getRoleData")
	public String getRoleData(Model model,RoleVo roleVo,HttpServletRequest request) throws Exception{
		String pageNo = request.getParameter("page");
		if(pageNo == null){
			pageNo = String.valueOf(firstPage);
		}
		PageBean<Role> pageBean = roleService.queryRoleListByCondition(Integer.valueOf(pageNo), pageSize, roleVo);
		model.addAttribute("page", pageBean);
		return "sys/roleListDataPage";
	}
	
	//角色表单
	@RequestMapping("/form")
	public String form(Model model) throws Exception{
		
		return "sys/roleFom";
	}
	
	//进入菜单权限编辑页
	@RequestMapping("/getRoleMenu")
	public String getRoleMenu(Role role,Model model) throws Exception{
		Role queryRole = roleService.queryRoleById(role);
		model.addAttribute("role", queryRole);
		return "sys/addRoleMenu";
	}
	
	//json获取角色的菜单
	@ResponseBody
	@RequestMapping(value= "/getRoleMenuList",produces="text/html;charset=utf-8")
	public String getRoleMenuList(Role role) throws Exception{
		return roleService.queryRoleMenuListById(role);
	}
	
	//保存角色菜单
	@ResponseBody
	@RequestMapping("/saveRoleMenu")
	public String saveRoleMenu(RoleVo roleVo) throws Exception{
		roleService.saveRoleMenu(roleVo);
		return "success";
	}
}
