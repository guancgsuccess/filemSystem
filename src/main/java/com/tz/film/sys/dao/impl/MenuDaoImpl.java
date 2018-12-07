package com.tz.film.sys.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tz.film.sys.dao.MenuDao;
import com.tz.film.sys.entity.Menu;

/**   
*    
* 项目名称：filmSystem   
* 类名称：MenuDaoImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月23日 下午12:59:29   
*       
*/
@Repository
@Transactional
public class MenuDaoImpl implements MenuDao {
	//获取sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	
	//获得和当前线程绑定的session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
		
	//保存菜单
	public void saveMenu(Menu menu) {
		getSession().save(menu);
	}

	@SuppressWarnings("unchecked")
	//查询列表
	public List<Menu> selectAllMenu(Menu menu) {
		Criteria criteria = getSession().createCriteria(Menu.class,"menu");
		if(menu != null && menu.getpId() != null){
			criteria.add(Restrictions.eq("menu.pId", menu.getpId()));
		}
		return criteria.list();
	}

	//更新节点
	public void updateMenu(Menu menu) {
		getSession().update(menu);
	}

	//删除菜单
	public void deleteMenu(Menu menu) {
		getSession().delete(menu);
	}

	//根据id获取菜单
	public Menu selectMenuByPrimaryKey(Integer id) {
		Menu m = (Menu) getSession().get(Menu.class, id);
		System.out.println("==========>menu:" + m);
		return m;
	}

	//更新节点的isParent状态为1
	public void updateMenuIsParent(Menu menu,String isParent) {
		String sql = "update sys_menu set isParent = '" + isParent + "' where id=" + menu.getpId();
		getSession().createSQLQuery(sql).executeUpdate();
	}

}
