package Model;

import java.util.Objects;

public class Place {
    private int id;
    private int x;
    private int y;
    private int free;
    private String username;

    public Place() {
    }

    public Place(int id, int x, int y, int free, String username) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.free = free;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
