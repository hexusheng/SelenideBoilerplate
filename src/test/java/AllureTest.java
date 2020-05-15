import helpers.Driver;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureTest extends A_BaseTestParallelClasses
{
    @Attachment
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) Driver.currentDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    @Description("Авторизация через email")
    @Severity(SeverityLevel.CRITICAL)
    public void loginViaEmail() {
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");
    }

    @Test
    @Description("Тест с приложениями")
    public void testWithAttachments() {
        app.loginPage.open();

        // Способ прикрепить приложение №1
        Allure.addAttachment("My attachment", "yeah, I am an Attachment! Some logs...");

        // Способ прикрепить приложение №2
        takeScreenshot();
    }

    @Test
    @Description("Тест с ссылками")
    @Issue("123")  // example - jira
    @TmsLink("test-1") // test management link, example - test rails
    public void testWithLinks() {
        app.loginPage.open();
    }

    @Test
    @Description("Тест с ошибкой. Здесь срабатывает A_ErrorsLogListener и к отчету добавляется скриншот с ошибкой")
    @Severity(SeverityLevel.MINOR)
    public void failedTest() {
        app.loginPage.open();
        Assert.assertEquals(2,1);
    }

}
