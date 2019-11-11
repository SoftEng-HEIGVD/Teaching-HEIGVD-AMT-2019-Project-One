package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
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

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class UsersDAOTest {

    @EJB
    IUsersDAO usersDao;

  /*
  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class, "test.jar")
      .addPackages(true, "ch.heigvd");
  }
  */

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAUser() throws DuplicateKeyException, SQLException {
        User stephane = User.builder().username("steph" + System.currentTimeMillis()).firstName("Stephane").lastName("Selim")
                .email("selim@email.com").build();
        User stephaneCreated = usersDao.create(stephane);
        assertEquals(stephane, stephaneCreated);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAndRetrieveAUserViaTheUsersDAO() throws DuplicateKeyException, KeyNotFoundException {
        User stephane = User.builder().username("steph" + System.currentTimeMillis()).firstName("Stephane").lastName("Selim")
                .email("selim@email.com").build();
        User stephaneCreated = usersDao.create(stephane);
        User stephaneLoaded = usersDao.findById(stephaneCreated.getUsername());
        assertEquals(stephane, stephaneCreated);
        assertEquals(stephane, stephaneLoaded);
        assertSame(stephane, stephaneCreated);
        assertNotSame(stephane, stephaneLoaded);
    }

    @Test
    public void itShouldBePossibleToDeleteAUser() throws DuplicateKeyException, KeyNotFoundException {
        User stephane = User.builder().username("steph" + System.currentTimeMillis()).firstName("Stephane").lastName("Selim")
                .email("selim@email.com").build();
        User stephaneCreated = usersDao.create(stephane);
        User stephaneLoaded = usersDao.findById(stephaneCreated.getUsername());
        assertEquals(stephane, stephaneCreated);
        usersDao.deleteById(stephaneCreated.getUsername());
        boolean hasThrown = false;
        try {
            stephaneLoaded = usersDao.findById(stephaneCreated.getUsername());
        } catch (KeyNotFoundException e) {
            hasThrown = true;
        }
        assertTrue(hasThrown);
    }

    @Test
    public void itShouldBePossibleToUpdateAUser() throws DuplicateKeyException, KeyNotFoundException {
        User stephane = User.builder().username("steph" + System.currentTimeMillis()).firstName("Stephane").lastName("Selim")
                .email("selim@email.com").build();
        User stephaneCreated = usersDao.create(stephane);
        User stephaneModified = stephane.toBuilder().firstName("john").lastName("doe").build();
        usersDao.update(stephaneModified);
        User olivierModifiedInDB = usersDao.findById(stephane.getUsername());
        assertEquals(stephaneModified, olivierModifiedInDB);
        assertNotEquals(stephaneCreated, olivierModifiedInDB);

    }
}