/**
 * @author CJ Cucio
 * @date 22 November 2019
 */

package yib00005xs.std511.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import yib00005xs.std511.library.commons.Init;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Properties properties = loadPropertiesFile("resources/library.properties");
        Init init = new Init(properties);
        init.start();
    }
    
    public static Properties loadPropertiesFile(String stringFile) throws IOException {
        InputStream input = null;
        Properties properties = null;
        try {
            input = new FileInputStream(stringFile);
            properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Main.loadPropertiesFile() ERROR: " + e.toString());
        } catch (IOException e) {
            System.out.println("Main.loadPropertiesFile() ERROR: " + e.toString());
        } finally {
            input.close();
        }
        
        return properties;
    }

}
