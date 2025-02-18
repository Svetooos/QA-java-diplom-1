import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void createBun() {
        Bun bun = new Bun("Тест", 2.0F);
        assertEquals("Тест", bun.getName());
        assertEquals(2.0F, bun.getPrice(), 0.0F);
    }
}
