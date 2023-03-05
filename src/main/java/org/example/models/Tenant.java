package org.example.models;

public class Tenant {
    private int Id;
    private String name;
    private String email;

    public Tenant(int id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Dweller{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
