import java.util.Date;

public class Util {

    public static String generateGmail(){
        Date date = new Date();
        String email=  date.toString().replace(" ","_").replace(":","_");
        return "Fake_" + email + "@gmail.com";
    }
}
