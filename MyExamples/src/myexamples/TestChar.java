/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import static java.lang.Math.round;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author odzhara-ongom
 */
public class TestChar {

    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static String cost2String(double cost) {
        if (round(cost) == cost) {
            return round(cost) + "";
        }
        long rest = round((cost - round(cost)) * 100);
        if (rest > 9) {
            return round(cost) + ". " + rest;
        } else {
            return round(cost) + ". 0" + rest;
        }
    }

    public static String showSettings() {
        String settings = "{\n"
                + "    \"settings\": {\n"
                + "        \"analysis\": {\n"
                + "            \"char_filter\": {\n"
                + "                \"breakAtPoint\": {\n"
                + "                    \"type\":       \"mapping\",\n"
                + "                    \"mappings\": [ \".=>. . \"]\n"
                + "            }},\n"
                + "            \"analyzer\": {\n"
                + "                \"emailAnalyzer\": {\n"
                + "                    \"type\":         \"custom\",\n"
                + "                    \"char_filter\":  [ \"breakAtPoint\" ],\n"
                + "                    \"tokenizer\":    \"standard\",\n"
                + "                    \"filter\":       [ \"lowercase\"]\n"
                + "                    \n"
                + "            }}\n"
                + "}}}";
        return settings;
    }

    public static String dateToSearchString(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("MMMMM MM/yyyy").format(date);
    }

    public static Date addYearsToDate(Date date, int years) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        long dateLong = 1422745200000L;
        Date date = new Date(dateLong);
        System.out.println("date=" + date.toString());
        System.out.println(dateToSearchString(date));
        System.out.println(date.toLocaleString());
        System.out.println(date.toGMTString());
        System.out.println(dateToSearchString(addYearsToDate(date, 1)));
        System.out.println(dateToSearchString(addYearsToDate(date, 0)));
        System.out.println(dateToSearchString(addYearsToDate(date, -1)));
        System.out.println(dateToSearchString(addYearsToDate(date, -3)));
        System.out.println(dateToSearchString(addYearsToDate(date, -5)));

    }

    public static void testSort() {
        List<TweetEntity> tList = new ArrayList<>();
        tList.add(new TweetEntity((new Date()).toGMTString(), "one", " one tweet of one", 5));
        tList.add(new TweetEntity((new Date()).toGMTString(), "one", " second tweet of one", 2));
        tList.add(new TweetEntity((new Date()).toGMTString(), "two", " one tweet of two", 10));
        tList.add(new TweetEntity((new Date()).toGMTString(), "two", " second tweet of two", 4));
        Collections.sort(tList, new Comparator<TweetEntity>() {
//            @Override public int compare(TweetEntity p1, TweetEntity p2) {
//                return (int) (p1.getUser_id() - p2.getUser_id()); // Ascending
//            }
            @Override
            public int compare(TweetEntity p1, TweetEntity p2) {
                return p1.getTweet().compareTo(p2.getTweet()); // Ascending
            }

        });
        for (TweetEntity t : tList) {
            System.out.println(t.getTweet());
        }

        System.out.println(("").compareTo("two"));
    }

    public static void testMyChar() {
        char c = 'a';
        int x = c;
        System.out.println(c + "=" + x);

        int n = 10;
        String[] words = generateRandomWords(n);
        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }

        double cost1 = 10000000000.99;
        double cost2 = 10000000000.98;
        double cost = cost1 - cost2;
        System.out.println("cost=" + (cost));
        double wert = 10000000001.3201;
        System.out.println(cost2String(wert));
        System.out.println(showSettings());
    }
}
