package auto.utils.external;

import com.github.javafaker.Faker;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import java.util.Random;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;



public class Helper {

    public Helper() {
    }

    public String printName(String name) {
        return "hello " + name;
    }

    public String getCurrentDateSystem() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateDisplay = formatter.format(date).toString();
        System.out.println(formatter.format(date));
        return dateDisplay;
    }

    public int getAmountRandom() {
        return (int) (Math.random() * 5000 + 1);
    }

    public String getRandomString(int length) {
        boolean allowChar = true;
        boolean allowNumbers = true;
        String generatedStr = RandomStringUtils.random(length, allowChar, allowNumbers);
        System.out.println(generatedStr);
        return generatedStr;
    }

    public String generateRandomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }


    public JSONArray getValueResponse(String rs, String key, String value, String field) {
        return JsonPath.read(rs, "$..[?(@." + key + "=='" + value + "')]." + field + "");
    }

    public String getValueResponseByXpath(String rs, String xpath) {
        return JsonPath.parse(rs).read("$." + xpath).toString();
    }

    public int randomNum(int maximum) {
        return new Random().nextInt(maximum);
    }

    public String readJSonNode(String json, String node) {
        return JsonParser.parseString(json).getAsJsonObject().get(node).toString();
    }

    public static String randomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String stressAddress() {
        return new Faker().address().streetAddress();
    }

    public String replaceValue(String a, String oldValue, String newValue) {
        return a.replace(oldValue, newValue);
    }

    public String upperCase(String a) {
        return a.toUpperCase();
    }

    public String convertText(String text) {
        String textUpper = text.toUpperCase();
        String afterConvert = null;
        if (textUpper.contains("THANH PHO")) {
            afterConvert = textUpper.replace("THANH PHO ", "TP.");
        } else if (textUpper.contains("TINH")) {
            afterConvert = textUpper.replace("TINH ", "T.");
        } else if (textUpper.contains("HUYEN")) {
            afterConvert = textUpper.replace("HUYEN ", "H.");
        } else if (textUpper.contains("THI XA")) {
            afterConvert = textUpper.replace("THI XA ", "TX.");
        } else if (textUpper.contains("THI TRAN")) {
            afterConvert = textUpper.replace("THI TRAN ", "T.");
        } else if (textUpper.contains("QUAN")) {
            afterConvert = textUpper.replace("QUAN ", "Q.");
        } else if (textUpper.contains("PHUONG")) {
            afterConvert = textUpper.replace("PHUONG ", "P.");
        }
        return afterConvert;
    }


    public static boolean compareString(String string1, String string2) {
        if (string1.contains(string2)) {
            return true;
        } else {
            return false;
        }
    }

    public String userPrepareDataForTestAsBelow(String value) {
        String billReturn = "";
        switch (value) {
            case "RANDOM":
                billReturn = generateRandomNumeric(6);
                break;
            case "RANDOM_EVN":
                billReturn = "PD01" + generateRandomNumeric(5);
                break;
            case "RANDOM_WATER":
                billReturn = generateRandomNumeric(4);
                break;
            default:
                billReturn = value;
        }
        return billReturn;
    }

    public String getDataFromJsonFileByKey(String path, String keyPath, String environment) throws IOException {
        String evn = System.getProperty("karate.env");
        System.out.println("karate.env==========>>>>>>>>>>: " + evn);
        if (evn == null) {
            evn = environment;
        }
        StringBuilder data = new StringBuilder();
        org.json.JSONObject jsonFile = new org.json.JSONObject(Utilities.getContentsFile(path));
        data.append(jsonFile.get(keyPath + "-" + evn.toLowerCase(Locale.ROOT)));
        return data.toString();
    }

    public String answerDataSendFeedback(String value) {
        int max = 240;
        switch (value) {
            case "null":
                value = null;
                break;
            case "{SPACE}":
                value = " ";
                break;
            case "{SPACE_TEXT_SPACE}":
                value = " " + generateRandomString(1) + " ";
                break;
            case "{CHAR_GREATER_THAN_MAX_1}":
                value = generateRandomString(max + 1);
                break;
            case "{LESS_THAN_MAX_1}":
                value = generateRandomString(max - 1);
                break;
            case "{EQUAL_MAX}":
                value = generateRandomString(max);
                break;
            default:
                value = value;
        }
        return value;
    }
    public String generateRandomString(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    public List<String> getAnswerListByCaseType(String caseType) {
        int maxLength = 240;
        List<String> answers = new ArrayList<>();
        switch (caseType) {
            case "{NULL}":
                answers.add(null);
                break;
            case "{DELETE}":
                break;
            case "":
                answers.add("");
                break;
            case "{SPACE}":
                answers.add(" ");
                break;
            case "{SPACE_NUM_SPACE}":
                answers.add(" " + RandomStringUtils.randomNumeric(4) + " ");
                break;
            case "{LESS_THAN_MAX_1}":
                answers.add(RandomStringUtils.randomAlphanumeric(maxLength - 1));
                break;
            case "{EQUAL_MAX}":
                answers.add(RandomStringUtils.randomAlphanumeric(maxLength));
                break;
            case "{CHAR_GREATER_THAN_MAX_1}":
                answers.add(RandomStringUtils.randomAlphabetic(maxLength + 1));;
                break;
            default:
                answers.add(caseType);
                break;
        }
        return answers;
    }


    public Object selectRandomItem() {
        List<Object> list = createListFromJson();
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    public String selectRandomBoolean() {
        List<String> list = new ArrayList<>();
        list.add("true");
        list.add("false");
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    public String generateRandomNumber(int length) {
        String CHARACTERS = "0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public List<Object> createListFromJson() {
        List<Object> objects = null;
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/test/resources/data/services/roc-payment-dis/responseListBanks.json")) {
            Type listType = new TypeToken<List<Object>>() {}.getType();
            objects = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
