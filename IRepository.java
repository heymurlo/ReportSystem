package com.company.DAL;

import java.util.List;


public class IRepository<IEntity> {
    protected List<IEntity> Entities;

    public List<IEntity> GetEntities() {
        return Entities;
    }

    public void Create(IEntity obj) {
        Entities.add(obj);
    }

    IEntity Get(int id) {
        return Entities.get(id);
    }

}
