package com.automatizacion.stepsdefinitions;

import com.automatizacion.questions.ResponseCodeQuestion;
import com.automatizacion.tasks.GetBooking;
import com.automatizacion.utils.service.Services;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;

import static com.automatizacion.utils.Constants.END_POIND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetServicesBookingStepDefinition {

    private EnvironmentVariables environmentVariables;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that John makes a call to the API")
    public void that_john_makes_a_call_to_the_api() {
        String endpoint;
        endpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(END_POIND);
        theActorCalled("juan").whoCan(CallAnApi.at(endpoint)).remember("variables", environmentVariables);

    }

    @When("Makes a get request to the microservice (.*)$")
    public void makes_a_get_request_to_the_microservice(Services services) {
        theActorInTheSpotlight().attemptsTo(GetBooking.byCapability(services));

    }
    @Then("Check the status of request (.*)$")
    public void check_the_status_of_request(String statusCode) {
        theActorInTheSpotlight().should(
                seeThat("the status code is: ",
                        ResponseCodeQuestion.was(),
                        CoreMatchers.equalTo(Integer.parseInt(statusCode))
                )
        );
    }
}