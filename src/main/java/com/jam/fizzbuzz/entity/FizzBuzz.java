package com.jam.fizzbuzz.entity;

import javax.persistence.*;

@Entity
public class FizzBuzz implements Comparable{

    @Id
    @GeneratedValue
    @Column(name="ipk", nullable = false)
    private int ipk;
    @Column(name="counter", nullable = false)
    private int counter;
    @Column(name="replacement", nullable = false)
    private String replacement;
    @Column(name="ordinal", nullable = false)
    private int ordinal;

    public FizzBuzz(){};

    public FizzBuzz(int value, String replacement, int ordinal){
        this.counter = value;
        this.replacement = replacement;
        this.ordinal = ordinal;
    }

    public Integer getIpk(){
        return ipk;
    }

    public void setIpk(int ipk){
        this.ipk = ipk;
    }

    public void setCounter(Integer counter){
        this.counter = counter;
    }

    public void setReplacement(String replacement){
        this.replacement = replacement;
    }

    public void setOrdinal(Integer ordinal){
        this.ordinal = ordinal;
    }

    public Integer getCounter(){
        return this.counter;
    }

    public String getReplacement(){
        return this.replacement;
    }

    public Integer getOrdinal(){
        return this.ordinal;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof FizzBuzz)){
            throw new IllegalArgumentException("Don't try to compare something that isn't of the right class");
        }
        FizzBuzz other = (FizzBuzz) o;
        return Integer.compare(this.ordinal, other.ordinal);
    }
}
