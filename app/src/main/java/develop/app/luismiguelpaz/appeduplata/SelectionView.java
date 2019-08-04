package develop.app.luismiguelpaz.appeduplata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class SelectionView extends AppCompatActivity {

    Button jovenes;
    Button ninos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_view);

        jovenes = findViewById(R.id.jovenes);
        ninos = findViewById(R.id.ninos);

        jovenes.setOnClickListener( e -> {
            Intent intent = new Intent(getApplicationContext(), Simulation.class);
            intent.putExtra("type", "");
            startActivity(intent);
            System.exit(0);
            finish();
        });

        ninos.setOnClickListener( e -> {
            Intent intent = new Intent(getApplicationContext(), Simulation.class);
            intent.putExtra("type", "Ninios");
            startActivity(intent);
            finish();
        });
    }
}
