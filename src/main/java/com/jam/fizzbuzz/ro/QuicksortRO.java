package com.jam.fizzbuzz.ro;

import java.util.List;

public class QuicksortRO {
    private List<Integer> unsorted;
    private List<Integer> sorted;

    public void setUnsorted(List<Integer> unsorted){
        this.unsorted = unsorted;
    }

    public List<Integer> getUnsorted(){
        return this.unsorted;
    }

    public void setSorted(List<Integer> sorted){
        this.sorted = sorted;
    }

    public List<Integer> getSorted(){
        return this.sorted;
    }
}
