package com.tz.film.film.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Album   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月22日 下午2:45:02   
*       
*/
@Entity
@Table(name="film_album")
public class Album implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String imgUrl;
	private Film film;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@ManyToOne
	@JoinColumn(name="filmId")
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", imgUrl=" + imgUrl + ", film=" + film + "]";
	}
	
}
