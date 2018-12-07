package com.tz.film.sys.dao.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tz.film.sys.dao.RoleDao;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.vo.RoleVo;
/**   
*    
* 项目名称：filmSystem   
* 类名称：RoleDaoImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月26日 上午11:01:24   
*       
*/
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{
	//获取sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	
	//获得和当前线程绑定的session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
		
	//保存角色
	public void saveRole(Role role) {
		getSession().save(role);
	}

	

	//查询总记录数
	public int rowCount(RoleVo roleVo) {
		Criteria criteria = getSession().createCriteria(Role.class);
		return criteria.list().size();
	}

	//查询list
	@SuppressWarnings("unchecked")
	public List<Role> selectRoleListByCondition(Integer currentPage, Integer size, RoleVo roleVo) {
		Criteria criteria = getSession().createCriteria(Role.class,"role");
		criteria.setFirstResult((currentPage - 1) * size);
		criteria.setMaxResults(size);
		return criteria.addOrder(Order.desc("role.id")).list();
	}

	//根据id获取角色
	public Role selectRoleByPrimaryKey(Role role) {
		Role r = (Role) getSession().get(Role.class, role.getId());
		//查询关联的表
		Hibernate.initialize(r.getMenus());
		return r;
	}

	//根据id保存菜单
	public void saveRoleMenuById(Integer id, String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			String sql = "insert into sys_role_menu(role_id,menu_id) values("+ id +","+ Integer.valueOf(ids[i]) +")";
			SQLQuery query = getSession().createSQLQuery(sql);
			query.executeUpdate();
		}
	}

	//删除角色已关联的菜单
	public void deleteRoleMenuById(Integer id) {
		String sql = "delete from sys_role_menu where role_id="+id;
		getSession().createSQLQuery(sql).executeUpdate();
	}

	//查询所有的角色
	@SuppressWarnings("unchecked")
	public List<Role> selectAllRoles() {
		Criteria criteria = getSession().createCriteria(Role.class);
		return criteria.list();
	}
	
	

}
