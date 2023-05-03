import java.util.*;

class Test_Student{
  public Test_Student(){}

  public void sortTest1(){
  }
  
  public void curveTest1(){

    
    Student student = new Student();

    //TEST DATA
    student.putStudent("Amy");
    student.putScore("Amy", "Homework", 54.0);
    student.putScore("Amy", "Quiz", 78.0);
    student.putScore("Amy", "Midterm", 99.0);
    student.putScore("Amy", "Final Exam", 85.0);

    student.putStudent("Joe");
    student.putScore("Joe", "Homework", 58.0);
    student.putScore("Joe", "Quiz", 52.6);
    student.putScore("Joe", "Midterm", 47.7);
    student.putScore("Joe", "Final Exam", 69.3);

    student.putStudent("Patrick");
    student.putScore("Patrick", "Homework", 73.5);
    student.putScore("Patrick", "Quiz", 91.1);
    student.putScore("Patrick", "Midterm", 67.0);
    student.putScore("Patrick", "Final Exam", 43.6);

    student.putStudent("April");
    student.putScore("April", "Homework", 82.7);
    student.putScore("April", "Quiz", 71.0);
    student.putScore("April", "Midterm", 93.4);
    student.putScore("April", "Final Exam", 42.0);
    
    student.putStudent("Sharon");
    student.putScore("Sharon", "Homework", 82.0);
    student.putScore("Sharon", "Quiz", 71.0);
    student.putScore("Sharon", "Midterm", 93.0);
    student.putScore("Sharon", "Final Exam", 42.2);

    student.putStudent("Kyla");
    student.putScore("Kyla", "Homework", 45.9);
    student.putScore("Kyla", "Quiz", 70.1);
    student.putScore("Kyla", "Midterm", 83.5);
    student.putScore("Kyla", "Final Exam", 62.0);
    
    student.putStudent("Terry");
    student.putScore("Terry", "Homework", 29.7);
    student.putScore("Terry", "Quiz", 26.8);
    student.putScore("Terry", "Midterm", 67.0);
    student.putScore("Terry", "Final Exam", 71.5);
    
    student.putStudent("Mia");
    student.putScore("Mia", "Homework", 99.4);
    student.putScore("Mia", "Quiz", 58.0);
    student.putScore("Mia", "Midterm", 87.6);
    student.putScore("Mia", "Final Exam", 83.2);
    
    student.putStudent("Jason");
    student.putScore("Jason", "Homework", 95.4);
    student.putScore("Jason", "Quiz", 72.3);
    student.putScore("Jason", "Midterm", 79.6);
    student.putScore("Jason", "Final Exam", 81.9);
    
    student.putStudent("Becca");
    student.putScore("Becca", "Homework", 65.4);
    student.putScore("Becca", "Quiz", 44.8);
    student.putScore("Becca", "Midterm", 57.8);
    student.putScore("Becca", "Final Exam", 70.2);
    
    student.getAllFinalScores();
    student.curveGrade();
    
    //VALIDATION DATA
    HashMap<String, Double> testFinalScores = new HashMap<String, Double>();
    testFinalScores.put("Amy", 78.7);   //    
    testFinalScores.put("Joe", 58.3); //
    testFinalScores.put("Patrick", 66.8); //
    testFinalScores.put("April", 70.3);  //
    testFinalScores.put("Sharon", 70.1); //
    testFinalScores.put("Kyla", 63.1); //
    testFinalScores.put("Terry", 49.1); //
    testFinalScores.put("Mia", 83.9); //
    testFinalScores.put("Jason", 83.6); //
    testFinalScores.put("Becca", 61.2); //

    /* 
    testFinalScores.put("Mia", 83.9);  'A'
    testFinalScores.put("Jason", 83.6); 'A'
    testFinalScores.put("Amy", 78.7);  'B'
    testFinalScores.put("April", 70.3); 'B'
    testFinalScores.put("Sharon", 70.1); 'C'
    testFinalScores.put("Patrick", 66.8); 'C'
    testFinalScores.put("Kyla", 63.1); 'D'
    testFinalScores.put("Becca", 61.2); 'D'
    testFinalScores.put("Joe", 58.3); 'F'
    testFinalScores.put("Terry", 49.1); 'F'
      */
    
    //VALIDATION DATA
    //# of students: 10
    HashMap<String, Character> validationData = new HashMap<String, Character>();
    validationData.put("Amy", 'B');
    validationData.put("Joe", 'F');
    validationData.put("Patrick", 'C');
    validationData.put("April", 'B');
    validationData.put("Sharon", 'C');
    validationData.put("Kyla", 'D');
    validationData.put("Terry", 'F');
    validationData.put("Mia", 'A');
    validationData.put("Jason", 'A');
    validationData.put("Becca", 'D');

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
