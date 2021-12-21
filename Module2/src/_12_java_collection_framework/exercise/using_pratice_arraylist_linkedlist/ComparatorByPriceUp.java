package _12_java_collection_framework.exercise.using_pratice_arraylist_linkedlist;

import java.util.Comparator;

public class ComparatorByPriceUp implements Comparator<Products> {
    @Override
    public int compare(Products o1, Products o2) {
        return o1.getPrice()- o2.getPrice();
    }
}
