package com.automatizacion.utils.service;

public enum Services {

    GET_BOOKING("/booking/1"),
    GET_BOOKING_IDS("/booking"),
    POST_CREATE_TOKEN("/auth"),
    PUT_UPDATE_BOOKING("/booking/1"),
    POST_CREATE_BOOKING("/booking");

    private final String serviceName;

    Services(String service) {
        this.serviceName = service;
    }

    public String getServiceName() {
        return serviceName;
    }
}
