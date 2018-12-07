package com.tz.film.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tz.film.film.entity.PageBean;
import com.tz.film.sys.dao.MenuDao;
import com.tz.film.sys.dao.RoleDao;
import com.tz.film.sys.entity.Menu;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.service.RoleService;
import com.tz.film.sys.vo.RoleVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：RoleServiceImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月26日 下午3:14:44   
*       
*/
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public PageBean<Role> queryRoleListByCondition(Integer currentPage, Integer size, RoleVo roleVo) {
		//获取总记录数
		int count = roleDao.rowCount(roleVo);
		//获取集合
		List<Role> list = roleDao.selectRoleListByCondition(currentPage, size, roleVo);
		PageBean<Role> pageBean = new PageBean<>(count, size);
		pageBean.setCurrent(currentPage);
		pageBean.setDatas(list);
		return pageBean;
	}

	//根据id获取角色
	public Role queryRoleById(Role role) {
		//获取角色
		Role queryRole = roleDao.selectRoleByPrimaryKey(role);
		return queryRole;
	}

	/**
	 * 根据id查询角色，并加载菜单
	 */
	public String queryRoleMenuListById(Role role) {
		List<Map<String, Object>> mapList = new ArrayList<>();
		//查询所有的菜单
		List<Menu> allMenulist = menuDao.selectAllMenu(new Menu());
		//查询当前角色拥有的菜单
		
		List<Menu> managerMenuList = new ArrayList<>(roleDao.selectRoleByPrimaryKey(role).getMenus());
		
		for(int i=0;i<allMenulist.size();i++){  
	            Menu e = allMenulist.get(i);  
	            Map<String, Object> map = new HashMap<>();  
	            map.put("id", e.getId());  
	            map.put("pId", e.getpId());  
	            map.put("name", e.getName());  
	            for(Menu roleMenu:managerMenuList){  
	                if(roleMenu.getId() == e.getId()){  
	                    map.put("checked", true);  
	                }  
	            }  
	            mapList.add(map);  
	    }
		
		return JSON.toJSONString(mapList);
	}

	//保存角色菜单
	public void saveRoleMenu(RoleVo roleVo) {
		//查询该角色是否拥有菜单
		List<Menu> managerMenuList = new ArrayList<>(roleDao.selectRoleByPrimaryKey(roleVo.getRole()).getMenus());
		String[] ids = roleVo.getMenuIds().split(",");
		
		if(!managerMenuList.isEmpty()){
			//先移除已有菜单
			roleDao.deleteRoleMenuById(roleVo.getRole().getId());
		}
		
		roleDao.saveRoleMenuById(roleVo.getRole().getId(),ids);
	}

	//查询所有的角色
	public List<Role> queryAllRoles() {
		return roleDao.selectAllRoles();
	}

}
