package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
    @SequenceGenerator(sequenceName = "generic_seq", allocationSize = 1, name = "GEN_SEQ")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
