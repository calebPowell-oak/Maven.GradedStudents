package io.zipcoder;

import com.sun.jmx.snmp.agent.SnmpUserDataFactory;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public HashMap<Student, String> getGradebook(){
        Arrays.sort(students);
        Double highestScore = students[0].getAnExamScore(0);
        Double lowestScore = students[0].getAnExamScore(0);
        for(Student x : students){
            if(x.getAnExamScore(0) > highestScore) highestScore = x.getAnExamScore(0);
            else if(x.getAnExamScore(0) < lowestScore) lowestScore = x.getAnExamScore(0);
        }

        HashMap<Student, String> gb = new HashMap<>(students.length);
        Integer count = 1;
        for(Student x : students){
            gb.put(x, getLetterGrade(new Double(count++)/students.length));
        }
        return gb;
    }

    public String getLetterGrade(Double percentile){
        if(percentile >= .90) return "A";
        else if (percentile >= .71) return "B";
        else if (percentile >= .50) return "C";
        else if (percentile >= .11) return "D";
        else return "F";
    }
}
