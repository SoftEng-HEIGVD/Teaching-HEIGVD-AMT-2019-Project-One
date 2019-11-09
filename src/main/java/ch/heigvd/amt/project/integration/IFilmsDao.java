package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.model.Film;

import javax.ejb.Local;

@Local
public interface IFilmsDao extends IDAO<String, Film> {

}
