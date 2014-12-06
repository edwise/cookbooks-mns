package com.edwise.pocs.springrest.entity;

public class User {

    private Long id;
    private String name;
    private Integer type;
    private String phone;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public User setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User copyFrom(User user) {
        if (user.name != null) {
            this.name = user.name;
        }
        if (user.type != null) {
            this.type = user.type;
        }
        if (user.phone != null) {
            this.phone = user.phone;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id) && !(name != null ? !name.equals(user.name) : user.name != null)
                && !(phone != null ? !phone.equals(user.phone) : user.phone != null)
                && !(type != null ? !type.equals(user.type) : user.type != null);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", phone='" + phone + '\'' +
                '}';
    }
}
