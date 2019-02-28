package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.XL;


public class Demo extends BaseTest{
	
	@Test
	
	public void testDemo()
	{   String v=XL.getData(XL_PATH, "Sheet1", 0, 0);
		Reporter.log(v, true);
		int count = XL.getRowCount(XL_PATH, "Sheet1");
		System.out.println(count);
		Assert.fail();
	}

}
