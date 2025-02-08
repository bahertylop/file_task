package org.example.writer;

import org.example.User;
import org.example.writer.UserWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUserWriter implements UserWriter {

    private static final String COLUMN_NAMES = "id|name|waterCountDay|waterCountNight|gasCount|electroCountDay|electroCountNight\n";

    @Override
    public void printUsersToFile(List<User> users, String fileName) {
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))
        ) {
            bufferedWriter.write(COLUMN_NAMES);

            for (User user : users) {
                bufferedWriter.write(user.toLine());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
