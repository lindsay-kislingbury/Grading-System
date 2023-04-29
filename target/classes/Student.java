import java.util.*;
import java.io.*;

public class Student {
  private Map<String, HashMap<String, Double>> studentsMap;
  private Map<String, Double> weights;

  public Student(){
    studentsMap = new HashMap<String, HashMap<String, Double>>();
    weights = new HashMap<String, Double>();
    weights.put("Homework", 0.3);
    weights.put("Quiz", 0.2);
    weights.put("Midterm", 0.2);
    weights.put("Final Exam", 0.3);
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
        double score = 0;
        for(int i=0; i<headers.length; i++){ 
          if(i == nameIndex) continue;
          if(headers[i].contains("homework")) {
            type = "Homework";
            score = Double.parseDouble(line[i]);
          } else if (headers[i].toLowerCase().contains("quiz")) {
            type = "Quiz";
            score = Double.parseDouble(line[i]);
          } else if (headers[i].toLowerCase().contains("midterm")) {
            type = "Midterm";
            score = Double.parseDouble(line[i]);
          } else if (headers[i].toLowerCase().contains("final")) {
            type = "Final Exam";
            score = Double.parseDouble(line[i]);
          }
          //camel case name to prevent errors later
          name = camelCase(name);
          if(studentsMap.get(name) != null){
            studentsMap.get(name).put(type, score);
          } else {
            HashMap<String, Double> temp = new HashMap<String, Double>();
            studentsMap.put(name, temp);
            studentsMap.get(name).put(type, score);
          }
        }
      }
      fileScnr.close();
    } catch (FileNotFoundException e) { 
      System.out.println(e.getMessage());
    }
  }

  //CAMEL CASE NAME [helper for fileReader, addStudent, changeName, changeScore, checkStudent]
  public String camelCase(String input){
    String output = input.toLowerCase();
    output = output.substring(0, 1).toUpperCase() + output.substring(1);
    return output;
  }

  //CREATE STUDENT [helper for addStudent()]
  //TEST THIS
  public void createStudent(String name, double h, double m, double q, double f){
    HashMap<String, Double> scores = new HashMap<String, Double>();
    name = camelCase(name);
    scores.put("Homework", h);
    scores.put("Midterm", m);
    scores.put("Quiz", q);
    scores.put("Final Exam", f);
    studentsMap.put(name, scores);
  }
  
  //ADD STUDENT
  public void addStudent(){
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    String name = "";
    double h=0, q=0, m=0, f=0;
    do{
      System.out.println("\nADD STUDENT");
      try{
        System.out.println("Enter Student Name: ");
        name = scnr.nextLine();
        name = camelCase(name);
        if(studentsMap.get(name) != null){
          System.out.println("The Student Already Exists");
          continue;
        }
        nameValidator(name);
        System.out.println("Enter Homework Score: ");
        h = scnr.nextDouble();
        scoreValidator(h);
        System.out.println("Enter Midterm Score: ");
        m = scnr.nextDouble();
        scoreValidator(m);
        System.out.println("Enter Quiz Score: ");
        q = scnr.nextDouble();
        scoreValidator(q);
        System.out.println("Enter Final Exam Score: ");
        f = scnr.nextDouble();
        scoreValidator(f);
        valid = true;
        createStudent(name, h, m, q, f);
      }catch(InputMismatchException e){
        String buffer = scnr.nextLine();
        System.out.println(e.toString() + ":\nOnly Numbers Accepted");
      }catch(IllegalArgumentException ee){
        System.out.println(ee.toString());
      }  
    }while(!valid);
    
  }

  
  //DELETE STUDENT
  public void deleteStudent(){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Name Of Student To Delete: ");
    String name = scnr.nextLine();
    if(studentsMap.get(name) != null){
      studentsMap.remove(name);
    } else {
      System.out.println("No Such Student Exists");
    }
  }

  //CHANGE NAME 
  public void changeName(){
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    System.out.println("Enter the Name to Change: ");
    String oldName = scnr.nextLine();
    oldName = camelCase(oldName);
    if(studentsMap.get(oldName) != null){
      do{
        System.out.println("Enter the New Name: ");
        String newName = scnr.nextLine();
        nameValidator(newName);
        newName = camelCase(newName);
        valid = true;
        studentsMap.put(newName, studentsMap.remove(oldName));
      }while(!valid);
    } else {
      System.out.println("No Such Student Exists");
    }
  }

  //CALCULATE WEIGHTED SCORE [helper for getFinalScore]
  public double calcScore(String name, String type){
    Scanner scnr = new Scanner(System.in);  
    boolean valid = false;
    if(!studentsMap.get(name).containsKey(type)){
      do{
        try{
          System.out.printf("Enter Missing %s Score For %s: ", type, name);
          double score = scnr.nextDouble();
          scoreValidator(score);
          studentsMap.get(name).put(type, score);
          valid = true;
        } catch(InputMismatchException e) {
          System.out.println(e.toString()+ ": Only Numbers Accepted");
          String buffer = scnr.nextLine();
        } catch(IllegalArgumentException ee) {
          System.out.println(ee.toString());
        }
      }while(!valid);
    }
    double weightedScore = (studentsMap.get(name).get(type) * weights.get(type));
    return weightedScore;
  }


  //GET FINAL SCORE
  public void getFinalScore(){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Name of Student: ");
    String name = scnr.nextLine();
    name = camelCase(name);
    double finalScore = 0.0;
    for(String type : weights.keySet()){
      finalScore += calcScore(name, type);
    }
    studentsMap.get(name).put("FINAL SCORE", finalScore);
    System.out.println("Final Score Calculated!\n");
  }

  //FOR TESTING: CALCULATE FINAL SCORE FOR ALL STUDENTS
  public void calcAllFinalScores(){
    for(String name : studentsMap.keySet()){
      double finalScore = 0.0;
      for(String type : weights.keySet()){
        finalScore += calcScore(name, type);
      }
      studentsMap.get(name).put("FINAL SCORE", finalScore);
    }
  }

  //CHANGE SCORE
  public void changeScore(){
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    do{
      valid = false;
      try{
        System.out.println("Enter Student Name: ");
        String name = scnr.nextLine();
        name = camelCase(name);
        nameValidator(name);
        if(studentsMap.get(name) != null){
          System.out.println("Which Type?\n");
          System.out.println("1. Homework\n2. Quiz\n3. Midterm\n4. Final Exam");
          Character choice = scnr.nextLine().charAt(0);
          String type = "";
          switch(choice){
            case '1': type = "Homework";
              break;
            case '2': type = "Quiz";
              break;
            case '3': type = "Midterm";
              break;
            case '4': type = "Final Exam";
              break;
          }
          if(studentsMap.get(name).get(type) == null){
            System.out.println("No Such Score Exists");
            continue;
          } else {
              System.out.println("Enter the New Score: ");
              double score = scnr.nextInt();
              scoreValidator(score);
              studentsMap.get(name).put(type, score);
              valid = true;
          }
        } else {
          System.out.println("No Such Student Exits");
          continue;
        }
      } catch(InputMismatchException e) {
        System.out.println(e.toString()+ ": Only Numbers Accepted");
        String buffer = scnr.nextLine();
      } catch(IllegalArgumentException ee) {
        System.out.println(ee.toString());
      }
    }while(!valid);
  }

  //NAME VALIDATION [helper for addStudent() & changeName()]
  public void nameValidator(String name){
    if(name == ""){
      throw new IllegalArgumentException("\nNothing Entered");
    } else {
      for(int i=0; i<name.length(); i++){
        if(!Character.isLetter(name.charAt(i))){
          throw new IllegalArgumentException("\nOnly Letters Accepted");
        }
      }
    }
  }

  //SCORE VALIDATION [helper for addStudent() and changeScore()]
  public void scoreValidator(double score){
    if(score < 0.0 || score > 100.0){
      throw new IllegalArgumentException("\nOnly Scores (0 - 100) Accepted");
    }
  }

  //CHECK STUDENT
  public void checkStudent(){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Student Name: ");
    String name = scnr.nextLine();
    name = camelCase(name);
    if(studentsMap.get(name) == null){
      System.out.println("No Such Student Exists");
    } else {
      System.out.println(name);
      for(String k : studentsMap.get(name).keySet()){
        System.out.printf("%12s: %.1f", k, studentsMap.get(name).get(k));
        System.out.println();
      }
    }
    System.out.println();
  }

  //CHECK ALL STUDENTS
  public void checkAllStudents(){
    for(String name : studentsMap.keySet()){
      System.out.println(name);
      for(String k : studentsMap.get(name).keySet()){
        System.out.printf("%12s: %.1f", k, studentsMap.get(name).get(k));
        System.out.println();
      }
      System.out.println();
    }
  }
  
}
