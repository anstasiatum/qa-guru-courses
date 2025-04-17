import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class SearchTests {

        //Yandex main page opened
        @Test
        void yandexSuccessfulSearchTest() {
            Configuration.holdBrowserOpen = true;
            open("https://ya.ru/");
            $("html").shouldHave(text("Войти"));
        }

        //Google main page opened
        @Test
        void googlePageCanBeOpened() {
            Configuration.holdBrowserOpen = true;
            open("https://www.google.com/");
            $("html").shouldHave(text("Россия"));
        }

        //DuckDuckGo main page opened
        @Test
        void duckDuckGoPageCanBeOpened() {
            Configuration.holdBrowserOpen = true;
            open("https://duckduckgo.com/");
            $("html").shouldHave(text("Chat"));
        }

        //DuckDuckGo search results
        @Test
        void duckDuckGoSuccessfulSearchTest() {
            open("https://duckduckgo.com/");
            $("#searchbox_input").setValue("selenide").pressEnter();
            $("#web_content_wrapper").shouldHave(text("https://selenide.org"));
        }
    }

