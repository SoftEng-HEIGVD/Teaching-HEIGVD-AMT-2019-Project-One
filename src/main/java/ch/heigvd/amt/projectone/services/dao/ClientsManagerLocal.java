package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.model.Client;

public interface ClientsManagerLocal {

    public boolean create(String username, String password);
    public boolean validConnection(String username, String password);
    public Client findClientByUsername(String username);
}
