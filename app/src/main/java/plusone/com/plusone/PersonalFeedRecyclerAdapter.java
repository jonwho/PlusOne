package plusone.com.plusone;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Picknick on 6/17/2016.
 */
public class PersonalFeedRecyclerAdapter extends RecyclerView.Adapter<PersonalFeedRecyclerAdapter.ViewHolder> {
    private String mDataset[];
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView cardText;
        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
            cardText = (TextView) mCardView.findViewById(R.id.card_text);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PersonalFeedRecyclerAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PersonalFeedRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_card_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.cardText.setText(""+position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
