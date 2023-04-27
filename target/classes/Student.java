import java.util.*;
import java.io.*;

public class Student {

  private Map<String, HashMap<String, Integer>> studentsMap;

  public Student(){
    studentsMap = new HashMap<String, HashMap<String, Integer>>();
  }

  //FILE READER 
  public void inputFile(String input){
    File file = new File(input);  
    try {
      Scanner fileScnr = new Scanner(file);
      String[] headers = fileScnr.nextLine().split("\t");
      int nameIndex = 0;
      for(int i=0; i<headers.length; i++){
        if(headers[i].toLowerCase().contains("name")){
          nameIndex = i;
        }
      }
      while (fileScnr.hasNext()) {  
        String[] line = fileScnr.nextLine().split("\t"); 
        String name = line[nameIndex];
        String type = "";
        int score = 0;
        for(int i=0; i<headers.length; i++){ 
          if(i == nameIndex) continue;
          if(headers[i].contains("homework")) {
            type = "Homework";
            score = Integer.parseInt(line[i]);
          } else if (headers[i].contains("quiz")) {
            type = "Quiz";
            score = Integer.parseInt(line[i]);
          } else if (headers[i].contains("midterm")) {
            type = "Midterm";
            score = Integer.parseInt(line[i]);
          } else if (headers[i].contains("final")) {
            type = "FinalExam";
            score = Integer.parseInt(line[i]);
          }
          if(studentsMap.get(name) != null){
            studentsMap.get(name).put(type, score);
          }
          else{
            Map tempScore = new HashMap<String, Integer>();
            tempScore.put(type, score);
            HashMap tempStudent = new HashMap<String, HashMap<String, Integer>>();
            tempStudent.put(name, tempScore);
            studentsMap.put(name, tempStudent);
          }
        }
      }
      fileScnr.close();
    } catch (FileNotFoundException e) { 
      System.out.println(e.getMessage());
    }
  }

  //CHECK STUDENT
  public void checkStudent(String name){
    System.out.println(studentsMap.get(name));
  }

  //FOR TESTING. PRINT ALL
  public void printAll(){
    for(String k : studentsMap.keySet()){
      checkStudent(k);
    }
  }

  //ADD STUDENT
  public void addStudent(){
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    String name = "";
    int h=0, m=0, q=0, f=0;
    do{
      System.out.println("\nADD STUDENT");
      try{
        System.out.println("Enter Student Name: ");
        name = scnr.nextLine();
        nameValidator(name);
        System.out.println("Enter Homework Score: ");
        h = scnr.nextInt();
        scoreValidator(h);
        System.out.println("Enter Midterm Score: ");
        m = scnr.nextInt();
        scoreValidator(m);
        System.out.println("Enter Quiz Score: ");
        q = scnr.nextInt();
        scoreValidator(q);
        System.out.println("Enter Final Exam Score: ");
        f = scnr.nextInt();
        scoreValidator(f);
        valid = true;
      }catch(InputMismatchException e){
        String buffer = scnr.nextLine();
        System.out.println(e.toString() + ": Only Integers Accepted");
      }catch(IllegalArgumentException ee){
        System.out.println(ee.toString());
      }  
    }while(!valid);
  }

  //NAME VALIDATION
  public void nameValidator(String name){
    for(int i=0; i<name.length(); i++){
      if(!Character.isLetter(name.charAt(i))){
        throw new IllegalArgumentException("Only Letters Accepted");
      }
    }
  }

  //SCORE VALIDATION
  public void scoreValidator(int score){
    if(score < 0 || score > 100){
      throw new IllegalArgumentException("Only Scores (0 - 100) Accepted");
    }
  }

  

  /*
  private String name;
  private Map<String, Integer> scores;
  private double finalGrade;

  // Default Constructor
  public Student() {
    this.name = "empty";
    scores = new HashMap<String, Integer>();
  }

  public Student(String name){
    this.name = name;
    scores = new HashMap<String, Integer>();
  }

  // Non-Default Constructor
  public Student(String name, int h, int q, int m, int f) {
    this.name = name;
    scores = new HashMap<String, Integer>();
    scores.put("Homework", h);
    scores.put("Quiz", q);
    scores.put("Midterm", m);
    scores.put("FinalExam", f);
  }

  //Set Name
  public void setName(String name){
    this.name = name;
  }

  public void setScore(String type, int score){
    scores.put(type, score);
  }

  public boolean checkScore(String type){
    return scores.containsKey(type);
  }

  public void setFinalGrade(){
    double hw = scores.get("Homework")*0.2;
    double quiz = scores.get("Quiz")*0.3;
    double midterm = scores.get("Midterm")*0.2;
    double finalExam = scores.get("FinalExam")*0.3;
    finalGrade =  hw + quiz + midterm + finalExam;
  }

  // Equals Method compares student by name
  public boolean equals(Student s) {
    if (this.name.equals(s.name))
      return true;
    else
      return false;
  }
 
  // Print
  public void printInfo() {
    System.out.println(name);
    System.out.println("Homework: " + scores.get("Homework"));
    System.out.println("Quiz: " + scores.get("Quiz"));
    System.out.println("Midterm: " + scores.get("Midterm"));
    System.out.println("Final Exam: " + scores.get("FinalExam"));
    System.out.println("FINAL SCORE: " + scores.get("FinalScore"));
    System.out.println();
  }
  */
  
}
