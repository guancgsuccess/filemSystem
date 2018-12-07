package com.tz.film.sys.service;

import com.tz.film.sys.entity.Menu;

/**   
*    
* 项目名称：filmSystem   
* 类名称：MenuService   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月23日 下午1:16:59   
*       
*/

public interface MenuService {
	//保存节点
	public void saveNodes(Menu menu);
	
	//更新节点信息
	public void updateNodes(Menu menu);
	
	//删除节点
	public void deleteNodes(Menu menu);
	
	//获取所有的菜单
	public String queryAllMenu();
	
	//根据id获取菜单
	public Menu queryMenuById(Menu menu);
}
