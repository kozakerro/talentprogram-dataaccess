package dk.bec.dataaccess.service;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RepositoryOwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Transactional
    public List<Owner> getOwners() {
        System.out.println("Returning all owners");
        Iterable<Owner> owners = ownerRepository.findAll();
        return StreamSupport.stream(owners.spliterator(), false).collect(Collectors.toList());
    }

    @Transactional
    public Optional<Owner> getOwner(int id) {
        System.out.println("Returning owner with id: " + id);
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner;
    }

    @Transactional
    public List<Owner> getOwnersByFirstNameAndLastName(String firstName, String lastName) {
        System.out.println("Returning owners with first name like: " + firstName + " and last name like: " + lastName);
        List<Owner> owners = ownerRepository.findByFirstNameAndLastName(firstName, lastName);
        return owners;
    }

    @Transactional
    public List<Owner> getOwnersWithLastNameOtherThan(String lastName) {
        System.out.println("Returning owners with last name other than: " + lastName);
        List<Owner> owners = ownerRepository.findByLastNameNotLike(lastName);
        return owners;
    }

    @Transactional
    public List<Owner> findNamesLongerThan(int length) {
        System.out.println("Returning owners with last longer than: " + length);
        List<Owner> owners = ownerRepository.findNamesLongerThan(length);
        return owners;
    }

}
