package jUnitDemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SuiteTest1.class, SuiteTest2.class })
public class JUnitTestSuite {
	//This class Remains empty,it is used only as a holder 
	//for the above annotations

}
