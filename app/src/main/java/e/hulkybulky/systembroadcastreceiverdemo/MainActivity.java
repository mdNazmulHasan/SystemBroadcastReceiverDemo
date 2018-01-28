package e.hulkybulky.systembroadcastreceiverdemo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    MyPhoneReceiver myPhoneReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        IntentFilter filter = new IntentFilter();
        filter.addAction("service.to.activity.transfer");
        myPhoneReceiver = new MyPhoneReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //UI update here
                if (intent != null)
                    Toast.makeText(context, intent.getStringExtra("number"), Toast.LENGTH_LONG).show();
            }
        };
        registerReceiver(myPhoneReceiver, filter);
    }
}
