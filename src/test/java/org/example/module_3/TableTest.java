package org.example.module_3;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TableTest extends BaseTest {

    @Test
    public void tableHeadersTest() {
        page.navigate("https://the-internet.herokuapp.com/tables", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        List<Locator> rows = page.locator("//table[@id='table1']//tbody/tr").all();

        List<Users> users = rows.stream()
                .map(cells -> {
                    List<Locator> cell = cells.getByRole(AriaRole.CELL).all();
                    String firstName = cell.get(1).innerText();
                    String lastName = cell.get(0).innerText();
                    String email = cell.get(2).innerText();
                    String due = cell.get(3).innerText();
                    String webSite = cell.get(4).innerText();
                    Locator action = cell.get(5);
                    return new Users(lastName, firstName, email, due, webSite, action);
                })
                .collect(Collectors.toList());

        for(Users user : users) {
            System.out.println(user);
        }

        users.stream()
                .filter(i -> i.getFirstName().equals("Jason"))
                .findFirst().ifPresent(System.out::println);
    }


}
