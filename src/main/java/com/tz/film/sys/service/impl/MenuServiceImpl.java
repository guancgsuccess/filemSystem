package com.tz.film.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tz.film.sys.dao.MenuDao;
import com.tz.film.sys.entity.Menu;
import com.tz.film.sys.service.MenuService;

/**   
*    
* 项目名称：filmSystem   
* 类名称：MenuServiceImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月23日 下午1:18:05   
*       
*/
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	
	//查询菜单
	public String queryAllMenu() {
		List<Menu> menus = menuDao.selectAllMenu(new Menu());
		List<Map<String, Object>> list = new ArrayList<>();
		for (Menu menu : menus) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", menu.getId());
			map.put("pId", menu.getpId());
			map.put("name", menu.getName());
			list.add(map);
		}
		return JSON.toJSONString(list);
	}

	//保存节点
	public void saveNodes(Menu menu) {
		//默认设置新增节点为子节点
		menu.setIsParent("0");
		//menu
		//将父节点的isParent更新为1
		menuDao.updateMenuIsParent(menu,"1");
		menuDao.saveMenu(menu);
	}

	//更新节点
	public void updateNodes(Menu menu) {
		menuDao.updateMenu(menu);
	}

	//删除节点
	public void deleteNodes(Menu menu) {
		menuDao.deleteMenu(menu);
		//删除一个节点后判断该节点的父节点是否还有子节点，没有则更新isParent字段为0
		List<Menu> menus = menuDao.selectAllMenu(menu);
		if(menus.isEmpty()){//集合为空，则修改父节点的标识位
			menuDao.updateMenuIsParent(menu,"0");
		}
	}

	//根据id获取菜单
	public Menu queryMenuById(Menu menu) {
		return menuDao.selectMenuByPrimaryKey(menu.getId());
	}

}
