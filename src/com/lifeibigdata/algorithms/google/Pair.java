package com.lifeibigdata.algorithms.google;

/**
 * Created by lifei on 16/5/23.
 */
public class Pair{
    public String end;
    public int weight;
    public Pair(String end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    public Pair() {
    }
    @Override
    public String toString() {
        return "Pair [end=" + end + ", weight=" + weight + "]";
    }
}