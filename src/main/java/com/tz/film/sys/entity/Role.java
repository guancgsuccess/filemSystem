package com.tz.film.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Role   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月24日 下午4:39:08   
*       
*/
@Entity
@Table(name="sys_role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String role;//角色
	private String description;//角色描述
	private String status;//角色状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private String delFlag = "0";//删除表示位0表示正常，1表示删除
	private Set<Menu> menus = new HashSet<>();
	private Set<User> users = new HashSet<>();
	
	public Role() {
		super();
	}

	
	public Role(Integer id, String role, String description, String status, Date createTime, Date updateTime,
			String delFlag) {
		super();
		this.id = id;
		this.role = role;
		this.description = description;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.delFlag = delFlag;
	}


	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Column
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	@ManyToMany
	@JoinTable(name="sys_role_menu",
				joinColumns = {@JoinColumn(name="role_id",referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(name="menu_id",referencedColumnName="id")})
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	@ManyToMany(targetEntity = User.class,mappedBy="roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", description=" + description + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", delFlag=" + delFlag + "]";
	}

}
