import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void yandexSuccessfulSearchTest() {
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru/");
        $("html").shouldHave(text("Войти"));
    }

    @Test
    void googlePageCanBeOpened() {
        Configuration.holdBrowserOpen = true;
        open("https://www.google.com/");
        $("html").shouldHave(text("Россия"));
    }

    @Test
    void duckDuckGoPageCanBeOpened() {
        Configuration.holdBrowserOpen = true;
        open("https://duckduckgo.com/");
        $("html").shouldHave(text("Chat"));
    }

    @Test
    void duckDuckGoSuccessfulSearchTest() {
        open("https://duckduckgo.com/");
        $("#searchbox_input").setValue("selenide").pressEnter();
        $("#web_content_wrapper").shouldHave(text("https://selenide.org"));
    }
}