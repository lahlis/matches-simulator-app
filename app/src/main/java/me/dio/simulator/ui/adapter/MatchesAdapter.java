package me.dio.simulator.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.dio.simulator.databinding.MatchItemBinding;
import me.dio.simulator.domain.Match;
import me.dio.simulator.ui.DetailActivity;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches) { this.matches = matches; }

    public List<Match> getMatches() {
        return matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MatchItemBinding binding = MatchItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Match match = matches.get(position);

        Glide.with(context).load(match.getHomeTeam().getImage()).into(holder.binding.ivHomeTeam);
        holder.binding.tvHomeTeamName.setText(match.getHomeTeam().getName());
        if (match.getHomeTeam().getScore() != null) {
            holder.binding.tvHomeTeamScore.setText(String.valueOf(match.getHomeTeam().getScore()));
        }

        Glide.with(context).load(match.getAwayTeam().getImage()).into(holder.binding.ivAwayTeam);
        holder.binding.tvAwayTeamName.setText(match.getAwayTeam().getName());
        if (match.getAwayTeam().getScore() != null)
            holder.binding.tvAwayTeamScore.setText(String.valueOf(match.getAwayTeam().getScore()));

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.Extras.MATCH, match);
            context.startActivity(intent);
        });

   }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final MatchItemBinding binding;

        public ViewHolder(MatchItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}


/* Notes:
Adapter: adapts a single data structure (matches list) to a visual element (layout). Assigns information to layout
elements.
public MatchesAdapter(List<Match> matches) {(...): constructor created for pass lists as parameter for the adapter
ViewHolder using 'View Binding': ViewHolder (LayoutFileName binding).
private final: turns binding accessible for others elements inside adapter.
onCreateViewHolder: create new views (invoked by the layout manager)
Context: a layer that stands behind its component (e.g., activities, applications) which provides access to various functionalities (loading
resources, inflating layouts, starting activities...). getContext was used because the Layout Inflater ('getLayoutInflater')
wasn't accessible here.
Parent/root: layout root-element
onBindViewHolder: replace the contents of a view (invoked by layout manager). From ViewHolder's element and its position is possible to
know about the referred item of list -> Associate a ViewHolder with appropriate data (from API) that will fill view holder's layout.
 */