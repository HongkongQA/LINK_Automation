Feature: LINK_search
  open linkreit web page, Search content

  Scenario: Search hongkong
    Given Go to linkreit home
    When I find search button
    And  Type the search text "hongkong"
    And Click the submit
    Then Wait the query result



