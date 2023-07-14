Feature: Testing a REST API

  Scenario: List Users 
  Given: I Set GET employees service api endpoint
    When you want to retrieve a list of users
    Then the server should handle it and return a list of users

  Scenario: Retrieve an user
  Given: I Set GET employee service api endpoint
    When you want to retrieve a defined '4525' user
    Then the server should handle it and return a user
  
  Scenario: Create an employee
  Given: I Set POST employee service api endpoint
    When you want to create an user
    Then the user is created in the database