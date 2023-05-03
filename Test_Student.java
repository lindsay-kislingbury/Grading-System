import java.util.*;

class Test_Student{
  public Test_Student(){}

  public void sortTest1(){
  }
  
  public void curveTest1(){
    Student student = new Student();

    //TEST DATA
    HashMap<String, Double> scores1 = new HashMap<String, Double>();
    scores1.put("Homework", 54.0);
    scores1.put("Quiz", 78.0);
    scores1.put("Midterm", 99.0);
    scores1.put("Final Exam", 85.0);
    student.putStudent("Amy", scores1);

    HashMap<String, Double> scores2 = new HashMap<String, Double>();
    scores2.put("Homework", 58.0);
    scores2.put("Quiz", 52.6);
    scores2.put("Midterm", 47.7);
    scores2.put("Final Exam", 69.3);
    student.putStudent("Joe", scores2);

    HashMap<String, Double> scores3 = new HashMap<String, Double>();
    scores3.put("Homework", 73.5);
    scores3.put("Quiz", 91.1);
    scores3.put("Midterm", 67.0);
    scores3.put("Final Exam", 43.6);
    student.putStudent("Patrick", scores3);

    HashMap<String, Double> scores4 = new HashMap<String, Double>();
    scores4.put("Homework", 82.7);
    scores4.put("Quiz", 71.0);
    scores4.put("Midterm", 93.4);
    scores4.put("Final Exam", 42.0);
    student.putStudent("April", scores4);

    HashMap<String, Double> scores5 = new HashMap<String, Double>();
    scores5.put("Homework", 82.0);
    scores5.put("Quiz", 71.0);
    scores5.put("Midterm", 93.0);
    scores5.put("Final Exam", 42.2);
    student.putStudent("Sharon", scores5);

    HashMap<String, Double> scores6 = new HashMap<String, Double>();
    scores6.put("Homework", 51.7);
    scores6.put("Quiz", 41.0);
    scores6.put("Midterm", 43.8);
    scores6.put("Final Exam", 67.3);
    student.putStudent("Corey", scores6);


    student.getAllFinalScores();
    student.curveGrade();
    student.checkAllStudents();
    
    //VALIDATION DATA
    HashMap<String, Double> testFinalScores = new HashMap<String, Double>();
    testFinalScores.put("Amy", 78.7); //b
    testFinalScores.put("Joe", 58.3);
    testFinalScores.put("Patrick", 66.8); 
    testFinalScores.put("April", 70.3);  //c
    testFinalScores.put("Sharon", 70.1); //d
    testFinalScores.put("Corey", 52.7);
    
    HashMap<String, Character> validationData = new HashMap<String, Character>();
    validationData.put("Amy", 'B');
    validationData.put("Joe", 'F');
    validationData.put("Patrick", 'F');
    validationData.put("April",'C');
    validationData.put("Sharon", 'D');
    validationData.put("Corey", 'F');

    //TEST
    for(String k : validationData.keySet()){
      if(student.getLetterGrade(k) == validationData.get(k)){
      System.out.printf("TEST PASSED - EXPECTED: %s OBSERVED: %s\n", 
                           validationData.get(k), student.getLetterGrade(k));
      }
      else{
        System.out.printf("TEST FAILED - EXPECTED: %s OBSERVED: %s\n", 
                           validationData.get(k), student.getLetterGrade(k));
      }
    }
    
  }

  
  public static void main(String[] args){
    Test_Student test = new Test_Student();
    test.curveTest1();

  }
}