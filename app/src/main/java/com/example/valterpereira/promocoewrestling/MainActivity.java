package com.example.valterpereira.promocoewrestling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private static final String RESOURCE="[\n" +
            "\t{\n" +
            "\t\t\"Name\":\"Associação Portuguesa de Wrestling\",\n" +
            "\t\t\"Description\": \"Mais antiga promoção de wrestling do país.\",\n" +
            "\t\t\"Image\":\"https://wrestling.pt/wp-content/uploads/2017/01/apw-logo.jpg\",\n" +
            "\t\t\"Website\": \"https://www.facebook.com/apwwrestling/\",\n" +
            "\t\t\"Location\":\"37.141289,-8.539057\"\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t},\n" +
            "\t\n" +
            "\t{\n" +
            "\t\"Name\":\"Wrestling Portugal\",\n" +
            "\t\t\"Description\": \"Mais famosa promoção do país\",\n" +
            "\t\t\"Image\":\"http://www.wrestlingportugal.com/wp-content/uploads/2014/12/lutador.jpg\",\n" +
            "\t\t\"Website\": \"http://wrestlingportugal.com/\",\n" +
            "\t\t\"Location\":\"38.757128,-9.265047\"\n" +
            "\t\n" +
            "\t\n" +
            "\t},\n" +
            "\n" +
            "\t{\n" +
            "\t\"Name\":\"Centro de Treinos Wrestling\",\n" +
            "\t\t\"Description\": \"Mais recente promoção do país\",\n" +
            "\t\t\"Image\":\"https://www.ctwportugal.com/wp-content/uploads/2017/09/CTW-Centro-Treinos-Wrestling-Logo-min.png\",\n" +
            "\t\t\"Website\": \"https://www.ctwportugal.com/\",\n" +
            "\t\t\"Location\":\"38.7050696,-9.1962183\"\n" +
            "\t\n" +
            "\t}\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
