Feature: BookCart Application tests

  @test
  Scenario Outline: Add to cart
    And user login into the application with "<username>" and "<password>"
    And user search for a "<book>"
    When user add the book to the cart
    Then the cart badge should be updated

    @regression
    Examples: 
      | username | password | book            |
      | ortoni   | Pass1234 | Roomies         |
      | ortonikc | Pass1234 | The Simple Wild |

    @test
    Examples: 
      | username | password | book    |
      | ortoni   | Pass1234 | Roomies |
