package plusone.com.plusone;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Picknick on 6/17/2016.
 */
public class PersonalFeedRecyclerAdapter extends RecyclerView.Adapter<PersonalFeedRecyclerAdapter.ViewHolder> {
    private ArrayList<FriendManager.Friend> mDataset;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public View profileImage;
        public TextView username;
        public TextView likes;
        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
            profileImage = mCardView.findViewById(R.id.profile_image);
            username = (TextView) mCardView.findViewById(R.id.name_text);
            likes = (TextView) mCardView.findViewById(R.id.likes);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PersonalFeedRecyclerAdapter(ArrayList<FriendManager.Friend> myDataset) {
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
        FriendManager.Friend friend = FriendManager.friendManager.friendList.get(position);
        holder.username.setText(friend.firstName + " " + friend.lastName);
        holder.likes.setText(""+friend.likes);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
