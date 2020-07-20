package nl.novi.dbexample.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * https://en.wikibooks.org/wiki/Java_Persistence/OneToMany
 */
@Entity
public class ApplicationUser {

    /**
     * We laten op regel X hibernate het beste generation-type selecteren. Je kunt er hier meer over lezen:
     * https://thorben-janssen.com/jpa-generate-primary-keys/
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    /**
     * Deze twee spreken voor zich
     */
    private String name;
    private String email;

    /**
     * Dog is de many van de one to many kant. Aan de many kant moet de mappedBy geconfigureerd worden. Deze geef je
     * de naam van de variabele mee van de relatie aan de one-kant. In Dog is dat deze regel:
     * private ApplicationUser owner;
     *
     * */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Dog> dogs;

    /*
    Hieronder vind je alle getter en setters. Ik ga ervanuit dat je weet wat deze zijn en doen.
     */
    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

}
