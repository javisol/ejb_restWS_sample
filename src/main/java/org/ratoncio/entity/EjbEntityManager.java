package org.ratoncio.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EjbEntityManager {
    @PersistenceContext(unitName = "ejb-entity")
    private EntityManager entityManager;

    public void addPet(EjbEntityBean pet){
        entityManager.persist(pet);
    }

    public EjbEntityBean getPetById(int id){
        return entityManager.find(EjbEntityBean.class, id);
    }
    
    public EjbEntityBean getPetByName(String name){
        return entityManager.find(EjbEntityBean.class, name);
    }

    public void updatePet(EjbEntityBean pet){
        entityManager.merge(pet);
    }

    public void deletePet(EjbEntityBean pet){
        entityManager.remove(entityManager.contains(pet) ? pet : entityManager.merge(pet));
    }

}
