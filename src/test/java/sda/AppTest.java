package sda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AppTest
{

    private BankCardChecker bankCardChecker;
    private LuhnChecker luhnChecker;


    @Before
    public void createObjects() {
        bankCardChecker = new BankCardChecker();
        luhnChecker = new LuhnChecker();
    }

    @Test
    public void luhnCheckerTest () {
        //given
        String cardNumber1 = "748110"; // false
        String cardNumber2 = "748210"; // true
        String cardNumber3 = "4221143134311219"; // true
        String cardNumber4 = "4221143134311218"; // false
        //when
        boolean result1 = luhnChecker.checkLuhn(cardNumber1);
        boolean result2 = luhnChecker.checkLuhn(cardNumber2);
        boolean result3 = luhnChecker.checkLuhn(cardNumber3);
        boolean result4 = luhnChecker.checkLuhn(cardNumber4);
        //then
        Assert.assertFalse(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);
    }

    @Test
    public void cardCheckerTest () throws IOException {

        List<Rules> rules = new ArrayList<>();
        Rules rule1 = new Rules();
        Rules rule2 = new Rules();
        Rules rule3 = new Rules();

        rule1.setPrefix("4");
        rule2.setPrefix("51");
        rule3.setPrefix("34");

        rule1.setLength(16);
        rule2.setLength(16);
        rule3.setLength(15);

        rule1.setIssuer("Visa");
        rule2.setIssuer("Master Card");
        rule3.setIssuer("American Express");

        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);

        String cardNumber1 = "4321645165321653"; // visa
        String cardNumber2 = "5121645165321653"; // MC
        String cardNumber3 = "342164516532165"; // AE
        String cardNumber4 = "2332164516532165"; // Unknown

        String expectedResult1 = "Visa";
        String expectedResult2 = "Master Card";
        String expectedResult3 = "American Express";
        String expectedResult4 = "Unknown";


        String result1 = bankCardChecker.checkCard(cardNumber1, rules);
        String result2 = bankCardChecker.checkCard(cardNumber2, rules);
        String result3 = bankCardChecker.checkCard(cardNumber3, rules);
        String result4 = bankCardChecker.checkCard(cardNumber4, rules);

        Assert.assertEquals(expectedResult1, result1);
        Assert.assertEquals(expectedResult2, result2);
        Assert.assertEquals(expectedResult3, result3);
        Assert.assertEquals(expectedResult4, result4);
    }


}
