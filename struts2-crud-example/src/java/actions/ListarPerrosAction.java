/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import daos.perroDao;
import entidades.Perro;
import java.util.ArrayList;
/**
 *
 * @author 1
 */
public class ListarPerrosAction extends ActionSupport {

    private ArrayList<Perro> perros;

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setClientes(ArrayList<Perro> perros) {
        this.perros = perros;
    }
 
    @Override
    public String execute() throws Exception {
        perroDao perro2 = new perroDao();
        perros = perro2.obtenerPerros();
     
        return SUCCESS;
    }

}
