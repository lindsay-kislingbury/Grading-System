import java.io.*;
import java.util.*;
/*
Possible Exception Handling:
 if students’ scores are (less than) <0 and  (greater than)>100,IllegalArgumentException occurs. Please keep asking for the new input if those exceptions happen.
*/
class Main {  
  //File Reader Method
  public static void inputFile(String input, Map<String, Student> studentsMap){
    File file = new File(input);  
    try {
      Scanner fileScnr = new Scanner(file);

      //Store headings in array. Determine index of Name
      String[] headers = fileScnr.nextLine().split("\t");
      int nameIndex = 0;
      for(int i=0; i<headers.length; i++){
        if(headers[i].toLowerCase().contains("name")){
          nameIndex = i;
        }
      }

      //Loop through remaining lines
      //If student already exits, add scores
      //Otherwise, create new student and add scores
      while (fileScnr.hasNext()) {  
        String lineJustRead = fileScnr.nextLine(); 
        String[] line = lineJustRead.split("\t"); 
        String name = line[nameIndex];
        for(int i=0; i<headers.length; i++){ 
          if(i == nameIndex) continue;
          if(studentsMap.containsKey(name)){
            studentsMap.get(name).addScore(headers[i], Integer.parseInt(line[i]));
          }
          else{
            Student tempStudent = new Student(name);
            tempStudent.addScore(headers[i], Integer.parseInt(line[i]));
            studentsMap.put(name, tempStudent);
          }
        } 
      }
      
      fileScnr.close();
    } catch (FileNotFoundException e) { //TODO: more exceptions? different kind?
      e.printStackTrace();
    }
  }

/* Method - AddStudent - add details (name and scores).
   If student already exists, then print out the message
   "The student already exists."
   Possible Exception Handling:
One example is IllegalArgumentException. This exception occurs when we design the method AddStudent, and the student’s name is Olivia3 which contains digits and can not be a valid name.
*/ 
public void AddStudent() {
    
  }
/* Method - DeleteStudent - delete details (name and               scores) of a student. If the student we want to 
   delete does not exist, output "No such student exists"     
*/ 
public void DeleteStudent() {

  }
  

  //MAIN//
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    //Declare and Initialize HashMap<key, value> key is name, value is student Object
    Map<String, Student> studentsMap = new HashMap<String, Student>();

      System.out.println("GRADE CALCULATOR");
      for(int i=0; i<16; i++){
        System.out.printf("-");
      }
      System.out.println();
      
      System.out.println("Enter a file name: ");
      String fileName = scnr.nextLine();
      //Read files
      while(fileName != ""){
        inputFile(fileName+".txt", studentsMap);
        System.out.println("File read successfully!");
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
          case '0': for(String k : studentsMap.keySet()){
                      studentsMap.get(k).printInfo();
                    }
                    break;
          case '1': System.out.println("TODO: addStudent\n");
                    break;
          case '2': System.out.println("TODO: changeName\n");
                    break;
          case '3': System.out.println("TODO: changeScore\n");
                    break;
          case '4': System.out.println("TODO: deleteStudent\n");
                    break;
          case '5': System.out.println("TODO: checkStudent\n");
                    break;
        }
      } else {
        System.out.println("Goodbye!");
      }
    }while(choice != "");

    
  }
}