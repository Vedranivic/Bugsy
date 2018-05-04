package hr.ferit.vedran.bugsy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vedra on 3.5.2018..
 */

@Root(strict = false)
public class Rss {
    @Element(name = "channel") private Channel channel;

    public Channel getChannel() {
        return channel;
    }

}
