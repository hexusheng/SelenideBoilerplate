package app.pages;
import app.AppConfig;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        Selenide.open(AppConfig.baseUrl + pageUrl);
    }
}
