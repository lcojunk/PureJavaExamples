/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.sorting;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *
 * @author odzhara-ongom
 */
public class SortingExample implements Runnable {

    private void simpleListOfStringTest() {
        List<String> words = Arrays.asList(
                "äbc", "Abc", "Äbc", "abc", "aäbc", "bca"
        );
        System.out.println(Locale.getDefault());
        Collator coll = Collator.getInstance(Locale.GERMANY);
        Collections.sort(words, coll);
        words.stream().forEach(word -> System.out.println(word));
        System.out.println("a-a=" + coll.compare("a", "a"));
        System.out.println("b-a=" + coll.compare("b", "a"));
        System.out.println("a-b=" + coll.compare("a", "b"));
    }

    private void testBranchSorting() {
        List<Branch> branches = new ArrayList<>();
        branches.add(new Branch("äbc", null));
        branches.add(new Branch("Abc", null));
        branches.add(new Branch("Äbc", null));
        branches.add(new Branch("abc", null));
        branches.add(new Branch("aäbc", null));
        branches.add(new Branch("bca", null));
        Collections.sort(branches, new BranchComparator().withCollator(Collator.getInstance(Locale.GERMANY)));
        branches.stream().forEach(branch -> System.out.println(branch.getName()));
        System.out.println(branches.stream().filter(b -> b == null).collect(Collectors.toList()).size());
    }

    private void testBranchSorting2() {
        List<Branch> branches = new ArrayList<>();
        branches.add(new Branch("äbc", null));
        branches.add(new Branch("Abc", null));
        branches.add(new Branch("Äbc", null));
        branches.add(null);
        branches.add(new Branch("abc", null));
        branches.add(new Branch("aäbc", null));
        branches.add(new Branch(null, "abc"));
        branches.add(new Branch("bca", null));
        printBranchNames(branches);
        System.out.println("---- now sorted asc ----");
        List<Branch> sortedBranches = Branch.sort(branches, Locale.GERMANY, true);
        printBranchNames(sortedBranches);
        System.out.println("---- now sorted desc ----");
        printBranchNames(Branch.sort(branches, Locale.GERMANY, false));

    }

    private void printBranchNames(List<Branch> branches) {
        if (branches == null) {
            System.out.println("null list");
            return;
        }
        branches.stream().forEach(branch -> {
            if (branch != null) {
                System.out.println(branch.getName());
            } else {
                System.out.println("null branch");
            }
        });
    }
//-------------------------------------------------------------------------

    private void runTests() {
        simpleListOfStringTest();
        testBranchSorting();
        System.out.println("-------------------------------------");
        testBranchSorting2();
    }

    @Override
    public void run() {
        System.out.println("Runing SortingExample...");
        runTests();
        System.out.println("Done");
    }

}
