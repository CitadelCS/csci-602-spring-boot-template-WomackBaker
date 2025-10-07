Feature: the info endpoint returns server version
  Scenario: client makes call to GET /info and receives server version
    When the client calls /info
    Then the client receives server version 1.0.0
