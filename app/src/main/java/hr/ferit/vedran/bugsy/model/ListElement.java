package hr.ferit.vedran.bugsy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vedra on 3.5.2018..
 */

@Root(strict = false, name = "item")
public class ListElement {
    @Element(name = "title") private String title;
    @Element(name = "category") private String category;
    @Element(name = "description") private String description;
    @Element(name = "pubDate") private String pubDate;
    @Element(name = "enclosure" , required = false) private Enclosure enclosure;
    @Element(name = "link") private String url;

    public String getTitle() {
        return title;
    }


    public String getCategory() {
        return category;
    }


    public String getDescription() {
        return description;
    }


    public String getPubDate() {
        return pubDate;
    }


    public Enclosure getEnclosure() {
        return enclosure;
    }


    public String getUrl() {
        return url;
    }

}
