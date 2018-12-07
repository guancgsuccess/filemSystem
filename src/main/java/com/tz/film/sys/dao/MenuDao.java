package com.tz.film.sys.dao;

import java.util.List;

import com.tz.film.sys.entity.Menu;

/**   
*    
* 项目名称：filmSystem   
* 类名称：MenuDao   
* 类描述：   菜单接口
* 创建人：edwarder   
* 创建时间：2017年10月23日 下午12:57:49   
*       
*/
public interface MenuDao {
	//保存菜单
	public void saveMenu(Menu menu);
	
	//查询所有的菜单
	public List<Menu> selectAllMenu(Menu menu);
	
	//更新节点信息
	public void updateMenu(Menu menu);
	
	//删除节点
	public void deleteMenu(Menu menu);
	
	//查询菜单节点
	public Menu selectMenuByPrimaryKey(Integer id);
	
	//更新节点isParent字段状态
	public void updateMenuIsParent(Menu menu,String isParent);
}
