/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import context.DBContext;
import entity.Images;
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
public class ImageModel {

    public List<Images> getAllImageByGalleryId(int id) {
        DBContext dBContext = new DBContext();
        Connection connection;
        try {
            connection = dBContext.getConnection();
            List<Images> listImage = new ArrayList<>();
            String sql = "SELECT Images.* FROM dbo.Images INNER JOIN dbo.Gallery"
                    + " ON Gallery.id = Images.gallery_id WHERE gallery_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Images image = new Images();
                image.setId(rs.getInt("id"));
                image.setGallery_id(rs.getInt("gallery_id"));
                image.setImage(dBContext.getImagePath() + rs.getString("image"));
                image.setTitle(rs.getString("title"));
                listImage.add(image);
            }
            return listImage;
        } catch (Exception ex) {
            Logger.getLogger(ImageModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
