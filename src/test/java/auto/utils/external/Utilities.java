package auto.utils.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.minidev.json.parser.ParseException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Utilities {

    private static final String dir = System.getProperty("user.dir");

    public static String getContentsFile(String path) throws IOException {
        try {
            String filePath = dir + "/" + path;
            return FileUtils.readFileToString(new File(filePath), String.valueOf(StandardCharsets.UTF_8));
        } catch (Exception e) {
            InputStream in = Utilities.class.getResourceAsStream(path);
//            in.getClass().getResourceAsStream(path).getClass().getPackage().getName();
            return IOUtils.toString(in, String.valueOf(StandardCharsets.UTF_8));
        }
    }

    public static InputStream getContentAsStream(String path) {
        try {
            System.out.println(Utilities.class.getResource(path));
            return new FileInputStream(Utilities.class.getResource(path).getPath());
        } catch (IOException e) {
            return Utilities.class.getResourceAsStream(path);
        }
    }

    public static String getDBInfo(String path) {
        return readValueFromXMLFile(path, "src/test/resources/environments/database.xml");
    }

    public static Map<String, Node> readNodeValueFromXMLFile(String fileName, String path) {
        Map<String, Node> nodeSet = new HashMap<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc1 = builder.parse(dir + "/" + fileName);
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xpath.compile(path);
            NodeList nList = (NodeList) expression.evaluate(doc1.getDocumentElement(), XPathConstants.NODESET);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                String value = nNode.getAttributes().getNamedItem("name").getNodeValue();
                nodeSet.put(value, nNode);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nodeSet;
    }

    public static String readValueFromXMLFile(String path, String fileName) {
        String[] item = path.split("\\.");
        String value = null;
        try {
            Map<String, Node> nodeSet = readNodeValueFromXMLFile(fileName, "//type[@name='" + item[0] + "']//object");
            Node node = nodeSet.get(item[1]);
            NodeList nodeList = ((Element) node).getElementsByTagName("attribute");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getAttributes().getNamedItem("name").getNodeValue().equals(item[2])) {
                    value = nNode.getAttributes().getNamedItem("value").getNodeValue();
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public String getDateTime(String type, int timePlus, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        switch (type) {
            case "DATE":
                cal.add(Calendar.DATE, timePlus);
                break;
            case "MONTH":
                cal.add(Calendar.MONTH, timePlus);
                break;
            case "YEAR":
                cal.add(Calendar.YEAR, timePlus);
                break;
            default:
                break;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }


    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String getCurrentDateByFormat(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String upDownDays(String addDay, int days, String pattern) {
        try {
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date d = sdf.parse(addDay);
            c1.setTime(d);
            c1.add(Calendar.DATE, days);
            return sdf.format(c1.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SneakyThrows
    public JSONObject readFileJson(String pathFile) {
        Object object = new JSONParser().parse(new FileReader(pathFile));
        return new JSONObject(new ObjectMapper().writeValueAsString(object));

    }

    public String getDataFromJsonFile(String pathFile, String env) {
        String environment = env.replace("-", "");
        JSONObject jsonObject = readFileJson(pathFile);
        JSONObject object = jsonObject.getJSONObject(environment);
        return object.toString();
    }
}
