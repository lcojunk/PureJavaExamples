/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.sorting;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *
 * @author odzhara-ongom
 */
public class Branch {

    private static Locale defaultLocale = Locale.GERMANY;
    private String id;
    private String name;

    private String description;

    private boolean active;

    public static Comparator<Branch> getNameCompartor(Locale locale, boolean asc) {
        return new Comparator<Branch>() {
            @Override
            public int compare(Branch b1, Branch b2) {
                Collator collator;
                if (locale == null) {
                    collator = Collator.getInstance(defaultLocale);
                } else {
                    collator = Collator.getInstance(locale);
                }
                if (asc) {
                    return collator.compare(b1.getName(), b2.getName());
                } else {
                    return collator.compare(b2.getName(), b1.getName());
                }
            }
        };
    }

    public static List<Branch> sort(List<Branch> entities, Locale locale, boolean asc) {
        List<Branch> result = new ArrayList<>();
        if (entities == null || entities.size() == 0) {
            return result;
        }
        List<Branch> entitiesWithNames = entities.stream()
                .filter(b -> b != null && b.getName() != null)
                .sorted(getNameCompartor(locale, asc))
                .collect(Collectors.toList());
        result.addAll(entitiesWithNames);

        List<Branch> noNames = entities.stream()
                .filter(b -> b != null && b.getName() == null).collect(Collectors.toList());
        result.addAll(noNames);
        result.addAll(entities.stream().filter(b -> b == null).collect(Collectors.toList()));
        return result;
    }

    public Branch() {
    }

    public Branch(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Branch(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Branch(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
