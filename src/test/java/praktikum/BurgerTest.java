package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsWorkCorrect() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientWorkCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals("Ингридиенты должны добавляться в список ингридиентов бургера", List.of(ingredient1, ingredient2), burger.ingredients);
    }

    @Test
    public void removeIngredientWorkCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        Assert.assertEquals("Ингридиенты должны удаляться из списка ингридиентов бургера", List.of(), burger.ingredients);
    }

    @Test
    public void moveIngredientWorkCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals("Ингридиенты должны перемещаться в списке ингридиентов бургера", List.of(ingredient2, ingredient1), burger.ingredients);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient1.getPrice()).thenReturn(100F);
        Assert.assertEquals("Должна возвращаться корректная цена бургера", 300, burger.getPrice(), 0);

    }
}