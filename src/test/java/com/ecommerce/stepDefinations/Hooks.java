package com.ecommerce.stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utils.WebDriverManager;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver(); 
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver(); 
    }
}
