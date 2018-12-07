package com.tz.film.film.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tz.film.film.dao.FilmDao;
import com.tz.film.film.entity.Film;
import com.tz.film.film.vo.FilmVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：FilmDaoImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午1:32:15   
*       
*/
@Transactional
@Repository
public class FilmDaoImpl implements FilmDao {
	//获取sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	
	//获得和当前线程绑定的session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Film film) {
		getSession().save(film);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> selectFilmByCondition(FilmVo filmVo) {
		Criteria criteria = getSession().createCriteria(Film.class,"film");
		if (filmVo != null && filmVo.getFilm() != null 
				&& filmVo.getFilm().getFilmName() != null
				&& filmVo.getFilm().getFilmName() != "") {
			criteria.add(Restrictions.like("film.filmName", "%" + filmVo.getFilm().getFilmName() + "%"));
		}
		return criteria.addOrder(Order.desc("film.id")).list();
	}

	@Override
	public Film selectFilmByPrimaryKey(Integer id) {
		return (Film) getSession().get(Film.class, id);
	}

	@Override
	public void updateFilm(Film film) {
		getSession().update(film);
	}

	//批量删除
	public void deleteFilms(String[] ids) {
		String hql = "";
		for (int i = 0; i < ids.length; i++) {
			System.out.println(ids[i]);
			if(i==0) {
				hql = "id = " + Integer.parseInt(ids[i]);
			} else {
				hql = hql + "or id=" + Integer.parseInt(ids[i]);
			}
			getSession().createQuery("delete from Film where " + hql).executeUpdate();
		}
		
	}

	@Override
	public void deteteFilm(Integer id) {
		String sql = "delete from FILM_FILM where id = " + id;
		getSession().createSQLQuery(sql).executeUpdate();
	}

	//查询记录总数
	public int rowCount(FilmVo filmVo) {
		Criteria criteria = getSession().createCriteria(Film.class,"film");
		if (filmVo != null && filmVo.getFilm() != null 
				&& filmVo.getFilm().getFilmName() != null
				&& filmVo.getFilm().getFilmName() != "") {
			criteria.add(Restrictions.like("film.filmName", "%" + filmVo.getFilm().getFilmName() + "%"));
		}
		return criteria.addOrder(Order.desc("film.id")).list().size();
	}

	//分页查询列表
	@SuppressWarnings("unchecked")
	public List<Film> selectFilmByCondition(Integer currentPage, Integer size, FilmVo filmVo) {
		Criteria criteria = getSession().createCriteria(Film.class,"film");
		if (filmVo != null && filmVo.getFilm() != null 
				&& filmVo.getFilm().getFilmName() != null
				&& filmVo.getFilm().getFilmName() != "") {
			criteria.add(Restrictions.like("film.filmName", "%" + filmVo.getFilm().getFilmName() + "%"));
		}
		criteria.setFirstResult((currentPage - 1) * size);
		criteria.setMaxResults(size);
		return criteria.addOrder(Order.desc("film.id")).list();
	}

}
