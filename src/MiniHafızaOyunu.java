/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.Scanner;

/**
 *
 * @author mucah
 */

public class MiniHafızaOyunu {
    public static void kayittanAl(){
    File file = new File("kayit.bin");
    Scanner scanner = new Scanner(System.in);

    if(file.exists()){
        System.out.println("Kaydedilmiş bir oyununuz var. Kayıttan devam etmek ister misiniz? (yes/no) ");
        String cevap = scanner.nextLine();
        
        if(cevap.equals("yes")){
            kartlar = OyunKayit.kayittanAl();
            return;
        }
    }
    
        kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        kartlar[0][2] = new Kart('B');
        kartlar[0][3] = new Kart('F');
        kartlar[1][0] = new Kart('G');
        kartlar[1][1] = new Kart('A');
        kartlar[1][2] = new Kart('D');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('F');
        kartlar[2][1] = new Kart('C');
        kartlar[2][2] = new Kart('D');
        kartlar[2][3] = new Kart('H');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('G');
        kartlar[3][2] = new Kart('B');
        kartlar[3][3] = new Kart('C');
}
    
    private static Kart[][] kartlar = new Kart[4][4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        
        kayittanAl();
        //System.out.println("Çıkış için q ya basınız..");
        
        while(oyunBittiMi() == false){
            
            oyunTahtasi();
            tahminEt();
            System.out.print("Çıkış için q ya basınız., devam etmek için herhangi bir tuşa basınız: ");
            String cikis = scanner.nextLine();
            
            if(cikis.equals("q")){
                System.out.println("Oyunu kaydetmek istiyor musunuz? (yes or no)");
                String kayit = scanner.nextLine();
                
                if(kayit.equals("yes")){
                    OyunKayit.oyunKaydet(kartlar);
                }
                else{
                    System.out.println("Oyun kaydedilmedi.");
                }
                System.out.println("Programdan çıkılıyor..");
                break;
            }
            //tahminEt();
        
        }
        
         
    }
    public static void tahminEt(){
        Scanner scanner = new Scanner(System.in);
            
            System.out.println("Birinci tahmini bir boşluklu olarak i ve j değerlerini giriniz..: ");
            int i1 = scanner.nextInt();
            int j1 = scanner.nextInt();
            
            kartlar[i1][j1].setTahmin(true);
            oyunTahtasi();
            
            System.out.println("İkinci tahmini bir boşluklu olarak i ve j değerlerini giriniz..: ");
            int i2 = scanner.nextInt();
            int j2 = scanner.nextInt();
            kartlar[i2][j2].setTahmin(true);
            oyunTahtasi();
            kartlar[i2][j2].setTahmin(false);
            
            if(kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()){
            
                kartlar[i2][j2].setTahmin(true);
                
            }
            else{
            
                kartlar[i1][j1].setTahmin(false);
            
            }
        
    
    }
    
    public static boolean oyunBittiMi(){
    
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
            
                if(kartlar[i][j].isTahmin() == false){
                    return false;
                }
                
            }
        }
        System.out.println("\n\nTebrikler kazandınız!");
        return true;
    
    
    
    
    }
    public static void oyunTahtasi(){
        
        for(int i = 0; i < 4; i++){
            System.out.println("_____________________");
            for(int j = 0; j < 4; j++){
                
                if(kartlar[i][j].isTahmin()){
                    System.out.print(" |" + kartlar[i][j].getDeger() + "| ");
                }
                else{
                    System.out.print(" | | ");
                }
                
            }
            System.out.println();
        
        }
        System.out.println("_____________________");
    
    }
    
}
