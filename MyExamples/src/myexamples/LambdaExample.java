/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import myexamples.lambda.DummyArticle;
import myexamples.lambda.DummyClass;
import myexamples.lambda.DummyPerson;
import myexamples.lambda.LambdaServices;

/**
 *
 * @author odzhara-ongom
 */
public class LambdaExample {

    private static String[] names = {"Klaus", "Klara", "John", "James", "Kurt", "Jane"};

    public static void main(String[] args) {
        testJavaSet();
//        findByIdUsage();
//        example1();
//        example2();
//        exampleParallelExecCompare();
//        example3();

    }

    private static void testExistsString() {
        List<String> ll = new ArrayList<>();
        ll.add("123");
        ll.add("456");
        System.out.println(existsString(ll, "456"));
        System.out.println(existsString(ll, "123"));
        System.out.println(existsString(ll, "12"));
    }

    private static void testClearAllDuplicates() {
        List<String> ll = new ArrayList<>();
        ll.add("123");
        ll.add("456");
        ll.add("123");
        ll.add("456");
        ll.add("756");
        ll.add("456");
        ll.add("756");
        ll.add("456");
        List<String> ll1 = clearAllDuplicates(ll);
        ll.stream().forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        ll1.stream().forEach(s -> System.out.println(s));
    }

    private static List<String> clearAllDuplicates(List<String> strings) {
        return strings.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
    }

    private static void testJavaSet() {
        Set<String> set = new HashSet<>();
        set.add("test");
        set.add("test");
        set.add("test2");
        set.add(null);
        set.add(null);
        set.stream().forEach(s -> System.out.println(s));

    }

    private static void testToMap() {
        List<TweetEntity> tweets = new ArrayList<>();
        tweets.add(new TweetEntity(null, "name1", "tweet1"));
        tweets.add(new TweetEntity(null, "name2", "tweet2"));
        tweets.add(new TweetEntity(null, "name3", "tweet3"));
        tweets.add(new TweetEntity(null, "name1", "tweet3"));
        Map<String, String> tweetMap = new HashMap<>();
        tweets.stream().forEach(tweet -> tweetMap.put(tweet.getName(), tweet.getTweet()));
        //Map<String, String> tweetMap = tweets.stream().collect(Collectors.toMap(TweetEntity::getName, TweetEntity::getTweet));
        tweetMap.forEach((key, value) -> System.out.println(key + ":" + value));
        tweets.stream().collect(Collectors.toSet());
    }

    private static void testToSet() {
        List<TweetEntity> tweets = new ArrayList<>();
        tweets.add(new TweetEntity(null, "name1", "tweet1"));
        tweets.add(new TweetEntity(null, "name2", "tweet2"));
        tweets.add(new TweetEntity(null, "name3", "tweet3"));
        tweets.add(new TweetEntity(null, "name1", "tweet3"));
        Set<TweetEntity> tSet = tweets.stream().collect(Collectors.toSet());
        tSet.stream().forEach(t -> System.out.println(t.getName() + ":" + t.getTweet()));

    }

    private static void testNewList() {
        List<TweetEntity> tweets = new ArrayList<>();
        tweets.add(new TweetEntity(null, "name1", "tweet1"));
        tweets.add(new TweetEntity(null, "name2", "tweet2"));
        tweets.add(new TweetEntity(null, "name3", "tweet3"));
        tweets.add(new TweetEntity(null, "name1", "tweet3"));
        List<TweetEntity> newTweets = tweets.stream().collect(Collectors.toList());
        tweets = new ArrayList<>();
        tweets.add(new TweetEntity(null, "name5", "tweet5"));
        tweets.stream().forEach(t -> System.out.println(t.getName() + ":" + t.getTweet()));
        System.out.println("-----------------------------");
        newTweets.stream().forEach(t -> System.out.println(t.getName() + ":" + t.getTweet()));

    }

    private static boolean existsString(List<String> ll, String refId) {
        return ll.stream().filter(id -> id.equals(refId)).findFirst().isPresent();
    }

    private static void assertPrint(String message, boolean b) {
        if (b == true) {
            System.out.println(message + ":" + b);
        }
    }

    private static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    private static void checkValidateIdList() {
        assertPrint("check null list:", validateIdList(null) == null);
        List<String> checkList = new ArrayList<>();
        assertPrint("check leer list:", validateIdList(checkList) == null);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                checkList.add(null);
            } else {
                checkList.add("boom");
            }
        }
        assertPrint("check list size:", validateIdList(checkList).size() == 5);
        for (String s : validateIdList(checkList)) {
            assertPrint("check string not null:", s != null);
        }
    }

    private static List<String> validateIdList(List<String> idList) {
        if (isEmpty(idList)) {
            return null;
        }
        List<String> result = idList.stream().filter(id -> id != null).collect(Collectors.toList());
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    private static List<?> filterNullObjects(List<?> objects) {
        if (isEmpty(objects)) {
            return null;
        }
        List<?> result = objects.stream().filter(o -> o != null).collect(Collectors.toList());
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    private static void example3() {
        List<DummyArticle> articles = null;
        Optional<DummyArticle> optional = Optional.empty();
        System.out.println(optional.isPresent());
        System.out.println(findArticleById(5, articles).isPresent());
        articles = createArticles(10);
        System.out.println(findArticleById(15, articles).isPresent());
        findArticleById(1, articles).ifPresent(article -> System.out.println("Article found: " + DummyArticle.toString(article)));

        //System.out.println(findArticleById(1, articles).ifPresent(article->System.out.println("")));
        System.out.println(findArticleById(null, articles).isPresent());
    }

    private static Optional<DummyArticle> findArticleById(Integer id, List<DummyArticle> list) {
        if (id == null || list == null || list.size() == 0) {
            return Optional.empty();
        }
        return list.stream()
                .filter(entity -> entity != null)
                .filter(entity -> entity.getId() != null)
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    private static List<DummyPerson> createDummies(int n) {
        List<DummyPerson> allPersons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            allPersons.add(new DummyPerson(i, names[i % names.length], new Date(), random.nextInt(30) + 155, random.nextInt(10000) / 10.0 + 500));
        }
        return allPersons;
    }

    private static List<DummyArticle> createArticles(int n) {
        List<DummyPerson> allPersons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n / 2 + 1; i++) {
            allPersons.add(new DummyPerson(i, names[i % names.length], new Date(), random.nextInt(30) + 155, random.nextInt(10000) / 10.0 + 500));
        }
        List<DummyArticle> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            articles.add(new DummyArticle(i, "Titel Nr" + i, new Date(), "Main text" + i, allPersons.get(i % allPersons.size())));
        }
        return articles;
    }

    private static void findByIdUsage() {
        int n = 20;
        List<DummyPerson> allPersons = createDummies(n);
        allPersons.stream().forEach(person -> System.out.println(DummyPerson.toString(person)));
        System.out.println("----------------------------------------------");
        allPersons.stream()
                .filter(person -> person.getWeight() > 170)
                .collect(Collectors.toList())
                .stream()
                .forEach(person -> System.out.println(DummyPerson.toString(person)));
    }

    private static Optional<DummyPerson> findDummyById(Integer id, List<DummyPerson> pList) {
        return pList.stream()
                .filter(person -> person.getId() == id.intValue())
                .findFirst();
    }

    private static Optional<DummyPerson> findById(Integer id, List<DummyPerson> list) {
        if (id == null || list == null || list.size() == 0) {
            return Optional.empty();
        }
        return list.stream()
                .filter(person -> person != null)
                .filter(person -> person.getId() != 0)
                .filter(person -> person.getId() == id.intValue())
                .findFirst();
    }

    private static void exampleParallelExecCompare() {
        int arrSize = 300000000;

        List<Integer> testList = createArray(arrSize, 100);
        long timestamp = System.currentTimeMillis();
        int sum = addIntegers(testList);
        System.out.println(sum + "; time=" + (System.currentTimeMillis() - timestamp));
        timestamp = System.currentTimeMillis();
        sum = addIntegersSeq(testList);
        System.out.println(sum + "; timeSeq=" + (System.currentTimeMillis() - timestamp));
    }

    private static void example2() {
        Random random = new Random();
        List<DummyClass> dummyList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dummyList.add(new DummyClass(random.nextInt(100)));
        }
        List<DummyClass> list;
        Object[] o = dummyList.stream().filter(a -> a.getId() > 10).toArray();
        dummyList.stream().filter(a -> a.getId() > 10);

        list = dummyList.stream().filter(a -> a.getId() > 10).collect(Collectors.toList());
//        dummyList.stream().map(a->a.getId()).forEach(b->{System.out.println(b.getClass().getName());});
//        for(DummyClass d:list){
//            d.print();
//        }
//        Iterator <DummyClass> iterator=list.iterator();
//        while (iterator.hasNext()) {
//            DummyClass next = iterator.next();
//            next.print();
//        }
//
        dummyList.stream()
                .filter(dummy -> dummy.isOdd())
                .map(dummy -> dummy.toString())
                .forEach(dummyString -> {
                    System.out.println("dummyString=" + dummyString);
                });
    }

    private static void example1() {
        DummyClass dummyClass = new DummyClass(0);
        LambdaServices lambdaServices = new LambdaServices();
        System.out.println("is not null? " + lambdaServices.getServiceNotNull().accept(dummyClass));
        System.out.println("is odd? " + lambdaServices.getServiceOdd().accept(dummyClass));
        System.out.println("is even? " + lambdaServices.getServiceEven().accept(dummyClass));
        System.out.println("is ten? " + lambdaServices.getServiceTen().accept(dummyClass));
    }

    private static int addIntegers(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }

    private static int addIntegersSeq(List<Integer> values) {
        int result = 0;
        for (Integer i : values) {
            result = result + i;
        }
        return result;
    }

    private static ArrayList<Integer> createArray(int size, int max) {
        Random random = new Random();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {

            result.add(random.nextInt(max) - (max / 2));
        }
        return result;
    }

}
