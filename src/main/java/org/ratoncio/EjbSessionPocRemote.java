package org.ratoncio;

import javax.ejb.Remote;

@Remote
public interface EjbSessionPocRemote {
	public void increment(int num);
	
	public int result();
}
