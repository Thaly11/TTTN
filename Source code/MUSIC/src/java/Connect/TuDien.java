/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

/**
 *
 * @author DELL
 */
public class TuDien {
    private String tu;
    private float trongSo;
    private int tuHatGiong;

    public TuDien(String tu, float trongSo, int tuHatGiong) {
        this.tu = tu;
        this.trongSo = trongSo;
        this.tuHatGiong = tuHatGiong;
    }
    
    public void setTu(String tu) {
        this.tu = tu;
    }

    public void setTrongSo(int trongSo) {
        this.trongSo = trongSo;
    }

    public void setTuHatGiong(int tuHatGiong) {
        this.tuHatGiong = tuHatGiong;
    }

    public String getTu() {
        return tu;
    }

    public float getTrongSo() {
        return trongSo;
    }

    public int getTuHatGiong() {
        return tuHatGiong;
    }
    
    
}
