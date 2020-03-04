/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.characters;

import dao.characters.characters;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dec72
 */
public enum charactersDAO {
    instance;
    private Connection con = null;
    //------------------------------------------------
    // create connection to DB
    //------------------------------------------------
    private charactersDAO(){
        try{
         System.out.println("Loading DB Driver...");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("DB Driver Loaded!");
            
            con = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/DnD",
            "DnD",
            "DnD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------
    // Get All characters
    //------------------------------------------------
    public List<characters> getAllCharacters(){
        List<characters> Characters = new ArrayList<characters>();
        try {
            String sql = "SELECT * FROM characters";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String race = rs.getString("race");
                String player_class = rs.getString("player_class");
                int level = rs.getInt("level");
                String campaign_name = rs.getString("campaign_name");
                Characters.add(new characters(id, name, race, player_class, level, campaign_name));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Characters;
    }
    //------------------------------------------------
    // Get Character by ID
    //------------------------------------------------
    public characters getCharacter(int Theid){
        characters character = null;
        try {
            String sql = "SELECT * FROM characters WHERE id = ?";
        
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, Integer.toString(Theid));
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String race = rs.getString("race");
                    String player_class = rs.getString("player_class");
                    int level = rs.getInt("level");
                    String campaign_name = rs.getString("campaign_name");
                    character = new characters(id, name, race, player_class, level, campaign_name);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return character;
    }
    //------------------------------------------------
    // POST - add new character to the DB
    //------------------------------------------------
    public boolean addCharacter(characters character){
	int id = character.getId();
        String name = character.getName();
        String race = character.getRace();
        String player_class = character.getPlayer_class();
        int level = character.getLevel();
        String campaign_name = character.getCampaign_name();
        try {
            String sql = "INSERT INTO characters VALUES(?, ?, ?, ?, ?, ?)";
        
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, race);
            preparedStatement.setString(4, player_class);
            preparedStatement.setInt(5, level);
            preparedStatement.setString(6, campaign_name);
            boolean count = preparedStatement.execute();
            preparedStatement.execute();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------
    // PUT - update character in the DB 
    //------------------------------------------------
    public boolean updateCharacter(characters character){
	int id = character.getId();
        String name = character.getName();
        String race = character.getRace();
        String player_class = character.getPlayer_class();
        int level = character.getLevel();
        String campaign_name = character.getCampaign_name();
        try {
            String sql = "UPDATE characters "
                    + "SET name = ?, "
                    + "race = ?,"
                    + "player_class = ?,"
                    + "level = ?,"
                    + "campaign_name = ?"
                    + "WHERE id = ?";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, race);
            preparedStatement.setString(3, player_class);
            preparedStatement.setInt(4, level);
            preparedStatement.setString(5, campaign_name);
            preparedStatement.setInt(6, id);
            boolean count = preparedStatement.execute();
            preparedStatement.execute();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //------------------------------------------------
    // DELETE - delete character from DB 
    //------------------------------------------------
    public void deleteCharacter(int id){
        try {
            String sql = "DELETE FROM characters WHERE id = ?";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, Integer.toString(id));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // END OF FILE
}
