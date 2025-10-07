Feature: the info endpoint returns application name
  Scenario: client makes call to GET /info and receives application name
    When the client calls /info
    Then the client receives application name csci-602
