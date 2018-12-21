import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {

    public static String dd = "job.aiijob.com/a/applicant/index";
        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.get("job.aiijob.com/a/applicant/index");

            String title = driver.getCurrentUrl();

            WebElement result = driver.findElement(By.xpath("//*[@id=\"username\"]"));
            result.sendKeys("18310614641");
            WebElement result2 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            result2.sendKeys("123456a");
            WebElement result3 = driver.findElement(By.xpath("//*[@id=\"btn-user-login\"]"));

            result3.click();
            Thread.sleep(5000);
           System.out.println(title);
           if( dd .equals(title) ){
                System.out.println("没跳转正确");
           }else {
               System.out.println("跳转正确了 笑脸");
           }
            driver.close();
        }

}
