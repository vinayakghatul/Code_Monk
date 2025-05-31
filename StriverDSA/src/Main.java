import java.util.*;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Custom_Comparator implements Comparator<Student> {

    public int compare(Student a, Student b) {
      return a.id - b.id;
    }
}

class Main {

    public static void main(String args[]) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(2,"abc"));
        students.add(new Student(3, "xyz"));
        students.add(new Student(1, "pqr"));

        Collections.sort(students, new Custom_Comparator());
        for (Student student : students) {
            System.out.println(student.id);
        }
    }
}

