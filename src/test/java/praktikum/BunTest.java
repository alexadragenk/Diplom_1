package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameReturnCorrectName() {
        String actualName = bun.getName();
        String expectedName = "black bun";
        Assert.assertEquals("Должно возвращаться корректное имя булочки", expectedName, actualName);
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        float actualPrice = bun.getPrice();
        float expectedPrice = 100;
        Assert.assertEquals("Должна возвращаться корректная цена булочки", expectedPrice, actualPrice, 0);
    }
}
