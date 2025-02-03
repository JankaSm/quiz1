package q;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanAnswer {
    private List<String> yourAnswers = new ArrayList<>();
    private Scanner scan;

    public ScanAnswer(List<String> yourAnswers, Scanner scan) {
        this.yourAnswers = yourAnswers;
        this.scan = scan;
    }

    public List<String> getYourAnswers() {
        return yourAnswers;
    }

    public Scanner getScan() {
        return scan;
    }

    public void scanAnswer(){
        System.out.println("Zadaj odpoved: ");
        String answer=scan.nextLine();
        yourAnswers.add(answer);
    }
}
