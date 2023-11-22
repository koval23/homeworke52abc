package ait.model;

import ait.dao.Entity;
import ait.dao.EntityCollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class B implements EntityCollection {
    //    TODO +High,+Low (Средняя частота добавления и удаления.)
    private TreeSet<Entity> entities;

    Comparator<Entity> comparatorByValue = (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue());

    //------------------------------------------------------
    public B() {
        entities = new TreeSet<>(comparatorByValue);
    }

    public B(Entity entity) {
        this();
        entities.add(entity);
    }

    public B(TreeSet<Entity> entities) {
        this();
        this.entities.forEach(entity -> add(entity));
    }

    //    ------------------------------------------------------

//  O(log n)
    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    //O(log n)
    @Override
    public Entity removeMaxValue() {
        if (entities.isEmpty()) return null;
        Entity maxEntity = entities.pollLast();
        return maxEntity;
    }
}
