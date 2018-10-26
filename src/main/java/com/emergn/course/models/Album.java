package com.emergn.course.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private Integer year;
    private Integer numberOfSong;

    public Album(String name, Integer year, Integer numberOfSong) {
        this.name = name;
        this.year = year;
        this.numberOfSong = numberOfSong;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSong(Integer numberOfSong) {
        this.numberOfSong = numberOfSong;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberOfSong() {
        return numberOfSong;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }
}
