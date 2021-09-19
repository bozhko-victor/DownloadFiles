package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideFilesTest {

    @Test
    void downloadFileTest() throws Exception {
        Selenide.open("https://github.com/selenide/selenide-appium/blob/master/README.md");
        File download = $(byLinkText("Raw")).download();
        String result;
        try (InputStream is = new FileInputStream(download)) {
            result = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
        assertThat(result).contains("Selenide adaptor for Appium framework");
    }

    void uploadFileTest() {

    }
}
