package java_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ComparatorPractice1 {
  private static final Comparator<Student> comparator1 =
      Comparator.comparing(Student::getBirth)
          .thenComparing(Comparator.comparing(Student::getName));

  public static void main(String[] args){
    Student student1 = new Student("1990-01-01", "John");
    Student student2 = new Student("1990-01-02", "Jane");
    Student student3 = new Student("1990-01-02", "Jane2");

    List<Student> students = Arrays.asList(student1, student2, student3);

//    students.sort(comparator1);
    students.sort(Student::compareTo);

    students.forEach(System.out::println);
  }
}

class Student implements Comparable<Student>{
  private final String birth;
  private final String name;

  Student(String birth, String name) {
    this.birth = birth;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getBirth() {
    return birth;
  }

  @Override
  public String toString() {
    return "Student{" +
        "birth='" + birth + '\'' +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public int compareTo(@NotNull Student other) {
    int result = this.birth.compareTo(other.birth);
    if(result != 0) {
      return result;
    }

    result = other.name.compareTo(this.name);
    if(result != 0) {
      return result;
    }

    return 0;
  }
}
