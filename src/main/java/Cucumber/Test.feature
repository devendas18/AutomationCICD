@tag
Feature: Search functionality
  This text here is a default "description" area that is ignored by the runner.
  @tag1
  Scenario: Search for a specific term
    Given the user is on the homepage
    When they enter "Cucumber" into the search bar
    And 
    Then results for "Cucumber" are displayed