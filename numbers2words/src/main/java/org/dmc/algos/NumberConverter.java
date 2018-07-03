package org.dmc.algos;

public class NumberConverter {

    public static final String[] basic_digits = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] prefixes = new String[] {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static final String[] powers_prefixes = new String[] {"thousand", "million", "billion"};
    
    public static final int THOUSAND = 1000;
    public static final String HUNDRED_PREF = "hundred";
    public static final String SPACE = " ";
    public static final String EMPTY = "";

    /**
     * Given a positive number, convert it to the english representation.
     * 
     * Examples:
     * 
     * 1 - one
     * 12 - twelve
     * 31 - thirty one
     * 124 - one hundred twenty four
     * 1357 - one thousand three hundred fifty seven
     * 12357124 - twelve million three hundred fifty seven thousand one hundred twenty four
     * 2124345456 - two BILLION "one HUNDRED twenty four" MILLION "three HUNDRED forty five" THOUSAND "four HUNDRED fifty six"
     * 
     * @param number number to be converted
     * @return words in english
     */
    public static String toWords(int number) {
        StringBuilder words = new StringBuilder();

        if (number < 20) {
            return basic_digits[number];
        }
        
        // 10 - 99
        if (number < 100) {
            return words.append(prefixes[number / 10])
                        .append(convertIfPresent(number % 10))
                        .toString();
        }

        // 100 - 999
        if (number < 1000) {
            return words.append(toWords(number / 100))
                        .append(SPACE)
                        .append(HUNDRED_PREF)
                        .append(convertIfPresent(number % 100))
                        .toString();
        }
        
        // 1000 - max int
        int power = getThousandPower(number);
        String prefix = powers_prefixes[power - 1];
        int divisor = (int) Math.pow(THOUSAND, power);

        return words.append(toWords(number / divisor))
                    .append(SPACE)
                    .append(prefix)
                    .append(convertIfPresent(number % divisor))
                    .toString();
    }

    private static int getThousandPower(int number) {
        int power = 0;
        int current = number;
        while (current >= THOUSAND) {
            current /= THOUSAND;
            power++;
        }
        return power;
    }

    private static String convertIfPresent(int number) {
        // convert number only if not zero
        if (number > 0) {
            return SPACE + toWords(number); 
        }
        return EMPTY;
    }
}
