Feature: the info endpoint returns server description
  Scenario: client makes call to GET /info and receives server description
    When the client calls /info
    Then the client receives server description "Template Spring Boot API for use of CSCI 602"
