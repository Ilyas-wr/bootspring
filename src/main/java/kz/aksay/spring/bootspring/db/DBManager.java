package kz.aksay.spring.bootspring.db;

import kz.aksay.spring.bootspring.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 3L;

    static {
        students.add(new Student(1L,"Ilyas","Abiken",90,"A"));
        students.add(new Student(2L,"Zhandos","Smalyamov",60,"D"));
    }

    public static ArrayList<Student> getAllItems(){
        return students;
    }

    public static void AddItems(Student student){
        student.setId(id);
        students.add(student);
        id++;
        if (student.getExam()>= 90){
            student.setMark("A");
        } else if (student.getExam()>=75 && student.getExam()<=89) {
            student.setMark("B");
        } else if (student.getExam()>=60 && student.getExam()<=74) {
            student.setMark("C");
        }
        else if (student.getExam()>=50 && student.getExam()<=59) {
            student.setMark("D");
        }
        else {
            student.setMark("F");
        }
    }

    public static Student getStudentId(Long id){
        for(Student stud: students){
            if(stud.getId() == id){
                return stud;
            }
        }
        return null;
    }



}
