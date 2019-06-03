package com.lab.sdt.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
public class Registro_Vista implements Serializable{
	 private RegistroUsuario RegistroUsuario = new RegistroUsuario();
	 private boolean skip;
	 
	public RegistroUsuario getRegistroUsuario() {
		return RegistroUsuario;
	}
	public void setRegistroUsuario(RegistroUsuario registroUsuario) {
		RegistroUsuario = registroUsuario;
	}
	public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + RegistroUsuario.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}
