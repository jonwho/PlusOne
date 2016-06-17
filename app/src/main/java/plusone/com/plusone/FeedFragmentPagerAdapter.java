package plusone.com.plusone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by Picknick on 6/15/2016.
 */
public class FeedFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment fragments[];


    public FeedFragmentPagerAdapter(FragmentManager fm, Fragment fragments[])
    {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position)
    {
        return fragments[position];
    }

    @Override
    public int getCount()
    {
        return fragments.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        super.destroyItem(container, position, object);
    }
}
