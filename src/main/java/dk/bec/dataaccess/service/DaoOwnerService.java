package dk.bec.dataaccess.service;

import dk.bec.dataaccess.dao.OwnerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DaoOwnerService {

    @Autowired
    OwnerDAO ownerDAO;



    // additional methods
    @Transactional
    public void createOwners() {
        ownerDAO.createOwners();
    }

    @Transactional
    public void lifecycle() {
        ownerDAO.lifecycle();
    }

}
