package _12_java_collection_framework.exercise.using_pratice_arraylist_linkedlist;

import _12_java_collection_framework.practice.comparator_comparable.Student;

public class Products implements Comparable < Products > {
    private int id;
    private int price;
    private String name;
    private String information;

    public Products() {
    }

    public Products(int id, int price, String name, String information) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id=" + id +
                ", price=" + price +
                ", name='" + name +
                ", information='" + information ;
    }

    @Override
    public int compareTo(Products o) {
        return this.getPrice() - o.getPrice();
    }
}
