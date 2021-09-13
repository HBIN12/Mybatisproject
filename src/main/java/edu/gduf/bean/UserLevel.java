package edu.gduf.bean;

public class UserLevel {
    private User user;
    private String level;
    private Integer id;

    public UserLevel() {
    }

    public UserLevel(User user, String level, Integer id) {
        this.user = user;
        this.level = level;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserLevel{" +
                "user=" + user +
                ", level='" + level + '\'' +
                ", id=" + id +
                '}';
    }
}
