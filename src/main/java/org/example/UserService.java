package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public static List<User> filterUsers(List<User> users, double maxUsingValue) {
        return users.stream()
                .filter(
                        (user) -> user.getUserUsings()
                                .stream()
                                .allMatch((x) -> x < maxUsingValue)
                )
                .collect(Collectors.toList());
    }
}
