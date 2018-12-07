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

import com.tz.film.sys.dao.MenuDao;
import com.tz.film.sys.entity.Menu;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring-mvc.xml")
public class TestMenu {
	@Autowired
	private MenuDao menuDao;
	
	
	//模拟数据
	@Test
	public void insertMenu(){
		Menu menu = new Menu(1, 0, "系统菜单", "", "1");
		menuDao.saveMenu(menu);
	}
	
	//查询
	@Test
	public void selectMenu(){
		menuDao.selectAllMenu(new Menu()).forEach(System.out::println);
	}
}
