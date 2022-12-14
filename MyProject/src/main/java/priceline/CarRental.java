package priceline;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CarRental {


	public static void main(String[] args) {
		
		 String pickUpMonth="March 2023";	
		 String DropMonth="March 2023";	
		 String pickUpDate ="March 1, 2023";
		 String dropDate="March 3, 2023";
	     

         String pickUpTime="05:00";
        String dropTime="19:00";
        String pickUpPlace="Baton Rouge";	
        String DropPlace="Westminster";	
        
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.priceline.com/rentalcars/?vrid=ad835bcbdc0c291e5680ec446e867c41");
		
		WebElement dd = driver.findElement(By.xpath("//div[@class='sc-bdVaJa sc-eNQAEJ debIBP']/div/div/div[@class='sc-bdVaJa sc-htpNat eJeNxs']"));
		dd.click();
		boolean selected =dd.isSelected();
		assertEquals(selected, false);
		boolean selected2 = driver.findElement(By.cssSelector("div[class='sc-bdVaJa CdgIL'] div[class='sc-bdVaJa sc-htpNat hdKdYu']")).isSelected();
        System.out.println(selected2); //false but it already selected same for line 32
		
		
		WebElement pickup = driver.findElement(By.xpath("//input[@placeholder='City, Airport or Address']"));
		pickup.sendKeys("MSY");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@data-testid='typeahead-dropdown-item']"));
	   	findElements.stream().filter(s->s.getText().contains(pickUpPlace)).forEach(s->s.click());
        //or
		/*for (WebElement each : findElements) {
			String text = each.getText();
			System.out.println(text);	
			if (text.contains(pickUpPlace)) {
				each.click();
				break;
			}		
		}*/
		driver.findElement(By.xpath("//input[@id='drop-off-location']")).sendKeys("la");
		List<WebElement> findElements2 = driver.findElements(By.cssSelector("div[data-testid='dropdown-item']"));
		for (WebElement each2 : findElements2) {
			String text1 = each2.getText();
			//System.out.println(text1);	
			if (text1.contains(DropPlace)) {
				each2.click();
				break;
			}				
		}
		
		driver.findElement(By.xpath("//input[@id='pickup-date']/parent::div[@class='sc-bdVaJa sc-htpNat gPJmAi']")).click();
		 
		//Extracting text of all months and select the pickupmonth
		List<WebElement> monthtext = driver.findElements(By.xpath("//div[@class='sc-bdVaJa Month__MonthName-sc-12ikvnx-0 fOguv']"));
		for (WebElement each : monthtext) {
			String month = each.getText();
			//System.out.println(month);
			if (month.equals(pickUpMonth)) {
				break;
			}else
				driver.findElement(By.cssSelector("button[class*='CalendarCard__RightArrow']")).click();
		}
			
		//extracting text of all dates and select the date
		List<WebElement> alldates = driver.findElements(By.className("day-cell"));
		for (WebElement date : alldates) {
			String text = date.getText();
			//System.out.println(text);
            String attribute = date.getAttribute("aria-label"); //if didnt add this line,its selecting current month date 1
			if (attribute.equalsIgnoreCase(pickUpDate)) {
				date.click();
			    break;

				}
			}
		
		driver.findElement(By.cssSelector("input[data-autobot-element-id='CARS_SEARCH_END_DATE']")).click();
		//Extracting text of all months and select the dropmonth
				List<WebElement> monthtext1 = driver.findElements(By.xpath("//div[@class='sc-bdVaJa Month__MonthName-sc-12ikvnx-0 fOguv']"));
				for (WebElement each : monthtext1) {
					String month = each.getText();
					System.out.println(month);
					if (month.equals(DropMonth)) {
						break;
					}else
						driver.findElement(By.cssSelector("button[class*='CalendarCard__RightArrow']")).click();
				}
					
				//extracting text of all dates and select the date
				List<WebElement> alldates1 = driver.findElements(By.className("day-cell"));
				for (WebElement date1 : alldates1) {
					String text = date1.getText();
					//System.out.println(text);
		            String attribute = date1.getAttribute("aria-label"); //if didnt add this line,its selecting current month date 1
					if (attribute.equalsIgnoreCase(dropDate)) {
						date1.click();
					    break;

						}
					}
				
		//pickupTime
		WebElement dp = driver.findElement(By.cssSelector("select[id='pickupTime']"));
		Select sss= new Select(dp);
		sss.selectByValue(pickUpTime);
		//dropTime
		WebElement dp1 = driver.findElement(By.cssSelector("select[id='returnTime']"));
		Select sss1= new Select(dp1);
		sss.selectByValue(dropTime);
		
		driver.findElement(By.cssSelector("button[aria-label='Search for Rental Cars']")).click();



	}

}