// Queens.java
// Quy Lam
// qlam
// pa5
// This program will find all solutions for the n-Queens problem, for 1≤n≤13.

import java.util.*;

class Queens{
    public static void main(String [] args){

	int sol=0, i=0, n =0, l = args.length ;
	String verbose = "-v", e = "error";
      
	if(l==0){
	    err(e);
	}
	if(l==1){
		try{
		    Integer.parseInt(args[0]);
		    n = Integer.parseInt(args[0]);
		}catch(NumberFormatException e1){
		    err(e);
		}
	}
	if(l==2){
	    if(verbose.equals(args[0])){
		try{
		    Integer.parseInt(args[1]);
		    n = Integer.parseInt(args[1]);
		}catch(NumberFormatException e1){
		    err(e);
		}
	    }
	    else{
		err(e);
	    }
	}
	if(l>=3){
	    err(e);
		}
    
	int [] I = new int[n+1];
	makeArr(I);
	for(i=1;i<=factorial(n);i++){
	    if(isSolution(I)){
		sol++;
		if(verbose.equals(args[0])){
		    printArray(I);
		}
	    }
	    nextPermutation(I);
	}
	System.out.println(n+"-Queens has "+sol+" solutions");
      
    }
    static void makeArr(int [] A){
	for(int i=1; i<A.length;i++){
	    A[i]=i;
	}
    }
   
    static void err(String e){
	System.out.println("Usage: Queens [-v] number");
	System.out.println("Option:  -v   verbose output, print all solutions");
	System.exit(0);
    }
    static void nextPermutation(int [] P){
        int n = P.length, j = n-1;
        int successor = 0, pivot = -1;

        for(int i = n-2; i>=0 && pivot == -1; i--){
            if(P[i]<P[j]){
                pivot = i;
            }
            j--;
        }
        if(pivot == -1){
            reverse(P,0,P.length-1);
        }
        for(int i = n-1;i>=0 && successor ==0;i--){
            if(P[i]>P[pivot]){
                successor = i;
            }
        }
        swap(P, pivot, successor);
        reverse(P, pivot+1, P.length-1);
    }
    
    static void swap( int [] Q, int i, int j){
	int n = Q.length,temp;
	if(i>=0 && j>=0 && i<n &&j<n){
	    temp = Q[i];
	    Q[i] = Q[j];
	    Q[j] = temp;
	    i++;
	    j--;
	}
    }

    static void reverse(int [] S, int a, int b){
	while(a<b){
	    swap(S, a, b);
	    a++;
	    b--;
	}
	return;
    }
    static void printArray(int[] A){
	System.out.print("(");
	for(int i=1; i<A.length; i++){
	    if(i !=A.length-1){
		System.out.print( +A[i]+", ");
	    }else{
		System.out.print( A[i] + ")");
		
		
		System.out.println("");
	    }
	}
    }

    static boolean isSolution(int[] A){
	boolean x = true;
	int Horizontal, Vertical, a;
	for(int i=1; i<=A.length-1; i++){
	    for(int j = i+1; j<=A.length-1; j++){
		Horizontal = Math.abs(A[i] - A[j]);
		Vertical = Math.abs(i - j);
		if(Horizontal == Vertical){
		    x = false;
		}
	    }
	}         
	return x;
    }

    static int factorial(int n){
        if(n<=1)
	    return 1;
        else
            return factorial(n-1)*n;
    }
}
