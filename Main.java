import java.io.*;
import java.util.*;

class Main {  

  //MAIN
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Student students = new Student();
    System.out.println("\nWELCOME TO GRADEBOOK!");
    System.out.println("To Begin, input score files");

    //Read files
    System.out.println("Enter a file name: ");
    String fileName = scnr.nextLine();
    while(fileName != ""){
      students.inputFile(fileName +".txt");
      System.out.println("Enter Another File Or Press Enter to Continue: ");
      fileName = scnr.nextLine();
    }
    
    //Program Menu
    // * indicates that the function is not asked for in the instructions
    // but it makes testing easier or we may want to keep it
    String choice = "";
    do{
    System.out.printf("%13s","MENU\n");
    System.out.println("1. Add Student");
    System.out.println("2. Delete Student");
    System.out.println("3. Change Name");
    System.out.println("4. Change Score");
    System.out.println("5. Get Final Score");
    System.out.println("6. *Calculate All Final Scores*");
    System.out.println("7. Check Student");
    System.out.println("8. *Check All Students*");
    System.out.println("Press Enter to Exit");
    choice = scnr.nextLine();
    if(choice != ""){
      switch(choice.charAt(0)){
        case '1': { //ADD STUDENT
          students.addStudent();
          break;
        }
        case '2': { //DELETE STUDENT
          students.deleteStudent();
          break;
        } 
        case '3': { //CHANGE NAME
          students.changeName();
          break;
        }     
        case '4': { //CHANGE SCORE
          students.changeScore();
          break;
        }  
        case '5': { //GET FINAL SCORE
          students.getFinalScore();
          break;
        }
        case '6': { //FOR TESTING: CALCULATE ALL FINAL SCORES
          students.calcAllFinalScores();
          break;
        }
        case '7': { //CHECK STUDENT
          students.checkStudent();
          break;
        }
        case '8': { //FOR TESTING: PRINT ALL STUDENTS
          students.checkAllStudents();
          break;
        }
      }
    } else {
      System.out.println("Thank you for using GRADEBOOK!");
    }
  }while(choice != "");
  }
}