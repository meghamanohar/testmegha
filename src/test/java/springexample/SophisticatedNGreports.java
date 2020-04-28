package springexample;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SophisticatedNGreports implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started->" + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Pass->" + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed->" + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped->" + result.getName());

		
	}

	public void onStart(ITestContext context) {
		System.out.println("Start Of Execution(TEST)->" + context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("END Of Execution(TEST)->" + context.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
 
}
