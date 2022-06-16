package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;
public class InformationActivity extends AppCompatActivity {
    public static String CONTENT = "content";
    static Map<String, String> articles = Map.ofEntries(
            entry("Adidas original Tee Shirt A Bandes Adicolor Rouge", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("Adidas original Tee Shirt A Bandes HE9550 Jaune", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-he9550-jaune-310993.html"),
            entry("Adidas Baskets NY 90 FZ2247 White Royal Blue", "https://www.laboutiqueofficielle.com/achat-baskets-basses/adidas-baskets-ny-90-fz2247-footwear-white-royal-blue-247735.html"),
            entry("Calvin Klein Baskets Runner Black Bright White", "https://www.laboutiqueofficielle.com/achat-baskets-basses/calvin-klein-baskets-runner-sneaker-lace-up-0086-black-bright-white-266592.html"),
            entry("Casquette Neon 940 12375788 Blanc Jaune Fluo", "https://www.laboutiqueofficielle.com/achat-casquettes-de-baseball/new-era-casquette-neon-940-new-york-yankees-12375788-blanc-jaune-fluo-216137.html"),
            entry("Casquette Trucker Essential  NY 12 Camel Noir", "https://www.laboutiqueofficielle.com/achat-trucker/new-era-casquette-trucker-essential-af-new-york-yankees-12589246-camel-noir-235669.html"),
            entry("FINAL CLUB Pantalon Cargo Skinny Fit 944 Camel", "https://www.laboutiqueofficielle.com/achat-pantalons-cargo/final-club-pantalon-cargo-skinny-fit-944-camel-304431.html"),
            entry("Frilivin Chemise Jean A CA-639 Bleu Denim", "https://www.laboutiqueofficielle.com/achat-chemises-manches-courtes/frilivin-chemise-jean-a-manches-courtes-ca-639-bleu-denim-305633.html"),
            entry("LBO Chemise Slim Fit 159 Carreaux Noir Rouge", "https://www.laboutiqueofficielle.com/achat-chemises-manches-longues/lbo-chemise-manches-longues-slim-fit-159-carreaux-noir-rouge-103638.html"),
            entry("Tommy hilfiger Tee Shirt A Bandes RN 0562 Blanc", "https://www.laboutiqueofficielle.com/achat-t-shirts/tommy-hilfiger-tee-shirt-a-bandes-rn-0562-blanc-221367.html")
    );



    public static synchronized Intent newIntent(Context context, String content) {
        final Intent intent = new Intent(context, InformationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra(CONTENT, content);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("La Boutique Officielle");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((TextView)findViewById(R.id.productTV)).setText(
                getIntent().getStringExtra(CONTENT));
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String label = getIntent().getStringExtra(CONTENT);
                if (articles.get(label) != null) {
                    openUrl(articles.get(label));
                }
            }
        });

        findViewById(R.id.scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openUrl(String url){
        if (url.startsWith("http://") || url.startsWith("https://")) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}