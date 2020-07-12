package dk.bec.dataaccess.rest;

import dk.bec.dataaccess.entity.Owner;
import dk.bec.dataaccess.service.DaoOwnerService;
import dk.bec.dataaccess.service.RepositoryOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    @Autowired
    RepositoryOwnerService repositoryOwnerService;

    @Autowired
    DaoOwnerService daoOwnerService;

    @PutMapping("/createOwners")
    public void createOwners() {
        daoOwnerService.createOwners();
    }

    @PutMapping("/lifecycle")
    public void lifecycle() {
        daoOwnerService.lifecycle();
    }

    @GetMapping(value = "/dao/owners", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwnersDAO() {
        List<Owner> owners = daoOwnerService.getOwners();
        return owners;
    }

    @GetMapping(value = "/dao/owners/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Owner getOwnerByIdDAO(@PathVariable("id") int id) {
        Optional<Owner> owner = daoOwnerService.getOwner(id);
        return owner.get();
    }

    @GetMapping(value = "/dao/owners/lastName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwnersByLastNameDAO(@PathVariable("name") String lastName) {
        List<Owner> owners = daoOwnerService.getOwnersByLastName(lastName);
        return owners;
    }

    @GetMapping(value = "/repository/owners", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwnersRepository() {
        List<Owner> owners = repositoryOwnerService.getOwners();
        return owners;
    }

    @GetMapping(value = "/repository/owners/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Owner getOwnerByIdRepository(@PathVariable("id") int id) {
        Optional<Owner> owner = repositoryOwnerService.getOwner(id);
        return owner.get();
    }

    @GetMapping(value = "/repository/owners/fullName", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwners(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        List<Owner> owners = repositoryOwnerService.getOwnersByFirstNameAndLastName(firstName, lastName);
        return owners;
    }

    @GetMapping(value = "/repository/owners/notLastName", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwners(@RequestParam("lastName") String lastName) {
        List<Owner> owners = repositoryOwnerService.getOwnersWithLastNameOtherThan(lastName);
        return owners;
    }

    @GetMapping(value = "/repository/owners/lastNameLongerThan/{length}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwners(@PathVariable("length") Integer length) {
        List<Owner> owners = repositoryOwnerService.findNamesLongerThan(length);
        return owners;
    }

}
