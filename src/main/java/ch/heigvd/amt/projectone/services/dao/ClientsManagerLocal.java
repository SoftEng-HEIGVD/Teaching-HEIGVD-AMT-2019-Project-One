package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.model.Client;

public interface ClientsManagerLocal {

    boolean create(String username, String password);
    boolean validConnection(String username, String password);
    Client findClientByUsername(String username);
    int getIdByUsername(String username);
    Client getClientById(int id);

}
