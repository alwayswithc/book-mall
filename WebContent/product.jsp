<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品详情页</title>
        <link href="css/zzsc.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" class="library" src="js/jquery-1.8.2.min.js"></script>
	    <script type="text/javascript" class="library" src="js/jquery.colorbox-min.js"></script>
        <script type="text/javascript" class="library" src="js/zzsc.js"></script>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <script src="bootstrap/js/jquery-3.1.0.min.js"></script>
	    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <jsp:include page="head.jsp" />
    <img src="images/ye.PNG" style="margin-left: 150px;margin-top: 30px;width:80%;">
            <table cellspacing="0" cellpadding="0" width="80%" style="margin-left: 150px">
            	<tr>
            		<td>
            		     <div class="con-FangDa" id="fangdajing"  >
            				<div class="con-fangDaIMg">
            					<!-- 正常显示的图片-->
            					<img src="${b.simg}">
            					<!-- 滑块-->
            					<div class="magnifyingBegin"></div>
            					<!-- 放大镜显示的图片 -->
            					<div class="magnifyingShow"><img src="${b.bimg}"></div>
            				</div>
            			</div>
            			<br>
            			<br>
            			<div style="padding-left:90px;">
            	      	<a></a><button class="btn btn-success">立即购买<span class="glyphicon glyphicon-heart"></span></button>
            			<a href="Product?cmd=addCart&id=${b.id}"><button class="btn btn-default">加入购物车<span class="glyphicon glyphicon-shopping-cart"></span></button></a>
            			</div>	
            		</td>
            		<td>
            		      &nbsp; &nbsp; &nbsp;<font style="font-family: '微软雅黑';font-size:25px;color:#8C8C8C;">${b.name }</font>
            		     <hr><br>
            		      &nbsp; &nbsp; &nbsp;<b>种类</b> &nbsp;${b.category}
            		      <hr><br>
            		      &nbsp; &nbsp; &nbsp;<b>价格</b> &nbsp;<font style="color:red">${b.price}</font>
            		      <hr><br>
            		      &nbsp; &nbsp; &nbsp;<b>库存</b>&nbsp;${b.pnum}
            		      <hr><br>
            		      &nbsp; &nbsp; &nbsp;<b>图书简介</b><br>
            		      <div style="width:600px;background-color: #F7F7F7;">
            		      ${b.description}
            		      </div>
            		</td>
            	</tr>
        
            </table>
</body>
</html>