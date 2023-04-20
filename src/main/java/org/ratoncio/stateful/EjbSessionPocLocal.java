package org.ratoncio.stateful;

import javax.ejb.Local;

@Local
public interface EjbSessionPocLocal {
    public void increment(int num);

    public int result();
    
}