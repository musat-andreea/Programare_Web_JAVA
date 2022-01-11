package com.andreea.proiectjavafacultate.services;

import com.andreea.proiectjavafacultate.connectivity.DatabaseConnection;
import com.andreea.proiectjavafacultate.models.Designer;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DesignerService {
    private DatabaseConnection conn = DatabaseConnection.getInstance();
    private List<Designer> designers = new ArrayList<>();

    public List<Designer> getAllDesigners()
    {
        try
        {
            designers.clear();
            String sql = "SELECT * FROM designers";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Designer e;

                e = new Designer(rs.getInt("eventId"), rs.getString("name"));
                System.out.println(e);
                this.designers.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return this.designers;
    }

    public Designer getDesigner(int id)
    {
        Designer e = new Designer();
        try
        {
            String sql = "SELECT * FROM designers WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            e = new Designer(rs.getString("nume"));

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return e;
    }

    public boolean addDesigner(Designer e)
    {
        try
        {
            String sql = "INSERT INTO designers (name) VALUES (?)";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getNume());
            stmt.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    public boolean deleteDesigner(int id)
    {
        try
        {
            String sql = "DELETE FROM designers WHERE id = ?";
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
