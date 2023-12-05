Feature: Book a room

  Background: 
    Given I am on the home page

  Scenario: Option to book a room is available on the page
    When I browse through the page
    Then I have the option to book a room

  @book
  Scenario Outline: Option to book room
    When I browse through the page
    Then I have the option to book a room
    When User click book this room
    And User enter the "<FirstName>" "<LastName>" "<Email>" and "<PhoneNumber>"
    And User select the booking date two nights
    And user click on book
    Then verify booking detils

    Examples: 
      | FirstName       | LastName        | Email               | PhoneNumber  |
      | TestAutomation1 | TestAutomation1 | testautom@gmail.com | +32467689396 |
  
