import java.io.*;
import java.util.*;

class Main {  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Student students = new Student();
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
    String choice = "";
    do{
    System.out.printf("%13s","MENU\n");
    System.out.println("1. Add Student");
    System.out.println("2. Delete Student");
    System.out.println("3. Change Name");
    System.out.println("4. Change Score");
    System.out.println("5. Get Final Score");
    System.out.println("6. Check Student");
    System.out.println("7. Curve Grade");
    System.out.println("8. *GET ALL FINAL SCORES*");
    System.out.println("9. *CHECK ALL STUDENTS*");
    
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
        case '6': { //CHECK STUDENT
          students.checkStudent();
          break;
        }
        case '7':{ //CURVE GRADE
          students.getAllFinalScores();
          students.curveGrade();
        }
        case '8': { //FOR TESTING: CALCULATE ALL FINAL SCORES
          students.getAllFinalScores();
          break;
        }
        case '9': { //FOR TESTING: PRINT ALL STUDENTS
          students.checkAllStudents();
          break;
        }
        case 't':{
          Test_Student test = new Test_Student();
          test.curveTest1();
          test.curveTest2();
        }
      }
    } else {
      System.out.println("Good Bye!");
    }
  }while(choice != "");
  }
}