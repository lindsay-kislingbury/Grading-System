import java.io.*;
import java.util.*;

class Main {  
  public static void main(String[] args) {
    Map<String, Student> studentsMap = new HashMap<String, Student>();

    //TODO: make this a function where user can enter file name
    //and can be called multiple times
    File file = new File("quizmidtermScores.txt");  
    try {
      Scanner fileScnr = new Scanner(file);
      String[] headers = fileScnr.nextLine().split("\t");
      String[] line;
      Character type = ' ';
      int score = 0;
      String name = "";
      while (fileScnr.hasNext()) {  
        String lineJustRead = fileScnr.nextLine(); 
        line = lineJustRead.split("\t"); 

        //loop through the rest of the data and store in the correct attribute
        for(int i=0; i<headers.length; i++){ 
          if(headers[i].toLowerCase().contains("name")){   
            name = line[i];
          }
          else if(headers[i].toLowerCase().contains("quiz")){
            type = 'Q';
            score = Integer.parseInt(line[i]);
          }
          else if(headers[i].toLowerCase().contains("midterm")){
           type = 'M';
           score = Integer.parseInt(line[i]);
          }
          else if(headers[i].toLowerCase().contains("final")){
            type = 'F';
            score = Integer.parseInt(line[i]);
          }

          //if student exists, add score
          //otherwise, add new student
          if(studentsMap.containsKey(name)){
            studentsMap.get(name).addScore(type, score);
          }
          else{
            Student tempStudent = new Student(name);
            tempStudent.addScore(type, score);
            studentsMap.put(name, tempStudent);
          }
        }
      }
      fileScnr.close();
    } catch (FileNotFoundException e) { //TODO: more exceptions? different kind?
      e.printStackTrace();
    }

    //Print all students to check results
    for(String name : studentsMap.keySet()){
      studentsMap.get(name).printInfo();
    }
  }
}