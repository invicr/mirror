<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="<c:url value="/resources/js/calendar/fullcalendar.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/> "></script>
<script src="<c:url value="/resources/js/calendar/moment.min.js"/> "></script>
<script src="<c:url value="/resources/js/calendar/fullcalendar.min.js"/> "></script>
<script src="<c:url value="/resources/js/calendar/lang-all.js"/> "></script>
<script>
 $(function() {
	getDate();
	getTime();
	
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,basicWeek,basicDay'
		},
		lang: 'ko',
		height: 460
	});
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
    <table width="100%" align="center">
        <tr height="50"></tr> 
        <tr> 
            <td width="50%" style="font-size:15pt"><div id="date"></div></td>
        </tr>
        <tr>
            <td style="font-size:30pt"><div id="time"></div></td>
            <td style="font-size:30pt" align="center">My Calendar</td>
        </tr> 
        <tr> 
        	<td></td> 
        	<td height="auto" width="50%" align="right"><div id="calendar"></div></td>
        </tr>
    </table>
    <table width="90%" align="center">
    	<tr>
    		<td align="center" style="font-size:20pt">Designed by ADM기술팀</td>
    	</tr>
    </table>
</body>
</html>