package Servlet;

import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Service.Referee;

@WebServlet(urlPatterns = "/rps")
public class RpsServlet extends HttpServlet{

	
	String choice="";
	public int[] pointsArray= {0,0};
	int compChoice=0;
	String compC="";
	String result="";
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)  throws ServletException,IOException{
		clear();
		request=set(request,pointsArray[0],pointsArray[1],choice,compC,result);
		Display(request, response,"game");
}
	
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)  throws ServletException,IOException{
		
		
		
		choice ="";
		String rock=request.getParameter("1");
		String paper=request.getParameter("2");
		String scissor=request.getParameter("3");
		
		//Which button have been clicked
		choice =(rock!=null)?"rock":((paper!=null)?"paper":(scissor!=null)?"scissor":"");
		
		//Random Computer Choice
		compChoice=(int) (Math.floor(Math.random()*3)+1);
		
		//What will shown on view
		choice =(rock!=null)?"Rock":((paper!=null)?"Paper":(scissor!=null)?"Scissors":"");
		compC=(compChoice==1)?"Rock":((compChoice==2)?"Paper":(compChoice==3)?"Scissors":"");
		
		
		Referee referee=new Referee();
		pointsArray=referee.result(choice,compChoice, pointsArray);
		result=referee.control(result, pointsArray);
		
		request=set(request,pointsArray[0],pointsArray[1],choice,compC,result);
			
		if(result=="") {
		Display(request, response,"game");
		}
		else if(result!=""){
			Display(request, response,"result");
		}
		
}
	
	

	
	protected void Display(HttpServletRequest request,HttpServletResponse response,String jsp)  throws ServletException,IOException{
		request.getRequestDispatcher 
		("/WEB-INF/jsp/"+jsp+".jsp").
		forward(request, response);
	
	}
	
	
	
	protected HttpServletRequest set(HttpServletRequest Prequest,int UserScore,int CompScore,String Choice,String compChoice,String res)  throws ServletException,IOException{
		Prequest.setAttribute("UserScore",UserScore);
		Prequest.setAttribute("CompScore",CompScore);
		Prequest.setAttribute("choice", Choice);		
		Prequest.setAttribute("CompChoice", compChoice);
		Prequest.setAttribute("result",res);
		return Prequest; 
		
	}
	
	protected void clear(){
		choice="User' Choice";
		compChoice=0;
		compC="Computer' Choice";
		pointsArray[0]=0;
		pointsArray[1]=0;
		result="";
	}
	
	
	
	//AutoRefresh
	//response.setHeader("Refresh", "0; URL=http://localhost:8080/rps");
	
	
	
	
	
}






	
	
	
//	
//	@RequestMapping(value="/")
//	@ResponseBody
//	public void Hello0( ) {
//		
//	}
	