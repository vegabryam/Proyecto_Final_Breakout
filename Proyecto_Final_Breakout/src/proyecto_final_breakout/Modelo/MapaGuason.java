/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Asus
 */
public class MapaGuason {
    private int mapa[][];
    private int bloqueancho;
    private int bloquealto;
    private int[][] arreglo;

    public MapaGuason(int fila, int columna) {
        this.arreglo=new int[fila][columna];
        this.mapa=new int[fila][columna];
        
        for(int i=0; i<this.arreglo.length;i++){
            for(int j=0; j<this.arreglo[i].length;j++){
                this.arreglo[i][j]=1;
            }
        }
        
        for(int i=0; i<this.mapa.length;i++){
            for(int j=0; j<this.mapa[i].length;j++){
                if(i==0 && (j==2 || j==3 || j==4)){
                    this.mapa[i][j]=2;
                }
                if((i==1||i==2) &&(j==1 || j==2 || j==3 || j==4 || j==5)){
                    this.mapa[i][j]=2;
                }
                if((i==3) &&(j==0 || j==1 || j==5 || j==6)){
                    this.mapa[i][j]=2;
                }else if(i==3 && (j==2 || j==3 || j==4)){
                    this.mapa[i][j]=3;
                }
                if((i==4||i==5) &&(j==0||j==6)){
                    this.mapa[i][j]=2;
                }else if((i==4||i==5) &&(j==2 || j==3 || j==4 || j==1 || j==5)){
                    this.mapa[i][j]=3;
                }
                if((i==6||i==7) &&(j==0||j==6)){
                    this.mapa[i][j]=2;
                }else if((i==6||i==7) &&(j==3|| j==1 || j==5)){
                    this.mapa[i][j]=3;
                }else if((i==6||i==7) &&(j==2 || j==4)){
                    this.mapa[i][j]=4;
                }
                if(i==8&&(j==2 || j==3 || j==4 || j==1 || j==5)){
                    this.mapa[i][j]=3;
                }
                if(i==9 &&(j==1 || j==5)){
                    this.mapa[i][j]=5;
                }else if(i==9 &&(j==2 || j==3 || j==4)){
                    this.mapa[i][j]=3;
                }
                if(i==10 &&(j==1 || j==5)){
                    this.mapa[i][j]=5;
                }else if(i==10 &&(j==2 || j==3 || j==4)){
                    this.mapa[i][j]=4;
                }
                if(i==11 &&(j==2|| j==3 || j==4)){
                    this.mapa[i][j]=3;
                }
                if((i==12 || i==13) &&(j==2 ||j==4 || j==1 || j==5)){
                    this.mapa[i][j]=6;
                }else if((i==12 || i==13) && j==3){
                    this.mapa[i][j]=2;
                }
            }
        }
        
        this.bloqueancho=40;
        this.bloquealto=20;
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }

    public int getBloqueancho() {
        return bloqueancho;
    }

    public void setBloqueancho(int bloqueancho) {
        this.bloqueancho = bloqueancho;
    }

    public int getBloquealto() {
        return bloquealto;
    }

    public void setBloquealto(int bloquealto) {
        this.bloquealto = bloquealto;
    }
    
    public boolean setBloqueValor(int valor,int fila,int columna){
          
        if(this.arreglo[fila][columna]==valor){
          this.mapa[fila][columna]=0;
          return true;
        }else{
          this.arreglo[fila][columna]=this.arreglo[fila][columna]+1;
          return false;
        }
          
        
    }
    
    
    
    public void dibujar(Graphics2D g){
        
        for(int i=0; i<this.mapa.length;i++){
            for(int j=0; j<this.mapa[0].length;j++){
                if(this.mapa[i][j]==2){
                    if(arreglo[i][j]==1){
                       g.setColor(new Color(124,252,0,200));  
                    }else if(arreglo[i][j]==2){
                      g.setColor(new Color(124,252,0,100));  
                    }else if(arreglo[i][j]==3){
                        g.setColor(new Color(124,252,0,50));
                    }
                    
                    g.fillRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                }else if(this.mapa[i][j]==3){
                    if(arreglo[i][j]==1){
                       g.setColor(new Color(255,255,255,200));  
                    }else if(arreglo[i][j]==2){
                      g.setColor(new Color(255,255,255,100));  
                    }else if(arreglo[i][j]==3){
                      g.setColor(new Color(255,255,255,50));
                    }
                    
                    g.fillRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                }else if(this.mapa[i][j]==4){
                    if(arreglo[i][j]==1){
                       g.setColor(new Color(0,0,0,200));  
                    }else if(arreglo[i][j]==2){
                      g.setColor(new Color(0,0,0,100));  
                    }else if(arreglo[i][j]==3){
                      g.setColor(new Color(0,0,0,50));
                    }
                    
                    g.fillRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                }else if(this.mapa[i][j]==5){
                    if(arreglo[i][j]==1){
                       g.setColor(new Color(205,0,0,200));  
                    }else if(arreglo[i][j]==2){
                      g.setColor(new Color(205,0,0,100));  
                    }else if(arreglo[i][j]==3){
                      g.setColor(new Color(205,0,0,50));  
                    }
                    
                    g.fillRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                }else if(this.mapa[i][j]==6){
                    
                    if(arreglo[i][j]==1){
                       g.setColor(new Color(154,50,205,200)); 
                    }else if(arreglo[i][j]==2){
                      g.setColor(new Color(154,50,205,100));  
                    }else if(arreglo[i][j]==3){
                      g.setColor(new Color(154,50,205,50));
                    }
                    
                    
                    g.fillRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+100,i*this.bloquealto+20,this.bloqueancho,this.bloquealto);
                }
            }
        }
    }
}
