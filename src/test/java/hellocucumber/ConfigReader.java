package hellocucumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static{
        try{
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getUsername(){
        return properties.getProperty("username");
    }
    public static String getPassword(){
        return properties.getProperty("password");
    }
}
