package anonymous;

public class any {

	public static void main(String[] args) {
		
		a oba= new a(){};
		oba.showa();
		
	
	}

}


 class a{
	 void showa(){
		 System.out.println("Inside class A showa method");
	 }
	 
 }

 class b extends a{
	 void showa(){
		 System.out.println("Inside class B showa method");
		 }
	 
	 void showb(){
		 System.out.println("Inside class B showb method");
	 }
 }