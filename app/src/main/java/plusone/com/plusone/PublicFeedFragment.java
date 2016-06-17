package plusone.com.plusone;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PublicFeedFragment extends Fragment {
    private TextView text1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView == null) {
            contentView = inflater.inflate(R.layout.fragment_public_feed, container, false);
        }
        text1 = (TextView) contentView.findViewById(R.id.public_feed_text);

        text1.setText("test");

        return contentView;
    }
}
