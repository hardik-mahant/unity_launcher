package com.hardik.mahant.unitylauncher;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.unity3d.player.UnityPlayerActivity;

import java.util.Objects;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

    public static final String CHANNEL = "test_activity";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        Log.i("HomeActivity", "oncreate");
        new MethodChannel(Objects.requireNonNull(getFlutterEngine()).getDartExecutor().getBinaryMessenger(), CHANNEL).setMethodCallHandler(
                (call, result) -> {
                    if (call.method.equals("startNewActivity")) {
                        startNewActivity();
                    }
                }
        );
    }

    private void startNewActivity() {
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }
}
