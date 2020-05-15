package app;

import app.pages.LoginPage;
import helpers.Driver;

public class App {

    public LoginPage loginPage;

    public App() {

        Driver.initDriver();

        //Driver.initRemotedriver();

        loginPage = PageBuilder.buildLoginPage();
    }
}
