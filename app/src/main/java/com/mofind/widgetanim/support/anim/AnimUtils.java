package com.mofind.widgetanim.support.anim;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mofind.widgetanim.R;

public class AnimUtils {

	/**
	 * 控件水平抖动动画
	 * @param context
	 * @param v
	 * @return
	 */
	public static Animation horizontalShake(Context context, View v) {
		return shake(context, v, true);
	}

	/**
	 * 控件垂直抖动动画
	 * @param context
	 * @param v
	 * @return
	 */
	public static Animation verticalShake(Context context, View v) {
		return shake(context, v, false);
	}

	/**
	 * 控件抖动动画
	 * @param context
	 * @param v
	 * @return
	 */
	public static Animation shake(Context context, View v, boolean isX) {
		Animation shakeAnim = AnimationUtils.loadAnimation(context, isX ? R.anim.shake_x : R.anim.shake_y);
		v.startAnimation(shakeAnim);
		return shakeAnim;
	}

	/**
	 * 控件3D翻转动画（水平）
	 * @param context
	 * @param v
	 * @param dir 方向，true为正时针方向
	 * @return
	 */
	public static Rotate3D retate3D(Context context, View v, boolean dir) {
		Rotate3D rotate3d = new Rotate3D(v.getWidth() / 2, v.getHeight() / 2, dir);
		rotate3d.setDuration(800);
		v.startAnimation(rotate3d);
		return rotate3d;
	}

	/**
	 * 控件弹跳动画
	 * @param context
	 * @param v
	 * @return
	 */
	public static Animation clickScale(Context context, View v) {
		Animation scaleAnim = AnimationUtils.loadAnimation(context, R.anim.click_scale);
		v.startAnimation(scaleAnim);
		return scaleAnim;
	}

}
