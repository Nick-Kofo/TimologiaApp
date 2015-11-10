package com.cooper.timologia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.cooper.timologia.R;

public class Epikinonia extends Activity {

	
	Button apostoli;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_form);
		apostoli = (Button) findViewById(R.id.BT_apostoli);

		apostoli.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	         sendEmail();
	      }

			private void sendEmail() {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"monkeydcooper@yahoo.com"});
				i.putExtra(Intent.EXTRA_SUBJECT, "Θέμα");
				i.putExtra(Intent.EXTRA_TEXT   , "Γράψτε Μήνυμα");
				try {
				    startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(Epikinonia.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}
			}
	   });		
}
	

	
	
}
