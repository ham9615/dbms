/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import java.sql.Date;

/**
 *
 * @author ADI
 */
public class calendarModel {
    
    private String circuitcode;
    private String circuitname;
    private Date   racedate;
    private String pole;
    private String winner;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public calendarModel(String circuitcode,String location, String circuitname, Date racedate, String pole, String winner) {
        this.circuitcode = circuitcode;
        this.circuitname = circuitname;
        this.racedate = racedate;
        this.pole = pole;
        this.winner = winner;
    }

    public String getCircuitcode() {
        return circuitcode;
    }

    public void setCircuitcode(String circuitcode) {
        this.circuitcode = circuitcode;
    }

    public String getCircuitname() {
        return circuitname;
    }

    public void setCircuitname(String circuitname) {
        this.circuitname = circuitname;
    }

    public Date getRacedate() {
        return racedate;
    }

    public void setRacedate(Date racedate) {
        this.racedate = racedate;
    }

    public String getPole() {
        return pole;
    }

    public void setPole(String pole) {
        this.pole = pole;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    
    
    
    
    
}
