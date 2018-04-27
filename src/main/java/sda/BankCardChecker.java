package sda;

import java.util.List;

public class BankCardChecker {
    public String checkCard (String number, List<Rules> rules) {
        String result = "Unknown";

        for (Rules rule : rules) {
            if (number.startsWith(rule.getPrefix()) && number.length() == rule.getLength()) {
                result = rule.getIssuer();
            }
        }
        return result;
    }
}
