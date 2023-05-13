@RegressionTest
Feature:

  Scenario: As an existing user, I want to send a comment on a post
    Given the user navigate to Blog page
    When the user select an interesting post and read it
    Then the user send a comment to that post