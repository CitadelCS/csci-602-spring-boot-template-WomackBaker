Feature: the info endpoint can be retrieved
  Scenario: client makes call to GET /info
    When the client calls /info
    Then the client receives application name csci-602
    And the client receives server version 1.0.0
    And the client receives server description "Template Spring Boot API for use of CSCI 602"