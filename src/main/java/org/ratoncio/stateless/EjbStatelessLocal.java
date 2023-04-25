package org.ratoncio.stateless;

import javax.ejb.Local;

@Local
public interface EjbStatelessLocal {
    public void increment(int num);

    public int result();

}