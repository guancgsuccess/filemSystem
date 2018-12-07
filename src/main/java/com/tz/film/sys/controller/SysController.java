package com.tz.film.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
*    
* 项目名称：filmSystem   
* 类名称：SysController   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月24日 下午2:59:48   
*       
*/
@Controller
@RequestMapping("/sys")
public class SysController {

	//默认页面
	@RequestMapping("/defaultPage")
	public String defaultPage() throws Exception{
		return "/sys/defaultPage";
		
	}
}
