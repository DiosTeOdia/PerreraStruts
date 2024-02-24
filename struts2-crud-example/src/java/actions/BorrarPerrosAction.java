/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import daos.perroDao;
import entidades.Perro;
import java.util.ArrayList;

/**
 *
 * @author 1
 */
public class BorrarPerrosAction extends ActionSupport {
    
    private int perroId;
    private ArrayList<Perro> perros;

    public int getPerroId() {
        return perroId;
    }

    public void setPerroId(int perroId) {
        this.perroId = perroId;
    }
    
    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setClientes(ArrayList<Perro> perros) {
        this.perros = perros;
    }
 
    @Override
    public String execute() throws Exception {
        System.out.println(perroId);
        perroDao perro2 = new perroDao();
        int resultado = perro2.borrarPerro(perroId);
        if (resultado == 1) {
            perros = perro2.obtenerPerros();
            
            return SUCCESS;
        }
        return ERROR;
    }
    
}
