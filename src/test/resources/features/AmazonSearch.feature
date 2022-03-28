Feature: User should be able to type something into the search box and be redirected to a page with that title

  Scenario: User is searching for something
    Given user is on amazon page
    When user inputs "apple" into the search box and hits enter
    Then user can see the title of the "apple"