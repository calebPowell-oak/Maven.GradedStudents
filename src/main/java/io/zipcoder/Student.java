package io.zipcoder;

import org.omg.CORBA.DoubleHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;
    private ArrayList<Double> examsScores = new ArrayList<>(0);

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examsScores.addAll(Arrays.asList(testScores));
    }

    public Student(){
        this.firstName = "";
        this.lastName = "";
    }

    public void addExamScore(Double newScore){
        examsScores.add(newScore);
    }

    public Integer getTestsTaken(){
        return examsScores.size();
    }

    public Boolean setExamScore(Integer testIndex, Double newScore){
        if(testIndex >= 0 && testIndex <= examsScores.size()){
            examsScores.set(testIndex, newScore);
            return true;
        }
        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamsScores() {
        String output = "Exam Scores: \n";
        Integer count = 1;
        for(Double score : examsScores){
            output += String.format("\tExam %d -> %.0f\n", count++, score);
        }
        return output;
    }

    public Double getAnExamScore(Integer testIndex){
        return this.examsScores.get(testIndex);
    }

    public Double getAverageExamScore() {
        Double count = 0d;
        for(Double score : examsScores){
            count += score;
        }
        return count /= examsScores.size();
    }

    @Override
    public String toString() {
        String output = "";
        output += String.format("Student Name: " + this.firstName + " " + this.lastName +
                "\n> Average Score: %.0f\n" + "> Exam Scores: \n", getAverageExamScore());
        Integer count = 1;
        for(Double score : examsScores){
            output += String.format("\tExam %d -> %.0f\n", count++, score);
        }
        return output;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Student oStud = (Student)other;
        return firstName.equals(oStud.getFirstName()) &&
                lastName.equals(oStud.getLastName());
    }

    @Override
    public int compareTo(Student o) {
        if(this.getAverageExamScore() > o.getAverageExamScore()) return 1;
        if(this.getAverageExamScore() < o.getAverageExamScore()) return -1;
        else {
            return firstName.compareTo(o.getFirstName());
        }
    }
}
