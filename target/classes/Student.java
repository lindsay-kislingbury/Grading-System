import java.util.ArrayList;

public class Student {
  private String name;
  private ArrayList<Integer> finalScores;
  private ArrayList<Integer> midtermScores;
  private ArrayList<Integer> quizScores;

  // Default Constructor
  public Student() {
    this.name = "empty";
    finalScores = new ArrayList<Integer>();
    midtermScores = new ArrayList<Integer>();
    quizScores = new ArrayList<Integer>();
  }

  // Non-Default Constructor
  public Student(String name) {
    this.name = name;
    finalScores = new ArrayList<Integer>();
    midtermScores = new ArrayList<Integer>();
    quizScores = new ArrayList<Integer>();
  }

  //Equals Method compares student by name
  public boolean equals(Student s) {
    if (this.name.equals(s.name)) return true;
    else return false;
  }

  //Add a score
  public void addScore(Character type, int score) {
    switch (type) {
      case 'F':
        finalScores.add(score);
        break;
      case 'M':
        midtermScores.add(score);
        break;
      case 'Q':
        quizScores.add(score);
        break;
    }
  }

  // Print
  // TODO: this should be cleaner and more concise
  public void printInfo() {
    System.out.println(name + "'s Scores:");
    if (!finalScores.isEmpty()) {
      System.out.print("Final: ");
      for (Integer finalScore : finalScores) {
        System.out.print(finalScore + ", ");
      }
      System.out.println();
    }
    if (!midtermScores.isEmpty()) {
      System.out.print("Midterm: ");
      for (Integer midtermScore : midtermScores) {
        System.out.print(midtermScore + ", ");
      }
      System.out.println();
    }
    if (!quizScores.isEmpty()) {
      System.out.print("Quiz: ");
      for (Integer quizScore : quizScores) {
        System.out.print(quizScore + ", ");
      }
      System.out.println("\n");
    }
  }
}
