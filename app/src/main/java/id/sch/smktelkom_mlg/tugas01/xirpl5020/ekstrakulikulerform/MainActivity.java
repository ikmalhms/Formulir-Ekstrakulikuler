package id.sch.smktelkom_mlg.tugas01.xirpl5020.ekstrakulikulerform;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        bOk = (Button) findViewById(R.id.buttonOK);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        cbBC = (CheckBox) findViewById(R.id.checkBoxBC);
        cbOR = (CheckBox) findViewById(R.id.checkBoxOR);
        cbGB = (CheckBox) findViewById(R.id.checkBoxGB);
        cbNL = (CheckBox) findViewById(R.id.checkBoxNL);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                proses();

            }
        });
    }

    private void proses() {

        String hasil = "Ekstrakulikuler Pilihan Anda : \n";
        int startlen = hasil.length();
        if (cbBC.isChecked()) hasil += cbBC.getText() + "\n";
        if (cbOR.isChecked()) hasil += cbOR.getText() + "\n";
        if (cbGB.isChecked()) hasil += cbGB.getText() + "\n";
        if (cbNL.isChecked()) hasil += cbNL.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak Ada Pilihan";

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String irb;

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgStatus.getCheckedRadioButtonId());
            irb = rb.getText().toString();
        } else {

            irb = null;
        }

        if (irb == null) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Anda Harus Mengisi Jenis Kelamin!!");
            builder1.setCancelable(true);

            builder1.setNeutralButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    }
            );
            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else {
            tvHasil.setText("Nama : " + nama + " \n" + "\n" +
                    "Alamat : " + alamat + " \n" + "\n" + "Jenis Kelamin : " + irb
                    + " \n" + "\n" + hasil + "\n" + "Kelas Anda : " + spKelas.getSelectedItem().toString());
        }
    }
}
