package drivers.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import drivers.Domain.CategoryDomain;
import com.example.loginpage.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    /**
     * Create a new CategoryAdapter object.
     * @param categoryDomains a list of category domains.
     */
    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    /**
     * On creation of a new view with parent as its view group, this method instantiates the
     * corresponding XML file and generating the required new view, returned as a ViewHolder object.
     * @param parent the parent view group which contains the corresponding category
     * @param viewType an integer representing the viewType of the view holder
     * @return the new inflate view object is returned as a view holder object.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);

        return new ViewHolder(inflate);
    }

    /**
     * Once the view holder is set using the adapter, this method is called with the view holder
     * and the required positions of a category, inserting one in its position using
     * recycler view.
     * @param holder the view holder that contains information about the categories
     * @param position the category the position integer is linked with is set and placed using
     *                 the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl="";
        switch (position) {
            case 0: {
                picUrl = "cat_1";
                break;
            }
            case 1: {
                picUrl = "cat_2";
                break;
            }
            case 2: {
                picUrl = "cat_3";
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl, "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);

    }

    /**
     * A getter method for the size of the categoryDomains attribute.
     * @return the size of the category domains attribute.
     */
    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        /**
         * Creates an instance of the ViewHolder object, with its three important attributes
         * extracted from the itemView parameter.
         * @param itemView This contains information about the name, picture and layout of each
         *                 category.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
