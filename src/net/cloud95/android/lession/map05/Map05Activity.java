package net.cloud95.android.lession.map05;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class Map05Activity extends FragmentActivity {

	private GoogleMap map;
	private UiSettings uiSettings;

	private Switch animate_switch;
	private Button stop_button, camera01_button, camera02_button,
			camera03_button, scroll_up_button, scroll_down_button,
			scroll_left_button, scroll_right_button, zoom_in_button,
			zoom_out_button;

	private CancelableCallback myCancelableCallback;//是直接import進來的介面

	private static final CameraPosition position01 = new CameraPosition.Builder()
			.target(new LatLng(25.071742, 121.524256)) // 設定位置
			.zoom(15) // 設定縮放
			.bearing(300) // 設定方向
			.tilt(50) // 設定傾斜度
			.build(); // 建立設定好的CameraPosition物件
	private static final CameraPosition position02 = new CameraPosition.Builder()
			.target(new LatLng(24.141369, 120.663246)).zoom(14).bearing(0)
			.tilt(25).build();
	private static final CameraPosition position03 = new CameraPosition.Builder()
			.target(new LatLng(22.656076, 120.287071)).zoom(17).bearing(180)
			.tilt(50).build();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		processViews();
		processControllers();

		// 建立準備要移動到台灣地理中心點的CameraUpdate物件
		LatLng center = new LatLng(23.975117, 120.981588);
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(center,
				12);
		// 直接顯示指定位置的地圖
		map.moveCamera(cameraUpdate);
	}

	@Override
	public void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		if (map == null) {
			map = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
		}
	}

	private void processViews() {
		setUpMapIfNeeded();
		uiSettings = map.getUiSettings();
		// 取消我的位置與捲動按鈕
		map.setMyLocationEnabled(false);
		uiSettings.setZoomControlsEnabled(false);
		// 禁止縮放、捲動、傾斜與旋轉操作
		uiSettings.setScrollGesturesEnabled(false);
		uiSettings.setZoomGesturesEnabled(false);
		uiSettings.setTiltGesturesEnabled(false);
		uiSettings.setRotateGesturesEnabled(false);

		// 動畫開啟或關閉
		animate_switch = (Switch) findViewById(R.id.animate_switch);

		stop_button = (Button) findViewById(R.id.stop_button);
		camera01_button = (Button) findViewById(R.id.camera01_button);
		camera02_button = (Button) findViewById(R.id.camera02_button);
		camera03_button = (Button) findViewById(R.id.camera03_button);
		scroll_up_button = (Button) findViewById(R.id.scroll_up_button);
		scroll_down_button = (Button) findViewById(R.id.scroll_down_button);
		scroll_left_button = (Button) findViewById(R.id.scroll_left_button);
		scroll_right_button = (Button) findViewById(R.id.scroll_right_button);
		zoom_in_button = (Button) findViewById(R.id.zoom_in_button);
		zoom_out_button = (Button) findViewById(R.id.zoom_out_button);
	}

	private void processControllers() {
		OnClickListener buttonListener = new OnClickListener() {

			@Override
			public void onClick(View view) {
				if(view == stop_button){
				// 停止動畫
					map.stopAnimation();
				}else if(view == camera01_button){
				// 移動地圖
					processMap(CameraUpdateFactory.newCameraPosition(position01), myCancelableCallback);
				}
				// 移動地圖
				// 移動地圖
				// 向上移動地圖
				// 向下移動地圖
				// 向左移動地圖
				// 向右移動地圖
				// 放大
				// 縮小
			}

		};

		// 動畫事件
		// 動畫結束
		// 動畫取消
	}

	private void processMap(CameraUpdate cameraUpdate, int duration,
			CancelableCallback cancelableCallback) {
		// 使用動畫效果
		// 直接顯示
	}

	private void processMap(CameraUpdate cameraUpdate,
			CancelableCallback cancelableCallback) {
		// 使用動畫效果
		// 直接顯示
	}

}
