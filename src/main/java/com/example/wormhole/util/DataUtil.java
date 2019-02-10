package com.example.wormhole.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

   public static LocalDate getLocalDate(String stringDate) {
       try {
           return LocalDate.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE);
       }
       catch (Exception e){
           //TODO поправить костыль
           return LocalDate.now();
       }

    }
}
