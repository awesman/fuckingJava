Feature: Test Cars scenario

  Scenario: Choose first car
    Given Open browser and navigate to page Cars
    When navigate to Research page
    And choose random parameters
    And set Car name year model and navigate to trim comparison
    And set engine and transmission
    Then navigate to main page

  Scenario: Choose second car
    Given open research page
    When choose random parameters
    And set secondCar name year model and navigate to trim comparison
    And set secondCar engine and transmission
    Then navigate to research page

  Scenario: Compare cars
    Given open Side-by-Side Comparisons
    When choose first car and start compare
    And add second car
    Then compare cars




