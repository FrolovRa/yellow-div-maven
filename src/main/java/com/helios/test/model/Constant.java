package com.helios.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Constant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int number;

    public Constant(int number){
        this.number = number;
    }

    public Constant(){}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
