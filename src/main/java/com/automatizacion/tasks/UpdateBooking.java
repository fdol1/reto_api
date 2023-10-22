package com.automatizacion.tasks;

import com.automatizacion.exceptions.ExceptionsCreateToken;
import com.automatizacion.utils.service.HeaderParams;
import com.automatizacion.utils.service.Services;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.automatizacion.utils.Constants.KEY_BODY_BOOKING;
import static com.automatizacion.utils.Constants.KEY_RESPONSE_POST_TOKEN;
import static com.automatizacion.utils.ErrorMessage.IMPOSIBLE_INSTANT;

public class UpdateBooking implements Task{

    private final Services service;
    private final String idBooking;
    public UpdateBooking(Services service, String idBooking) {
        this.service = service;
        this.idBooking = idBooking;
    }

    private UpdateBooking() {
        throw new ExceptionsCreateToken(IMPOSIBLE_INSTANT.getMessage());
    }

    public static Performable sendData(Services service, String idBooking) {
        return Tasks.instrumented(UpdateBooking.class, service, idBooking);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String responseToken = actor.recall(KEY_RESPONSE_POST_TOKEN);
        String body = actor.recall(KEY_BODY_BOOKING);
        actor.attemptsTo(
                Put.to(service.getServiceName() + idBooking).with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)
                                .header(HeaderParams.CONTENT_TYPE.getName(), HeaderParams.APPLICATION_JSON.getName())
                                .header(HeaderParams.ACCEPT.getName(), HeaderParams.APPLICATION_JSON.getName())
                                .header(HeaderParams.COOKIE.getName(),responseToken)
                                .header(HeaderParams.AUTHORIZATION.getName(), HeaderParams.AUTHORIZATION_VALUE.getName())
                                .body(body)
                )
        );
    }
}