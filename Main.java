import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();
        File studentsFile = new File("src/students.txt");
        Scanner studentScanner = new Scanner(studentsFile);
        while (studentScanner.hasNextLine()) {
            String[] studentData = studentScanner.nextLine().split(" ");
            Student student = new Student(
                    studentData[0], studentData[1], Integer.parseInt(studentData[2]),
                    parseGender(studentData[3])
            );
            for (int i = 4; i < studentData.length; i++) {
                student.addGrade(Integer.parseInt(studentData[i]));
            }
            school.addMember(student);
        }
        studentScanner.close();

        File teachersFile = new File("src/teachers.txt");
        Scanner teacherScanner = new Scanner(teachersFile);
        while (teacherScanner.hasNextLine()) {
            String[] teacherData = teacherScanner.nextLine().split(" ");
            Teacher teacher = new Teacher(
                    teacherData[0], teacherData[1], Integer.parseInt(teacherData[2]),
                    parseGender(teacherData[3]), teacherData[4],
                    Integer.parseInt(teacherData[5]), Integer.parseInt(teacherData[6])
            );
            school.addMember(teacher); // Добавление преподавателя в школу
        }
        teacherScanner.close();

        System.out.println("School Members:");
        System.out.println(school);
    }

    private static boolean parseGender(String gender) {
        return gender.equalsIgnoreCase("Male");
    }
}
