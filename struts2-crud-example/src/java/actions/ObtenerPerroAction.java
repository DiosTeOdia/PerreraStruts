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
public class ObtenerPerroAction extends ActionSupport {

    private int perroId;
    private Perro perro;

    public int getPerroId() {
        return perroId;
    }

    public void setPerroId(int clienteId) {
        this.perroId = clienteId;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }
    
    @Override
    public String execute() throws Exception {
        perroDao perro2 = new perroDao();
        perro = perro2.obtenerPerro(perroId);
        
        return SUCCESS;
    }

}
