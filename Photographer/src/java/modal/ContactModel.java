/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import context.DBContext;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANH DUC
 */
public class ContactModel {

    public Contact getContact() {
        DBContext dBContext = new DBContext();
        Connection connection;
        try {
            connection = dBContext.getConnection();
            String sql = "SELECT * FROM dbo.Contact";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Contact contact = new Contact();
                contact.setName(rs.getString("name"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setTel(rs.getString("tel"));
                contact.setEmail(rs.getString("email"));
                contact.setAbout(rs.getString("about"));
                return contact;
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
