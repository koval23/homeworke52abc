package ait.model;

import ait.dao.Entity;
import ait.dao.EntityCollection;

import java.util.*;

public class C implements EntityCollection {
    //    TODO -High,+Low (Редкое добавление, частое удаление.)
    private LinkedList<Entity> entities;

    Comparator<Entity> comparatorByValue = (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue());


    //------------------------------------------------------
    public C() {
        entities = new LinkedList<>();
    }

    public C(Entity entity) {
        this();
        entities.add(entity);
    }

    public C(Entity[] entities) {
        this();
        this.entities.forEach(entity -> add(entity));
    }
//------------------------------------------------------

    //O(n)
    @Override
    public void add(Entity entity) {
        if (entity == null) return;
        for (Entity e : entities) {
            if (e.getValue() == entity.getValue()) {
                return;
            }
        }
        int index = Collections.binarySearch(entities, entity, comparatorByValue);
        if (index >= 0) {
            return;
        }
        index = -index - 1;
        entities.add(index, entity);
    }

    // O(1)
    @Override
    public Entity removeMaxValue() {
        return entities.removeLast();
    }
}
