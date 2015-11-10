package com.cooper.timologia;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cooper.timologia.R;

public class PotaDetails extends Activity implements View.OnClickListener {

	Button ouiskia, vodka, gin, tequila, rum, cognaq, liker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pota);
		
		
		ouiskia = (Button) findViewById(R.id.b_ouiskia);
		ouiskia.setOnClickListener(this);
		vodka = (Button) findViewById(R.id.b_vodka);
		vodka.setOnClickListener(this);
		gin = (Button) findViewById(R.id.b_gin);
		gin.setOnClickListener(this);
		tequila = (Button) findViewById(R.id.b_tequila);
		tequila.setOnClickListener(this);
		rum = (Button) findViewById(R.id.b_rum);
		rum.setOnClickListener(this);
		cognaq = (Button) findViewById(R.id.b_cognaq);
		cognaq.setOnClickListener(this);
		liker = (Button) findViewById(R.id.b_liker);
		liker.setOnClickListener(this);
		
	}

	
	
	
	private void ouiskiaClick() {
		
		startActivity(new Intent("com.cooper.timologia.OUISKIADETAILS"));
	}
	private void vodkaClick() {
		
		startActivity(new Intent("com.cooper.timologia.VODKADETAILS"));
	}
	private void ginClick() {
		
		startActivity(new Intent("com.cooper.timologia.GINDETAILS"));
	}
	private void tequilaClick() {
		
		startActivity(new Intent("com.cooper.timologia.TEQUILADETAILS"));
	}
	private void rumClick() {
		
		startActivity(new Intent("com.cooper.timologia.RUMDETAILS"));
	}
	private void cognaqClick() {
		
		startActivity(new Intent("com.cooper.timologia.COGNAQDETAILS"));
	}
	private void likerClick() {
		
		startActivity(new Intent("com.cooper.timologia.LIKERDETAILS"));
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.b_ouiskia:
			ouiskiaClick();
			break;
		case R.id.b_vodka:
			vodkaClick();
			break;
		case R.id.b_gin:
			ginClick();
			break;
		case R.id.b_tequila:
			tequilaClick();
			break;
		case R.id.b_rum:
			rumClick();
			break;
		case R.id.b_cognaq:
			cognaqClick();
			break;
		case R.id.b_liker:
			likerClick();
			break;
		
		default:
			break;
		}

	}
}
