Feature: Testing a REST API

  Scenario: List Employees 
  Given: I Set GETemployees endpoint
    When I want to retrieve a list of employees
    Then the server should handle it and return a list of employees

  Scenario: Retrieve an Employee
  Given: I Set GETemployee endpoint
    When I want to retrieve a defined '4525' employee
    Then the server should handle it and return an employee
  
  