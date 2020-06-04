package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("the user navigates to Fleet, Vehicles ");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates Marketing, Campaigns")
    public void the_user_navigates_Marketing_Campaigns() {
        System.out.println("the user navigates to Marketing, Campaigns ");
    }

    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("Expected and Actual title are matching");

    }

    @When("the user navigates Activities, Calendar Events")
    public void the_user_navigates_Activities_Calendar_Events() {
        System.out.println("the user navigates Activities, Calendar Events");
    }

    @Then("the title should be Calendars")
    public void the_title_should_be_Calendars() {
        System.out.println("Expected and Actual title are matching");

    }

    @When("the user navigates {string} {string}")
    public void the_user_navigates(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNumber) {
        BrowserUtils.waitFor(5);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNumber,actualNumber);


    }
}
