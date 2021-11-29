Feature: Validate the successful submission message

  @e2e
  Scenario Outline: Ensure that successful submission message appears after submitting contact page
    Given User clicks on contact us on homepage
    Then  Customer submits "<ForeName>" "<Email>" "<Message>" and Successful acknowledgement messsage is displayed
    Examples:
      | ForeName  | Email               | Message      |
      | testUser1 | testUser1@gmail.com | testMessage1 |
      | testUser2 | testUser2@gmail.com | testMessage2 |
      | testUser3 | testUser3@gmail.com | testMessage3 |
      | testUser4 | testUser4@gmail.com | testMessage4 |
      | testUser5 | testUser5@gmail.com | testMessage5 |

  @e2e
  Scenario: Verifying the selected items are in the cart
    Given user clicks on shop page on homepage
    And user adds Funny Cow 2 times
    And user adds Fluffy bunny 1 time
    When user click on cart menu
    Then verify total 3 items are in cart

