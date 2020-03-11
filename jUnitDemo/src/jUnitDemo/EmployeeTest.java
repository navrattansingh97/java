package jUnitDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class EmployeeTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetEmpNameWithHighestSalary() {
		String expectedName="Navi";
		assertEquals(expectedName,Employee.getEmpNameWithHighestSalary());
	}

	@Test
	public void testGetHeighestPaidEmployee() {
		Employee expectedEmpObj = new Employee (1,"Na",15000);
		assertEquals(expectedEmpObj,Employee.getHeighestPaidEmployee());
	}

}
