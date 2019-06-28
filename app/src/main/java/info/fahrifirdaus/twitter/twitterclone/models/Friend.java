package info.fahrifirdaus.twitter.twitterclone.models;

public class Friend {

    public String id;
    public String friend_id;
    public String username;
    public String name;
    public String image_url;

    public Friend() {

    }

    public Friend(String username, String name, String image_url) {
        this.username = username;
        this.name = name;
        this.image_url = image_url;
    }

    public Friend(String id, String friend_id, String username, String name, String image_url) {
        this.id = id;
        this.friend_id = friend_id;
        this.username = username;
        this.name = name;
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return username + " namanya " + name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
