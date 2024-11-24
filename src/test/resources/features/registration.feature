Feature: Registration page feature

  Background:
    Given User is on the Registration Page

  Scenario Outline: Fill First and Last name
    When Fill "<firstName>" in First Name
    And Fill "<lastName>" in Last Name

    Examples:
      | firstName | lastName |
      | Shiv      | Kant     |
      | John      | Doe      |
      | Jane      | Smith    |
      | 1Jane     | Smith    |
      | Jane      | 2Smith   |
      | Jans736e  | Smi&&th  |

  Scenario: Check Marital Status (Radio Button) of the customer
    When Click on the below Martial Status options
      | Status   |
      | Single   |
      | Married  |
      | Divorced |

  Scenario: Check hobby of the customer (Checkbox)
    When Click on the below hobby options
      | Status   |
      | Dance    |
      | Reading  |
      | Cricket  |

  Scenario: Check Country Name of the customer
    When Click on the Country dropDown
    And Select the country from dropDown

  Scenario Outline: Fill Phone Number
    When Fill "<phoneNumber>" in Phone Number

    Examples:
      | phoneNumber  |
      | 6202055728   |
      | 9876543210   |

  Scenario Outline: Fill Email
    When Fill "<email>" in Email

    Examples:
      | email               |
      | test@example.com    |
      | invalidemail@xyz.com|

  Scenario Outline: Fill Password
    When Fill "<password>" in Password

    Examples:
      | password  |
      | pass123   |
      | abcdefg   |

  Scenario Outline: Upload file
    And Upload file "<filePath>"
    Examples:
      | filePath                                                              |
      | C:\Users\shivkant_kumar\Pictures\a5b229107ae73c00cf2bed81913a21a1.jpg |
