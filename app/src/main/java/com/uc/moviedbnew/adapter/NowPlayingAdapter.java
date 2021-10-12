package com.uc.moviedbnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uc.moviedbnew.R;
import com.uc.moviedbnew.helper.Const;
import com.uc.moviedbnew.model.Movies;
import com.uc.moviedbnew.model.NowPlaying;

import java.util.ArrayList;
import java.util.List;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.CardViewViewHolder> {
    private Context context;
    private List<NowPlaying.Results> nowPlayings;

    public NowPlayingAdapter(Context context) {
        this.context = context;
    }

    public List<NowPlaying.Results> getNowPlayings() {
        return nowPlayings;
    }

    public void setNowPlayings(List<NowPlaying.Results> nowPlayings) {
        this.nowPlayings = nowPlayings;
    }

    @NonNull
    @Override
    public NowPlayingAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingAdapter.CardViewViewHolder holder, int position) {
        final NowPlaying.Results results = getNowPlayings().get(position);
        holder.lbl_title.setText(results.getTitle());
        holder.lbl_overview.setText(results.getOverview());
        holder.lbl_release_date.setText(results.getRelease_date());
        Glide.with(context)
                .load(Const.BASE_IMG_URL + results.getPoster_path())
                .into(holder.img_poster);
    }

    @Override
    public int getItemCount() {
        return getNowPlayings().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView img_poster;
        TextView lbl_title, lbl_overview, lbl_release_date;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            img_poster = itemView.findViewById(R.id.img_poster_card_nowplaying);
            lbl_title = itemView.findViewById(R.id.lbl_title);
            lbl_overview = itemView.findViewById(R.id.lbl_overview);
            lbl_release_date = itemView.findViewById(R.id.lbl_release_date);
        }
    }
}
