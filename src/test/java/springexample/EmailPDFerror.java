package springexample;

import java.util.Properties;
// This one works!!//
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lowagie.text.Section;
@Listeners(JyperionListener.class)

public class EmailPDFerror extends ScreenshotError {
	public static WebDriver driver;
	
	//Testcase failed so screen shot generate

    @Test

    public void testPDFReportOne(){

  
        driver = ScreenshotError.getDriver();

        driver.get("http://google.com");

        Assert.assertTrue(false);

    }
    //Testcase failed so screen shot generate

    @Test

    public void testPDFReporTwo(){
    	

        driver = ScreenshotError.getDriver();

        driver.get("http:/facebook.com");

        Assert.assertTrue(false);

    }
  //Test test case will be pass, so no screen shot on it

    @Test

    public void testPDFReportThree(){
    

        driver = ScreenshotError.getDriver();

        driver.get("http://amazon.com");

        Assert.assertTrue(true);

    }
    
  //After complete execution send pdf report by email

    @AfterSuite

    public void tearDown(){

        sendPDFReportByGMail("megha.manohar@gmail.com", "12022Titus", "megha@rishikumar.com", "PDF Report", "");

        }

 
    /**

     * Send email using java

     * @param from

     * @param pass

     * @param to

     * @param subject

     * @param body

     */

    private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

    	Properties props = System.getProperties();

    	String host = "smtp.gmail.com";
    	System.out.println("Inside the method to send email");

    	props.put("mail.smtp.starttls.enable", "true");

    	props.put("mail.smtp.host", host);

    	props.put("mail.smtp.user", from);

    	props.put("mail.smtp.password", pass);

    	props.put("mail.smtp.port", "587");

    	props.put("mail.smtp.auth", "true");
    	
    	System.out.println("inside #2");

    	Session session = Session.getDefaultInstance(props);

    	MimeMessage message = new MimeMessage(session);

    	try {

    			//Set from address

    			message.setFrom(new InternetAddress(from));

    			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

    			//Set subject

    			message.setSubject(subject);

    			message.setText(body);

    			BodyPart objMessageBodyPart = new MimeBodyPart();

    			objMessageBodyPart.setText("Please Find The Attached Report File!");

    			Multipart multipart = new MimeMultipart();

    			multipart.addBodyPart(objMessageBodyPart);

    			objMessageBodyPart = new MimeBodyPart();

    			//Set path to the pdf report file

    			String filename = System.getProperty("user.dir")+"//Default test.pdf";

    			//Create data source to attach the file in mail

    			DataSource source = new FileDataSource(filename);

    			objMessageBodyPart.setDataHandler(new DataHandler(source));

    			objMessageBodyPart.setFileName(filename);

    			multipart.addBodyPart(objMessageBodyPart);

    			message.setContent(multipart);
    			System.out.println("Here towards the end 1");

    			Transport transport = session.getTransport("smtp");

    			transport.connect(host, from, pass);
    			System.out.println(transport.isConnected());
    			System.out.println("Here towards the end 2");

    			transport.sendMessage(message, message.getAllRecipients());
    			
    			
    			System.out.println(message);
    			System.out.println("Here towards the end 3");

    			transport.close();

    	}
catch (AddressException ae) {

			ae.printStackTrace();

		}

catch (MessagingException me) {

			me.printStackTrace();

}
driver.quit();
}
       
}
