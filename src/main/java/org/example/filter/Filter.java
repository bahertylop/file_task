package org.example.filter;

import org.example.User;

import java.util.List;

public interface Filter {
    List<User> filterUsers(List<User> users);
}
