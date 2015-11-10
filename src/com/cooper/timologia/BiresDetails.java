package com.cooper.timologia;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cooper.timologia.R;

public class BiresDetails extends Activity {

	
	ListView Timologia_listview;
	ArrayList<Timologia> timologia_data = new ArrayList<Timologia>();
	Timologia_Adapter tAdapter;
	DatabaseHandler db;
	String Toast_msg;
	EditText search_view;
	TextView sum;

	public static final String KEY_ARITHMOS_TIM_DETAIL = "arithmos_tim_detail";
	public static final String KEY_TIMI_TIM_DETAIL = "timi_tim_detail";
	public static final String KEY_EIDOS1_TIM_DETAIL = "eidos1_tim_detail";
	public static final String KEY_EIDOS2_TIM_DETAIL = "eidos2_tim_detail";
	public static final String KEY_EIDOS3_TIM_DETAIL = "eidos3_tim_detail";
	public static final String KEY_EIDOS4_TIM_DETAIL = "eidos4_tim_detail";
	public static final String KEY_EIDOS5_TIM_DETAIL = "eidos5_tim_detail";
	public static final String KEY_EIDOS6_TIM_DETAIL = "eidos6_tim_detail";
	public static final String KEY_EIDOS7_TIM_DETAIL = "eidos7_tim_detail";
	public static final String KEY_EIDOS8_TIM_DETAIL = "eidos8_tim_detail";
	public static final String KEY_POSOTITA1_TIM_DETAIL = "posotita1_tim_detail";
	public static final String KEY_POSOTITA2_TIM_DETAIL = "posotita2_tim_detail";
	public static final String KEY_POSOTITA3_TIM_DETAIL = "posotita3_tim_detail";
	public static final String KEY_POSOTITA4_TIM_DETAIL = "posotita4_tim_detail";
	public static final String KEY_POSOTITA5_TIM_DETAIL = "posotita5_tim_detail";
	public static final String KEY_POSOTITA6_TIM_DETAIL = "posotita6_tim_detail";
	public static final String KEY_POSOTITA7_TIM_DETAIL = "posotita7_tim_detail";
	public static final String KEY_POSOTITA8_TIM_DETAIL = "posotita8_tim_detail";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tim_noadd);
		try {
			Timologia_listview = (ListView) findViewById(R.id.list_tim);
			Timologia_listview.setItemsCanFocus(false);
			
			sum = (TextView) findViewById(R.id.ET_Sum);

			Set_Referash_Data();
			registerClickCallback();
			Set_Sum_Tim();

			search_view = (EditText) findViewById(R.id.search_view);

			search_view.addTextChangedListener(new TextWatcher() {

				@Override
				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub
					String text = search_view.getText().toString()
							.toLowerCase(Locale.getDefault());
					tAdapter.filter(text);
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub
				}

				@Override
				public void onTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub
				}
			});

		} catch (Exception e) {
			// TODO: handle exception
			Log.e("some error", "" + e);
		}
		

	}

	private void Set_Sum_Tim() {
		// TODO Auto-generated method stub
		db = new DatabaseHandler(this);
		String data = db.getSumBires();
		db.close();
		if (data != null) {
			sum.setText("Σύνολο σε μπύρες= " + data);
		} else {
			sum.setText("Σύνολο σε μπύρες= 0");
		}
	}

	private void registerClickCallback() {
		// TODO Auto-generated method stub

		Timologia_listview
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent,
							View viewClicked, int position, long id) {
						// TODO Auto-generated method stub

						Timologia item = (Timologia) tAdapter.getItem(position);

						Intent intent = new Intent(getApplicationContext(),
								Click.class);
						intent.putExtra(KEY_ARITHMOS_TIM_DETAIL,
								item.getArithmoTim());
						intent.putExtra(KEY_TIMI_TIM_DETAIL, item.getTimiTim());

						intent.putExtra(KEY_EIDOS1_TIM_DETAIL,
								item.getEidos1Tim());
						intent.putExtra(KEY_EIDOS2_TIM_DETAIL,
								item.getEidos2Tim());
						intent.putExtra(KEY_EIDOS3_TIM_DETAIL,
								item.getEidos3Tim());
						intent.putExtra(KEY_EIDOS4_TIM_DETAIL,
								item.getEidos4Tim());
						intent.putExtra(KEY_EIDOS5_TIM_DETAIL,
								item.getEidos5Tim());
						intent.putExtra(KEY_EIDOS6_TIM_DETAIL,
								item.getEidos6Tim());
						intent.putExtra(KEY_EIDOS7_TIM_DETAIL,
								item.getEidos7Tim());
						intent.putExtra(KEY_EIDOS8_TIM_DETAIL,
								item.getEidos8Tim());
						intent.putExtra(KEY_POSOTITA1_TIM_DETAIL,
								item.getPosotita1Tim());
						intent.putExtra(KEY_POSOTITA2_TIM_DETAIL,
								item.getPosotita2Tim());
						intent.putExtra(KEY_POSOTITA3_TIM_DETAIL,
								item.getPosotita3Tim());
						intent.putExtra(KEY_POSOTITA4_TIM_DETAIL,
								item.getPosotita4Tim());
						intent.putExtra(KEY_POSOTITA5_TIM_DETAIL,
								item.getPosotita5Tim());
						intent.putExtra(KEY_POSOTITA6_TIM_DETAIL,
								item.getPosotita6Tim());
						intent.putExtra(KEY_POSOTITA7_TIM_DETAIL,
								item.getPosotita7Tim());
						intent.putExtra(KEY_POSOTITA8_TIM_DETAIL,
								item.getPosotita8Tim());

						startActivity(intent);
					}
				});

	}

	public void Set_Referash_Data() {
		timologia_data.clear();
		db = new DatabaseHandler(this);
		ArrayList<Timologia> timologia_array_from_db = db.Get_BiresDetails();

		for (int i = 0; i < timologia_array_from_db.size(); i++) {

			int tidno = timologia_array_from_db.get(i).getIDTim();

			String eponimia_tim = timologia_array_from_db.get(i)
					.getEponimiaTim();
			String timi_tim = timologia_array_from_db.get(i).getTimiTim();
			String date_tim = timologia_array_from_db.get(i).getDateTim();
			String arithmo_tim = timologia_array_from_db.get(i).getArithmoTim();
			String eidos1_tim = timologia_array_from_db.get(i).getEidos1Tim();
			String eidos2_tim = timologia_array_from_db.get(i).getEidos2Tim();
			String eidos3_tim = timologia_array_from_db.get(i).getEidos3Tim();
			String eidos4_tim = timologia_array_from_db.get(i).getEidos4Tim();
			String eidos5_tim = timologia_array_from_db.get(i).getEidos5Tim();
			String eidos6_tim = timologia_array_from_db.get(i).getEidos6Tim();
			String eidos7_tim = timologia_array_from_db.get(i).getEidos7Tim();
			String eidos8_tim = timologia_array_from_db.get(i).getEidos8Tim();
			String posotita1_tim = timologia_array_from_db.get(i)
					.getPosotita1Tim();
			String posotita2_tim = timologia_array_from_db.get(i)
					.getPosotita2Tim();
			String posotita3_tim = timologia_array_from_db.get(i)
					.getPosotita3Tim();
			String posotita4_tim = timologia_array_from_db.get(i)
					.getPosotita4Tim();
			String posotita5_tim = timologia_array_from_db.get(i)
					.getPosotita5Tim();
			String posotita6_tim = timologia_array_from_db.get(i)
					.getPosotita6Tim();
			String posotita7_tim = timologia_array_from_db.get(i)
					.getPosotita7Tim();
			String posotita8_tim = timologia_array_from_db.get(i)
					.getPosotita8Tim();

			Timologia cnt = new Timologia();

			cnt.setIDTim(tidno);
			cnt.setEponimiaTim(eponimia_tim);
			cnt.setTimiTim(timi_tim);
			cnt.setDateTim(date_tim);
			cnt.setArithmoTim(arithmo_tim);
			cnt.setEidos1Tim(eidos1_tim);
			cnt.setEidos2Tim(eidos2_tim);
			cnt.setEidos3Tim(eidos3_tim);
			cnt.setEidos4Tim(eidos4_tim);
			cnt.setEidos5Tim(eidos5_tim);
			cnt.setEidos6Tim(eidos6_tim);
			cnt.setEidos7Tim(eidos7_tim);
			cnt.setEidos8Tim(eidos8_tim);
			cnt.setPosotita1Tim(posotita1_tim);
			cnt.setPosotita2Tim(posotita2_tim);
			cnt.setPosotita3Tim(posotita3_tim);
			cnt.setPosotita4Tim(posotita4_tim);
			cnt.setPosotita5Tim(posotita5_tim);
			cnt.setPosotita6Tim(posotita6_tim);
			cnt.setPosotita7Tim(posotita7_tim);
			cnt.setPosotita8Tim(posotita8_tim);

			timologia_data.add(cnt);
		}
		db.close();
		tAdapter = new Timologia_Adapter(BiresDetails.this, timologia_data);
		Timologia_listview.setAdapter(tAdapter);
		tAdapter.notifyDataSetChanged();
	}

	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Set_Referash_Data();

	}

	public class Timologia_Adapter extends BaseAdapter {

		Context mContext;
		LayoutInflater inflater;
		private List<Timologia> timologiaList = null;
		private ArrayList<Timologia> timologia_data;

		public Timologia_Adapter(Context context, List<Timologia> timologiaList) {
			mContext = context;
			this.timologiaList = timologiaList;
			inflater = LayoutInflater.from(mContext);
			this.timologia_data = new ArrayList<Timologia>();
			this.timologia_data.addAll(timologiaList);
		}

		public class TimologiaHolder {

			TextView eponimia_tim;
			TextView date_tim;
			TextView timi_tim;

			Button edit;
			Button delete;
		}

		@Override
		public int getCount() {
			return timologiaList.size();
		}

		@Override
		public Timologia getItem(int position) {
			return timologiaList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View View, ViewGroup parent) {
			final TimologiaHolder holder;

			if (View == null) {
				holder = new TimologiaHolder();
				View = inflater.inflate(R.layout.listview_row_tim, null);

				holder.eponimia_tim = (TextView) View
						.findViewById(R.id.user_eponimia_txt_tim);
				holder.date_tim = (TextView) View
						.findViewById(R.id.date_txt_tim);
				holder.timi_tim = (TextView) View
						.findViewById(R.id.user_timi_txt_tim);
				holder.edit = (Button) View.findViewById(R.id.btn_update_tim);
				holder.delete = (Button) View.findViewById(R.id.btn_delete_tim);
				View.setTag(holder);
			} else {
				holder = (TimologiaHolder) View.getTag();
			}

			holder.eponimia_tim.setText(timologiaList.get(position)
					.getEponimiaTim());
			holder.date_tim.setText(timologiaList.get(position).getDateTim());
			holder.timi_tim.setText(timologiaList.get(position).getTimiTim());

			holder.edit.setTag(timologiaList.get(position).getIDTim());
			holder.delete.setTag(timologiaList.get(position).getIDTim());

			holder.edit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.i("Edit Button Clicked", "**********");

					Intent update_timologio = new Intent(mContext,
							Update_Tim.class);
					update_timologio.putExtra("called", "update");
					update_timologio.putExtra("TIMOLOGIO_ID", v.getTag()
							.toString());
					mContext.startActivity(update_timologio);

				}
			});
			holder.delete.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(final View v) {
					// TODO Auto-generated method stub

					// show a message while loader is loading

					AlertDialog.Builder adb = new AlertDialog.Builder(mContext);
					adb.setTitle("Διαγραφή;");
					adb.setMessage("Είστε σίγουρος για τη διαγραφή; ");
					final int user_id = Integer.parseInt(v.getTag().toString());
					adb.setNegativeButton("Άκυρο", null);
					adb.setPositiveButton("Ok",
							new AlertDialog.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// MyDataObject.remove(positionToRemove);
									DatabaseHandler dBHandler = new DatabaseHandler(
											mContext.getApplicationContext());
									dBHandler.Delete_Timologia(user_id);
									BiresDetails.this.onResume();

								}
							});
					adb.show();
				}

			});
			return View;
		}

		public void filter(String charText) {
			charText = charText.toLowerCase(Locale.getDefault());
			timologiaList.clear();
			if (charText.length() == 0) {
				timologiaList.addAll(timologia_data);
			} else {
				for (Timologia tim : timologia_data) {
					if (tim.getEponimiaTim().toLowerCase(Locale.getDefault())
							.contains(charText)) {
						timologiaList.add(tim);
					}
				}
			}
			notifyDataSetChanged();
		}

	}
}
