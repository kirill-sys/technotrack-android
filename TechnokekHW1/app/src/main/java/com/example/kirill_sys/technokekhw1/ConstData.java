package com.example.kirill_sys.technokekhw1;

public class ConstData {
    static final String STATE_BTN = "btnText";
    static final String STATE_TV = "tvText";
    static final String STATE_TIME = "currTime";
    static final String STATE_TIME_1 = "currTime1";

    private final static String[] units = {
            "", "один", "два", "три", "четыре", "пять", "шесть",
            "семь", "восемь", "девять", "десять", "одиннадцать",
            "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };
    private final static String[] tens = {
            "", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ",
            "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "
    };
    private final static String[] hundreds = {
            "", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ",
            "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "
    };
    final static String thousand = "тысяча";

    public static String numberToText(int number) {
        StringBuilder result = new StringBuilder();
        int unit = number % 10;
        int ten = (number / 10) % 10;
        int hundred = number / 100;

        result.append(hundreds[hundred]);
        if (ten >= 2) {
            result.append(tens[ten]).append(units[unit]);
        } else if (unit == 0) {
            result.append(tens[ten]);
        } else {
            result.append(units[ten * 10 + unit]);
        }

        return result.toString().trim();
    }
}