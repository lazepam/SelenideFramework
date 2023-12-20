import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Google {


    @Test
    public void test() {
        Configuration.holdBrowserOpen=true;//Browser'ı açık tutar
        //Google adresine gidelim
        open("https://www.google.com");
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        $("[name='q']").shouldBe(empty);//TextBox'ın boş olduğunu doğrular
        $("[name='q']").val("Selenide").pressEnter();//TextBox'ta selenide aratıp enter'a basar
        $("#search").shouldHave(text("selenide.org"));//arama sonucunda selenide.org yazısının olduğunu test eder
        System.out.println($("[name='q']").isEnabled());
        $("[name='q']").shouldNotBe(empty);//Boş olmadığını doğrular
        $("[name='q']").shouldBe(enabled);//Etkin olması gerektiğini doğrular
        $("[name='q']").shouldBe(visible);//Görünür olması gerektiğini doğrular



    }


}
