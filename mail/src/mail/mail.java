package mail;

public class mail {

	
	boolean checkerStart(char a[]){ //Starting character must not be a number
		
			if((int)a[0]>47&&(int)a[0]<58){
				System.out.println("Starting char is a number");
				return false;
		} 
			return true;
	}
	
	boolean checkerChar(char a[]){   //No special characters other than . _ and @ are allowed
		for(int i=0;i<a.length;i++){
		
			if(( (int)a[i]==64)||((int)a[i]==46)||(((int)a[i]>47)&&((int)a[i]<58))||(((int)a[i]>64)&&((int)a[i]<91))||(((int)a[i]<123)&&((int)a[i]>96))){
			}
			else{
				System.out.println("Invalid special char ");
				return false;
			}
		}
			return true;
		
	}
	
	boolean checkDot(char a[]){          //Maximum no of dots can be 2
		int t=0,temp=0;
		for(int i=0;i<a.length;i++){
			if(a[i]=='.'){
				temp=i;
				break;
			}
		}
			for(int j=temp+1;j<a.length;j++){
				if(a[j]=='.'){
					temp=j;
					break;
				}
			}
				
				for(int k=temp+1;k<a.length;k++){
					if(a[k]=='.'){
						System.out.println("More than 2 dots before @ symbol is not allowed");
						return false;
					}
						
					}
		
	return true;
		
	}
	
	
	boolean checkAt(char a[]){          //only one @ is allowed
		int t=0;
		for(int i=0;i<a.length;i++){
			if(a[i]=='@') { t=i; break;}
	}
		for(int j=t+1;j<a.length;j++){
			if(a[j]=='@'){
				System.out.println("More than one @");
				return false;
				
			}
		}
	 return true;
	}
		
	boolean checkDotAfter(char a[]){  //Only one dot is allowed after @ symbol
		int i,dot=0,temp=0;
		for(i=0;i<a.length;i++){
			if(a[i]=='@'){ dot=i; break;
			}
			
		}
		for(int j=dot;j<a.length;j++){
					if(a[j]=='.'){
						dot=j; break;
					}
				}
				for(int k=dot+1;k<a.length;k++){
					if(a[k]=='.'){
						System.out.println("More than one dot after @"); 
						return false;
					}
				}
				return true;
			}
			
	public static void main(String a[]){
		mail ob=new mail();
		String mail="shivam1aggarwal@gmail.com";
		char arr[]=mail.toCharArray();
		if((ob.checkerStart(arr))&&(ob.checkerChar(arr))&&(ob.checkDot(arr))&&(ob.checkAt(arr))&&(ob.checkDotAfter(arr))){
			System.out.println("Valid Mail id");
		}
		else{
			System.out.println("Invalid mail id");
		}
			
	}
	
	
	
	
}
