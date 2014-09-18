package cn.wxtest.tab.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.wxtest.tab.R;

public class FriendsFragment extends Fragment{
	private Context context;
	private View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (v == null) {
			v = inflater.inflate(R.layout.fragment_track, container, false);
		}
		ViewGroup viewGroup=(ViewGroup) v.getParent();
		if (viewGroup!=null) {
			viewGroup.removeAllViewsInLayout();
		}
		
		context = getActivity();
		initView();
		return v;

	}

	private void initView() {
		// TODO Auto-generated method stub

	}
}
