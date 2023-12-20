import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Amazon {
    @Before
    public void setUp() throws Exception {
        //Configuration.browser="edge";
        open();
        webdriver().driver().getWebDriver().manage().window().maximize();
        webdriver().driver().getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void name() {
        open("https://amazon.com");
        $(By.xpath("//*[@id='twotabsearchtextbox']")).val("iphone").pressEnter();
        String aramaSonucu = $(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        System.out.println("Arama Sonuc Yazisi = "+aramaSonucu);
        System.out.println("Arama Sonuc Sayisi = "+aramaSonucu.split(" ")[2]);
        $(By.xpath("(//*[@class='sg-col-inner'])[1]")).shouldHave(text("iphone"));
        //Configuration.holdBrowserOpen=true;
    }

}
