import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yocket.event.EventDto;

public class EventDao {

    public Connection getConnection() throws SQLException {

        // Allow up to a second to check if the connection is valid.
        if (connection == null || !connection.isValid(1000)) {
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public EventDto getEvent(Number event_id) {

        String sql = "select * from event;";
        return getEvents(sql);
    }

    private EventDto getEvents(String sql) throws SQLException {

        List<EventDto> events = new ArrayList<EventDto>();
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            EventDto event = new EventDto();
            event.setEvent_name(rs.getString("event_name"));
            event.setEvent_id(rs.getInt("event_id"));
            event.setEvent_starting_time(rs.getTimestamp("event_starting_time"));
            event.setEvent_duration(rs.getTimestamp("event_duration"));
            events.add(event);
        }

        return events;
    }

    public List<EventDto> getUpcomingEvent() {
        String sql = "select * from event where event_starting_time > (current_timestamp() + INTERVAL 10 MINUTE);";
        return getEvents(sql);
    }

    public List<EventDto> getLiveEvent() {
        String sql = "select * from event where (event_starting_time - current_timestamp()) < INTERVAL 10 MINUTE);";
        return getEvents(sql);
    }
}

