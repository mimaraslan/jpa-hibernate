package com.mimaraslan;

import com.mimaraslan.dao.StudentDao;
import com.mimaraslan.entity.Student;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();

        Student student1 = new Student("A", "X", "aaa@gmail.com");
        Student student2 = new Student("B", "Y", "bbb@gmail.com");
        Student student3 = new Student("C", "Z", "ccc@gmail.com");

        studentDao.saveStudent(student1);
        studentDao.saveStudent(student2);
        studentDao.saveStudent(student3);

        List<Student> students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getEmail()));

    }
}