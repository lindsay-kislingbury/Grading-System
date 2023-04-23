import java.util.ArrayList;

public class Student {
  private String name;
  private int homework;
  private int quiz;
  private int midterm;
  private int finalExam;
  private int finalScore;

  // Default Constructor
  public Student() {
    this.name = "empty";
    homework = 0;
    quiz = 0;
    midterm = 0;
    finalExam = 0;
    finalScore = 0;
  }

  // Non-Default Constructor
  public Student(String name, int h, int q, int m, int f) {
    this.name = name;
    homework = h;
    midterm = m;
    quiz = q;
    finalExam = f;
    finalScore = 0;
  }
  
  public String getName(){
    return name;
  }

  //Set Name
  public void setName(String name){
    this.name = name;
  }

  public void setHomework(int homework){
    this.homework = homework;
  }

  public void setQuiz(int homework){
    this.homework = homework;
  }

    public void setMidterm(int homework){
    this.homework = homework;
  }

    public void setFinalExam(int homework){
    this.homework = homework;
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
    System.out.println("Homework: " + homework);
    System.out.println("Quiz: " + quiz);
    System.out.println("Midterm: " + midterm);
    System.out.println("Final Exam: " + finalExam);
    System.out.println("FINAL SCORE: " + finalScore);
    System.out.println();
  }
  
}
