package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestAnything {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hora = "15:00";
        Date d_hora = sdf.parse(hora);
        System.out.println("Hora actual: " + sdf.format(d_hora));
        
        String[][] horarios = {{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};
    }

}
