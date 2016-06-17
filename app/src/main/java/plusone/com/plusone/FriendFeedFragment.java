package plusone.com.plusone;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FriendFeedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FriendFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendFeedFragment extends Fragment {
    private TextView text1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView == null) {
            contentView = inflater.inflate(R.layout.fragment_friend_feed, container, false);
        }
        text1 = (TextView) contentView.findViewById(R.id.friend_feed_text);

        text1.setText("test");

        return contentView;
    }
}
