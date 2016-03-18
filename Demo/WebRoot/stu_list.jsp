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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>学生管理</title>

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="bower_components/datatables-responsive/css/dataTables.responsive.css"
	rel="stylesheet">

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
<style type="text/css">
.dataTables_length {
	float: left;
}

#dataTables-example_length {
	float: left;
}
</style>
</head>

<body>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="page-header col-sm-12">
							<h3>
								<small class="pull-right"><a href="student!goAdd"
									class="btn btn-primary pull-right">添加学生</a>
								</small> 学生列表
							</h3>
						</div>
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example-memo">
									<thead>
										<tr>
											<th>编号</th>
											<th>姓名</th>
											<th>出生日期</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="stuList" var="stuList">
											<tr class="odd gradeA"
												id=<s:property value="#stuList.stuId"/>>
												<td><s:property value="#stuList.stuId" /></td>
												<td><s:property value="#stuList.stuName" />
												</td>
												<td><s:property value="#stuList.stuBirthday" />
												</td>
												<td>				
												 <a href="student!showStu?stuId=<s:property value="#stuList.stuId"/>"><span
														class="glyphicon glyphicon-edit"></span>
												</a>
												 &nbsp;&nbsp;&nbsp; 
												<a href="javascript:deleteStu(<s:property value="#stuList.stuId"/>)">
														<span class="glyphicon glyphicon-trash"></span>
												</a>
												</td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
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


	<!-- DataTables JavaScript -->
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>


	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example-memo').DataTable({
				responsive : true,
				"oLanguage" : {
					"sInfo" : "从_START_到_END_/共_TOTAL_条数据",
					"oPaginate" : {
						"sFirst" : "首页  ",
						"sPrevious" : "  前一页 ",
						"sNext" : "  后一页  ",
						"sLast" : "  尾页"
					},
					"sZeroRecords" : "没有检索到数据",
					"sSearch" : "搜索：",
					"sLengthMenu" : "每页显示  _MENU_ 条记录",
					"sInfoEmpty" : "没有数据",
					"sInfoFiltered" : "(从_MAX_条数据中检索)"
				},
				"sPaginationType" : "full_numbers"

			});
		});
	</script>
	<script>
		function deleteStu(value) {
			var r = confirm("确定删除编号为" + value + "的记录吗？");
			if (r == true) {

				$.ajax({
					url : 'student!deleteStu',
					type : 'POST',
					dataType : 'text',
					data : {
						stuId : value
					},
					success : function() {
						$("#" + value).remove();
						//alert('删除成功');
					},

					error : function() {
						alert('删除失败');
					}
				});
			}
		}
	</script>
</body>
</html>
