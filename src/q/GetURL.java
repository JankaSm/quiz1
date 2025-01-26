package q;
import java.net.URL;

public class GetURL {
    private URL urlZadanie;
    private URL urlVysledky;

    public GetURL(TestType testType) {
        String filePathTest = "q/resources/" + testType.getFileNameTest();
        String filePathEvaluation = "q/resources/" + testType.getFileNameEvaluation();
        //System.out.println("filePathTest: "+filePathTest);
        //System.out.println("filePathEvaluation: "+filePathEvaluation);

        this.urlZadanie =  GetURL.class.getClassLoader().getResource(filePathTest);
        this.urlVysledky = GetURL.class.getClassLoader().getResource(filePathEvaluation);
        //System.out.println("urlZadanie: "+urlZadanie);
        //System.out.println("urlVysledky: "+urlVysledky);


        //    File file = new File(url.getPath());
//    //System.out.println("url " + url);
//            try(
//    BufferedReader reader = new BufferedReader(new FileReader(file)))
//
//    {
//        StringBuilder questionBuilder = new StringBuilder(); // Na zhromaždenie otázky
//        List<String> questions = new ArrayList<>(); // Zoznam otázok
//        String line;
//    }
    }

    public URL getUrlZadanie() {
        return urlZadanie;
    }

    public URL getUrlVysledky() {
        return urlVysledky;
    }
}


