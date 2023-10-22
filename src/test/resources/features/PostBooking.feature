# Autor: l1_fdo@hotmail.com

@RunAll
Feature: POST type requests are made for the creation of the token and the creation of bookings

  @PostCreateToken
  Scenario Outline: Make post request waiting for OK response to CREATE TOKEN
    Given that John makes a call to the API
    When Makes a post request to the microservice POST_CREATE_TOKEN
      | username | <username> |
      | password | <password> |
    Then Check the status of request 200
    And Verify that the reason is different from Bad credentials
    Examples:
      | username | password    |
      | admin    | password123 |

  @PostCreateBooking
  Scenario Outline: Make post request waiting for OK response to CREATE BOOKING
    Given that John makes a call to the API
    When Makes a post request to create booking POST_CREATE_BOOKING
      | firstname       | <firstname>       |
      | lastname        | <lastname>        |
      | totalprice      | <totalprice>      |
      | depositpaid     | <depositpaid>     |
      | checkin         | <checkin>         |
      | checkout        | <checkout>        |
      | additionalneeds | <additionalneeds> |
    Then Check the status of request 200
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |