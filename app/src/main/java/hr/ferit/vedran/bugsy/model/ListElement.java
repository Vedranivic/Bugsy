package hr.ferit.vedran.bugsy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vedra on 3.5.2018..
 */

@Root(strict = false)
public class ListElement {
    @Element(name = "title") private String title;
    @Element(name = "category") private String category;
    @Element(name = "description") private String description;
    @Element(name = "pubDate") private String pubDate;
    @Element(name = "enclosure" , required = false) private Image image;
    @Element(name = "link") private String url;

    public ListElement(String title, String category, String description, String pubDate, String url) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.pubDate = pubDate;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
