<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../../common/include.jsp"%>
<!-- 静态加载 -->
<%--  这种方式不能引用页面的标签，属于动态加载
<jsp:include page="../../common/include.jsp"></jsp:include>
 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>user_list</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>



<body>
	<%-- 
		<c:forEach items="${userList }" var="item">
			<c:out value="${item.id.entityCode }"></c:out>&nbsp;&nbsp;
			<c:out value="${item.employeeNo }"></c:out>&nbsp;&nbsp;
			<c:out value="${item.userName }"></c:out>&nbsp;&nbsp;
			<c:out value="${item.userCode }"></c:out><br>
		</c:forEach>
		 --%>
	<div class="queryBox">
		<div class="thirdBox">
			<input type="button" id="query_user_list" value="查询">
		</div>
	</div>
		 
	<table id="user_list_table">
		<thead>
			<tr>
				<th>岗位代码</th>
				<th>部门编号</th>
				<th>员工编号</th>
				<th>用户名</th>
				<th>登录号</th>
				<th>创建时间</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
		
	</table>

</body>

<script type="text/javascript">

	var user_list_table;
	$(document).ready(function() {
		var table = $('#user_list_table').dataTable({
        "bProcessing": true,
        colReorder: true,		// 用于固定表头
        fixedHeader: true,
       // "sScrollY": "300px",
       "bServerSide" : true,			// Configure DataTables to use server-side processing
        "sAjaxSource": "${ctx}/login/ajaxUserList.do",	
        "fnServerData": function ( sSource, aoData, fnCallback ) {
				 $.ajax( {
					 "dataType": 'json',
					 "type": "post",
					 "url": sSource,
					 "data":  {
							aoData : JSON.stringify(aoData),
							"1" : 1
						},
					 "success": fnCallback
				 } );
			 },
		"bProcessing" : true,
		"searching" : false,			//搜索输入框显示
		"bLengthChange" : true,// 控制每页显示记录数
		"iDisplayLength": 10,
		"oLanguage" : {
				"sLengthMenu" : "",
				"sZeroRecords" : "没有找到符合条件的数据",
				"sProcessing" : "正在加载数据...",
				"sInfo" : "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
				"sInfoEmpty" : "没有记录",
				"sInfoFiltered" : "(从 _MAX_ 条记录中过滤)",
				"sSearch" : "搜索：",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "<<",
					"sNext" : ">>",
					"sLast" : "尾页"
				}
			},
        "aoColumns": [
            { 
            	"mData": "positionCode" ,
            	"sClass": "center"
            },
            { 
            	"mData": "orgCode" ,
            	"sClass": "center"
            },
            { 
            	"mData": "employeeNo" ,
            	"sClass": "center"
            },
            { 
            	"mData": "userName" ,
            	"sClass": "center"
            },
            { 
            	"mData": "userCode" ,
            	"sClass": "center"
            },
            { 
            	"mData": "createDate" ,
            	"sClass": "center"
            }
	        ]
	    });
		
		user_list_table = table;

	});
	
	$(document).off("click", "#user_list_table tbody tr");
	$(document).on("click", "#user_list_table tbody tr", function(){
        if ( $(this).hasClass('row_selected') ) {
            $(this).removeClass('row_selected');
        }else {
            $(this).addClass('row_selected');
        }
    });
	
	$(document).off("click", "#query_user_list");
	$(document).on("click", "#query_user_list", function(){
		if(user_list_table != null){
			user_list_table.fnDraw(false);
		}
	});
	
</script>

</html>


