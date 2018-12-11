package com.example.vsvll.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = findViewById(R.id.webView);

        //The advantage of using webView is we can show the web in our app itself rather than going to a browser.
        //Also we need to give internet permission to our app in order to load page in our android app.
        String URL =  "https://www.google.co.in";

        //the below code will help to load all the further searches in our app.
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(URL);

        //The above code will load the  page you have searched for, however when you click on the back button it will close the app
        //To avoid this we need override onBackPress method.
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack() == true){
            webView.goBack();
        }

        else if(webView.canGoBack() == false)
        {
            //here we can add and alert dialog box saying "Are you sure you want to leave"

            //the below line will close the app if no page to go back
            super.onBackPressed();
        }

    }
}

