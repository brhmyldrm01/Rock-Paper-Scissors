<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Rock Paper Scissors Game</title>
       <link href="<c:url value="/resources/styleGame.css" />" rel="stylesheet">
    </head>
    <body>
            <header>
        <h1>ROCK PAPER SCISSORS</h1>
            </header>
                
            <div class="score_board">
                <div id="user-label" title="User Score" class="badge"> USER </div>
                <div id="computer-label" title="Computer Score" class="badge"> COMP </div>
                <span id="user_score">${UserScore}</span>:<span id="computer_score"> ${CompScore} </span>
              
            </div>
            <div class="result">
              <img alt="usericon" id="iconUser" style="width: 100px; height: 100px; margin-left:500px; " src="resources/monk.png">  ${choice} <br> <br>
     		 <img alt="compicon" style="width: 100px; height: 100px; margin-left:500px;" src="resources/binary-code.png"> ${CompChoice} <br> <br>
             
            </div>
         
            <div class="choices">
            
            <form action="rps" method="POST"  >
                <button  name="1" class="choice" title="Rock" id="r" value=1>
                <img alt="Rock" src="<c:url value="resources/icons8-hand-rock-48.png" />"></button>
                 
         
                <button name="2" class= "choice" title="Paper" id="p" value=2>
                <img alt="Paper" src="<c:url value="resources/icons8-hand-cursor-48.png" />"></button>
                
                   
                  
                <button name="3"  class="choice" title="Scissor" id="s" value=3>
                <img alt="Cursor" src="<c:url value="resources/icons8-hand-scissors-48.png" />"></button>
         
            </div>
            </form>
            
            <form action="rps" method="GET">
            <input name="else" type="submit" id="restart" value="RESTART">
           </form>
             
            
           
             
    </body>
</html>