package org.example.module_3;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest extends BaseTest {

    @Test
    public void checkDressPriceTest() {
        page.navigate("http://www.automationpractice.pl/index.php", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));

//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dresses")).first().click();
        Locator menuBar = page.locator("#block_top_menu");
        menuBar.locator(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DRESSES"))).click();
        List<Locator> allItems = page.locator("//div[@class='product-container']").all();

        allItems.stream().forEach(System.out::println);

        List<ShopItem> shopItemList = allItems.stream()
                .map(item -> {
                    String itemName = item.locator("//a[@class='product-name']").innerText();
                    String itemPrice = item.locator("//div[@class='right-block']//span[@class='price product-price']").innerText().substring(1);
                    return new ShopItem(itemName, itemPrice);
                })
                .collect(Collectors.toList());

        for (ShopItem item : shopItemList) {
            assertTrue(item.getItemName().contains("Printed"));
        }

        long count = shopItemList.stream()
                .map(s -> {
                    return Integer.valueOf(s.getPrice());
                })
                .filter(price -> price < 15)
                .count();

//                .forEach(price -> {
//                    assertTrue(price > 10);
//                });


        assertEquals(0, count);
    }
}
