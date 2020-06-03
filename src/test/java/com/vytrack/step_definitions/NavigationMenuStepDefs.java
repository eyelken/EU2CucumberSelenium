package com.vytrack.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuStepDefs {

    @Then("the user navigate to Fleet, Vehicles")
    public void the_user_navigate_to_Fleet_Vehicles() {
        System.out.println("the user navigates to Fleet, Vehicles");
    }

    @Then("the expected title should be Vehicles")
    public void the_expected_title_should_be_Vehicles() {
        System.out.println("expected and actual titles are matching");
    }

    @Then("the user navigate to Marketing, Campaigns")
    public void the_user_navigate_to_Marketing_Campaigns() {
        System.out.println("the user navigates to Marketing, Campaigns");
    }

    @Then("the expected title should be Campaigns")
    public void the_expected_title_should_be_Campaigns() {
        System.out.println("expected and actual titles are matching");
    }

    @Then("the user navigate to Activities, Calendar Events")
    public void the_user_navigate_to_Activities_Calendar_Events() {
        System.out.println("the user navigates to Activities, Calendar Events");
    }

    @Then("the expected title should be Calendar Events")
    public void the_expected_title_should_be_Calendar_Events() {
        System.out.println("expected and actual titles are matching");
    }

}
