package com.andreea.proiectjavafacultate.services;

import com.andreea.proiectjavafacultate.connectivity.DatabaseConnection;
import com.andreea.proiectjavafacultate.models.Image;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    private DatabaseConnection conn = DatabaseConnection.getInstance();
    private List<Image> gallery = new ArrayList<>();
    
    public List<Image> getAllImages()
    {
        try
        {
            gallery.clear();
            String sql = "SELECT * FROM gallery";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Image e;

                e = new Image(rs.getInt("id"), rs.getString("image"));
                System.out.println(e);
                this.gallery.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return this.gallery;
    }

    public Image getImage(int id)
    {
        Image e = new Image(id);
        try
        {
            String sql = "SELECT * FROM gallery WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            e = new Image(id, rs.getString("image"));

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return e;
    }

    public boolean addImage(Image e)
    {
        try
        {
            String sql = "INSERT INTO gallery (image) VALUES (?)";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getImage());
            stmt.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    public List<Image> getModelImage(int modelId)
    {
        List<Image> images = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM gallery WHERE modelId = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, modelId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Image e;
                e = new Image(rs.getInt("id"), rs.getString("image"));
                images.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return images;
    }

    public boolean deleteImage(int id)
    {
        try
        {
            String sql = "DELETE FROM gallery WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
