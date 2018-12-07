package com.tz.film.film.dao;

import java.util.List;

import com.tz.film.film.entity.Film;
import com.tz.film.film.vo.FilmVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：FilmDao   
* 类描述：   影片dao
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午1:26:50   
*       
*/
public interface FilmDao {

	//保存影片信息
	public void save(Film film);
	
	//查询所有的影片
	public List<Film> selectFilmByCondition(FilmVo filmVo);
	
	//根据id查询影片信息
	public Film selectFilmByPrimaryKey(Integer id);
	
	//更新影片信息
	public void updateFilm(Film film); 
	
	//批量删除操作
	public void deleteFilms(String[] ids);
	
	//单条记录删除
	public void deteteFilm(Integer id);
	
	//查询记录总数
	public int rowCount(FilmVo filmVo);
	
	//查询列表-分页查询
	public List<Film> selectFilmByCondition(Integer currentPage,Integer size,FilmVo filmVo);

}
