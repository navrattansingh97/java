package jUnitDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {
MyMath myMath=new MyMath();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMyMath() {
		System.out.println("Test1");
		assertEquals(6, myMath.sum(new int[] {1,2,3}));
	}

	@Test
	public void testSum() {
		System.out.println("Test 2");
		assertEquals(3,myMath.sum(new int[]{3}));
	}

}
