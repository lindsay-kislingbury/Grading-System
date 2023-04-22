import java.util.ArrayList;

public class Student {
  private String name;
  private ArrayList<Integer> hwScores;
  private ArrayList<Integer> finalScores;
  private ArrayList<Integer> midtermScores;
  private ArrayList<Integer> quizScores;

  // Default Constructor
  public Student() {
    this.name = "empty";
    hwScores = new ArrayList<Integer>();
    midtermScores = new ArrayList<Integer>();
    quizScores = new ArrayList<Integer>();
    finalScores = new ArrayList<Integer>();
  }

  // Non-Default Constructor
  public Student(String name) {
    this.name = name;
    hwScores = new ArrayList<Integer>();
    midtermScores = new ArrayList<Integer>();
    quizScores = new ArrayList<Integer>();
    finalScores = new ArrayList<Integer>();
  }

  //Equals Method compares student by name
  public boolean equals(Student s) {
    if (this.name.equals(s.name)) return true;
    else return false;
  }

  //Add a score
  public void addScore(String header, int score) {
    if(header.toLowerCase().contains("homework")){
      hwScores.add(score);
    }
    else if(header.toLowerCase().contains("quiz")){
      quizScores.add(score);
    }
    else if(header.toLowerCase().contains("midterm")){
      midtermScores.add(score);
    }
    else if(header.toLowerCase().contains("final")){
      finalScores.add(score);
    }
    //else throw an exception?
  }

  // Print
  public void printInfo() {
    for(int i=0; i<15; i++) System.out.print("-");
    System.out.println();
    System.out.println(name);
    for(int i=0; i<15; i++) System.out.print("-");
    System.out.println();
    if(!hwScores.isEmpty()){
      System.out.printf("%12s", "Homework:\t");
      for(int s : hwScores) System.out.print(s + " ");
      System.out.println("\n");
    }
    if(!quizScores.isEmpty()){
      System.out.printf("%12s", "Quiz:\t");
      for(int s : quizScores) System.out.print(s + " ");
      System.out.println("\n");
    }
    if(!midtermScores.isEmpty()){
      System.out.printf("%12s", "Midterm:\t");
      for(int s : midtermScores) System.out.print(s + " ");
      System.out.println("\n");
    }
    if(!finalScores.isEmpty()){
      System.out.printf("%12s", "Final:\t");
      for(int s : finalScores) System.out.print(s + " ");
      System.out.println("\n");
    }
    
  }

}
