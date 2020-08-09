package model;

public class Account {
    private int id;
    private String name;
    private int phone;
    private int placeId;

    public Account() {
    }

    public Account(String name, int phone, int place_id) {
        this.name = name;
        this.phone = phone;
        this.placeId = place_id;
    }

    public Account(int id, String name, int phone, int place_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.placeId = place_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPlace_id() {
        return placeId;
    }

    public void setPlace_id(int place_id) {
        this.placeId = place_id;
    }
}
