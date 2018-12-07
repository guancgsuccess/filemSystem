package com.tz.film.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**   
*    
* 项目名称：springmvcdemo   
* 类名称：DateConverter   
* 类描述：   日期转换器
* 创建人：edwarder   
* 创建时间：2017年9月24日 下午3:52:40   
*       
*/
public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		//实现将日期串转成日期类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			//转换成功返回
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//转换失败
		return null;
	}

}
