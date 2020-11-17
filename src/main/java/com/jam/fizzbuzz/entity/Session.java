package com.jam.fizzbuzz.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name="Session")
@Table(name="SESSION")
public class Session {

    public Session(){}

    public Session(String sessionId){
        this.sessionId = sessionId;
    }

    @Id
    @GeneratedValue
    @Column(name="sessionKey", nullable = false)
    private int sessionKey;

    @Column(name="sessionId", nullable = false)
    private String sessionId;

    @Column(name="expirationDate", nullable = false)
    private Date expirationDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FizzBuzz> fizzBuzzes;

    public void setFizzBuzzes(List<FizzBuzz> fizzBuzzes) {
        this.fizzBuzzes = fizzBuzzes;
    }

    public void setSessionKey(int sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getSessionKey() {
        return sessionKey;
    }

    public String getSessionId() {
        return sessionId;
    }

    public List<FizzBuzz> getFizzBuzzes() {
        return fizzBuzzes;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Session)){
            throw new IllegalArgumentException("The types don't match!");
        }
        Session other = (Session) o;
        return this.sessionId.equals(other.sessionId);
    }
}
