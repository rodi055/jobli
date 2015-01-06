package com.R.L.A.jobli;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class CreateJobFragment extends Fragment {
	public static Long defJobID = -1L;
	private GoogleMap mMap;
	private boolean isEdit;
	// private Job mCurrJobData;
	private CameraPosition chosenPos;
	boolean LocationSet = false;
	int requestCodeMap = 100;

	public static CreateJobFragment newInstance(Long id) {
		if (id == null) {
			id = defJobID;
		}
		CreateJobFragment fragment = new CreateJobFragment();
		Bundle args = new Bundle();
		args.putLong("id", id);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			// mCurrHotSpotId = getArguments().getLong("id");
			// mCurrHotSpotData = LocalDBManager.INSTANCE.HotSpotDB
			// .getItemById(mCurrHotSpotId);
			// if (mCurrHotSpotData == null || mCurrHotSpotId == defHotSpotID) {
			isEdit = false;
			// } else {
			// isEdit = true;
			// }
			setHasOptionsMenu(true);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_create_job, container,
				false);
		initMap();

		setListeners();

		getActivity().getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		return v;
	}

	private void initMap() {
		MapFragment f = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.My_map));
		mMap = f.getMap();

		if (isEdit) {
			// LatLng ll = new LatLng(
			// mCurrJobData.getLangt(),mCurrJobData.getLongt());
			// chosenPos = LocationFactury.buildCameraPosition(ll);
			// if (mMap != null) {
			// mMap.moveCamera(CameraUpdateFactory.newCameraPosition(chosenPos));
			// mMap.addMarker(new MarkerOptions().position(ll));
			// LocationSet = true;
			// }

		} else {
			chosenPos = LocationFactory.currentPosition();
			if (mMap != null)
				mMap.moveCamera(CameraUpdateFactory
						.newCameraPosition(chosenPos));
			LocationFactory currentLocation = new LocationFactory(
					JobliApplication.getAppContext());
			mMap.addMarker(new MarkerOptions().position(new LatLng(
					currentLocation.getLatitude(), currentLocation
							.getLongitude())));
		}
	}

	private void setListeners() {
		mMap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng arg0) {
				double lat = chosenPos.target.latitude;
				double lng = chosenPos.target.longitude;
				startActivityForResult(
						new Intent(getActivity(), MapPickerActivity.class)
								.putExtra("lat", lat).putExtra("lng", lng),
						requestCodeMap);
			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		getActivity();
		if (requestCode == requestCodeMap && resultCode == Activity.RESULT_OK) {

			// reset Camera on mMap
			Double lat = data.getExtras().getDouble("lat");
			Double lng = data.getExtras().getDouble("lng");
			chosenPos = LocationFactory.buildCameraPosition(lat, lng);

			mMap.clear();
			mMap.moveCamera(CameraUpdateFactory.newCameraPosition(chosenPos));
			mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
			LocationSet = true;

		}
	}
}
