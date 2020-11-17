package com.jam.fizzbuzz.entity;

import javax.persistence.*;

@Entity(name="FizzBuzz")
@Table(name="FIZZ_BUZZ")
public class FizzBuzz implements Comparable<FizzBuzz>{

    @Id
    @GeneratedValue
    @Column(name="fizzBuzzKey", nullable = false)
    private int fizzBuzzKey;
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

    public Integer getFizzBuzzKey(){
        return fizzBuzzKey;
    }

    public void setFizzBuzzKey(int fizzBuzzKey){
        this.fizzBuzzKey = fizzBuzzKey;
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
    public int compareTo(FizzBuzz other) {
        return Integer.compare(this.ordinal, other.ordinal);
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof FizzBuzz)){
            throw new IllegalArgumentException("The types don't match");
        }
        FizzBuzz other = (FizzBuzz) o;
        return this.counter == other.counter && this.ordinal == other.ordinal && this.replacement.equals(other.replacement);
    }
}
