package org.ratoncio;

//import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class EjbSessionPoc
 */
@Stateful
//@LocalBean
public class EjbSessionPocBean implements EjbSessionPocRemote, EjbSessionPocLocal {

	private int cont;
	
    public EjbSessionPocBean() {
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
