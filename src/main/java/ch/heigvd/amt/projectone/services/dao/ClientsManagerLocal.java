package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.Client;

public interface ClientsManagerLocal extends IDAO<Client>{


    int getIdByUsername(String username);
    Client getClientById(int id);
}
