package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PlayMarioActivity extends AppCompatActivity {

    private WebView mWebview;
    String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        url = getIntent().getStringExtra("url");
        mWebview = new WebView(this);



        WebSettings webSettings = mWebview.getSettings();
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabasePath("/data/data/"+this.getPackageName()+"/databases/");

       /* String databasePath = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        webSettings.setDatabasePath(databasePath);*/

        mWebview.setWebChromeClient(new WebChromeClient() {
            public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(5 * 1024 * 1024);
            }
        });
        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        mWebview.loadUrl(url);
        setContentView(mWebview);

    }

}
