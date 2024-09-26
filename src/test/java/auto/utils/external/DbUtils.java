package auto.utils.external;

import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.math.BigDecimal;
import java.util.*;

public class DbUtils {
    private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);
    private final JdbcTemplate jdbc;

    public DbUtils(String name, String evn) {
        DBStatement db = new DBStatement(name, evn);
        String url = db.getUrl();
        String username = db.getUsername();
        String password = db.getPassword();
        String driver = db.getDriver();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        jdbc = new JdbcTemplate(dataSource);
        logger.info("init jdbc template: {}", url);
    }

    public Object readValue(String query) {
        return jdbc.queryForObject(query, Object.class);
    }

    public Map<String, Object> readRow(String query) {
        return jdbc.queryForMap(query);
    }

    public List<Map<String, Object>> readRows(String query) {
        return jdbc.queryForList(query);
    }

    public void updateRow(String query) {
        jdbc.update(query);
    }

    public void insertDataRowTxn(String username, String keyPairAlias, String keyPairAliasChallenge, String publicKeyAlgorithm, String deviceId) {
        DbUtils db = new DbUtils("dbAutoTest", "db");
        String query = "select * from qa_db.account a WHERE username = '" + username + "'";
        try {
            Map<String, Object> result = readRow(query);
            String query3 = "UPDATE qa_db.account SET keyPairAlias = '" + keyPairAlias + "', publicKeyAlgorithm = '" + publicKeyAlgorithm + "', deviceId = '" + deviceId + "', keyPairAliasChallenge = '" + keyPairAliasChallenge + "' Where username='" + username + "'";
            db.updateRow(query3);
        } catch (Exception ex) {
            String query2 = "INSERT into qa_db.account (username,keyPairAlias,keyPairAliasChallenge,publicKeyAlgorithm,deviceId) \n" +
                    "VALUES ('" + username + "','" + keyPairAlias + "','" + keyPairAliasChallenge + "','" + publicKeyAlgorithm + "','" + deviceId + "')";
            updateRow(query2);
        }
    }

    public String getKeyPairAlias(String username) {
        String query = "select keyPairAlias from qa_db.account a WHERE username = '" + username + "'";
        Map<String, Object> result = readRow(query);
        return result.get("keyPairALias").toString();
    }

    public String getKeyPairAliasChallenge(String username) {
        String query = "select keyPairAliasChallenge from qa_db.account a WHERE username = '" + username + "'";
        Map<String, Object> result = readRow(query);
        return result.get("keyPairAliasChallenge").toString();
    }

    public String getDeviceId(String username) {
        String query = "select deviceId from qa_db.account a WHERE username = '" + username + "'";
        Map<String, Object> result = readRow(query);
        return result.get("deviceId").toString();
    }
    

    public String addCondition(String condition, String query) {
        if (condition != "NONE") {
            if (query.contains("WHERE")) {
                query += " AND " + condition;
            } else {
                query += " WHERE " + condition;
            }
        }
        return query;
    }
}



