Feature: Basic Flow

  Scenario: Navigation to Contact page

    Given A user is on Home page
    When They navigate to Contact page
    Then They should be able to chat with customer support


  Scenario: Navigation to About page

    Given A user is on Home page
    When They navigate to About page
    Then They should see information about site


  Scenario: Failure Test

    Given A user is on Home page
    Then They should be on the Home Page