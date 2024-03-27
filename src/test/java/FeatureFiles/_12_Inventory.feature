#Senaryo :
#  Inventory Bölümündeki
#  Item Categories Çalışmasını test ediniz
#  girişi yapıp , sonrasında silmesini yapınız

Feature: Inventory functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create Inventory and Delete
    And Click on the Element in LeftNav
      | inventory      |
      | setupInventory |
      | inventoryCat   |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | userType |
      | <type>   |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name   | type          |
      | isInv1 | student       |
      | isInv2 | administrator |
      | isInv3 | student       |
      | isInv4 | administrator |
      | isInv5 | student       |
