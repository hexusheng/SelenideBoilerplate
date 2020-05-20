import app.App;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Selenide;
import helpers.Driver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(UniversalVideoListener.class)
public class ScreenshotsAndVideoTest {

    @Test
    @Video
    public void shouldFailAndCreateRecordWithTestName() {
        Driver.wait(1);
        assert false;
    }

    @Test
    @Video(name = "second_test")
    public void videoShouldHaveNameSecondTest() {
        App app = new App();
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");
    }

    @Test
    public void screenshotTest() {
        Selenide.open("http://ya.ru");

        //Driver.takeScreenshot();

        //Selenide.screenshot("test");
    }

}
