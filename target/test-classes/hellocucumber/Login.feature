Feature: Everybody wants to know if we can log in

  Scenario: User successfully logs in
    Given the user is on the login page
    And I wait for the page to load
    When the user enters valid username and password
    Then the success message should say "Logged in Successfully"