package tw.edu.yuntech.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button B1,B2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1=findViewById(R.id.B1);
        B2=findViewById(R.id.B2);

        final NotificationChannel nc
                =new NotificationChannel("1","ncid",NotificationManager.IMPORTANCE_HIGH);
        final NotificationManager nm	=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        final Notification.BigPictureStyle bp=new  Notification.BigPictureStyle();
        bp.setSummaryText("白冰冰");
        bp.setBigContentTitle("I LOVE !!");
        //final  Bitmap bt=((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher_foreground)).getBitmap();
        //Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_foreground);
        final Bitmap bmp = ((BitmapDrawable)getResources().getDrawable(R.drawable.bbb)).getBitmap();
        bp.bigPicture(bmp);

        final Notification.Builder  nb
                =new Notification.Builder (MainActivity.this, "1")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setColor(Color.BLUE)
                .setContentTitle("text")
                .setContentText("OOO")
                .setChannelId("1")
                .setStyle(bp)
                ;




        B1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm.createNotificationChannel(nc);
                nm.notify(1,nb.build());
            }
        });

        B2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                nm.cancelAll();
            }
        });
    }
}