package com.example.admin.miningsurvey.util;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * 
 * 项目名称:flood<br/>
 * 类名称:ToastUtil<br/>
 * 描述:单例模式实时显示Toast提示消息
 * 
 */
public class ToastUtil {

	private static Toast toast;
	/**
	 * 当前工具类的总开关
	 */
	private static boolean isAllowShow = true;

	/**
	 * 
	 * 功能:开关(isAllowShow开启后，此方法功能可用)
	 * 
	 * @param context
	 * @param msg
	 */
	public static void show(Context context, String msg) {
		if (!isAllowShow) {
			return;
		}
		// 开关开启后才往下执行
		if (toast == null) {
			if(context==null)
			{
				return;
			}
			toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}

	/**
	 * 
	 * 功能:上面方法的增强版，当只需要显示部分Toast提示时，<br/>
	 * 总开关关闭,传入true,显示;<br/>
	 * 总开关开启,传入false,关闭
	 * 
	 * @param context
	 * @param msg
	 * @param flag
	 *            开关状态
	 */
	public static void show(Context context, String msg, boolean flag) {
		if (!flag) {
			return;
		}
		if (!isAllowShow && !flag) {
			return;
		}
		// 开关开启后才往下执行
		if (toast == null) {
			toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}

	/**
	 * 
	 * 功能:一直显示Toast
	 * 
	 * @param context
	 * @param msg
	 * @param flag
	 */
	public static void alwaysShow(final Context context, final String msg, final boolean flag) {
		new Thread() {
			public void run() {
				while (true) {
					Looper.prepare();
					SystemClock.sleep(3000);
//					show(context, msg, flag);
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					Looper.loop();
				}
			};
		}.start();

	}
}
