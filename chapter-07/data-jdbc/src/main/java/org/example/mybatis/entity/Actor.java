package org.example.mybatis.entity;


public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
