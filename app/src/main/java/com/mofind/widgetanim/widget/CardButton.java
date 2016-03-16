package com.mofind.widgetanim.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.mofind.widgetanim.R;
import com.mofind.widgetanim.support.anim.Rotate3D;

/**
 * 3D翻转按钮
 * 
 * 卡片正面 oso:coverText = "Location"
 * 
 * 卡片反面oso:versoText = "Staging"
 * 
 * @author jiang
 */
public class CardButton extends Button {

	public CardButton(Context context, String coverText, String versoText) {
		super(context);
		// TODO Auto-generated constructor stub
		this.coverText = coverText;
		this.versoText = versoText;
		init(coverText, versoText);
	}

	public CardButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CardStyle);// 得到属性数组
		coverText = a.getString(R.styleable.CardStyle_coverText);
		versoText = a.getString(R.styleable.CardStyle_versoText);
		a.recycle();
		init(coverText, versoText);
	}

	public CardButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CardStyle);// 得到属性数组
		coverText = a.getString(R.styleable.CardStyle_coverText);
		versoText = a.getString(R.styleable.CardStyle_versoText);
		a.recycle();
		init(coverText, versoText);
	}

	private void init(String coverText, String versoText) {
		setText(coverText);
		// 设置监听
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startChange(isCover());
			}
		});
	}

	public void showCover() {
		setText(coverText);
	}
    public void showCover(boolean toShowCover) {
        setText(toShowCover?coverText:versoText);
    }

	public void showVerso() {
		setText(versoText);
	}

	private void startChange(final boolean isCover) {
		anim = new Rotate3D(getWidth() / 2, getHeight() / 2, true);
		startAnimation(anim);
		anim.setInterpolatedTimeListener(new Rotate3D.InterpolatedTimeListener() {
			@Override
			public void interpolatedTime(float interpolatedTime) {
				boolean overHalf = (interpolatedTime > 0.5f);
				if (overHalf) {
					if (isCover) {
						showVerso();
					} else {
						showCover();
					}
					if (onChangeTypeListener != null)
						onChangeTypeListener.onChange(getText().toString());
				}
			}
		});
	}

	public boolean isCover() {
		return getText().toString().equals(coverText);
	}

	public OnChangeTypeListener getOnChangeTypeListener() {
		return onChangeTypeListener;
	}

	public void setOnChangeTypeListener(OnChangeTypeListener onChangeTypeListener) {
		this.onChangeTypeListener = onChangeTypeListener;
	}

	public String getCoverText() {
		return coverText;
	}

	public void setCoverText(String coverText) {
		this.coverText = coverText;
	}

	public String getVersoText() {
		return versoText;
	}

	public void setVersoText(String versoText) {
		this.versoText = versoText;
	}

	private String coverText = "Cover"; // 正面
	private String versoText = "Verso"; // 反面

	private Rotate3D anim = null;

	private OnChangeTypeListener onChangeTypeListener;

	public interface OnChangeTypeListener {
		void onChange(String value);
	}
}
