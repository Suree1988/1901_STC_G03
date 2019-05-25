package G3SnowboardShopTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import extentReportDemo.ExtentReportsClass1;

public class STC_G03_Automation_Testing extends ExtentReportsClass1 {
	
	@Test
	public void TC_2_1() throws Exception {
		
		logger = extent.createTest("TC-2-1");
		driver.get("https://www.zalando.se/kvinna-home/");
		driver.findElement(By.xpath("//*[@id=\'z-navicat-header-root\']/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[1]/div[3]/div/div[1]/a/span/span")).click();
				
		driver.findElement(By.name("login.email")).sendKeys("sureerat1988@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("login.password")).sendKeys("sureerat2531");
		driver.findElement(By.xpath("//html/body/div[4]/div/div/x-fragment-loginmodalreef/div/div/div/div[2]/z-grid/z-grid-item/div/div/div[2]/div/div/div[2]/div/form/z-grid/z-grid-item[3]/button")).click();
		
		Thread.sleep(3000);
		
		String welcomeMessage = driver.findElement(By.xpath("//*[@id='z-navicat-header-root']/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[1]/div[3]/div/div[1]/a/span/span")).getText();
		System.out.println(welcomeMessage);
//		assertEquals(welcomeMessage, "Mitt konto");
		
	}
	
	@DataProvider(name="emails-and-passwords-unusual-data-provider")
	public String[][] emailsAndPasswordsUnusualDataProvider() {
	  
	  	logger = extent.createTest("TC-2-2");
		return new String[][]{
				{"custo?er@test.se","sureerat1234"},
				{"adm%n@test.se","sureerat1234"},
				{"custämer1@test.se","sureerat1234"},
				{"sure#rat1988@gmail.com","sureerat1234"}
			};
	}	
	
	@Test(dataProvider="emails-and-passwords-unusual-data-provider")
	public void TC_2_2(String email, String password) throws Exception {
		
		driver.get("https://www.zalando.se/kvinna-home/");
		driver.findElement(By.xpath("//*[@id=\'z-navicat-header-root\']/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[1]/div[3]/div/div[1]/a/span/span")).click();
		
		driver.findElement(By.name("login.email")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.name("login.password")).sendKeys(password);
		driver.findElement(By.xpath("//html/body/div[4]/div/div/x-fragment-loginmodalreef/div/div/div/div[2]/z-grid/z-grid-item/div/div/div[2]/div/div/div[2]/div/form/z-grid/z-grid-item[3]/button")).click();
		
		Thread.sleep(2000);
		
		String error = driver.findElement(By.cssSelector(".z-1-text.z-1-notification__content.z-1-text-detail-micro.z-1-text-black")).getText();
		System.out.println(error);
		AssertJUnit.assertEquals(error, "Ange en giltig e-postadress, t.ex. namn@domain.se");
		
	}
	
	@DataProvider(name="emails-correct-number-data-provider")
	public Object[][] emailsWithCorrectNumberOfCharactersDataProvider() {
	  
	  	logger = extent.createTest("TC-2-3, TC-2-4");
		return new Object[][]{
				{"tghost.2srffggggggggggggggffdgggggggggggrewws@chaonamdinh.com", false},
				{"tghost.2srffggggggggggggssssssssssssssssssssssssssggffdgggggggggggrewws@chaonamdinh.com", true},
				{"tghost.2srffgggggggggggggkkkkkkkkkkkkgffdgggggggggggrewws@chaonamdinh.com", true},
				{"tghost.2srffggggggggggggggffffffffffffffffffffffdgggggggggggrewws@chaonamdinh.com", true}
				
			};
	}	
	
	@Test(dataProvider="emails-correct-number-data-provider")
	public void TC_2_3_2_4 (String email, boolean isLongMessage) throws Exception {
		
		driver.get("https://www.zalando.se/kvinna-home/");
		driver.findElement(By.xpath("//*[@id=\'z-navicat-header-root\']/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[1]/div[3]/div/div[1]/a/span/span")).click();
		
		driver.findElement(By.name("login.email")).sendKeys(email);
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//html/body/div[4]/div/div/x-fragment-loginmodalreef/div/div/div/div[2]/z-grid/z-grid-item/div/div/div[2]/div/div/div[2]/div/form/z-grid/z-grid-item[3]/button")).click();
		
		Thread.sleep(2000);
		
		if(isLongMessage) {
			logger.createNode("Felmeddelanden ska visas");
			String error = driver.findElement(By.cssSelector(".z-1-notification.z-1-field__notification.z-1-notification--inline.z-1-notification--error.z-1-notification--text-small")).getText();
			System.out.println(error);	
			AssertJUnit.assertEquals(error, "För lång inmatning.");
			
		}else {
			logger.createNode("Att det inte ska bli några felmeddelanden");
			String error = driver.findElement(By.cssSelector(".z-1-field__component")).getText();
			System.out.println(error);	
			
		}

	}
	
	@Test
	public void TC_2_5() throws Exception {
		
		logger = extent.createTest("TC-2-5");
		driver.get("https://www.zalando.se/kvinna-home/");
		driver.findElement(By.xpath("//*[@id=\'z-navicat-header-root\']/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[1]/div[3]/div/div[1]/a/span/span")).click();
				
		driver.findElement(By.name("login.email")).sendKeys("En miljon fans: Gör om säsong 8 av Game of thrones");
		Thread.sleep(2000);
		driver.findElement(By.name("login.password")).sendKeys("Många Game of thrones-fans är minst sagt missnöjda med senaste säsongen av fantasy-serien. Över en miljon hängivna Game of thrones-tittare har nu skrivit under en namnlista med kravet att säsong 8 görs om.");
		driver.findElement(By.xpath("//html/body/div[4]/div/div/x-fragment-loginmodalreef/div/div/div/div[2]/z-grid/z-grid-item/div/div/div[2]/div/div/div[2]/div/form/z-grid/z-grid-item[3]/button")).click();
		
		Thread.sleep(3000);
		
		String loginMessage = driver.findElement(By.cssSelector(".z-coast-reef_login_headline")).getText();
		System.out.println(loginMessage);
		AssertJUnit.assertEquals(loginMessage, "Välkommen till Zalando! Logga in med dina användaruppgifter.");
		
	}
	
	@Test
	public void TC_3_1() {
		
		driver.get("https://www.zalando.se/login/?view=register");
		
		logger = extent.createTest("TC-3-1 TC-19-1");
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		
		logger.createNode("Registrera konto");
		registerPage.registering("Stephie", "Tapscott", "stapscott1@squarespace.com", "sureerat1234");
		WebElement  radioBtn = driver.findElement(By.name("register.gender"));
		radioBtn.click();
		WebElement  radioBtn1 = driver.findElement(By.name("register.newsletter"));
		radioBtn1.click();
		
		logger.createNode("Det ska gå att registrera sig som ny kund");
		driver.findElement(By.className("z-button__content")).click();		
	}
	
	@DataProvider(name="name-data-provider")
	public String[][] nameDataProvider() {
	  
	  	logger = extent.createTest("TC-3-2");
		return new String[][]{
			{"Maria/", "Patton0"}
		};
	}	
	
	@Test(dataProvider="name-data-provider")
	public void TC_3_2 (String fNamn, String eNamn) throws Exception {
		
		driver.get("https://www.zalando.se/login/?view=register");
		
		logger = extent.createTest("TC-3-2");
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		
		logger.createNode("Registrera konto");
		registerPage.enterFirstName(fNamn);
		registerPage.enterFamilyName(eNamn);
		
		logger.createNode("Felmeddelande ska inte visas");
		driver.findElement(By.cssSelector(".z-button.z-button--primary.z-button--button")).click();	
		
		Thread.sleep(4000);
		
		String error = driver.findElement(By.cssSelector(".z-1-notification.z-1-field__notification.z-1-notification--inline.z-1-notification--error.z-1-notification--text-small")).getText();
		System.out.println(error);
		AssertJUnit.assertTrue(error.contains("Ogiltigt val"));
	}
	
	@DataProvider(name="email-data-provider")
	public String[][] emailDataProvider() {
	  
	  	logger = extent.createTest("TC-3-2");
		return new String[][]{
			{"dca☝ian.dohanov@memecituenakganasli.gq"},
			{"dca¤ian.dohanov@memecituenakganasli.gq"}
		};
	}	
	
	@Test(dataProvider="email-data-provider")
	public void TC_3_2_email (String email) throws Exception {
		
		driver.get("https://www.zalando.se/login/?view=register");
		
		logger = extent.createTest("TC-3-2");
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		
		logger.createNode("Skriv in ovanliga tecken");
		registerPage.enterEmail(email);
		
		logger.createNode("Felmeddelande ska inte visas");
		driver.findElement(By.cssSelector(".z-button.z-button--primary.z-button--button")).click();	
		
		Thread.sleep(4000);
		
		String error = driver.findElement(By.cssSelector(".z-1-field__component")).getText();
		System.out.println(error);
	}
	
	@DataProvider(name="fnamn-and-lastnamn-data-provider")
	public Object[][] nameAndLastnameDataProvider() {
	  
	  	logger = extent.createTest("TC-3-3, TC-3-4");
		return new Object[][]{
				{"Mirabelle", "Thomasine",false},
				{"tghost.2srffggggggggggggssssssssssssssssssssssssssggffdgggggggggggrewws", "tghost.2srffggggggggggggssssssssssssssssssssssssssggffdgggggggggggrewws",true},
				{"tghost.2srffgggggggggggggkkkkkkkkkkkkgffdgggggggggggrewwschaonamdinh", "tghost.2srffggggggggggggssssssssssssssssssssssssssggffdgggggggggggrewwsgggggggggggggg",true},
				{"Kjell", "Albertsson",false},
				
			};
	}	
	
	@Test(dataProvider="fnamn-and-lastnamn-data-provider")
	public void TC_3_3_3_4 (String fname, String eNamn, boolean isLongMessage) throws Exception {
		
		driver.get("https://www.zalando.se/login/?view=register");
		
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		registerPage.enterFirstName(fname);
		registerPage.enterFamilyName(eNamn);
		driver.findElement(By.cssSelector(".z-button.z-button--primary.z-button--button")).click();
		
		Thread.sleep(2000);
		
		if(isLongMessage) {
			logger.createNode("Felmeddelanden ska visas");
			String error = driver.findElement(By.cssSelector(".z-1-notification.z-1-field__notification.z-1-notification--inline.z-1-notification--error.z-1-notification--text-small")).getText();
			System.out.println(error);	
			AssertJUnit.assertEquals(error, "För lång inmatning.");
			
		}else {
			logger.createNode("Att det inte ska bli några felmeddelanden");
			String error = driver.findElement(By.cssSelector(".z-1-field__component")).getText();
			System.out.println(error);	
			
		}

	}
	
	@Test
	public void TC_3_5() throws Exception {
		
		logger = extent.createTest("TC-3-5");
		driver.get("https://www.zalando.se/login/?view=register");
		
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		registerPage.registering("Tightsen är konstruerade med minimalt antal sömmar för en bekvämare passform", "Tightsen är konstruerade med minimalt antal sömmar för en bekvämare passform", "Tightsen är konstruerade med minimalt antal sömmar för en bekvämare passform", "Tightsen är konstruerade med minimalt antal sömmar för en bekvämare passform");
		driver.findElement(By.cssSelector(".z-button.z-button--primary.z-button--button")).click();
		Thread.sleep(3000);
		
		logger.createNode("Det ska inte gå att klistra in text i fälten");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		AssertJUnit.assertEquals(url, "https://www.zalando.se/login/?view=register");
		
	}
	
	@Test
	public void TC_19_1() {
		
		driver.get("https://www.zalando.se/login/?view=register");
		
		logger = extent.createTest("TC-19-1");
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		
		logger.createNode("Registrera konto");
		registerPage.registering("Stephie", "Tapscott", "stapscott1@squarespace.com", "sureerat1234");
		WebElement  radioBtn = driver.findElement(By.name("register.gender"));
		radioBtn.click();
		WebElement  radioBtn1 = driver.findElement(By.name("register.newsletter"));
		radioBtn1.click();
		
		logger.createNode("Det ska gå att registrera sig som ny kund och det ska visas i databasen.");
		driver.findElement(By.className("z-button__content")).click();		
	}
	
	@DataProvider(name="password-db-data-provider")
	public Object[][] registerWithusualTextDataProvider() {
	  
	  	logger = extent.createTest("TC-19_2");
		return new Object[][]{
				{"Mirabelle", "Thomasine", "vman@yarnpedia.ml", "jhytÄjh"},
				{"Alexa", "Salinas","nyoun-dyanx@afflive.gq", "A&LBMå[zd*62h(m\\"},
				{"Destiny", "Battle","qmohanadmano@mobaratopcinq.life", "}-3*eVöT&`ec@DT]"},
				
			};
	}	
	
	@Test(dataProvider="password-db-data-provider")
	public void TC_19_2 (String fname, String eNamn, String email, String password) throws Exception {
		
		driver.get("https://www.zalando.se/login/?view=register");
		
		RegisterTestClass registerPage = PageFactory.initElements(driver, RegisterTestClass.class);
		registerPage.registering(fname, eNamn, email, password);
		driver.findElement(By.cssSelector(".z-button.z-button--primary.z-button--button")).click();
		
		Thread.sleep(2000);
		
		logger.createNode("Lösenordet bör visas i databasen.");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		AssertJUnit.assertEquals(url, "https://www.zalando.se/login/?view=register");
			
	}
	

	@Test
	public void TC_7_1() {
		
		driver.get("https://www.zalando.se/damklader-toppar/");
		
		logger = extent.createTest("TC-7-1");
		List <WebElement> listofItems = driver.findElements(By.xpath("//*[@id=\'z-nvg-cognac-root\']/div[1]/z-grid/z-grid-item[2]/div/div[5]/z-grid"));
		
		logger.createNode("Visa produktinformation");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		for (int i=1; i<=listofItems.size(); i++) {
			listofItems = driver.findElements(By.cssSelector(".cat_imageContainer-1cbCt"));
			wait.until(ExpectedConditions.visibilityOf(listofItems.get(i-1)));
			
			//Clicking on the first element 
		    listofItems.get(i-1).click();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    logger.createNode("Produktinformation ska visas när man trycker på en produkt");
		    System.out.print(i + " element clicked\t--");
		    System.out.println("pass");
		    driver.navigate().back(); 
		}
	
	}
	
	@Test
	public void TC_4_1() {
		
		driver.get("https://www.zalando.se/kvinna-home/");
		
		logger = extent.createTest("TC-4-1");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Carhartt WIP");
		element.submit();
		
	    WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.className("cat_main-1dxBH")));

	    List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\'z-nvg-cognac-root\']/div[1]/z-grid/z-grid-item[2]/div/div[1]"));

	    for (WebElement webElement : findElements)
	    {
	        System.out.println(webElement.findElement(By.cssSelector(".cat_filler-LplA4.cat_ellipsis-MujnT")).getText());
	    }
	}

	@Test
	public void TC_4_2() {
		
		driver.get("https://www.zalando.se/kvinna-home/");
		
		logger = extent.createTest("TC-4-2");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("C");
		element.submit();
		
	   String url = driver.getCurrentUrl();
	   System.out.println(url);
	   AssertJUnit.assertEquals(url, "https://www.zalando.se/kvinna-home/");
	    
	}
	
	@Test
	public void TC_5_1 () throws Exception {
		
		logger = extent.createTest("TC-5-1");
		driver.get("https://www.amazon.co.uk/gp/deals/?ie=UTF8&ref_=sv_uk_1&nocache=1558642373334");
		WebElement myDynamicElement = (new WebDriverWait(driver, 2))
	              .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Today's Deals")));
		logger.createNode("Tryck på \\\"Köp\\\" på en eller flera produkter.");
		driver.findElement(By.linkText("NESCAFÉ DOLCE GUSTO Cafe au lait Coffee Pods, 16 Capsules (Pa...")).click();
		driver.findElement(By.id("mbc-buybutton-addtocart-1-announce")).click();
		
		Thread.sleep(2000);
		driver.navigate().back(); 
		driver.navigate().back();
		
		logger.createNode("Tryck på \\\"Köp\\\" på en eller flera produkter.");
		driver.findElement(By.linkText("Save £10 on Fire TV Stick 4K")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		logger.createNode("Tryck på \\\"Köp\\\" på en eller flera produkter.");
		driver.findElement(By.linkText("Naked Grouse Blended Malt Scotch Whisky, 70cl")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		
		logger.createNode("Tryck på \"Köp\" på en eller flera produkter.");
		driver.findElement(By.linkText("45% off Rimmel Slay Kit")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		
		driver.findElement(By.id("nav-cart")).click();
		
		logger.createNode("Produkterna ska visas i varukorgen efter att man tryckt på \"Köp\"");
		String shop = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/h2")).getText();
		System.out.println(shop);
		AssertJUnit.assertEquals(shop, "Shopping Basket");
		
//		driver.findElement(By.cssSelector(".a-button.a-button-normal.a-button-span12.a-button-primary.fixedWidth210")).click();
//		
//		Thread.sleep(3000);
//		
//		driver.findElement(By.cssSelector(".a-button a-button-normal a-button-span12 a-button-primary fixedWidth210")).click();
		

//		assertEquals(alarm, "Added to Basket");
		
	}

}
