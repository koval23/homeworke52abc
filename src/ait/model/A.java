package ait.model;

import ait.dao.Entity;
import ait.dao.EntityCollection;

import java.util.ArrayList;
import java.util.List;

public class A implements EntityCollection {
    //    TODO +High,-Low (Частое добавление, редкое удаление.)
    private ArrayList<Entity> entities;

    //------------------------------------------------------
    public A() {
        entities = new ArrayList<>();
    }

    public A(Entity entity) {
        this();
        entities.add(entity);
    }

    public A(List<Entity> entities) {
        this();
        this.entities.forEach(entity -> add(entity));
    }
//------------------------------------------------------
// O(n)
    @Override
    public void add(Entity entity) {
        for (Entity e : entities) {
            if (e.getValue() == entity.getValue()) {
                return;
            }
        }
        entities.add(entity);
    }
// O(n)
    @Override
    public Entity removeMaxValue() {
        int max = 0;
        int index = -1;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getValue() > max) {
                max = entities.get(i).getValue();
                index = i;
            }
        }
        if (index < 0) {
            return null;
        }
        Entity res = entities.get(index);
        entities.remove(res);
        return res;
    }
}
