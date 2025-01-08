
Feature: Navigation bar
    To see the subpages
    without logging in
    I can click the navigation bar links

    Background: I am on the Free Range Testers web without logging in.
        Given I navigate to www.freerangetesters.com

Scenario Outline: I can access the subpages through the navigation bar
    When I go to <section> using the navigation bar
    Examples:
        | section   | 
        | Cursos    |
        | Recursos  |
        | Udemy     |
        | Mentorías |
        | Blog|

Scenario: Courses are presented correctly to potencial customers
    When I go to Cursos using the navigation bar
    And Select Introducción al Testing
    Then Introducción al Testing de Software page loads correctly


Scenario: Users can select a plan when signin up   
    When I select Elegir plan
    Then I can validate the options in the checkout page


    

    

