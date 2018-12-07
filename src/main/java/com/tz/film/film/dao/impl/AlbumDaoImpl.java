package com.tz.film.film.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tz.film.film.dao.AlbumDao;
import com.tz.film.film.entity.Album;
import com.tz.film.film.entity.Film;

/**   
*    
* 项目名称：filmSystem   
* 类名称：AlbumDaoImpl   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月22日 下午3:36:01   
*       
*/
@Repository
@Transactional
public class AlbumDaoImpl implements AlbumDao {
	//获取sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	
	//获得和当前线程绑定的session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
		
	@Override
	public void saveAlbum(Album album) {
		getSession().save(album);
	}

	//根据影片id进行分组查询
	@SuppressWarnings("unchecked")
	@Override
	public List<Film> selectAlbumGroupFilm() {
		Criteria criteria = getSession().createCriteria(Album.class);
		criteria.setProjection(Projections.groupProperty("film"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> selectAllPicByFilmId(Integer id) {
		Criteria criteria = getSession().createCriteria(Album.class,"album");
		if(id != null && !"".equals(id)){
			criteria.add(Restrictions.eq("album.film.id", id));
		}
		return criteria.list();
	}

}
