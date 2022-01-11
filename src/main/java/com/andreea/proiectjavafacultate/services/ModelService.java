package com.andreea.proiectjavafacultate.services;

import com.andreea.proiectjavafacultate.connectivity.DatabaseConnection;
import com.andreea.proiectjavafacultate.models.Model;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    private DatabaseConnection conn = DatabaseConnection.getInstance();
    private List<Model> models = new ArrayList<>();

    public List<Model> getAllModels()
    {
        try
        {
            String sql = "SELECT * FROM models";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Model c;
                if (rs.getFloat(("weight")) > 0) {
                    c = new Model(rs.getInt("id"), rs.getString("nume"), rs.getString("prenume"),
                            rs.getFloat("height"), rs.getFloat("weight"));
                }
                else
                {
                    c = new Model(rs.getString("nume"), rs.getString("prenume"),
                            rs.getFloat("height"));
                }
                this.models.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.models;
    }

    public Model getModel(int id)
    {
        Model c = new Model();
        try
        {
            String sql = "SELECT * FROM models WHERE id = " + id + " LIMIT 1";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            c= new Model(rs.getInt("id"), rs.getString("nume"), rs.getString("prenume"),
                        rs.getFloat("height"), rs.getFloat("weight"), rs.getFloat("birthday"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public int getModelId(String name)
    {
        int modelId = -1;
        try
        {
            String sql = "SELECT id FROM models WHERE nume = ? LIMIT 1";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            modelId = rs.getInt("id");

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return modelId;
    }
    public boolean addModel(Model c)
    {
        try
        {
            String sql = "INSERT INTO models (nume, prenume, height, weight, birthday) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, c.getNume());
            stmt.setString(2, c.getPrenume());
            stmt.setFloat(3, c.getHeight());
            stmt.setFloat(4, c.getWeight());
            stmt.setFloat(5, c.getBirthday());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHeight(int id, float h)
    {
        try
        {
            System.out.println("S-A APELAT UPDATE INALTIME");
            String sql = "UPDATE models SET height = ? WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, h);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateWeight(int id, float w)
    {
        try
        {
            System.out.println("S-A APELAT UPDATE GREUTATE");
            String sql = "UPDATE models SET weight = ? WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, w);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBirthday(int id, float b)
    {
        try
        {
            System.out.println("S-A APELAT UPDATE DATA NASTERII");
            String sql = "UPDATE models SET birthday = ? WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, b);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enrollToEvent(int modelId, int eventId)
    {

        System.out.println("ENROLL TO event APELAT");
        try
        {
            String sql = "UPDATE models SET event_id = ? WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, eventId);
            stmt.setInt(2, modelId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enrollToDesigner(int modelId, int designerId)
    {

        System.out.println("ENROLL TO designer APELAT");
        try
        {
            String sql = "UPDATE designers SET modelId = ? WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(1, modelId);
            stmt.setInt(2, designerId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteModel(int id)
    {
        try
        {
            String sql = "DELETE FROM models WHERE id = ?";
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
