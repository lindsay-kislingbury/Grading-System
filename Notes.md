TODO:
----   

1. changeScore() function in main
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
2. Need to calculate final score and curve grades. How does she want this output?
3. 

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

REQUIREMENTS:
----   
✅=completed,  ❌=not completed

1. **importFile()** ✅
   -  ✔ Read the text files that contain student names and scores
   -  ✔ Use this method repeatedly to read multiple text files and store the information correctly
   - 	✔ Every file must have student names. But students’ names may be different in each file.
   - ✔ The order of students’ names in each file may be different.
   - ✔ The 1st file has the student name Gabrielle, but other files do not have this name.
   - ✔ We do not know what types of scores are contained in the text file. A file may have any one of those four types of scores
   - ✔ Parse the content in the text file's first line to know what types of scores it has
   - ✔ If a file has multiple types of scores, their order in the text file is also not fixed
   - ✔ If you can make your program handle repeated score types, you will get extra credits.

2. **addScore()** ✅
  - ✔ Add the new score of one specific student
  - ✔ If the score we want to add already exists, print  “the score already exists.”

3. **addStudent()** ✅
  - ✔ Add the details of the new student (like name and scores achieved). If the student we want to add already exists, print “the student already exists.”

4. **deleteStudent()** ✅
  - ✔ Delete the details of the new student (like name and scores achieved). If the student we want to delete does not exist, print “no such student exists.”

5. **changeName** ❌
  - Change an existing student’s name.
  - If the name we want to change does not exist, print “no such student exists”; otherwise, we just change it.

6. **changeScore**
  - ✔ Change one existing score.
  - ✔ If the score we want to change does not exist, print “no such score exists” otherwise, we just change it.

7. **getFinalScore** ❌
   - Get the final score according to the following grading policy and store it into the array/list that contains all scores:   
      ```
      Assessment  %  
      Quiz        20   
      Homework    30   
      Midterm     20   
      Final exam  30
      ```
   - Ensure that you have all scores of quizzes, homework, midterm, and final exam for all students.
   - If you have all scores, just calculate the final score; otherwise, notify which scores are missing and ask for input from the keyboard
   - Those kinds of operations will be repeated until we get all the scores. Then calculate the final score.

8. **curveGrade**
  - Curve the final score according to the following criteria and store it into the array/list that contains all scores
    ```
    Top 10%      A
    Top 20%-10%  B
    Top 30%-20%  C
    Top 40%-30%  D
    Top 100%-40% F
    ```

9. ✅ **checkStudent**
  - ✔ Print out the details of one specific student, i.e., Olivia, by using Checkstudent(“Olivia”)
  -  ✔ If no such student exists, print “no such student exists”; otherwise, just print out this student’s scores.
  -  ✔ If we have already called GetFinalScore and CurveGrade to calculate the final and curved scores, they also need to be printed out.

10. handle all possible exceptions
  - ✔ IllegalArgumentException. This exception occurs when we design the method AddStudent, and the student’s name is Olivia3 which contains digits and can not be a valid name. Similarly, if students’ scores are <0 and >100, IllegalArgumentException occurs. Please keep asking for the new input if those exceptions happen.

11. ❌ One new feature




EXTRA POINTS:   
----   
1. if your program is more flexible and comprehensive, you will get higher points