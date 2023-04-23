import java.util.*;
import java.io.*;

class StudentGroup{
  private Map<String, Student> studentsMap;  
  private Map<String, Integer> finalScores;

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
  public void changeScore(int score){
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
  public void addStudent(){
    Scanner scnr = new Scanner(System.in);
    boolean again = false;
    do{
      again = false;
      try{
        System.out.println("ADD A STUDENT");
        System.out.println("Enter the Student Name: ");
        String name = scnr.nextLine();
        nameValidator(name);
        if(studentsMap.containsKey(name)){
          System.out.println("The student already exists");
          again = true;
        }
        else{
          System.out.println("Enter Homework Score: ");
          int h = scnr.nextInt();
          scoreValidator(h);
          System.out.println("Enter Quiz Score: ");
          int q = scnr.nextInt();
          scoreValidator(q);
          System.out.println("Enter Midterm Score: ");
          int m = scnr.nextInt();
          scoreValidator(m);
          System.out.println("Enter Final Exam Score: ");
          int f = scnr.nextInt();
          scoreValidator(f);
          createStudent(name, h, q, m, f);
        }
      }catch(InputMismatchException e){
        System.out.println(e.toString());
        String buffer = scnr.nextLine(); 
        again = true;
      }catch(IllegalArgumentException ee){
        System.out.println(ee.toString());
        again = true;
      }  
    }while(again);
  }

  //Create Student Object, add to Map
  public void createStudent(String name, int h, int q, int m, int f){
    Student tempStudent = new Student(name, h, q, m, h);
    studentsMap.put(name, tempStudent);
    System.out.println("Student Added Successfully!");
    tempStudent.printInfo();
  }

  //Validate name contains only letters
  public boolean nameValidator(String input){
    boolean valid = true;
    for(int i=0; i<input.length(); i++){
      if(!Character.isLetter(input.charAt(i))){
        valid = false;
      }
    }
    if(!valid){
      throw new IllegalArgumentException("Only Letters Accepted");
    }
    return valid;
  }

  //Validate score is greater than 0 and less than 100
  public boolean scoreValidator(int score){
    boolean valid = true;
    if(score < 0 || score > 100){
      valid = false;
    }
    if(!valid){
      throw new IllegalArgumentException("Only Scores (0 - 100) Accepted");
    }
    return valid;
  }

/* Print out the details of one specific student
  - by using Checkstudent(“Olivia”). 
  - If no such student exists, print “no such student exists”
  - otherwise, just print out this student’s scores.
  - If we have already called GetFinalScore and CurveGrade 
  - they need to be printed 
*/
  public void checkStudent(String name){
    if(studentsMap.get(name) == null){
      System.out.println("No Such Student Exists");
    } else {
      Student s = studentsMap.get(name);
      s.printInfo();
    }
  }

  //FOR TESTING: Print all students in the Map
  public void printAll(){
    for(String k : studentsMap.keySet()){
      studentsMap.get(k).printInfo();
    }
  }

/* Method delete details (name and scores) of student. 
  If the student we want to delete does not exist, output 
  "No such student exists"     
*/ 
  public void deleteStudent(String name){
    if(studentsMap.get(name) == null){
      System.out.println("No Such Student Exists");
    } else {
      studentsMap.remove(name);
      System.out.println(name + "Removed Successfully!");
    }
  }

  //file reader helper
  public Character parseHeader(String header) {
    Character type = ' ';
    if (header.toLowerCase().contains("homework")) {
      type = 'H';
    } else if (header.toLowerCase().contains("quiz")) {
      type = 'Q';
    } else if (header.toLowerCase().contains("midterm")) {
      type = 'M';
    } else if (header.toLowerCase().contains("final")) {
      type = 'F';
    }
  }
  
  //File Reader 
  public void inputFile(String input){
    File file = new File(input);  
    try {
      Scanner fileScnr = new Scanner(file);
      String[] headers = fileScnr.nextLine().split("\t");
      int nameIndex = 0;
      for(int i=0; i<headers.length; i++){
        if(headers[i].toLowerCase().contains("name")){
          nameIndex = i;
        }
      }
      while (fileScnr.hasNext()) {  
        String lineJustRead = fileScnr.nextLine(); 
        String[] line = lineJustRead.split("\t"); 
        String name = line[nameIndex];
        Character type = parseHeader(header[i]);
        int score = Integer.parseInt(line[i]);
        for(int i=0; i<headers.length; i++){ 
          if(i == nameIndex) continue;
          if(studentsMap.containsKey(name)){
            studentsMap.get(name).setScore(type, score);
          }
          else{
            Student tempStudent = new Student();
            tempStudent.setName(name);
            tempStudent.setScore(type, score);
            studentsMap.put(name, tempStudent);
          }
        } 
      }
      System.out.println("File Read Successfully!");
      fileScnr.close();
    } catch (FileNotFoundException e) { 
      System.out.println("FILE NOT FOUND: " + e.getMessage());
    }
  }

  
}