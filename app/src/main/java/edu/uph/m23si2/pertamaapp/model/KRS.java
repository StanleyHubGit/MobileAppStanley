package edu.uph.m23si2.pertamaapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KRS extends RealmObject {
    @PrimaryKey
    private int krsID;
    private String Semester, TahunAjaran;
    private Mahasiswa mahasiswa;

    public KRS(){}

    public KRS(int krsID, String semester, String tahunAjaran, Mahasiswa mahasiswa) {
        this.krsID = krsID;
        Semester = semester;
        TahunAjaran = tahunAjaran;
        this.mahasiswa = mahasiswa;
    }

    public int getKrsID() {
        return krsID;
    }

    public void setKrsID(int krsID) {
        this.krsID = krsID;
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

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
