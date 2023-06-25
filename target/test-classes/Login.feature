Feature: Login Scenarios

  Scenario Outline: Trying to log in with an invalid username
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I Log in
    Then I should get a error message "<error>"
    Examples:
      | username         | password     | error                                                        |
      | invalid_username | secret_sauce | Username and password do not match any user in this service. |

  Scenario Outline: Trying to log in with an invalid password
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I Log in
    Then I should get a error message "<error>"
    Examples:
      | username      | password         | error                                                        |
      | standard_user | invalid_password | Username and password do not match any user in this service. |


  Scenario Outline: Trying to log in with valid credentials
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I Log in
    Then I should see the products page with the title "<title>"
    Examples:
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |