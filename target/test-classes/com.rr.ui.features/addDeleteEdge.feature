Feature:  In order to add or delete an edge
  As a user of the application
  I want to log into the application
  And want to add a new node or delete an existing node

  Scenario: Add Edge with Valid Credentials
    Given User is at the Home Page
    When User enter UserName and Password
    And Click on the LogIn button
    Then Map should be displayed
    And User adds a new node
    And new node should be created


  Scenario: Delete Edge with Valid Credentials
    Given the Maker has started a game with the word "silky"
    When the Breaker joins the Maker's game
    Then the Breaker must guess a word with 5 characters