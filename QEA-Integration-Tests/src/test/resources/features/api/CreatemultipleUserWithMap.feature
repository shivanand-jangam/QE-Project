Feature: validate creation Multiple User with map

@MultipleUserwithMap
Scenario: Varify creation of Multiple user with map

Given I have endpoint as "/booking"
When I provided Content-Type as "application/json"
And I provide User details with map and Hit "POST" request
      |Username | Lastname |
      |Vijay    | Yaligar  |
      |Bhima    | Madhure  |
      |Santosh  | Birajdar |

Then I should get status code as 200