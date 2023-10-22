package com.automatizacion.stepsdefinitions;

import com.automatizacion.tasks.Create;
import com.automatizacion.tasks.UpdateBooking;
import com.automatizacion.utils.service.Services;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static com.automatizacion.utils.Constants.*;
import static com.automatizacion.utils.Utils.setDataCreateBooking;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutServicesBookingStepDefinition {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Makes a put request to create booking (.*)$")
    public void makes_a_post_request_to_create_booking_post_create_booking(Services services, Map<String, Object> dataBooking) {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody(PATH_JSON_CREATE_BOOKING, KEY_BODY_BOOKING, setDataCreateBooking(dataBooking)),
                UpdateBooking.sendData(services, String.valueOf(dataBooking.get("idBooking")))
        );
    }
}