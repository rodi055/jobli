package com.R.L.A.jobli;

public class User extends BitmapDispleyer implements IdiableObj,
		Comparable<User> {

	private Long mId;
	private String mStrId;
	private String mImage;
	private String mName;

	// ctor
	public User(Long mId, String mStrId, String mImage, String mName) {
		this.mId = mId;
		this.mStrId = mStrId;
		this.mImage = mImage;
		this.mName = mName;
	}

	// implements IdiableObj
	@Override
	public Long getId() {
		return mId;
	}

	@Override
	public void setId(Long id) {
		mId = id;
	}

	// getters and setters:
	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mIm) {
		this.mImage = mIm;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getStringId() {
		return mStrId;
	}

	public void setStringId(String mId) {
		this.mStrId = mId;
	}

	@Override
	protected String getImageUrl() {
		return getmImage();
	}

	@Override
	public int compareTo(User another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
