Feature: Test
  Scenario Outline: testing
    Given open webdriver
    And I navigate to <URL>
    And I enter text <TEXT> on <ELEMENT> in <PAGE>
    And I click on <ELEMENT1> in <PAGE>
    And I click on <ELEMENT2> in <PAGE1>
    And I click on <ELEMENT3> property
    And I click on <ELEMENT4> property

    Examples:
    |URL| ELEMENT | PAGE| TEXT | ELEMENT1 | PAGE1|ELEMENT2| ELEMENT3 | ELEMENT4|
    |https://www.amazon.com| searchbox | MainPage| test| searchicon| PageTwo | sort| Todays Deals| Amazon Devices|