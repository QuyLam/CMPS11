// GCD.java
// Quy Lam
// qlam
// pa3
// This program will ask user to input two positive integers then print out the greatest common advisor of these two numbers.

import java.util.Scanner;
class GCD{
    public static void main(String [] args){
	Scanner sc = new Scanner(System.in);
	int i,x,y,x_0,x_1,y_1,q;
	x = 0;
	y = 0;

	// Check input
        for(i=0;i<2;i++){
	    if(i==1) 
		System.out.print("Enter another positive integer: ");
	    else
		System.out.print("Enter a positive integer: ");
	    while(true){
		//check integer input
		while(!sc.hasNextInt()){
		    sc.next();
		    System.out.print("Please enter a positive integer: ");
		}
		//check positive integer
		if (sc.hasNextInt()) {
		    x_0=sc.nextInt();
		    if (x_0>0){
			if (x==0){
			    x = x_0;
			}
			else
			    y = x_0;
			    
			break;
		    }
		    //input prompt
		    else {
			System.out.print("Please enter a positive integer: ");
		    }}
		else
		    System.out.print("Please enter a positve integer: ");
	    }
	}
	//set x_1 to be the larger integer
	if (y>x) {
	    y_1 = x;
	    x_1 = y;
	}
	else {
	    x_1 = x;
	    y_1 =y;
	}
	//find the greatest common divisor
	while(x_1%y_1>0){
	    q =x_1%y_1; //q : remainder
	    x_1= y_1;
	    y_1= q;
	}
	System.out.println("The GCD of "+x+" and "+y+" is "+y_1);
    }
}
