import java.io.*;
import java.util.*;

class Main {  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    StudentGroup group = new StudentGroup();

      System.out.println("GRADE CALCULATOR");
      for(int i=0; i<16; i++){
        System.out.printf("-");
      }
      System.out.println();

      //Read files
      System.out.println("Enter a file name: ");
      String fileName = scnr.nextLine();
      while(fileName != ""){
        group.inputFile(fileName +".txt");
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
          case '0': group.printAll();
                    break;
          case '1': group.addStudent();
                    break;
          case '2': System.out.println("TODO: changeName\n");
                    break;
          case '3': System.out.println("TODO: changeScore\n");
                    break;
          case '4': System.out.println("TODO: deleteStudent\n");
                    break;
          case '5': System.out.println("Enter Student Name: ");
                    String name = scnr.nextLine();
                    group.checkStudent(name);
                    break;
        }
      } else {
        System.out.println("Goodbye!");
      }
    }while(choice != "");

  }
}