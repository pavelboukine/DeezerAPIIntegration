package algonquin.cst2335.deezerapiintegration;

public class Song {
    private int id;
    private String title;
    private String duration;
    private String albumName;
    private String albumCover;

    public Song() {
        // Default constructor
    }

    public Song(int id, String title, String duration, String albumName, String albumCover) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.albumName = albumName;
        this.albumCover = albumCover;
    }

    // Getters and setters for all attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }
}