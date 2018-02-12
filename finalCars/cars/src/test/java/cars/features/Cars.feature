Feature: Test Cars scenario

  Scenario: Test Car.com
    Given main page open
    When user click on menu tab 'Research'
        And fill search fields with random characteristics
    Then user navigate trims -> compare
        And save car patameters and navigate main page
    When user click on menu tab 'Research'
        And fill search fields with random characteristics
    Then user navigate trims -> compare
        And save car patameters and navigate main page
    When user click on menu tab 'Research'
    Then open reseach page and navigate Side-by-Side
    When open compare page and add cars
    Then open result page and compare cars





