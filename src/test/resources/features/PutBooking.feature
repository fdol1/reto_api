# Autor: lpinedau@choucairtesting.com

@RunAll
Feature: A booking update is made through the API. To do this,
  it is necessary to create the token first to pass it as a header in the update.

  Background: Request is made to the API to create token
    Given that John makes a call to the API
    When Makes a post request to the microservice POST_CREATE_TOKEN
      | username | admin       |
      | password | password123 |
    Then Check the status of request 200
    And Verify that the reason is different from Bad credentials

  @UpdateBooking
  Scenario Outline: Make put request waiting for OK response to UPDATE TOKEN
    Given that John makes a call to the API
    When Makes a put request to create booking PUT_UPDATE_BOOKING
      | idBooking       | <idBooking>       |
      | firstname       | <firstname>       |
      | lastname        | <lastname>        |
      | totalprice      | <totalprice>      |
      | depositpaid     | <depositpaid>     |
      | checkin         | <checkin>         |
      | checkout        | <checkout>        |
      | additionalneeds | <additionalneeds> |
    Then Check the status of request 200
    Examples:
      | idBooking | firstname  | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | 1         | Jim_update | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |