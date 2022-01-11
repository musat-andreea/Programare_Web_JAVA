package com.andreea.proiectjavafacultate.services;


import com.andreea.proiectjavafacultate.connectivity.DatabaseConnection;
import com.andreea.proiectjavafacultate.models.Model;
import com.andreea.proiectjavafacultate.models.Event;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class EventService {
    private DatabaseConnection conn = DatabaseConnection.getInstance();
    private List<Event> events = new ArrayList<>();

    public List<Event> getAllEvents()
    {
        try
        {
            String sql = "SELECT * FROM events";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Event e;
                e = new Event(rs.getString("nume"), rs.getDate("data"));
                this.events.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return this.events;
    }

    public Event getEvent(int id)
    {
        Event e = new Event();
        try
        {
            String sql = "SELECT * FROM events WHERE id = ? LIMIT 1";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            e = new Event(rs.getString("nume"), rs.getDate("data"));

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return e;
    }

    public int getEventId(String name)
    {
        int event_id = -1;
        try
        {
            String sql = "SELECT id FROM events WHERE nume = ? LIMIT 1";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            event_id = rs.getInt("id");

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return event_id;
    }

    public boolean addEvent(Event e)
    {
        try
        {
            String sql = "INSERT INTO events (nume, data) VALUES (?,?)";
            System.out.println("SE APELEAZA ADD EVENT");

            System.out.println(e);
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getEvent_name());
            java.sql.Date sDate = new java.sql.Date(e.getEvent_date().getTime());
            stmt.setDate(2, sDate);
            stmt.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    public boolean updateEventDate(int id, Date d)
    {
        try
        {
            String sql = "UPDATE events SET data = ? WHERE id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            java.sql.Date sDate = new java.sql.Date(d.getTime());
            stmt.setDate(1, sDate);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enrollToAgency(int eventId, int agencyId)
    {
        try
        {
            System.out.println("SE APELEAZA UPDATE EVENT AGENCY");
            String sql = "UPDATE events SET agency_id = ? WHERE id= ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setFloat(2, eventId);
            stmt.setInt(1, agencyId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Model> listHeightModels(int id, String orderBy)
    {

        List<Model> lc = new ArrayList<>();
        try
        {
            String sql;
            if (orderBy.equals("None")) {
                sql = "SELECT * FROM models WHERE event_id = ?";
            }
            else
            {
                sql = "SELECT * FROM models WHERE event_id = ? ORDER BY " + orderBy + " DESC";
            }
            PreparedStatement stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                do {
                Model c;
                    if (rs.getFloat(("weight")) > 0) {
                        c = new Model(rs.getInt("id"), rs.getString("nume"), rs.getString("prenume"),
                                rs.getFloat("height"), rs.getFloat("weight"), rs.getFloat("birthday"));
                    }
                    else
                    {
                        c = new Model(rs.getString("nume"), rs.getString("prenume"),
                                rs.getFloat("height"));
                    }
                    lc.add(c);

                } while(rs.next());

            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return lc;
    }

    public boolean deleteEvent(int id)
    {
        try
        {
            String sql = "DELETE FROM events WHERE id = ?";
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
