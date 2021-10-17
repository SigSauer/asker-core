package com.sigsauer.asker.biz.services.shared;

import com.sigsauer.asker.biz.shared.bean.EntityDO;

import java.util.List;

public interface AbstractService<T extends EntityDO, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T entity);

    void delete(ID id);

}

