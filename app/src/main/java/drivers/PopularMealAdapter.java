package drivers;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import drivers.PopularMealDomain;
import com.example.loginpage.R;

import java.util.ArrayList;

public class PopularMealAdapter extends RecyclerView.Adapter<PopularMealAdapter.ViewHolder> {
    ArrayList<PopularMealDomain> popularMealDomains;

    public PopularMealAdapter(ArrayList<PopularMealDomain> popularMealDomains) {
        this.popularMealDomains = popularMealDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular_meal, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(popularMealDomains.get(position).getTitle());
        holder.calorie.setText(String.valueOf(popularMealDomains.get(position).getCalories()));

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(popularMealDomains.get(position).getPicture(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.picture);

    }


    @Override
    public int getItemCount() {
        return popularMealDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, calorie;
        ImageView picture;
        ImageView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            picture = itemView.findViewById(R.id.picture);
            calorie = itemView.findViewById(R.id.calorie);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
