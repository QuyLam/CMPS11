// Roots.java
// Quy Lam
// qlam
// pa4
// This program will the roots of polynomial using bisection method.
import java.util.*;
import java.util.Scanner;

public class Roots{

    public static void main( String[] args ) {
	Scanner sc = new Scanner(System.in);
	int degree;
	double leftend, rightend, tolerance, threshold, resolution;
	tolerance = 0.0000001;
	threshold = 0.001;
	resolution =0.01;

	System.out.print("Enter the degree: ");
	degree = sc.nextInt();
      
	double[] polynomial = new double[degree+1];
      
	System.out.print("Enter the "+(degree+1)+" coefficients: ");
	for(int i=0; i<(degree+1); i++) {
	    polynomial[i] = sc.nextDouble();
	}

	System.out.print("Enter the left and right endpoints: ");
	leftend = sc.nextDouble();
	rightend = sc.nextDouble();

	System.out.println(" ");

	double[] polynomialnew;
	diff(polynomial);
	polynomialnew = diff(polynomial);

	partition(polynomial, leftend, rightend, resolution, tolerance);

    }

    static double poly(double[] C, double x) {
	double sum;
	sum = 0;

	for(int i=0; i<C.length; i++) {
	    sum += C[i]*Math.pow(x,i);
	} return sum;
    }

    static double[] diff(double[] C) {
	double[] p = new double[C.length-1];

	for(int i=0; i<(p.length); i++) {
	    p[i] = C[i+1]*(i+1);
	}
	return p;
    }

    public static boolean oddRoot(double[] C, double a, double b) {
	if(poly(C,a)>0 && poly(C,b)<0) {
	    return true;
	}
	if(poly(C,a)<0 && poly(C,b)>0) {
	    return true;
	}
	if(Math.abs(poly(C,a)) == 0) {
	    return true;
	}
	else {
	    return false;
	}
    }

    static double findRoot(double[] C, double a, double b, double tolerance) {
	double m = (a + b)/2.0;
	double threshold = .001;

	if(Math.abs(poly(C,a)) < threshold) {
	    return a;
	}
	if(Math.abs(poly(C,a)) < threshold) {
	    return b;
	}
	while( b - a > tolerance) {
	    m = (a + b) / 2.0;

	    if(oddRoot(C, a, m)) {
		b = m;
	    }
	    if(oddRoot(C, m, b)) {
		a = m;
	    }
	} 
	return m;
    }

    public static void partition(double[] C, double a, double b, double resolution, double tolerance) {
	double leftend = a;
	double rightend = a + resolution;
	boolean anyRoots = false;
	double threshold=0.001;
	double x;

	double[] drev;
	diff(C);
	drev = diff(C);

	while(rightend < b) {
	    if(oddRoot(C, leftend, rightend)) {
		double y = findRoot(C, leftend, rightend, tolerance);
                System.out.printf(" Root found at %.5f%n", y);
                anyRoots = true;
                leftend += resolution;
                rightend += resolution;
	    }
	    else if (oddRoot(drev, leftend, rightend)) {
		x = findRoot(drev, leftend, rightend, tolerance);        
		if(Math.abs(poly(C, x)) < threshold) {
		    System.out.print("Root found at ");
		    System.out.printf("%.5f%n", x);
		    anyRoots = true;
		    leftend += resolution;
		    rightend += resolution;
		    continue;
		}
		leftend += resolution;
		rightend += resolution;
		continue; 
	    }
	    leftend += resolution;
	    rightend += resolution;     
	}
	if(oddRoot(C, leftend, b)) {
	    double y = findRoot(C,leftend, b, tolerance);
	    System.out.printf("Root found at %.5%n", y);
	    anyRoots = true;
	}
	else if(oddRoot(drev, leftend, b)) {
	    x = findRoot(drev, leftend, rightend, tolerance);  
	    if (Math.abs(poly(C,x)) < threshold ) {
		System.out.printf("Root found at %.5f%n",x);
		anyRoots = true;
	    }
	}
	if (Math.abs(poly(C,b)) ==0) {
	    System.out.printf("Root found at %.5f%n", b);
	    anyRoots = true;
	}
	if(!anyRoots) {
	    System.out.println("No roots were found in the specified range. ");
	}
    }
}   
