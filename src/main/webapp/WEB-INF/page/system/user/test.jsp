<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/include.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<script src="${ctx}/resource/js/sockjs-0.3.js"></script>


<title>webSocket测试</title>
<script type="text/javascript">
	$(function() {
		var websocket;
		if ('WebSocket' in window) {
			alert("WebSocket");
			websocket = new WebSocket("ws://127.0.0.1:8080/mavenPro/myHandler");
			//websocket = new WebSocket("ws://echo.websocket.org");
		} else if ('MozWebSocket' in window) {
			alert("MozWebSocket");
			websocket = new MozWebSocket("ws://echo");
		} else {
			alert("SockJS");
			websocket = new SockJS("http://127.0.0.1:8080/mavenPro/sockjs/myHandler");
		}
		websocket.onopen = function(evnt) {
			$("#tou").html("链接服务器成功!")
		};
		websocket.onmessage = function(evnt) {
			$("#msg").html($("#msg").html() + "<br/>" + evnt.data);
		};
		websocket.onerror = function(evnt) {
		};
		websocket.onclose = function(evnt) {
			$("#tou").html("与服务器断开了链接!")
		}
		$('#send').bind('click', function() {
			send();
		});
		function send() {
			if (websocket != null) {
				var message = document.getElementById('message').value;
				websocket.send(message);
			} else {
				alert('未与服务器链接.');
			}
		}
	});
</script>

</head>
<body>

	<div class="page-header" id="tou">webSocket及时聊天Demo程序</div>
	<div class="well" id="msg"></div>
	<div class="col-lg">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="发送信息..."
				id="message"> <span class="input-group-btn">
				<button class="btn btn-default" type="button" id="send">发送</button>
			</span>
		</div>
		<!-- /input-group -->
	</div>
	<!-- /.col-lg-6 -->
</body>

</html>