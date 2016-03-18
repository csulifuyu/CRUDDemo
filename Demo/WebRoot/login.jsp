<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生管理</title>

<meta name="description" content="学生管理" />
<link rel="stylesheet" type="text/css" href="css/style-diy.css" />

</head>
<script type="text/javascript">
	function loadimage() {
		document.getElementById("randImage").src = "backImage.jsp?" + Math.random();
	}

	function clearMsg() {
		document.getElementById("Msg").innerHTML = "";  //把某个id名为nameMsg的内容换成空字符,  innerHTML是对象的属性，可用于读取、写入对象的内容。
	}
</script>
<body>
<div class="main">
	<div class="header"> </div>
	<div class="content">
		<div class="title hide">管理登录</div>
	
		<form  method="post" action="LoginAction.action"  id="login">
			<fieldset>
				<div class="input">
				<input class="input_all name" type="text" name="adminAccount" placeholder="用户名"  onfocus="clearMsg()" value=${adminAccount}></input>
				
				</div>
				<div class="input">
					<input class="input_all password" type="password" name="adminPwd" placeholder="密码" onfocus="clearMsg()" value=${adminPwd}></input>
				</div>
				
				<div class="input">
				<span><input class="checkcode"  type="text" name="rand" style="width:38%" placeholder="&nbsp;&nbsp;验证码" onfocus="clearMsg()" />&nbsp;&nbsp;</span>
				<span><img alt="code..." name="randImage" id="randImage"src="backImage.jsp"  width="60" height="25" border="1" /></span>
				<span><a href="javascript:loadimage();" style="text-decoration:none"> <font size="1">&nbsp;&nbsp;&nbsp;&nbsp;换一张</font></a></span>				 					
				</div>
				<div class="input">
				<span id="Msg" style="color:red"><s:property value="loginMessage" /></span>
		         </div>
				
				
				<div class="enter">
				
					<input class="button hide" name="submit" type="submit" value="登录" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button2 hide" name="reset" type="reset" value="重置" />
				</div>
			</fieldset>
		</form>
	</div>
</div>
<script type="text/javascript" src="js/placeholder.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="js/belatedpng.js" ></script>
<script type="text/javascript">
	DD_belatedPNG.fix("*");
</script>
<![endif]--></body>
</html>
