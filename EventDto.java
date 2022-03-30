package com.yocket.event;

import java.time.LocalDateTime;

public class EventDto {
    
    private int event_id;
    
    private String event_name;

    private DateTime event_starting_time;

    private DateTime event_duration;

    public int getEvent_id() {
        return event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public DateTime getEvent_starting_time() {
        return event_starting_time;
    }

    public void setEvent_starting_time(DateTime event_starting_time) {
        this.event_starting_time = event_starting_time;
    }

    public DateTime getEvent_duration() {
        return event_duration;
    }

    public void setEvent_duration(DateTime event_duration) {
        this.event_duration = event_duration;
    }
    
}