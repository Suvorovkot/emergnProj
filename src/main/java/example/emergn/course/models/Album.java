package example.emergn.course.models;


import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private Integer year;
    private Integer numberOfSongs;

    private String artistName;

    public Album(String name, Integer year, Integer numberOfSongs, String artistName) {
        this.name = name;
        this.year = year;
        this.numberOfSongs = numberOfSongs;
        this.artistName = artistName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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
