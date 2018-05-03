package hr.ferit.vedran.bugsy.networking;

import hr.ferit.vedran.bugsy.model.Rss;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vedra on 3.5.2018..
 */

public interface NewsfeedAPI {
    @GET("rss/{category}") Call<Rss> getNewsfeed(@Path("category") String category);
}
