/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import context.DBContext;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANH DUC
 */
public class GalleryModel {

    public List<Gallery> getAllGallery() {
        DBContext dBContext = new DBContext();
        Connection connection;
        try {
            connection = dBContext.getConnection();
            List<Gallery> listGallery = new ArrayList<>();
            String sql = "SELECT * FROM dbo.Gallery";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setId(rs.getInt("id"));
                gallery.setName(rs.getString("name"));
                gallery.setContent(rs.getString("content"));
                gallery.setImage(dBContext.getImagePath() + rs.getString("image"));
                listGallery.add(gallery);
            }
            return listGallery;
        } catch (Exception ex) {
            Logger.getLogger(GalleryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Gallery getGalleryById(int id) {
        DBContext dBContext = new DBContext();
        Connection connection;
        try {
            connection = dBContext.getConnection();
            String sql = "SELECT * FROM dbo.Gallery where id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setId(rs.getInt("id"));
                gallery.setName(rs.getString("name"));
                gallery.setContent(rs.getString("content"));
                gallery.setImage(dBContext.getImagePath() + rs.getString("image"));
                return gallery;
            }
        } catch (Exception ex) {
            Logger.getLogger(GalleryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
