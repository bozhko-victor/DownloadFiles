package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.checkerframework.checker.units.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFilesTest {

    @Test
    void downloadFileTest() throws Exception {
        open("https://github.com/selenide/selenide-appium/blob/master/README.md");
        File download = $(byLinkText("Raw")).download();
        String result;
        try (InputStream is = new FileInputStream(download)) {
            result = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
        assertThat(result).contains("Selenide adaptor for Appium framework");
    }

        @Test
    void uploadFileTest1() {
        open("http://file.karelia.ru/");
        $("input[type='file']").uploadFromClasspath("example.txt");
        $("#file_submit").click();
        $("#fileQueue")
                .shouldHave(text("example.txt"));
    }


}
