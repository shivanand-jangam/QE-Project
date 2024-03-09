Feature: Verify Upadate User Scenario

  @TestRunUpdate
  Scenario Outline: Verity New update User Functionality
    Given I have endpoint as '<endpoint>'
    When I provided Content-Type as "application/json"
    When I provided in payloadbody firstname as '<originalFname>' and lastname as '<originalLname>'
    And I hit "create" booking "POST" request
    Then I should get status code as 200
    And I should get fistname as '<originalFname>'
    And I should get lastname as '<originalLname>'
    
    Given I have endpoint as '<endpoint2>'
    When I provided Content-Type as "application/json"
    When I have generated the token
    When I provided in payloadbody firstname as '<modifiedFname>' and lastname as '<modifiedLname>'
    And I hit "update" booking "PUT" request
    Then I should get status code as 200
    And I should booking user fistname as '<modifiedFname>'
    And I should booking user lastname as '<modifiedLname>'

    Examples: 
      | endpoint | originalFname | originalLname | condition2 | endpoint2     | modifiedFname | modifiedLname     |
      | /booking | originalShiva | originalnand  | FullModify | /booking/{id} | Vijay         | Automation Tester |
