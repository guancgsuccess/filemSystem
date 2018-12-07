package com.tz.film.sys.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.film.sys.entity.Menu;
import com.tz.film.sys.service.MenuService;
import com.tz.film.sys.vo.MenuVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：MenuController   
* 类描述：   菜单控制器
* 创建人：edwarder   
* 创建时间：2017年10月23日 上午10:51:58   
*       
*/
@Controller
@RequestMapping("/sys/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	//获取菜单展示页面
	@RequestMapping("/menuList")
	public String menuList() throws Exception{
		return "sys/menuList";
	}
	
	//获取所有的菜单列表
	@RequestMapping(value="/getAllMenu",produces="text/html;charset=utf-8" )
	@ResponseBody
	public String getAllMenu() throws Exception{
		return menuService.queryAllMenu();
	}
	
	//保存节点
	@RequestMapping("/saveNodes")
	@ResponseBody
	public String saveNodes(Menu menu) throws Exception{
		menuService.saveNodes(menu);
		return "success";
	}
	
	//删除节点
	@RequestMapping("/deleteNode")
	@ResponseBody
	public String deleteNode(Menu menu) throws Exception{
		menuService.deleteNodes(menu);
		return "success";
	}
	
	//更新节点
	@RequestMapping("/updateNode")
	@ResponseBody
	public String updateNode(Menu menu) throws Exception{
		menuService.updateNodes(menu);
		return "success";
	}
	
	//更新节点
	@RequestMapping("/queryNode")
	@ResponseBody
	public MenuVo queryNode(Menu menu) throws Exception{
		Menu m = menuService.queryMenuById(menu);
		MenuVo menuVo = new MenuVo();
		BeanUtils.copyProperties(m, menuVo);
		return menuVo;
	}
}
