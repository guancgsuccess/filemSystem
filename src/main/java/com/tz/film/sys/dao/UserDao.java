package com.tz.film.sys.dao;

import java.util.List;

import com.tz.film.sys.entity.User;
import com.tz.film.sys.vo.UserVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：UserDao   
* 类描述：用户接口
* 创建人：jzhang  
* 创建时间：2017年10月15日 上午11:02:17   
* 联系方式：1104975916@qq.com 
*      
*/
public interface UserDao {
	/**
	 * 保存一个用户
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 更新一个用户
	 */
	public void update(User user);
	
	/**
	 * 根据用户名来查询用户
	 * 实际开发中,注册的用户名必然是唯一的.
	 */
	public User findByUserName(String username);
	
	/**
	 * 获取用户列表记录总数
	 */
	public int rowCount(UserVo userVo);
	
	/**
	 * 分页查询列表
	 */
	public List<User> selectUserListByCondition(Integer currentPage, Integer size,UserVo userVo);
	
	//根据id查询用户
	public User selectUserByPrimaryKey(Integer id);
}
