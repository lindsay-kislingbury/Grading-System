import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<Student>(); 

    //TODO: make this a function where user can enter file name
    //and can be called multiple times
    File file = new File("quizmidtermScores.txt");  
    
    try {
      Scanner fileScnr = new Scanner(file);
      
      /* first line is the headers. 
      *  read the line into an array of Strings, 
      *  using \t (tab) whitespace as the delimiter
      */
      String[] headers = fileScnr.nextLine().split("\t");
      
      /* loop through the rest of the data. store in student objects
      *  reads in one line at a time. splits the whole line into an array
      */ 
      String[] line;
      Character type = ' ';
      int score = 0;
      String name = "";
      while (fileScnr.hasNext()) { //keep looping until no more lines to read   
        String lineJustRead = fileScnr.nextLine(); //store the line just read in
        line = lineJustRead.split("\t"); //split the line into an array of Strings
        
        for(int i=0; i<headers.length; i++){ //for the # of columns(headers) i
          if(headers[i].contains("Name")){   
            name = line[i];
          }
          else if(headers[i].contains("quiz")){
            type = 'Q';
            score = Integer.parseInt(line[i]);
          }
          else if(headers[i].contains("midterm")){
           type = 'M';
           score = Integer.parseInt(line[i]);
          }
          else if(headers[i].contains("final")){
            type = 'F';
            score = Integer.parseInt(line[i]);
          }
          /* Check if the student already exits in the array
          *  if they do, add score. Otherwise, create new Student
          *  there are weird rules about arraylists. Can't add to it while
          *  iterating through it - that's why this is weird. 
          *  Better solution?
          */
          boolean exists = false;
          if(!students.isEmpty()){
            for(Student s : students){
              if(s.equals(name)){
                s.addScore(type, score);
                exists = true;
              }
            }
          }
          if(!exists){
            Student tempStudent = new Student(name);
            tempStudent.addScore(type, score);
            students.add(tempStudent);
          }
        }
      }
      fileScnr.close();
    } catch (FileNotFoundException e) { //TODO: more exceptions? different kind?
      e.printStackTrace();
    }
    
    //Print Array of Students
    for(Student s : students){ s.printInfo(); }

  }
}