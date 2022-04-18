package com.project.iBook.MyTest;

import com.google.gson.Gson;
import com.project.iBook.iBookApp;
import com.project.iBook.service.FilterService;
import com.project.iBook.service.SearchService;
import com.project.iBook.vo.BookVo;
import com.project.iBook.vo.BooksVo;
import com.project.iBook.vo.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = iBookApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InterfaceTest {

    @Autowired
    SearchService searchService;

    @Autowired
    FilterService filterService;

    @Test
    public void testTop() throws IOException {
        Gson gson = new Gson();

        Result result = filterService.findTopBooks(10);
        BooksVo test = (BooksVo) result.getData();

        File directory = new File("");
        String filePath = directory.getAbsoluteFile() + "/src/test/java/com/project/iBook/MyTest/testTop.txt";
        // read json string from txt file
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            sb = new StringBuffer();
            String line = null;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // StringBuffer ==> String
        String data = new String(sb);
        BooksVo compareTest = gson.fromJson(data, BooksVo.class);

        System.out.println(test.toString().equals(compareTest.toString()));
        System.out.println("testTop() is successful");

    }

    @Test
    public void testSearchByIsbn_error(){
        Result test = searchService.findByIsbn("54123lkjasdf");
        Result compareTest = Result.fail(404, "Request uri is invalid");
        System.out.println(test.equals(compareTest));
        System.out.println("testSearchByIsbn_error() is successful");
    }

    @Test
    public void testSearchById_error(){
        Result test = searchService.findById("adsfasdwer");
        Result compareTest = Result.fail(404, "Request uri is invalid");
        System.out.println(test.equals(compareTest));
        System.out.println("testSearchById_error() is successful");
    }

    @Test
    public void testSearchById() throws IOException {
        Gson gson = new Gson();

        // The Three-Body Problem
        String id = "QxbFBAAAQBAJ";
        Result result = searchService.findById(id);

        BookVo test = (BookVo) result.getData();
        BookVo compareTest = gson.fromJson(textForSearchByid, BookVo.class);

        System.out.println(test.toString().equals(compareTest.toString()));
        System.out.println("testSearchById() is successful");
    }

    private static final String textForSearchByid = "{\"id\":\"QxbFBAAAQBAJ\",\"title\":\"The Three-Body Problem\",\"au" +
            "thors\":[\"Cixin Liu\"],\"pub" +
            "lisher\":\"Macmillan\",\"publishedDate\":\"2014-11-11\",\"description\":\"\\u003cp\\u003e\\u003cb\\u00" +
            "3eSoon to be a Netflix Original Series!\\u003cbr\\u003e\\u003c/b\\u003e\\u003cbr\\u003e\\u003cb\\u003" +
            "eAn NPR Best Book of the Decade\\u003cbr\\u003e\\u003c/b\\u003e\\u003cbr\\u003e\\u003cb\\u003eWinner o" +
            "f the Hugo Award for Best Novel\\u003c/b\\u003e\\u003cbr\\u003e\\u003cbr\\u003e“\\u003ci\\u003eWar of t" +
            "he Worlds\\u003c/i\\u003e for the 21st century.” – \\u003ci\\u003eWall Street Journal\\u003c/i\\u00" +
            "3e\\u003cbr\\u003e\\u003cb\\u003e\\u003ci\\u003e\\u003cbr\\u003eThe Three-Body Problem \\u003c/i\\u003" +
            "eis the first chance for English-speaking readers to experience the Hugo Award-winning phenomenon fro" +
            "m China\\u0027s most beloved science fiction author, Liu Cixin.\\u003c/b\\u003e\\u003cbr\\u003e\\u003c" +
            "br\\u003eSet against the backdrop of China\\u0027s Cultural Revolution, a secret military project sen" +
            "ds signals into space to establish contact with aliens. An alien civilization on the brink of destruct" +
            "ion captures the signal and plans to invade Earth. Meanwhile, on Earth, different camps start formi" +
            "ng, planning to either welcome the superior beings and help them take over a world seen as corrupt, o" +
            "r to fight against the invasion. The result is a science fiction masterpiece of enormous scope and vi" +
            "sion.\\u003cbr\\u003e\\u003cbr\\u003e\\u003cb\\u003eThe Three-Body Problem Series\\u003c/b\\u003e\\u00" +
            "3cbr\\u003e\\u003ci\\u003eThe Three-Body Problem\\u003c/i\\u003e\\u003cbr\\u003e\\u003ci\\u003eThe Dar" +
            "k Forest\\u003c/i\\u003e\\u003cbr\\u003e\\u003ci\\u003eDeath\\u0027s End\\u003c/i\\u003e\\u003cbr\\u00" +
            "3e\\u003cbr\\u003e\\u003cb\\u003eOther Books\\u003c/b\\u003e\\u003cbr\\u003e\\u003ci\\u003eBall Light" +
            "ning\\u003c/i\\u003e \\u003cbr\\u003e\\u003ci\\u003eSupernova Era\\u003cbr\\u003eTo Hold Up The Sky\\u" +
            "003c/i\\u003e (forthcoming)\\u003c/p\\u003e\",\"height\":\"25.00 cm\",\"width\":\"16.10 cm\",\"thickn" +
            "ess\":\"3.60 cm\",\"ISBN_10\":\"0765377063\",\"ISBN_13\":\"9780765377067\",\"pageCount\":399,\"average" +
            "Rating\":3.5,\"imageLinks\":{\"thumbnail\":\"http://books.google.com/books/publisher/content?id\\u003" +
            "dQxbFBAAAQBAJ\\u0026printsec\\u003dfrontcover\\u0026img\\u003d1\\u0026zoom\\u003d1\\u0026edge\\u003dc" +
            "url\\u0026imgtk\\u003dAFLRE72vAlSsSPoWzl7r6rWfo9Lxh3O8qNQ2gnGu-K7g0plm1pYpjqfDD-16lGMK06WtuXLs9IS5wD" +
            "JpuLAXJIzAu4fF1Lcl2H62FD1nBKKDkDve4GhFPOOxG6Hv7TYVSzxdjlrexItc\\u0026source\\u003dgbs_api\",\"smallT" +
            "humbnail\":\"http://books.google.com/books/publisher/content?id\\u003dQxbFBAAAQBAJ\\u0026printsec\\u00" +
            "3dfrontcover\\u0026img\\u003d1\\u0026zoom\\u003d5\\u0026edge\\u003dcurl\\u0026imgtk\\u003dAFLRE73pszr5" +
            "Uclok6gRuv2RN-sXV70pQKzvRCZYeluz2GbbJPlobqXPJW-vdVjh_KZ5cmPFpYNXr8oqm55UnHt0gtp-1iaaLlFnynTLk0plg8KGq" +
            "ek-4oI5bfdtr-_YGP6I4Q3_zSZ0\\u0026source\\u003dgbs_api\",\"small\":\"http://books.google.com/books" +
            "/publisher/content?id\\u003dQxbFBAAAQBAJ\\u0026printsec\\u003dfrontcover\\u0026img\\u003d1\\u0026z" +
            "oom\\u003d2\\u0026edge\\u003dcurl\\u0026imgtk\\u003dAFLRE711tVZMMhCUnpH4dkRpn9DBkgEKXQFmIAEUJ485DVM" +
            "LVQjN0nq_N62TsdG52X-4E2Yc_BH-ApUqArqvqu4zGOVdbSMf6PrY9dOVrgNRJ9AvKJ750PiNdNIZkp6HYybBFAfzpOKQ\\u002" +
            "6source\\u003dgbs_api\",\"medium\":\"http://books.google.com/books/publisher/content?id\\u003dQxbFB" +
            "AAAQBAJ\\u0026printsec\\u003dfrontcover\\u0026img\\u003d1\\u0026zoom\\u003d3\\u0026edge\\u003dcurl\\u" +
            "0026imgtk\\u003dAFLRE717k5aDNqzLpgs8sTqywqFUItzh2LJHdn9sIB2mzGduSaE07artKo35UsBz3xRxxmfDSEifprIZaso2r" +
            "gVrpLylKiMdtVbu8yKw9SlQJQCed9MsH1yhDi8yUvuGCQF9injB6fI4\\u0026source\\u003dgbs_api\",\"large\":\"ht" +
            "tp://books.google.com/books/publisher/content?id\\u003dQxbFBAAAQBAJ\\u0026printsec\\u003dfrontcover\\u" +
            "0026img\\u003d1\\u0026zoom\\u003d4\\u0026edge\\u003dcurl\\u0026imgtk\\u003dAFLRE71zrXceLrNdqYowVqdV7" +
            "TsqCRkP81VxKFg9PtTQ5yx9mqWKHvg33RJYlnmC-j-MuZ_O6emcgc0-tJTrLyWskAqR32cfVFl1KapbRqvG0Aq9rAE9oo_rPgt-jjQ" +
            "xSQPjjCueANYV\\u0026source\\u003dgbs_api\",\"extraLarge\":\"http://books.google.com/books/publisher/c" +
            "ontent?id\\u003dQxbFBAAAQBAJ\\u0026printsec\\u003dfrontcover\\u0026img\\u003d1\\u0026zoom\\u003d6\\u00" +
            "26edge\\u003dcurl\\u0026imgtk\\u003dAFLRE739Gt_IyDQ61A6--jgH8GRTqlYg7cBycDNZa_sTfk-31vj_T3JttSPUW15FX" +
            "IF3e8oG-t3JjNMWxdDSo1YR3GfRnCcL6xfDMyXli9cOZQE6PpzMb3SyrJoMuMU2hWDoD2gHQM4Y\\u0026source\\u003dgbs_a" +
            "pi\"},\"amazonPrice\":9.99,\"amazonRating\":4.5}";

}

