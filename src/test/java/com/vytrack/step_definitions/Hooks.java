package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        System.out.println("\tthis is coming from BEFORE");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2);
        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDb(){
        System.out.println("\tconnecting to Database...");

    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting from Database...");

    }
}
