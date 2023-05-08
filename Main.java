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
    System.out.println("4. Add Score");
    System.out.println("5. Change Score");
    System.out.println("6. Get Final Score");
    System.out.println("7. Check Student");
    System.out.println("8. Curve Grade");
    System.out.println("9. Check All Students");
    System.out.println("0. Run Tests");
    System.out.println("W. Write To File");
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
        case '4': { //ADD SCORE
          students.addScore();
          break;
        }
        case '5': { //CHANGE SCORE
          students.changeScore();
          break;
        }  
        case '6': { //GET FINAL SCORE
          students.getFinalScore();
          break;
        }
        case '7': { //CHECK STUDENT
          students.checkStudent();
          break;
        }
        case '8':{ //CURVE GRADE
          students.curveGrade();
          break;
        }
        case '9': { //PRINT ALL STUDENTS
          students.checkAllStudents();
          break;
        }
        case '0':{ //RUN TESTS
          Test_Student test = new Test_Student();
          test.curveTest1();
          test.curveTest2();
          break;
        }
        case 'W'://PRINT TO FILE
        	case'w':{
        	Print output = new Print();
        	output.outputFile(students.getMap(), students.getGrades());
          break;
        }
      }
    } else {
      System.out.println("Good Bye!");
    }
  }while(choice != "");
  }
}