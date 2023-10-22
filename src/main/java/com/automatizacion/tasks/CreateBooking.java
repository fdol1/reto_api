package com.automatizacion.tasks;

import com.automatizacion.exceptions.ExceptionsCreateToken;
import com.automatizacion.utils.service.HeaderParams;
import com.automatizacion.utils.service.Services;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.automatizacion.utils.Constants.KEY_BODY_BOOKING;
import static com.automatizacion.utils.ErrorMessage.IMPOSIBLE_INSTANT;


public class CreateBooking implements Task{

    private final Services service;

    public CreateBooking(Services service) {
        this.service = service;
    }

    private CreateBooking() {
        throw new ExceptionsCreateToken(IMPOSIBLE_INSTANT.getMessage());
    }

    public static Performable sendData(Services service) {
        return Tasks.instrumented(CreateBooking.class, service);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(KEY_BODY_BOOKING);

        actor.attemptsTo(
                Post.to(service.getServiceName()).with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)
                                .header(HeaderParams.CONTENT_TYPE.getName(), HeaderParams.APPLICATION_JSON.getName())
                                .body(body)
                )
        );

    }
}