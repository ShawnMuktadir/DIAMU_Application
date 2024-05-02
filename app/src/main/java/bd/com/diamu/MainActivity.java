package bd.com.diamu;

import static android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import bd.com.diamu.constant.Constant;
import bd.com.diamu.databinding.ActivityMainBinding;


@SuppressLint({"SetJavaScriptEnabled", "ObsoleteSdkInt"})
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setWebView();
    }

    private void setWebView() {
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.webView.getSettings().setMixedContentMode(MIXED_CONTENT_ALWAYS_ALLOW);
        }
        binding.webView.getSettings().setDomStorageEnabled(true);
        binding.webView.getSettings().setLoadWithOverviewMode(true);
        binding.webView.getSettings().setUseWideViewPort(true);
        binding.webView.getSettings().setBuiltInZoomControls(true);
        binding.webView.getSettings().setDisplayZoomControls(false);
        binding.webView.getSettings().setSupportZoom(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            binding.webView.getSettings().setAllowFileAccessFromFileURLs(true);
            binding.webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            binding.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        binding.webView.getSettings().setBlockNetworkImage(false);
        binding.webView.getSettings().setDatabaseEnabled(true);
        binding.webView.getSettings().setSupportMultipleWindows(true);
        binding.webView.getSettings().setGeolocationEnabled(true);
        binding.webView.getSettings().setBlockNetworkLoads(false);
        binding.webView.getSettings().setLoadsImagesAutomatically(true);
        binding.webView.getSettings().setAllowContentAccess(true);
        binding.webView.getSettings().setAllowFileAccess(true);
        binding.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        binding.webView.clearHistory();
        binding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

            }
        });

        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //code for opening the application
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(Constant.DIAMU_WEB_URL);
    }

    @Override
    public void onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
