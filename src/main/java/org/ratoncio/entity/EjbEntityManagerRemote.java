package org.ratoncio.entity;

import javax.ejb.Remote;

@Remote
public interface EjbEntityManagerRemote {

	public EjbEntityBean getPetById(int id);
	
	public EjbEntityBean getPetByName(String name);
	
	public void addPet(EjbEntityBean pet);

	public void updatePet(EjbEntityBean pet);
	
	public void deletePet(EjbEntityBean pet);

}
