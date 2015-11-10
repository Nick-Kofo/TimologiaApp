package com.cooper.timologia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cooper.timologia.R;

public class Eidi extends Activity implements View.OnClickListener {

	Button trofima, pota, kafe, anapsiktika, bires, tsai, ouza_tsipoura,
			krasia, ylika, pagota, sinodeutika, frouta, kreatika, tirokomika;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eidi);
		pota = (Button) findViewById(R.id.b_pota);
		pota.setOnClickListener(this);
		kafe = (Button) findViewById(R.id.b_kafedes);
		kafe.setOnClickListener(this);
		trofima = (Button) findViewById(R.id.b_trofima);
		trofima.setOnClickListener(this);
		anapsiktika = (Button) findViewById(R.id.b_anapsiktika);
		anapsiktika.setOnClickListener(this);
		bires = (Button) findViewById(R.id.b_bires);
		bires.setOnClickListener(this);
		tsai = (Button) findViewById(R.id.b_tsai);
		tsai.setOnClickListener(this);
		ouza_tsipoura = (Button) findViewById(R.id.b_ouza_tsipoura);
		ouza_tsipoura.setOnClickListener(this);
		krasia = (Button) findViewById(R.id.b_krasia);
		krasia.setOnClickListener(this);
		ylika = (Button) findViewById(R.id.b_ylika);
		ylika.setOnClickListener(this);
		pagota = (Button) findViewById(R.id.b_pagota);
		pagota.setOnClickListener(this);
		sinodeutika = (Button) findViewById(R.id.b_sinodeutika);
		sinodeutika.setOnClickListener(this);
		frouta = (Button) findViewById(R.id.b_frouta);
		frouta.setOnClickListener(this);
		kreatika = (Button) findViewById(R.id.b_kreatika);
		kreatika.setOnClickListener(this);
		tirokomika = (Button) findViewById(R.id.b_tirokomika);
		tirokomika.setOnClickListener(this);
	}

	private void potaClick() {

		startActivity(new Intent("com.cooper.timologia.POTADETAILS"));
	}

	private void kafeClick() {

		startActivity(new Intent("com.cooper.timologia.KAFEDESDETAILS"));
	}

	private void trofimaClick() {

		startActivity(new Intent("com.cooper.timologia.TROFIMADETAILS"));
	}

	private void anapsiktikaClick() {

		startActivity(new Intent(
				"com.cooper.timologia.ANAPSIKTIKADETAILS"));
	}

	private void biresClick() {

		startActivity(new Intent("com.cooper.timologia.BIRESDETAILS"));
	}

	private void tsaiClick() {

		startActivity(new Intent("com.cooper.timologia.TSAIDETAILS"));
	}

	private void ouza_tsipouraClick() {

		startActivity(new Intent(
				"com.cooper.timologia.OUZATSIPOURADETAILS"));
	}

	private void krasiaClick() {

		startActivity(new Intent("com.cooper.timologia.KRASIADETAILS"));
	}

	private void ylikaClick() {

		startActivity(new Intent("com.cooper.timologia.YLIKADETAILS"));
	}

	private void pagotaClick() {

		startActivity(new Intent("com.cooper.timologia.PAGOTADETAILS"));
	}

	private void sinodeutikaClick() {

		startActivity(new Intent(
				"com.cooper.timologia.SINODEUTIKADETAILS"));
	}

	private void froutaClick() {

		startActivity(new Intent(
				"com.cooper.timologia.FROUTA_LAXDETAILS"));
	}

	private void kreatikaClick() {

		startActivity(new Intent(
				"com.cooper.timologia.KREATIKADETAILS"));
	}

	private void tirokomikaClick() {

		startActivity(new Intent(
				"com.cooper.timologia.TIROKOMIKADETAILS"));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_pota:
			potaClick();
			break;
		case R.id.b_kafedes:
			kafeClick();
			break;
		case R.id.b_trofima:
			trofimaClick();
			break;
		case R.id.b_anapsiktika:
			anapsiktikaClick();
			break;
		case R.id.b_bires:
			biresClick();
			break;
		case R.id.b_tsai:
			tsaiClick();
			break;
		case R.id.b_ouza_tsipoura:
			ouza_tsipouraClick();
			break;
		case R.id.b_krasia:
			krasiaClick();
			break;
		case R.id.b_ylika:
			ylikaClick();
			break;
		case R.id.b_pagota:
			pagotaClick();
			break;
		case R.id.b_sinodeutika:
			sinodeutikaClick();
			break;
		case R.id.b_frouta:
			froutaClick();
			break;
		case R.id.b_kreatika:
			kreatikaClick();
			break;
		case R.id.b_tirokomika:
			tirokomikaClick();
			break;
		default:
			break;
		}

	}
}
