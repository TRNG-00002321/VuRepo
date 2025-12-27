@password @security
Feature: Password Reset
  As a registered user
  I want to reset my password
  So that I can regain access to my account if I forget my password

  @smoke
  Scenario: Request password reset with valid email
    # TODO: Write the scenario
    Given the user is on the password reset page
    When the user enters a valid registered email address
    And the user submits the password reset request
    Then a password reset confirmation message is displayed
    And a password reset email is sent to the user

  Scenario: Request password reset with invalid email format
    # TODO: Write the scenario
    Given the user is on the password reset page
    When the user enters an email address with an invalid format
    And the user submits the password reset request
    Then an error message is displayed indicating the email format is invalid

  Scenario: Request password reset with unregistered email
    # TODO: Write the scenario
    # Note: For security, message should not reveal if email exists
    Given the user is on the password reset page
    When the user enters an unregistered email address
    And the user submits the password reset request
    Then a generic password reset confirmation message is displayed

  Scenario: Reset link expires after 24 hours
    # TODO: Write the scenario
    # Use time-based Given clause
    Given a password reset link was generated more than 24 hours ago
    When the user attempts to use the password reset link
    Then the system rejects the password reset request
    And a message is displayed indicating the reset link has expired

  Scenario: Successfully reset password
    # TODO: Write the scenario
    # Include setting new password and verification
    Given a password reset link was sent within the last 24 hours
    When the user clicks the password reset link
    And the user enters a new password
    And the user confirms the new password
    Then a success message is displayed stating "Successfully changed the password"

  Scenario: Old password fails after reset
    Given the user "john@example.com" has reset their password to "NewPass123!"
    When the user attempts to login with email "john@example.com" and password "OldPass456!"
    Then the login should fail
    And an error message should indicate "Invalid credentials"

  Scenario: Password must meet complexity requirements
    # TODO: Write the scenario
    # Include scenarios for passwords that don't meet requirements
    Given the user is on the password creation page
    When the user enters a password that does not meet complexity requirements
    And the user submits the password
    Then an error message is displayed explaining the password complexity rules

