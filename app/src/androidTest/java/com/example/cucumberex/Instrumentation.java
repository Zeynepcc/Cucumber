package com.example.cucumberex;

import android.os.Bundle;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.runner.AndroidJUnitRunner;

import org.junit.runner.RunWith;

import cucumber.api.android.CucumberInstrumentation;
import cucumber.api.android.CucumberInstrumentationCore;

public class Instrumentation extends AndroidJUnitRunner {
    private final CucumberInstrumentationCore instrumentationCore = new
            CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        instrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
