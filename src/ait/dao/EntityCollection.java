package ait.dao;

public interface EntityCollection {
    public void add(Entity entity);

    public Entity removeMaxValue();
}
