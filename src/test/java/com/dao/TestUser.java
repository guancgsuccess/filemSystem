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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.film.sys.dao.UserDao;
import com.tz.film.sys.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring-mvc.xml")
public class TestUser {
	@Autowired
	private UserDao userDao;
	
	
	//模拟数据
	@Test
	public void insertUser(){
		User user = new User(1, "jack", "123456");
		User user2 = new User(2, "tom", "123456");
		userDao.save(user);
		userDao.save(user2);
		
	}
	
	//查询
	@Test
	public void selectUser(){
		System.out.println(userDao.findByUserName("jack"));
	}
}
