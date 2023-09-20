package com.ringleadafrica.rlapos;

public class UserModel {

    private Integer id;
    private String first_name;
    private String last_name;
    private String national_id;
    private String phone_number;
    private String address;
    private String username;
    private String email;
    private String password;
    private String role;

    public UserModel(Integer id, String first_name, String last_name, String national_id, String phone_number, String address, String username, String email, String password, String role) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.national_id = national_id;
        this.phone_number = phone_number;
        this.address = address;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserModel(Integer id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNational_id() {
        return national_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
