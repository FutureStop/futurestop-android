/**
 * 
 */
package com.github.futurestop.activity;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * @author Chung-Yi Cho
 * Test
 */
public class HomeActivity extends FragmentActivity {
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Hello Home Activity");
        setContentView(tv);
    };
    
    
}
