// Complex.java
// Quy Lam
// qlam
// pa6
// This program will do some common operations with complex numbers.
//import java.util.*;
class Complex{

    //--------------------------------------------------------------------------
    // Private Data Fields 
    //--------------------------------------------------------------------------
    private double re;
    private double im;
   
    //--------------------------------------------------------------------------
    // Public Constant Fields 
    //--------------------------------------------------------------------------
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);

    //--------------------------------------------------------------------------
    // Constructors 
    //--------------------------------------------------------------------------
    Complex(double a, double b){
	this.re = a;
	this.im = b;
    }

    Complex(double a){
	this.re = a;
	this.im = 0;
    }

    Complex(String s){
	double [] C = parseComplex(s);
	this.re = C[0];
	this.im = C[1];
    }

    //---------------------------------------------------------------------------
    // Public methods 
    //---------------------------------------------------------------------------

    // Complex arithmetic -------------------------------------------------------

    // copy()
    // Return a new Complex equal to this Complex
    Complex copy(){
	return new Complex(this.re, this.im);
    }
   
    // add()
    // Return a new Complex representing the sum this plus z.
    Complex add(Complex z){
	return new Complex(this.re + z.re, this.im + z.im);
    }
   
    // negate()
    // Return a new Complex representing the negative of this.
    Complex negate(){
	return new Complex(-re,-im);
    }

    // sub()
    // Return a new Complex representing the difference this minus z.
    Complex sub(Complex z){
	return new Complex(this.re - z.re, this.im - z.im);
    }

    // mult()
    // Return a new Complex representing the product this times z.
    Complex mult(Complex z){
	return new Complex((this.re * z.re)-(this.im * z.im),
			   (this.im * z.re)+(this.re * z.im));
    }

    // recip()
    // Return a new Complex representing the reciprocal of this.
    // Throw an ArithmeticException with appropriate message if 
    // this.equals(Complex.ZERO).
    Complex recip(){
	if(this.equals(Complex.ZERO)){
	    throw new ArithmeticException(
					  "reciprocal of 0");
	}
	return new Complex((this.re/(Math.pow(this.re,2) + Math.pow(this.im,2))),
			   (-this.im/(Math.pow(this.re,2) + Math.pow(this.im,2))));
	
    }

    // div()
    // Return a new Complex representing the quotient of this by z.
    // Throw an ArithmeticException with appropriate message if 
    // z.equals(Complex.ZERO).
    Complex div(Complex z){
	if(z.equals(Complex.ZERO)){
	    throw new ArithmeticException(
					  "division by zero");
	}

	return new Complex((this.re * z.re + this.im * z.im)/
			   (Math.pow(z.re,2) + Math.pow(z.im,2)),
			   (this.im * z.re - this.re * z.im)/
			   (Math.pow(z.re,2) + Math.pow(z.im,2)));
	
    }

    // conj()
    // Return a new Complex representing the conjugate of this Complex.
    Complex conj(){
	return new Complex(re, -im);
    }
   
    // Re()
    // Return the real part of this.
    double Re(){
	return re;
    }

    // Im()
    // Return the imaginary part of this.
    double Im(){
	return im;
    }

    // abs()
    // Return the modulus of this Complex
    double abs(){
    	return Math.sqrt(Math.pow(re,2) + Math.pow(im,2));
    }

    // arg()
    // Return the argument of this Complex
    double arg(){
	return Math.atan2(im, re);
    }

    // Other functions ---------------------------------------------------------
   
    // toString()
    // Return a String representation of this Complex.
    public String toString(){
	if(re == 0){return(+im+ "i");}
	else if(im == 0){return(""+re);}
	else if(im > 0){return(+re+ "+" +im+ "i");}
	else{return(+re+ "" +im+ "i");}
    }

    // equals()
    // Return true iff this and obj have the same real and imaginary parts.
    public boolean equals(Object obj){
	boolean eq = false;
	Complex z;
	z = (Complex)obj;
	eq = (this.re == z.re && this.im == z.im);
	return eq;
    }

    // valueOf()
    // Return a new Complex with real part a and imaginary part b.
    static Complex valueOf(double a, double b){
	return new Complex(a,b);
    }

    // valueOf()
    // Return a new Complex with real part a and imaginary part 0.
    static Complex valueOf(double a){
	return new Complex(a,0);
    }

    // valueOf()
    // Return a new Complex constructed from s.
    static Complex valueOf(String s){
	return new Complex(s);
    }

    static double[] parseComplex(String str){
	double[] part = new double[2];
	String s = str.trim();
	String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
	String SGN = "[+-]?";
	String OP =  "\\s*[+-]\\s*";
	String I =   "i";
	String OR =  "|";
	String REAL = SGN+NUM;
	String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
	  REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
	  throw new NumberFormatException(
					  "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
	  part[0] = Double.parseDouble(s);
	  part[1] = 0;
      }else if( s.matches(SGN+I) ){
	  part[0] = 0;
	  part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
	  part[0] = 0;
	  part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
	  part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
	  part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{  
	  part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
	  part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      return part;
    }

}
