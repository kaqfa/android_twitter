package info.fahrifirdaus.twitter.twitterclone.models;

public class Post {

    private String id;
    private String username;
    private String image_url;
    private String name;
    private String content;
    private long datetime;

    public Post() { }

    public Post(String name, String content, long datetime) {
        this.name = name;
        this.content = content;
        this.datetime = datetime;
    }

    public Post(String id, String username, String image_url, String name, String content, long datetime) {
        this.id = id;
        this.username = username;
        this.image_url = image_url;
        this.name = name;
        this.content = content;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return name + " memposting " + content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }
}
