import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Before
    public void init() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(50F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(200F);

        Mockito.when(bun.getName()).thenReturn("Пшеничная булка");
        Mockito.when(ingredientFirst.getName()).thenReturn("Говяжья котлета");
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSecond.getName()).thenReturn("Сырный соус");
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void createBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        assertNotNull(burger.bun);
        assertNotNull(ingredientFirst);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);

        assertEquals(450, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        String expected = "(==== Пшеничная булка ====)\r\n= filling Говяжья котлета =\r\n= sauce Сырный соус =\r\n(==== Пшеничная булка ====)\r\n\r\nPrice: 450,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }


    @Test
    public void getReceipt_remove() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.removeIngredient(0);
        String expected = "(==== Пшеничная булка ====)\r\n= sauce Сырный соус =\r\n(==== Пшеничная булка ====)\r\n\r\nPrice: 400,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void getReceipt_move() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0,1);
        String expected = "(==== Пшеничная булка ====)\r\n= sauce Сырный соус =\r\n= filling Говяжья котлета =\r\n(==== Пшеничная булка ====)\r\n\r\nPrice: 450,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}