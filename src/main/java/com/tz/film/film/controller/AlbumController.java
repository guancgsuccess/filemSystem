package com.tz.film.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tz.film.film.entity.Album;
import com.tz.film.film.entity.Film;
import com.tz.film.film.service.AlbumService;
import com.tz.film.film.service.FilmService;

/**   
*    
* 项目名称：filmSystem   
* 类名称：AlbumController   
* 类描述：   影片集控制器
* 创建人：edwarder   
* 创建时间：2017年10月22日 上午9:54:51   
*       
*/
@Controller
@RequestMapping("/back/album")
public class AlbumController {
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private AlbumService albumService;
	
	//请求影片集上传页面
	@RequestMapping("/getAlbumUploadPage/{id}")
	public String getAlbumUploadPage(@PathVariable("id") Integer id,Model model) throws Exception{
		Film film = filmService.queryFilmByPrimaryKey(id);
		model.addAttribute("film", film);
		return "film/albumUploadPage";
	}
	
	//处理上传的图片集
	@RequestMapping("/multiPicUpload/{id}")
	public String multiPicUpload(@PathVariable("id") Integer id,
			@RequestParam("file") MultipartFile[] file) throws Exception{
		//上传图片
		albumService.saveAlbumByFilmId(file, id);
		return "film/albumList";
	}
	
	//影片集列表
	@RequestMapping("/albumList")
	public String albumList(Model model) throws Exception{
		List<Film> films = albumService.queryAlbumGroupByFilm();
		model.addAttribute("films", films);
		return "film/albumList";
	}
	
	//获取所有的图片
	@RequestMapping("/showAllPic/{id}")
	public String showAllPic(@PathVariable("id") Integer id,Model model) throws Exception{
		List<Album> albums = albumService.queryAllPicByFilmId(id);
		Film film = filmService.queryFilmByPrimaryKey(id);
		model.addAttribute("film", film);
		model.addAttribute("albums", albums);
		return "film/albumView";
	}
}
