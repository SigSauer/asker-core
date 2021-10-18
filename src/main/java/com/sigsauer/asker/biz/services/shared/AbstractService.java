package com.sigsauer.asker.biz.services.shared;

import com.sigsauer.asker.biz.bean.shared.EntityDO;
import com.sigsauer.asker.biz.exceptions.shared.EntityConflictException;
import com.sigsauer.asker.biz.exceptions.shared.EntityNotFoundException;

import java.util.List;

public interface AbstractService<T extends EntityDO, ID> {

    List<T> findAll();

    T findById(ID id) throws EntityNotFoundException;

    T save(T entity) throws EntityConflictException;

    T update(ID id, T entity) throws EntityConflictException;

    void delete(ID id) throws EntityNotFoundException;

}

