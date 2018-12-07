package com.tz.film.sys.service;
/**   
*    
* 项目名称：filmSystem   
* 类名称：UserService   
* 类描述：   用户服务层
* 创建人：edwarder   
* 创建时间：2017年10月15日 上午11:52:02   
*       
*/

import javax.servlet.http.HttpServletRequest;

import com.tz.film.film.entity.PageBean;
import com.tz.film.sys.entity.User;
import com.tz.film.sys.vo.UserVo;

public interface UserService {
	/**
	 * 校验用户的存在性和密码的正确性
	 * @return
	 */
	public String checkUser(String username,String password);
	
	/**
	 * 查询列表
	 */
	public PageBean<User> queryUserListByCondition(Integer currentPage,Integer size,UserVo userVo);
	
	/**
	 * 根据id查询用户
	 */
	public User queryUserByPrimaryKey(User user);
	
	/**
	 * 保存、更新用户
	 */
	public void saveUser(HttpServletRequest request);
	
	/**
	 * 判断用户是否是超级管理员
	 */
	public boolean isAdmin(User user);
	
	/**
	 * 根据用户名查询用户
	 */
	public User queryUserByName(String username);
}
