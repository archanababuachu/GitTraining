package com.test.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Xpath {
	
	WebDriver driver;
	WebElement submit_btn, refresh_btn;
	
	@Test (priority = 0)
	public void validateURLandTitle() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\ArchanaB\\chromedriver_win32_101\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "http://demo.automationtesting.in/Register.html" ,"Wrong URL Launched");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Register", "Wrong Title Displayed");
	}
	
	@ Test (priority = 1)
	public void validateRegisterLabels() {
		//heading1
		WebElement head1 = driver.findElement(By.xpath("//h1[contains(.,'Auto')]"));
		String head1text = head1.getText();
		Assert.assertEquals(head1text, "Automation Demo Site","Wrong Heading one");
				
		//heading2
		WebElement head2 = driver.findElement(By.xpath("//h2[text()='Register']"));
		String head2text = head2.getText();
		Assert.assertEquals(head2text, "Register");
		
		//labels
		Boolean name_label = driver.findElement(By.xpath("//label[contains(.,'Full')]")).isDisplayed();
		Assert.assertTrue(name_label,"Name label is not present in the page");
		Boolean address_label = driver.findElement(By.xpath("//label[contains(.,'Addre')]")).isDisplayed();
		Assert.assertTrue(address_label,"Address label is not present in the page");
		Boolean email_label = driver.findElement(By.xpath("//label[text()='Email address*']")).isDisplayed();
		Assert.assertTrue(email_label,"Email label is not present in the page");
		Boolean phone_label = driver.findElement(By.xpath("//label[contains(.,'Phone')]")).isDisplayed();
		Assert.assertTrue(phone_label,"Phone label is not present in the page");
		Boolean gender_label = driver.findElement(By.xpath("//label[contains(.,'Gend')]")).isDisplayed();
		Assert.assertTrue(gender_label,"Gender label is not present in the page");
		Boolean hobby_label = driver.findElement(By.xpath("//label[contains(.,'Hobb')]")).isDisplayed();
		Assert.assertTrue(hobby_label,"Hobby label is not present in the page");
		Boolean lang_label = driver.findElement(By.xpath("//label[contains(.,'Langu')]")).isDisplayed();
		Assert.assertTrue(lang_label,"Language label is not present in the page");
		Boolean skills_label = driver.findElement(By.xpath("//label[contains(.,'Skil')]")).isDisplayed();
		Assert.assertTrue(skills_label,"Skills label is not present in the page");
		Boolean country_label = driver.findElement(By.xpath("//label[contains(.,'Select')]")).isDisplayed();
		Assert.assertTrue(country_label,"Country label is not present in the page");
		Boolean dob_label = driver.findElement(By.xpath("//label[contains(.,'Date')]")).isDisplayed();
		Assert.assertTrue(dob_label,"DOB label is not present in the page");
		Boolean pwd_label = driver.findElement(By.xpath("//label[text()='Password']")).isDisplayed();
		Assert.assertTrue(pwd_label,"Password label is not present in the page");
		Boolean confirm_pwd_label = driver.findElement(By.xpath("//label[text()='Confirm Password']")).isDisplayed();
		Assert.assertTrue(confirm_pwd_label,"Confirm Password label is not present in the page");
		Boolean photo_label = driver.findElement(By.xpath("//label[text()=' Photo']")).isDisplayed();
		Assert.assertTrue(photo_label,"Photo label is not present in the page");
		
		submit_btn = driver.findElement(By.xpath("//button[@id='submitbtn']"));
		Boolean sub_btn = submit_btn.isEnabled();
		Assert.assertTrue(sub_btn, "Submit button is not enabled");
		refresh_btn = driver.findElement(By.xpath("//button[@id='Button1']"));
		Boolean ref_btn = refresh_btn.isEnabled();
		Assert.assertTrue(ref_btn, "Refresh button is not enabled");
				
	}
	
	@Test (priority = 2)
	public void checkRefreshButton() throws InterruptedException {
		fillRegisterForm();
		refresh_btn.click();
		Thread.sleep(2000);
	}
	
	@Test (priority = 3)
	public void submitRegister() throws InterruptedException {
		submit_btn = driver.findElement(By.xpath("//button[@id='submitbtn']"));
		fillRegisterForm();
		submit_btn.click();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public void fillRegisterForm() throws InterruptedException {
		//Filling the form
		WebElement first_name = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		first_name.sendKeys("Anupama");
		
		WebElement last_name = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Last Name']"));
		last_name.sendKeys("Midhun");
		
		WebElement address = driver.findElement(By.xpath("//textarea"));
		address.sendKeys("Bhavanam\nPanchayath\nHaha District");
		
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("anupama@gmail.com");
		
		WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
		phone.sendKeys("9856742233");
		
		WebElement gender = driver.findElement(By.xpath("//input[@type='radio' and @value='FeMale']"));
		gender.click();
		
		WebElement hobby1 = driver.findElement(By.xpath("//input[@id='checkbox1']"));
		hobby1.click();
		
		WebElement hobby2 = driver.findElement(By.xpath("//input[@id='checkbox2']")); 
		hobby2.click();
		
		//submit_btn.click();
		phone.click();
		
		//------------language mutiselect ul li (ElementNotInteractable) --> defect
		WebElement language = driver.findElement(By.xpath("//div[@id='msdd']"));
		language.click();
		WebElement lang_list;
		lang_list = driver.findElement(By.xpath("(//div[@style='display: block;']//ul//li)[1]"));
		lang_list.click();
		lang_list = driver.findElement(By.xpath("(//div[@style='display: block;']//ul//li)[2]"));
		lang_list.click();
		phone.click();
		
		
		Select skills = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
		skills.selectByIndex(3);
		
	    WebElement country = driver.findElement(By.xpath("//span[@role='combobox']"));
	    country.click();
	    WebElement country_search = driver.findElement(By.xpath("//input[@type='search']"));
	    country_search.sendKeys("india");
	    WebElement country_found = driver.findElement(By.xpath("//ul[@id='select2-country-results']//li"));
	    country_found.click();
	    
	    Select birth_year = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
	    birth_year.selectByVisibleText("1940");
	    Select birth_month = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
	    birth_month.selectByIndex(1);
	    Select birth_date = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
	    birth_date.selectByValue("4");
	    
	    WebElement fpass = driver.findElement(By.xpath("//input[@id='firstpassword']"));
	    fpass.sendKeys("archana");
	    WebElement spass = driver.findElement(By.xpath("//input[@id='secondpassword']"));
	    spass.sendKeys("archana"); 
		
	}

}
