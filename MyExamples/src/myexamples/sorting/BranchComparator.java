/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.sorting;

import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @author odzhara-ongom
 */
public class BranchComparator implements Comparator<Branch> {

    private Collator collator;

    public BranchComparator withCollator(Collator c) {
        collator = c;
        return this;
    }

    @Override
    public int compare(Branch b1, Branch b2) {
        return collator.compare(b1.getName(), b2.getName());
    }

}
