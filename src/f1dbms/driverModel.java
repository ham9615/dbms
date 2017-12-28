/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

/**
 *
 * @author ADI
 */
public class driverModel {
    
    private String driverid;
    private String name;
    private String nationality;
    private String team;
    private int age;
    private int race;
    private int pole;
    private int win;
    private int championship;

    public driverModel(String driverid, String name, String nationality, String team, int age, int race, int pole, int win, int championship) {
        this.driverid = driverid;
        this.name = name;
        this.nationality = nationality;
        this.team = team;
        this.age = age;
        this.race = race;
        this.pole = pole;
        this.win = win;
        this.championship = championship;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRaces() {
        return race;
    }

    public void setRaces(int race) {
        this.race = race;
    }

    public int getPole() {
        return pole;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getChampionship() {
        return championship;
    }

    public void setChampionship(int championship) {
        this.championship = championship;
    }
    
    
    
    
}
