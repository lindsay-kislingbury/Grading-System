import java.io.*;
import java.util.*;

class Main {  
  /*
  //ADD STUDENT
  public static void addStudent(Map<String, Student> studentsMap){
    Scanner scnr = new Scanner(System.in);
    boolean again = false;
    do{
      again = false;
      System.out.println("ADD STUDENT");
      try{
        System.out.println("Enter the Student Name: ");
        String name = nameValidator();
        if(studentsMap.get(name) != null){
          System.out.println("Student Already Exists");
          again = true;
          continue;
        }
        System.out.println("Enter Homework Score: ");
        int h = scoreValidator();
        System.out.println("Enter Quiz Score: ");
        int q = scoreValidator();
        System.out.println("Enter Midterm Score: ");
        int m = scoreValidator();
        System.out.println("Enter Final Exam Score: ");
        int f = scoreValidator();
        Student tempStudent = new Student(name, h, q, m, f);
        studentsMap.put(name, tempStudent);
        System.out.println("\nStudent Created!");
        studentsMap.get(name).printInfo();
      }catch(InputMismatchException e){
        System.out.println(e.toString() + ": Only Integers Accepted");
        again = true;
      }catch(IllegalArgumentException ee){
        System.out.println(ee.toString());
        again = true;
      }  
    }while(again);
  }


  //NAME VALIDATION
  public static String nameValidator(){
    Scanner scnr = new Scanner(System.in);
    String name = scnr.nextLine();
    boolean valid = true;
    for(int i=0; i<name.length(); i++){
      if(!Character.isLetter(name.charAt(i))){
        valid = false;
      }
    }
    if(!valid){
      throw new IllegalArgumentException("Only Letters Accepted");
    }
    return name;
  }

  //SCORE VALIDATION
  public static int scoreValidator(){
    Scanner scnr = new Scanner(System.in);
    int score = scnr.nextInt();
    boolean valid = true;
    if(score < 0 || score > 100){
      valid = false;
    }
    if(!valid){
      throw new IllegalArgumentException("Only Scores (0 - 100) Accepted");
    }
    return score;
  }

  //DELETE STUDENT
  public static void deleteStudent(Map<String, Student> studentsMap){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Student Name: ");
    String name = scnr.nextLine();
    if(studentsMap.get(name) != null){
      studentsMap.remove(name);
    } else {
      System.out.println("No Such Student Exists");
    }
  }
  
  //PRINT ALL
  public static void printAll(Map<String, Student> studentsMap){
    for(String k : studentsMap.keySet()){
      studentsMap.get(k).printInfo();
    }
  }

  //CHECK STUDENT
  public static void checkStudent(Map<String, Student> studentsMap){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Student Name: ");
    String name = scnr.nextLine();
    if(studentsMap.get(name) != null){
      studentsMap.get(name).printInfo();
    } else {
      System.out.println("No Such Student Exists");
    }
  }

  //CHANGE SCORE
  public static void changeScore(Map<String, Student> studentsMap){
    Scanner scnr = new Scanner(System.in);
    boolean again = false;
    do{
      System.out.println("CHANGE SCORE");
      again = false;
      try{
        System.out.println("Enter Student Name: ");
        String name = nameValidator();
        if(studentsMap.get(name) != null){
          System.out.println("Which Score?\n");
          System.out.println("1. Homework\n2. Quiz\n3. Midterm\n4. Final Exam");
          Character choice = scnr.nextLine().charAt(0);
          System.out.println("Enter the New Score: ");
          int score = scoreValidator();
          String type = "";
          switch(choice){
            case '1': type = "Homework";
              break;
            case '2': type = "Quiz";
              break;
            case '3': type = "Midterm";
              break;
            case '4': type = "Final Exam";
              break;
          }
          if(studentsMap.get(name).checkScore(type)){
            studentsMap.get(name).setScore(type, score);
          } else {
            System.out.println("No Such Score Exists");
          }
        } else {
          System.out.println("No Such Student Exists");
        }
      } catch(InputMismatchException e) {
        System.out.println(e.toString()+ ": Only Integers Accepted");
        again = true;
      } catch(IllegalArgumentException ee) {
        System.out.println(ee.toString());
        again = true;
      }
    }while(again);
  }


  //CHANGE NAME
  /*
  - Change an existing student’s name.
  - If the name we want to change does not exist, print “no such student exists”; otherwise, we just change it.
  */
  /*
  public static void changeName(Map<String, Student> studentsMap){
    //**missing name input. need to declare and accept name from scnr. then pass to setName
    Scanner scnr = new Scanner(System.in);
    
    boolean again = false;
    do{
      System.out.println("CHANGE NAME");
      again = false;
      try{
       System.out.println("Enter Name of Student to Change:");
        String oldName = scnr.nextLine();
          if(studentsMap.get(oldName) != null){
            System.out.println("Enter the new name: ");
            String newName = nameValidator();
            studentsMap.get(oldName).setName(newName);
          } 
         else {
          System.out.println("No Such Student Exists");
        }
      } catch(IllegalArgumentException ee) {
        System.out.println(ee.toString());
        again = true;
      }
    }while(again);
    
  //use Map function Map.get(name) to return the correct student
  //call Student.setName(newName) to set name
  //use nameValidator() function to validate new name. 
  //the function takes no arguments, 
  //uses its own scanner to take input and returns a string
      //String newName = nameValidator()
      //this function throws a IllegalArgumentException which you need to catch
      //when you catch the exception, 
      //use System.out.println(ee.toString()) to print the message
      //REFER TO changeScore function. should be similear 
    
  }
*/

  //MAIN
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Student students = new Student();
    students.inputFile("scores1.txt");
    students.printAll();
    students.addStudent();
/*
      System.out.println("GRADE CALCULATOR");

      //Read files
      System.out.println("Enter a file name: ");
      String fileName = scnr.nextLine();
      while(fileName != ""){
        inputFile(fileName +".txt", studentsMap);
        System.out.println("Enter Another File Or Press Enter to Continue: ");
        fileName = scnr.nextLine();
      }
    
      //Program Menu
      String choice = "";
      do{
      System.out.println("MENU");
      System.out.println("0. FOR TESTING. PRINT ALL SCORES");
      System.out.println("1. Add Student");
      System.out.println("2. Change Name");
      System.out.println("3. Change Score");
      System.out.println("4. Delete Student");
      System.out.println("5. Check Student");
      System.out.println("Press Enter to Exit");
      choice = scnr.nextLine();
      if(choice != ""){
        switch(choice.charAt(0)){
          case '0': { //PRINT ALL STUDENTS
            printAll(studentsMap);
            break;
          }
          case '1': { //ADD STUDENT
            addStudent(studentsMap);
            break;
          }
          case '2': {
            System.out.println("TODO: CHANGE NAME");
            changeName(studentsMap);
            break;
          }       
          case '3': {
            changeScore(studentsMap);
            break;
          }  
          case '4': { //DELETE STUDENT
            deleteStudent(studentsMap);
            break;
          }   
          case '5': { //CHECK STUDENT
            checkStudent(studentsMap);
            break;
          }        
        }
      } else {
        System.out.println("Goodbye!");
      }
    }while(choice != "");
`*/
  }
}