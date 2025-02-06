package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersTable {

    private static final String COLUMN_NAMES = "id|name|waterCountDay|waterCountNight|gasCount|electroCountDay|electroCountNight\n";

    public static List<User> getUsersFromFile(String fileName) {
        List<User> users = new ArrayList<>();
        Path inputFilePath = Paths.get(fileName);
        try (
                Scanner sc = new Scanner(Files.newInputStream(inputFilePath));
        ) {
            int lineCounter = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (lineCounter++ != 0) {
                    users.add(parseUserFromLine(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
        return users;
    }

    private static User parseUserFromLine(String line) throws IOException {
        String[] params = line.split("\\|");
        if (params.length != 7) {
            throw new IOException("Некорректная строка в файле");
        }

        return new User(
                Integer.parseInt(params[0]),
                params[1],
                Integer.parseInt(params[2]),
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6])
        );
    }

    public static void printUsersToFile(List<User> users, String newFileName) {
        try (
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFileName))
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
