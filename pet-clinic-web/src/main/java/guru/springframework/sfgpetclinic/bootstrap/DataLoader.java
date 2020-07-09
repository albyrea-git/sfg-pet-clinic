package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Valentina");
        owner1.setLastName("Amadio");
        owner1.setAddress("via Abbà");
        owner1.setCity("Tavazzano");
        owner1.setTelephone("1234567");


        Pet valePet = new Pet();
        valePet.setPetType(savedDogType);
        valePet.setOwner(owner1);
        valePet.setBirthDate(LocalDate.now());
        valePet.setName("Axel");
        owner1.getPets().add(valePet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Martino");
        owner2.setLastName("Albanese");
        owner2.setAddress("via del Lisone");
        owner2.setCity("Carpiano");
        owner2.setTelephone("99887766");
        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("first visit");
        visit1.setPet(valePet);
        visitService.save(visit1);

        System.out.println("Visit loaded.....");
        Pet aironPet = new Pet();
        aironPet.setPetType(savedDogType);
        aironPet.setOwner(owner2);
        aironPet.setBirthDate(LocalDate.now());
        aironPet.setName("Airon");
        owner2.getPets().add(aironPet);

        System.out.println("Owners loaded.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marco");
        vet1.setLastName("Pivetta");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Camillo");
        vet2.setLastName("Benso");
        vetService.save(vet2);

        System.out.println("Vets loaded.....");

    }
}
