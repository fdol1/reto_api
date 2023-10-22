package com.automatizacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.automatizacion.utils.Constants.KEY_RESPONSE_POST_TOKEN;

public class CheckResponseCreateToken implements Question<Boolean> {

    private final String responseMessage;
    public CheckResponseCreateToken(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public static CheckResponseCreateToken onResponse(String responseMessage){
        return new CheckResponseCreateToken(responseMessage);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return (!responseMessage.equals(actor.recall(KEY_RESPONSE_POST_TOKEN)));
    }
}