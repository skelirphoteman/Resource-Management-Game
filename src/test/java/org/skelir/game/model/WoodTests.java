package org.skelir.game.model;

import org.junit.jupiter.api.Test;
import org.skelir.game.exception.NegativeQuantity;

import static org.junit.jupiter.api.Assertions.*;

class WoodTests {
    private Wood wood = new Wood();

    @Test
    public void nameTest(){
        assertEquals("Wood", wood.getName());
    }

    @Test
    public void addQuantityTest(){
        int qts = wood.getQuantity();

        int qtsAdd = 5;

        wood.addQuantity(qtsAdd);

        assertEquals(qts + qtsAdd, wood.getQuantity());
    }

    @Test
    public void subQuantityTest(){
        wood = new Wood(10);

        int qts = wood.getQuantity();

        int qtsSub = 5;

        assertDoesNotThrow(() -> wood.subQuantity(qtsSub));

        assertEquals(qts - qtsSub, wood.getQuantity());
    }

    @Test
    public void negativeQuantityException(){
        wood = new Wood(0);

        int qts = wood.getQuantity();

        int qtsSub = 5;

        assertThrows(NegativeQuantity.class, () -> wood.subQuantity(qtsSub));
    }

    @Test
    public void hasQuantityTest(){
        int qts = 15;
        wood = new Wood(15);

        assertTrue(wood.hasQuantity(qts - 2));
        assertTrue(wood.hasQuantity(qts));
        assertFalse(wood.hasQuantity(qts + 10));
    }
}