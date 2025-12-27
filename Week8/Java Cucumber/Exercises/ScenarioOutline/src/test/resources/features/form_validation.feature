@validation
Feature: Form Field Validation
  As a user
  I want to receive clear validation messages
  So that I can correctly fill out forms

  @email-validation
  Scenario Outline: Email field validation
    Given the user is on the registration page
    When the user enters email "<email>"
    And the user submits the form
    Then the email validation result should be "<valid>"
    And the validation message should be "<message>"

    # TODO: Create comprehensive Examples for email validation
    Examples: Valid Emails
      | email                    | valid | message |
      | user@example.com         | yes   | Valid   |
      | user.name@example.co.uk  | yes   | Valid   |
      | user+tag@example.com     | yes   | Valid   |

    Examples: Invalid Emails - Format Issues
      | email              | valid | message                          |
      | userexample.com    | no    | Email must contain @             |
      | user@              | no    | Email must contain domain name   |
      | @example.com       | no    | Email must contain username      |
      | user @example.com  | no    | Email must not contain spaces    |

    Examples: Invalid Emails - Empty
      | email | valid | message                  |
      |       | no    | Email is required        |

  @password-validation
  Scenario Outline: Password strength validation
    Given the user is on the registration page
    When the user enters password "<password>"
    And the user submits the form
    Then the password strength should be "<strength>"
    And the validation message should be "<message>"

    # TODO: Create Examples for password strength
    # Consider: length, uppercase, lowercase, numbers, special chars
    Examples: Password Strength
      | password   | strength | message                                   |
      | abc        | weak     | Password must be at least 8 characters    |
      | abcdefgh   | weak     | Password must contain an uppercase letter |
      | Abcdefgh   | weak     | Password must contain a number            |
      | Abcdefg1   | weak     | Password must contain a special character |
      | Abcdef1!   | strong   | Password is strong                        |

  @age-validation
  Scenario Outline: Age boundary validation
    Given the user is on the registration page
    When the user enters age "<age>"
    And the user submits the form
    Then the age validation result should be "<valid>"

    # TODO: Create Examples using boundary value analysis
    # Valid age range: 18-120
    Examples: Boundary Values
      | age | valid | description             |
      | 17  | no    | Below minimum boundary  |
      | 18  | yes   | At minimum boundary     |
      | 19  | yes   | Just above minimum      |
      | 119 | yes   | Just below maximum      |
      | 120 | yes   | At maximum boundary     |
      | 121 | no    | Above maximum boundary  |