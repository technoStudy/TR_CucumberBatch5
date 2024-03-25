Feature: Datatable Örnek

  Scenario: Users List
    When write username "ismet"
    And write username and password "ismet" and "1234"

    And write username as DataTable
      | ismet  |
      | mehmet |
      | Ayşe   |
      | Fatma  |
      | Ulvi   |
      | Esma   |

    And write username and password as DataTable
      | ismet  | 1234   |
      | mehmet | 23232  |
      | Ayşe   | 445454 |
      | Fatma  | 56555  |
      | Ulvi   | 6666   |
      | Esma   | 77777  |

 #  dataProvider (TestNG için), Senaryo Outline (cucumber)
 #  görevi verilen her değer için, tüm senayo çalışır
 #
 #  DataTable ise , sadece bir step e, çoklu parametre vermek
 #  için kullanılır, sadece 1 kez tüm parametreleri stepin içine atar