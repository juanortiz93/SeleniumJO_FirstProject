Feature: Validate a name is on a list

@Test
Scenario: As a Test Engineer, I want to validate that a text is present inside the list
    
        Given I navigate to the list page
        When I search the list
        Then I can finde the text in the list