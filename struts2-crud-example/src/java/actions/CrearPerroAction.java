/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import daos.perroDao;
import entidades.Perro;
import java.util.ArrayList;

/**
 *
 * @author 1
 */
public class CrearPerroAction extends ActionSupport {
    
    private String nombre;
    private String duenio;
    
    private ArrayList<Perro> perros;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }
    
    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }
 
    @Override
    public String execute() throws Exception {
        perroDao cDAO = new perroDao();
        perroDao perro2 = new perroDao();
  
        Perro perro = new Perro(nombre, duenio);
        int resultado = perro2.crearPerro(perro);
       
        if (resultado == 1) {
            perros = perro2.obtenerPerros();
            return SUCCESS;
        }
        return ERROR;
    }
    
}
