package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);



        Owner owner1 = new Owner();
        owner1.setFirstName("Valentina");
        owner1.setLastName("Amadio");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Martino");
        owner2.setLastName("Albanese");
        ownerService.save(owner2);

        System.out.println("Owners loaded.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marco");
        vet1.setLastName("Pivetta");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Camillo");
        vet2.setLastName("Benso");
        vetService.save(vet2);

        System.out.println("Vets loaded.....");

    }
}
