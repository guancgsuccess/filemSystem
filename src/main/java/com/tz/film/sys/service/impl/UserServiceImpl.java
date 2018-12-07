package com.tz.film.sys.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.film.film.entity.PageBean;
import com.tz.film.sys.dao.UserDao;
import com.tz.film.sys.entity.Role;
import com.tz.film.sys.entity.User;
import com.tz.film.sys.service.UserService;
import com.tz.film.sys.vo.UserVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：UserServiceImpl   
* 类描述：   用户服务层
* 创建人：edwarder   
* 创建时间：2017年10月15日 上午11:55:11   
*       
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public String checkUser(String username,String password) {
		User user = userDao.findByUserName(username);
		if(user != null){
			if(password.equals(user.getPassword())){
				return "101";//用户登录成功
			}else{
				return "102";//用户登录失败
			}
		}else{//用户登陆不存在
			return "102";
		}
	}

	//查询列表
	public PageBean<User> queryUserListByCondition(Integer currentPage, Integer size, UserVo userVo) {
		//获取记录总数
		int count = userDao.rowCount(userVo);
		//获取集合
		List<User> list = userDao.selectUserListByCondition(currentPage, size, userVo);
		PageBean<User> pageBean = new PageBean<>(count, size);
		pageBean.setDatas(list);
		pageBean.setCurrent(currentPage);
		return pageBean;
	}

	//根据id查询用户
	public User queryUserByPrimaryKey(User user) {
		return userDao.selectUserByPrimaryKey(user.getId());
	}

	//保存用户
	public void saveUser(HttpServletRequest request) {
		//获取参数
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String roles[] = request.getParameterValues("roles");
		
		User user = new User();
		user.setUsername(username);
		user.setUpdateTime(new Date());
		//添加角色
		if(roles != null && roles.length > 0){
			Set<Role> roleList = new HashSet<>();
			for (String roleId : roles) {
				Role role = new Role();
				role.setId(Integer.valueOf(roleId));
				roleList.add(role);
			}
			user.setRoles(roleList);
		}
		//判断是新记录还更新记录
		if(!id.equals("")){//更新记录
			user.setId(Integer.valueOf(id));
			user.setPassword(password);
			userDao.update(user);
		}else{//新增记录
			user.setCreateTime(new Date());
			userDao.save(user);
		}
		
	}

	//判断是否是超级管理员
	public boolean isAdmin(User user) {
		System.out.println(user.getId() != null && user.getId() == 1);
		return user.getId() != null && user.getId() == 1;
	}

	//根据用户名查询用户
	public User queryUserByName(String username) {
		User user = userDao.findByUserName(username);
		return userDao.selectUserByPrimaryKey(user.getId());
	}

}
