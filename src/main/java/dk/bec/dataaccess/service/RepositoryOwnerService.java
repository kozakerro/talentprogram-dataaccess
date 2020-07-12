package dk.bec.dataaccess.service;

import dk.bec.dataaccess.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryOwnerService {

    @Autowired
    OwnerRepository ownerRepository;



}
