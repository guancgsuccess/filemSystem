package com.tz.film.sys.dao;

import java.util.List;

import com.tz.film.sys.entity.Role;
import com.tz.film.sys.vo.RoleVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：RoleDao   
* 类描述：   角色dao
* 创建人：edwarder   
* 创建时间：2017年10月26日 上午11:00:10   
*       
*/
public interface RoleDao {
	//保存角色
	public void saveRole(Role role);
	
	//查询记录总数
	public int rowCount(RoleVo roleVo); 
	
	//查询list
	public List<Role> selectRoleListByCondition(Integer currentPage,Integer size,RoleVo roleVo);
	
	//根据id获取角色
	public Role selectRoleByPrimaryKey(Role role);
	
	//保存角色菜单
	public void saveRoleMenuById(Integer id,String[] ids);
	
	//根据角色id删除关联表中已有的关联关系
	public void deleteRoleMenuById(Integer id);
	
	//查询所有的角色
	public List<Role> selectAllRoles();
}
