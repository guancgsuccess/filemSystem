package com.tz.film.film.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tz.film.film.entity.Album;
import com.tz.film.film.entity.Film;

/**   
*    
* 项目名称：filmSystem   
* 类名称：AlbumService   
* 类描述：   影片集服务层
* 创建人：edwarder   
* 创建时间：2017年10月22日 下午2:55:09   
*       
*/
public interface AlbumService {
	//保存图片集
	public void saveAlbumByFilmId(MultipartFile[] file,Integer id);
	
	//查询所有的影片集，并按影片进行分组
	public List<Film> queryAlbumGroupByFilm();
	
	//根据影片id查询所有的影片图集
	public List<Album> queryAllPicByFilmId(Integer id);
	
}
