package com.example.tomap.loginreal;

public class UserInfo {

    String name;
    String age;
    String instrument;
    String genre;
    String skill;

    public UserInfo(){

    }

    public UserInfo(String name, String age, String instrument, String genre, String skill){
        this.name = name;
        this.age = age;
        this.instrument = instrument;
        this.genre = genre;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getInstrument() {
        return instrument;
    }
    public String getGenre() {
        return genre;
    }

    public String getSkill() {
        return skill;
    }
}
