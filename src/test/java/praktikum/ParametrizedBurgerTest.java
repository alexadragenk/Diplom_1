package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class ParametrizedBurgerTest {
    static Database database = new Database();
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedString;

    public ParametrizedBurgerTest(Bun bun, List<Ingredient> ingredients, String expectedString) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters(name = "Рецепт")
    public static Object[][] burgerTestData() {
        List<Ingredient> ingredientsDB = database.availableIngredients();
        List<Bun> bunsDB = database.availableBuns();
        return new Object[][]{
                {bunsDB.get(0), List.of(ingredientsDB.get(0), ingredientsDB.get(3)), "(==== black bun ====)\n= sauce hot sauce =\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 400,000000\n"},
                {bunsDB.get(1), List.of(ingredientsDB.get(1), ingredientsDB.get(4)), "(==== white bun ====)\n= sauce sour cream =\n= filling dinosaur =\n(==== white bun ====)\n\nPrice: 800,000000\n"},
        };
    }

    @Test
    public void getReceiptShouldReturnCorrectString() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        String actualString = burger.getReceipt();
        Assert.assertEquals("Должен возвращаться корректный рецепт бургера", expectedString, actualString);
    }
}