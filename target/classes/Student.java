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

  //Set Name
  public void setName(String name){
    this.name = name;
  }
  
  //Set Score
  public void setScore(Character type, int score){
    switch(type){
      case 'H':
        homework = score;
        break;
      case 'Q':
        quiz = score;
        break;
      case 'M':
        quiz = score;
        break;
      case 'F':
        finalExam = score
        break;
    }
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
