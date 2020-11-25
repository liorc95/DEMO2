package Deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test1 {
  public void test(FileInputStream fileIS) throws IOException, ClassNotFoundException {

    ObjectInputStream in = new ObjectInputStream(fileIS);
    Student student = (Student) in.readObject();
    MathStudent mathStudent = (MathStudent) student;
    in.close();
  }
}

class Student {
  private int departmentID;

  public Student(int value) {
    this.departmentID = value;
  }
}

class MathStudent extends Student {
  private GradeSheet grades = null;

  public MathStudent(int value) {
    super(value);
    this.grades = new GradeSheet(value);
  }
}

class GradeSheet {
  private int avgGrade;
  private Set<String> grades = null;

  public GradeSheet(int value) {
    this.avgGrade = value;
  }
}
