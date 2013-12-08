

package connectivity;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



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
    private String phone;
    private String email;
    private String name;
    private String address;
    private String country;
    private String city;
    private String postalCode;
    
/**
 * Constructor.
 * @param id
 * @param phone
 * @param email
 * @param name
 * @param address
 * @param country
 * @param city
 * @param postalCode 
 */
    public Resort(int id, String phone, String email, String name, String address, String country, String city, String postalCode) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
     * Create a new Resort recort.
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
                + "phone_resort, email, postal_code)"
                + "VALUES ('" + tfName + "', '" 
                + tfAddress + "', '" 
                + tfCountry + "', '"
                + tfCity + "', '"
                + tfPhoneResort + "', '"
                + tfEmail + "', '"
                + tfpostalCode + "')";
        
        db.insertQuery(sql);       
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
     * Update a singel resort record.
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
                    this.setPhone(result.getString("phone_resort"));
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

    /**
     * Method to search the entity Resorts.
     * @param dbField field to search, if null it searches al fields.
     * @param searchArg the paramater to search with. 
     * @return a list of resorts coresponding to the parameters. 
     */
    public  List<Resort> searchResortList(int dbField, String searchArg){
        List<Resort> resorts = new ArrayList<>();
        String sql, sqlSelect = "SELECT * FROM `resort`";
        
        if (dbField == 0) {
            sql = sqlSelect + "WHERE `resort_id` LIKE '%" + searchArg + "%'"
                    + "OR `resort_name` LIKE '%" + searchArg + "%'"
                    + "OR `address` LIKE '%" + searchArg + "%'"
                    + "OR `country` LIKE '%" + searchArg + "%'"
                    + "OR `city` LIKE '%" + searchArg + "%'"
                    + "OR `phone_resort` LIKE '%" + searchArg + "%'"
                    + "OR `email` LIKE '%" + searchArg + "%'"
                    + "OR `postal_code`  LIKE '%" + searchArg + "%'";
        } else if (dbField == 1) {
            sql = sqlSelect + "WHERE `resort_name` LIKE '%" + searchArg + "%'";
        } else if (dbField == 2) {
            sql = sqlSelect + "WHERE `address` LIKE '%" + searchArg + "%'";
        } else if (dbField == 3) {
            sql = sqlSelect + "WHERE `country` LIKE '%" + searchArg + "%'";
        } else if (dbField == 4) {
            sql = sqlSelect + "WHERE `city` LIKE '%" + searchArg + "%'";
        } else if (dbField == 5) {
            sql = sqlSelect + "WHERE `phone_resort` LIKE '%" + searchArg + "%'";
        } else if (dbField == 6) {
            sql = sqlSelect + "WHERE `email` LIKE '%" + searchArg + "%'";
        } else if (dbField == 7) {
            sql = sqlSelect + "WHERE `postal_code` LIKE '%" + searchArg + "%'";
        }
        
        else
        {
            sql = sqlSelect;
        }        
        
        try{
            ResultSet result = getDb().doQuery(sql);
            while(result.next()){
                resorts.add(new Resort(result.getInt("resort_id"),
                result.getString("resort_name"),
                result.getString("address"),
                result.getString("country"),
                result.getString("city"),
                result.getString("phone_resort"),
                result.getString("email"),
                result.getString("postal_code")));
            }
            }
            catch (SQLException e){
            System.out.println(getDb().SQL_EXCEPTION + e.getMessage());        
            }
        
        return  resorts;      
        
    }
    
    /**
     * links a resort to a customer.
     * @param customerId
     * @param resortId 
     */
    public void linkCustomerIdToResort(int customerId, int resortId) {
        String sql = "UPDATE `customer` SET `resort_id` = " + resortId
                + "WHERE `customer_id` =" + customerId;
        db.insertQuery(sql);
    }   
}
    
    

    
    

    

    
    
    
    

