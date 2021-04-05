import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {

        String author = "epaga";

        List<String> result = null;
        result = Result.getArticleTitles(author);

        System.out.println("Testing");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}