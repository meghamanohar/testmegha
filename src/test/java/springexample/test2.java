package springexample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test2 {
	
    @Test
    public void sum()
    {
    	System.out.println("SUM");
    	int a = 5;
    	int b = 10;
    	Assert.assertEquals(15, a+b);
    			
    }
    @Test
    public void sub()
    {
    	System.out.println("SUB");
    	int a = 5;
    	int b = 10;
    	Assert.assertEquals(50, b-a);
    			
    }

}
