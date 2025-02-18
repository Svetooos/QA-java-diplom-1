import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void getSauce() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void getFilling() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }

}
