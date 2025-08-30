package edu.uph.m23si2.pertamaapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KelasMatakuliah extends RealmObject {
    @PrimaryKey
    private int kelasID;
    private String NamaKelas, Semester, TahunAjaran;
    private Matakuliah matakuliah;

    public KelasMatakuliah(){}

    public KelasMatakuliah(int kelasID, String namaKelas, String semester, String tahunAjaran, Matakuliah matakuliah) {
        this.kelasID = kelasID;
        NamaKelas = namaKelas;
        Semester = semester;
        TahunAjaran = tahunAjaran;
        this.matakuliah = matakuliah;
    }

    public int getKelasID() {
        return kelasID;
    }

    public void setKelasID(int kelasID) {
        this.kelasID = kelasID;
    }

    public String getNamaKelas() {
        return NamaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        NamaKelas = namaKelas;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getTahunAjaran() {
        return TahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        TahunAjaran = tahunAjaran;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }
}
