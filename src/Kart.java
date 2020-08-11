
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mucah
 */
public class Kart implements Serializable{
    
    private char deger;
    private boolean tahmin = false;

    public Kart(char deger){
        this.deger = deger;
    }
    
    public char getDeger() {
        return deger;
    }

    
    public void setDeger(char deger) {
        this.deger = deger;
    }

    
    public boolean isTahmin() {
        return tahmin;
    }

    
    public void setTahmin(boolean tahmin) {
        this.tahmin = tahmin;
    }

    void isTahmin(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
