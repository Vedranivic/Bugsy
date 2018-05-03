package hr.ferit.vedran.bugsy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.ferit.vedran.bugsy.adapter.NewsfeedAdapter;
import hr.ferit.vedran.bugsy.adapter.NewsfeedClickCallback;
import hr.ferit.vedran.bugsy.model.ListElement;
import hr.ferit.vedran.bugsy.model.Rss;
import hr.ferit.vedran.bugsy.networking.NewsfeedAPI;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class NewsfeedActivity extends AppCompatActivity implements Callback<Rss> {

    private static final String BASE_URL = "http://www.bug.hr/";
    @BindView(R.id.rvNewsfeed)
    RecyclerView rvNewsfeed;
    @BindView(R.id.spCategory)
    Spinner spCategory;
    NewsfeedAdapter newsfeedAdapter;

    NewsfeedClickCallback clickCallback = new NewsfeedClickCallback() {
        @Override
        public void onClick(ListElement item) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        ButterKnife.bind(this);
        setupUI();
        fetchNewsfeed();
    }

    private void setupUI(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(
                this, layoutManager.getOrientation());
        newsfeedAdapter = new NewsfeedAdapter(clickCallback, this);

        rvNewsfeed.setLayoutManager(layoutManager);
        rvNewsfeed.addItemDecoration(divider);
        rvNewsfeed.setAdapter(newsfeedAdapter);
    }

    private void fetchNewsfeed() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        NewsfeedAPI API = retrofit.create(NewsfeedAPI.class);
        Call<Rss> call = API.getNewsfeed(spCategory.getSelectedItem().toString().toLowerCase());
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Rss> call, Response<Rss> response) {
        if(response.body() != null){
            List<ListElement> list = response.body().getChannel().getNewsList();
        }
        else Toast.makeText(getApplicationContext(),
                "There are no result.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<Rss> call, Throwable t) {
        Log.i("Failure", t.getMessage());
    }

}
