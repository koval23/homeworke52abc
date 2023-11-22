package ait.model;

import ait.dao.Entity;
import ait.dao.EntityCollection;

import java.util.*;

public class A implements EntityCollection {
    //    TODO +High,-Low (Частое добавление, редкое удаление.)
    private TreeSet<Entity> entities;
    Comparator<Entity> comparatorByValue = (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue());

    //------------------------------------------------------
    public A() {
        entities = new TreeSet<>(comparatorByValue);
    }

    public A(Entity entity) {
        this();
        entities.add(entity);
    }

    public A(Entity[] entities) {
        this();
        this.entities.forEach(entity -> add(entity));
    }
//------------------------------------------------------

    //O(n)
    @Override
    public void add(Entity entity) {
        if (entity == null) return;
        entities.add(entity);
    }

    @Override
    public Entity removeMaxValue() {
        if (entities.isEmpty()) return null;
        Entity maxEntity = entities.pollLast();
        return maxEntity;
    }
}
