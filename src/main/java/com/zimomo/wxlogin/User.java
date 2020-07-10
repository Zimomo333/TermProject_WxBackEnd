package com.zimomo.wxlogin;

public class User {
    String id;
    String open_id;
    String password;
    String username;
    String name;
    int sex;
    String identity_card;
    String photo;
    String house_no;
    int health_status;
    int access_times;
    Boolean is_locked;

    public User(String id, String open_id, String password, String username, String name, int sex, String identity_card, String photo, String house_no, int health_status, int access_times, Boolean is_locked) {
        this.id = id;
        this.open_id = open_id;
        this.password = password;
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.identity_card = identity_card;
        this.photo = photo;
        this.house_no = house_no;
        this.health_status = health_status;
        this.access_times = access_times;
        this.is_locked = is_locked;
    }

    public User(String id, String username, String name, int sex, String identity_card, String photo, String house_no, int health_status, int access_times, Boolean is_locked) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.identity_card = identity_card;
        this.photo = photo;
        this.house_no = house_no;
        this.health_status = health_status;
        this.access_times = access_times;
        this.is_locked = is_locked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public int getHealth_status() {
        return health_status;
    }

    public void setHealth_status(int health_status) {
        this.health_status = health_status;
    }

    public int getAccess_times() {
        return access_times;
    }

    public void setAccess_times(int access_times) {
        this.access_times = access_times;
    }

    public Boolean getIs_locked() {
        return is_locked;
    }

    public void setIs_locked(Boolean is_locked) {
        this.is_locked = is_locked;
    }
}
