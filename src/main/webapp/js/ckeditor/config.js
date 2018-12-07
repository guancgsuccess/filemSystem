/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	    config.language = 'zh-cn'; // 配置语言
	 
	    //config.uiColor = '#fff'; // 背景颜色
	 
	    //config.width = '600px'; // 宽度
	 
	    //config.height = '400px'; // 高度
	 
	    //config.skin = 'office2003';// 界面v2,kama,office2003
	    //config.allowedContent= true;
	 
	    config.toolbar = 'Full';// 工具栏风格Full,Basic
	     
	    config.font_names='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;' +
	    '隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
	     
	    /*config.filebrowserBrowseUrl ='js/ckfinder/ckfinder.html';
	     
	    config.filebrowserImageBrowseUrl ='js/ckfinder/ckfinder.html?Type=Images';
	     
	    config.filebrowserFlashBrowseUrl = 'js/ckfinder/ckfinder.html?Type=Flash';
	     
	    config.filebrowserUploadUrl = 'js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	     
	    config.filebrowserImageUploadUrl = 'js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	     
	    config.filebrowserFlashUploadUrl = 'js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';*/
};
