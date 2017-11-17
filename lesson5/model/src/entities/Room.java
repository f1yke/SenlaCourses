package entities;

import repositories.RoomRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room extends Entity {
    private Integer number;
    private Double price;
    private Integer capacity;
    private Integer countStars;
    private RoomStatus status;
    private Date dateOfSettle;
    private Date dateEviction;

    private List<Client> clients;

    public Room() {
        status = RoomStatus.NOT_USED;
        clients = new ArrayList<>();
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Integer getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDateOfSettle() {
        return dateOfSettle;
    }

    public void setDateOfSettle(Date dateOfSettle) {
        this.dateOfSettle = dateOfSettle;
    }

    public Date getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(Date dateEviction) {
        this.dateEviction = dateEviction;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(" ").append(getNumber()).append(" ").append(price).append(" ").append(capacity).append(" ")
                .append(countStars).append(" ").append(status).append(" ");
        if (dateOfSettle != null && dateEviction != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            sb.append(format.format(dateOfSettle)).append(" ").append(format.format(dateEviction));
        }
        return sb.toString();
    }
}