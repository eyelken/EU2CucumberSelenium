package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class LoginStepDefs {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        //WebDriver driver = Driver.get();
        //driver.get(url);
        //instead of driver object we will use Driver.get() directly
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify title","Dashboard",actualTitle);


    }

    @When("the user enter sales manager information")
    public void the_user_enter_sales_manager_information() {
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user enter store manager information")
    public void the_user_enter_store_manager_information() {
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue("Actual Title "+Driver.get().getTitle(),Driver.get().getTitle().contains(expectedTitle));

    }





}