package com.sigsauer.asker.biz.shared;

import com.sigsauer.asker.biz.shared.bean.EntityDO;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<T extends EntityDO, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);

    void delete(ID id);

}
