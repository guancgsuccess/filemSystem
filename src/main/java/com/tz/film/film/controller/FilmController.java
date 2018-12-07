package com.tz.film.film.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tz.film.film.entity.Film;
import com.tz.film.film.entity.PageBean;
import com.tz.film.film.service.FilmService;
import com.tz.film.film.vo.FilmVo;

/**   
*    
* 项目名称：filmSystem   
* 类名称：FilmController   
* 类描述：   影片controller
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午1:56:13   
*       
*/
@Controller
@RequestMapping(value="/back")
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	private static final Integer pageSize = 2;
	private static final Integer firstPage = 1;
	
	//影片列表
	@RequestMapping("/filmList")
	public String filmList(Model model,FilmVo filmVo) throws Exception{
		List<Film> films = filmService.queryFilmListByCondition(filmVo);
		model.addAttribute("filmList", films);
		return "film/filmList";
	}
	
	//请求添加
	/*@RequestMapping("/filmAdd")
	public String filmAdd() throws Exception{
		return "film/filmForm";
	}*/
	
	//请求修改页面
	/*@RequestMapping("/modify")
	public String modify(Integer id,Model model) throws Exception{
		//根据id查询影片信息
		Film film = filmService.queryFilmByPrimaryKey(id);
		model.addAttribute("film", film);
		return "film/filmForm";
	}*/
	
	//请求表单
	@RequestMapping("/form")
	public String form(Film film,Model model) throws Exception{
		if(film.getId() != null){
			//根据id查询影片信息
			Film editFilm = filmService.queryFilmByPrimaryKey(film.getId());
			model.addAttribute("film", editFilm);
		}
		return "film/filmForm";
	}
	
	//保存影片信息
	@RequestMapping("/filmSave")
	@ResponseBody
	public String filmSave(Film film,HttpServletRequest request) throws Exception{
		
		if(film.getId() != null){//更新操作
			System.out.println(request.getParameter("remarks"));
			return filmService.updateFilm(film);
		}else{//新增操作
			return filmService.saveFilm(film);
		}
	}
	
	//上传图片
	@RequestMapping(value="/filmPicUpload",method={RequestMethod.POST})
	@ResponseBody
	public String filmPicUpload(@RequestParam("file_upload") CommonsMultipartFile filmPic) throws Exception{
		System.out.println("图片上传");
		//获取的图片原始名称
		String originalFilename = filmPic.getOriginalFilename();
		
		//上传图片
		if(filmPic != null && originalFilename != null && originalFilename.length() > 0){
			//存储图片的物理路径
			String storePath = "D:\\upload";
			//新的图片名称
			String newFilename = UUID.randomUUID() 
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(storePath + newFilename);
			//将内存中数据写入磁盘
			filmPic.transferTo(newFile);
			//上传成功将图片路径写到itemsCustom属性中
			return newFilename;
		}
		return null;
	}
	
	//删除操作
	@RequestMapping("/filmDel")
	@ResponseBody
	public String filmDel(String ids) throws Exception{
		return filmService.deleteFilms(ids);
	}
	
	//查看详情页面
	@RequestMapping("/showInfo")
	public String showInfo(Film film,Model model) throws Exception{
		//根据id查询影片信息
		Film viewFilm = filmService.queryFilmByPrimaryKey(film.getId());
		model.addAttribute("film", viewFilm);
		return "film/filmInfo";
	}
	
	//获取影片列表信息
	@RequestMapping("/getFilmData")
	public String getFilmData(Model model,FilmVo filmVo,HttpServletRequest request) throws Exception{
		String pageNo = request.getParameter("page");
		String filmName = request.getParameter("filmName");
		if(filmName != null){
			Film film = new Film();
			film.setFilmName(filmName);
			filmVo.setFilm(film);
		}
		if(pageNo == null){
			pageNo = String.valueOf(firstPage);
		}
		PageBean<Film> page = filmService.queryFilmByCondition(Integer.valueOf(pageNo), pageSize, filmVo);
		request.setAttribute("page", page);
		
		return "film/filmListDataPage";
	}
}
