import java.io.*;
import java.util.*;

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

  //MAIN//
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    //Declare and Initialize HashMap<key, value> key is name, value is student Object
    Map<String, Student> studentsMap = new HashMap<String, Student>();
    
    //Get file name
    System.out.println("Welcome to grade reader!\n");
    System.out.println("Enter the file name to read: ");
    String fileName = scnr.nextLine();
    
    //Read files
    while(fileName != ""){
      inputFile(fileName+".txt", studentsMap);
      System.out.println("Enter another file name or press Enter to continue: ");
      fileName = scnr.nextLine();
    }
    
    //Print all students to check results
    
    
  }
}