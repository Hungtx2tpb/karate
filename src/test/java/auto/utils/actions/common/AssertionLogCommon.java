package auto.utils.actions.common;

import lombok.Data;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import auto.utils.external.DbUtils;

@Data
public class AssertionLogCommon {
    private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);
    private final SoftAssertions softAssertions;

    public AssertionLogCommon() {
        softAssertions = new SoftAssertions();
    }

    public AssertionLogCommon assertEqual(String messageError, String actual, String expected) {
        softAssertions.assertThat(actual).describedAs(messageError).isEqualTo(expected);
        logger.info("Assert equal String with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        return this;
    }

    public AssertionLogCommon assertEqual(String messageError, Object actual, Object expected) {
        logger.info("Assert equal Object with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertEqual(String actual, String expected) {
        logger.info("Assert equal String between actual: {} and expected: {}", actual, expected);
        softAssertions.assertThat(actual).isEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertEqual(String messageError, int actual, int expected) {
        logger.info("Assert equal Int with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertEqual(int actual, int expected) {
        logger.info("Assert equal Int between actual: {} and expected: {}", actual, expected);
        softAssertions.assertThat(actual).isEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertEqual(String messageError, Long actual, Long expected) {
        logger.info("Assert equal Long with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertEqual(Long actual, Long expected) {
        logger.info("Assert equal Long between actual: {} and expected: {}", actual, expected);
        softAssertions.assertThat(actual).isEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertContain(String messageError, String actual, String expected) {
        logger.info("Assert equal with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).contains(expected);
        return this;
    }

    public AssertionLogCommon assertContain(String actual, String expected) {
        logger.info("Assert contain String with actual: {} and expected: {}", actual, expected);
        softAssertions.assertThat(actual).contains(expected);
        return this;
    }

    public AssertionLogCommon assertNotEqual(String messageError, String actual, String expected) {
        logger.info("Assert equal String with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isNotEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertNotEqual(String messageError, int actual, int expected) {
        logger.info("Assert equal Int with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isNotEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertNotEqual(String messageError, long actual, long expected) {
        logger.info("Assert equal Long with target message {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isNotEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertNotEqual(String actual, String expected) {
        logger.info("Assert not equal String between actual: {} and expected: {}", actual, expected);
        softAssertions.assertThat(actual).isNotEqualTo(expected);
        return this;
    }

    public AssertionLogCommon assertNotNull(String messageError, Object object) {
        logger.info("Assert not null with target message: {} with object: {}", messageError, object);
        softAssertions.assertThat(object).describedAs(messageError).isNotNull();
        return this;
    }

    public AssertionLogCommon assertIsNull(String messageError, Object object) {
        logger.info("Assert is null with target message: {} with object: {}", messageError, object);
        softAssertions.assertThat(object).describedAs(messageError).isNull();
        return this;
    }

    public AssertionLogCommon assertEqual(String messageError, boolean actual, boolean expected) {
        logger.info("Assert equal boolean with target message: {} between actual: {} and expected: {}", messageError, actual, expected);
        softAssertions.assertThat(actual).describedAs(messageError).isEqualTo(expected);
        return this;
    }

    public void executeAssert() {
        logger.info("Execute soft assert");
        softAssertions.assertAll();
    }
}
