Feature: check UI elements on Different Elements page

  Scenario: Check UI elements on Different Elements Page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    When I select checkboxes with values:
      | Water |
      | Wind  |
    And I select Selen radio
    And I select Yellow option in dropdown
    Then logs section contains log rows with values:
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |

