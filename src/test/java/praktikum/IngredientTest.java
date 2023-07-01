package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);

    @Test
    public void getNameReturnCorrectName() {
        String actualName = ingredient.getName();
        String expectedName = "hot sauce";
        Assert.assertEquals("Должно возвращаться корректное имя ингридиента", expectedName, actualName);
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        float actualPrice = ingredient.getPrice();
        float expectedPrice = 100;
        Assert.assertEquals("Должна возвращаться корректная цена ингридиента", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getTypeReturnCorrectType() {
        IngredientType actualType = ingredient.getType();
        IngredientType expectedType = SAUCE;
        Assert.assertEquals("Должен возвращаться корректный тип ингридиента", expectedType, actualType);
    }
}
