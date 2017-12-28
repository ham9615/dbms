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
public class constructorModel {
    
    private String teamid;
    private String teamname;
    private String location;
    private String carid;
    private int championship;

    public constructorModel(String teamid, String teamname, String location, String carid, int championship) {
        this.teamid = teamid;
        this.teamname = teamname;
        this.location = location;
        this.carid = carid;
        this.championship = championship;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public int getChampionship() {
        return championship;
    }

    public void setChampionship(int championship) {
        this.championship = championship;
    }
    
    
    
}
