package hw_jdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    public static User ROMAN = new User("Roman", "Jdi1234");

    private String name;
    private String password;
}
