package hr.ferit.vedran.bugsy.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by vedra on 3.5.2018..
 */

@Root(name = "enclosure", strict = false)
public class Image {

    @Attribute(name = "url", required = false) private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
