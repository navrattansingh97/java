package jUnitDemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
Calculator cal;
@Before 
public void setUp() throws Exception {
	cal=new Calculator();
}
	@After
	public void tearDown() throws Exception{
		cal=null;
	
}

	@Test
	public void testAdd() {
		double result=cal.add(10.5, 20.32);
		assertEquals(30.82,result,0);
	}

	@Test
	public void testSub() {
		double result=cal.sub(100.5, 100);
		assertEquals(0.5,result,0);
	}

	@Test
	public void testMultiply() {
		double result=cal.multiply(2.5, 100);
		assertEquals(250,result,0);
	}

	@Test
	public void testDiv() {
		double result=cal.div(100, 10);
		assertEquals(10,result,0.001);
	}

}
