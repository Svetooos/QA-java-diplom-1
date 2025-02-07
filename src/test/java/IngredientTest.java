import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void createIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Тест", 2.0F);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Тест", ingredient.getName());
        assertEquals(2.0F, ingredient.getPrice(), 0.0F);
    }
}