package id.sch.smktelkom_mlg.tugas01.xirpl5020.ekstrakulikulerform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spKelas;
    CheckBox cbBC, cbOR, cbGB, cbNL;
    RadioButton rbL, rbP;
    EditText etNama;
    EditText etAlamat;
    Button bOk;
    TextView tvHasil;
    RadioGroup rgStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
