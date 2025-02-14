package q;

public class CompareAnswers {
    private final CorrectAnswers correctAnswers;
    private final ScanAnswer scanAnswers;
    private int testPoints;

    public CompareAnswers(CorrectAnswers correctAnswers, ScanAnswer scanAnswers) {
        this.correctAnswers = correctAnswers;
        this.scanAnswers = scanAnswers;
    }

    public int getTestPoints() {
        return testPoints;
    }
//    public void printCorrectAnswers() {
//        List<String> cAnswers = correctAnswers.getResult();
//        List<String> yAnswers = scanAnswers.getYourAnswers();
//        System.out.println("Správne odpovede: " + cAnswers);
//        System.out.println("Tvoje odpovede: " + yAnswers);
//    }

    public void countCorrectAnswers() {
        for (int i = 0; i < correctAnswers.getResult().size(); i++) {
            if (correctAnswers.getResult().get(i).equals(scanAnswers.getScanAnswers().get(i))) {
                testPoints++;
            }
        }
        if (testPoints == 1) {
            System.out.println("Za test si ziskal: " + testPoints + " bod.");
        } else if (testPoints > 1 || testPoints < 5) {
            System.out.println("Za test si ziskal: " + testPoints + " body.");
        } else System.out.println("Za test si ziskal: " + testPoints + " bodov.");

    }

}

