package org.dmc.algos;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberConverterTest {
    
    @Test
    public void toWords_basic_shouldSucceed() {
        assertEquals("zero", NumberConverter.toWords(0));
        assertEquals("one", NumberConverter.toWords(1));
        assertEquals("two", NumberConverter.toWords(2));
        assertEquals("three", NumberConverter.toWords(3));
        assertEquals("fourteen", NumberConverter.toWords(14));
        assertEquals("twenty six", NumberConverter.toWords(26));
        assertEquals("fifty seven", NumberConverter.toWords(57));
        assertEquals("sixty eight", NumberConverter.toWords(68));
        assertEquals("ninety nine", NumberConverter.toWords(99));
    }

    @Test
    public void toWords_hundred_shouldSucceed() {
        assertEquals("one hundred", NumberConverter.toWords(100));
        assertEquals("one hundred eleven", NumberConverter.toWords(111));
        assertEquals("three hundred thirty three", NumberConverter.toWords(333));
        assertEquals("six hundred eighty one", NumberConverter.toWords(681));
        assertEquals("nine hundred ninety nine", NumberConverter.toWords(999));
    }

    @Test
    public void toWords_powers_shouldSucceed() {
        assertEquals("sixty thousand one hundred one", NumberConverter.toWords(60101));
        assertEquals("two billion one hundred twenty four million three hundred forty five thousand four hundred fifty six", NumberConverter.toWords(2124345456));
        assertEquals("twelve million three hundred fifty seven thousand one hundred twenty four", NumberConverter.toWords(12357124));
        assertEquals("twelve million three hundred fifty seven thousand one hundred one", NumberConverter.toWords(12357101));
        assertEquals("one billion one", NumberConverter.toWords(1000000001));
    }
}