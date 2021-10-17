package com.sigsauer.asker.biz.shared;

import com.sigsauer.asker.biz.shared.bean.EntityDO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public abstract class AbstractEntityRepository<T extends EntityDO, ID> {

    private final Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    private static final EntityManager em = Persistence.createEntityManagerFactory("local").createEntityManager();

    public static EntityManager getEntityManager() {
        return em;
    }

    public List<T> findAll() {
        return em.createQuery("select t from "+ type.getSimpleName() + " t").getResultList();
    }

    public Optional<T> findById(ID id){
        return Optional.ofNullable(em.find(type, id));
    }

    public T save(T entity){
        em.getTransaction().begin();
        if(entity.getId() == null) {
//            entity.setId(UUID.randomUUID());
            em.persist(entity);
        }else {
            em.merge(entity);
        }
        em.getTransaction().commit();
        return entity;
    }

    public void delete(ID id){
        em.getTransaction().begin();
        Optional<T> entity = this.findById(id);
        if(entity.isPresent()) {
            em.remove(entity);
        }
        em.getTransaction().commit();
    }





}
