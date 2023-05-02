package com.mimaraslan;

import com.mimaraslan.dao.StudentDao;
import com.mimaraslan.entity.Student;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        studentDao.saveStudent(student);

        List<Student> students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getFirstName()));
    }
}