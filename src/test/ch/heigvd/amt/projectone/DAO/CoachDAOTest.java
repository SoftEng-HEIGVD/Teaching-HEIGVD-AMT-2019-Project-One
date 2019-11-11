package ch.heigvd.amt.projectone.DAO;

import ch.heigvd.amt.projectone.model.Coach;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.websocket.DeploymentException;
import java.sql.SQLException;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class CoachDAOTest {

    @EJB
    ICoachDAO coachD;

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateACoach() throws DuplicateKeyException, SQLException, DeploymentException {
        Coach nair = Coach.builder()
                .username("nairA")
                .lastName("Alic")
                .firstName("Nair")
                .password("test")
                .isAdmin(true)
                .build();
        coachD.create(nair);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAndRetrieveACoach() throws DuplicateKeyException, SQLException, DeploymentException {
        Coach nair = Coach.builder()
                .username("nairA")
                .lastName("Alic")
                .firstName("Nair")
                .password("test")
                .isAdmin(true)
                .build();
        Coach nairCreated = coachD.create(nair);

        Coach nairAdded = coachD.findById(nairCreated.getUsername());
        assertEquals(nair, nairCreated);
        assertEquals(nair, nairAdded);
        assertSame(nair, nairCreated);
        assertNotSame(nair, nairAdded);
    }

//    @Test
//    public void deleteById() {
//    }
}