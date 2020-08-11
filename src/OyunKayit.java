
import static java.io.FileDescriptor.out;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mucah
 */
public class OyunKayit {
    public static void oyunKaydet(Kart [][] kartlar){
        
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayit.bin"))){
            System.out.println("Oyun kaydediliyor...");
            
            out.writeObject(kartlar);
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public static Kart[][] kayittanAl(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayit.bin"))){
            Kart[][] cikti = (Kart[][]) in.readObject();
            
            return cikti;
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
