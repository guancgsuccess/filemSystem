package com.tz.film.sys.service;
/**   
*    
* 项目名称：filmSystem   
* 类名称：RoleService   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月26日 下午3:10:04   
*       
*/

import java.util.List;

import com.tz.film.film.entity.PageBean;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.vo.RoleVo;

public interface RoleService {
	//查询所有角色
	public List<Role> queryAllRoles();
	
	//查询角色列表
	public PageBean<Role> queryRoleListByCondition(Integer currentPage,Integer size,RoleVo roleVo);
	
	//根据id获取角色
	public Role queryRoleById(Role role);
	
	//根据角色id获取菜单
	public String queryRoleMenuListById(Role role);
	
	//保存角色菜单
	public void saveRoleMenu(RoleVo roleVo);
}
