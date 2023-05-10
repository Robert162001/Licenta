@SanityTest
Feature: Verify that the user can connect to each page of the site

  Scenario Outline: As an existing user, I want to be able to connect to each page of the site
    Given the user is on Home page
    When the user navigate to "<page>" page
    Then the user is able to see "<information specific for that site>"

    Examples:
    | page         | information specific for that site |
    | Blog         | reviews                            |
    | Trips        | trips                              |
    | Destinations | destinations                       |
    | TripTypes    | triptypes                          |
    | Activities   | activities                         |


  Scenario: Failure Test

    Given the user is on Home page
    Then the user is able to see Home page