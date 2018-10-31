package com.testinfra.util;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestCaseGeneratorUtil {
   private String testCaseId;
   private static final String testCaseList = "1-4,6,7,8,11-15";

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
   public TestCaseGeneratorUtil(String testCaseId) {
      this.testCaseId = testCaseId;;
   }

   //This was the original implementation
   //@Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { "TC1" },
         { "TC2" },
         { "TC3" },
         { "TC4" },
         { "TC5" }
      });
   }

   // This test will run 4 times since we have 5 parameters defined
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("Parameterized Number is : " + this.testCaseId);
      assertTrue(true);
   }

   /**
    * This method takes a string input and returns collection of test cases ids
    * String format
    * 1. comma separated for individual test cases
    * Example: 1,2,3,4,5 returns TC1,TC2,TC3,TC4,TC5
    * 2. hyphen separated for range of test cases
    * Example: 1-4 returns TC1,TC2,TC3,TC4
    * 3. mix mode containing commma and hyphen
    * Example: 1-3,5,6,9-11 returns TC1,TC2,TC3,TC5,TC6,TC9,TC10,TC11
    * @param input
    * @return
    */
   private static Collection getTestCasesForExecution(String input){
	   String testCasePrefix = "TC";
	   List<String> testCasesForExecution = new ArrayList<String>();
	   String []tcSplitByComma = input.split(",");
	   for(String testGroup: tcSplitByComma){
		   String []tcSplitByDash = testGroup.split("-");
		   if(tcSplitByDash.length==1){
			   testCasesForExecution.add(testCasePrefix+tcSplitByDash[0]);
		   }else if(tcSplitByDash.length==2){
			   int tcStartsFrom = Integer.parseInt(tcSplitByDash[0]);
			   int tcEndsAt = Integer.parseInt(tcSplitByDash[1]);
			   for(int i=tcStartsFrom;i<=tcEndsAt;i++){
				   testCasesForExecution.add(testCasePrefix+i);
			   }
		   }else{
			   System.out.println("Invalid input");
		   }
	   }
	   return testCasesForExecution;
   }

   @Parameterized.Parameters
   public static Collection primeNumbers1S() {
	   return getTestCasesForExecution(testCaseList);
   }
}
