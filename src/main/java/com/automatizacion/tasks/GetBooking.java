package com.automatizacion.tasks;

import com.automatizacion.utils.service.HeaderParams;
import com.automatizacion.utils.service.Services;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetBooking implements Task {

    private final Services service;

    public GetBooking(Services service) {
        this.service = service;
    }

    public static GetBooking byCapability(Services services) {
        return Tasks.instrumented(GetBooking.class, services);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(service.getServiceName()).with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)
                                .header(HeaderParams.ACCEPT.getName(), HeaderParams.APPLICATION_JSON.getName()))
        );
    }
}
