package org.example.filter;

import org.example.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public List<User> filterUsers(List<User> users, double maxUsingValue) {
        return users.stream()
                .filter(
                        (user) -> user.getUserUsings()
                                .stream()
                                .allMatch((x) -> x < maxUsingValue)
                )
                .collect(Collectors.toList());
    }
}
