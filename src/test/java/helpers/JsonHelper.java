package helpers;

import org.json.JSONObject;

import java.util.Iterator;

public class JsonHelper {

    public static boolean areEqual(String expectedResultJson,String actualResulJson){
        boolean isEqual=true;
        JSONObject jsonExpected=new JSONObject(expectedResultJson);
        JSONObject jsonActual=new JSONObject(actualResulJson);

        Iterator<?> keyList=jsonExpected.keys();
        while (keyList.hasNext()){
            String key= (String) keyList.next();
            String valueExpected= String.valueOf(jsonExpected.get(key));
            String valueActual= String.valueOf(jsonActual.get(key));
            if (jsonExpected.has(key) && jsonActual.has(key)){
                if (valueExpected.equals("IGNORE") || valueActual.equals("IGNORE")){
                    System.out.println("WARN> attributo ignorado: ["+key+"]");
                } else if( !valueExpected.equals(valueActual)){
                    System.out.println("ERROR> attributo: ["+key+"] no es igual, expected: "+valueExpected+" vs actual: "+valueActual);
                    isEqual=false;
                }
            }else{
                System.out.println("ERROR el attributo ["+key+"] no existe");
                isEqual=false;
            }

        }
        return isEqual;
    }

}
