package example.emergn.course.database.models;


import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer year;
    private Integer numberOfSongs;

    private String artistName;

    public Album() {
        super();
    }

    public Album(Integer id, String name, Integer year, Integer numberOfSongs, String artistName) {
        super();
        this.id = id;
        this.name = name;
        this.year = year;
        this.numberOfSongs = numberOfSongs;
        this.artistName = artistName;
    }


    public Album(String name, Integer year, Integer numberOfSongs, String artistName) {
        super();
        this.name = name;
        this.year = year;
        this.numberOfSongs = numberOfSongs;
        this.artistName = artistName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSongs(Integer numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberOfSongs() {
        return numberOfSongs;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String  getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
