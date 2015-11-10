package com.cooper.timologia;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cooper.timologia.R;

public class SinoloPromitheuti extends Activity implements View.OnClickListener {

	Button sinolikoposopromitheuti, evdomadieoposopromitheuti;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sinolo_promitheuton);

		sinolikoposopromitheuti = (Button) findViewById(R.id.b_sinoliko);
		sinolikoposopromitheuti.setOnClickListener(this);
		evdomadieoposopromitheuti = (Button) findViewById(R.id.b_evdomadieo);
		evdomadieoposopromitheuti.setOnClickListener(this);
		

	}

	private void sinolikoposopromitheutiClick() {

		startActivity(new Intent("com.cooper.timologia.SINOLIKOPOSOPROMITHEUTI"));
	}

	private void evdomadieoposopromitheutiClick() {

		startActivity(new Intent("com.cooper.timologia.EVDOMADIEOPOSOPROMITHEUTI"));
	}

	


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_sinoliko:
			sinolikoposopromitheutiClick();
			break;
		case R.id.b_evdomadieo:
			evdomadieoposopromitheutiClick();
			break;
		

		default:
			break;
		}

	}
}
