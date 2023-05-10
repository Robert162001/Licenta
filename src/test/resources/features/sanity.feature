@SanityTest
Feature: Verify that the user can connect to each page of the site

  Scenario Outline: As an existing user, I want to be able to connect to each page of the site
    Given the user is on Home Page
    When the user navigate to <page> page
    Then the user is able to see <information specific for that site>

    Examples:
    | page         | information specific for that site |
    | Blog         | reviews                            |
    | Trips        | trips                              |
    | Destinations | destinations                       |
    | TripTypes    | triptypes                          |
    | Activities   | activities                         |


#  Scenario: Navigation to Blog page
#
#    Given A user is on Home page
#    When They navigate to Blog page
#    Then They should be able to see reviews
#
#
#  Scenario: Navigation to Trips page
#
#    Given A user is on Home page
#    When They navigate to Trips page
#    Then They should see information about trips
#
#
#  Scenario: Navigation to Destinations page
#
#    Given A user is on Home page
#    When They navigate to Destinations page
#    Then They should see information about destinations
#
#
#  Scenario: Navigation to TripTypes page
#
#    Given A user is on Home page
#    When They navigate to TripTypes page
#    Then They should see information about triptypes
#
#
#  Scenario: Navigation to Activities page
#
#    Given A user is on Home page
#    When They navigate to Activities page
#    Then They should see information about activities

#  Scenario: Failure Test
#
#    Given the user is on Home page
#    Then They should be on the Home Page