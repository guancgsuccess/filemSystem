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
import javax.validation.constraints.Size;

/**   
*    
* 项目名称：filmSystem   
* 类名称：User   
* 类描述：   管理员实体
* 创建人：edwarder   
* 创建时间：2017年10月13日 上午8:26:31   
*       
*/
@Entity
@Table(name="sys_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	@Size(min=1,max=15,message="{user.name.length.error}")
	private String username;
	@Size(min=6,max=15,message="{user.password.error}")
	private String password;
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private String delFlag = "0";//删除表示位0表示正常，1表示删除
	private Set<Role> roles = new HashSet<>();
	
	public User() {
	}
	
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Id
	/*@GeneratedValue(generator = "gen_user_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_user_id", sequenceName = "seq_user_id", allocationSize = 1)*/
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@ManyToMany
	@JoinTable(name="sys_user_role",
				joinColumns = {@JoinColumn(name="user_id",referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")})
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Column(updatable=false)
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
