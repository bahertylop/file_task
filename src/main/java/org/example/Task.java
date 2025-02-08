package org.example;

import org.example.filter.UserService;
import org.example.reader.CSVUserReader;
import org.example.reader.UserReader;
import org.example.writer.CSVUserWriter;
import org.example.writer.UserWriter;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.List;

public class Task {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Неправильно заданы аргументы: путь-к-файлу максимальное-потребление");
            return;
        }

        String inputFilePath = getFileNameFromArgs(args);
        double maxUsingValue = getMaxUsingValueFromArgs(args);

        UserReader reader = new CSVUserReader();
        List<User> users = reader.getUsersFromFile(inputFilePath);

        List<User> filteredUsers = new UserService().filterUsers(users, maxUsingValue);

        String outputFilePath = createOutputFilePath(inputFilePath);
        UserWriter writer = new CSVUserWriter();
        writer.printUsersToFile(filteredUsers, outputFilePath);
    }

    public static String getFileNameFromArgs(String[] args) {
        return args[0];
    }
    private static double getMaxUsingValueFromArgs(String[] args) {
        double maxUsingValue;
        try {
            maxUsingValue = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Неправильно указан аргумент максимальное-потребление, требуется double");
        }
        return maxUsingValue;
    }

    private static String createOutputFilePath(String inputFilePath) {
        return Paths.get(inputFilePath).getParent().resolve("result.csv").toString();
    }
}
