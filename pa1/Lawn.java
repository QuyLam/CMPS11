// Lawn.java
// Quy Lam
// qlam
// pa1
// program will take the inputs from keyboard,then calculate and print out: the lawn area and the mowing time.                                                                   

import java.util.Scanner;
class Lawn{
   public static void main( String [] args){
       double length, width, lotarea, length1, width1, housearea, area;
       double rate;
       int h, m, s;
       String str;
     
              
       Scanner sc = new Scanner(System.in);

       System.out.print("Enter the length and width of the lot, in feet: ");
       length = sc.nextDouble();
       width = sc.nextDouble();
       lotarea = length*width;
       System.out.print("Enter the length and width of the house, in feet: ");
       length1 = sc.nextDouble();
       width1 = sc.nextDouble();
       housearea = length1*width1;
       area = lotarea - housearea;
       System.out.println("The lawn area is "+ area+" square feet.");

       System.out.print("Enter the mowing rate, in square feet per second: ");
       rate = sc.nextDouble();
       double seconds = area/rate;
       s = (int) Math.round(seconds); // s = 3726
       m = s/60;
       str = ( m==1 ? "minute" : "minutes" );
       s = s%60;
       h = m/60;
       str = ( h==1 ? "hour" : "hours" );
       m = m%60;
       str = ( s==1 ? "second" : "seconds" );
       System.out.println("The mowing time is " +h+ (h==1? " hour " : " hours ") +m+(m==1? " minute ": " minutes ") +s+ (s==1? " second." : " seconds."));
 
   }
}
            




