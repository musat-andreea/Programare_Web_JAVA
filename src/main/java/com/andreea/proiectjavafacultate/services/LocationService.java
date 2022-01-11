package com.andreea.proiectjavafacultate.services;

import com.andreea.proiectjavafacultate.connectivity.DatabaseConnection;
import com.andreea.proiectjavafacultate.models.Location;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private DatabaseConnection conn = DatabaseConnection.getInstance();
    private List<Location> locations = new ArrayList<>();
    
    public List<Location> getAllLocations()
    {
        try
        {
            locations.clear();
            String sql = "SELECT * FROM locations";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Location e;

                e = new Location(rs.getInt("id"), rs.getInt("eventId"), rs.getString("city"), rs.getString("country"),
                        rs.getString("capacity"), rs.getBoolean("status") );
                System.out.println(e);
                this.locations.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return this.locations;
    }

    public Location getLocation(int id)
    {
        Location e = new Location(id);
        try
        {
            String sql = "SELECT * FROM locations WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            e = new Location(rs.getInt("id"), rs.getInt("eventId"), rs.getString("city"), rs.getString("country"),
                    rs.getString("capacity"), rs.getBoolean("status") );

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return e;
    }

    public boolean addLocation(Location e)
    {
        try
        {
            String sql = "INSERT INTO locations (eventId, city, country, capacity, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            System.out.println(e.toString());
            stmt.setInt(1, e.getEventId());
            stmt.setString(2, e.getCity());
            stmt.setString(3, e.getCountry());
            stmt.setString(4, e.getCapacity());
            stmt.setBoolean(5, e.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    public List<Location> getEventLocation(int eventId)
    {
        List<Location> images = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM locations WHERE eventId = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Location e;
                e = new Location(rs.getInt("id"), rs.getInt("eventId"), rs.getString("city"), rs.getString("country"),
                        rs.getString("capacity"), rs.getBoolean("status") );
                images.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return images;
    }

    public boolean deleteLocation(int id)
    {
        try
        {
            String sql = "DELETE FROM locations WHERE id = ?";
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
