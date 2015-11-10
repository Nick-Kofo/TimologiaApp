package com.cooper.timologia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cooper.timologia.R;

public class Mines extends Activity implements View.OnClickListener {

	Button ianouarios, fevrouarios, martios, aprilios, maios, iounios, ioulios, augoustos, septevrios, oktovrios, noevrios, dekevrios;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mines);
		ianouarios = (Button) findViewById(R.id.b_ianouarios);
		ianouarios.setOnClickListener(this);
		fevrouarios = (Button) findViewById(R.id.b_febrouarios);
		fevrouarios.setOnClickListener(this);
		martios = (Button) findViewById(R.id.b_martios);
		martios.setOnClickListener(this);
		aprilios = (Button) findViewById(R.id.b_aprilis);
		aprilios.setOnClickListener(this);
		maios = (Button) findViewById(R.id.b_maios);
		maios.setOnClickListener(this);
		iounios = (Button) findViewById(R.id.b_iounios);
		iounios.setOnClickListener(this);
		ioulios = (Button) findViewById(R.id.b_ioulios);
		ioulios.setOnClickListener(this);
		augoustos = (Button) findViewById(R.id.b_augoustos);
		augoustos.setOnClickListener(this);
		septevrios = (Button) findViewById(R.id.b_septemvrios);
		septevrios.setOnClickListener(this);
		oktovrios = (Button) findViewById(R.id.b_oktovrios);
		oktovrios.setOnClickListener(this);
		noevrios = (Button) findViewById(R.id.b_noemvrios);
		noevrios.setOnClickListener(this);
		dekevrios = (Button) findViewById(R.id.b_dekemvrios);
		dekevrios.setOnClickListener(this);
	}

	private void ianClick(){
		startActivity(new Intent("com.cooper.timologia.IANOUARIOS"));
	}
	private void fevClick(){
		startActivity(new Intent("com.cooper.timologia.FEVROUARIOS"));
	}
	private void marClick(){
		startActivity(new Intent("com.cooper.timologia.MARTIOS"));
	}
	private void aprClick(){
		startActivity(new Intent("com.cooper.timologia.APRILIOS"));
	}
	private void maiClick(){
		startActivity(new Intent("com.cooper.timologia.MAIOS"));
	}
	private void iouClick(){
		startActivity(new Intent("com.cooper.timologia.IOUNIOS"));
	}
	private void iulClick(){
		startActivity(new Intent("com.cooper.timologia.IOULIOS"));
	}
	private void augClick(){
		startActivity(new Intent("com.cooper.timologia.AUGOUSTOS"));
	}
	private void sepClick(){
		startActivity(new Intent("com.cooper.timologia.SEPTEVRIOS"));
	}
	private void oktClick(){
		startActivity(new Intent("com.cooper.timologia.OKTOVRIOS"));
	}
	private void noeClick(){
		startActivity(new Intent("com.cooper.timologia.NOEVRIOS"));
	}
	private void dekClick(){
		startActivity(new Intent("com.cooper.timologia.DEKEVRIOS"));
	}

	
	
	
	
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.b_ianouarios:
			ianClick();
			break;
		case R.id.b_febrouarios:
			fevClick();
			break;
		case R.id.b_martios:
			marClick();
			break;
		case R.id.b_aprilis:
			aprClick();
			break;
		case R.id.b_maios:
			maiClick();
			break;
		case R.id.b_iounios:
			iouClick();
			break;
		case R.id.b_ioulios:
			iulClick();
			break;
		case R.id.b_augoustos:
			augClick();
			break;
		case R.id.b_septemvrios:
			sepClick();
			break;
		case R.id.b_oktovrios:
			oktClick();
			break;
		case R.id.b_noemvrios:
			noeClick();
			break;
		case R.id.b_dekemvrios:
			dekClick();
			break;
		default:
			break;
		}

	}
}

