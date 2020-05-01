package lib.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "eventType",
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = JoinEvent.class, name = "joinEvent"),
    @JsonSubTypes.Type(value = AnswerEvent.class, name = "answerEvent")
})
public abstract class GameEvent implements Serializable {

    private final EventType eventType;

    protected GameEvent(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }
}
