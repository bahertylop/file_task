package org.example.writer;

import org.example.User;

import java.util.List;

public interface UserWriter {

    void printUsersToFile(List<User> users, String fileName);
}
