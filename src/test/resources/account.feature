Feature: the account endpoint can create an account
  Scenario: client makes call to POST /account
    When the client creates an account with:
      | username | test          |
      | password | test          |
      | email    | test@test.com |
    Then the response contains the account with status 201