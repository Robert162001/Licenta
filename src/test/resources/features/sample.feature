Feature: Basic Flow

  Scenario: Navigation to Blog page

    Given A user is on Home page
    When They navigate to Blog page
    Then They should be able to chat with customer support


  Scenario: Navigation to Trips page

    Given A user is on Home page
    When They navigate to Trips page
    Then They should see information about site


  Scenario: Failure Test

    Given A user is on Home page
    Then They should be on the Home Page