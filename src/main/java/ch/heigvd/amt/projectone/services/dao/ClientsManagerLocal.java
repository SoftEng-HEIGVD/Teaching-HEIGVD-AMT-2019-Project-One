package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.model.Client;

public interface ClientsManagerLocal {

    boolean create(String name, String username, String password, String password_confirm);
    boolean validConnection(String username, String password);
    Client findClientByUsername(String username);
    int getIdByUsername(String username);
    Client getClientById(int id);

}
