import java.util.*;
import java.io.*;

class StudentGroup{
  private Map<String, Student> studentsMap;  

  //Constructor: Create Hashmap
  public StudentGroup(){
    studentsMap = new HashMap<String, Student>();
  }

  
  // Add a score (FROM USER AT KEYBOARD)
  //TODO: If the score we want to add already exists,
  //EG: ONLY PRINT THE NOTIFICATION IF THE NEW SCORE IS THE SAME AS THE OLD SCORE
  //print out the notification “the score already exists.” 
  public void addScore(){
    //call Student.setScore() method
  }

    /* CHANGE NAME
   - Change an existing student’s name. 
   - If the name we want to change does not exist, 
   - print “no such student exists”; otherwise, we just change it.
  */
  public void changeName(){
    //call Student.setName()
  }

   /*CHANGE SCORE
   - Change one existing score. 
   - If the score we want to change does not exist, print “no such score exists” 
   - otherwise, we just change it. 
   - For example, we want to change the student Olivia’s score 
   - for the final exam to 65. If we already have the record 
   - of Olivia’s score for the final exam, just change it; otherwise, 
   - print “no such score exists.”
  */
  public void changeScore(String name, int score){
    //call Student.setScore()
  }

   /* Curve the final score according to the following criteria 
    and store it into the array/list that contains all scores:
    Top 10%-------------------A
    Top 20%-10%------------B
    Top 30%-20%------------C 
    Top 40%-30%------------D 
    Top 100%-40%----------F
  */
  public void curveGrade(){}
  
  /* Get the final score according to the following grading
  - policy and store it into the array/list that contains all scores 
  - ensure you have all scores of quizzes, homework, midterm, and final exam 
  - notify which scores are missing and ask for input from the keyboard
  */
  public int getFinalScore(){
    //call curve grade method to curve the grade
    int finalScore = 0;
    return finalScore;
  }

  /* Add details (name and scores).
   - If student already exists print "The student already exists."
   - Possible Exception Handling: IllegalArgumentException occurs 
   - when the student’s name is Olivia3 which contains digits and 
   - can not be a valid name.
   - Possible Exception Handling: if students’ scores are (less than) <0
   - and (greater than)>100 IllegalArgumentException occurs. 
   - Please keep asking for the new input if those exceptions happen.
  */
  //ADD STUDENT
  public void addStudent(String name, int h, int q, int m, int f){
    if(studentsMap.get(name) == null){
      System.out.println("The student " + name + " already exists");
    }
    else{
      Student tempStudent = new Student(name, h, q, m, f);
      studentsMap.put(name, tempStudent);
    } 
  }

  //NAME VALIDATION
  public void nameValidator(String input){
    boolean valid = true;
    for(int i=0; i<input.length(); i++){
      if(!Character.isLetter(input.charAt(i))){
        valid = false;
      }
    }
    if(!valid){
      throw new IllegalArgumentException("Only Letters Accepted");
    }
  }

  //SCORE VALIDATION
  public void scoreValidator(int score){
    boolean valid = true;
    if(score < 0 || score > 100){
      valid = false;
    }
    if(!valid){
      throw new IllegalArgumentException("Only Scores (0 - 100) Accepted");
    }
  }

  //DELETE STUDENT
  public void deleteStudent(String name){
    if(studentsMap.get(name) != null){
      studentsMap.remove(name);
    } else {
      System.out.println("No Such Student Exists");
    }
  }
  
  //PRINT ALL
  public void printAll(){
    for(String k : studentsMap.keySet()){
      studentsMap.get(k).printInfo();
    }
  }

  //CHECK STUDENT
  public void checkStudent(String name){
    if(studentsMap.get(name) != null){
      studentsMap.get(name).printInfo();
    } else {
      System.out.println("No Such Student Exists");
    }
  }
  
  
}