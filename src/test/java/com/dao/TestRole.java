package com.dao;
/**   
*    
* 项目名称：filmSystem   
* 类名称：TestUser   
* 类描述：   用户测试类
* 创建人：edwarder   
* 创建时间：2017年10月15日 上午11:13:20   
*       
*/

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.film.sys.dao.RoleDao;
import com.tz.film.sys.entity.Role;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring-mvc.xml")
public class TestRole {
	@Autowired
	private RoleDao roleDao;
	
	
	//模拟数据
	@Test
	public void insertRole(){
		Role role = new Role(1, "admin", "超级管理员", "1", new Date(), new Date(), "0");
		Role role2 = new Role(2, "manager", "经理", "1", new Date(), new Date(), "0");
		Role role3 = new Role(3, "employee", "普通员工", "1", new Date(), new Date(), "0");
		roleDao.saveRole(role);
		roleDao.saveRole(role2);
		roleDao.saveRole(role3);
	}
	
	//查询
	@Test
	public void selectUser(){
		//roleDao.selectRoleListByCondition().forEach(System.out::println);
	}
}
