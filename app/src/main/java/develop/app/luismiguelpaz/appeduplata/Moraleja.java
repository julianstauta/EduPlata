package develop.app.luismiguelpaz.appeduplata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Moraleja extends AppCompatActivity {

    TextView moraleja;
    Button butBack;
    Button butSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moraleja);
        moraleja = findViewById(R.id.moraleja);
        butBack = findViewById(R.id.buttonBack);
        moraleja.setText(getIntent().getExtras().getString("moraleja"));

        butSignup=findViewById(R.id.registro);


        butBack.setOnClickListener( e -> {
            Intent intent = new Intent(this, SelectionView.class);
            startActivity(intent);
            finish();
        });
        butSignup.setOnClickListener( e -> {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
            finish();
        });


    }
}
