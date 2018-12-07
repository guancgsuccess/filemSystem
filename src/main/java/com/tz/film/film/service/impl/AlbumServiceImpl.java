package com.tz.film.film.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tz.film.film.dao.AlbumDao;
import com.tz.film.film.dao.FilmDao;
import com.tz.film.film.entity.Album;
import com.tz.film.film.entity.Film;
import com.tz.film.film.service.AlbumService;

/**   
*    
* 项目名称：filmSystem   
* 类名称：AlbumServiceImpl   
* 类描述：   影片集服务层实现类
* 创建人：edwarder   
* 创建时间：2017年10月22日 下午3:00:07   
*       
*/
@Service
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private AlbumDao albumDao;

	/**
	 * 上传影片集
	 * @throws IOException 
	 */
	public void saveAlbumByFilmId(MultipartFile[] file, Integer id) {
		//获取影片对象
		Film film = filmDao.selectFilmByPrimaryKey(id);
		if(file != null && file.length> 0){
			for (int j = 0; j < file.length; j++) {
				MultipartFile f = file[j];
				try {
					//保存图片到磁盘
					String newFileName = savePicToDisk(f);
					//将图片持久化到数据库中
					Album album = new Album();
					album.setImgUrl(newFileName);
					album.setFilm(film);
					albumDao.saveAlbum(album);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//保存图片到磁盘
	public String savePicToDisk(MultipartFile file) throws Exception{
		if(!file.isEmpty()){
			//获取的图片原始名称
			String originalFilename = file.getOriginalFilename();
			
			//存储图片的物理路径
			String storePath = "D:\\upload\\";
			//新的图片名称
			String newFilename = UUID.randomUUID() 
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(storePath + newFilename);
			//将内存中数据写入磁盘
			file.transferTo(newFile);
			//返回图片路径
			return newFilename;
		}
		return null;
	}

	//查询所有的影片集，并按影片进行分组
	public List<Film> queryAlbumGroupByFilm() {
		return albumDao.selectAlbumGroupFilm();
	}

	//根据影片id查询所有的影片图集
	public List<Album> queryAllPicByFilmId(Integer id) {
		return albumDao.selectAllPicByFilmId(id);
	} 

}
