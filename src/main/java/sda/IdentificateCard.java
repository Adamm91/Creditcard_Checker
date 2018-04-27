package sda;

import java.io.IOException;
import java.util.List;

public  class IdentificateCard {
    public static String cardInfo (String number, String filePath) throws IOException {
        BanksReader banksReader = new BanksReader();
        BankCardChecker bankCardChecker = new BankCardChecker();
        LuhnChecker luhnChecker = new LuhnChecker();
        List<Rules> rules = banksReader.read(filePath);
        return !luhnChecker.checkLuhn(number) ? "Invalid card number" : bankCardChecker.checkCard(number, rules);
    }
}
