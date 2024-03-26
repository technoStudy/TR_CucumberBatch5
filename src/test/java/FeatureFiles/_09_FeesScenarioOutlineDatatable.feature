Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality and Delete
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the Element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name      | code | intCode  | priority |
      | ism2Fee21 | 23941 | PayPal   | 42431     |
      | ism2Fee22 | 23942 | Cash     | 42432     |
      | ism2Fee23 | 23943 | Cheque   | 42433     |
      | ism2Fee24 | 23944 | ApplaPay | 42434     |
      | ism2Fee25 | 23945 | Crypto   | 42435     |