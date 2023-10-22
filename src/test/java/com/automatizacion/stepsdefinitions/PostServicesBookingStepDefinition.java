package com.automatizacion.stepsdefinitions;

import com.automatizacion.questions.CheckResponseCreateToken;
import com.automatizacion.tasks.Create;
import com.automatizacion.tasks.CreateBooking;
import com.automatizacion.tasks.CreateToken;
import com.automatizacion.utils.service.Services;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static com.automatizacion.utils.Constants.*;
import static com.automatizacion.utils.Utils.setDataCreateBooking;
import static com.automatizacion.utils.Utils.setDataCreateToken;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostServicesBookingStepDefinition {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Makes a post request to the microservice (.*)$")
    public void makes_a_post_request_to_the_microservice(Services services, Map<String, Object> dataToken) {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody(PATH_JSON_CREATE_TOKEN, KEY_BODY_TOKEN, setDataCreateToken(dataToken)),
                CreateToken.sendData(services)
        );
    }

    @Then("Verify that the reason is different from (.*)$")
    public void verify_that_the_reason_is_different_from(String responseMessage) {
        theActorInTheSpotlight().should(seeThat(CheckResponseCreateToken.onResponse(responseMessage)));
    }

    @When("Makes a post request to create booking (.*)$")
    public void makes_a_post_request_to_create_booking_post_create_booking(Services services, Map<String, Object> dataBooking) {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody(PATH_JSON_CREATE_BOOKING, KEY_BODY_BOOKING, setDataCreateBooking(dataBooking)),
                CreateBooking.sendData(services)
        );
    }
}