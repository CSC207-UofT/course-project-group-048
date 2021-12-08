package drivers.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginpage.R;

import java.util.ArrayList;

import drivers.Domain.PopularMealDomain;

public class PopularMealAdapter extends RecyclerView.Adapter<PopularMealAdapter.ViewHolder> {
    ArrayList<PopularMealDomain> popularMealDomains;

    /**
     * Creates a new popularMealDomains object.
     *
     * @param popularMealDomains a list of popular meal domains
     */
    public PopularMealAdapter(ArrayList<PopularMealDomain> popularMealDomains) {
        this.popularMealDomains = popularMealDomains;
    }

    /**
     * On creation of a new view with parent as its view group, this method instantiates the
     * corresponding XML file and generating the required new view, returned as a ViewHolder object.
     *
     * @param parent   the parent view group which contains the corresponding popular meal domain
     * @param viewType an integer representing the viewType of the view holder
     * @return the new inflate view object is returned as a view holder object.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular_meal, parent, false);

        return new ViewHolder(inflate);
    }

    /**
     * Once the view holder is set using the adapter, this method is called with the view holder
     * and the required positions of a category, inserting one in its position using
     * recycler view.
     *
     * @param holder   the view holder that contains information about the categories
     * @param position the category that the position integer is linked with is set and placed
     *                 using the recycler view
     */
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

    /**
     * A getter method for the size of the popularMealDomains attribute.
     *
     * @return the size of the popularMealDomains attribute.
     */
    @Override
    public int getItemCount() {
        return popularMealDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, calorie;
        ImageView picture;
        ImageView addBtn;

        /**
         * Creates an instance of the ViewHolder object, with its three important attributes
         * extracted from the itemView parameter.
         *
         * @param itemView This contains information about the name, picture, layout and button of
         *                 each category.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            picture = itemView.findViewById(R.id.picture);
            calorie = itemView.findViewById(R.id.calorie);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
