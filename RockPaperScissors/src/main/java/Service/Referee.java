package Service;

public class Referee {
	
	
	public int[] result(String userChoice,int compChoice,int[] points) {
	int user =(userChoice=="Rock")?1:((userChoice=="Paper")?2:(userChoice=="Scissors")?3:000);
	int computer=compChoice;
	
	if(user==computer) {
		return points;
	}
	else if((user==1&&computer==3)||(user==2&&computer==1)||(user==3&&computer==2)){
		points[0]++;
	}
	else if((user==3&&computer==1)||(user==1&&computer==2)||(user==2&&computer==3)) {
		points[1]++;
	}
		return points ;
	}
	
	public String control(String result,int[] arr) {
		if(arr[0]==3) {
			result="User Won";
		}
		else if(arr[1]==3) {
			result="Computer Won";
		}
		else {
			result="";
		}
		
		return result;
	}
	
	
	
}
