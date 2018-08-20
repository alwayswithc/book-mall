<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>购物车</title>
        <link href="css/cart.css" rel="stylesheet">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <script src="bootstrap/js/jquery-3.1.0.min.js"></script>
	    <script src="bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript">
		function changeNum(id,num,totalCount){
			num = parseInt(num);
			totalCount =parseInt(totalCount);
			if(num<1){
				if(confirm("是否确认要删除此商品？")){
					num = 0;
				}else{
					num=1;
				}
			}
			
			if(num>totalCount){
				alert("购买数量不能大于库存数量！");
				num=totalCount;
			}
			location.href="${pageContext.request.contextPath}/product?cmd=changeNum&id="+id+"&num="+num;
		}
	    </script>
</head>
<body>
   <jsp:include page="head.jsp"></jsp:include>
		<div id="tu">
			<img src="images/购物车.PNG" style="margin-left: 60px;">
		</div>
		<div id="xian"></div>
		<br>
		<br>
	     <div>
		<table cellpadding="1" style="width: 80%; height: auto;border:1px #8B0000 solid;text-align:center;margin-left:150px;">
			<tr>
				<td width="10%">&nbsp;序号</td>
				<td width="30%">&nbsp;商品名称</td>
				<td width="10%">价格</td>
				<td width="20%">&nbsp;数量</td>
				<td width="10%">库存</td>
				<td width="10%">小计</td>
				<td width="10%">取消</td>
			</tr>
		</table>
		<!-- 循环输出商品信息 -->
		  <c:set var="total" value="0"/>
		 <c:forEach items="${cart}" var="entry" varStatus="vs">
		 <table width="80%" border="0" cellspacing="0" style="margin-left:150px;text-align:center">
		   <tr>
		       <td width="10%">${vs.count}</td>
		       <td width="30%">${entry.key.name}</td>
		       <td width="10%">${entry.key.price }</td>
		       <td width="20%">
		           <!-- 减少商品数量 -->
		           、               <input type="button" value='-' style="width:20px" onclick="changeNum('${entry.key.id}','${entry.value-1 }','${entry.key.pnum }')">
		           <!-- 商品数量显示 -->
		           <input name="text" type="text" value="${entry.value}" style="width:40px;text-align:center">
		           <!-- 添加商品数量 -->
		           <input type="button" value='+' style="width:20px" onclick="changeNum('${entry.key.id}','${entry.value+1 }','${entry.key.pnum }')">        
		       </td>
		       <td width="10%">${entry.key.pnum}</td>
		       <td width="10%">${entry.key.price*entry.value}</td>
		       <td width="10%">
		          <!-- 删除商品 -->
		          、            <a href="ChangeNumServlet?id=${entry.key.id}&num=0" style="color: #FF0000; font-weight: bold">X</a>
               </td>
		    </tr>
		 </table>
		 <c:set value="${total+ entry.key.price*entry.value}" var="total"/>
		 </c:forEach>
		 <br>
		<!-- 合计信息 -->
		<table style="margin-left:1000px">
		    <tr>
	            <td><font style="color: #FF6600; font-weight: bold">合计：&nbsp;&nbsp;${total}元</font>
	            </td>
	        </tr>
		</table>
		<br>
		<br>
		<br>
		<div style="padding-left:690px;">
           <a href="index.jsp"><button class="btn btn-info">继续购物</button></a>
           <a href="order.jsp"><button class="btn btn-default">立即买单</button></a>
           </div>	
</body>
</html>