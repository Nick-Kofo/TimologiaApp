package com.cooper.timologia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cooper.timologia.R;

public class Imerominies extends Activity implements View.OnClickListener {

	Button imerisia, evdomada, minas, etos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imerominies_tim);
		imerisia = (Button) findViewById(R.id.b_imerisia);
		imerisia.setOnClickListener(this);
		evdomada = (Button) findViewById(R.id.b_evdomada);
		evdomada.setOnClickListener(this);
		minas = (Button) findViewById(R.id.b_minas);
		minas.setOnClickListener(this);
		etos = (Button) findViewById(R.id.b_etos);
		etos.setOnClickListener(this);

	}

	private void imerisiaClick() {

		startActivity(new Intent("com.cooper.timologia.HMERISIA"));
	}

	private void evdomadaClick() {

		startActivity(new Intent("com.cooper.timologia.EVDOMADA"));
	}

	private void minasClick() {

		startActivity(new Intent("com.cooper.timologia.MINES"));
	}

	private void etosClick() {

		startActivity(new Intent("com.cooper.timologia.ETOS"));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_imerisia:
			imerisiaClick();
			break;
		case R.id.b_evdomada:
			evdomadaClick();
			break;
		case R.id.b_minas:
			minasClick();
			break;
		case R.id.b_etos:
			etosClick();
			break;

		default:
			break;
		}

	}
}
