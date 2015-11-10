package com.cooper.timologia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.cooper.timologia.R;

import static com.cooper.timologia.Timologio.KEY_ARITHMOS_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS1_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS2_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS3_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS4_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS5_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS6_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS7_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_EIDOS8_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA1_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA2_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA3_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA4_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA5_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA6_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA7_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_POSOTITA8_TIM_DETAIL;
import static com.cooper.timologia.Timologio.KEY_TIMI_TIM_DETAIL;

public class Click extends Activity {

	TextView arithmos_timologiou, timi_timologiou, eidos1_timologiou,
			eidos2_timologiou, eidos3_timologiou, eidos4_timologiou,
			eidos5_timologiou, eidos6_timologiou, eidos7_timologiou,
			eidos8_timologiou, posotita1_timologiou, posotita2_timologiou,
			posotita3_timologiou, posotita4_timologiou, posotita5_timologiou,
			posotita6_timologiou, posotita7_timologiou, posotita8_timologiou;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.click);
		arithmos_timologiou = (TextView) findViewById(R.id.TV_arithmo_timologiou);
		timi_timologiou = (TextView) findViewById(R.id.TV_timi_timologiou);
		eidos1_timologiou = (TextView) findViewById(R.id.TV_eidos1_timologiou);
		eidos2_timologiou = (TextView) findViewById(R.id.TV_eidos2_timologiou);
		eidos3_timologiou = (TextView) findViewById(R.id.TV_eidos3_timologiou);
		eidos4_timologiou = (TextView) findViewById(R.id.TV_eidos4_timologiou);
		eidos5_timologiou = (TextView) findViewById(R.id.TV_eidos5_timologiou);
		eidos6_timologiou = (TextView) findViewById(R.id.TV_eidos6_timologiou);
		eidos7_timologiou = (TextView) findViewById(R.id.TV_eidos7_timologiou);
		eidos8_timologiou = (TextView) findViewById(R.id.TV_eidos8_timologiou);
		posotita1_timologiou = (TextView) findViewById(R.id.TV_posotita1_timologiou);
		posotita2_timologiou = (TextView) findViewById(R.id.TV_posotita2_timologiou);
		posotita3_timologiou = (TextView) findViewById(R.id.TV_posotita3_timologiou);
		posotita4_timologiou = (TextView) findViewById(R.id.TV_posotita4_timologiou);
		posotita5_timologiou = (TextView) findViewById(R.id.TV_posotita5_timologiou);
		posotita6_timologiou = (TextView) findViewById(R.id.TV_posotita6_timologiou);
		posotita7_timologiou = (TextView) findViewById(R.id.TV_posotita7_timologiou);
		posotita8_timologiou = (TextView) findViewById(R.id.TV_posotita8_timologiou);

		String arithmos_tim = "";
		String timi_tim = "";
		String eidos1_tim = "";
		String eidos2_tim = "";
		String eidos3_tim = "";
		String eidos4_tim = "";
		String eidos5_tim = "";
		String eidos6_tim = "";
		String eidos7_tim = "";
		String eidos8_tim = "";
		String posotita1_tim = "";
		String posotita2_tim = "";
		String posotita3_tim = "";
		String posotita4_tim = "";
		String posotita5_tim = "";
		String posotita6_tim = "";
		String posotita7_tim = "";
		String posotita8_tim = "";

		Intent intent = getIntent();
		if (null != intent) {
			arithmos_tim = intent.getStringExtra(KEY_ARITHMOS_TIM_DETAIL);
			arithmos_timologiou.setText(arithmos_tim);
			timi_tim = intent.getStringExtra(KEY_TIMI_TIM_DETAIL);
			timi_timologiou.setText(timi_tim);
			eidos1_tim = intent.getStringExtra(KEY_EIDOS1_TIM_DETAIL);
			eidos1_timologiou.setText(eidos1_tim);
			eidos2_tim = intent.getStringExtra(KEY_EIDOS2_TIM_DETAIL);
			eidos2_timologiou.setText(eidos2_tim);
			eidos3_tim = intent.getStringExtra(KEY_EIDOS3_TIM_DETAIL);
			eidos3_timologiou.setText(eidos3_tim);
			eidos4_tim = intent.getStringExtra(KEY_EIDOS4_TIM_DETAIL);
			eidos4_timologiou.setText(eidos4_tim);
			eidos5_tim = intent.getStringExtra(KEY_EIDOS5_TIM_DETAIL);
			eidos5_timologiou.setText(eidos5_tim);
			eidos6_tim = intent.getStringExtra(KEY_EIDOS6_TIM_DETAIL);
			eidos6_timologiou.setText(eidos6_tim);
			eidos7_tim = intent.getStringExtra(KEY_EIDOS7_TIM_DETAIL);
			eidos7_timologiou.setText(eidos7_tim);
			eidos8_tim = intent.getStringExtra(KEY_EIDOS8_TIM_DETAIL);
			eidos8_timologiou.setText(eidos8_tim);
			posotita1_tim = intent.getStringExtra(KEY_POSOTITA1_TIM_DETAIL);
			posotita1_timologiou.setText(posotita1_tim);
			posotita2_tim = intent.getStringExtra(KEY_POSOTITA2_TIM_DETAIL);
			posotita2_timologiou.setText(posotita2_tim);
			posotita3_tim = intent.getStringExtra(KEY_POSOTITA3_TIM_DETAIL);
			posotita3_timologiou.setText(posotita3_tim);
			posotita4_tim = intent.getStringExtra(KEY_POSOTITA4_TIM_DETAIL);
			posotita4_timologiou.setText(posotita4_tim);
			posotita5_tim = intent.getStringExtra(KEY_POSOTITA5_TIM_DETAIL);
			posotita5_timologiou.setText(posotita5_tim);
			posotita6_tim = intent.getStringExtra(KEY_POSOTITA6_TIM_DETAIL);
			posotita6_timologiou.setText(posotita6_tim);
			posotita7_tim = intent.getStringExtra(KEY_POSOTITA7_TIM_DETAIL);
			posotita7_timologiou.setText(posotita7_tim);
			posotita8_tim = intent.getStringExtra(KEY_POSOTITA8_TIM_DETAIL);
			posotita8_timologiou.setText(posotita8_tim);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
