package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll

    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void PractiveFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("test@test.ru");
        $("[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("8800535335");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2005");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $("[aria-label='Choose Thursday, May 12th, 2005']").click();

        $("[id=subjectsInput]").setValue("Text").pressEnter(); // Элемент найден правильно, текст не сохраняется в форме
        $("[for='hobbies-checkbox-3']").click();
        //      $("[id=uploadPicture]").uploadFile  //Загрузка файла
        $("[id=currentAddress]").setValue("Moscow");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        $("[id=submit]").click();

        $(".table-responsive").shouldHave(text("Ivan"),text("Ivanov"),text("test@test.ru"),
                text("Male"),text("8800535335"),text("12 May,2005"),
                text("Music"),text("Moscow"),text("NCR Delhi"));

    }

}