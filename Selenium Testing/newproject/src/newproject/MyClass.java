package newproject;


	import java.awt.List;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
		
		
	public class MyClass {
		 public static void main(String[] args) {
		
		
			 FirefoxOptions options;
			 WebDriver driver;
				
			 
			 System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
				
				options = new FirefoxOptions();
				options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
		 
				driver = new FirefoxDriver(options);
				driver.get("http://localhost/todo2/index.php");
			 
				assert(driver.getPageSource().contains("Welcome to Todo List"));			
				 
				DateFormat df = new SimpleDateFormat("MMddyyyyHHmmss");
				Date today = Calendar.getInstance().getTime();        
				String username = "Lee1234";

				//  Create User Account 
				 
				driver.findElement(By.linkText("Register new account")).click();
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				driver.findElement(By.name("username")).sendKeys(username);
				driver.findElement(By.name("password")).sendKeys("password");
				driver.findElement(By.name("password2")).sendKeys("password");
				
				driver.findElement(By.name("register")).click();
				
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 //Log in with account 
				
				driver.findElement(By.name("username")).sendKeys("Lee1234");
				driver.findElement(By.name("password")).sendKeys("password");
				driver.findElement(By.name("enter")).click(); 
				
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.findElement(By.linkText("Logout")).click();
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Log in Invalid Account 
				driver.findElement(By.name("username")).sendKeys("Khayyam123");
				driver.findElement(By.name("password")).sendKeys("pass");
				driver.findElement(By.name("enter")).click(); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Log in with account 
				
				driver.findElement(By.name("username")).sendKeys("Lee1234");
				driver.findElement(By.name("password")).sendKeys("password");
				driver.findElement(By.name("enter")).click(); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Add new task Pending status
				 
				String date = "2018-06-20"; 
				driver.findElement(By.name("task_name")).sendKeys("New task"); 
				driver.findElement(By.name("due_date")).sendKeys(date); 
				driver.findElement(By.name("status_list")).sendKeys("Pending"); 
				driver.findElement(By.name("enter")).click(); 

				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Add new task Started status
				String date2 = "2018-06-01"; 
				driver.findElement(By.name("task_name")).sendKeys("Start task"); 
				driver.findElement(By.name("due_date")).sendKeys(date2); 
				driver.findElement(By.name("status_list")).sendKeys("Started"); 
				driver.findElement(By.name("enter")).click(); 
				
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Add new task Pending status then Completed
				String date3 = "2018-06-20"; 
				driver.findElement(By.name("task_name")).sendKeys("New task"); 
				driver.findElement(By.name("due_date")).sendKeys(date3); 
				driver.findElement(By.name("status_list")).sendKeys("Completed"); 
				driver.findElement(By.name("enter")).click(); 
				 
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Add new task Pending status then Late
				String date4 = "2018-06-20"; 
				driver.findElement(By.name("task_name")).sendKeys("Late task"); 
				driver.findElement(By.name("due_date")).sendKeys(date4); 
				driver.findElement(By.name("status_list")).sendKeys("Late"); 
				driver.findElement(By.name("enter")).click(); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Verify Multiple Task of Same Type are allowed
				String date5 = "2018-06-20"; 
				driver.findElement(By.name("task_name")).sendKeys("New task"); 
				driver.findElement(By.name("due_date")).sendKeys(date5); 
				driver.findElement(By.name("status_list")).sendKeys("Pending"); 
				driver.findElement(By.name("enter")).click(); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String total1 = driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td")).getText();
				int tasktotal1 = Integer.parseInt(total1);
				System.out.println("Total Task before Deletion is: ");
				System.out.println(tasktotal1); 
				
				// Delete Pending task 
				
				WebElement element = driver.findElement(By.xpath(".//table[@class='data-table']/tbody/tr[1]/td[6]"));
				element.click(); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Alert alert = driver.switchTo().alert(); 
				
				alert.accept(); 
				
				 
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Total Task count 
				
				String total = driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td")).getText();
				int tasktotal = Integer.parseInt(total);
				System.out.println("Total Task is: ");
				System.out.println(tasktotal); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Edit a Task Name and Date
				
				String editedDate="2018-07-01"; 
				WebElement ele = driver.findElement(By.xpath(".//table[@class='data-table']/tbody/tr[1]/td[5]"));
				ele.click(); 

				Alert ale = driver.switchTo().alert(); 
				ale.accept(); 
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.get("http://localhost/todo2/edit_task.php?edit_task_id=55");
				driver.findElement(By.name("task_name")).sendKeys("Edited"); 
				driver.findElement(By.name("due_date")).sendKeys(editedDate);
				driver.findElement(By.name("update")).click(); 
				driver.findElement(By.linkText("Back")).click(); 
				
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Create Duplicate Task Same Everything 
				
				String date6 = "2018-06-20"; 
				driver.findElement(By.name("task_name")).sendKeys("New task"); 
				driver.findElement(By.name("due_date")).sendKeys(date6); 
				driver.findElement(By.name("status_list")).sendKeys("Started"); 
				driver.findElement(By.name("enter")).click(); 
				
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.close();
		    }
		
		
		
	}

