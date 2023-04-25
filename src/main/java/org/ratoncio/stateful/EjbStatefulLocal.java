package org.ratoncio.stateful;

import javax.ejb.Local;

@Local
public interface EjbStatefulLocal {
    public void increment(int num);

    public int result();
    
}