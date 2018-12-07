package com.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.film.film.dao.AlbumDao;
import com.tz.film.film.dao.FilmDao;
import com.tz.film.film.entity.Film;

/**   
*    
* 项目名称：filmSystem   
* 类名称：TestFilm   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月15日 下午1:38:39   
*       
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring-mvc.xml")
public class TestFilm {
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private AlbumDao albumDao;
	
	//初始化数据
	@Test
	public void saveFilm(){
		Film film = new Film(1, "金刚狼3", null, "2017", "动作/剧情", "英文", 
				"中英双字", "詹姆斯·曼高德", "休·杰克曼", "2017", new Date(), "","20171015001","5号VIP厅");
		Film film2 = new Film(2, "神偷奶爸3", null, "2017", "喜剧/动画/冒险", "英文", 
				"中英双字", "凯尔·巴尔达  Kyle Balda", "史蒂夫·卡瑞尔 Steve Carell", "2017", new Date(), "","20171015002","1号IMAX厅");
		filmDao.save(film);
		filmDao.save(film2);
	}
	
	//查询列表
	/*@Test
	public void testFilmList(){
		filmDao.selectFilmByCondition().forEach(System.out::println);
	}*/
	
	//批量删除
	@Test
	public void testDelete(){
		String[] ids = new String[]{"35","42"};
		
		filmDao.deleteFilms(ids);
	}
	
	//删除一条记录
	@Test
	public void testDeleteOne(){
		filmDao.deteteFilm(26);
	}
	
	//查询影片集
	@Test
	public void testAlbumGroupByFilm(){
		albumDao.selectAlbumGroupFilm().forEach(System.out::println);
	}
	
	//查询影片的所有图片
	@Test
	public void testAlbumPicByFilm(){
		albumDao.selectAllPicByFilmId(61).forEach(System.out::println);
	}
	
	
}
