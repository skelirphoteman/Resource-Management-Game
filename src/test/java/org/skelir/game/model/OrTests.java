package org.skelir.game.model;

import org.junit.jupiter.api.Test;
import org.skelir.game.exception.NegativeQuantity;

import static org.junit.jupiter.api.Assertions.*;

class OrTests {
    private Or or = new Or();

    @Test
    public void nameTest(){
        assertEquals("Or", or.getName());
    }

    @Test
    public void addQuantityTest(){
        int qts = or.getQuantity();

        int qtsAdd = 5;

        or.addQuantity(qtsAdd);

        assertEquals(qts + qtsAdd, or.getQuantity());
    }

    @Test
    public void subQuantityTest(){
        or = new Or(10);

        int qts = or.getQuantity();

        int qtsSub = 5;

        assertDoesNotThrow(() -> or.subQuantity(qtsSub));

        assertEquals(qts - qtsSub, or.getQuantity());
    }

    @Test
    public void negativeQuantityException(){
        or = new Or(0);

        int qts = or.getQuantity();

        int qtsSub = 5;

        assertThrows(NegativeQuantity.class, () -> or.subQuantity(qtsSub));
    }

    @Test
    public void hasQuantityTest(){
        int qts = 15;
        or = new Or(15);

        assertTrue(or.hasQuantity(qts - 2));
        assertTrue(or.hasQuantity(qts));
        assertFalse(or.hasQuantity(qts + 10));
    }
}