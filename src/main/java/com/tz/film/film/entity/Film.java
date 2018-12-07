package com.tz.film.film.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Film   
* 类描述：   影片实体
* 创建人：edwarder   
* 创建时间：2017年10月13日 上午8:39:09   
*       
*/
@Entity
@Table(name="FILM_FILM")
public class Film implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String filmCode;//影片编号
	private String filmName;//电影名称
	private String filmPic;//谍照
	private String years;	//年代
	private String types;	//类型
	private String language;	//语言
	private String caption;		//字幕
	private String director;	//导演
	private String actors;		//演员
	private String releaseTime;	//上映时间
	private String playRoom;	//播放影厅
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date playTime;		//播放时间
	private String remarks;		//简介
	
	public Film() {
		// TODO Auto-generated constructor stub
	}
	
	public Film(Integer id, String filmName, String filmPic, String years, String types, String language,
			String caption, String director, String actors, String releaseTime, Date playTime, String remarks,
			String filmCode,String playRoom) {
		super();
		this.id = id;
		this.filmName = filmName;
		this.filmPic = filmPic;
		this.years = years;
		this.types = types;
		this.language = language;
		this.caption = caption;
		this.director = director;
		this.actors = actors;
		this.releaseTime = releaseTime;
		this.playTime = playTime;
		this.remarks = remarks;
		this.filmCode = filmCode;
		this.playRoom = playRoom;
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
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	@Column
	public String getFilmPic() {
		return filmPic;
	}

	public void setFilmPic(String filmPic) {
		this.filmPic = filmPic;
	}

	@Column
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@Column
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@Column
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Column
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column
	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@Column
	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column
	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	@Column
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Column
	public String getFilmCode() {
		return filmCode;
	}

	public void setFilmCode(String filmCode) {
		this.filmCode = filmCode;
	}
	
	@Column
	public String getPlayRoom() {
		return playRoom;
	}

	public void setPlayRoom(String playRoom) {
		this.playRoom = playRoom;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", filmName=" + filmName + ", filmPic=" + filmPic + ", years=" + years + ", types="
				+ types + ", language=" + language + ", caption=" + caption + ", director=" + director + ", actors="
				+ actors + ", releaseTime=" + releaseTime + ", playTime=" + playTime + ", remarks=" + remarks + "]";
	}
	
}
