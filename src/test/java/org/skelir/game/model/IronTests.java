package org.skelir.game.model;

import org.junit.jupiter.api.Test;
import org.skelir.game.exception.NegativeQuantity;

import static org.junit.jupiter.api.Assertions.*;

class IronTests {
    private Iron iron = new Iron();

    @Test
    public void nameTest(){
        assertEquals("Iron", iron.getName());
    }

    @Test
    public void addQuantityTest(){
        int qts = iron.getQuantity();

        int qtsAdd = 5;

        iron.addQuantity(qtsAdd);

        assertEquals(qts + qtsAdd, iron.getQuantity());
    }

    @Test
    public void subQuantityTest(){
        iron = new Iron(10);

        int qts = iron.getQuantity();

        int qtsSub = 5;

        assertDoesNotThrow(() -> iron.subQuantity(qtsSub));

        assertEquals(qts - qtsSub, iron.getQuantity());
    }

    @Test
    public void negativeQuantityExceptionTest(){
        iron = new Iron(0);

        int qts = iron.getQuantity();

        int qtsSub = 5;

        assertThrows(NegativeQuantity.class, () -> iron.subQuantity(qtsSub));
    }

    @Test
    public void hasQuantityTest(){
        int qts = 15;
        iron = new Iron(15);

        assertTrue(iron.hasQuantity(qts - 2));
        assertTrue(iron.hasQuantity(qts));
        assertFalse(iron.hasQuantity(qts + 10));
    }
}