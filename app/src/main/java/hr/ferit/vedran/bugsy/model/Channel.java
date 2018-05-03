package hr.ferit.vedran.bugsy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by vedra on 3.5.2018..
 */

@Root(strict = false)
public class Channel {
    @ElementList(name = "item", inline = true) private List<ListElement> newsList;

    public List<ListElement> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<ListElement> newsList) {
        this.newsList = newsList;
    }
}
