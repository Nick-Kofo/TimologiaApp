package com.cooper.timologia;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cooper.timologia.R;

public class Menu extends Activity implements View.OnClickListener {

	Button promitheutes, timologia, eidi, imer_tim, credits, epikinonia, help, sinolopromitheuton, backup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		promitheutes = (Button) findViewById(R.id.b_promitheutes);
		promitheutes.setOnClickListener(this);
		timologia = (Button) findViewById(R.id.b_timologia);
		timologia.setOnClickListener(this);
		eidi = (Button) findViewById(R.id.b_eidi);
		eidi.setOnClickListener(this);
		imer_tim = (Button) findViewById(R.id.imer_tim);
		imer_tim.setOnClickListener(this);
		epikinonia = (Button) findViewById(R.id.b_epikoinonia);
		epikinonia.setOnClickListener(this);
		credits = (Button) findViewById(R.id.b_credits);
		credits.setOnClickListener(this);
		help = (Button) findViewById(R.id.b_help);
		help.setOnClickListener(this);
		sinolopromitheuton = (Button) findViewById(R.id.b_sinolopromitheuton);
		sinolopromitheuton.setOnClickListener(this);
		backup = (Button) findViewById(R.id.b_backup);
		backup.setOnClickListener(this);

	}

	private void promitheutesClick() {

		startActivity(new Intent("com.cooper.timologia.PROMITHEUTIS"));
	}

	private void timologiaClick() {

		startActivity(new Intent("com.cooper.timologia.TIMOLOGIO"));
	}

	private void eidiClick() {

		startActivity(new Intent("com.cooper.timologia.EIDI"));
	}

	private void imerominiesClick() {

		startActivity(new Intent("com.cooper.timologia.IMEROMINIES"));
	}

	private void epikinoniaClick() {

		startActivity(new Intent("com.cooper.timologia.EPIKINONIA"));
	}

	private void creditsClick() {

		startActivity(new Intent("com.cooper.timologia.CREDITS"));
	}
	
	private void helpClick() {

		startActivity(new Intent("com.cooper.timologia.HELP"));
	}
	private void sinolopromitheutonClick() {

		startActivity(new Intent("com.cooper.timologia.SINOLOPROMITHEUTON"));
	}
	private void backupClick() {

		startActivity(new Intent("com.cooper.timologia.BACKUP"));
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_promitheutes:
			promitheutesClick();
			break;
		case R.id.b_timologia:
			timologiaClick();
			break;
		case R.id.b_eidi:
			eidiClick();
			break;
		case R.id.imer_tim:
			imerominiesClick();
			break;
		case R.id.b_epikoinonia:
			epikinoniaClick();
			break;
		case R.id.b_credits:
			creditsClick();
			break;
		case R.id.b_help:
			helpClick();
			break;
		case R.id.b_sinolopromitheuton:
			sinolopromitheutonClick();
			break;
		case R.id.b_backup:
			backupClick();
			break;

		default:
			break;
		}

	}
}
