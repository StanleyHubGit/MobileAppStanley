package edu.uph.m23si2.pertamaapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class KRSDetail extends RealmObject {
    @PrimaryKey
    private int detailID;
    private KRS krs;
    private KelasMatakuliah kelasMatakuliah;

    public KRSDetail(){}

    public KRSDetail(int detailID, KRS krs, KelasMatakuliah kelasMatakuliah) {
        this.detailID = detailID;
        this.krs = krs;
        this.kelasMatakuliah = kelasMatakuliah;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public KRS getKrs() {
        return krs;
    }

    public void setKrs(KRS krs) {
        this.krs = krs;
    }

    public KelasMatakuliah getKelasMatakuliah() {
        return kelasMatakuliah;
    }

    public void setKelasMatakuliah(KelasMatakuliah kelasMatakuliah) {
        this.kelasMatakuliah = kelasMatakuliah;
    }
}
