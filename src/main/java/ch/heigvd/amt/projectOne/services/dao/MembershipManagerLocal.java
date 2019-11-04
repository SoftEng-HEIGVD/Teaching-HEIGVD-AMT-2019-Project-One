package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Membership;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MembershipManagerLocal {

    public boolean addMembership(Membership membership);

    public List<Membership> getMembershipsByUserId(int id);

    public boolean removeMembership(int id);
}
