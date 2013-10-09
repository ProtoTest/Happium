package com.prototest.MakrTests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 10/8/13
 * Time: 6:12 PM
 * Test runner
 */
public class Master_TestRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(Makr_HomeScreen_Test.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
    }
}
