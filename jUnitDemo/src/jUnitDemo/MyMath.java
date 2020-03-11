package jUnitDemo;

public class MyMath {
public MyMath(){
	
}
int sum(int[] numbers){
	int sum=0;
	for (int i:numbers){
		sum += i;
	}
	return sum;
}
}
