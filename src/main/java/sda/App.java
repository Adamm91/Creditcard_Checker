package sda;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException {

        String filePath = "rules.csv";
        String cardNumber = "2241143134311219";

        System.out.println(IdentificateCard.cardInfo(cardNumber, filePath));

    }
}
