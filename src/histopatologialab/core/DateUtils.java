package histopatologialab.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatDate(LocalDate localDate){
        if (localDate == null) localDate = LocalDate.now();
        return localDate.format(formatter);
    }
}
