import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class TaskManagerAppTest1 {
    public static void main(String[] args){

        //Create a driver instance using WebDriver interface.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Navigate to the URL https://qataskmanager.ccbp.tech/

        driver.get("https://qataskmanager.ccbp.tech/");

        //Find all the tasks which has class attribute value task

        List<WebElement>  ListOfTasksElements  = driver.findElements(By.className("task"));
        System.out.println(ListOfTasksElements.size());

        //Perform the below test for all the tasks,
        //Hover on the task

        Actions action = new Actions(driver);

        for(WebElement taskElement : ListOfTasksElements){
            String originalColor = taskElement.getCssValue("background-color");
            action.moveToElement(taskElement).perform();
            String newColor = taskElement.getCssValue("background-color");


            if(!originalColor.equals(newColor)){
                System.out.println("Background color changed on hover.");
            }else{
                System.out.println("Background color did not change on hover.");
            }
        }

        driver.quit();


    }







}
