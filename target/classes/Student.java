import java.util.ArrayList;

public class Student {
  private String name;
  private int hwScore;
  private int finalExamScore;
  private int midtermScore;
  private int quizScore;
  

  // Default Constructor
  public Student() {
    this.name = "empty";
    hwScore = 0;
    midtermScore = 0;
    quizScore = 0;
    finalExamScore = 0;
  }

  // Non-Default Constructor
  public Student(String name) {
    this.name = name;
    hwScore = 0;
    midtermScore = 0;
    quizScore = 0;
    finalExamScore = 0;
  }
  
public int gethwScore(){
  return hwScore;
}
public int getQuizScore(){
  return quizScore;
}

public int getMidtermScore(){
  return midtermScore;
}

public int getFinalExamScore(){
    return finalExamScore;
  }

/*Get the final score according to the following grading policy and store it into the array/list that contains all scores (call this from group class to store it in list of final scores?)
-ensure that you have all scores of quizzes, homework, midterm, and final exam 
-notify which scores are missing and ask for input from the keyboard
*/
public int getFinalScore(){
  //STUB
  int finalScore=0;
  return finalScore;
}

  // Equals Method compares student by name
  public boolean equals(Student s) {
    if (this.name.equals(s.name))
      return true;
    else
      return false;
  }
  
  // Add a score
  //TODO: If the score we want to add already exists,
  //EG: ONLY PRINT THE NOTIFICATION IF THE NEW SCORE IS THE SAME AS THE OLD SCORE
  //print out the notification “the score already exists.” 
  public void addScore(String header, int score) {
    if (header.toLowerCase().contains("homework")) {
      hwScore = score;
    } else if (header.toLowerCase().contains("quiz")) {
      quizScore = score;
    } else if (header.toLowerCase().contains("midterm")) {
      midtermScore = score;
    } else if (header.toLowerCase().contains("final")) {
      finalExamScore = score;
    }
  }

  //change score
  public void changeScore(Character type, int score){
    //switch?
  }

  // Print
  public void printInfo() {
    System.out.println(name);
    System.out.println("Homework: " + hwScore);
    System.out.println("Quiz: " + quizScore);
    System.out.println("Midterm: " + midtermScore);
    System.out.println("Final: " + finalExamScore);
    System.out.println();

  }

//CHANGE NAME
/* ): Change an existing student’s name. If the name we want to change does not exist, print out the notification “no such student exists”; otherwise, we just change it.
*/
public void changeName(String name){
  
}
//CHANGE SCORE
/* Change one existing score. If the score we want to change does not exist, print out the notification “no such score exists”; otherwise, we just change it. For example, we want to change the student Olivia’s score for the final exam to 65. If we-  already have the record of Olivia’s score for the final exam, just change it; otherwise, print out the notification “no such score exists.”
*/
public void changeScore(int Score){
  
}






/* Curve the final score according to the following criteria and store it into the array/list that contains all scores:
Top 10%-------------------A
Top 20%-10%------------B
Top 30%-20%------------C 
Top 40%-30%------------D 
Top 100%-40%----------F
*/
public void CurveGrade(){
  
}

/* Print out the details of one specific student, i.e., Olivia, by using Checkstudent(“Olivia”). If no such student exists, print out the notification “no such student exists”; otherwise, just print out this student’s scores. If we have already called GetFinalScore and CurveGrade to calculate the final and curved scores, they also need to be printed out.
*/
public void CheckStudent(){
  
}


  
}
