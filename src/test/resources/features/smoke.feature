Feature: First Flow

  Scenario: Successfully connection to site

    Given A user navigate to Home page
    When The site successfully loads
    Then They should be able to see the title
