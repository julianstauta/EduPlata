package develop.app.luismiguelpaz.appeduplata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    Button butCont;
    EditText et1;
    EditText et2;
    EditText et3;
    AppCompatCheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        butCont = findViewById(R.id.but_cont);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        checkBox = findViewById(R.id.cb);

        butCont.setOnClickListener( e -> {

            if (et1!=null || et1.getText().equals("")
            ||et2!=null || et2.getText().equals("")
            ||et3!=null || et3.getText().equals("")
            ||!checkBox.isChecked()){
                Toast.makeText(this, "Debes llenar todos los campos y aceptar los terminos y condiciones", Toast.LENGTH_LONG);
            } else{
                Intent intent = new Intent(getApplicationContext(), stats.class);
            }

        });

    }
}
