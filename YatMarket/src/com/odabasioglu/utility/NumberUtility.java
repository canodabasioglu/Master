package com.odabasioglu.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberUtility{

      public static final String[] birler={"","bir","iki","uc","dort","bes","alti","yedi","sekiz","dokuz"};
      public static final String[] onlar={"","on","yirmi","otuz","kirk","elli","atmis","yetmis","seksen","doksan"};
      public static final String[] basamaklar={"","bin","milyon","milyar","trilyon","katrilyon"};

      public static int rakamBul(int i,int sayi){ //sayinin i basamagindaki rakamini bulur
            if(i<=0) return 0;
            else return ((int)(sayi%Math.pow(10,i))/(int)(Math.pow(10,i-1)));
      }
 

      public static int[] sayiAyir(long sayi_){ //sayiyi ucer ucer ayirir
            String sayi=""+sayi_;
            int uzunluk=sayi.length();
            int[] sayilar=new int[uzunluk/3+((uzunluk%3==0)?0:1)];
            sayi="000"+sayi;
            int i=0;
            try{
                  while(i<uzunluk/3+((uzunluk%3==0)?0:1)){
                        sayilar[i]=Integer.parseInt(sayi.substring(sayi.length()-3));
                        sayi=sayi.substring(0,sayi.length()-3);
                        i++;
                  }
            }catch(StringIndexOutOfBoundsException e){
                  sayilar[i]=Integer.parseInt(sayi);
            }

            return sayilar;
      }
 

      public static String yuzlukCevir(int sayi){  //uc basamakli sayiyi cevirir
            if(sayi/1000>0) return "hatali sayi !";
            else if(sayi==0) return "sifir";
            else{
                  String sayininBirleri=birler[rakamBul(1,sayi)];
                  String sayininOnlari=onlar[rakamBul(2,sayi)];
                  String sayininYuzleri;
                  if(rakamBul(3,sayi)==0) sayininYuzleri="";
                  else if(rakamBul(3,sayi)==1) sayininYuzleri="yuz";
                  else sayininYuzleri=birler[rakamBul(3,sayi)]+"yuz";
                  return sayininYuzleri+sayininOnlari+sayininBirleri;
            }
      }
 

      public static String sayiCevir(long sayi){ //1 kentrilyondan ku�uk sayiyi cevirir.
            if(sayi==0) return "sifir";
            String sonuc="";
            String eksi="";
            if(sayi<0) { eksi="eksi ";  sayi=-sayi;  }
            int[] bolumler=sayiAyir(sayi);
            if(bolumler.length>6) return "Cok buyuk sayi";
            else{
                  for(int i=0;i<bolumler.length;i++){
                        if(i==0) {
                              if(bolumler[i]!=0) sonuc=sonuc+yuzlukCevir(bolumler[i]);
                        }
                        else if(i==1){
                              if(bolumler[i]==1) sonuc=basamaklar[i]+" "+sonuc;
                              else if(bolumler[i]!=0) sonuc=yuzlukCevir(bolumler[i])+basamaklar[i]+" "+sonuc;
                        }
                        else{
                              if(bolumler[i]!=0) sonuc=yuzlukCevir(bolumler[i])+basamaklar[i]+" "+sonuc;
                        }

                  }
                  return eksi+sonuc;
            }

      }
 

      public static void main (String args []) throws IOException {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(isr);

            String sayi=in.readLine();
            long longSayi=0;
            try{
                  longSayi=Long.parseLong(sayi);
            }catch(NumberFormatException e){
                 
                  System.exit(0);
            }

            System.err.println(" "+sayi+" sayisinin yaziyla degeri : "+sayiCevir(longSayi));
       }
} // class definition'in sonu

 
