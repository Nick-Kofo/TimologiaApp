package com.cooper.timologia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cooper.timologia.R;

public class Backup extends Activity implements View.OnClickListener {

	Button backupdb, restoredb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.backup);

		backupdb = (Button) findViewById(R.id.b_backupdb);
		backupdb.setOnClickListener(this);
		restoredb = (Button) findViewById(R.id.b_restoredb);
		restoredb.setOnClickListener(this);

	}

	private void backupdbClick() {
		try {
			File sd = Environment.getExternalStorageDirectory();
			File data = Environment.getDataDirectory();

			if (sd.canWrite()) {
				String currentDBPath = "//data//com.cooper.timologia//databases//contactsManager";
				String backupDBPath = "contactsManager";
				File currentDB = new File(data, currentDBPath);
				File backupDB = new File(sd, backupDBPath);

				if (currentDB.exists()) {
					FileChannel src = new FileInputStream(currentDB)
							.getChannel();
					FileChannel dst = new FileOutputStream(backupDB)
							.getChannel();
					dst.transferFrom(src, 0, src.size());
					src.close();
					dst.close();
					Toast.makeText(getApplicationContext(),
							"Τα δεδομένα σώθηκαν στη συσκευή",
							Toast.LENGTH_SHORT).show();
				}
			}
		} catch (Exception e) {
		}

	}

	private void restoredbClick() {

		try {
			File sd = Environment.getExternalStorageDirectory();
			File data = Environment.getDataDirectory();

			if (sd.canWrite()) {
				String currentDBPath = "//data//com.cooper.timologia//databases//contactsManager";
				String backupDBPath = "contactsManager";
				File currentDB = new File(data, currentDBPath);
				File backupDB = new File(sd, backupDBPath);

				if (currentDB.exists()) {
					FileChannel src = new FileInputStream(backupDB)
							.getChannel();
					FileChannel dst = new FileOutputStream(currentDB)
							.getChannel();
					dst.transferFrom(src, 0, src.size());
					src.close();
					dst.close();
					Toast.makeText(getApplicationContext(),
							"Τα δεδομένα εισάχθηκαν με επιτυχία",
							Toast.LENGTH_SHORT).show();
				}
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_backupdb:
			backupdbClick();
			break;
		case R.id.b_restoredb:
			restoredbClick();
			break;

		default:
			break;
		}

	}
}
