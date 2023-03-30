package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class TitleTest extends BaseTest {

    @Test
    @Tag("Regression")
    @DisplayName("env")
    void shouldValidateCorrectTitle() {
        String actualTitle = driver.getTitle();
        log.info("Actual title is: " + actualTitle);
        assertThat(actualTitle).isEqualTo(System.getProperty("title"));
    }
}