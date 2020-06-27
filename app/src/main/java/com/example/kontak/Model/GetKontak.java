package com.example.kontak.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetKontak {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    String result;
    List<Kontak> listDataKontak;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getResult() {
        return result;
    }

    public List<Kontak> getListDataKontak() {
        return listDataKontak;
    }

    public void setListDataKontak(List<Kontak> listDataKontak) {
        this.listDataKontak = listDataKontak;
    }

}
