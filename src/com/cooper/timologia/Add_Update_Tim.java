package com.cooper.timologia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.cooper.timologia.R;

public class Add_Update_Tim extends Activity implements OnItemSelectedListener {
	EditText add_eponimia_tim, add_arithmos_tim, add_timi_tim, add_date_tim,
			add_eidos1_tim, add_eidos2_tim, add_eidos3_tim, add_eidos4_tim,
			add_eidos5_tim, add_eidos6_tim, add_eidos7_tim, add_eidos8_tim,
			add_posotita1_tim = null, add_posotita2_tim = null,
			add_posotita3_tim = null, add_posotita4_tim = null,
			add_posotita5_tim = null, add_posotita6_tim = null,
			add_posotita7_tim = null, add_posotita8_tim = null;
	Button add_save_btn_tim, update_btn_tim, calculate, b_valeproion2,
			b_valeproion3, b_valeproion4, b_valeproion5, b_valeproion6,
			b_valeproion7, b_valeproion8, b_vgaleproion2, b_vgaleproion3,
			b_vgaleproion4, b_vgaleproion5, b_vgaleproion6, b_vgaleproion7,
			b_vgaleproion8;
	LinearLayout add_view_tim, update_view_tim, LL2, LL3, LL4, LL5, LL6, LL7,
			LL8;
	String valid_eponimia_tim = null, valid_arithmos_tim = null,
			valid_timi_tim = null, valid_date_tim = null,
			valid_eidos1_tim = null, valid_eidos2_tim = null,
			valid_eidos3_tim = null, valid_eidos4_tim = null,
			valid_eidos5_tim = null, valid_eidos6_tim = null,
			valid_eidos7_tim = null, valid_eidos8_tim = null,
			valid_posotita1_tim = null, valid_posotita2_tim = null,
			valid_posotita3_tim = null, valid_posotita4_tim = null,
			valid_posotita5_tim = null, valid_posotita6_tim = null,
			valid_posotita7_tim = null, valid_posotita8_tim = null,
			Toast_msg = null, valid_user_id = "";
	int TIMOLOGIO_ID;
	DatabaseHandler dbHandler = new DatabaseHandler(this);
	Spinner spinner, spinner11, spinner12, spinner13, spinner14, spinner15,
			spinner16, spinner17, spinner18, spinner19, spinner20, spinner21,
			spinner22, spinner23, spinner24, spinner25, spinner26, spinner27,
			spinner28, spinner29, spinner30,

			spinner11_2, spinner12_2, spinner13_2, spinner14_2, spinner15_2,
			spinner16_2, spinner17_2, spinner18_2, spinner19_2, spinner20_2,
			spinner21_2, spinner22_2, spinner23_2, spinner24_2, spinner25_2,
			spinner26_2, spinner27_2, spinner28_2, spinner29_2, spinner30_2,

			spinner11_3, spinner12_3, spinner13_3, spinner14_3, spinner15_3,
			spinner16_3, spinner17_3, spinner18_3, spinner19_3, spinner20_3,
			spinner21_3, spinner22_3, spinner23_3, spinner24_3, spinner25_3,
			spinner26_3, spinner27_3, spinner28_3, spinner29_3, spinner30_3,

			spinner11_4, spinner12_4, spinner13_4, spinner14_4, spinner15_4,
			spinner16_4, spinner17_4, spinner18_4, spinner19_4, spinner20_4,
			spinner21_4, spinner22_4, spinner23_4, spinner24_4, spinner25_4,
			spinner26_4, spinner27_4, spinner28_4, spinner29_4, spinner30_4,

			spinner11_5, spinner12_5, spinner13_5, spinner14_5, spinner15_5,
			spinner16_5, spinner17_5, spinner18_5, spinner19_5, spinner20_5,
			spinner21_5, spinner22_5, spinner23_5, spinner24_5, spinner25_5,
			spinner26_5, spinner27_5, spinner28_5, spinner29_5, spinner30_5,

			spinner11_6, spinner12_6, spinner13_6, spinner14_6, spinner15_6,
			spinner16_6, spinner17_6, spinner18_6, spinner19_6, spinner20_6,
			spinner21_6, spinner22_6, spinner23_6, spinner24_6, spinner25_6,
			spinner26_6, spinner27_6, spinner28_6, spinner29_6, spinner30_6,

			spinner11_7, spinner12_7, spinner13_7, spinner14_7, spinner15_7,
			spinner16_7, spinner17_7, spinner18_7, spinner19_7, spinner20_7,
			spinner21_7, spinner22_7, spinner23_7, spinner24_7, spinner25_7,
			spinner26_7, spinner27_7, spinner28_7, spinner29_7, spinner30_7,

			spinner11_8, spinner12_8, spinner13_8, spinner14_8, spinner15_8,
			spinner16_8, spinner17_8, spinner18_8, spinner19_8, spinner20_8,
			spinner21_8, spinner22_8, spinner23_8, spinner24_8, spinner25_8,
			spinner26_8, spinner27_8, spinner28_8, spinner29_8, spinner30_8;

	ArrayAdapter<String> dataAdapter_bires, dataAdapter_anapsiktika,
			dataAdapter_tsai, dataAdapter_ouza_tsipoura, dataAdapter_krasia,
			dataAdapter_kafedes, dataAdapter_trofima, dataAdapter_ouiskia,
			dataAdapter_vodka, dataAdapter_gin, dataAdapter_tequila,
			dataAdapter_rum, dataAdapter_cognaq, dataAdapter_liker,
			dataAdapter_ylika, dataAdapter_frouta_lax, dataAdapter_kreatika,
			dataAdapter_tirokomika, dataAdapter_sinodeutika,
			dataAdapter_pagota;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_update_screen_tim);

		Locale locale = new Locale("US");
		Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		getBaseContext().getResources().updateConfiguration(config,
				getBaseContext().getResources().getDisplayMetrics());

		spinner = (Spinner) findViewById(R.id.Spinner_Eponimias);
		spinner.setOnItemSelectedListener(this);

		spinner11 = (Spinner) findViewById(R.id.spinner11);
		spinner11.setOnItemSelectedListener(this);
		spinner12 = (Spinner) findViewById(R.id.spinner12);
		spinner12.setOnItemSelectedListener(this);
		spinner13 = (Spinner) findViewById(R.id.spinner13);
		spinner13.setOnItemSelectedListener(this);
		spinner14 = (Spinner) findViewById(R.id.spinner14);
		spinner14.setOnItemSelectedListener(this);
		spinner15 = (Spinner) findViewById(R.id.spinner15);
		spinner15.setOnItemSelectedListener(this);
		spinner16 = (Spinner) findViewById(R.id.spinner16);
		spinner16.setOnItemSelectedListener(this);
		spinner17 = (Spinner) findViewById(R.id.spinner17);
		spinner17.setOnItemSelectedListener(this);
		spinner18 = (Spinner) findViewById(R.id.spinner18);
		spinner18.setOnItemSelectedListener(this);
		spinner19 = (Spinner) findViewById(R.id.spinner19);
		spinner19.setOnItemSelectedListener(this);
		spinner20 = (Spinner) findViewById(R.id.spinner20);
		spinner20.setOnItemSelectedListener(this);
		spinner21 = (Spinner) findViewById(R.id.spinner21);
		spinner21.setOnItemSelectedListener(this);
		spinner22 = (Spinner) findViewById(R.id.spinner22);
		spinner22.setOnItemSelectedListener(this);
		spinner23 = (Spinner) findViewById(R.id.spinner23);
		spinner23.setOnItemSelectedListener(this);
		spinner24 = (Spinner) findViewById(R.id.spinner24);
		spinner24.setOnItemSelectedListener(this);
		spinner25 = (Spinner) findViewById(R.id.spinner25);
		spinner25.setOnItemSelectedListener(this);
		spinner26 = (Spinner) findViewById(R.id.spinner26);
		spinner26.setOnItemSelectedListener(this);
		spinner27 = (Spinner) findViewById(R.id.spinner27);
		spinner27.setOnItemSelectedListener(this);
		spinner28 = (Spinner) findViewById(R.id.spinner28);
		spinner28.setOnItemSelectedListener(this);
		spinner29 = (Spinner) findViewById(R.id.spinner29);
		spinner29.setOnItemSelectedListener(this);
		spinner30 = (Spinner) findViewById(R.id.spinner30);
		spinner30.setOnItemSelectedListener(this);

		spinner11_2 = (Spinner) findViewById(R.id.spinner11_2);
		spinner11_2.setOnItemSelectedListener(this);
		spinner12_2 = (Spinner) findViewById(R.id.spinner12_2);
		spinner12_2.setOnItemSelectedListener(this);
		spinner13_2 = (Spinner) findViewById(R.id.spinner13_2);
		spinner13_2.setOnItemSelectedListener(this);
		spinner14_2 = (Spinner) findViewById(R.id.spinner14_2);
		spinner14_2.setOnItemSelectedListener(this);
		spinner15_2 = (Spinner) findViewById(R.id.spinner15_2);
		spinner15_2.setOnItemSelectedListener(this);
		spinner16_2 = (Spinner) findViewById(R.id.spinner16_2);
		spinner16_2.setOnItemSelectedListener(this);
		spinner17_2 = (Spinner) findViewById(R.id.spinner17_2);
		spinner17_2.setOnItemSelectedListener(this);
		spinner18_2 = (Spinner) findViewById(R.id.spinner18_2);
		spinner18_2.setOnItemSelectedListener(this);
		spinner19_2 = (Spinner) findViewById(R.id.spinner19_2);
		spinner19_2.setOnItemSelectedListener(this);
		spinner20_2 = (Spinner) findViewById(R.id.spinner20_2);
		spinner20_2.setOnItemSelectedListener(this);
		spinner21_2 = (Spinner) findViewById(R.id.spinner21_2);
		spinner21_2.setOnItemSelectedListener(this);
		spinner22_2 = (Spinner) findViewById(R.id.spinner22_2);
		spinner22_2.setOnItemSelectedListener(this);
		spinner23_2 = (Spinner) findViewById(R.id.spinner23_2);
		spinner23_2.setOnItemSelectedListener(this);
		spinner24_2 = (Spinner) findViewById(R.id.spinner24_2);
		spinner24_2.setOnItemSelectedListener(this);
		spinner25_2 = (Spinner) findViewById(R.id.spinner25_2);
		spinner25_2.setOnItemSelectedListener(this);
		spinner26_2 = (Spinner) findViewById(R.id.spinner26_2);
		spinner26_2.setOnItemSelectedListener(this);
		spinner27_2 = (Spinner) findViewById(R.id.spinner27_2);
		spinner27_2.setOnItemSelectedListener(this);
		spinner28_2 = (Spinner) findViewById(R.id.spinner28_2);
		spinner28_2.setOnItemSelectedListener(this);
		spinner29_2 = (Spinner) findViewById(R.id.spinner29_2);
		spinner29_2.setOnItemSelectedListener(this);
		spinner30_2 = (Spinner) findViewById(R.id.spinner30_2);
		spinner30_2.setOnItemSelectedListener(this);

		spinner11_3 = (Spinner) findViewById(R.id.spinner11_3);
		spinner11_3.setOnItemSelectedListener(this);
		spinner12_3 = (Spinner) findViewById(R.id.spinner12_3);
		spinner12_3.setOnItemSelectedListener(this);
		spinner13_3 = (Spinner) findViewById(R.id.spinner13_3);
		spinner13_3.setOnItemSelectedListener(this);
		spinner14_3 = (Spinner) findViewById(R.id.spinner14_3);
		spinner14_3.setOnItemSelectedListener(this);
		spinner15_3 = (Spinner) findViewById(R.id.spinner15_3);
		spinner15_3.setOnItemSelectedListener(this);
		spinner16_3 = (Spinner) findViewById(R.id.spinner16_3);
		spinner16_3.setOnItemSelectedListener(this);
		spinner17_3 = (Spinner) findViewById(R.id.spinner17_3);
		spinner17_3.setOnItemSelectedListener(this);
		spinner18_3 = (Spinner) findViewById(R.id.spinner18_3);
		spinner18_3.setOnItemSelectedListener(this);
		spinner19_3 = (Spinner) findViewById(R.id.spinner19_3);
		spinner19_3.setOnItemSelectedListener(this);
		spinner20_3 = (Spinner) findViewById(R.id.spinner20_3);
		spinner20_3.setOnItemSelectedListener(this);
		spinner21_3 = (Spinner) findViewById(R.id.spinner21_3);
		spinner21_3.setOnItemSelectedListener(this);
		spinner22_3 = (Spinner) findViewById(R.id.spinner22_3);
		spinner22_3.setOnItemSelectedListener(this);
		spinner23_3 = (Spinner) findViewById(R.id.spinner23_3);
		spinner23_3.setOnItemSelectedListener(this);
		spinner24_3 = (Spinner) findViewById(R.id.spinner24_3);
		spinner24_3.setOnItemSelectedListener(this);
		spinner25_3 = (Spinner) findViewById(R.id.spinner25_3);
		spinner25_3.setOnItemSelectedListener(this);
		spinner26_3 = (Spinner) findViewById(R.id.spinner26_3);
		spinner26_3.setOnItemSelectedListener(this);
		spinner27_3 = (Spinner) findViewById(R.id.spinner27_3);
		spinner27_3.setOnItemSelectedListener(this);
		spinner28_3 = (Spinner) findViewById(R.id.spinner28_3);
		spinner28_3.setOnItemSelectedListener(this);
		spinner29_3 = (Spinner) findViewById(R.id.spinner29_3);
		spinner29_3.setOnItemSelectedListener(this);
		spinner30_3 = (Spinner) findViewById(R.id.spinner30_3);
		spinner30_3.setOnItemSelectedListener(this);

		spinner11_4 = (Spinner) findViewById(R.id.spinner11_4);
		spinner11_4.setOnItemSelectedListener(this);
		spinner12_4 = (Spinner) findViewById(R.id.spinner12_4);
		spinner12_4.setOnItemSelectedListener(this);
		spinner13_4 = (Spinner) findViewById(R.id.spinner13_4);
		spinner13_4.setOnItemSelectedListener(this);
		spinner14_4 = (Spinner) findViewById(R.id.spinner14_4);
		spinner14_4.setOnItemSelectedListener(this);
		spinner15_4 = (Spinner) findViewById(R.id.spinner15_4);
		spinner15_4.setOnItemSelectedListener(this);
		spinner16_4 = (Spinner) findViewById(R.id.spinner16_4);
		spinner16_4.setOnItemSelectedListener(this);
		spinner17_4 = (Spinner) findViewById(R.id.spinner17_4);
		spinner17_4.setOnItemSelectedListener(this);
		spinner18_4 = (Spinner) findViewById(R.id.spinner18_4);
		spinner18_4.setOnItemSelectedListener(this);
		spinner19_4 = (Spinner) findViewById(R.id.spinner19_4);
		spinner19_4.setOnItemSelectedListener(this);
		spinner20_4 = (Spinner) findViewById(R.id.spinner20_4);
		spinner20_4.setOnItemSelectedListener(this);
		spinner21_4 = (Spinner) findViewById(R.id.spinner21_4);
		spinner21_4.setOnItemSelectedListener(this);
		spinner22_4 = (Spinner) findViewById(R.id.spinner22_4);
		spinner22_4.setOnItemSelectedListener(this);
		spinner23_4 = (Spinner) findViewById(R.id.spinner23_4);
		spinner23_4.setOnItemSelectedListener(this);
		spinner24_4 = (Spinner) findViewById(R.id.spinner24_4);
		spinner24_4.setOnItemSelectedListener(this);
		spinner25_4 = (Spinner) findViewById(R.id.spinner25_4);
		spinner25_4.setOnItemSelectedListener(this);
		spinner26_4 = (Spinner) findViewById(R.id.spinner26_4);
		spinner26_4.setOnItemSelectedListener(this);
		spinner27_4 = (Spinner) findViewById(R.id.spinner27_4);
		spinner27_4.setOnItemSelectedListener(this);
		spinner28_4 = (Spinner) findViewById(R.id.spinner28_4);
		spinner28_4.setOnItemSelectedListener(this);
		spinner29_4 = (Spinner) findViewById(R.id.spinner29_4);
		spinner29_4.setOnItemSelectedListener(this);
		spinner30_4 = (Spinner) findViewById(R.id.spinner30_4);
		spinner30_4.setOnItemSelectedListener(this);

		spinner11_5 = (Spinner) findViewById(R.id.spinner11_5);
		spinner11_5.setOnItemSelectedListener(this);
		spinner12_5 = (Spinner) findViewById(R.id.spinner12_5);
		spinner12_5.setOnItemSelectedListener(this);
		spinner13_5 = (Spinner) findViewById(R.id.spinner13_5);
		spinner13_5.setOnItemSelectedListener(this);
		spinner14_5 = (Spinner) findViewById(R.id.spinner14_5);
		spinner14_5.setOnItemSelectedListener(this);
		spinner15_5 = (Spinner) findViewById(R.id.spinner15_5);
		spinner15_5.setOnItemSelectedListener(this);
		spinner16_5 = (Spinner) findViewById(R.id.spinner16_5);
		spinner16_5.setOnItemSelectedListener(this);
		spinner17_5 = (Spinner) findViewById(R.id.spinner17_5);
		spinner17_5.setOnItemSelectedListener(this);
		spinner18_5 = (Spinner) findViewById(R.id.spinner18_5);
		spinner18_5.setOnItemSelectedListener(this);
		spinner19_5 = (Spinner) findViewById(R.id.spinner19_5);
		spinner19_5.setOnItemSelectedListener(this);
		spinner20_5 = (Spinner) findViewById(R.id.spinner20_5);
		spinner20_5.setOnItemSelectedListener(this);
		spinner21_5 = (Spinner) findViewById(R.id.spinner21_5);
		spinner21_5.setOnItemSelectedListener(this);
		spinner22_5 = (Spinner) findViewById(R.id.spinner22_5);
		spinner22_5.setOnItemSelectedListener(this);
		spinner23_5 = (Spinner) findViewById(R.id.spinner23_5);
		spinner23_5.setOnItemSelectedListener(this);
		spinner24_5 = (Spinner) findViewById(R.id.spinner24_5);
		spinner24_5.setOnItemSelectedListener(this);
		spinner25_5 = (Spinner) findViewById(R.id.spinner25_5);
		spinner25_5.setOnItemSelectedListener(this);
		spinner26_5 = (Spinner) findViewById(R.id.spinner26_5);
		spinner26_5.setOnItemSelectedListener(this);
		spinner27_5 = (Spinner) findViewById(R.id.spinner27_5);
		spinner27_5.setOnItemSelectedListener(this);
		spinner28_5 = (Spinner) findViewById(R.id.spinner28_5);
		spinner28_5.setOnItemSelectedListener(this);
		spinner29_5 = (Spinner) findViewById(R.id.spinner29_5);
		spinner29_5.setOnItemSelectedListener(this);
		spinner30_5 = (Spinner) findViewById(R.id.spinner30_5);
		spinner30_5.setOnItemSelectedListener(this);

		spinner11_6 = (Spinner) findViewById(R.id.spinner11_6);
		spinner11_6.setOnItemSelectedListener(this);
		spinner12_6 = (Spinner) findViewById(R.id.spinner12_6);
		spinner12_6.setOnItemSelectedListener(this);
		spinner13_6 = (Spinner) findViewById(R.id.spinner13_6);
		spinner13_6.setOnItemSelectedListener(this);
		spinner14_6 = (Spinner) findViewById(R.id.spinner14_6);
		spinner14_6.setOnItemSelectedListener(this);
		spinner15_6 = (Spinner) findViewById(R.id.spinner15_6);
		spinner15_6.setOnItemSelectedListener(this);
		spinner16_6 = (Spinner) findViewById(R.id.spinner16_6);
		spinner16_6.setOnItemSelectedListener(this);
		spinner17_6 = (Spinner) findViewById(R.id.spinner17_6);
		spinner17_6.setOnItemSelectedListener(this);
		spinner18_6 = (Spinner) findViewById(R.id.spinner18_6);
		spinner18_6.setOnItemSelectedListener(this);
		spinner19_6 = (Spinner) findViewById(R.id.spinner19_6);
		spinner19_6.setOnItemSelectedListener(this);
		spinner20_6 = (Spinner) findViewById(R.id.spinner20_6);
		spinner20_6.setOnItemSelectedListener(this);
		spinner21_6 = (Spinner) findViewById(R.id.spinner21_6);
		spinner21_6.setOnItemSelectedListener(this);
		spinner22_6 = (Spinner) findViewById(R.id.spinner22_6);
		spinner22_6.setOnItemSelectedListener(this);
		spinner23_6 = (Spinner) findViewById(R.id.spinner23_6);
		spinner23_6.setOnItemSelectedListener(this);
		spinner24_6 = (Spinner) findViewById(R.id.spinner24_6);
		spinner24_6.setOnItemSelectedListener(this);
		spinner25_6 = (Spinner) findViewById(R.id.spinner25_6);
		spinner25_6.setOnItemSelectedListener(this);
		spinner26_6 = (Spinner) findViewById(R.id.spinner26_6);
		spinner26_6.setOnItemSelectedListener(this);
		spinner27_6 = (Spinner) findViewById(R.id.spinner27_6);
		spinner27_6.setOnItemSelectedListener(this);
		spinner28_6 = (Spinner) findViewById(R.id.spinner28_6);
		spinner28_6.setOnItemSelectedListener(this);
		spinner29_6 = (Spinner) findViewById(R.id.spinner29_6);
		spinner29_6.setOnItemSelectedListener(this);
		spinner30_6 = (Spinner) findViewById(R.id.spinner30_6);
		spinner30_6.setOnItemSelectedListener(this);

		spinner11_7 = (Spinner) findViewById(R.id.spinner11_7);
		spinner11_7.setOnItemSelectedListener(this);
		spinner12_7 = (Spinner) findViewById(R.id.spinner12_7);
		spinner12_7.setOnItemSelectedListener(this);
		spinner13_7 = (Spinner) findViewById(R.id.spinner13_7);
		spinner13_7.setOnItemSelectedListener(this);
		spinner14_7 = (Spinner) findViewById(R.id.spinner14_7);
		spinner14_7.setOnItemSelectedListener(this);
		spinner15_7 = (Spinner) findViewById(R.id.spinner15_7);
		spinner15_7.setOnItemSelectedListener(this);
		spinner16_7 = (Spinner) findViewById(R.id.spinner16_7);
		spinner16_7.setOnItemSelectedListener(this);
		spinner17_7 = (Spinner) findViewById(R.id.spinner17_7);
		spinner17_7.setOnItemSelectedListener(this);
		spinner18_7 = (Spinner) findViewById(R.id.spinner18_7);
		spinner18_7.setOnItemSelectedListener(this);
		spinner19_7 = (Spinner) findViewById(R.id.spinner19_7);
		spinner19_7.setOnItemSelectedListener(this);
		spinner20_7 = (Spinner) findViewById(R.id.spinner20_7);
		spinner20_7.setOnItemSelectedListener(this);
		spinner21_7 = (Spinner) findViewById(R.id.spinner21_7);
		spinner21_7.setOnItemSelectedListener(this);
		spinner22_7 = (Spinner) findViewById(R.id.spinner22_7);
		spinner22_7.setOnItemSelectedListener(this);
		spinner23_7 = (Spinner) findViewById(R.id.spinner23_7);
		spinner23_7.setOnItemSelectedListener(this);
		spinner24_7 = (Spinner) findViewById(R.id.spinner24_7);
		spinner24_7.setOnItemSelectedListener(this);
		spinner25_7 = (Spinner) findViewById(R.id.spinner25_7);
		spinner25_7.setOnItemSelectedListener(this);
		spinner26_7 = (Spinner) findViewById(R.id.spinner26_7);
		spinner26_7.setOnItemSelectedListener(this);
		spinner27_7 = (Spinner) findViewById(R.id.spinner27_7);
		spinner27_7.setOnItemSelectedListener(this);
		spinner28_7 = (Spinner) findViewById(R.id.spinner28_7);
		spinner28_7.setOnItemSelectedListener(this);
		spinner29_7 = (Spinner) findViewById(R.id.spinner29_7);
		spinner29_7.setOnItemSelectedListener(this);
		spinner30_7 = (Spinner) findViewById(R.id.spinner30_7);
		spinner30_7.setOnItemSelectedListener(this);

		spinner11_8 = (Spinner) findViewById(R.id.spinner11_8);
		spinner11_8.setOnItemSelectedListener(this);
		spinner12_8 = (Spinner) findViewById(R.id.spinner12_8);
		spinner12_8.setOnItemSelectedListener(this);
		spinner13_8 = (Spinner) findViewById(R.id.spinner13_8);
		spinner13_8.setOnItemSelectedListener(this);
		spinner14_8 = (Spinner) findViewById(R.id.spinner14_8);
		spinner14_8.setOnItemSelectedListener(this);
		spinner15_8 = (Spinner) findViewById(R.id.spinner15_8);
		spinner15_8.setOnItemSelectedListener(this);
		spinner16_8 = (Spinner) findViewById(R.id.spinner16_8);
		spinner16_8.setOnItemSelectedListener(this);
		spinner17_8 = (Spinner) findViewById(R.id.spinner17_8);
		spinner17_8.setOnItemSelectedListener(this);
		spinner18_8 = (Spinner) findViewById(R.id.spinner18_8);
		spinner18_8.setOnItemSelectedListener(this);
		spinner19_8 = (Spinner) findViewById(R.id.spinner19_8);
		spinner19_8.setOnItemSelectedListener(this);
		spinner20_8 = (Spinner) findViewById(R.id.spinner20_8);
		spinner20_8.setOnItemSelectedListener(this);
		spinner21_8 = (Spinner) findViewById(R.id.spinner21_8);
		spinner21_8.setOnItemSelectedListener(this);
		spinner22_8 = (Spinner) findViewById(R.id.spinner22_8);
		spinner22_8.setOnItemSelectedListener(this);
		spinner23_8 = (Spinner) findViewById(R.id.spinner23_8);
		spinner23_8.setOnItemSelectedListener(this);
		spinner24_8 = (Spinner) findViewById(R.id.spinner24_8);
		spinner24_8.setOnItemSelectedListener(this);
		spinner25_8 = (Spinner) findViewById(R.id.spinner25_8);
		spinner25_8.setOnItemSelectedListener(this);
		spinner26_8 = (Spinner) findViewById(R.id.spinner26_8);
		spinner26_8.setOnItemSelectedListener(this);
		spinner27_8 = (Spinner) findViewById(R.id.spinner27_8);
		spinner27_8.setOnItemSelectedListener(this);
		spinner28_8 = (Spinner) findViewById(R.id.spinner28_8);
		spinner28_8.setOnItemSelectedListener(this);
		spinner29_8 = (Spinner) findViewById(R.id.spinner29_8);
		spinner29_8.setOnItemSelectedListener(this);
		spinner30_8 = (Spinner) findViewById(R.id.spinner30_8);
		spinner30_8.setOnItemSelectedListener(this);

		// Spinner Drop down elements
		List<String> category_bires = new ArrayList<String>(); 
		category_bires.add("ΜΠΥΡΕΣ");
		category_bires.add("fix");
		category_bires.add("fix dark");
		category_bires.add("κάϊσερ");
		category_bires.add("κάϊσερ blonde");
		category_bires.add("carlsberg");
		category_bires.add("corona");
		category_bires.add("kilkeny");
		category_bires.add("fischer");
		category_bires.add("somersby");
		category_bires.add("bud");
		category_bires.add("μύθος");
		category_bires.add("βόρεια pilsner");
		category_bires.add("βόρεια india");
		category_bires.add("heineken");
		category_bires.add("amstel");
		category_bires.add("amstel λεμόνι");
		category_bires.add("mcfarland");
		category_bires.add("stella");
		category_bires.add("erdinger");
		category_bires.add("paulaner");
		category_bires.add("chimay");
		category_bires.add("buckler");
		category_bires.add("desperados");
		category_bires.add("estrella");
		category_bires.add("volkan");
		category_bires.add("volkan black");
		category_bires.add("fix βαρέλι");
		category_bires.add("κάϊσερ βαρέλι");
		category_bires.add("μύθος βαρέλι");
		category_bires.add("άλφα βαρέλι");
		category_bires.add("fischer βαρέλι");
		
		String title_bires = category_bires.get(0);
		category_bires.remove(0);
		Collections.sort(category_bires);
		category_bires.add(0, title_bires);

		List<String> category_anapsiktika = new ArrayList<String>();
		category_anapsiktika.add("ΑΝΑΨΥΚΤΙΚΑ-ΧΥΜΟΙ");
		category_anapsiktika.add("Γ.coca cola");
		category_anapsiktika.add("Γ.coca cola light");
		category_anapsiktika.add("Γ.coca cola zero");
		category_anapsiktika.add("Γ.πορτοκαλάδα");
		category_anapsiktika.add("Γ.λεμονάδα");
		category_anapsiktika.add("Γ.τόνικ");
		category_anapsiktika.add("Γ.σόδα");
		category_anapsiktika.add("Γ.sprite");
		category_anapsiktika.add("Perrier");
		category_anapsiktika.add("Π.coca cola");
		category_anapsiktika.add("Π.coca cola light");
		category_anapsiktika.add("Π.coca cola zero");
		category_anapsiktika.add("Π.sprite");
		category_anapsiktika.add("Π.πορτοκαλάδα");
		category_anapsiktika.add("Π.λεμονάδα");
		category_anapsiktika.add("Π.τόνικ");
		category_anapsiktika.add("Π.σόδα");
		category_anapsiktika.add("Π.tuborg");
		category_anapsiktika.add("Π.φράουλα");
		category_anapsiktika.add("χυμό πορτοκάλι");
		category_anapsiktika.add("χυμό ροδάκινο");
		category_anapsiktika.add("χυμό μήλο");
		category_anapsiktika.add("χυμό ρόδι");
		category_anapsiktika.add("χυμό κοκτέϊλ");
		category_anapsiktika.add("χυμό μπανάνα");
		category_anapsiktika.add("χυμό ανανά");
		category_anapsiktika.add("χυμό βύσσινο");
		category_anapsiktika.add("χυμό κρανμπερι");
		category_anapsiktika.add("χυμό λεμόνι");
		category_anapsiktika.add("χυμό ανάμεικτο");
		category_anapsiktika.add("χυμό φράουλα");
		
		String title_anapsiktika = category_anapsiktika.get(0);
		category_anapsiktika.remove(0);
		Collections.sort(category_anapsiktika);
		category_anapsiktika.add(0, title_anapsiktika);

		List<String> category_tsai = new ArrayList<String>();
		category_tsai.add("ΤΣΑΙ");
		category_tsai.add("τσάι απλό");
		category_tsai.add("τσάι ροδάκινο");
		category_tsai.add("τσάι πράσινο");
		category_tsai.add("τσάι καραμέλα");
		category_tsai.add("τσάι λεμόνι");
		category_tsai.add("τσάι φράουλα");
		category_tsai.add("τσάι βανίλλια");
		category_tsai.add("τσάι μαύρο");
		category_tsai.add("τσάι βότανα");
		category_tsai.add("χαμομήλι");
		
		String title_tsai = category_tsai.get(0);
		category_tsai.remove(0);
		Collections.sort(category_tsai);
		category_tsai.add(0, title_tsai);

		List<String> category_pagota = new ArrayList<String>();
		category_pagota.add("ΠΑΓΩΤΑ");
		category_pagota.add("παγωτό βανίλια");
		category_pagota.add("παγωτό σοκολάτα");
		category_pagota.add("παγωτό καραμέλα");
		category_pagota.add("παγωτό φράουλα");
		category_pagota.add("παγωτό μπανάνα");
		category_pagota.add("παγωτό μόκα");
		category_pagota.add("παγωτό στρατσιατέλα");
		category_pagota.add("παγωτό λεμόνι");
		
		String title_pagota = category_pagota.get(0);
		category_pagota.remove(0);
		Collections.sort(category_pagota);
		category_pagota.add(0, title_pagota);

		List<String> category_ouza_tsipoura = new ArrayList<String>();
		category_ouza_tsipoura.add("ΟΥΖΑ-ΤΣΙΠΟΥΡΑ");
		category_ouza_tsipoura.add("Αλεξανδρίδη(100ml)");
		category_ouza_tsipoura.add("φραγκουλά(100ml)");
		category_ouza_tsipoura.add("Κουλάς(100ml)");
		category_ouza_tsipoura.add("Μπέη(100ml)");
		category_ouza_tsipoura.add("Πεντάρι(100ml)");
		category_ouza_tsipoura.add("Αλεξανδρίδη(200ml)");
		category_ouza_tsipoura.add("Φραγκουλά(200ml)");
		category_ouza_tsipoura.add("Μπεσίρη(200ml)");
		category_ouza_tsipoura.add("Κουλάς(200ml)");
		category_ouza_tsipoura.add("Μπέη(200ml)");
		category_ouza_tsipoura.add("Πεντάρι(200ml)");
		category_ouza_tsipoura.add("T.Γιώμα Πέντ(200ml)");
		category_ouza_tsipoura.add("T.Αλεξανδρίδη(200ml)");
		category_ouza_tsipoura.add("T.Αγιονέρι(χύμα)");
		category_ouza_tsipoura.add("T.Βλαδίκα(χύμα)");
		
		String title_ouza_tsipoura = category_ouza_tsipoura.get(0);
		category_ouza_tsipoura.remove(0);
		Collections.sort(category_ouza_tsipoura);
		category_ouza_tsipoura.add(0, title_ouza_tsipoura);

		List<String> category_krasia = new ArrayList<String>(); 
		category_krasia.add("ΚΡΑΣΙΑ-ΣΑΜΠΑΝΙΕΣ");
		category_krasia.add("Λ.Ντάμα κούπα");
		category_krasia.add("Λ.Χρυσός Λέων");
		category_krasia.add("Λ.Μικρός");
		category_krasia.add("Λ.Τέχνη Αλυπίας");
		category_krasia.add("Λ.Τέχνη Μαλαγού");
		category_krasia.add("Λ.Βιβλία");
		category_krasia.add("Λ.Αγκαθιά");
		category_krasia.add("Λ.Μαγική πλαγιά");
		category_krasia.add("Λ.Ευπορία");
		category_krasia.add("Λ.Isari");
		category_krasia.add("Λ.Cirinon");
		category_krasia.add("Λ.Μοσχοφίλερο μικρό");
		category_krasia.add("Λ.Μοσχοφίλερο μεγάλο");
		category_krasia.add("Λ.Ρωμαλίδης");
		category_krasia.add("Λ.Μπίσκας");
		category_krasia.add("Λ.Ημίγλυκο");
		category_krasia.add("Λ.Sangria");
		category_krasia.add("Λ.Γεροβασιλείου");
		category_krasia.add("Λ.Chardonnay Γεροβασιλείου");
		category_krasia.add("Λ.Αμέθυστος");
		category_krasia.add("Λ.Thema Παυλίδη");
		category_krasia.add("Λ.Κτήμα Άλφα");
		category_krasia.add("Λ.Μελισσόπετρα");
		category_krasia.add("Λ.Μαγικό Βουνό");
		category_krasia.add("Λ.Κτήμα Αβαντίς");
		category_krasia.add("Λ.Αβαντίς Charisma");
		category_krasia.add("Λ.Chateau Ν.Λαζαρίδη");
		category_krasia.add("Λ.Χατζηβαρύτη Γουμένισσα");
		category_krasia.add("Λ.Visanto");
		category_krasia.add("Λ.Sandeman Porto");
		category_krasia.add("Κ.Βόρεια Γη");
		category_krasia.add("Κ.Cirinon");
		category_krasia.add("Κ.Idonida");
		category_krasia.add("Κ.Isari");
		category_krasia.add("Κ.Τέχνη Αλυπίας");
		category_krasia.add("Κ.Βιβλία");
		category_krasia.add("Κ.Chateau");
		category_krasia.add("Κ.Ρήγας κούπα");
		category_krasia.add("Κ.Μαγικό");
		category_krasia.add("Κ.Μαύρος κύκνος");
		category_krasia.add("Κ.Μικρός");
		category_krasia.add("Κ.Αγιωργίτικο μικρό");
		category_krasia.add("Κ.Ημίγλυκο μελίρρυτο μικρό");
		category_krasia.add("Κ.Ημίγλυκο 750ML");
		category_krasia.add("Κ.Sangria");
		category_krasia.add("Κ.Γεροβασιλείου");
		category_krasia.add("Κ.Chardonnay Γεροβασιλείου");
		category_krasia.add("Κ.Αμέθυστος");
		category_krasia.add("Κ.Thema Παυλίδη");
		category_krasia.add("Κ.Κτήμα Άλφα");
		category_krasia.add("Κ.Μελισσόπετρα");
		category_krasia.add("Κ.Μαγικό Βουνό");
		category_krasia.add("Κ.Κτήμα Αβαντίς");
		category_krasia.add("Κ.Αβαντίς Charisma");
		category_krasia.add("Κ.Chateau Ν.Λαζαρίδη");
		category_krasia.add("Κ.Χατζηβαρύτη Γουμένισσα");
		category_krasia.add("Κ.Visanto");
		category_krasia.add("Κ.Sandeman Porto");
		category_krasia.add("Ρ.Τέχνη Αλυπίας");
		category_krasia.add("Ρ.Σκέρτσο");
		category_krasia.add("Ρ.Βιβλία");
		category_krasia.add("Ρ.Μικρός");
		category_krasia.add("Ρ.Λαλίκος");
		category_krasia.add("Ρ.Cirinon");
		category_krasia.add("Ρ.Γεροβασιλείου");
		category_krasia.add("Ρ.Thema Παυλίδη");
		category_krasia.add("Ρ.Κτήμα Άλφα");
		category_krasia.add("Ρ.Μελισσόπετρα");
		category_krasia.add("Ρ.Μαγικό Βουνό");
		category_krasia.add("Ρ.Κτήμα Αβαντίς");
		category_krasia.add("Ρ.Αβαντίς Charisma");
		category_krasia.add("Ρ.Chateau Ν.Λαζαρίδη");
		category_krasia.add("Ρ.Χατζηβαρύτη Γουμένισσα");
		category_krasia.add("Ρ.Visanto");
		category_krasia.add("Ξινόμαυρο Σκατζόχοιρος άλφα");
		category_krasia.add("Asti Martini");
		category_krasia.add("Asti μικρή");
		category_krasia.add("Gordon Rouge");
		category_krasia.add("Moschato D Asti");
		category_krasia.add("Dom Perignon");
		category_krasia.add("Moet et Chandon");
		category_krasia.add("Veuve Clickuot");
		category_krasia.add("Veuve aperitif");
		
		String title_krasia = category_krasia.get(0);
		category_krasia.remove(0);
		Collections.sort(category_krasia);
		category_krasia.add(0, title_krasia);

		List<String> category_kafedes = new ArrayList<String>();
		category_kafedes.add("ΚΑΦΕΔΕΣ-ΣΟΚΟΛ");
		category_kafedes.add("Εσπρέσσο");
		category_kafedes.add("Εσπρέσσο.ντεκάφ");
		category_kafedes.add("σοκολάτα ζεστή");
		category_kafedes.add("σοκολάτα κρύα");
		category_kafedes.add("σοκολάτα oreo");
		category_kafedes.add("σοκολάτα lacta");
		category_kafedes.add("στικ ζάχαρη");
		category_kafedes.add("στικ μάυρη ζαχ");
		category_kafedes.add("ζαχαρίνες");
		category_kafedes.add("νόβο μακράς");
		category_kafedes.add("νόβο εβαπορέ");
		category_kafedes.add("φρεντίτο βανίλ.");
		category_kafedes.add("φρεντίτο σοκολ.");
		category_kafedes.add("όρεο");
		category_kafedes.add("σιρόπια");
		category_kafedes.add("Νεσκαφέ");
		category_kafedes.add("Νεσ. ντεκάφ");
		category_kafedes.add("Ζάχαρη κιλού");
		category_kafedes.add("Μαρασκίνο");
		category_kafedes.add("σιρόπι βύσσινο");
		category_kafedes.add("Ελληνικός");
		category_kafedes.add("τρούφα");
		category_kafedes.add("φίλλερ");
		category_kafedes.add("Frio");
		category_kafedes.add("Freddoccino");
		category_kafedes.add("Latin Dance");
		category_kafedes.add("Canderel");
		
		String title_kafedes = category_kafedes.get(0);
		category_kafedes.remove(0);
		Collections.sort(category_kafedes);
		category_kafedes.add(0, title_kafedes);

		List<String> category_trofima = new ArrayList<String>();
		category_trofima.add("ΑΛΛΑ ΤΡΟΦΙΜΑ");
		category_trofima.add("χυμός λεμονιού");
		category_trofima.add("καλαμάρι κατεψυγμένο");
		category_trofima.add("πορτοκάλι γλυκό");
		category_trofima.add("σύκα αποξηραμένα");
		category_trofima.add("ψωμάκια burger");
		category_trofima.add("κάπαρη");
		category_trofima.add("πέννες");
		category_trofima.add("λινγκουϊνι");
		category_trofima.add("κουβερτούρα");
		category_trofima.add("μπασμάζι");
		category_trofima.add("μέλι");
		category_trofima.add("μπαγκετάκια μικρά");
		category_trofima.add("ψωμί τόστ");
		category_trofima.add("καλαμπόκι");
		category_trofima.add("μπαγιάτικο ψωμί για κιμά");
		category_trofima.add("πεστό βασιλικού");
		category_trofima.add("ελαιόλαδο");
		category_trofima.add("σπορέλαιο");
		category_trofima.add("σκουμπρί καπνιστό με ρίγανη");
		category_trofima.add("μπαγκέτα λευκή");
		category_trofima.add("μπαγκέτα μάυρη");
		category_trofima.add("μπαγκετάκι λευκό");
		category_trofima.add("γαρίδες Νο1");
		category_trofima.add("μύδια με κέλυφος");
		category_trofima.add("αυγά");
		category_trofima.add("ψαρονέφρι");
		category_trofima.add("καπνιστός σολωμός");
		category_trofima.add("χαβιάρι");
		category_trofima.add("παπαρδέλες");
		category_trofima.add("αρμπόριο");
		category_trofima.add("μπασμάτι");
		category_trofima.add("soya sause");
		category_trofima.add("μύδια με κέλυφος");
		category_trofima.add("πάγος");
		category_trofima.add("cranberry");
		category_trofima.add("μέλι");
		category_trofima.add("σιρόπι βανίλια");
		category_trofima.add("σιρόπι καραμέλα");
		category_trofima.add("σιρόπι φράουλα");
		category_trofima.add("σιρόπι φουντούκι");
		category_trofima.add("σιρόπι βύσσινο");
		category_trofima.add("σιρόπι καρύδα");
		category_trofima.add("πιτάκια Select");
		
		String title_trofima = category_trofima.get(0);
		category_trofima.remove(0);
		Collections.sort(category_trofima);
		category_trofima.add(0, title_trofima);

		List<String> category_sinodeutika = new ArrayList<String>();
		category_sinodeutika.add("ΣΥΝΟΔΕΥΤΙΚΑ");
		category_sinodeutika.add("πατατάκια");
		category_sinodeutika.add("κουλουράκια");
		category_sinodeutika.add("φυστίκια Αιγίνης");
		category_sinodeutika.add("φιλέ-αμύγλαδο");
		category_sinodeutika.add("φυστίκια");
		category_sinodeutika.add("μαρασκίνο");
		category_sinodeutika.add("μαγιονέζα");
		category_sinodeutika.add("κέτσαπ");
		category_sinodeutika.add("μουστάρδα");
		category_sinodeutika.add("φύλλα Τορτίγιας");
		category_sinodeutika.add("γλυκόξινη σάλτσα");
		category_sinodeutika.add("στικ μουστάρδα");
		category_sinodeutika.add("κριτσίνια πολύσπορα");
		category_sinodeutika.add("κριτσίνια καλαμπόκι");
		category_sinodeutika.add("νερό μικρό");
		category_sinodeutika.add("νερό μεγάλο");
		category_sinodeutika.add("κορπή ανθρακ.");
		
		String title_sinodeutika = category_sinodeutika.get(0);
		category_sinodeutika.remove(0);
		Collections.sort(category_sinodeutika);
		category_sinodeutika.add(0, title_sinodeutika);

		List<String> category_ouiskia = new ArrayList<String>();
		category_ouiskia.add("ΟΥΪΣΚΙ");
		category_ouiskia.add("Johnie");
		category_ouiskia.add("Johnie black");
		category_ouiskia.add("Johnie platinum");
		category_ouiskia.add("Johnie gold");
		category_ouiskia.add("Johnie blue");
		category_ouiskia.add("Johnie green");
		category_ouiskia.add("Dewars");
		category_ouiskia.add("Cutty Sark");
		category_ouiskia.add("Famous");
		category_ouiskia.add("Haig");
		category_ouiskia.add("Ballandines");
		category_ouiskia.add("Bells");
		category_ouiskia.add("Grands");
		category_ouiskia.add("Wild Turkey");
		category_ouiskia.add("Teachers");
		category_ouiskia.add("J&B");
		category_ouiskia.add("Jim Beam");
		category_ouiskia.add("Makers Mark");
		category_ouiskia.add("Four Roses");
		category_ouiskia.add("Canadian");
		category_ouiskia.add("Jameson");
		category_ouiskia.add("Bushmills");
		category_ouiskia.add("Bushmills 10");
		category_ouiskia.add("Comfort");
		category_ouiskia.add("Comfort lime");
		category_ouiskia.add("Tullamore");
		category_ouiskia.add("Jameson 12");
		category_ouiskia.add("Jack");
		category_ouiskia.add("Dimple");
		category_ouiskia.add("Chivas");
		category_ouiskia.add("Cardhu");
		category_ouiskia.add("Cutty 12");
		category_ouiskia.add("Cutty 15");
		category_ouiskia.add("Cutty 18");
		category_ouiskia.add("Glenfiddich");
		category_ouiskia.add("Glenmorangie");
		category_ouiskia.add("Oban");
		category_ouiskia.add("Lagavulin");
		category_ouiskia.add("Macallan");
		category_ouiskia.add("Dalwhinnie");
		category_ouiskia.add("Glenlivet");
		category_ouiskia.add("Talisker");
		category_ouiskia.add("Dalmore");
		category_ouiskia.add("Gragganmore");
		category_ouiskia.add("Caol ila");
		
		String title_ouiskia = category_ouiskia.get(0);
		category_ouiskia.remove(0);
		Collections.sort(category_ouiskia);
		category_ouiskia.add(0, title_ouiskia);

		List<String> category_vodka = new ArrayList<String>();
		category_vodka.add("VODKA");
		category_vodka.add("Smirnoff red");
		category_vodka.add("Smirnoff black");
		category_vodka.add("North");
		category_vodka.add("Ursus");
		category_vodka.add("Stoli");
		category_vodka.add("Absolut");
		category_vodka.add("Finlandia");
		category_vodka.add("Belvedere");
		category_vodka.add("Ketel one");
		category_vodka.add("Grey goose");
		category_vodka.add("Ciroc");
		category_vodka.add("Standar");
		
		String title_vodka = category_vodka.get(0);
		category_vodka.remove(0);
		Collections.sort(category_vodka);
		category_vodka.add(0, title_vodka);

		List<String> category_gin = new ArrayList<String>();
		category_gin.add("GIN");
		category_gin.add("Gordons");
		category_gin.add("Beefeater");
		category_gin.add("Beefeater 24");
		category_gin.add("Bombay");
		category_gin.add("Tanqeauray");
		category_gin.add("Tanqeauray ten");
		category_gin.add("Hendricks");
		
		String title_gin = category_gin.get(0);
		category_gin.remove(0);
		Collections.sort(category_gin);
		category_gin.add(0, title_gin);

		List<String> category_tequila = new ArrayList<String>();
		category_tequila.add("TEQUILA");
		category_tequila.add("Cuervo κίτρινη");
		category_tequila.add("Cuervo λευκή");
		category_tequila.add("Cuervo Black");
		category_tequila.add("Cuervo especial");
		category_tequila.add("Cuervo reserva");
		category_tequila.add("Don julio anejo");
		category_tequila.add("Don julio black");
		category_tequila.add("Don julio reposado");
		category_tequila.add("Herrandura");
		category_tequila.add("Herradura κίτρινη");
		category_tequila.add("Olmeca σοκολάτα");
		category_tequila.add("Olmeca κίτρινη");
		category_tequila.add("Jimador");
		category_tequila.add("Jimador κίτρινη");
		
		String title_tequila = category_tequila.get(0);
		category_tequila.remove(0);
		Collections.sort(category_tequila);
		category_tequila.add(0, title_tequila);

		List<String> category_rum = new ArrayList<String>();	
		category_rum.add("RUM");
		category_rum.add("Bacardi 0,7");
		category_rum.add("Bacardi λίτρο");
		category_rum.add("Havana λευκή");
		category_rum.add("Havana 3 κίτρινη");
		category_rum.add("Havana 5 μάυρη");
		category_rum.add("Havana 7");
		category_rum.add("CT Morgan");
		category_rum.add("Pampero λευκό");
		category_rum.add("Pampero κίτρινο");
		category_rum.add("Varadero");
		category_rum.add("Zacapa");	
		category_rum.add("Cachacha");
		
		String title_rum = category_rum.get(0);
		category_rum.remove(0);
		Collections.sort(category_rum);
		category_rum.add(0, title_rum);

		List<String> category_cognaq = new ArrayList<String>(); 
		category_cognaq.add("COGNAQ");
		category_cognaq.add("Metaxa 5");
		category_cognaq.add("Metaxa 7");
		category_cognaq.add("Courvoisier");
		category_cognaq.add("Benedictine");
		category_cognaq.add("Remi Martin");
		category_cognaq.add("Hennessy xo");
		category_cognaq.add("Hennessy vsop");
		category_cognaq.add("Martel vs");
		category_cognaq.add("Armagnac");
		category_cognaq.add("Calvados");
		
		String title_cognaq = category_cognaq.get(0);
		category_cognaq.remove(0);
		Collections.sort(category_cognaq);
		category_cognaq.add(0, title_cognaq);

		List<String> category_liker = new ArrayList<String>();  
		category_liker.add("ΛΙΚΕΡ-RTD");
		category_liker.add("Pimms");
		category_liker.add("Kahlua");
		category_liker.add("Heering");
		category_liker.add("Grand marnier");
		category_liker.add("Tia maria");
		category_liker.add("Aperol");
		category_liker.add("Jagermeister");
		category_liker.add("Skinos Mastiha");
		category_liker.add("Limoncelo");
		category_liker.add("Menta");
		category_liker.add("Fernet");
		category_liker.add("Batida");
		category_liker.add("Passoa");
		category_liker.add("Pisang");
		category_liker.add("Blue Curacao");
		category_liker.add("Malibu");
		category_liker.add("Lime");
		category_liker.add("Grenandine");
		category_liker.add("Amareto");
		category_liker.add("Grandberry");
		category_liker.add("Baileys");
		category_liker.add("Drambuie");
		category_liker.add("Frangelico");
		category_liker.add("Campari");
		category_liker.add("Martini");
		category_liker.add("Martini rosato");
		category_liker.add("Martini dry");
		category_liker.add("Sambucha kef");
		category_liker.add("Sambucha black");
		category_liker.add("Cointreau");
		category_liker.add("Gordons Space");
		category_liker.add("Red Bull");
		category_liker.add("Shark");
		category_liker.add("ice");
		category_liker.add("breezer");
		
		String title_liker = category_liker.get(0);
		category_liker.remove(0);
		Collections.sort(category_liker);
		category_liker.add(0, title_liker);
		
		List<String> category_ylika = new ArrayList<String>();
		category_ylika.add("ΥΛΙΚΑ");
		category_ylika.add("Χ.Κουζίνας");
		category_ylika.add("Χ.Υγείας επάγγ.");
		category_ylika.add("Βετέξ");
		category_ylika.add("Σφουγγάρια");
		category_ylika.add("Γάντια");
		category_ylika.add("Οδοντογλυφ.");
		category_ylika.add("Σφουγγαρίστρες");
		category_ylika.add("Κοντάρι");
		category_ylika.add("Σκούπα-Φαράσι");
		category_ylika.add("Κουβάς σκουγγ.");
		category_ylika.add("Καλαμάκια Εσπρ.");
		category_ylika.add("Καλαμάκια φραπέ");
		category_ylika.add("Καλαμάκια σοκολάτας");
		category_ylika.add("Υγρό πατωμάτων");
		category_ylika.add("Υγρό τζαμιών");
		category_ylika.add("Υγρό ποτηριών");
		category_ylika.add("Υγρό ίνοξ");
		category_ylika.add("Υγρό λίπη");
		category_ylika.add("Οινόπνευμα");
		category_ylika.add("Αναδευτήρες");
		category_ylika.add("Σακούλες 80Χ1,10");
		category_ylika.add("Σακούλες 65Χ85");
		category_ylika.add("Σακούλες γραφείου");
		category_ylika.add("Σακούλες πάγου");
		category_ylika.add("Χλωρίνη");
		category_ylika.add("Σύρμα");
		category_ylika.add("Χειροπετσέτες");
		category_ylika.add("Αφρός σαπούνι");
		category_ylika.add("Χαρτοπετσέτες");
		category_ylika.add("Κρεμοσάπουνο");
		category_ylika.add("πακέτα delivery");
		category_ylika.add("ποτήρια πλαστικά");
		category_ylika.add("απορυπαντικό πλυντηρίου");
		category_ylika.add("στεγνωτικό");
		category_ylika.add("λαδόκολες");
		category_ylika.add("σακούλες για πακέτο");
		category_ylika.add("φίλτρα γαλλικού");
		category_ylika.add("φίλτρα τσάι");
		category_ylika.add("αποσμυτικά");
		category_ylika.add("χαρτιά ταμειακής");
		category_ylika.add("χαρτιά παραγγελιών");
		
		String title_ylika = category_ylika.get(0);
		category_ylika.remove(0);
		Collections.sort(category_ylika);
		category_ylika.add(0, title_ylika);

		List<String> category_frouta_lax = new ArrayList<String>();
		category_frouta_lax.add("ΦΡΟΥΤΑ-ΛΑΧ");
		category_frouta_lax.add("Ρόκα");
		category_frouta_lax.add("Μεσκλάν");
		category_frouta_lax.add("Μαρούλι ίσιο");
		category_frouta_lax.add("Λολό ρόσσο");
		category_frouta_lax.add("Ντομάτες");
		category_frouta_lax.add("Ντοματίνια");
		category_frouta_lax.add("Πατάτες");
		category_frouta_lax.add("Πατάτες 10/18");
		category_frouta_lax.add("Κολοκυθάκια");
		category_frouta_lax.add("Μελιτζάνες");
		category_frouta_lax.add("Κρεμμύδι ξερό άσπρο");
		category_frouta_lax.add("Κρεμμυδάκι φρέσκο");
		category_frouta_lax.add("Μανιτάρια σαμπινιόν");
		category_frouta_lax.add("Αγγούρια");
		category_frouta_lax.add("Πιπεριές φλωρίνης");
		category_frouta_lax.add("Πιπεριές καυτερές");
		category_frouta_lax.add("Πατάτες baby");
		category_frouta_lax.add("Κινέζικο λάχανο");
		category_frouta_lax.add("Βασιλικός");
		category_frouta_lax.add("Δυόσμος");
		category_frouta_lax.add("Μαϊντανός");
		category_frouta_lax.add("Σκοινόπρασο");
		category_frouta_lax.add("Άνηθος");
		category_frouta_lax.add("Θυμάρι");
		category_frouta_lax.add("Δεντρολίβανο");
		category_frouta_lax.add("Σκόρδο");
		category_frouta_lax.add("Σπανάκι");
		category_frouta_lax.add("Μπρόκολο");
		category_frouta_lax.add("Κουνουπίδι");
		category_frouta_lax.add("Iceberg");
		category_frouta_lax.add("Πορτοκάλια");
		category_frouta_lax.add("Λεμόνια");
		category_frouta_lax.add("Καρότα");
		category_frouta_lax.add("Μήλα");
		category_frouta_lax.add("Ελιές");
		category_frouta_lax.add("Ακτινίδια");
		category_frouta_lax.add("Αχλάδια");
		category_frouta_lax.add("Φράουλες");
		category_frouta_lax.add("Πεπόνι");
		category_frouta_lax.add("Καρπούζι");
		category_frouta_lax.add("Κεράσια");
		category_frouta_lax.add("Μπανάνες");
		category_frouta_lax.add("Νεκταρίνια");
		category_frouta_lax.add("Ντομάτα κονκασέ");
		category_frouta_lax.add("Πελτές ντομάτας");
		category_frouta_lax.add("Λιαστή ντομάτα");
		
		String title_frouta_lax = category_frouta_lax.get(0);
		category_frouta_lax.remove(0);
		Collections.sort(category_frouta_lax);
		category_frouta_lax.add(0, title_frouta_lax);

		List<String> category_kreatika = new ArrayList<String>();
		category_kreatika.add("ΚΡΕΑΤΙΚΑ-ΑΛΑΝΤΙΚΑ");
		category_kreatika.add("ζωμός κότας");
		category_kreatika.add("μπέικον φέτες");
		category_kreatika.add("γαλοπούλα φέτες");
		category_kreatika.add("ζαμπόν φέτες");
		category_kreatika.add("λουκάνικα πιπερόνε");
		category_kreatika.add("σαλάμι μπύρας");
		category_kreatika.add("σαλάμι αέρος");
		category_kreatika.add("στήθος κοτόπουλο");
		category_kreatika.add("μπούτι κοτόπουλο");
		category_kreatika.add("ψαρονέφρι");
		category_kreatika.add("χοιρινός λεμός");
		category_kreatika.add("μοσχαρίσιος κυμάς");
		category_kreatika.add("χοιρίνός κυμάς");
		category_kreatika.add("χοιρινή παντσέτα χωρίς κόκκαλο");
		category_kreatika.add("μοσχαρίσια γλώσσα");
		category_kreatika.add("μοσχαρίσιο rib-eye");
		
		String title_kreatika = category_kreatika.get(0);
		category_kreatika.remove(0);
		Collections.sort(category_kreatika);
		category_kreatika.add(0, title_kreatika);

		List<String> category_tirokomika = new ArrayList<String>();
		category_tirokomika.add("ΤΥΡΟΚΟΜΙΚΑ");
		category_tirokomika.add("κρέμα γάλακτος");
		category_tirokomika.add("γιαούρτι");
		category_tirokomika.add("γκούντα φέτες");
		category_tirokomika.add("γκούντα τριμένη");
		category_tirokomika.add("παρμεζάνα τριμένη");
		category_tirokomika.add("μανούρι");
		category_tirokomika.add("μοτσαρέλα νερού");
		category_tirokomika.add("χαλούμι");
		category_tirokomika.add("παρμεζάνα κεφάλι");
		category_tirokomika.add("γραβιέρα");
		category_tirokomika.add("κρέμα τυριού buko");
		category_tirokomika.add("κρέμα τυριού");
		category_tirokomika.add("ημίσκληρο κασέρι");
		category_tirokomika.add("μυζήθρα");
		category_tirokomika.add("lurpak");
		category_tirokomika.add("ρεγγάτο");
		category_tirokomika.add("βούτυρο 5kg");
		category_tirokomika.add("φέτα αγελαδινή");
		category_tirokomika.add("γάλα");
		
		String title_tirokomika = category_tirokomika.get(0);
		category_tirokomika.remove(0);
		Collections.sort(category_tirokomika);
		category_tirokomika.add(0, title_tirokomika);

		dataAdapter_ouiskia = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_ouiskia);
		dataAdapter_ouiskia
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner11.setAdapter(dataAdapter_ouiskia);
		spinner11_2.setAdapter(dataAdapter_ouiskia);
		spinner11_3.setAdapter(dataAdapter_ouiskia);
		spinner11_4.setAdapter(dataAdapter_ouiskia);
		spinner11_5.setAdapter(dataAdapter_ouiskia);
		spinner11_6.setAdapter(dataAdapter_ouiskia);
		spinner11_7.setAdapter(dataAdapter_ouiskia);
		spinner11_8.setAdapter(dataAdapter_ouiskia);
		dataAdapter_ouiskia.notifyDataSetChanged();

		dataAdapter_vodka = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_vodka);
		dataAdapter_vodka
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner12.setAdapter(dataAdapter_vodka);
		spinner12_2.setAdapter(dataAdapter_vodka);
		spinner12_3.setAdapter(dataAdapter_vodka);
		spinner12_4.setAdapter(dataAdapter_vodka);
		spinner12_5.setAdapter(dataAdapter_vodka);
		spinner12_6.setAdapter(dataAdapter_vodka);
		spinner12_7.setAdapter(dataAdapter_vodka);
		spinner12_8.setAdapter(dataAdapter_vodka);
		dataAdapter_vodka.notifyDataSetChanged();

		dataAdapter_gin = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_gin);
		dataAdapter_gin
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner13.setAdapter(dataAdapter_gin);
		spinner13_2.setAdapter(dataAdapter_gin);
		spinner13_3.setAdapter(dataAdapter_gin);
		spinner13_4.setAdapter(dataAdapter_gin);
		spinner13_5.setAdapter(dataAdapter_gin);
		spinner13_6.setAdapter(dataAdapter_gin);
		spinner13_7.setAdapter(dataAdapter_gin);
		spinner13_8.setAdapter(dataAdapter_gin);
		dataAdapter_gin.notifyDataSetChanged();

		dataAdapter_tequila = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_tequila);
		dataAdapter_tequila
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner14.setAdapter(dataAdapter_tequila);
		spinner14_2.setAdapter(dataAdapter_tequila);
		spinner14_3.setAdapter(dataAdapter_tequila);
		spinner14_4.setAdapter(dataAdapter_tequila);
		spinner14_5.setAdapter(dataAdapter_tequila);
		spinner14_6.setAdapter(dataAdapter_tequila);
		spinner14_7.setAdapter(dataAdapter_tequila);
		spinner14_8.setAdapter(dataAdapter_tequila);
		dataAdapter_tequila.notifyDataSetChanged();

		dataAdapter_rum = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_rum);
		dataAdapter_rum
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner15.setAdapter(dataAdapter_rum);
		spinner15_2.setAdapter(dataAdapter_rum);
		spinner15_3.setAdapter(dataAdapter_rum);
		spinner15_4.setAdapter(dataAdapter_rum);
		spinner15_5.setAdapter(dataAdapter_rum);
		spinner15_6.setAdapter(dataAdapter_rum);
		spinner15_7.setAdapter(dataAdapter_rum);
		spinner15_8.setAdapter(dataAdapter_rum);
		dataAdapter_rum.notifyDataSetChanged();

		dataAdapter_cognaq = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_cognaq);
		dataAdapter_cognaq
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner16.setAdapter(dataAdapter_cognaq);
		spinner16_2.setAdapter(dataAdapter_cognaq);
		spinner16_3.setAdapter(dataAdapter_cognaq);
		spinner16_4.setAdapter(dataAdapter_cognaq);
		spinner16_5.setAdapter(dataAdapter_cognaq);
		spinner16_6.setAdapter(dataAdapter_cognaq);
		spinner16_7.setAdapter(dataAdapter_cognaq);
		spinner16_8.setAdapter(dataAdapter_cognaq);
		dataAdapter_cognaq.notifyDataSetChanged();

		dataAdapter_liker = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_liker);
		dataAdapter_liker
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner17.setAdapter(dataAdapter_liker);
		spinner17_2.setAdapter(dataAdapter_liker);
		spinner17_3.setAdapter(dataAdapter_liker);
		spinner17_4.setAdapter(dataAdapter_liker);
		spinner17_5.setAdapter(dataAdapter_liker);
		spinner17_6.setAdapter(dataAdapter_liker);
		spinner17_7.setAdapter(dataAdapter_liker);
		spinner17_8.setAdapter(dataAdapter_liker);
		dataAdapter_liker.notifyDataSetChanged();

		dataAdapter_ouza_tsipoura = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_ouza_tsipoura);
		dataAdapter_ouza_tsipoura
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner18.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_2.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_3.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_4.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_5.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_6.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_7.setAdapter(dataAdapter_ouza_tsipoura);
		spinner18_8.setAdapter(dataAdapter_ouza_tsipoura);
		dataAdapter_ouza_tsipoura.notifyDataSetChanged();

		dataAdapter_krasia = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_krasia);
		dataAdapter_krasia
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner19.setAdapter(dataAdapter_krasia);
		spinner19_2.setAdapter(dataAdapter_krasia);
		spinner19_3.setAdapter(dataAdapter_krasia);
		spinner19_4.setAdapter(dataAdapter_krasia);
		spinner19_5.setAdapter(dataAdapter_krasia);
		spinner19_6.setAdapter(dataAdapter_krasia);
		spinner19_7.setAdapter(dataAdapter_krasia);
		spinner19_8.setAdapter(dataAdapter_krasia);
		dataAdapter_krasia.notifyDataSetChanged();

		dataAdapter_bires = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_bires);
		dataAdapter_bires
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner20.setAdapter(dataAdapter_bires);
		spinner20_2.setAdapter(dataAdapter_bires);
		spinner20_3.setAdapter(dataAdapter_bires);
		spinner20_4.setAdapter(dataAdapter_bires);
		spinner20_5.setAdapter(dataAdapter_bires);
		spinner20_6.setAdapter(dataAdapter_bires);
		spinner20_7.setAdapter(dataAdapter_bires);
		spinner20_8.setAdapter(dataAdapter_bires);
		dataAdapter_bires.notifyDataSetChanged();

		dataAdapter_anapsiktika = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_anapsiktika);
		dataAdapter_anapsiktika
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner21.setAdapter(dataAdapter_anapsiktika);
		spinner21_2.setAdapter(dataAdapter_anapsiktika);
		spinner21_3.setAdapter(dataAdapter_anapsiktika);
		spinner21_4.setAdapter(dataAdapter_anapsiktika);
		spinner21_5.setAdapter(dataAdapter_anapsiktika);
		spinner21_6.setAdapter(dataAdapter_anapsiktika);
		spinner21_7.setAdapter(dataAdapter_anapsiktika);
		spinner21_8.setAdapter(dataAdapter_anapsiktika);
		dataAdapter_anapsiktika.notifyDataSetChanged();

		dataAdapter_tsai = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_tsai);
		dataAdapter_tsai
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner22.setAdapter(dataAdapter_tsai);
		spinner22_2.setAdapter(dataAdapter_tsai);
		spinner22_3.setAdapter(dataAdapter_tsai);
		spinner22_4.setAdapter(dataAdapter_tsai);
		spinner22_5.setAdapter(dataAdapter_tsai);
		spinner22_6.setAdapter(dataAdapter_tsai);
		spinner22_7.setAdapter(dataAdapter_tsai);
		spinner22_8.setAdapter(dataAdapter_tsai);
		dataAdapter_tsai.notifyDataSetChanged();

		dataAdapter_kafedes = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_kafedes);
		dataAdapter_kafedes
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner23.setAdapter(dataAdapter_kafedes);
		spinner23_2.setAdapter(dataAdapter_kafedes);
		spinner23_3.setAdapter(dataAdapter_kafedes);
		spinner23_4.setAdapter(dataAdapter_kafedes);
		spinner23_5.setAdapter(dataAdapter_kafedes);
		spinner23_6.setAdapter(dataAdapter_kafedes);
		spinner23_7.setAdapter(dataAdapter_kafedes);
		spinner23_8.setAdapter(dataAdapter_kafedes);
		dataAdapter_kafedes.notifyDataSetChanged();

		dataAdapter_pagota = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_pagota);
		dataAdapter_pagota
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner24.setAdapter(dataAdapter_pagota);
		spinner24_2.setAdapter(dataAdapter_pagota);
		spinner24_3.setAdapter(dataAdapter_pagota);
		spinner24_4.setAdapter(dataAdapter_pagota);
		spinner24_5.setAdapter(dataAdapter_pagota);
		spinner24_6.setAdapter(dataAdapter_pagota);
		spinner24_7.setAdapter(dataAdapter_pagota);
		spinner24_8.setAdapter(dataAdapter_pagota);
		dataAdapter_pagota.notifyDataSetChanged();

		dataAdapter_sinodeutika = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_sinodeutika);
		dataAdapter_sinodeutika
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner25.setAdapter(dataAdapter_sinodeutika);
		spinner25_2.setAdapter(dataAdapter_sinodeutika);
		spinner25_3.setAdapter(dataAdapter_sinodeutika);
		spinner25_4.setAdapter(dataAdapter_sinodeutika);
		spinner25_5.setAdapter(dataAdapter_sinodeutika);
		spinner25_6.setAdapter(dataAdapter_sinodeutika);
		spinner25_7.setAdapter(dataAdapter_sinodeutika);
		spinner25_8.setAdapter(dataAdapter_sinodeutika);
		dataAdapter_sinodeutika.notifyDataSetChanged();

		dataAdapter_frouta_lax = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_frouta_lax);
		dataAdapter_frouta_lax
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner26.setAdapter(dataAdapter_frouta_lax);
		spinner26_2.setAdapter(dataAdapter_frouta_lax);
		spinner26_3.setAdapter(dataAdapter_frouta_lax);
		spinner26_4.setAdapter(dataAdapter_frouta_lax);
		spinner26_5.setAdapter(dataAdapter_frouta_lax);
		spinner26_6.setAdapter(dataAdapter_frouta_lax);
		spinner26_7.setAdapter(dataAdapter_frouta_lax);
		spinner26_8.setAdapter(dataAdapter_frouta_lax);
		dataAdapter_frouta_lax.notifyDataSetChanged();

		dataAdapter_kreatika = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_kreatika);
		dataAdapter_kreatika
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner27.setAdapter(dataAdapter_kreatika);
		spinner27_2.setAdapter(dataAdapter_kreatika);
		spinner27_3.setAdapter(dataAdapter_kreatika);
		spinner27_4.setAdapter(dataAdapter_kreatika);
		spinner27_5.setAdapter(dataAdapter_kreatika);
		spinner27_6.setAdapter(dataAdapter_kreatika);
		spinner27_7.setAdapter(dataAdapter_kreatika);
		spinner27_8.setAdapter(dataAdapter_kreatika);
		dataAdapter_kreatika.notifyDataSetChanged();

		dataAdapter_tirokomika = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_tirokomika);
		dataAdapter_tirokomika
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner28.setAdapter(dataAdapter_tirokomika);
		spinner28_2.setAdapter(dataAdapter_tirokomika);
		spinner28_3.setAdapter(dataAdapter_tirokomika);
		spinner28_4.setAdapter(dataAdapter_tirokomika);
		spinner28_5.setAdapter(dataAdapter_tirokomika);
		spinner28_6.setAdapter(dataAdapter_tirokomika);
		spinner28_7.setAdapter(dataAdapter_tirokomika);
		spinner28_8.setAdapter(dataAdapter_tirokomika);
		dataAdapter_tirokomika.notifyDataSetChanged();

		dataAdapter_trofima = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_trofima);
		dataAdapter_trofima
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner29.setAdapter(dataAdapter_trofima);
		spinner29_2.setAdapter(dataAdapter_trofima);
		spinner29_3.setAdapter(dataAdapter_trofima);
		spinner29_4.setAdapter(dataAdapter_trofima);
		spinner29_5.setAdapter(dataAdapter_trofima);
		spinner29_6.setAdapter(dataAdapter_trofima);
		spinner29_7.setAdapter(dataAdapter_trofima);
		spinner29_8.setAdapter(dataAdapter_trofima);
		dataAdapter_trofima.notifyDataSetChanged();

		dataAdapter_ylika = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category_ylika);
		dataAdapter_ylika
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner30.setAdapter(dataAdapter_ylika);
		spinner30_2.setAdapter(dataAdapter_ylika);
		spinner30_3.setAdapter(dataAdapter_ylika);
		spinner30_4.setAdapter(dataAdapter_ylika);
		spinner30_5.setAdapter(dataAdapter_ylika);
		spinner30_6.setAdapter(dataAdapter_ylika);
		spinner30_7.setAdapter(dataAdapter_ylika);
		spinner30_8.setAdapter(dataAdapter_ylika);
		dataAdapter_ylika.notifyDataSetChanged();

		loadSpinnerDataHama();
		// set screen
		Set_Add_Update_Screen();

		// set visibility of view as per calling activity
		String called_from = getIntent().getStringExtra("called");

		if (called_from.equalsIgnoreCase("add")) {
			add_view_tim.setVisibility(View.VISIBLE);
			update_view_tim.setVisibility(View.GONE);
		} else {

			update_view_tim.setVisibility(View.VISIBLE);
			add_view_tim.setVisibility(View.GONE);
			TIMOLOGIO_ID = Integer.parseInt(getIntent().getStringExtra(
					"TIMOLOGIO_ID"));

			Timologia t = dbHandler.Get_Timologio(TIMOLOGIO_ID);

			add_eponimia_tim.setText(t.getEponimiaTim());
			add_arithmos_tim.setText(t.getArithmoTim());
			add_timi_tim.setText(t.getTimiTim());
			add_date_tim.setText(t.getDateTim());
			add_eidos1_tim.setText(t.getEidos1Tim());
			add_eidos2_tim.setText(t.getEidos2Tim());
			add_eidos3_tim.setText(t.getEidos3Tim());
			add_eidos4_tim.setText(t.getEidos4Tim());
			add_eidos5_tim.setText(t.getEidos5Tim());
			add_eidos6_tim.setText(t.getEidos6Tim());
			add_eidos7_tim.setText(t.getEidos7Tim());
			add_eidos8_tim.setText(t.getEidos8Tim());
			add_posotita1_tim.setText(t.getPosotita1Tim());
			add_posotita2_tim.setText(t.getPosotita2Tim());
			add_posotita3_tim.setText(t.getPosotita3Tim());
			add_posotita4_tim.setText(t.getPosotita4Tim());
			add_posotita5_tim.setText(t.getPosotita5Tim());
			add_posotita6_tim.setText(t.getPosotita6Tim());
			add_posotita7_tim.setText(t.getPosotita7Tim());
			add_posotita8_tim.setText(t.getPosotita8Tim());

			// dbHandler.close();
		}

		add_eponimia_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eponimia_Name(add_eponimia_tim);
			}
		});

		add_eidos1_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos1_Name(add_eidos1_tim);
			}
		});
		add_eidos2_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos2_Name(add_eidos2_tim);
			}
		});
		add_eidos3_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos3_Name(add_eidos3_tim);
			}
		});
		add_eidos4_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos4_Name(add_eidos4_tim);
			}
		});
		add_eidos5_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos5_Name(add_eidos5_tim);
			}
		});
		add_eidos6_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos6_Name(add_eidos6_tim);
			}
		});
		add_eidos7_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos7_Name(add_eidos7_tim);
			}
		});
		add_eidos8_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos8_Name(add_eidos8_tim);
			}
		});
		add_posotita1_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita1_Name(add_posotita1_tim);
			}
		});
		add_posotita2_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita2_Name(add_posotita2_tim);
			}
		});
		add_posotita3_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita3_Name(add_posotita3_tim);
			}
		});
		add_posotita4_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita4_Name(add_posotita4_tim);
			}
		});
		add_posotita5_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita5_Name(add_posotita5_tim);
			}
		});
		add_posotita6_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita6_Name(add_posotita6_tim);
			}
		});
		add_posotita7_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita7_Name(add_posotita7_tim);
			}
		});
		add_posotita8_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Posotita8_Name(add_posotita8_tim);
			}
		});
		add_arithmos_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				// min lenth 6 and max lenth 6 ()
				Is_Valid_Sign_Number_Validation(0, 10, add_arithmos_tim);
			}
		});
		// add_arithmos_tim.addTextChangedListener(new
		// PhoneNumberFormattingTextWatcher());
		add_timi_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

				Is_Valid_Timi_Number_Validation(0, 15, add_timi_tim);

			}
		});

		// add_timi_tim.addTextChangedListener(new
		// PhoneNumberFormattingTextWatcher());

		add_date_tim.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				// min lenth 6 and max lenth 6 ()
				Is_Valid_Date_Number_Validation(0, 10, add_date_tim);
			}
		});

		add_save_btn_tim.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// check the value state is null or not
				if (valid_date_tim != null && valid_date_tim.length() != 0) {

					dbHandler.Add_Timologio(new Timologia(valid_eponimia_tim,
							valid_arithmos_tim, valid_timi_tim, valid_date_tim,
							valid_eidos1_tim, valid_eidos2_tim,
							valid_eidos3_tim, valid_eidos4_tim,
							valid_eidos5_tim, valid_eidos6_tim,
							valid_eidos7_tim, valid_eidos8_tim,
							valid_posotita1_tim, valid_posotita2_tim,
							valid_posotita3_tim, valid_posotita4_tim,
							valid_posotita5_tim, valid_posotita6_tim,
							valid_posotita7_tim, valid_posotita8_tim));
					Toast_msg = "Το τιμολόγιο εισάχθηκε επιτυχώς";
					Show_Toast(Toast_msg);
					Reset_Text();
					InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

					inputManager.hideSoftInputFromWindow(getCurrentFocus()
							.getWindowToken(),
							InputMethodManager.HIDE_NOT_ALWAYS);

					Intent add_tim = new Intent(Add_Update_Tim.this,
							Timologio.class);
					add_tim.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(add_tim);
					finish();
				} else {
					Toast_msg = "Κάποια πεδία είναι κενά\n συμπληρώστε τα υποχρεωτικα πεδία";
					Show_Toast(Toast_msg);
				}

			}
		});

		update_btn_tim.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				valid_eponimia_tim = add_eponimia_tim.getText().toString();
				valid_arithmos_tim = add_arithmos_tim.getText().toString();
				valid_timi_tim = add_timi_tim.getText().toString();
				valid_date_tim = add_date_tim.getText().toString();
				valid_eidos1_tim = add_eidos1_tim.getText().toString();
				valid_eidos2_tim = add_eidos2_tim.getText().toString();
				valid_eidos3_tim = add_eidos3_tim.getText().toString();
				valid_eidos4_tim = add_eidos4_tim.getText().toString();
				valid_eidos5_tim = add_eidos5_tim.getText().toString();
				valid_eidos6_tim = add_eidos6_tim.getText().toString();
				valid_eidos7_tim = add_eidos7_tim.getText().toString();
				valid_eidos8_tim = add_eidos8_tim.getText().toString();
				valid_posotita1_tim = add_posotita1_tim.getText().toString();
				valid_posotita2_tim = add_posotita2_tim.getText().toString();
				valid_posotita3_tim = add_posotita3_tim.getText().toString();
				valid_posotita4_tim = add_posotita4_tim.getText().toString();
				valid_posotita5_tim = add_posotita5_tim.getText().toString();
				valid_posotita6_tim = add_posotita6_tim.getText().toString();
				valid_posotita7_tim = add_posotita7_tim.getText().toString();
				valid_posotita8_tim = add_posotita8_tim.getText().toString();

				// check the value state is null or not
				if (valid_eponimia_tim != null
				/*
				 * && valid_name.length() != 0 && valid_arithmos_tim.length() !=
				 * 0 && valid_timi_tim.length() != 0
				 */) {

					dbHandler.Update_Timologio(new Timologia(TIMOLOGIO_ID,
							valid_eponimia_tim, valid_arithmos_tim,
							valid_timi_tim, valid_date_tim, valid_eidos1_tim,
							valid_eidos2_tim, valid_eidos3_tim,
							valid_eidos4_tim, valid_eidos5_tim,
							valid_eidos6_tim, valid_eidos7_tim,
							valid_eidos8_tim, valid_posotita1_tim,
							valid_posotita2_tim, valid_posotita3_tim,
							valid_posotita4_tim, valid_posotita5_tim,
							valid_posotita6_tim, valid_posotita7_tim,
							valid_posotita8_tim));
					dbHandler.close();
					Toast_msg = "Τα δεδομένα εισάχθηκαν επιτυχώς";
					Show_Toast(Toast_msg);
					Reset_Text();
					InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

					inputManager.hideSoftInputFromWindow(getCurrentFocus()
							.getWindowToken(),
							InputMethodManager.HIDE_NOT_ALWAYS);
					Intent add_tim = new Intent(Add_Update_Tim.this,
							Timologio.class);
					add_tim.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(add_tim);
				} else {
					Toast_msg = "Κάποια πεδία είναι κενά\n συμπληρώστε τα υποχρεωτικα πεδία";
					Show_Toast(Toast_msg);
				}

			}
		});

		b_valeproion2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL2.setVisibility(View.VISIBLE);
				b_valeproion3.setVisibility(View.VISIBLE);

				b_vgaleproion2.setVisibility(View.VISIBLE);
				b_valeproion2.setVisibility(View.GONE);

			}
		});

		b_vgaleproion2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL2.setVisibility(View.GONE);
				b_valeproion3.setVisibility(View.GONE);

				b_valeproion2.setVisibility(View.VISIBLE);
				b_vgaleproion2.setVisibility(View.GONE);

				add_eidos2_tim.setText("");
				add_posotita2_tim.setText("");

			}
		});

		b_valeproion3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL3.setVisibility(View.VISIBLE);
				b_valeproion4.setVisibility(View.VISIBLE);

				b_vgaleproion3.setVisibility(View.VISIBLE);
				b_valeproion3.setVisibility(View.GONE);
				b_valeproion2.setVisibility(View.GONE);
				b_vgaleproion2.setVisibility(View.GONE);

			}
		});

		b_vgaleproion3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL3.setVisibility(View.GONE);
				b_valeproion4.setVisibility(View.GONE);

				b_vgaleproion3.setVisibility(View.GONE);
				b_valeproion3.setVisibility(View.VISIBLE);
				b_vgaleproion2.setVisibility(View.VISIBLE);

				add_eidos3_tim.setText("");
				add_posotita3_tim.setText("");

			}
		});

		b_valeproion4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL4.setVisibility(View.VISIBLE);
				b_valeproion5.setVisibility(View.VISIBLE);

				b_vgaleproion4.setVisibility(View.VISIBLE);
				b_valeproion4.setVisibility(View.GONE);
				b_valeproion3.setVisibility(View.GONE);
				b_vgaleproion3.setVisibility(View.GONE);
			}
		});
		b_vgaleproion4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL4.setVisibility(View.GONE);
				b_valeproion5.setVisibility(View.GONE);

				b_valeproion4.setVisibility(View.VISIBLE);
				b_vgaleproion3.setVisibility(View.VISIBLE);
				b_vgaleproion4.setVisibility(View.GONE);

				add_eidos4_tim.setText("");
				add_posotita4_tim.setText("");

			}
		});

		b_valeproion5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL5.setVisibility(View.VISIBLE);
				b_valeproion6.setVisibility(View.VISIBLE);

				b_vgaleproion5.setVisibility(View.VISIBLE);
				b_valeproion5.setVisibility(View.GONE);
				b_vgaleproion4.setVisibility(View.GONE);
			}
		});
		b_vgaleproion5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL5.setVisibility(View.GONE);
				b_valeproion6.setVisibility(View.GONE);

				b_valeproion5.setVisibility(View.VISIBLE);
				b_vgaleproion4.setVisibility(View.VISIBLE);
				b_vgaleproion5.setVisibility(View.GONE);

				add_eidos5_tim.setText("");
				add_posotita5_tim.setText("");

			}
		});

		b_valeproion6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL6.setVisibility(View.VISIBLE);
				b_valeproion7.setVisibility(View.VISIBLE);

				b_vgaleproion6.setVisibility(View.VISIBLE);
				b_valeproion6.setVisibility(View.GONE);
				b_vgaleproion5.setVisibility(View.GONE);
			}
		});

		b_vgaleproion6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL6.setVisibility(View.GONE);
				b_valeproion6.setVisibility(View.VISIBLE);

				b_valeproion7.setVisibility(View.GONE);
				b_vgaleproion5.setVisibility(View.VISIBLE);
				b_vgaleproion6.setVisibility(View.GONE);

				add_eidos6_tim.setText("");
				add_posotita6_tim.setText("");

			}
		});

		b_valeproion7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL7.setVisibility(View.VISIBLE);
				b_valeproion8.setVisibility(View.VISIBLE);

				b_vgaleproion7.setVisibility(View.VISIBLE);
				b_valeproion7.setVisibility(View.GONE);
				b_vgaleproion6.setVisibility(View.GONE);
			}
		});
		b_vgaleproion7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL7.setVisibility(View.GONE);
				b_valeproion7.setVisibility(View.VISIBLE);

				b_valeproion8.setVisibility(View.GONE);
				b_vgaleproion6.setVisibility(View.VISIBLE);
				b_vgaleproion7.setVisibility(View.GONE);

				add_eidos7_tim.setText("");
				add_posotita7_tim.setText("");

			}
		});

		b_valeproion8.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL8.setVisibility(View.VISIBLE);
				b_valeproion8.setVisibility(View.GONE);

				b_vgaleproion8.setVisibility(View.VISIBLE);
				b_vgaleproion7.setVisibility(View.GONE);
			}
		});
		b_vgaleproion8.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LL8.setVisibility(View.GONE);

				b_valeproion8.setVisibility(View.VISIBLE);
				b_vgaleproion7.setVisibility(View.VISIBLE);
				b_vgaleproion8.setVisibility(View.GONE);

				add_eidos8_tim.setText("");
				add_posotita8_tim.setText("");

			}
		});

	}

	public void Set_Add_Update_Screen() {

		add_eponimia_tim = (EditText) findViewById(R.id.ET_eponimia_tim);
		add_eponimia_tim.setVisibility(View.GONE);
		add_arithmos_tim = (EditText) findViewById(R.id.ET_arithmos_tim);
		add_timi_tim = (EditText) findViewById(R.id.ET_timi_tim);
		add_date_tim = (EditText) findViewById(R.id.ET_date_tim);
		add_eidos1_tim = (EditText) findViewById(R.id.ET_eidos1_tim);
		add_eidos2_tim = (EditText) findViewById(R.id.ET_eidos2_tim);
		add_eidos3_tim = (EditText) findViewById(R.id.ET_eidos3_tim);
		add_eidos4_tim = (EditText) findViewById(R.id.ET_eidos4_tim);
		add_eidos5_tim = (EditText) findViewById(R.id.ET_eidos5_tim);
		add_eidos6_tim = (EditText) findViewById(R.id.ET_eidos6_tim);
		add_eidos7_tim = (EditText) findViewById(R.id.ET_eidos7_tim);
		add_eidos8_tim = (EditText) findViewById(R.id.ET_eidos8_tim);
		add_posotita1_tim = (EditText) findViewById(R.id.ET_posotita1_tim);
		add_posotita2_tim = (EditText) findViewById(R.id.ET_posotita2_tim);
		add_posotita3_tim = (EditText) findViewById(R.id.ET_posotita3_tim);
		add_posotita4_tim = (EditText) findViewById(R.id.ET_posotita4_tim);
		add_posotita5_tim = (EditText) findViewById(R.id.ET_posotita5_tim);
		add_posotita6_tim = (EditText) findViewById(R.id.ET_posotita6_tim);
		add_posotita7_tim = (EditText) findViewById(R.id.ET_posotita7_tim);
		add_posotita8_tim = (EditText) findViewById(R.id.ET_posotita8_tim);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm",
				java.util.Locale.getDefault());
		add_date_tim.setText(sdf.format(new Date()));
		valid_date_tim = add_date_tim.getText().toString();
		add_date_tim.setVisibility(View.GONE);

		add_save_btn_tim = (Button) findViewById(R.id.add_save_btn_tim);
		update_btn_tim = (Button) findViewById(R.id.update_btn_tim);

		b_valeproion2 = (Button) findViewById(R.id.b_valeproion2ο);
		b_valeproion3 = (Button) findViewById(R.id.b_valeproion3ο);
		b_valeproion4 = (Button) findViewById(R.id.b_valeproion4ο);
		b_valeproion5 = (Button) findViewById(R.id.b_valeproion5ο);
		b_valeproion6 = (Button) findViewById(R.id.b_valeproion6ο);
		b_valeproion7 = (Button) findViewById(R.id.b_valeproion7ο);
		b_valeproion8 = (Button) findViewById(R.id.b_valeproion8ο);

		b_vgaleproion2 = (Button) findViewById(R.id.b_vgaleproion2ο);
		b_vgaleproion3 = (Button) findViewById(R.id.b_vgaleproion3ο);
		b_vgaleproion4 = (Button) findViewById(R.id.b_vgaleproion4ο);
		b_vgaleproion5 = (Button) findViewById(R.id.b_vgaleproion5ο);
		b_vgaleproion6 = (Button) findViewById(R.id.b_vgaleproion6ο);
		b_vgaleproion7 = (Button) findViewById(R.id.b_vgaleproion7ο);
		b_vgaleproion8 = (Button) findViewById(R.id.b_vgaleproion8ο);

		b_valeproion3.setVisibility(View.GONE);
		b_valeproion4.setVisibility(View.GONE);
		b_valeproion5.setVisibility(View.GONE);
		b_valeproion6.setVisibility(View.GONE);
		b_valeproion7.setVisibility(View.GONE);
		b_valeproion8.setVisibility(View.GONE);

		b_vgaleproion2.setVisibility(View.GONE);
		b_vgaleproion3.setVisibility(View.GONE);
		b_vgaleproion4.setVisibility(View.GONE);
		b_vgaleproion5.setVisibility(View.GONE);
		b_vgaleproion6.setVisibility(View.GONE);
		b_vgaleproion7.setVisibility(View.GONE);
		b_vgaleproion8.setVisibility(View.GONE);

		add_view_tim = (LinearLayout) findViewById(R.id.add_view_tim);
		update_view_tim = (LinearLayout) findViewById(R.id.update_view_tim);
		LL2 = (LinearLayout) findViewById(R.id.LL2);
		LL3 = (LinearLayout) findViewById(R.id.LL3);
		LL4 = (LinearLayout) findViewById(R.id.LL4);
		LL5 = (LinearLayout) findViewById(R.id.LL5);
		LL6 = (LinearLayout) findViewById(R.id.LL6);
		LL7 = (LinearLayout) findViewById(R.id.LL7);
		LL8 = (LinearLayout) findViewById(R.id.LL8);

		add_view_tim.setVisibility(View.GONE);
		update_view_tim.setVisibility(View.GONE);
		LL2.setVisibility(View.GONE);
		LL3.setVisibility(View.GONE);
		LL4.setVisibility(View.GONE);
		LL5.setVisibility(View.GONE);
		LL6.setVisibility(View.GONE);
		LL7.setVisibility(View.GONE);
		LL8.setVisibility(View.GONE);

	}

	public void Is_Valid_Sign_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError(Html
					.fromHtml("<font color='red'>εισάγεται σωστά τον αριθμό</font>"));
			// edt.setError("Eisagete sosta ton arithmo");
			valid_arithmos_tim = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError(Html
					.fromHtml("<font color='red'>ελάχιστοι χαρακτήρες 9</font>"));
			// edt.setError("Ελάχιστοι χαρακτήρες " + MinLen);
			valid_arithmos_tim = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError(Html
					.fromHtml("<font color='red'>μέγιστοι χαρακτήρες 9</font>"));
			// edt.setError("Μέγιστοι χαρακτήρες " + MaxLen);
			valid_arithmos_tim = null;

		} else {
			valid_arithmos_tim = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Timi_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {

		valid_timi_tim = edt.getText().toString();

	} // END OF Edittext validation

	public void Is_Valid_Date_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError(Html
					.fromHtml("<font color='red'>αριθμούς μόνο</font>"));
			// edt.setError("Number Only");
			valid_arithmos_tim = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError(Html
					.fromHtml("<font color='red'>ελάχιστοι χαρακτήρες</font>"));
			// edt.setError("Minimum length " + MinLen);
			valid_arithmos_tim = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError(Html
					.fromHtml("<font color='red'>μέγιστοι χαρακτήρες</font>"));
			// edt.setError("Maximum length " + MaxLen);
			valid_arithmos_tim = null;

		} else {
			valid_date_tim = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Eponimia_Name(EditText edt)
			throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError(Html
					.fromHtml("<font color='red'>εισάγεται όνομα</font>"));
			// edt.setError("Εισάγεται όνομα");
			valid_eponimia_tim = null;
		} else if (!edt.getText().toString().matches("[a-zA-Zα-ωΑ-Ω ]+")) {
			edt.setError(Html
					.fromHtml("<font color='red'>εισάγεται χαρακτήρες</font>"));
			// edt.setError("Εισάγεται χαρακτήρες");
			valid_eponimia_tim = null;
		} else {
			valid_eponimia_tim = edt.getText().toString();
		}

	}

	public void Is_Valid_Eidos1_Name(EditText edt) throws NumberFormatException {

		valid_eidos1_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos2_Name(EditText edt) throws NumberFormatException {

		valid_eidos2_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos3_Name(EditText edt) throws NumberFormatException {

		valid_eidos3_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos4_Name(EditText edt) throws NumberFormatException {

		valid_eidos4_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos5_Name(EditText edt) throws NumberFormatException {

		valid_eidos5_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos6_Name(EditText edt) throws NumberFormatException {

		valid_eidos6_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos7_Name(EditText edt) throws NumberFormatException {

		valid_eidos7_tim = edt.getText().toString();
	}

	public void Is_Valid_Eidos8_Name(EditText edt) throws NumberFormatException {

		valid_eidos8_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita1_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita1_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita2_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita2_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita3_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita3_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita4_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita4_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita5_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita5_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita6_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita6_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita7_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita7_tim = edt.getText().toString();
	}

	public void Is_Valid_Posotita8_Name(EditText edt)
			throws NumberFormatException {

		valid_posotita8_tim = edt.getText().toString();
	}

	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

	public void Reset_Text() {

		add_eponimia_tim.getText().clear();
		add_arithmos_tim.getText().clear();
		add_timi_tim.getText().clear();
		add_date_tim.getText().clear();
		add_eidos1_tim.getText().clear();
		add_eidos2_tim.getText().clear();
		add_eidos3_tim.getText().clear();
		add_eidos4_tim.getText().clear();
		add_eidos5_tim.getText().clear();
		add_eidos6_tim.getText().clear();
		add_eidos7_tim.getText().clear();
		add_eidos8_tim.getText().clear();
		add_posotita1_tim.getText().clear();
		add_posotita2_tim.getText().clear();
		add_posotita3_tim.getText().clear();
		add_posotita4_tim.getText().clear();
		add_posotita5_tim.getText().clear();
		add_posotita6_tim.getText().clear();
		add_posotita7_tim.getText().clear();
		add_posotita8_tim.getText().clear();

	}

	private void loadSpinnerDataHama() {
		// database handler

		// Spinner Drop down elements
		List<String> eponimies = dbHandler.getAllEponimies();
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, eponimies);
		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);
		
		Collections.sort(eponimies);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

		dataAdapter_ouiskia.notifyDataSetChanged();
		dataAdapter_vodka.notifyDataSetChanged();
		dataAdapter_gin.notifyDataSetChanged();
		dataAdapter_tequila.notifyDataSetChanged();
		dataAdapter_rum.notifyDataSetChanged();
		dataAdapter_cognaq.notifyDataSetChanged();
		dataAdapter_liker.notifyDataSetChanged();
		dataAdapter_ouza_tsipoura.notifyDataSetChanged();
		dataAdapter_krasia.notifyDataSetChanged();
		dataAdapter_bires.notifyDataSetChanged();
		dataAdapter_anapsiktika.notifyDataSetChanged();
		dataAdapter_tsai.notifyDataSetChanged();
		dataAdapter_kafedes.notifyDataSetChanged();
		dataAdapter_pagota.notifyDataSetChanged();
		dataAdapter_sinodeutika.notifyDataSetChanged();
		dataAdapter_frouta_lax.notifyDataSetChanged();
		dataAdapter_kreatika.notifyDataSetChanged();
		dataAdapter_tirokomika.notifyDataSetChanged();
		dataAdapter_trofima.notifyDataSetChanged();
		dataAdapter_ylika.notifyDataSetChanged();

		String item = parent.getItemAtPosition(position).toString();

		switch (parent.getId()) {
		case R.id.Spinner_Eponimias:
			add_eponimia_tim.setText(item);
			valid_eponimia_tim = add_eponimia_tim.getText().toString();
			break;
		case R.id.spinner11:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner12:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner13:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner14:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner15:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner16:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner17:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner18:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner19:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner20:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner21:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner22:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner23:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner24:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner25:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner26:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner27:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner28:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner29:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner30:
			add_eidos1_tim.setText(item);
			valid_eidos1_tim = add_eidos1_tim.getText().toString();
			break;
		case R.id.spinner11_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner12_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner13_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner14_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner15_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner16_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner17_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner18_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner19_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner20_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner21_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner22_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner23_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner24_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner25_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner26_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner27_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner28_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner29_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner30_2:
			add_eidos2_tim.setText(item);
			valid_eidos2_tim = add_eidos2_tim.getText().toString();
			break;
		case R.id.spinner11_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner12_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner13_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner14_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner15_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner16_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner17_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner18_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner19_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner20_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner21_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner22_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner23_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner24_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner25_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner26_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner27_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner28_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner29_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner30_3:
			add_eidos3_tim.setText(item);
			valid_eidos3_tim = add_eidos3_tim.getText().toString();
			break;
		case R.id.spinner11_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner12_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner13_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner14_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner15_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner16_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner17_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner18_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner19_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner20_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner21_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner22_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner23_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner24_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner25_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner26_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner27_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner28_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner29_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner30_4:
			add_eidos4_tim.setText(item);
			valid_eidos4_tim = add_eidos4_tim.getText().toString();
			break;
		case R.id.spinner11_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner12_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner13_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner14_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner15_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner16_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner17_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner18_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner19_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner20_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner21_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner22_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner23_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner24_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner25_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner26_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner27_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner28_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner29_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner30_5:
			add_eidos5_tim.setText(item);
			valid_eidos5_tim = add_eidos5_tim.getText().toString();
			break;
		case R.id.spinner11_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner12_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner13_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner14_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner15_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner16_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner17_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner18_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner19_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner20_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner21_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner22_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner23_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner24_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner25_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner26_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner27_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner28_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner29_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner30_6:
			add_eidos6_tim.setText(item);
			valid_eidos6_tim = add_eidos6_tim.getText().toString();
			break;
		case R.id.spinner11_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner12_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner13_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner14_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner15_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner16_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner17_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner18_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner19_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner20_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner21_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner22_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner23_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner24_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner25_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner26_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner27_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner28_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner29_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner30_7:
			add_eidos7_tim.setText(item);
			valid_eidos7_tim = add_eidos7_tim.getText().toString();
			break;
		case R.id.spinner11_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner12_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner13_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner14_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner15_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner16_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner17_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner18_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner19_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner20_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner21_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner22_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner23_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner24_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner25_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner26_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner27_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner28_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner29_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		case R.id.spinner30_8:
			add_eidos8_tim.setText(item);
			valid_eidos8_tim = add_eidos8_tim.getText().toString();
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
