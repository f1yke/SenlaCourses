package entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends Entity {
    private String name;
    private Integer roomId;
    private List<Capability> capabilities;
    private static int lastId = 0;

    public Client() {
        capabilities = new ArrayList<>();
        setId(lastId);
        lastId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        if (roomId != null) {
            sb.append(" ").append(roomId);
        }
        return sb.toString();
    }
}