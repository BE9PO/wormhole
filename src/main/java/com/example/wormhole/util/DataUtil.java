package com.example.wormhole.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

   public static LocalDate getLocalDate(String stringDate) {
        if (stringDate != null) {
            return LocalDate.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            //TODO поправить костыль
            return LocalDate.now();//Костыл пока
        }
    }
}
