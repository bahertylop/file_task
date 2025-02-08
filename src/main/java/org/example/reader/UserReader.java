package org.example.reader;

import org.example.User;

import java.util.List;

public interface UserReader {

    List<User> getUsersFromFile(String fileName);
}
