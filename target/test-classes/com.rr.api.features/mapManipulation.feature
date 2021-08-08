Feature: Map Manipulation Features

  Background:
    Given user has logged in to application
      |username|password|
      |autobootstrap|autobootstrap|

  Scenario: Open map page for manipulation
    Given user clicks on settings and selects tatsumi from maps and clicks next
    When user navigates to select nodes on the map
    And user selects edge and joins the selected nodes
    And user creates region on click of edit
    And user click in region to Edit and Save the map
    And user edits maps to change X location of map



