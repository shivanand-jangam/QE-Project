Feature: validate creation Multiple User with List

@MultipleUser
Scenario: Varify creation of Multiple user with List

Given I have endpoint as "/booking"
When I provided Content-Type as "application/json"
And I provide User details 
      |Vijay    | Yaligar  |
      |Bhima    | Madhure  |
      |Santosh  | Birajdar |
When I Hit request as "POST"
Then I should get status code as 200
    
 
  