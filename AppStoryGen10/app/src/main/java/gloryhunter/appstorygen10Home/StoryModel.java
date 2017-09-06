package gloryhunter.appstorygen10Home;

/**
 * Created by SNOW on 9/5/2017.
 */

public class StoryModel {
    private int id;
    private String image;
    private String title;
    private String description;
    private String content;
    private String author;
    private boolean bookmark;


    public StoryModel(int id, String image, String title, String description, String content, String author, boolean bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBookmark() {
        return bookmark;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }


    @Override
    public String toString() {
        return "StoryModel{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", bookmark=" + bookmark +
                '}';
    }
}
