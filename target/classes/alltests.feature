Feature: AllTests
  As a user
  I want to test basic functionality of the site

  Scenario Outline: Check search of product item
    Given User opens '<homepage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User click on product '<productName>'

    Examples:
      | homepage              | keyword                                             |productName                                                   |
      | https://www.ebay.com/ | Perturebo Primarch of the iron warriors             |//*[@id="srp-river-results"]/ul/li[4]/div/div[1]/div/a/div/img|

  Scenario Outline: Checking Footer, Company info
    Given User opens '<homepage>' page
    When User click on Company info
    Then Checking of correct page '<CorrectUrl>'

    Examples:
      | homepage              |CorrectUrl                       |
      | https://www.ebay.com/ |https://www.ebayinc.com/company/ |

Scenario Outline: Explore popular brands
  Given User opens '<homepage>' page
  When User click on popular brands
  Then Checking of correct page '<CorrectUrl>'

  Examples:
    | homepage              |CorrectUrl                                                                                                                                        |
    | https://www.ebay.com/ |https://www.ebay.com/globaldeals?_trkparms=pageci%3A40fe448c-3d65-11ed-898f-d61999579c35%7Cparentrq%3A7880f55a1830a4d6b0cb3fbafffffedc%7Ciid%3A2 |

  Scenario Outline: Invalid Log In data
    Given User opens '<homepage>' page
    When Sign in
    And User sees the security measure window
    And Log In with incorrect email or '<login>'
    Then Incorrect Email or Password
    Examples:
      | login | homepage              |
      | LOGIN | https://www.ebay.com/ |

  Scenario Outline: Checking Facebook link
    Given User opens '<homepage>' page
    When User click on Facebook link
    Then Checking of correct page '<CorrectUrl>'

    Examples:
      | homepage              |CorrectUrl                    |
      | https://www.ebay.com/ |https://www.facebook.com/ebay/|
