#author: saritapadilla23@gmail.com

Feature: consumption services
  As a user I need to consumption of services


  Scenario:  service consumption get successful
    When the user send the request
    Then he should see the response code and  message


  Scenario:  service consumption register successful
    When the user send the register request
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Then he should see the register response code and  message


  Scenario:  service consumption delete successful
    When the user send the delete request
    Then he should see the delete response code and  message
