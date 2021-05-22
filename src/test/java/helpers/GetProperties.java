package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

    public void leerPropiedades() throws IOException {

        Properties prop = new Properties();

        String nameProperties = "qa.properties";

        InputStream inputStream= getClass().getClassLoader().getResourceAsStream(nameProperties);

        if (inputStream!=null){
            prop.load(inputStream);
        }

        Environment.user=prop.getProperty("user");
        System.out.println(" ****** USER : "+Environment.user);
        inputStream.close();

    }

}
