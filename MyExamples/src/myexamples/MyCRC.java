/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.CRC32;
import myexamples.lambda.AcceptDummy;
import myexamples.lambda.AcceptDummyImpl;
import myexamples.lambda.DummyClass;

/**
 *
 * @author odzhara-ongom
 */
public class MyCRC {

    private static <T> T returnObject(T inp) {
        return inp;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add(null);
        strings.add("two");
        List<String> filtered = processT(strings);
        strings.stream().forEach(s -> System.out.println(s));
        filtered.stream().forEach(s -> System.out.println(s));

        List<AcceptDummyImpl> list = new ArrayList<>();
        AcceptDummyImpl impl = new AcceptDummyImpl();
        list.add(null);
        list.add(impl);
        List<AcceptDummyImpl> list1 = processTT(list);
        list1.stream().forEach(ad -> {
            if (ad == null) {
                System.out.println("null");
            } else {
                System.out.println("full");
            }
        });
    }

    private static void testReturnObject() {
        Date date = new Date();
        System.out.println(returnObject(date).getTime());
    }

    public static <T> List<T> processT(List<T> params) {
        List<T> result = new ArrayList<T>();
        for (T param : params) {
            if (param != null) {
                result.add(param);
            }
        }
        return result;
    }

    public static <T extends AcceptDummy> List<T> processTT(List<T> params) {
        return params.stream().filter(param -> param != null).collect(Collectors.toList());
    }

    private static void testMyCRC() {
        CRC32 crc32 = new CRC32();
        byte[] bytes = new byte[10];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = 1;
        }
        crc32.update(bytes);
        System.out.println((int) crc32.getValue());
    }
}
