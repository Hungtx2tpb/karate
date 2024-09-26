package auto.utils.external;

import org.w3c.dom.Node;

import java.util.Locale;
import java.util.Map;

public class DBStatement {

    private final String url;
    private final String driver;
    private final String username;
    private final String password;

    public DBStatement(String name, String environment) {
        Map<String, Node> nodeSet = Utilities.readNodeValueFromXMLFile("src/test/resources/environments/database.xml", "//type[@name='common']//object");
        String evn = System.getProperty("karate.env");
        System.out.println("karate.env==========>>>>>>>>>>: " + evn);
        if (evn == null) {
//            evn = "roc-sit";
            evn = environment;
        }
        String env = evn.toLowerCase(Locale.ROOT) + ".";
        if (nodeSet.keySet().toString().contains(name)) {
            env = "common." + name;
        } else {
            env = env + name;
        }
        url = Utilities.getDBInfo(env + ".url");
        driver = Utilities.getDBInfo(env + ".driver");
        username = Utilities.getDBInfo(env + ".username");
        password = Utilities.getDBInfo(env + ".password");
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
