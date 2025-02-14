package q;

public class Test {
    private final LoadQuestions loadQuestions;
    private final ScanAnswer scanAnswers;
    private double testTimeMin;
    private double testTimeSec;
    private long startTime;

    public double getTestTimeMin() {
        return testTimeMin;
    }

    public double getTestTimeSec() {
        return testTimeSec;
    }

    public Test(LoadQuestions loadQuestions, ScanAnswer scanAnswers) {
        this.loadQuestions = loadQuestions;
        this.scanAnswers = scanAnswers;
    }


    public void startTest() {
        for (int i = 0; i < loadQuestions.getLoadQuestions().size(); i++) {
            if (i == 0) {
                System.out.println(loadQuestions.getLoadQuestions().get(i));
                System.out.println();
                startTime = System.currentTimeMillis();
            } else {
                System.out.println(loadQuestions.getLoadQuestions().get(i));
                scanAnswers.scanAnswer();
            }
        }
        long endTime = System.currentTimeMillis();
        testTimeMin = (endTime - startTime) / 1000.0 / 60.0;
        testTimeSec = (endTime - startTime) % 60.0;
        System.out.println("Test ti trval: " + (int) testTimeMin + " min a " + testTimeSec + " sec.");
    }
}