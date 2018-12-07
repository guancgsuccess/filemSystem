package com.tz.film.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.film.film.dao.FilmDao;
import com.tz.film.film.entity.Film;
import com.tz.film.film.entity.PageBean;
import com.tz.film.film.service.FilmService;
import com.tz.film.film.vo.FilmVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：FilmServiceImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午1:53:41   
*       
*/
@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmDao filmDao;
	
	/**
	 * 根据条件查询所有的影片列表
	 */
	public List<Film> queryFilmListByCondition(FilmVo filmVo) {
		return filmDao.selectFilmByCondition(filmVo);
	}

	@Override
	public String saveFilm(Film film) {
		filmDao.save(film);
		return "success";
	}

	@Override
	public Film queryFilmByPrimaryKey(Integer id) {
		return filmDao.selectFilmByPrimaryKey(id);
	}

	@Override
	public String updateFilm(Film film) {
		filmDao.updateFilm(film);
		return "success";
	}

	//批量删除
	public String deleteFilms(String ids) {
		String[] arrayIds = ids.split(",");
		filmDao.deleteFilms(arrayIds);
		return "success";
	}

	//分页查询
	public PageBean<Film> queryFilmByCondition(Integer currentPage, Integer size, FilmVo filmVo) {
		//获取记录总数
		int count = filmDao.rowCount(filmVo);
		//获取list集合
		List<Film> filmList = filmDao.selectFilmByCondition(currentPage, size, filmVo);
		PageBean<Film> pageBean = new PageBean<>(count, size);
		pageBean.setCurrent(currentPage);
		pageBean.setDatas(filmList);
		return pageBean;
	}

}
