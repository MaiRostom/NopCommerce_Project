@smoke
Feature: Search for a product
  Scenario Outline: user search for a product
    When user write the product name <product name> in search bar
    Then a page contains all product name appears
    Examples:
    |product name|
    |"book"|
    |"laptop"|
    | "nike"|

    Scenario Outline: user search using SKU
      When user write sku of the product  in search bar <product sku>
      Then verify that the item of that sKU is opened successfully
Examples:
      |product sku|
      |"AP_MBP_13"|
      |"SCI_FAITH"|
     |"APPLE_CAM"|
      |"SF_PRO_11"|

