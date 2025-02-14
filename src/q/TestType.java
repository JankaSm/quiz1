package q;

import java.util.Scanner;
import java.util.Set;

public class TestType {
    private String testType;

    public void scanTestType() {
        Scanner scan = new Scanner(System.in);
        Set<String> allowedCategories = Set.of("P3", "P4", "P5", "P6", "P7");

        while (true) {
            try {
                System.out.println("Define your category (P3, P4, P5, P6, P7): ");
                testType = scan.nextLine().trim().toUpperCase();
                System.out.println(testType);
                if (allowedCategories.contains(testType)) {
                    break;
                } else System.out.println("Category " + testType + " is not allowed.");

            } catch (Exception e) {
                System.out.println("the category not found!");
                scan.nextLine();
            }
        }
    }

    public String getTestType() {
        return testType;
    }
}
