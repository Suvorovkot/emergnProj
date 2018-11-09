package example.emergn.course.database.models;

import example.emergn.course.database.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "artists")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class)
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String stageName;
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    private Countries country;

    @OneToMany
    private List<Album> albums;

    public Artist(String firstName,
                  String lastName,
                  String stageName,
                  Countries country,
                  List<Album> albums) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.country = country;
        this.albums = albums;
    }

    public long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStageName() {
        return stageName;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
