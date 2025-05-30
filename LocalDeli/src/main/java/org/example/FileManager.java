package org.example;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FileManager {

    public static void save(Order currentOrder) {

        //file name 20250530-160611.txt

        String dir  = "receipts";

        File filePath = new File(dir, createFileName());

        try (FileWriter fw = new FileWriter(filePath)){

            fw.write(currentOrder.getItem().toString());
            for (OrderItem item : order.getOrderItem());
            fw.write(item.toString() + "\n");
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public static String createFileName(){
        LocalDateTime currentDate = LocalDateTime.now();
        StringBuilder fileName = new StringBuilder();

        System.out.println(currentDate.toLocalDate() + " " + currentDate.toLocalTime());

        for (String dateString : currentDate.toLocalDate().toString().split("-")){
            fileName.append(dateString);
        }

        fileName.append("-");

        for (String timeString : currentDate.toLocalTime().truncatedTo(ChronoUnit.SECONDS).toString().split(":")){
            fileName.append(timeString);
        }
        fileName.append(".txt");

        return fileName.toString();
    }
}
