package com.automatizacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/PostBooking.feature",
        tags = "@RunAll",
        glue ="com.automatizacion"
)

public class PostBookinsRunner {
}
