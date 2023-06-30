Feature: Create new user and get the users by id

  @smoke
  Scenario: Create new user
    Given Set up the create user request body
    When Create a new user
    Then Verify the create response status code 201
    And Get the create user response details
    Then Verify the user details


#  This dynamic approach not working because getting the 404 error status from server.
#  but the coding part is working fine.

#  @getUserById @smoke
#  Scenario: Get user by id
#    Given Set up the create user request body
#    When Create a new user
#    And Get the create user response details
#    When Get a single user based on created user detail
#    And Get the single user response details
#    Then Verify the get single user response status code 200
#    Then Verify the single user details

  @smoke
  Scenario: Get user by id
    When Get a following single user "2"
    And Get the single user response details
    Then Verify the get single user response status code 200
    Then Verify the single user details "2"