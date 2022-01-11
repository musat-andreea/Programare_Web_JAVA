package com.andreea.proiectjavafacultate.services;

import com.andreea.proiectjavafacultate.connectivity.DatabaseConnection;
import com.andreea.proiectjavafacultate.models.Event;
import com.andreea.proiectjavafacultate.models.Agency;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgencyService {
    private DatabaseConnection conn = DatabaseConnection.getInstance();
    private List<Agency> agency = new ArrayList<>();

    public List<Agency> getAllAgency()
    {
        try
        {
            agency.clear();
            String sql = "SELECT * FROM agencies";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Agency e;

                e = new Agency(rs.getInt("id"), rs.getString("nume"));
                System.out.println(e);
                this.agency.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return this.agency;
    }

    public Agency getAgency(int id)
    {
        Agency e = new Agency();
        try
        {
            String sql = "SELECT * FROM agencies WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            e = new Agency(rs.getString("nume"));

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return e;
    }

    public boolean addAgency(Agency e)
    {
        try
        {
            String sql = "INSERT INTO agencies (nume) VALUES (?)";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    public List<Event> listAgencyEvents(int id)
    {
        List<Event> events = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM events WHERE agency_id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Event e;
                e = new Event(rs.getString("nume"), rs.getDate("data"));
                events.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return events;
    }

    public boolean deleteAgency(int id)
    {
        try
        {
            String sql = "DELETE FROM agencies WHERE id = ?";
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
