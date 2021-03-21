package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    ContactsPage contactsPage = new ContactsPage();
    ContactInfoPage contactInfoPage = new ContactInfoPage();

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        //send userType to enter username and password
        loginPage.login(userType);
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expOptions) {

        BrowserUtils.waitFor(2);
        //get the list of webelement and convert them to list of string with the help of ready method.
        List<String> actualOptions = BrowserUtils.getElementsText(dashboardPage.menuOptions);

        Assert.assertEquals(expOptions,actualOptions);
        System.out.println("actualOptions = " + actualOptions);
        System.out.println("expOptions = " + expOptions);


    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        System.out.println("userInfo = " + userInfo);

        loginPage.login(userInfo.get("username"),userInfo.get("password"));

        String expectedName=userInfo.get("firstname")+" "+userInfo.get("lastname");
        String actualName=new DashboardPage().getUserName();

        Assert.assertEquals(expectedName,actualName);

        System.out.println("actualname = " + actualName);
        System.out.println("expectedname = " + expectedName);


    }
    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {

        BrowserUtils.waitFor(5);

        //click the row with email
        contactsPage.getContactEmail(email).click();
        BrowserUtils.waitForPageToLoad(7);

    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
        //get actual data from UI-GUI-Front end-Browser-Website(whatever we see)
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);


        //get expected data from database
        String query = "select concat(first_name,' ', last_name) as fullname, e.email, p.phone from orocrm_contact c\n" +
                "join orocrm_contact_email e on c.id = e.owner_id\n" +
                "join orocrm_contact_phone p on c.id = p.owner_id\n" +
                "where e.email = 'mbrackstone9@example.com'";

        //create connection
        DBUtils.createConnection();

        //since the result is only one row, we saved in Map<String,Object>
        //if you are dealing with multiple rows, use List<Map<String,Object>>
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        //close connection
        DBUtils.destroy();

        //Compare UI to DB
        Assert.assertEquals(expectedFullname,actualFullname);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);

    }

    @Then("the information {string} should be same with database")
    public void the_information_should_be_same_with_database(String email) {
        //get actual data from UI-GUI-Front end-Browser-Website(whatever we see)
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);


        //get expected data from database
        String query = "select concat(first_name,' ',last_name) as fullname,e.email,phone\n" +
                "from orocrm_contact c JOIN  orocrm_contact_email e\n" +
                "ON c.id=e.owner_id \n" +
                "JOIN orocrm_contact_phone p\n" +
                "ON e.owner_id=p.owner_id\n" +
                "where e.email='"+email+"'";


        //since the result is only one row, we saved in Map<String,Object>
        //if you are dealing with multiple rows, use List<Map<String,Object>>
        Map<String, Object> rowMap = DBUtils.getRowMap(query);


        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        //Compare UI to DB

        Assert.assertEquals(expectedFullname,actualFullname);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);


    }

}