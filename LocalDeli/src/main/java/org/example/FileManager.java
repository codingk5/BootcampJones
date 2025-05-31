package org.example;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FileManager {
    public static void save(Order currentOrder) {
        String dir = "src/main/resources/";
        File directory = new File(dir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        File filePath = new File(directory, createFileName());

        try (FileWriter fw = new FileWriter(filePath)) {
            for (OrderItem orderItem : currentOrder.getOrderItems()) {
                fw.write(orderItem.getReceiptName() + "\n");
            }
        } catch (Exception ex) {
            System.out.println("Error saving receipt: " + ex.getLocalizedMessage());
        }
    }

    public static String createFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return now.format(formatter) + ".txt";
    }


}
