package com.cooper.timologia;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.cooper.timologia.R;

public class Update_Tim extends Activity {
	EditText add_eponimia_tim, add_arithmos_tim, add_timi_tim, add_date_tim,
			add_eidos1_tim, add_eidos2_tim, add_eidos3_tim, add_eidos4_tim,
			add_eidos5_tim, add_eidos6_tim, add_eidos7_tim, add_eidos8_tim,
			add_posotita1_tim = null, add_posotita2_tim = null,
			add_posotita3_tim = null, add_posotita4_tim = null,
			add_posotita5_tim = null, add_posotita6_tim = null,
			add_posotita7_tim = null, add_posotita8_tim = null;
	Button add_save_btn_tim, update_btn_tim;
	LinearLayout add_view_tim, update_view_tim;
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

	// Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_screen_tim);

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
				if (valid_arithmos_tim != null && valid_timi_tim != null
						&& valid_date_tim != null
						&& valid_arithmos_tim.length() != 0
						&& valid_timi_tim.length() != 0
						&& valid_date_tim.length() != 0) {

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
					Intent add_tim = new Intent(Update_Tim.this,
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
				if (valid_arithmos_tim != null
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
					Intent add_tim = new Intent(Update_Tim.this,
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

	}

	public void Set_Add_Update_Screen() {

		add_eponimia_tim = (EditText) findViewById(R.id.ET_eponimia_tim);
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		add_date_tim.setText(sdf.format(new Date()));
		valid_date_tim = add_date_tim.getText().toString();
		add_date_tim.setVisibility(View.GONE);

		add_save_btn_tim = (Button) findViewById(R.id.add_save_btn_tim);
		update_btn_tim = (Button) findViewById(R.id.update_btn_tim);

		add_view_tim = (LinearLayout) findViewById(R.id.add_view_tim);
		update_view_tim = (LinearLayout) findViewById(R.id.update_view_tim);

		add_view_tim.setVisibility(View.GONE);
		update_view_tim.setVisibility(View.GONE);

	}

	public void Is_Valid_Sign_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Eisagete sosta ton arithmo");
			valid_arithmos_tim = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError("Ελάχιστοι χαρακτήρες " + MinLen);
			valid_arithmos_tim = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError("Μέγιστοι χαρακτήρες " + MaxLen);
			valid_arithmos_tim = null;

		} else {
			valid_arithmos_tim = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Timi_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Number Only");
			valid_arithmos_tim = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError("Minimum length " + MinLen);
			valid_arithmos_tim = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError("Maximum length " + MaxLen);
			valid_arithmos_tim = null;

		} else {
			valid_timi_tim = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Date_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Number Only");
			valid_arithmos_tim = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError("Minimum length " + MinLen);
			valid_arithmos_tim = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError("Maximum length " + MaxLen);
			valid_arithmos_tim = null;

		} else {
			valid_date_tim = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Eponimia_Name(EditText edt)
			throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Εισάγεται όνομα");
			valid_eponimia_tim = null;
		} else if (!edt.getText().toString().matches("[a-zA-Zα-ωΑ-Ω ]+")) {
			edt.setError("Εισάγεται χαρακτήρες");
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

}
