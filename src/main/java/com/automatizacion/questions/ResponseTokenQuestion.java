package com.automatizacion.questions;

import com.automatizacion.models.ModelResponseToken;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseTokenQuestion implements Question {

    @Override
    public ModelResponseToken answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ModelResponseToken.class);
    }
}
