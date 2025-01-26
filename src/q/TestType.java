package q;
//package sources;


import java.util.Scanner;
import java.util.Set;

public class TestType {
    private String testType;
    private String fileNameTest;
    private String fileNameEvaluation;

    public void TestType() {
        Scanner scan = new Scanner(System.in);
        Set<String> allowedCategories = Set.of("P3", "P4", "P5", "P6", "P7");

        while (true) {
            try {
                System.out.println("Define your category (P3, P4, P5, P6, P7): ");
                this.testType = scan.nextLine().trim();
                if (allowedCategories.contains(testType.toUpperCase())) {
                    break;
                } else System.out.println("Category " + testType + " is not allowed.");

            } catch (Exception e) {
                System.out.println("the category not found!");
                scan.nextLine();
            }
        }
        fileNameTest = testType.toUpperCase() + "_zadanie.txt";
        fileNameEvaluation = testType.toUpperCase() + "_vysledky.txt";
        System.out.println("fileNameTest: "+ fileNameTest);
        System.out.println("fileNameEvaluation: "+ fileNameEvaluation);

    }
//    public TestType(String fileNameTest, String fileNameEvaluation) {
//        this.fileNameTest = fileNameTest;
//        this.fileNameEvaluation = fileNameEvaluation;
//    }

    public String getFileNameTest() {
        return fileNameTest;
    }


    public String getFileNameEvaluation() {
        return fileNameEvaluation;
    }

}
