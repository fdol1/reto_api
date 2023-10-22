package com.automatizacion.utils;

import com.automatizacion.exceptions.ExceptionsCreateToken;

import java.util.HashMap;
import java.util.Map;


public class Utils {

    private Utils() {
        throw new ExceptionsCreateToken(ErrorMessage.IMPOSIBLE_INSTANT.getMessage());
    }

    public static Map<String, String> setDataCreateToken(Map<String, Object> dataCreateToken){

        Map<String, String> mapDataCreateToken = new HashMap<>();
        mapDataCreateToken.put("username", String.valueOf(dataCreateToken.get("username")));
        mapDataCreateToken.put("password", String.valueOf(dataCreateToken.get("password")));
        return mapDataCreateToken;
    }

    public static Map<String, String> setDataCreateBooking(Map<String, Object> dataCreateBooking){

        Map<String, String> mapDatacreateBooking = new HashMap<>();
        mapDatacreateBooking.put("firstname", String.valueOf(dataCreateBooking.get("firstname")));
        mapDatacreateBooking.put("lastname", String.valueOf(dataCreateBooking.get("lastname")));
        mapDatacreateBooking.put("totalprice", String.valueOf(dataCreateBooking.get("totalprice")));
        mapDatacreateBooking.put("depositpaid", String.valueOf(dataCreateBooking.get("depositpaid")));
        mapDatacreateBooking.put("checkin", String.valueOf(dataCreateBooking.get("checkin")));
        mapDatacreateBooking.put("checkout", String.valueOf(dataCreateBooking.get("checkout")));
        mapDatacreateBooking.put("additionalneeds", String.valueOf(dataCreateBooking.get("additionalneeds")));

        return mapDatacreateBooking;
    }



}