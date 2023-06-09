import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.Math;

public class Student {
	  private HashMap<String, HashMap<String, Double>> studentsMap;
	  private HashMap<String, Character> letterGrades;
	  private HashMap<String, Double> weights;
	  private double[] bracketWeights = { 0.1, 0.1, 0.1, 0.1 };
	  private Character[] bracketLetters = { 'A', 'B', 'C', 'D' };

  //CONSTRUCTOR
  public Student() {
    studentsMap = new HashMap<String, HashMap<String, Double>>();
    weights = new HashMap<String, Double>();
    letterGrades = new HashMap<String, Character>();
    weights.put("Homework", 0.3);
    weights.put("Quiz", 0.2);
    weights.put("Midterm", 0.2);
    weights.put("Final Exam", 0.3);
  }

  /*** GETTERS & SETTERS ***/
  //GET MAP
  public HashMap<String, HashMap<String, Double>> getMap(){
	  return studentsMap;
  }
  
  public HashMap<String, Character>getGrades() {
	  return letterGrades;
  }
  
  //PUT STUDENT IN MAP
  public void putStudent(String name){
    HashMap<String, Double> scores = new HashMap<String, Double>();
    studentsMap.put(name,scores);
  }
  //PUT SCORE IN STUDENT'S SCORES MAP
  public void putScore(String name, String type, Double score){
    studentsMap.get(name).put(type, score);
  }

  //GET LETTER GRADE
  public Character getLetterGrade(String name){
    return letterGrades.get(name);
  }

  /*** MUTATORS ***/
  //FILE READER
  public void inputFile(String input) {
    File file = new File(input);
    try {
      Scanner fileScnr = new Scanner(file);
      String[] headers = fileScnr.nextLine().split("\t");
      int nameIndex = 0;
      for (int i = 0; i < headers.length; i++) {
        if (headers[i].toLowerCase().contains("name")) {
          nameIndex = i;
        }
      }
      while (fileScnr.hasNext()) {
        String[] line = fileScnr.nextLine().split("\t");
        String name = line[nameIndex];
        String type = "";
        double score = 0;
        for (int i = 0; i < headers.length; i++) {
          if (i == nameIndex)
            continue;
          if (headers[i].contains("homework")) {
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
          name = camelCase(name);
          if (studentsMap.get(name) != null) {
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

  //ADD STUDENT
  public void addStudent() {
    // Variable Initialization
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    String name = "";
    double h = 0, q = 0, m = 0, f = 0;
    //Processing
    do {
      System.out.println("\nADD STUDENT"); //Output
      try { //Processing
        System.out.println("Enter Student Name: "); // Output
        name = scnr.nextLine(); //Input
        name = camelCase(name);
        //Processing
        if (studentsMap.get(name) != null) {
          System.out.println("The Student Already Exists"); //Output
          continue;
        }
        nameValidator(name);
        //Input
        System.out.println("Enter Homework Score: ");
        h = scnr.nextDouble(); //Processing
        scoreValidator(h);
        System.out.println("Enter Midterm Score: ");
        m = scnr.nextDouble();
        scoreValidator(m);
        System.out.println("Enter Quiz Score: ");
        q = scnr.nextDouble();
        scoreValidator(q);
        System.out.println("Enter Final Exam Score: ");
        f = scnr.nextDouble();
        //Processing
        scoreValidator(f);
        createStudent(name, h, m, q, f);
        valid = true;
        //Two Exceptions
      } catch (InputMismatchException ee) { // Exception to restrict   
        // scores to numbers input
        String buffer = scnr.nextLine();
        System.out.println(ee.toString() + ":\nOnly Numbers Accepted");
      } catch (IllegalArgumentException e) { // 
        System.out.println(e.toString());
      }
    } while (!valid);

  }

  //ADD SCORE
  public void addScore(){
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    System.out.println("Enter Name Of Student: ");
    String name = scnr.nextLine();
    name = camelCase(name);
    if (studentsMap.get(name) != null) {
      System.out.println("Which Type?\n");
      System.out.println("1. Homework\n2. Quiz\n3. Midterm\n4. Final Exam");
      Character choice = scnr.nextLine().charAt(0);
      String type = "";
      switch (choice) {
        case '1':
          type = "Homework";
          break;
        case '2':
          type = "Quiz";
          break;
        case '3':
          type = "Midterm";
          break;
        case '4':
          type = "Final Exam";
          break;
      }
      if(studentsMap.get(name).get(type) != null){
        System.out.println("The Score Already Exists\n");
      } else {
          System.out.println("Enter the New Score: ");
          double score = scnr.nextInt();
          scoreValidator(score);
          studentsMap.get(name).put(type, score);
          valid = true;
      }
    } else {
      System.out.println("No Such Student Exists");
    }
  }

  //DELETE STUDENT
  public void deleteStudent() {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Name Of Student To Delete: ");
    String name = scnr.nextLine();
    if (studentsMap.get(name) != null) {
      studentsMap.remove(name);
    } else {
      System.out.println("No Such Student Exists");
    }
  }

  //CHANGE NAME
  public void changeName() {
    Scanner scnr = new Scanner(System.in);
    boolean valid = false; // rectangle
    System.out.println("Enter the Name to Change: "); //Parallelogram
    String oldName = scnr.nextLine(); //Parallelogram
    oldName = camelCase(oldName); // rectangle with two lines on sides
    if (studentsMap.get(oldName) != null) { //diamond
      do {
        System.out.println("Enter the New Name: ");
        String newName = scnr.nextLine();
        nameValidator(newName);
        newName = camelCase(newName);
        studentsMap.put(newName, studentsMap.remove(oldName));
        valid = true;
      } while (!valid);
    } else {
      System.out.println("No Such Student Exists");
    }
  }

  //GET FINAL SCORE
  public void getFinalScore() {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Name of Student: ");
    String name = scnr.nextLine();
    name = camelCase(name);
    double finalScore = 0.0;
    for (String type : weights.keySet()) {
      boolean valid = false;
      if (!studentsMap.get(name).containsKey(type)) {
        do {
          try {
            System.out.printf("Enter Missing %s Score For %s: ", type, name);
            double score = scnr.nextDouble();
            scoreValidator(score);
            studentsMap.get(name).put(type, score);
            valid = true;
          } catch (InputMismatchException e) {
            System.out.println(e.toString() + ": Only Numbers Accepted");
            String buffer = scnr.nextLine();
          } catch (IllegalArgumentException ee) {
            System.out.println(ee.toString());
          }
        } while (!valid);
      }
      double weightedScore = (studentsMap.get(name).get(type) * weights.get(type));
      finalScore += weightedScore;
    }
    
    studentsMap.get(name).put("FinalScore", finalScore);
    System.out.println("FinalScore Calculated!\n");
  }

  //CHANGE SCORE
  public void changeScore() {
    Scanner scnr = new Scanner(System.in);
    boolean valid = false;
    do {
      valid = false;
      try {
        System.out.println("Enter Student Name: ");
        String name = scnr.nextLine();
        name = camelCase(name);
        nameValidator(name);
        if (studentsMap.get(name) != null) {
          System.out.println("Which Type?\n");
          System.out.println("1. Homework\n2. Quiz\n3. Midterm\n4. Final Exam");
          Character choice = scnr.nextLine().charAt(0);
          String type = "";
          switch (choice) {
            case '1':
              type = "Homework";
              break;
            case '2':
              type = "Quiz";
              break;
            case '3':
              type = "Midterm";
              break;
            case '4':
              type = "Final Exam";
              break;
          }
          if (studentsMap.get(name).get(type) == null) {
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
      } catch (InputMismatchException e) {
        System.out.println(e.toString() + ": Only Numbers Accepted");
        String buffer = scnr.nextLine();
      } catch (IllegalArgumentException ee) {
        System.out.println(ee.toString());
      }
    } while (!valid);
  }

  //CURVE GRADE
  public void curveGrade() {
    getAllFinalScores();
    try {
      List<Map.Entry<String, HashMap<String, Double>>> entries = sortStudents();
      int numStudents = entries.size();
      int lastStartIndex = 0;
      for (int i = 0; i < bracketWeights.length; i++) {
        int bracketSize = ((int)Math.ceil(bracketWeights[i] * numStudents));
        int endIndex = lastStartIndex + bracketSize;
        if(endIndex > numStudents){
          continue;
        }
        for (int j = lastStartIndex; j <= endIndex; j++) {
          letterGrades.put(entries.get(j).getKey(), bracketLetters[i]);
        }
        lastStartIndex = endIndex + 1;
      }
      for (int k = lastStartIndex; k < numStudents; k++) {
        letterGrades.put(entries.get(k).getKey(), 'F');
      }
    }catch (IndexOutOfBoundsException e){
      System.out.println(e);
    }
  }

  //GET ALL FINAL SCORES
  public void getAllFinalScores() {
    Scanner scnr = new Scanner(System.in);
    for (String name : studentsMap.keySet()) {
      double finalScore = 0.0;
      for (String type : weights.keySet()) {
        boolean valid = false;
        if (!studentsMap.get(name).containsKey(type)) {
          do {
            try {
              System.out.printf("Enter Missing %s Score For %s: ", type, name);
              double score = scnr.nextDouble();
              scoreValidator(score);
              studentsMap.get(name).put(type, score);
              valid = true;
            } catch (InputMismatchException e) {
              System.out.println(e.toString() + ": Only Numbers Accepted");
              String buffer = scnr.nextLine();
            } catch (IllegalArgumentException ee) {
              System.out.println(ee.toString());
            }
          } while (!valid);
        }
        double weightedScore = (studentsMap.get(name).get(type)
            * weights.get(type));
        weightedScore = Math.round(weightedScore * 100);
        weightedScore = weightedScore/100;
        finalScore += weightedScore;
      }
      studentsMap.get(name).put("FinalScore", finalScore);
    }
  }

  /*** HELPERS ***/
  //CREATE STUDENT
  public void createStudent(String name, double h, double m, double q, double f) {
    HashMap<String, Double> scores = new HashMap<String, Double>();
    name = camelCase(name);
    scores.put("Homework", h);
    scores.put("Midterm", m);
    scores.put("Quiz", q);
    scores.put("Final Exam", f);
    studentsMap.put(name, scores);
  }

  //NAME VALIDATION
  public void nameValidator(String name){
    if (name == "") {
      throw new IllegalArgumentException("\nNothing Entered");
    } else {
      for (int i = 0; i < name.length(); i++) {
        if (!Character.isLetter(name.charAt(i))) {
          throw new IllegalArgumentException("\nOnly Letters Accepted");
        }
      }
    }
  }

  //SCORE VALIDATION
  public void scoreValidator(double score){
    if (score < 0.0 || score > 100.0) {
      throw new IllegalArgumentException("\nOnly Scores (0 - 100) Accepted");
    }
  }

  //CAMEL CASE
  public String camelCase(String input) {
    String output = input.toLowerCase();
    output = output.substring(0, 1).toUpperCase() + output.substring(1);
    return output;
  }

  //SORT STUDENTS
  public List<Map.Entry<String, HashMap<String, Double>>> sortStudents() {
    Set<Map.Entry<String, HashMap<String, Double>>> set 
      = studentsMap.entrySet();
    List<Map.Entry<String, HashMap<String, Double>>> entries 
      = new ArrayList<Map.Entry<String, HashMap<String, Double>>>(set);
    
    Collections.sort(
      entries,
      new Comparator<Map.Entry<String, HashMap<String, Double>>>() {
        public int compare(Map.Entry<String, HashMap<String, Double>> s1,
            Map.Entry<String, HashMap<String, Double>> s2) {
          return s2.getValue().get("FinalScore")
              .compareTo(s1.getValue().get("FinalScore"));
        }
      });
    return entries;
  }

  /***PRINT***/
  //CHECK STUDENT
  public void checkStudent() {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Student Name: ");
    String name = scnr.nextLine();
    name = camelCase(name);
    if (studentsMap.get(name) == null) {
      System.out.println("No Such Student Exists");
    } else {
      System.out.println(name);
      for (String k : studentsMap.get(name).keySet()) {
        if (k != "FinalScore") {
          System.out.printf("%12s: %.1f", k, studentsMap.get(name).get(k));
          System.out.println();
        }
      }
      System.out.println("------------------------");
      if (studentsMap.get(name).get("FinalScore") != null) {
        System.out.printf("%15s: %.1f", "Final Score",
            studentsMap.get(name).get("FinalScore"));
        System.out.println();
      }
      if (letterGrades.get(name) != null) {
        System.out.printf("%15s: %c", "Final Grade", letterGrades.get(name));
        System.out.println();
      }
    }
    System.out.println();
  }

  //CHECK ALL STUDENTS
  public void checkAllStudents() {
    for (String name : studentsMap.keySet()) {
      System.out.println(name);
      for (String k : studentsMap.get(name).keySet()) {
        if (k != "FinalScore") {
          System.out.printf("%12s: %.1f", k, studentsMap.get(name).get(k));
          System.out.println();
        }
      }
      System.out.println("------------------------");
      if (studentsMap.get(name).get("FinalScore") != null) {
        System.out.printf("%15s: %.1f", "Final Score",
            studentsMap.get(name).get("FinalScore"));
        System.out.println();
      }
      if (letterGrades.get(name) != null) {
        System.out.printf("%15s: %c", "Final Grade", letterGrades.get(name));
        System.out.println();
      }
      System.out.println();
    }
  }

}
