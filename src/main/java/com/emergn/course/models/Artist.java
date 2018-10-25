package com.emergn.course.models;

public class Artist {
    private String name;
    private Integer year;
    private Integer numberOfSong;

    public Artist(String name, Integer year, Integer numberOfSong) {
        this.name = name;
        this.year = year;
        this.numberOfSong = numberOfSong;
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
