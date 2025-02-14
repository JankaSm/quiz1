package q;

import java.net.URL;

public class GetURL {
    private final URL urlZadanie;
    private final URL urlVysledky;

    public GetURL(TestType testType) {
        String type = testType.getTestType();
        String fileNameTest = type + "_zadanie.txt";
        String fileNameEvaluation = type + "_vysledky.txt";
        String filePathTest = "q/resources/" + fileNameTest;
        String filePathEvaluation = "q/resources/" + fileNameEvaluation;
        this.urlZadanie = GetURL.class.getClassLoader().getResource(filePathTest);
        this.urlVysledky = GetURL.class.getClassLoader().getResource(filePathEvaluation);
    }

    public URL getUrlZadanie() {
        return urlZadanie;
    }

    public URL getUrlVysledky() {
        return urlVysledky;
    }


}


