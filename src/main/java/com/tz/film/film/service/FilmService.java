package com.tz.film.film.service;
/**   
*    
* 项目名称：filmSystem   
* 类名称：FilmService   
* 类描述：   影片列表Service
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午1:50:51   
*       
*/

import java.util.List;

import com.tz.film.film.entity.Film;
import com.tz.film.film.entity.PageBean;
import com.tz.film.film.vo.FilmVo;

public interface FilmService{
	//保存影片信息
	public String saveFilm(Film film);

	//根据条件查询列表
	public List<Film> queryFilmListByCondition(FilmVo filmVo);
	
	//根据id查询影片信息
	public Film queryFilmByPrimaryKey(Integer id);
	
	//更新影片信息
	public String updateFilm(Film film);
	
	//批量删除
	public String deleteFilms(String ids);
	
	//分页查询列表
	public PageBean<Film> queryFilmByCondition(Integer currentPage,Integer size,FilmVo filmVo);
}
