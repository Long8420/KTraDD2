package baitap.ute.demolist_proflie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListviewItemActivity extends AppCompatActivity {

    TextView iddongho, idgia;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_listitem );

        iddongho = findViewById ( R.id.idTitle );
        imageView = findViewById ( R.id.imageView );
        Intent intent = getIntent ();
        String receivedName = intent.getStringExtra ( "name" );
        int receivedImage = intent.getIntExtra ( "image", 0 );

        iddongho.setText ( receivedName );
        imageView.setImageResource ( receivedImage );

    }
}
