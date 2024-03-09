Feature: User details API Test Scenarios

  @APITest11
  Scenario Outline: Verify given user details <id>
   Given I have "Page List" API end point as "/api/users?page=2"
    When I provided the content type as "application/json"
    And I make a "GET" request for user details
    Then the response status code should be 200
    And Verify id as <id>
    And Verify email as '<email>'
    And Verify first_name as '<first_name>'
    And Verify last_name as '<last_name>'
    And Verify avatar as '<avatar>'

    Examples: 
      | id | email                  | first_name | last_name | avatar                                  |
      |  9 | tobias.funke@reqres.in | Tobias     | Funke     | https://reqres.in/img/faces/9-image.jpg |
      #| 11 | george.edwards@reqres.in | George     | Edwards   | https://reqres.in/img/faces/9-image.jpg |
