package io.zipcoder;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {

    private Student[] students;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxSize){
        students = new Student[maxSize];
    }

    public Classroom() {
        students = new Student[30];
    }

    //

    public Student[] getStudents(){
        return this.students;
    }

    public Double getAverageExamScore() {
        Double compScore = 0d;
        for(Student x : students){
            compScore += x.getAverageExamScore();
        }
        return compScore / students.length;
    }

    public Boolean addStudent(Student student) {
        for(int i = 0; i < students.length; i++){
            if(students[i] == null){
                students[i] = student;
                return true;
            }
        }
        return false;
    }

    public Boolean removeStudent(String first, String last){
        Student rm = new Student(first, last, new Double[0]);
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].equals(rm)){
                for(int j = i; j < students.length - 1; j++){
                    students[j] = students[j + 1];
                }
                if(students[students.length -1] != null) students[students.length - 1] = null;
                return true;
            }
        }
        return false;
    }

    public void orderStudents(){
        Arrays.sort(students);
    }
}
