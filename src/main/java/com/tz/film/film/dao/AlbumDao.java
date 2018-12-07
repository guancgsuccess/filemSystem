package com.tz.film.film.dao;

import java.util.List;

import com.tz.film.film.entity.Album;
import com.tz.film.film.entity.Film;

/**   
*    
* 项目名称：filmSystem   
* 类名称：AlbumDao   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月22日 下午3:35:02   
*       
*/
public interface AlbumDao {
	//保存影片集
	public void saveAlbum(Album album);
	
	//根据影片id进行分组查询
	public List<Film> selectAlbumGroupFilm();
	
	//通过影片id获取所有的图片
	public List<Album> selectAllPicByFilmId(Integer id);
}
