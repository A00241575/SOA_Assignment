/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.characters;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Characters")
@XmlType (propOrder = {"id", "name", "race", "player_class", "level", "campaign_name"})
/**
 * Character Object class for D&D characters
 * @author dec72
 */
public class characters {
    private int id;
    private String name;
    private String race;
    private String player_class;
    private int level;
    private String campaign_name;
    
    public characters(int id, String name, String race, String player_class, int level, String campaign_name){
        this.id = id;
        this.name = name;
        this.race = race;
        this.player_class = player_class;
        this.level = level;
        this.campaign_name = campaign_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayer_class() {
        return player_class;
    }

    public void setPlayer_class(String player_class) {
        this.player_class = player_class;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
    }
    
}
