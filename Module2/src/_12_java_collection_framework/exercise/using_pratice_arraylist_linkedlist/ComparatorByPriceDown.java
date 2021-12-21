package _12_java_collection_framework.exercise.using_pratice_arraylist_linkedlist;

import java.util.Comparator;

public class ComparatorByPriceDown implements Comparator<Products> {
    @Override
    public int compare(Products o1, Products o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
