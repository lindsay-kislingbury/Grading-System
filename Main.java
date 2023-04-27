import java.io.*;
import java.util.*;

class Main {  
  /*
  

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
*/

  //MAIN
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Student students = new Student();
    System.out.println("GRADE CALCULATOR");

    //Read files
    System.out.println("Enter a file name: ");
    String fileName = scnr.nextLine();
    while(fileName != ""){
      students.inputFile(fileName +".txt");
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
        case '0': { //FOR TESTING: PRINT ALL STUDENTS
          students.printAll();
          break;
        }
        case '1': { //ADD STUDENT
          students.addStudent();
          break;
        }
        case '2': {
          System.out.println("TODO: CHANGE NAME");
          //students.changeName();
          break;
        }       
        case '3': {
          System.out.println("TODO: changeScore()");
          //students.changeScore();
          break;
        }  
        case '4': { //DELETE STUDENT
          System.out.println("TODO: deleteStudent()");
          //students.deleteStudent();
          break;
        }   
        case '5': { //CHECK STUDENT
          System.out.println("TODO: checkStudent()");
          //students.checkStudent();
          break;
        }        
      }
    } else {
      System.out.println("Goodbye!");
    }
  }while(choice != "");
  }
}