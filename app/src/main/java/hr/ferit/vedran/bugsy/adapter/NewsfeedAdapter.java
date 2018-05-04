package hr.ferit.vedran.bugsy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.ferit.vedran.bugsy.R;
import hr.ferit.vedran.bugsy.model.ListElement;

/**
 * Created by vedra on 3.5.2018..
 */

public class NewsfeedAdapter extends RecyclerView.Adapter<NewsfeedAdapter.ViewHolder> {
    private NewsfeedClickCallback mClickCallback;
    private List<ListElement> newsfeed;
    Context context;

    public NewsfeedAdapter(NewsfeedClickCallback mClickCallback, Context context) {
        this.mClickCallback = mClickCallback;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView title;
        @BindView(R.id.tvCategory)
        TextView category;
        @BindView(R.id.tvDescription)
        TextView description;
        @BindView(R.id.tvDate)
        TextView date;
        @BindView(R.id.ivImage)
        ImageView image;

        ViewHolder(View itemView, final NewsfeedClickCallback clickCallback) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickCallback.onClick(newsfeed.get(getAdapterPosition()));
                }
            });
        }

    }

    @Override
    public NewsfeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View feedView = inflater.inflate(R.layout.list_element, parent, false);
        ViewHolder feedViewHolder = new ViewHolder(feedView, mClickCallback);
        return feedViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsfeedAdapter.ViewHolder holder, int position) {
        ListElement item = this.newsfeed.get(position);
        holder.title.setText(item.getTitle());
        holder.category.setText(item.getCategory());
        holder.description.setText(item.getDescription());
        holder.date.setText(item.getPubDate().substring(0, item.getPubDate().length()-5));
        Picasso.get().load(item.getEnclosure().getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(newsfeed!=null)
            return this.newsfeed.size();
        else
            return 0;
    }

    public void refreshFeed(List<ListElement> newNewsfeed){
        this.newsfeed = newNewsfeed;
        notifyDataSetChanged();
    }



}
