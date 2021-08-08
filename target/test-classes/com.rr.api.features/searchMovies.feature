Feature: Search movies by title

  Scenario:Search movies by title for ‘Harry Potter’ and list the IDs of all results.

    Given I prepare GET request to OMDB api endpoint
    When I Set query param
    And Send a GET HTTP request
    Then I receive valid Response
    And I list the id of all results