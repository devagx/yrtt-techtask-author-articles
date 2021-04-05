import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Result {
    /*
     * Complete the 'getArticleTitles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING author as parameter.
     *
     * URL for cut and paste:
     * https://jsonmock.hackerrank.com/api/articles?author=<authorName>&page=<num>
     *
     */

    private static String CreateConnection(String uri, String author, long page) throws IOException {
        String inline = "";
        URL url = null;
        int responsecode = 0;
        HttpURLConnection conn = null;
        if (page == -1) {
            uri = String.format(uri, author);
        } else {
            uri = String.format(uri, author, page);
        }

        url = new URL(uri);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();

        if (responsecode != 200)
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inline += sc.nextLine();
            }
            sc.close();
        }
        return inline;
    }

    public static List<String> getArticleTitles(String author) throws IOException {
        HttpURLConnection conn = null;
        String uri = "https://jsonmock.hackerrank.com/api/articles?author=%s";
        List<String> resultsList = new ArrayList<>();
        JSONParser parse = null;
        JSONObject jobj = null;
        String result = "";

        result = CreateConnection(uri, author, -1);

        //Parse JSON to JSON Object
        parse = new JSONParser();

        try {
            jobj = (JSONObject) parse.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long totalPage = (long) jobj.get("total_pages");

        for (int page = 1; page <= totalPage; page++) {
            uri = "https://jsonmock.hackerrank.com/api/articles?author=%s&page=%s";
            result = "";
            result = CreateConnection(uri, author, page);

            //Parse JSON to JSON Object
            parse = new JSONParser();
            jobj = null;
            try {
                jobj = (JSONObject) parse.parse(result);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");

            //Loop JSON object
            for (int i = 0; i < jsonarr_1.size(); i++) {
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                String title = (String) jsonobj_1.get("title");
                String storyTitle = (String) jsonobj_1.get("story_title");
                String finalTitle = "";
                if ((title != null) && title.length() > 0) {
                    resultsList.add(title);
                } else if ((storyTitle != null && storyTitle.length() > 0)) {
                    resultsList.add(storyTitle);
                }
            }
        }
        return resultsList;
    }
}
