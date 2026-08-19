package DevendraTest.TestComponents_20;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_22_183 implements IRetryAnalyzer {         //IRetryAnalyzer is used to rerun the failed tcs  
	//183
	int count=0;
	int maxTry=1;     //it can be 1-2-3, how many times we want to rerun/retry

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count<maxTry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
