package com.example.valterpereira.promocoewrestling;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


     static final String RESOURCE="[\n" +
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

        if (findViewById(R.id.fragment_container) != null) {
            if (StatusCache.portrait != null) {
                Toast.makeText(this, "The FragmentGeneral was already created", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Create new FragmentGeneral", Toast.LENGTH_SHORT).show();
            setPortraitFragment(StatusCache.getPortrait());
        }else {
            if ((StatusCache.landscape != null) && (StatusCache.landscapeDet != null)) {
                Toast.makeText(this, "The Fragments were already created", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Create new Fragments", Toast.LENGTH_SHORT).show();
            setLandscapeFragments(StatusCache.getLandscape1(), StatusCache.getLandscape2());
        }
    }
    private void setPortraitFragment(TitlesFragment titlefrag) {
        titlefrag.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                titlefrag).commit();
    }

    private void setLandscapeFragments(TitlesFragment fragmentT, DetailsFragment fragmentD) {
        fragmentT.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.titles_container,
                fragmentT).commit();

        fragmentD.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.details_container,
                fragmentD).commit();
    }

    public void getLocation(View view) {
        String locationLabel = DetailsFragment.promocao.getName();
        Uri location = Uri.parse("geo:" + DetailsFragment.promocao.getLocation() + "?q=" + DetailsFragment.promocao.getLocation() + "(" + locationLabel + ")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        PackageManager manager = getPackageManager();
        List<ResolveInfo> info = manager.queryIntentActivities(mapIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (info.size() > 0) {
            startActivity(mapIntent);
            return;
        }
        Toast.makeText(this, "Não tem aplicações que suportem isto!", Toast.LENGTH_SHORT).show();
    }

    public void getWebsite(View view) {
        Uri uri = Uri.parse(DetailsFragment.promocao.getWebsite());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        Intent chooser = Intent.createChooser(intent, "abrir com...");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
            return;
        }
        Toast.makeText(this, "Não tem aplicações que suportem isto!", Toast.LENGTH_SHORT).show();

    }
}
