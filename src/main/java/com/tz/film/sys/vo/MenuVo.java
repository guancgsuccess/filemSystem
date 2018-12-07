package com.tz.film.sys.vo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Menu vo类  
* 类描述：   菜单实体类
* 创建人：edwarder   
* 创建时间：2017年10月23日 上午11:36:44   
*       
*/
public class MenuVo{

	private Integer id;
	private Integer pId;//父菜单id
	private String name;//菜单名称
	private String mUrl;//菜单路径
	private String isParent;//是否是父菜单
	
	public MenuVo() {
		super();
	}
	
	public MenuVo(Integer id, Integer pId, String name, String mUrl, String isParent) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.mUrl = mUrl;
		this.isParent = isParent;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", pId=" + pId + ", name=" + name + ", mUrl=" + mUrl + ", isParent=" + isParent + "]";
	}
	
}
