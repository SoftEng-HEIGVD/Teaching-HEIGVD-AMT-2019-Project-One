package ch.heig.amt.project.one.business.interfaces;

import ch.heig.amt.project.one.model.Entity;

import java.util.ArrayList;

public interface IDAO {
    boolean create(Entity e);
    ArrayList<Entity> findAll();
    Entity findById(int id);
    boolean update(Entity e);
    boolean delete(Entity e);
}
