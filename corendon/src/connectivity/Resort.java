/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectivity;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.Session;

/**
 *
 * @author mark
 */
public class Resort {
    
    
    DbManager db = new DbManager();
    
    public Resort() {
        db.openConnection();
    }

    
    
    private int id;
    private int phone;
    private String email;
    private String name;
    private String address;
    private String country;
    private String city;
    private String postalCode;

    public Resort(int id, int phone, String email, String name, String address, String country, String city, String postalCode) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
  
    
     public DbManager getDb() {
        return db;
    }
    
    /**
     * Create a new resort. 
     * @param tfName
     * @param tfAddress
     * @param tfCountry
     * @param tfCity
     * @param tfPhoneResort
     * @param tfEmail
     * @param tfpostalCode 
     */
    public void setNewResort(String tfName, String tfAddress, String tfCountry, String tfCity,
            String tfPhoneResort, String tfEmail, String tfpostalCode) {
        
        String sql = "INSERT INTO `resort` (resort_name, address, country, city,"
                + "phone_resort, email, postal_cod)"
                + "VALUES ('" + tfName + "', '" 
                + tfAddress + "', '" 
                + tfCountry + "', '"
                + tfCity + "', '"
                + tfPhoneResort + "', '"
                + tfEmail + "', '"
                + tfpostalCode + "')";
        
        db.doQuery(sql);       
    }
    
    
    /**
     * Delete a single resort record.
     * @param tfResortId 
     */
    public void deleteResort(String tfResortId)
    {
        String sql = "DELETE FROM `resort` WHERE `resort_id` = '" + tfResortId + "'";
        db.insertQuery(sql);
    }
    
    /**
     * Update a resort record.
     * @param tfId
     * @param tfName
     * @param tfAddress
     * @param tfCountry
     * @param tfCity
     * @param tfPhoneResort
     * @param tfEmail
     * @param tfpostalCode 
     */
    public void updateResort(int tfId, String tfName, String tfAddress, String tfCountry, String tfCity,
            String tfPhoneResort, String tfEmail, String tfpostalCode) 
    {
        
       String sql = "UPDATE `resort` SET `resort_name` = '" + tfName + "'"
               + ", `address` = '" + tfAddress + "'"
               + ", `country` = '" + tfCountry + "'"
               + "', `city` = '" + tfCity + "'"
               + "', `phone_resort` = '" + tfPhoneResort + "'"
               + "', `email` = '" + tfEmail + "'"
               + "', `postal_code` = '" + tfpostalCode + "'"
               +  "WHERE `resort_id` =" + tfId;    
        
        db.insertQuery(sql);
    }
    
    
    /**
     * get a single resort record.
     * @param tfInput
     * @param databaseVariable 
     */
    public void getResortDate(String tfInput, String databaseVariable) {

        try {
            String sql = "SELECT *, COUNT(*) as `rows` FROM `resort` WHERE `"
                    + databaseVariable + "`='" + tfInput + "'";

            ResultSet result = getDb().doQuery(sql);
            if (result.next()) {

                if (result.getInt("rows") >= 0) {
                    this.setId(result.getInt("resort_id"));
                    this.setName(result.getString("resort_name"));
                    this.setAddress(result.getString("address"));
                    this.setCity(result.getString("city"));
                    this.setPhone(result.getInt("phone_resort"));
                    this.setEmail(result.getString("email"));
                    this.setPostalCode(result.getString("postal_code"));
                } else {
                    System.out.println("SOMETING WENT WRONG");
                }
            }

        } catch (SQLException e) {
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());
        }
    }
    
       
      
        
        
        
    
    
}
    
    

    
    

    

    
    
    
    

