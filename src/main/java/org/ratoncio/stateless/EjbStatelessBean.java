package org.ratoncio.stateless;

import javax.ejb.Stateless;

@Stateless //(mappedName="EjbStatelessBean", name = "EjbStatelessBean")
public class EjbStatelessBean implements  EjbStatelessLocal {

	private int cont;
	
    public EjbStatelessBean() {
    	super();
    	cont = 0;
    }
    
    @Override
    public void increment(int num) {
    	cont = cont + num;
    }

    @Override
    public int result() {
    	return cont;
    }
}
