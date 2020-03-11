package jUnitDemo;

public class Calculator {
public double add(double a,double b){
	return a+b;
} 
public double sub(double a,double b){
	return a-b;
}
public double multiply(double a,double b){
	return a*b;
}

public double div(double a,double b){
	if(b==0){
	throw new ArithmeticException();
	}
		return a/b;
	
	
}
}
