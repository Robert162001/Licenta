@SmokeTest
Feature: Connection to the site

  Scenario: As an existing user, I want to connect to the site successfully

    Given the user navigate to Home page
    When the site successfully loads
    Then the user is able to see the title
