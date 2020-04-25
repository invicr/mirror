<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/> "></script>
<script>
 $(function() {
  getDate();
  getTime();
 });
 function getDate() {
        var date = document.getElementById("date"); // 출력할 장소 선택
        var now = new Date();
        var week = new Array('일', '월', '화', '수', '목', '금', '토');
        var today = now.getFullYear() + "년 " + (now.getMonth() + 1) + "월 " + now.getDate() + "일 " + "(" + week[now.getDay()] +")";
        date.innerHTML = today; 
        setTimeout("getDate()", 1000); 
    }
 
    function getTime() {
        var time = document.getElementById("time"); // 출력할 장소 선택
        var now = new Date(); 
        
        var hours = now.getHours();
        var min = now.getMinutes();
        var seconds = now.getSeconds();
        
        if(hours < 10){
			hours = '0' + hours;
        }
        
        if(min < 10){
			min = '0' + min;
        } 
        
        
        if(seconds < 10){
			seconds = '0' + seconds;
        }
          
  		var nowTime = hours + ":" + min + ":" +seconds;          
	        time.innerHTML = nowTime; 
	        setTimeout("getTime()", 1000);  
	    } 
</script>
</head>
 
<body style="background-color:black; color:white">
    <table width="90%" align="center">
        <tr height="50"></tr> 
        <tr> 
            <td width="50%" style="font-size:15pt"><div id="date"></div></td>
            <td width="50%" align="right" style="font-size:15pt" >기상청 (${baseTime}시 기준)</td> 
        </tr>
        <tr>
            <td style="font-size:30pt"><div id="time"></div></td>
            <td align="right" style="font-size:30pt">${iInfo.location} 
            <c:choose>
	           <c:when test="${iInfo.precipitationForm == 0}">
	               <c:choose>
	                   <c:when test="${iInfo.skyCondition == 1}">
	                       <img src='<c:url value='/resources/images/sunny.png'/>'>
	                   </c:when>
	                   <c:when test="${iInfo.skyCondition == 2}">
	                       <img src='<c:url value='/resources/images/sunny_cloud.png'/>'>
	                   </c:when>
	                   <c:when test="${iInfo.skyCondition == 3 || iInfo.skyCondition == 4}">
	                       <img src='<c:url value='/resources/images/cloud.png'/>'> 
	                   </c:when>
	               </c:choose>
	           </c:when>
	           <c:when test="${iInfo.precipitationForm != 0}">
	               <c:choose>
	                   <c:when test="${iInfo.precipitationForm == 1}">
	                       <img src='<c:url value='/resources/images/rain.png'/>'>
	                   </c:when>
	                   <c:when test="${iInfo.precipitationForm == 2}">
	                       <img src='<c:url value='/resources/images/rain.png'/>'>
	                   </c:when>
	                   <c:when test="${iInfo.precipitationForm == 3}">
	                       <img src='<c:url value='/resources/images/snow.png'/>'>
	                   </c:when>
	               </c:choose>
	           </c:when>     
	       </c:choose>		  
           ${iInfo.temperature}º</td>
        </tr> 
        <tr> 
            <td></td>
            <td align="right"> 
                <table>
                    <tr></tr>
                    <c:forEach var="result" items="${info}" varStatus="status">
                    	<tr height="50"> 
	                        <td width="70" style="font-size:15pt">${result.location}</td>  
	                        <td width="70" style="font-size:15pt"> 
							<c:choose>
                                    <c:when test="${result.precipitationForm == 0}">
                                        <c:choose>
                                            <c:when test="${result.skyCondition == 1}">
                                                <img src='<c:url value='/resources/images/sunny.png'/>'>
                                            </c:when>
                                            <c:when test="${result.skyCondition == 2}">
                                                <img src='<c:url value='/resources/images/sunny_cloud.png'/>'>
                                            </c:when>
                                            <c:when test="${result.skyCondition == 3 || result.skyCondition == 4}">
                                                <img src='<c:url value='/resources/images/cloud.png'/>'> 
                                            </c:when>
                                        </c:choose>
                                    </c:when>
                                    <c:when test="${result.precipitationForm != 0}">
                                        <c:choose>
                                            <c:when test="${result.precipitationForm == 1}">
                                                <img src='<c:url value='/resources/images/rain.png'/>'>
                                            </c:when>
                                            <c:when test="${result.precipitationForm == 2}">
                                                <img src='<c:url value='/resources/images/rain.png'/>'>
                                            </c:when>
                                            <c:when test="${result.precipitationForm == 3}">
                                                <img src='<c:url value='/resources/images/snow.png'/>'>
                                            </c:when>
                                        </c:choose>
                                    </c:when>     
                                </c:choose>		                        
	                        </td>
	                        <td width="70" style="font-size:15pt">${result.temperature}º</td>
	                        <%-- <td width="50" style="font-size:15pt">${result.location}</td> --%>    
	                    </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
    <table width="90%" align="center">
    	<tr>
    		<!-- <td align="center" style="font-size:30pt">Designed by ADM기술팀</td> -->
    	</tr>
    </table>
</body>
</html>