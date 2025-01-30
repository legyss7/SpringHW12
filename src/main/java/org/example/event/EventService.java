package org.example.event;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class EventService {
    private final List<String> events = new ArrayList<>();

    public void publishEvent(String event) {
        events.add(event);
        System.out.println("Событие опубликовано: " + event);
    }

}
