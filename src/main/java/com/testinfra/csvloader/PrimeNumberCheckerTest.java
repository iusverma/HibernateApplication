package com.testinfra.csvloader;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
   private String testCaseId;

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
   public PrimeNumberCheckerTest(String testCaseId) {
      this.testCaseId = testCaseId;;
   }

   @Parameterized.Parameters
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
      //primeNumberChecker.validate(inputNumber));
   }
}
