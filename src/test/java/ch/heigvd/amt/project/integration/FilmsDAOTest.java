package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;
import ch.heigvd.amt.project.model.User;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.sql.SQLException;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class FilmsDAOTest {

    private final static Random random = new Random();

    @EJB
    IFilmsDao filmsDao;

  /*
  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class, "test.jar")
      .addPackages(true, "ch.heigvd");
  }
  */

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAFilm() throws DuplicateKeyException, SQLException {
        Film film = Film.builder().id(constructId()).title("movie")
                .moviePosterPath("path.jpg").director("Fring").runningTime(200).build();
        Film filmCreated = filmsDao.createAndSpecifyId(film);
        assertEquals(filmCreated, film);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAndRetrieveAFilmViaTheFilmsDAO() throws DuplicateKeyException, KeyNotFoundException {
        Film film = Film.builder().id(constructId()).title("movie")
                .moviePosterPath("path.jpg").director("Fring").runningTime(200).build();
        Film filmCreated = filmsDao.createAndSpecifyId(film);
        Film filmFetched = filmsDao.findById(film.getId());
        assertEquals(filmCreated, film);
        assertEquals(film, filmFetched);
        assertSame(film, filmCreated);
        assertNotSame(film, filmFetched);
    }

    @Test
    public void itShouldBePossibleToDeleteAFilm() throws DuplicateKeyException, KeyNotFoundException {
        Film film = Film.builder().id(constructId()).title("movie")
                .moviePosterPath("path.jpg").director("Fring").runningTime(200).build();
        Film filmCreated = filmsDao.createAndSpecifyId(film);
        Film filmFetched = filmsDao.findById(film.getId());
        assertEquals(film, filmCreated);
        assertEquals(film, filmFetched);
        filmsDao.deleteById(filmCreated.getId());
        boolean hasThrown = false;
        try {
            filmFetched = filmsDao.findById(filmCreated.getId());
        } catch (KeyNotFoundException e) {
            hasThrown = true;
        }
        assertTrue(hasThrown);
    }

    @Test
    public void itShouldBePossibleToUpdateAFilm() throws DuplicateKeyException, KeyNotFoundException {
        Film film = Film.builder().id(constructId()).title("movie")
                .moviePosterPath("path.jpg").director("Fring").runningTime(200).build();
        Film filmCreated = filmsDao.createAndSpecifyId(film);
        Film filmModified = film.toBuilder().title("scarymovie").runningTime(50).build();
        filmsDao.update(filmModified);
        Film filmModifiedInDB = filmsDao.findById(film.getId());
        assertEquals(filmModified, filmModifiedInDB);
        assertNotEquals(filmCreated, filmModifiedInDB);

    }

    /**
     * Construct long ids for testing purposes
     * @return random long ids for films created
     */
    private long constructId() {
        return Long.parseLong(String.valueOf(random.nextLong()).substring(0, 7));
    }
}