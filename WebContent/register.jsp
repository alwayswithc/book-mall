 <%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
   String path = request.getContextPath();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>

<link rel="stylesheet" href="css/all.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/my.js"></script> 
<script type="text/javascript">
	function changeImage() {		
		document.getElementById("img").src = "ImageCodeServlet?time="
				+ new Date().getTime();
	}
	
	function validate(){
			var code=$("#ckcode").val();
	    	if(code==null||code==""){    		
	    		$("#codeDiv").html("<font style='color:red'>验证码不能为空</font>");

	    	}else{    		
	    		$.getJSON('user?cmd=check',{code:code},function d(data){
					$("#codeDiv").html(data.msg);
				});	
	    	}
	}
	   
</script>
</head>
<body>
    <!--头部-->
    <div class="header">
        <a class="logo" href="##"></a>
        <div class="desc">欢迎注册</div>
    </div>
    <!--版心-->
    <form action="${pageContext.request.contextPath}/user?cmd=register" method="post" >
    <div class="container">
    	<!--当当注册模块-->
    	<div class="register">
    		<!--用户名-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="userName">用&nbsp;户&nbsp;名</label>
    				<input type="text" id="userName" placeholder="您的账户名和登录名" name="uname" onblur="vv()"/>
    					<span id="checkuser"></span>
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--设置密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd">设 置 密 码</label>
    				<input type="password" id="pwd" placeholder="建议至少两种字符组合" name="password" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--确认密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd2">确 认 密 码</label>
    				<input type="password" id="pwd2" placeholder="请再次输入密码" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
			<!--设置密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="email">邮 箱 </label>
    				<input type="text" id="email" placeholder="请输入邮箱" name="email"/>
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span id="mailspan"></span>
    			</div>
    		</div>
    		<!--手机验证-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="mobile">手 机 </label>
    				<input type="text" id="mobile" placeholder="请输入手机号" name="phone"/>
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span id="phonespan"></span>
    			</div>
    		</div>
    		<!-- 验证码 -->
    		<div class="checkimg">
    		<h4>注册校验</h4><br>
			<table width="100%" border="0" cellspacing="1" class="upline">
							<tr>
								<td style="text-align: left; width: 40%">输入校验码：</td>
								<td style="width: 60%"><input type="text" style="border:1px solid black; height:25px"
									name="ckcode" id="ckcode" onblur="validate()" /></td>
								
							</tr>
							<tr>
								<td style="text-align: right; width: 20%;">&nbsp;</td>
								<td colspan="2" style="width: 90%"><img
									src="ImageCodeServlet" width="180"
									height="30"  id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">换一张</a>
								</td>
							</tr>
							<tr><td><span id="codeDiv"></span></td></tr>
						</table>
			</div>   			
    		<br>
    		<div class="register-box xieyi">
    			<!--表单项-->
    			<div class="box default">
    				<input type="checkbox" id="ck" />
    				<span>我已阅读并同意<a href="##">《当当用户注册协议》</a></span>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--注册-->
    		<input id="btn" type="submit" value="注册" ></input>
    	</div>
    </form>
</body>
</html>