@RegressionTests
Feature: Verify that the user can send a review

  Scenario: As an existing user, I want to send a comment on a post
    Given the user navigates to "Home" page
    When the user navigates to "Blog" page
    And they scroll to read the "first" published article on the page
    And they click on "Read more" button
    And they leave a comment with the following details
      | comment                  | name   | email            |
      | Very good documentation! | random | random@email.com |
    Then they see the comment published on the page

Feature: Verify that the user can book an offer destination

  Scenario: As an existing user, I want to make a reservation for a vacation
    Given the user navigates to "Home" page
    When the user navigates to "Trips" page
    And they click to see all the destination from criteria
    #And they select from criteria menu a destination















