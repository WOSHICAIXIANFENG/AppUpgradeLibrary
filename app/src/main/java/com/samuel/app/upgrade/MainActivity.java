package com.samuel.app.upgrade;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ieasy360.app.upgrade.UpdateChecker;

public class MainActivity extends AppCompatActivity {
    // You need to create your app update api in your server.
    public static final String APP_UPDATE_SERVER_URL = "http://192.168.1.136:83/WebServer/Files/PatchHandler.ashx?from=Android";
    Button mUpgradeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUpgradeBtn = (Button) findViewById(R.id.button);
        mUpgradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 检测是否有新版本
                UpdateChecker.checkForDialog(MainActivity.this, APP_UPDATE_SERVER_URL, true, true);
                Toast.makeText(MainActivity.this, R.string.check_tip, Toast.LENGTH_LONG).show();
            }
        });
    }
}
