import java.io.*;
import java.util.*;

class Main {  

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
    System.out.println("6. Get Final Score");
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
        case '2': { //CHANGE NAME
          students.changeName();
          break;
        }       
        case '3': { //CHANGE SCORE
          students.changeScore();
          break;
        }  
        case '4': { //DELETE STUDENT
          students.deleteStudent();
          break;
        }   
        case '5': { //CHECK STUDENT
          students.checkStudent();
          break;
        }
        case '6': { //GET FINAL SCORE
          students.getFinalScore();
        }
      }
    } else {
      System.out.println("Goodbye!");
    }
  }while(choice != "");
  }
}