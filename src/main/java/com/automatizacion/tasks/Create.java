package com.automatizacion.tasks;

import com.automatizacion.utils.MergeFrom;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

public class Create implements Task {
    private final String pathJson;
    private final String nameJson;
    private final Map<String, String> testData;

    public Create(String pathJson, String nameJson, Map<String, String> testData) {
        this.pathJson = pathJson;
        this.nameJson = nameJson;
        this.testData = testData;
    }

    public static Performable messageBody(String pathJson, String nameJson, Map<String, String> testData) {
        return Tasks.instrumented(Create.class, pathJson, nameJson, testData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = MergeFrom.template(pathJson).withFieldsFrom(testData);
        actor.remember(nameJson, body);
    }
}