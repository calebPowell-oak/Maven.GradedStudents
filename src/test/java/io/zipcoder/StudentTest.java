package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getScoresTest(){
        // Given
        Student caleb = new Student("Caleb", "Powell", new Double[] {100d,44d,77d});
        String expected = "Exam Scores: \n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 44\n" +
                "\tExam 3 -> 77\n";

        // When
        String actual = caleb.getExamsScores();

        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void x(){
        // Given

        // When

        // Assert

    }

    @Test
    public void addTestScoreTest(){
        // Given
        Student caleb = new Student();
        Integer expected = 1;

        // When
        caleb.addExamScore(77d);
        Integer actual = caleb.getTestsTaken();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTestScoreTest(){
        // Given
        Student caleb = new Student();
        caleb.addExamScore(10d);

        // When
        Integer testIndex = 0;
        Double expected = 100d;
        Assert.assertTrue(caleb.setExamScore(testIndex, expected));

        // Assert
        Double actual = caleb.getAnExamScore(testIndex);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTestScoreBadIndex(){
        // Given
        Student caleb = new Student();
        caleb.addExamScore(10d);

        // When
        Integer testIndex = 10;
        Double newScore = 100d;

        // Assert
        Assert.assertFalse(caleb.setExamScore(testIndex, newScore));
    }

    @Test
    public void getAverageExamScore(){
        // Given
        Double scores[] = {100d, 100d, 100d};
        Student caleb = new Student("C", "P", scores);
        Double count = 0d;
        for(Double x : scores){
            count += x;
        }

        // When
        Double expected = count /= scores.length;
        Double actual = caleb.getAverageExamScore();

        // Assert
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void toStringTest(){
        // Given
        Double scores[] = {101d, 100d, 102d};
        Student caleb = new Student("C", "P", scores);

        // When
        String expected = String.format("Student Name: " + caleb.getFirstName() + " " + caleb.getLastName() +
                "\n> Average Score: %.0f\n" + "> Exam Scores: \n", caleb.getAverageExamScore()) +
                "\tExam 1 -> 101\n" +
                "\tExam 2 -> 100\n" +
                "\tExam 3 -> 102\n";

        // Assert
        String actual = caleb.toString();
        Assert.assertEquals(expected, actual);
    }
}