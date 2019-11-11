package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.model.Client;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;


@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class ClientsManagerTest {

    /*
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ClientsManager.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "arquillian.xml");
    }
    */

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToCreateAClient() throws DuplicateKeyException {
        Client olivier = Client.builder().name("Olivier").username("oliechti_" + System.currentTimeMillis()).password("xxxxx").build();
        clientsManagerLocal.create(olivier);
    }
}
