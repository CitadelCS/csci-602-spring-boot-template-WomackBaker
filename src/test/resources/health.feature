Feature: the health endpoint can be retrieved
  Scenario: client makes call to GET /health
    When the client calls /health
    Then the client receives status ok