/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proyecto_final_breakout.Modelo.Persona;

/**
 *
 * @author Asus
 */
public class GestionDato {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Final_BreakoutPU");
    
    public boolean persistirPersona(Persona p)
    {
        boolean retorno=false;
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        retorno=true;
        return retorno;
    }
    
     public List<Persona> leerPersona() {
        List<Persona> retorno=null;        
        EntityManager em = this.emf.createEntityManager();
        retorno=em.createQuery("SELECT p FROM Persona p ORDER BY p.id").getResultList();        
        em.close();
        return retorno;
    }
}
