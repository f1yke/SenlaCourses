package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomHistory extends Entity {
    private int idClient;
    private int idRoom;
    private Date dateOfSettle;
    private Date dateEviction;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idClient).append(" ").append(idRoom).append(" ");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        sb.append(format.format(dateOfSettle)).append(" ").append(format.format(dateEviction));

        return sb.toString();
    }
}