package com.sigsauer.asker.biz.bean.shared;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class EntityDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    public EntityDO() {}

    public EntityDO(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getID() {
        return this.id.toString();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setID(String id) {
        this.id = id == null || id.isEmpty() ? null : UUID.fromString(id);
    }

    @Override
    public String toString() {
        return "EntityDO{" +
                "id=" + id +
                '}';
    }
}
