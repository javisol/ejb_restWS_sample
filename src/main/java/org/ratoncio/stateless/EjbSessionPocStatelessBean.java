package org.ratoncio.stateless;

import javax.ejb.Stateless;

@Stateless(mappedName="EjbBeanStateless", name = "EjbBeanStateless")
public class EjbSessionPocStatelessBean implements  EjbSessionPocStatelessLocal {

	private int cont;
	
    public EjbSessionPocStatelessBean() {
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
