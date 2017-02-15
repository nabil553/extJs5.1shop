<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>商城平台注册</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="<%=path %>/res/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=path %>/res/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="<%=path %>/res/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=path %>/res/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=path %>/res/assets/css/login.css" />
</head>
	<body class="login-layout">		
	 <div class="login-container">
	 
			<div class="center">
				<h1><i class="icon-coffee  blue"></i>&nbsp;<span class="red">沂品</span><span class="white">商城平台注册</span></h1>
				<h4 class="blue">&copy; SaiJie&nbsp;InfoCo., Ltd.</h4>
			</div>
				
			<div id="login-box" class="login-box visible widget-box no-border">
					<div class="widget-main">
						<h4 class="header blue lighter bigger"><i class="icon-coffee"></i>请输入您的用户名和密码</h4>
						<div class="space-6"></div>
						<form action="${pageContext.request.contextPath }/signon"  method="post" >
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" name="userName" class="form-control" placeholder="用户名" />
										<i class="icon-user"></i>
									</span>
								</label>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" name="userPwd" class="form-control" placeholder="密码" />
										<i class="icon-lock"></i>
									</span>
								</label>
								<div class="space"></div>
								<div class="clearfix">
									<button type="submit" class="width-30 pull-right btn btn-sm btn-primary">
										<i class="icon-key"></i>登录
									</button>
								</div>
							</fieldset>
						</form>
						<div class="social-or-login center"> <span class="bigger-110">欢迎您的登录</span> </div>
					<!-- <div class="social-login center">
							<a class="btn btn-primary">
								<i class="icon-facebook"></i>
							</a>
							<a class="btn btn-info">
								<i class="icon-twitter"></i>
							</a>
							<a class="btn btn-danger">
								<i class="icon-google-plus"></i>
							</a>
						</div> -->	
					</div><!-- /widget-main -->
			<!-- 	-->
					<div class="toolbar clearfix">
						<div>
							<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
								<i class="icon-arrow-left"></i> 忘记密码？
							</a>
						</div>
						<div>
							<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
								注册用户<i class="icon-arrow-right"></i>
							</a>
						</div>
			
					</div>
			</div><!-- /login-box -->
			
			<!--**************************************注册用户*********************************************** -->
			<div id="signup-box" class="signup-box widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header green lighter bigger"><i class="icon-group blue"></i>新用户注册</h4>
						<p> 请输入您的注册邮箱: </p>
						<form action="<%=path %>/addUser" method="post">
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" name="email" class="form-control" placeholder="Email" /><i class="icon-envelope"></i>
									</span>
								</label>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" name="userName" class="form-control" placeholder="用户名" /><i class="icon-user"></i>
									</span>
								</label>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" name="userPwd" class="form-control" placeholder="密码" /><i class="icon-lock"></i>
									</span>
								</label>
								<div class="clearfix">
									<button type="reset" class="width-30 pull-left btn btn-sm">
										<i class="icon-refresh"></i>重置
									</button>
									<button type="submit" class="width-65 pull-right btn btn-sm btn-success">
										提交<i class="icon-arrow-right icon-on-right"></i>
									</button>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="toolbar center">
						<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
							<i class="icon-arrow-left"></i>返回登录
						</a>
					</div>
				</div>
			</div><!-- /signup-box -->
			<!--**************************************密码找回*********************************************** -->
			<div id="forgot-box" class="forgot-box widget-box no-border">
					<div class="widget-main">
						<h4 class="header red lighter bigger"><i class="icon-key"></i> 密码找回</h4>
						<p>请输入您的注册邮箱/手机号</p>
						<form>
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="email" class="form-control" placeholder="Email" />
										<i class="icon-envelope"></i>
									</span>
								</label>
								<div class="clearfix">
									<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
										<i class="icon-lightbulb"></i>获得!
									</button>
								</div>
							</fieldset>
						</form>
					</div><!-- /widget-main -->
					<div class="toolbar center">
						<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
							返回登录<i class="icon-arrow-right"></i>
						</a>
					</div>
			</div><!-- /forgot-box -->
		
	</div>
					
		<!-- basic scripts -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			}
		</script>
</body>
</html>
