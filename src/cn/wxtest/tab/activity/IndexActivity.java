package cn.wxtest.tab.activity;

import java.util.ArrayList;

import tv.acfun.mobile.wight.TabViewPager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import cn.wxtest.tab.R;
import cn.wxtest.tab.fragment.AddressListFragment;
import cn.wxtest.tab.fragment.WeixinFragment;
import cn.wxtest.tab.fragment.SetFragment;
import cn.wxtest.tab.fragment.FriendsFragment;

public class IndexActivity extends FragmentActivity {
	private ArrayList<Fragment> fragments;
	private TabViewPager tabpager;
	private ImageView img_main, img_classify, img_track, img_me;
	private ImageView img_main_on, img_classify_on, img_track_on, img_me_on;
	private ImageView[] tabOff;
	private ImageView[] tabOn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		init();
	}

	private void init() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new WeixinFragment());
		fragments.add(new AddressListFragment());
		fragments.add(new FriendsFragment());
		fragments.add(new SetFragment());
		img_main = (ImageView) findViewById(R.id.img_main);
		img_classify = (ImageView) findViewById(R.id.img_classify);
		img_track = (ImageView) findViewById(R.id.img_track);
		img_me = (ImageView) findViewById(R.id.img_me);
		img_main_on = (ImageView) findViewById(R.id.img_main_on);
		img_classify_on = (ImageView) findViewById(R.id.img_classify_on);
		img_track_on = (ImageView) findViewById(R.id.img_track_on);
		img_me_on = (ImageView) findViewById(R.id.img_me_on);
		tabOff = new ImageView[]{img_main, img_classify, img_track, img_me};
		tabOn = new ImageView[]{img_main_on, img_classify_on, img_track_on, img_me_on};
		
		tabpager = (TabViewPager) findViewById(R.id.tabpager);
		tabpager.setAdapter(pageAdapter);
		tabpager.setOnPageChangeListener(onPageChangeListener);
	}

	private FragmentPagerAdapter pageAdapter = new FragmentPagerAdapter(
			getSupportFragmentManager()) {

		@Override
		public int getCount() {

			return fragments.size();
		}

		@Override
		public Fragment getItem(int arg0) {

			return fragments.get(arg0);
		}

	};

	private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			tabOn[arg0].setAlpha(1 - arg1);
			tabOff[arg0].setAlpha(arg1);
			
			if (tabpager.getMoveLeft()) {
				if (arg0 != 0) {
					tabOn[arg0 - 1].setAlpha(arg1);
					tabOff[arg0 - 1].setAlpha(1 - arg1);
				}
			} else {
				if (arg0 != pageAdapter.getCount() - 1) {
					tabOn[arg0 + 1].setAlpha(arg1);
					tabOff[arg0 + 1].setAlpha(1 - arg1);
				}
				
			}
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	};

}
