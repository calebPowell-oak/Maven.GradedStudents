package io.zipcoder;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
}
