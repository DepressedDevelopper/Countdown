package software.depresseddeveloper.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //We want to create a countdown to the 31 August 2024 at 23:59:59
        //We want to display the countdown in the format: 00 years 00 months 00 days 00 hours 00 minutes 00 seconds
        //We want to update the countdown every second
        //We want to display the countdown in a TextView

        TextView countdown = findViewById(R.id.countdown);
        getSupportActionBar().hide();
        //We create a new thread to run the countdown
        new Thread(new Runnable() {
            @Override
            public void run() {
                //We create a while loop to run the countdown
                while (true) {
                    //We create a try catch block to catch any errors
                    try {
                        //We take the end time and the now time and subtract them to get the difference
                        long difference = 1735680000000L - System.currentTimeMillis();
                        //We create a variable to store the seconds
                        long seconds = difference / 1000;
                        //We create a variable to store the minutes
                        long minutes = seconds / 60;
                        //We create a variable to store the hours
                        long hours = minutes / 60;
                        //We create a variable to store the days
                        long days = hours / 24;
                        //We create a variable to store the months
                        long months = days / 30;
                        //We create a variable to store the years
                        long years = months / 12;

                        //We display the countdown in the TextView
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                countdown.setText(String.format("%02d years \n %02d months \n %02d days \n %02d hours \n %02d minutes \n %02d seconds", years, months % 12, days % 30, hours % 24, minutes % 60, seconds % 60));
                            }
                        });
                        //We make the thread sleep for 1 second
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


}