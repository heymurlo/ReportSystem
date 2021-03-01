package com.company.DAL;

import java.util.LinkedList;
import java.util.List;


public class IRepository<IEntity> {
    protected List<IEntity> Entities = new LinkedList<>();

    public List<IEntity> GetEntities() {
        return Entities;
    }

    public void Create(IEntity obj, int id) {
        Entities.add(id, obj);
        //System.out.println("Entity with id: " + id + "created");
    }

    public IEntity Get(int id) {
        return Entities.get(id);
    }

}
