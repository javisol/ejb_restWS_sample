package org.ratoncio.stateless;

import javax.ejb.Local;

@Local
public interface EjbSessionPocStatelessLocal {
    public void increment(int num);

    public int result();
    
}