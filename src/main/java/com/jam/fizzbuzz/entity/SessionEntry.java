package com.jam.fizzbuzz.entity;

import javax.persistence.*;

@Entity(name="SessionEntry")
@Table(name="SESSION_ENTRY")
public class SessionEntry {

    @Id
    @GeneratedValue
    @Column(name="sessionEntryKey", nullable = false)
    private int sessionEntryKey;

    @ManyToOne
    private Session session;

    @OneToOne
    private FizzBuzz fizzBuzz;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session){
        this.session = session;
    }

    public void setFizzBuzz(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public FizzBuzz getFizzBuzz() {
        return fizzBuzz;
    }

    public int getSessionEntryKey() {
        return sessionEntryKey;
    }

    public void setSessionEntryKey(int sessionEntryKey) {
        this.sessionEntryKey = sessionEntryKey;
    }
}
