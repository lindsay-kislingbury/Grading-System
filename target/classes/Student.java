import java.util.*;

public class Student {
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
  
}
