Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | ismetUlk19 |
      | codeInput | isKod11    |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

#    And User delete the Element from Dialog
#      | ismetUlk19 |

#    Then Success message should be displayed

  Scenario: CitizenShip Create and Delete
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | citizenship  |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | isSCUlk19 |
      | shortName | isSC1    |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | isSCUlk19 |

    Then Success message should be displayed







