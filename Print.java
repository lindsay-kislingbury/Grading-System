import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Print {
	private int numChoices;
	private String[] choices;
	private Object[] headerArgs;
	private String divider;
	private String format;
	
	//CONSTRUCTOR
	public Print() {}
	
	//Output File
	public void getPrintChoices(HashMap<String, Character> letterGrades) {
    boolean valid = false;
    Pattern pattern = Pattern.compile("^[0-9 ]+$");
	  Scanner scnr = new Scanner(System.in);
    do{
  	  System.out.println("Which Categories to Print?:\n"
  			  	+ "1.Homework Score\n2.Quiz Score\n"
  	  			+ "3.Midterm Score\n4.Final Exam Score\n5.Final Score\n"
  	  			+ "6.Curved Grade\nEnter all choices on one line");
  	  String input = scnr.nextLine();
      Matcher matcher = pattern.matcher(input);
      if(!matcher.find()){
        System.out.println("Invalid Choice, Try Again");
      }
      else if(input.contains("6") && letterGrades.isEmpty()){
        System.out.println("Cannot Print Curved Grades\nGrades have not been Curved Yet.");
      }
      else{
        choices = input.split("\\s+");
  	    numChoices = choices.length;
        valid = true;
      }
    }while(!valid);
  }
		  
	//CREATE COLUMN NAMES AND ROW FORMATS
  public void headerArgumentBuilder() {
    int numChoices = choices.length;
    String[] arguments = new String[numChoices+1]; 
    format = "";
    format += "| %-7s |";
    arguments[0] = "NAME";
    for(int i=0; i<numChoices; i++) {
      if(choices[i].equals("1")) {
        format += " %5s |";
        arguments[i+1] = " HW "; 
      }
      else if(choices[i].equals("2")) {
        format += " %5s |";
        arguments[i+1] = "Q  "; 
      }
      else if(choices[i].equals("3")) {
        format += " %5s |";
        arguments[i+1] = "M  "; 
      }
      else if(choices[i].equals("4")) {
        format += " %5s |";
        arguments[i+1] = "F  "; 
      }
      else if(choices[i].equals("5")) {
        format += " %-5s |";
        arguments[i+1] = "SCORE"; 
      }
      else if(choices[i].equals("6")) {
        format += " %-5s |";
        arguments[i+1] = "GRADE"; 
      }
    }
    format += "%n";  
    headerArgs = arguments;
  }

  //CREATE DIVIDER
  public void dividerBuilder() {
    divider = "+---------";
    for(String c : choices) {
      divider += "+-------" ;
    }
    divider+="+\n";
  }

  //CREATE ROW DATA ARGUMENTS
  public String[] dataArgumentBuilder(Map.Entry<String, HashMap<String,Double>> student,
      Character grade) {
    int numChoices = choices.length;
    String[] dataArguments = new String[numChoices+1];
    dataArguments[0] = student.getKey();
    for(int i=0; i<numChoices; i++) {
      double score = 0.0;
      if(!choices[i].equals("6")) {
        if(choices[i].equals("1")){
          if(student.getValue().get("Homework") == null){
            dataArguments[i+1] = "n/a";
          }
          else{
            dataArguments[i+1] = 
              String.format("%.1f", student.getValue().get("Homework"));
          }
        }
        else if(choices[i].equals("2")){
          if(student.getValue().get("Quiz") == null){
            dataArguments[i+1] = "n/a";
          }
          else{
            dataArguments[i+1] = 
              String.format("%.1f", student.getValue().get("Quiz"));
          }
        }
        else if(choices[i].equals("3")){
          if(student.getValue().get("Midterm") == null){
            dataArguments[i+1] = "n/a";
          }
          else{
            dataArguments[i+1] = 
              String.format("%.1f", student.getValue().get("Midterm"));
          }
        }
        else if(choices[i].equals("4")){
          if(student.getValue().get("Final Exam") == null){
            dataArguments[i+1] = "n/a";
          }
          else{
            dataArguments[i+1] = 
              String.format("%.1f", student.getValue().get("Final Exam"));
          }
        }
        else if(choices[i].equals("5")){
          if(student.getValue().get("FinalScore") == null){
            dataArguments[i+1] = "n/a";
          }
          else{
            dataArguments[i+1] = 
              String.format("%.1f", student.getValue().get("FinalScore"));
          }
        }
      }
      else {
        dataArguments[i+1] = String.format("  %c", grade);
      }
    }
    return dataArguments;
  }

	//WRITE TO FILE
  public void outputFile(HashMap<String, HashMap<String, Double>> students, HashMap<String, Character> letterGrades){
    try{
      FileWriter fw = new FileWriter("report.txt");
      PrintWriter pw = new PrintWriter(fw);
      getPrintChoices(letterGrades);
      headerArgumentBuilder();
      dividerBuilder();
      pw.print(divider);
      pw.format(format, headerArgs);
      pw.print(divider);
      for(Map.Entry<String, HashMap<String,Double>> s : students.entrySet()) {
        Object[] dataArgs = dataArgumentBuilder(s, letterGrades.get(s.getKey()));
        pw.format(format, dataArgs);
        pw.print(divider);
      }
      pw.close();
    } catch(IOException e) {
      System.out.println(e.toString());
    }
  }
	
}