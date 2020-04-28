package springexample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = SophisticatedNGreportsTest.class)

public class TestSophisticatedNGreport {
  @Test(priority=0,description="testReporterOne")
  public void testRealReportOne(){

      Assert.assertTrue(true);
  }    
  @Test(priority=1,description="testReporterTwo")
  public void testRealReportTwo(){

          Assert.assertTrue(false);

      }
 

}
