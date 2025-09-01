package edu.uph.m23si2.pertamaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.uph.m23si2.pertamaapp.model.KRS;
import edu.uph.m23si2.pertamaapp.model.KRSDetail;
import edu.uph.m23si2.pertamaapp.model.KelasMatakuliah;
import edu.uph.m23si2.pertamaapp.model.Mahasiswa;
import edu.uph.m23si2.pertamaapp.model.Matakuliah;
import edu.uph.m23si2.pertamaapp.model.Prodi;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtNama, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("default.realm")
                .schemaVersion(1)
                .allowWritesOnUiThread(true) // sementara aktifkan untuk demo
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        initData();
        btnLogin = findViewById(R.id.btnLogin);
        edtNama = findViewById(R.id.edtNama);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDashboard();
            }
        });
    }

    public void initData(){
        // menambahkan data
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(r -> {
            Number maxId = r.where(Mahasiswa.class).max("studentID");
            Prodi prodiSI = r.createObject(Prodi.class,0);
            prodiSI.setFakultas("Fakultas Teknologi Informasi");
            prodiSI.setNama("Sistem Informasi");

            Matakuliah matMobile = r.createObject(Matakuliah.class,0);
            matMobile.setNama("Pemrograman Mobile Lanjut");
            matMobile.setSks(3);
            matMobile.setProdi(prodiSI);

            Matakuliah matPBO = r.createObject(Matakuliah.class,1);
            matPBO.setNama("Pemrograman Berorientasi Objek");
            matPBO.setSks(3);
            matPBO.setProdi(prodiSI);

            KelasMatakuliah kelasMobile = r.createObject(KelasMatakuliah.class,0);
            kelasMobile.setRuangKelas("AD101");
            kelasMobile.setDosen("Sir Ade");

            KelasMatakuliah kelasPBO = r.createObject(KelasMatakuliah.class,1);
            kelasPBO.setRuangKelas("AD102");
            kelasPBO.setDosen("Sir Des");

            KRS krs1 = r.createObject(KRS.class,0);
            krs1.setSemester(6);
            krs1.setTahunAjaran("2024/2025");

            KRSDetail detail1 = r.createObject(KRSDetail.class,0);
            detail1.setKrs(krs1);
            detail1.setKelasMatakuliah(kelasMobile);
            detail1.setStatus("Diambil");

            KRSDetail detail2 = r.createObject(KRSDetail.class,1);
            detail2.setKrs(krs1);
            detail2.setKelasMatakuliah(kelasPBO);
            detail2.setStatus("Diambil");

        });
        Toast.makeText(this, "Data tersimpan", Toast.LENGTH_SHORT).show();

    }
    public void toProfil(){
        Intent intent = new Intent(this,ProfilActivity.class);
        intent.putExtra("nama",edtNama.getText().toString());
        startActivity(intent);
    }
    public void toDashboard(){
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}