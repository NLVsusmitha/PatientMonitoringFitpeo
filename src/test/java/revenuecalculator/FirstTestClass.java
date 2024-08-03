package revenuecalculator;

import org.openqa.selenium.*;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstTestClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new EdgeDriver();
		
		// Navigating to this URL
		driver.get("https://www.fitpeo.com/");
		
		driver.manage().window().maximize();
		
		// Clicking Revenue Calculator 
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		Thread.sleep(4000);
		
		// Locate the slider element
        WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']"));
        
        // Create an Actions object
        Actions move = new Actions(driver);
        
        // Calculate the offset (assuming the slider range is 0 to 100)
        int valueToSet = 820; // Desired value
        int sliderWidth = slider.getSize().getWidth();
        int xOffset = (int) ((((121+valueToSet) )/ 200.0) * sliderWidth);
        
        // Move the slider
        move.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();


		Actions moveslider =new Actions(driver);
		
		Thread.sleep(4000);
		moveslider.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		WebElement textBox=	driver.findElement(By.xpath("//input[@id=':r0:']"));
		textBox.sendKeys(Keys.CONTROL + "a");
		textBox.sendKeys(Keys.DELETE);
		textBox.sendKeys("560");
		
		moveslider.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(4000);

	
		moveslider.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(4000);
		
		
		WebElement textBox1=	driver.findElement(By.xpath("//input[@id=':r0:']"));
		textBox1.sendKeys(Keys.CONTROL + "a");
		textBox1.sendKeys(Keys.DELETE);
		textBox1.sendKeys("820");
		
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]")).click();
		//Thread.sleep(4000);
		
		WebElement reimbursement=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]"));
		
		String value=reimbursement.getText();
		
		if( value.equals("$110700"))
		{
			System.out.println("Value Matched");
		}
		else
		{
			System.out.println("Value not Matched");
		}
		System.out.println( "Reimbursement for all Patients Per Month: shows the value is:" + reimbursement.getText());
		
		
		
	}

}
