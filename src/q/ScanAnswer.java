package q;

import java.util.List;
import java.util.Scanner;

public class ScanAnswer {
    private final List<String> scanAnswers;
    private final Scanner scan;

    public ScanAnswer(List<String> scanAnswers, Scanner scan) {
        this.scanAnswers = scanAnswers;
        this.scan = scan;
    }

    public List<String> getScanAnswers() {
        return scanAnswers;
    }

    public void scanAnswer(){
        System.out.println("Zadaj odpoved: ");
        String answer=scan.nextLine().trim().toLowerCase();
        System.out.println();
        scanAnswers.add(answer);
    }
}
