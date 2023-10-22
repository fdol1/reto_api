package com.automatizacion.tasks;

import com.automatizacion.exceptions.ExceptionsCreateToken;
import com.automatizacion.questions.ResponseTokenQuestion;
import com.automatizacion.utils.service.HeaderParams;
import com.automatizacion.utils.service.Services;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.automatizacion.utils.Constants.KEY_BODY_TOKEN;
import static com.automatizacion.utils.Constants.KEY_RESPONSE_POST_TOKEN;
import static com.automatizacion.utils.ErrorMessage.IMPOSIBLE_INSTANT;


public class CreateToken implements Task{

    private final Services service;

    public CreateToken(Services service) {
        this.service = service;
    }

    private CreateToken() {
        throw new ExceptionsCreateToken(IMPOSIBLE_INSTANT.getMessage());
    }

    public static Performable sendData(Services service) {
        return Tasks.instrumented(CreateToken.class, service);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(KEY_BODY_TOKEN);

        actor.attemptsTo(
                Post.to(service.getServiceName()).with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)
                                .header(HeaderParams.CONTENT_TYPE.getName(), HeaderParams.APPLICATION_JSON.getName())
                                .body(body)
                )
        );
        String responseToken = new ResponseTokenQuestion().answeredBy(actor).getToken();
        actor.remember(KEY_RESPONSE_POST_TOKEN,responseToken);

    }
}