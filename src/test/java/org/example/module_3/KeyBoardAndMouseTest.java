package org.example.module_3;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class KeyBoardAndMouseTest extends BaseTest {

    @Test
    public void keyBoardAndMouseTest() {
        page.navigate("https://the-internet.herokuapp.com/key_presses", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        Locator inputField = page.locator("#target");
        inputField.click();
        Keyboard keyboard = page.keyboard();
        keyboard.press("ArrowDown");
        Locator text = page.locator("#result");
        String visibleText = text.innerText();
        PlaywrightAssertions.assertThat(text).isVisible();
    }

    @Test
    public void rightClickTest(){
        page.navigate("https://the-internet.herokuapp.com/context_menu", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        Locator area = page.locator("#hot-spot");
        Mouse mouse = page.mouse();
        mouse.click(250, 250, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));

    }

    @Test
    public void dragAndDropTest(){
        page.navigate("https://the-internet.herokuapp.com/drag_and_drop", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        Locator source = page.locator("#column-a");
        Locator target = page.locator("#column-b");
        source.dragTo(target);
    }
}
