package com.tz.film.sys.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tz.film.sys.dao.UserDao;
import com.tz.film.sys.entity.User;
import com.tz.film.sys.vo.UserVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：UserDaoImpl   
* 类描述：   接口实现类
* 创建人：edwarder   
* 创建时间：2017年10月15日 上午11:04:42   
*       
*/
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	//获取sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	
	//获得和当前线程绑定的session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//保存用户
	
	public void save(User user) {
		getSession().save(user);
	}

	//根据用户名查询用户
	public User findByUserName(String username) {
		return (User) getSession().createQuery("from User where username=:uname")
				.setParameter("uname", username)
				.uniqueResult();
	}

	//查询记录总数
	public int rowCount(UserVo userVo) {
		Criteria criteria = getSession().createCriteria(User.class);
		return criteria.list().size();
	}

	//查询list
	@SuppressWarnings("unchecked")
	public List<User> selectUserListByCondition(Integer currentPage, Integer size, UserVo userVo) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setFirstResult((currentPage - 1) * size);
		criteria.setMaxResults(size);
		return criteria.list();
	}

	//根据id查询用户
	public User selectUserByPrimaryKey(Integer id) {
		User user = (User) getSession().get(User.class, id);
		Hibernate.initialize(user.getRoles());
		return user;
	}

	//更新用户
	public void update(User user) {
		getSession().update(user);
	}

}
