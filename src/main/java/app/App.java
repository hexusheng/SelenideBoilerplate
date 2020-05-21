package app;

import app.pages.LoginPage;
import helpers.Driver;

public class App {

    public LoginPage loginPage;

    public App() {

        Driver.initDriver();

        loginPage = PageBuilder.buildLoginPage();
    }
}
