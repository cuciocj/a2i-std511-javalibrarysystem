/**
 * @author CJ Cucio
 * @date 22 November 2019
 */

package yib00005xs.std511.library.commons;

import java.util.Properties;
import org.apache.logging.log4j.Logger;
import yib00005xs.std511.library.form.LoginFrame;

public class Init {
    
    private final Properties properties;
    
    public Init(Properties properties) {
        System.out.println("Start initialization...");
        this.properties = properties;
        initialize();
    }
    
    // TODO initialize
    private void initialize() {
        System.out.println(properties.getProperty("database.driver"));
    }
    
    public void start() {
        LoginFrame.main(null);
    }
    
}
