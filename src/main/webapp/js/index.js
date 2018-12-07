/**全选功能**/
function checkAll(obj){
	//1.获取所有的td中的checkbox
	var cks = document.getElementsByName("cks");
	
	//2.循环遍历.
	if(obj.checked){
		for(var i=0;i<cks.length;i++){
			cks[i].checked = true;
		}
	}else{
		for(var i=0;i<cks.length;i++){
			cks[i].checked = false;
		}
	}
}

/**删除学生**/
function delStu(){
	//获取当前登录的用户名称
	//var uname = document.getElementById("uname").value;
	
	//1.确定是否勾选了
	var count = 0;
	
	//定义一个变量,用来拼接checkbox的value
	var sids="";
	
	//1.获取所有的td中的checkbox
	var cks = document.getElementsByName("cks");
	
	//2.遍历
	for(var i=0;i<cks.length;i++){
		if(cks[i].checked){
			count++;
			sids+=cks[i].value+",";
		}
	}
	//3.判断...
	if(count==0){
		//说明没有勾选的.
		alert("对不起!请您先选择需要删除的学生信息!");
		return;
	}
	
	//4.选了.
	var flag = window.confirm("确定删除吗?");//返回是true-确定
	
	//5.判断
	if(flag){
		//发送到删除学生的action
		window.location.href='/studentSys/student/delStudent?sids='+sids.substring(0,sids.length-1);
	}
}