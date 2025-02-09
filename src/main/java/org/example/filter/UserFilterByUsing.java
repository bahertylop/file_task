package org.example.filter;

import org.example.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserFilterByUsing implements Filter {

    private final double maxUsingValue;

    public UserFilterByUsing(double maxUsingValue) {
        this.maxUsingValue = maxUsingValue;
    }

    @Override
    public List<User> filterUsers(List<User> users) {
        return users.stream()
                .filter(
                        (user) -> user.getUserUsings()
                                .stream()
                                .allMatch((x) -> x < maxUsingValue)
                )
                .collect(Collectors.toList());
    }
}
