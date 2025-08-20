package br.com.technosou.gestor.ultils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT_PT_BR = new SimpleDateFormat("dd/MM/yyyy");

    public static Date formatPtBr(String dateStr) throws ParseException {
        try {
            return DATE_FORMAT_PT_BR.parse(dateStr);
        } catch (ParseException e) {
            throw new ParseException("Invalide Date: " + dateStr, e.getErrorOffset());
        }
    }

    public static String formatPtBr(Date date) {
        if (date == null) return null;
        return DATE_FORMAT_PT_BR.format(date);
    }
}
