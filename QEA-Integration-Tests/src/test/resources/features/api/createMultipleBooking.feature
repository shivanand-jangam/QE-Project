Feature: create multiple users wty

  @tag2
  Scenario: create multiple user
   Given I have endpoint as '/booking'
    When I provided Content-Type as "application/json"
    And I provided user details
      | Vijay     | Yaligar | 
      | Shivanand |  Sir | 
    And I hit "create" booking "POST" request
    Then I should get status code as 200
   