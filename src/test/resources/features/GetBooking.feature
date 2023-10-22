# Autor: l1_fdo@hotmail.com

@RunAll
Feature: GET type requests are made to the API to obtain the booking ids and a specific

  @GetBooking
  Scenario: Make get request waiting for OK response to GET BOOKING
    Given that John makes a call to the API
    When Makes a get request to the microservice GET_BOOKING
    Then Check the status of request 200

  @GetBookingIds
  Scenario: Make get request waiting for OK response to GET BOOKING IDS
    Given that John makes a call to the API
    When Makes a get request to the microservice GET_BOOKING_IDS
    Then Check the status of request 200