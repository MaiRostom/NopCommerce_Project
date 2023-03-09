@smoke
Feature:Select random categories
  Scenario: Select random categories
    When user select random category
    And  user hover on the selected category with index 1
    And  user get the text of subcategory and click on it
    And  check the title of the category page
