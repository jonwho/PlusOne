package plusone.com.plusone;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class FeedActivity extends AppCompatActivity {

    private LinearLayout tabContainer;
    private ViewPager viewPager;
    private FeedFragmentPagerAdapter feedFragmentPagerAdapter;
    private Fragment fragments[];
    private View focusViews[];
    private String[] feeds = {"Me", "Friends", "Public"};

    private View personal_focus;
    private View friend_focus;
    private View public_focus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        tabContainer = (LinearLayout) findViewById(R.id.tab_container);
        viewPager = (ViewPager) findViewById(R.id.pager);
        fragments = new Fragment[feeds.length];
        focusViews = new View[feeds.length];

        fragments[0] = new PersonalFeedFragment();
        fragments[1] = new FriendFeedFragment();
        fragments[2] = new PublicFeedFragment();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View tab = inflater.inflate(R.layout.activity_feed_tabs, null);

        tabContainer.addView(tab);

        personal_focus = findViewById(R.id.personal_focus);
        friend_focus = findViewById(R.id.friend_focus);
        public_focus = findViewById(R.id.public_focus);

        feedFragmentPagerAdapter = new FeedFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(feedFragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment frag = fragments[position];

                if (position == 0) {
                    setFocus("Personal");
                } else if (position == 1) {
                    setFocus("Friends");
                } else if (position == 2) {
                    setFocus("Public");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setFocus("Personal");
    }

    private void setFocus(String focus) {
        if (focus == "Personal") {
            personal_focus.setVisibility(View.VISIBLE);
            friend_focus.setVisibility(View.INVISIBLE);
            public_focus.setVisibility(View.INVISIBLE);
        } else if (focus == "Friends") {
            personal_focus.setVisibility(View.INVISIBLE);
            friend_focus.setVisibility(View.VISIBLE);
            public_focus.setVisibility(View.INVISIBLE);
        } else {
            personal_focus.setVisibility(View.INVISIBLE);
            friend_focus.setVisibility(View.INVISIBLE);
            public_focus.setVisibility(View.VISIBLE);
        }
    }
}
