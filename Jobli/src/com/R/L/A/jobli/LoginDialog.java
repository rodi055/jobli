package com.R.L.A.jobli;

import com.google.android.gms.common.SignInButton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class LoginDialog extends DialogFragment {
	private SignInButton signInBtn;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());// android.R.style.Holo_Light_ButtonBar
		// Get the layout inflater
		LayoutInflater inflater = getActivity().getLayoutInflater();

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		View v = inflater.inflate(R.layout.login_dialog, null);

		signInBtn = (SignInButton) v.findViewById(R.id.signInBtn);
		signInBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onSignInBtnClick();
			}

		});
		builder.setView(v);
		return builder.create();
	}

	public abstract void onSignInBtnClick();
}
