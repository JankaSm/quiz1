package q;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    public static class Main {

        public static void main(String[] args) {

            TestType testType = new TestType();
            testType.scanTestType();

            GetURL getURL = new GetURL(testType);
            CorrectAnswers correctAnswers = new CorrectAnswers(getURL);
            LoadQuestions loadQuestions = new LoadQuestions(getURL);
            Scanner scan = new Scanner(System.in);
            List<String> answers = new ArrayList<>();
            ScanAnswer scanAnswers = new ScanAnswer(answers, scan);

            Test test = new Test(loadQuestions, scanAnswers);
            test.startTest();
            CompareAnswers compareAnswers = new CompareAnswers(correctAnswers, scanAnswers);
            compareAnswers.countCorrectAnswers();
            double testTimeMin = test.getTestTimeMin();
            double testTimeSec = test.getTestTimeSec();
            if (compareAnswers.getTestPoints() >= 10) {
                if (testTimeSec > 0) {
                    testTimeMin +=1;
                }
                int pointTime = Math.floorDiv((int) (60 - testTimeMin), 4);
                System.out.println("Za cas si ziskal " + pointTime + " bodov.");
                int pointsTotal = pointTime + compareAnswers.getTestPoints();
                System.out.println("Spolu si ziskal: " + pointsTotal + " bodov.");
            } else {
                System.out.println("za test si mal menej bodov ako 10, body za cas sa ti nepocitaju.");
            }
        }
    }
}
