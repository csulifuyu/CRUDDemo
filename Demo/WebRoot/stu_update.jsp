<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改学生信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">
		<div id="page-wrapper">
			
			<div class="row">
				<div class="col-lg-11">
					<div class="panel panel-default">
					<div class="page-header col-sm-12">
							<h3>
								<small class="pull-right"><a href="student!goStuList"
									class="btn btn-primary pull-right">返回列表</a>
								</small> 修改记录
							</h3>
						</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form" action="student!updateStu" method="post">
								<h3 class="mb">基本信息</h3>
								<div class="form-group">
									<label class="control-label col-sm-3" for="notNull">编号</label>
									<div class="col-sm-8 col-md-6 col-lg-5">
										<input type="text" name="newStudent.stuId" class="form-control" value="${studentVo.stuId}" readonly>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="notNull">姓名</label>
									<div class="col-sm-8 col-md-6 col-lg-5">
										<input type="text" name="newStudent.stuName" class="form-control" value="${studentVo.stuName}">
									</div>
								</div>

								<div class="form-group">
									    <label class="control-label col-sm-3">性别</label>
                                        <div class="col-sm-8 col-md-6 col-lg-5">
                                    
                                       <s:if test="stuSex=='man'">
                                      <div class="radio">
                                           <label>
                                        <input type="radio" name="newStudent.stuSex" value="男" checked>男
                                       </label>
                                       </div> 
                                     <div class="radio">
                                       <label>
                                       <input type="radio" name="newStudent.stuSex" value="女">女
                                        </label>
                                       </div> 
                                       </s:if>
                                       <s:else>
                                  <div class="radio">
                                           <label>
                                        <input type="radio" name="newStudent.stuSex" value="男" >男
                                       </label>
                                       </div> 
                                     <div class="radio">
                                       <label>
                                       <input type="radio" name="newStudent.stuSex" value="女" checked>女
                                        </label>
                                       </div> 
                                       </s:else>
                                 
                               
                                      

                                           </div>
								</div>

								<div class="form-group">
									<label for="birth" class="control-label col-sm-3">出生日期</label>
                                    <div class="col-sm-8 col-md-6 col-lg-5">
                                       <input type="text" name="newStudent.stuBirthday" id="birth" class="datepicker form-control" autocomplete="off" value="${studentVo.stuBirthday}">
                                    </div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="">联系电话</label>
									<div class="col-sm-8 col-md-6 col-lg-5">
										<input type="text" name="newStudent.stuMobile" class="form-control" value="${studentVo.stuMobile}">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3">家庭地址</label>
									<div class="col-sm-8 col-md-6 col-lg-5">
										<input type="text" name="newStudent.stuCity" class="form-control" value="${studentVo.stuCity}">
									</div>
								</div>




								<div class="form-group">
									 <div class="col-sm-offset-3 col-sm-8 col-md-offset-5 col-md-6 col-lg-offset-6 col-lg-5">
                                    <button class="btn btn-primary" type="submit">提 交</button>
                                   <button class="btn btn-default ml-15"  type="reset" data-dismiss="modal">重置</button>
                                   </div>

								</div>

							</form>
						</div>
					
					</div>
					
				</div>
				

			</div>
	
		</div>
		

	</div>
	<!-- jQuery -->
	<script src="bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>


	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

</body>
<!-- 日期选择器 -->
<script src="plugins/Datepicker-for-Bootstrap/bootstrap-datepicker.js"></script>
<script type="text/javascript">
window.$ && $(function() {

  /**
   * 日期选择
   */
   $('.datepicker').datepicker({
    format: 'yyyy/mm/dd'
  });

 
});
</script>
</html>
