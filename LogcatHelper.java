package net.simplyadvanced.mapactivity.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogcatHelper extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            //TextView tv = (TextView)findViewById(R.id.textView1);
            //tv.setText(log.toString());
        } catch (IOException e) {
        }
    }

    public static void saveLogcatToFile(Context context) {
        try {
            String fileName = "logcat_" + System.currentTimeMillis() + ".txt";
            File outputFile = new File(context.getExternalCacheDir(), fileName);
            @SuppressWarnings("unused")
            Process process = Runtime.getRuntime().exec("logcat -f " + outputFile.getAbsolutePath());
            Toast.makeText(context, fileName + " exported to " + outputFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){

        }
    }
}