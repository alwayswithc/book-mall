<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="css/index.css" rel="stylesheet">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <script src="bootstrap/js/jquery-3.1.0.min.js"></script>
	    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
		$(function() { $('.containor').on('mouseenter', function() { $(".nav_right").removeClass('hide'); }).on('mouseleave', function() { $(".nav_right").addClass('hide'); $(".sub").addClass('hide'); }).on('mouseenter', 'li', function(e) { var li_data = $(this).attr('data-id'); $(".sub").addClass('hide'); $('.sub[data-id="' + li_data + '"]').removeClass('hide'); }) })
	  function locking(){
 document.all.zzjs_net.style.display="block";
 document.all.zzjs_net.style.width=document.body.clientWidth; 
 document.all.zzjs_net.style.height=document.body.clientHeight;
 document.all.www_zzjs_net.style.display='block';
}
function Lock_CheckForm(theForm){
 document.all.zzjs_net.style.display='none';document.all.www_zzjs_net.style.display='none';
 return false;
}
</script>
<body>
      <div class="row" id="head">
			<div class="col-xs-10 col-lg-10 col-md-10" style="margin-top: 10px;padding-left: 30px;">
			<c:if test="${user!=null }">
			<font style="font-family: '微软雅黑';font-size: medium;">欢迎${user.username}光临当当</font>
			&nbsp;&nbsp;&nbsp;<a href="user?cmd=logout">注销</a>
			</c:if>
			<c:if test="${user==null}">
			<font style="font-family: '微软雅黑';font-size: medium;">欢迎光临当当，请<a href="#" style="color: #66AFE9;" onClick="locking();">登录</a>成为会员</font>
			</c:if>
			</div>
			<div id="zzjs_net" style="position:absolute;top:0px;filter: Alpha(opacity=70);opacity:0.7;background-color:#eef;z-index:2;left:0px;display:none;"></div>
<!--浮层框架开始-->
<div id="www_zzjs_net" align="center" style="position:absolute;z-index:3;left:expression_r((document.body.offsetWidth-540)/2);top:expression_r((document.body.offsetHeight-170)/10);background-color:#fff;display:none;">
  <table width="540" height="300" border="0" cellpadding="0" cellspacing="0" style="border:0 solid #e7e3e7;border-collapse:collapse;">
    <tr>
      <td style="background-color:pink;color:#fff;padding-left:4px;padding-top:2px;font-weight:bold;font-size:12px;" height="20" valign="middle"><div align="right"><a href="JavaScript:;" class="style1" onClick="Lock_CheckForm(this) "><font style="color:red">X</font></a>&nbsp;&nbsp;</div></td>
    </tr>
    <tr>
      <td height="130" align="center"><br />
        <form action="user?cmd=login2" method="post">
                                       用户名&nbsp;<input name="logname" type="text"  style="width:200px;height:30px;border-radius:3px;border:1px solid crimson;"><br><br>
                                        密码&nbsp;&nbsp;&nbsp;&nbsp;<input name="logpass" type="password" style="width:200px;height:30px;border-radius:3px;border:1px solid crimson;"><br><br>
               <input type="submit" value="登录" style="width:250px;height:30px;background-color:pink;border:none"> <br>
              <div style="text-align:center">还没账户？点此<a href="register.jsp">注册</a></div>                    
        </form>
      </td>
    </tr>
  </table>
</div>
			<div class="col-xs-2 col-lg-2 col-md-2" style="margin-top: 10px;">
				<font style="font-family: '微软雅黑';font-size: medium;">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">我的当当<span class="caret"></span></a>
					<ul class="dropdown-menu">
								<li><a href="#">我的订单</a></li>
								<li><a href="#">购物车</a></li>
                    </ul>
				</font>
			</div>
		</div>
		<div class="row" id="top">
			<div class="col-xs-3 col-lg-3 col-md-3"><img src="images/logo.PNG"></div>
			<div class="col-xs-7 col-lg-7 col-md-7" >
				<div class="input-group" style="padding: 30px;">
					<input type="text" class="form-control" placeholder="搜索商品" >
					<span class="input-group-btn">
				        <button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-search" ;"></span></button>
				      </span>
				</div>	
            </div>
            <div class="col-xs-2 col-lg-2 col-md-2"><img src="images/二维码.PNG"></div>
        <!--
        	轮滚面板
        -->
       
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000" >
     	<div class="carousel-inner">
     	<div class="item active">
         <img src="images/1.jpg" alt="First slide" class="img-responsive" style="width: 100% ">
		</div>
		<div class="item">
         <img src="images/2.jpg  " alt="Second slide" class="img-responsive" style="width: 100% ">
		</div>
        <div class="item">
         <img src="images/3.jpg" alt="Third slide" class="img-responsive" style="width: 100% ">
        </div>
         <div class="item">
         <img src="images/4.jpg" alt="Fourth slide" class="img-responsive" style="width: 100% ">
        </div>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
        <ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1" ></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		<li data-target="#carousel-example-generic" data-slide-to="3"></li>
	   </ol>
       </div>
       
       <!--导航-->
       <div class="containor">
			<div class="nav_left">
				<ul>
					<li data-id="1"> <span>美妆/个人护理</span></li>
					<li data-id="2"> <span>手机 /数码 /电脑办公</span></li>
					<li data-id="3"> <span>零食 /茶酒 /进口食品 </span></li>
					<li data-id="4"> <span>母婴玩具 </span></li>
					<li data-id="5"> <span>腕表 /眼镜 /珠宝饰品 </span></li>
					<li data-id="6"> <span>大家电 /生活电器 </span></li>
					<li data-id="7"> <span>厨具 /收纳 /宠物  </span></li>
					<li data-id="8"> <span>汽车 /配件 /用品  </span></li>
					<li data-id="9"> <span>生鲜水果  </span></li>
					<li data-id="10"> <span>家纺 /家饰 /鲜花   </span></li>
				</ul>
			</div>
			<div class="nav_right">
				<div class="sub hide" data-id="1">
					<dl>
						<dt><a >护肤品 <i> &gt;</i></a> </dt>
						<dd>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
						</dd>
						
					</dl>
						<dl>
						<dt><a >彩妆 <i> &gt;</i></a> </dt>
						<dd>
							<a>时尚彩妆</a>
							<a>香水</a>
							<a>气垫护肤</a>
							<a>BB霜</a>
							<a>口红</a>
							<a>隔离</a>
						<a>粉底</a>
							<a>粉饼</a>
						</dd>
						
					</dl>
						<dl>
						<dt><a >男士护肤 <i> &gt;</i></a> </dt>
						<dd>
							<a>洁面爽</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>肤水乳液/面霜</a>
							<a>精华液</a>
							<a>眼部护理</a>
							<a>面膜</a>
							<a>唇部护理</a>
							<a>防晒</a>
							<a>精华液</a>
							<a>T区护理控油</a>
							
						</dd>
						
					</dl>
              <dl>
             </div>

				<div class="sub hide" data-id="2">
					<dl>
						<dt><a >电脑办公 <i> &gt;</i></a> </dt>
						<dd>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
						</dd>
					</dl>

				</div>

				<div class="sub hide" data-id="3">
					<dl>
						<dt><a >进口食品 <i> &gt;</i></a> </dt>
						<dd>
							<a>官方直售</a>
							<a>饼干</a>
							<a>海苔</a>
							<a>火腿肠</a>
							<a>方便面</a>
							<a>果冻</a>
							<a>水果干</a>
							<a>坚果</a>
							<a>面包蛋糕</a>
							<a>华夫饼</a>
							<a>进口巧克力</a>
							<a>进口咖啡</a>
							<a>进口葡萄酒</a>
							<a>啤酒饮料</a>
						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="4">
					<dl>
						<dt><a >母婴玩具 <i> &gt;</i></a> </dt>
						<dd>
							<a>童装</a>
							<a>秋换新</a>
							<a>商场同款</a>
							<a>特价优惠</a>
							<a>秋衣秋裤</a>
							<a>外套</a>
							<a>羽绒服</a>
							<a>夹克</a>
							<a>连衣裙</a>
							<a>裤子</a>

						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="5">
					<dl>
						<dt><a >珠宝饰品 <i> &gt;</i></a> </dt>
						<dd>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="6">
					<dl>
						<dt><a >生活电器 <i> &gt;</i></a> </dt>
						<dd>
							<a>官方直售</a>
							<a>生活电器</a>
							<a>生活电器</a>
							<a>吹风机</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
							<a>官方直售</a>
							<a>面膜</a>
							<a>护肤套装</a>
							<a>乳液面霜</a>
							<a>精华液</a>
						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="7">
					<dl>
						<dt><a >厨具 <i> &gt;</i></a> </dt>
						<dd>
							<a>厨具</a>
							<a>厨具</a>
							<a>油烟机</a>
							<a>洗碗机</a>
							<a>电磁炉</a>
							<a>微波炉</a>
						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="8">
					<dl>
						<dt><a >汽车 <i> &gt;</i></a> </dt>
						<dd>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
							<a>汽车</a>
						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="9">
					<dl>
						<dt><a >生鲜水果 <i> &gt;</i></a> </dt>
						<dd>
							<a>火龙果</a>
							<a>苹果</a>
							<a>榴莲</a>
							<a>进口水果</a>
							<a>优惠活动</a>
							<a>雪梨</a>
							<a>山竹</a>
							<a>葡萄</a>
							<a>泰国芒果</a>
							<a>柚子</a>
							<a>马蹄</a>
							<a>橘子</a>
							<a>香蕉</a>
							<a>猕猴桃</a>
							<a>椰子</a>
						</dd>
					</dl>

				</div>
				<div class="sub hide" data-id="10">
					<dl>
						<dt><a >当季热卖 <i> &gt;</i></a> </dt>
						<dd>
							<a>定制窗帘</a>
							<a>抱枕</a>
							<a>被子</a>
							<a>两用坐垫</a>
							<a>国际家纺床品</a>
							<a>国际居家布艺</a>
							<a>国际家居饰品</a>
						</dd>
					</dl>
           	   </div>
			</div>
     </div>
   </div>  

      <!--
      
      	新书上架
      -->
      <div id="xin">
         <table class="table " style="width:auto;">
         	<tr>
         		<td><img src="images/xinshu.jpg"></td>
         	</tr>
         	<tr>
         		<td>
         			
           <table class="book" style="width: 800px;">
           	<tr>
           		<td style="text-align: center;">
           			<div>
           				<a href="Product?cmd=getBook&id=1"><img src="images/b1.jpg" ></a><br>
           				<a style="text-decoration: none;">苏东坡传（林语堂精装2018版）</a><br>
           				<font style="font-family: '微软雅黑';color: red;font-size: 15px;">￥39</font>
           			</div>	
           		</td>
           		<td style="text-align: center;">
           			<div>
           				<img src="images/b2.jpg" ><br>
           				<a style="text-decoration: none;">甲骨文丛书·北京的隐秘角落</a><br>
           				<font style="font-family: '微软雅黑';color: red;font-size: 15px;">￥38.8</font>
           			</div>	
           		</td>
           		<td style="text-align: center;">
           			<div>
           				<img src="images/b3.jpg" ><br>
           				<a style="text-decoration: none;">赏词如风——王立群品读经典诗词</a><br>
           				<font style="font-family: '微软雅黑';color: red;font-size: 15px;">￥25.8</font>
           			</div>
           		</td>
           	</tr>
           	<tr>
           		<td style="text-align: center;">
           			<div>
           				<img src="images/b4.jpg" ><br>
           				<a style="text-decoration: none;">汪曾祺散文集：人间世相</a><br>
           				<font style="font-family: '微软雅黑';color: red;font-size: 15px;">￥33.9</font>
           			</div>
           		</td>
           		<td style="text-align: center;">
           			<div>
           				<img src="images/b5.jpg" ><br>
           				<a style="text-decoration: none;">投资中不简单的事</a><br>
           				<font style="font-family: '微软雅黑';color: red;font-size: 15px;">￥58.3</font>
           			</div>
           		</td>
           		<td style="text-align: center;">
           			<div>
           				<img src="images/b6.jpg" ><br>
           				<a style="text-decoration: none;">我站在桥上看风景</a><br>
           				<font style="font-family: '微软雅黑';color: red;font-size: 15px;">￥15</font>
           			</div>
           		</td>
           	</tr>
           </table>
    	</td>
       </tr>
  
      </table>
     </div>
   </div>  
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <!-- 
          图书热卖
      -->
        <div style="float: left;">
        	<table class="table table-hover table-responsive">
        		<tr>
        			<td><img src="images/9828223.png" style="width: 120px;height: 70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        			<font style="font-family:arial;font-size: 25px;color: #D9534F;">图书热卖榜</font></td>
        		</tr>
        		<tr>
        			<td>
        				<img src="images/b7.jpg">
        				<font style="color:lightpink;font-size: 25px;">1.</font><font style="font-family: '微软雅黑';font-size: 15px;"><a href="#">余生很长，何必慌张</a></font><br>
        			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font style="fo acceleratort-family: '微软雅黑';font-size: 15px;color: red;text-align: center;">￥27.3</font>
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<font style="color: lightpink;font-size: 20px;">2.</font><font style="font-family: '微软雅黑';font-size: 15px;"><a href="#">十宗罪6：本书根据真实案例改编而成。</a></font><br>
        			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font style="fo acceleratort-family: '微软雅黑';font-size: 15px;color: red;text-align: center;">￥31.7</font>
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<font style="color:lightpink;font-size: 17px;">3.</font><font style="font-family: '微软雅黑';font-size: 15px;"><a href="#">东野圭吾新作：白金数据</a></font><br>
        			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font style="fo acceleratort-family: '微软雅黑';font-size: 15px;color: red;text-align: center;">￥21<font>
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<font style="color:lightpink;font-size: 15px;">4.</font><font style="font-family: '微软雅黑';font-size: 15px;"><a href="#">牧羊少年奇幻之旅</a></font><br>
        			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font style="fo acceleratort-family: '微软雅黑';font-size: 15px;color: red;text-align: center;">￥31.2<font>
        			</td>
        		</tr>
        		<tr>
        			<td>
        			    <font style="color:lightpink;font-size: 15px;">5.</font><font style="font-family: '微软雅黑';font-size: 15px;"><a href="#">夏日终曲(第90届奥斯卡获奖电影)</a></font><br>
        			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font style="fo acceleratort-family: '微软雅黑';font-size: 15px;color: red;text-align: center;">￥29.9<font>
        			</td>
        		</tr>
        	</table>
        </div>  
   

</body>
</html>