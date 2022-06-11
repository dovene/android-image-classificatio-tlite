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

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;
public class InformationActivity extends AppCompatActivity {
    public static String CONTENT = "content";
    static Map<String, String> articles = Map.ofEntries(
            entry("Adidas Original Tee Shirt A Bandes Adicolor Classi", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("adidas original Tee Shirt A Bandes HE9550 Jaune", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("tommy hilfiger Tee Shirt A Bandes RN 0562 Blanc", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("adidas original Tee Shirt A Bandes HE9550 Jaune3", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("adidas original Tee Shirt A Bandes HE9550 Jaune4", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("adidas original Tee Shirt A Bandes HE9550 Jaune5", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("adidas original Tee Shirt A Bandes HE9550 Jaune6", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html"),
            entry("adidas original Tee Shirt A Bandes HE9550 Jaune7", "https://www.laboutiqueofficielle.com/achat-t-shirts/adidas-tee-shirt-a-bandes-adicolor-classics-he9547-rouge-296457.html")
    );



    public static Intent newIntent(Context context, String content) {
        final Intent intent = new Intent(context, InformationActivity.class);
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
                openUrl(Objects.requireNonNull(articles.get(getIntent().getStringExtra(CONTENT))));
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