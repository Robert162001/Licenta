@SanityTests
Feature: Verify that the user can connect to each page of the site

  Scenario Outline: As an existing user, I want to be able to connect to each page of the site
    Given the user navigates to "Home" page
    When the user navigates to "<page>" page
    Then the user is able to see "<information specific for that page>"

    Examples:
      | page         | information specific for that page |
      | Blog         | reviews                            |
      | Trips        | trips                              |
      | Destinations | destinations                       |
      | TripTypes    | trip types                         |
      | Activities   | activities                         |


  Scenario: Failure Test

    Given the user navigates to "Home" page
    Then the user is able to see "reviews"