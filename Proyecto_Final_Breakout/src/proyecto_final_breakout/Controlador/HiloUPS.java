/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Controlador;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import proyecto_final_breakout.Vista.PanelUPS;

/**
 *
 * @author Asus
 */
public class HiloUPS extends Thread {
    
    private PanelUPS panelInicial;
    private PanamaHitek_Arduino arduino;
    private SerialPortEventListener listener=new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if(arduino.isMessageAvailable()){
                    int l=Integer.parseInt(arduino.printMessage().substring(0, 1));
                    if(l==1){
                        metodoRecorrerDerecha();
                    }else if(l==2){
                        metodoRecorrerIzquierda();
                    }
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public HiloUPS(PanelUPS panelUPS) {
        super("Hilo Barra");
        this.arduino=new PanamaHitek_Arduino();
        try {
            this.arduino.arduinoRXTX("COM4", 9600, listener);
        } catch (ArduinoException ex) {
            Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.panelInicial = panelUPS;
    }

    public PanelUPS getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(PanelUPS panelInicial) {
        this.panelInicial = panelInicial;
    }

    public PanamaHitek_Arduino getArduino() {
        return arduino;
    }

    public void setArduino(PanamaHitek_Arduino arduino) {
        this.arduino = arduino;
    }

    public SerialPortEventListener getListener() {
        return listener;
    }

    public void setListener(SerialPortEventListener listener) {
        this.listener = listener;
    }
    
    public void metodoRecorrerDerecha(){
            try {
                Thread.sleep(30);
                this.panelInicial.repaint();
                if(this.panelInicial.getPosX()<=this.panelInicial.getWidth()-100){
                    this.panelInicial.setPosX(this.panelInicial.getPosX()+25);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void metodoRecorrerIzquierda(){
            try {
                Thread.sleep(2);
                this.panelInicial.repaint();
                if(this.panelInicial.getPosX()>0){
                   this.panelInicial.setPosX(this.panelInicial.getPosX()-40); 
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     public void rebotarPelota(){
        int cont=0,bola=0;
        boolean bandera=true;
        while(bandera==true){
            try {
                if(this.panelInicial.getNumeroBloques()<10){
                 Thread.sleep(5);
                }else if(this.panelInicial.getNumeroBloques()<5){
                  Thread.sleep(3);  
                }else{
                  Thread.sleep(8);    
                }
                
                this.panelInicial.repaint();
                this.panelInicial.setBolaposX(this.panelInicial.getBolaposX()+this.panelInicial.getBoladirX());
                this.panelInicial.setBolaposY(this.panelInicial.getBolaposY()+this.panelInicial.getBoladirY());
                if(new Rectangle(this.panelInicial.getBolaposX(),this.panelInicial.getBolaposY(),20,20).intersects(new Rectangle(this.panelInicial.getPosX(),this.panelInicial.getPosY(),100,10))){
                    this.panelInicial.setBoladirY(-this.panelInicial.getBoladirY());
                }
                
                A:for(int i=0; i<this.panelInicial.getMapaU().getMapa().length;i++){
                    for(int j=0; j<this.panelInicial.getMapaU().getMapa()[0].length;j++){
                        if(this.panelInicial.getMapaU().getMapa()[i][j]>0){
                            int bloqueX=j*this.panelInicial.getMapaU().getBloqueancho()+25;
                            int bloqueY=i*this.panelInicial.getMapaU().getBloquealto()+29;
                            int bloqueancho=this.panelInicial.getMapaU().getBloqueancho();
                            int bloquealto=this.panelInicial.getMapaU().getBloquealto();
                            
                            Rectangle rect=new Rectangle(bloqueX,bloqueY,bloqueancho,bloquealto);
                            Rectangle rect1=new Rectangle(this.panelInicial.getBolaposX(),this.panelInicial.getBolaposY(),20,20);
                            
                            if(rect1.intersects(rect)){
                                this.panelInicial.getMapaU().setBloqueValor(0, i,j);
                                this.panelInicial.setPuntos(++cont);
                                this.panelInicial.setNumeroBloques(this.panelInicial.getNumeroBloques()-1);
                                if(this.panelInicial.getBolaposX()+19<= rect.x || this.panelInicial.getBolaposX()+1 >= rect.x+rect.width){
                                    this.panelInicial.setBoladirX(-this.panelInicial.getBoladirX());
                                }else{
                                    this.panelInicial.setBoladirY(-this.panelInicial.getBoladirY());
                                }
                                break A;
                            }
                        }
                    }
                }
                if(this.panelInicial.getBolaposX()<0){
                    this.panelInicial.setBoladirX(-this.panelInicial.getBoladirX());
                }
                if(this.panelInicial.getBolaposY()<0){
                    this.panelInicial.setBoladirY(-this.panelInicial.getBoladirY());
                }
                if(this.panelInicial.getBolaposX()>this.panelInicial.getWidth()-20){
                    this.panelInicial.setBoladirX(-this.panelInicial.getBoladirX());
                }
                if(this.panelInicial.getNumeroBloques()==0){
                    bandera=false;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void run() {
       super.run();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.rebotarPelota();
    }
    
    
}
