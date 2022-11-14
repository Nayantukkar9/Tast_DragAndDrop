package One;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws IOException{
		System.setProperty( "webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://trello.com/en/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// login page 
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("nayantukkar9@gmail.com");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Nayan@123");
		driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Click on  board
		driver.findElement(By.xpath("//div[@class='board-tile-details is-badged']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//Creating List-A
		driver.findElement(By.xpath("//span[@class='placeholder']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Enter list title…'])[1]")).sendKeys("List-A");
		driver.findElement(By.xpath("(//input[@value='Add list'])[1]")).click();
	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Adding a card to List-A
		driver.findElement(By.xpath("(//span[@class='js-add-a-card'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//textarea[@placeholder='Enter a title for this card…'])[1]")).sendKeys("This is in from list-A");
		driver.findElement(By.xpath("(//input[@value='Add card'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Creating List-B
		//driver.findElement(By.xpath("(//span[@class='placeholder'])[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/input[1]")).sendKeys("List-B");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//input[@value='Add list'])[1]")).click();
		
	    
		// Actions class  DragAndDrop
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("(//div[@class='list-card-details js-card-details'])[1]"));
	    WebElement drop = driver.findElement(By.xpath("//*[@id=\"board\"]/div[2]"));
		action.dragAndDrop(drag, drop).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// X and Y coordinates of the card
		WebElement element = driver.findElement(By.xpath("(//div[@class='list-card-details js-card-details'])[1]"));
		Point p = element.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		
		// logout
		driver.findElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[1]/div[1]/div[1]/div[1]/nav[1]/div[3]/button[2]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Log out')]")).click();
	}

}
