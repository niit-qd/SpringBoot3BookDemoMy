package org.example.jopo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    @Getter(value = AccessLevel.NONE)
    private boolean active;

    public boolean getActive() {
        return active;
    }
}
