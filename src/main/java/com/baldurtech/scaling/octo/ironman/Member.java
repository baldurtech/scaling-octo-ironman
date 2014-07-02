package com.baldurtech.scaling.octo.ironman;

public class Member {
    private Long id;
    private String username;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String toString() {
        return "Member@" + id + "(" + username + ")";
    }
}
