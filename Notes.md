TODO: WAIT UNTIL AFTER MEETING WITH PROF
----   

- changeScore() function in main
  - Declare Scanner object inside this function to take input
  - use Map function Map.get(name) to return the correct student.
  - call Student.setName(newName) to set name
  - dont worry about validation until it's working as expected.
  - nameValidator() function is already created in main.
    - It takes no arguments, uses it's own scanner to take the input and returns the string.
      -   `String name = inputValidator();`
    -   It throws an IllegalArgumentMistmatch excpeption which you need to catch and print it's message
      -   `System.out.println(e.toString());`
  - **REFER TO changeScore METHOD** which is similar. This function will be simpiler because you dont need to ask more info. just need to get the name


COMMENTS:    
----
- Right now, there is main menu for quick testing of important functions. For the final submission, we could make this conform to what prof wants for output (???)
- addStudent() method is complete. try entering invalid values. Should be pretty bulletproof.
- Content of files scores1, scores2, scores3:
  - **scores1**: Points for quiz, points for homework
  - **scores2**: Points for final exam
  - **scores3**: Points for midterm, Points for make-up midterm
    (Extra points for handling repeated score type)
    (Extra points for flexibility, the heading "Points for make-up midterm"
    doesn't follow the naming convention)

IDEAS:    
----
- create a Unit Test Class. This would fulfill the "extra feature" for the last requirement of the project. The instructions also ask us to list our test cases.
  - We could follow best practices for creating a Test Class here:
    https://www.baeldung.com/java-unit-testing-best-practices
