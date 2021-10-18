package com.sigsauer.asker.biz.repositories.shared;

import com.sigsauer.asker.biz.bean.shared.EntityDO;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<T extends EntityDO, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);

    boolean delete(ID id);

}
