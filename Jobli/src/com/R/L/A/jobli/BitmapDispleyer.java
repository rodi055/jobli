package com.R.L.A.jobli;


import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

//TODO this obj is abstract only until I can move the field
// string imageUrl from User & HotSpot here.
//the thing stopping me is I dont know how to make this obj from json.
public abstract class BitmapDispleyer {
	
	//protected Bitmap mIconBitmap = null;
	
	public BitmapDispleyer() {	}
	
	public BitmapDispleyer(Bitmap bitmap) {
		//ImageMap.INSTANCE.setImage(this,bitmap);
	}

	public Bitmap getImage(){
		return null;//ImageMap.INSTANCE.getImage(this);
	}

	private void setBitmap(Bitmap result) {
//		ImageMap.INSTANCE.setImage(this,result);
	}
	
	private class ImageLoader extends AsyncTask<String, Void, Bitmap> {
		private static final int PROFILE_PIC_SIZE = 100;

		ImageView bmImageView;

		public ImageLoader(ImageView imageView) {
			this.bmImageView = imageView;
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			if(urldisplay.endsWith("?50")){
				// by default the profile url gives 50x50 px image only
				// we can replace the value with whatever dimension we want by
				urldisplay = urldisplay.substring(0,urldisplay.length() - 2) + PROFILE_PIC_SIZE;
			}
			Bitmap mIcon = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mIcon;
		}

		protected void onPostExecute(Bitmap result) {
			if (bmImageView != null) bmImageView.setImageBitmap(result);
			setBitmap(result);
		}
	}

	public void setPhotoToImageView(ImageView imageViewToHostImage){
//		
//		
//		if(! ImageMap.INSTANCE.isImageExist(this)){
//			String mImage = getImageUrl();
//			
//			if(mImage == null || mImage.isEmpty()) return;
//			
//			new ImageLoader(imageViewToHostImage).execute(mImage);
//		}else{
//			imageViewToHostImage.setImageBitmap(ImageMap.INSTANCE.getImage(this)); 
//		}
	}

	public void downloadPhoto(){
		//if already downloaded return
//		if( ! ImageMap.INSTANCE.isImageExist(this)){
//			return;
//		}
		//else{
			String mImage = getImageUrl();
			if(mImage == null || mImage.isEmpty()) return;
			new ImageLoader(null).execute(mImage);
		//}
	}

	abstract protected String getImageUrl() ;
}
