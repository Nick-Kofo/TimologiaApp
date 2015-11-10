package com.cooper.timologia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.cooper.timologia.R;

public class Update_User extends Activity {
	EditText add_name, add_epitheto, add_mobile, add_stathero, add_email,
			add_eidos, add_eponimia_user, add_afm, add_eidos2, add_eidos3;
	Button add_save_btn, update_btn;
	LinearLayout add_view, update_view;
	String valid_mob_number = null, valid_stathero = null, valid_email = null,
			valid_name = null, valid_epitheto = null, valid_eidos = null,
			valid_eponimia_user = null, valid_afm = null, valid_eidos2 = null,
			valid_eidos3 = null, Toast_msg = null, valid_user_id = "";
	int USER_ID;
	DatabaseHandler dbHandler = new DatabaseHandler(this);
	// Spinner spinner, spinner2, spinner3;
	ArrayAdapter<String> dataAdapter;
	int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_screen);

		// set screen
		Set_Add_Update_Screen();

		// set visibility of view as per calling activity
		String called_from = getIntent().getStringExtra("called");

		if (called_from.equalsIgnoreCase("add")) {
			add_view.setVisibility(View.VISIBLE);
			update_view.setVisibility(View.GONE);
		} else {

			update_view.setVisibility(View.VISIBLE);
			add_view.setVisibility(View.GONE);
			USER_ID = Integer.parseInt(getIntent().getStringExtra("USER_ID"));

			Contact c = dbHandler.Get_Contact(USER_ID);

			add_name.setText(c.getName());
			add_epitheto.setText(c.getEpitheto());
			add_mobile.setText(c.getPhoneNumber());
			add_stathero.setText(c.getStathero());
			add_email.setText(c.getEmail());
			add_eidos.setText(c.getEidos());
			add_eponimia_user.setText(c.getEponimiaUser());
			add_afm.setText(c.getAFM());
			add_eidos2.setText(c.getEidos2());
			add_eidos3.setText(c.getEidos3());
			// dbHandler.close();
		}
		add_mobile.addTextChangedListener(new TextWatcher() {

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
				// min lenth 10 and max lenth 12 (2 extra for - as per phone
				// matcher format)
				Is_Valid_Sign_Number_Validation(10, 10, add_mobile);
			}
		});
		// add_mobile.addTextChangedListener(new
		// PhoneNumberFormattingTextWatcher());
		add_stathero.addTextChangedListener(new TextWatcher() {

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
				// min lenth 10 and max lenth 12 (2 extra for - as per phone
				// matcher format)
				Is_Valid_Sign_Number_Stathero_Validation(10, 10, add_stathero);
			}
		});
		// add_stathero.addTextChangedListener(new
		// PhoneNumberFormattingTextWatcher());
		add_afm.addTextChangedListener(new TextWatcher() {

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
				// min lenth 10 and max lenth 12 (2 extra for - as per phone
				// matcher format)
				Is_Valid_Afm(9, 9, add_afm);
			}
		});
		// add_afm.addTextChangedListener(new
		// PhoneNumberFormattingTextWatcher());

		add_email.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Email(add_email);
			}
		});

		add_name.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Person_Name(add_name);
			}
		});

		add_epitheto.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Person_Epitheto(add_epitheto);
			}
		});
		add_eponimia_user.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Eponimia_User(add_eponimia_user);
			}
		});

		add_eidos.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos(add_eidos);
			}

		});
		add_eidos2.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos2(add_eidos2);
			}

		});
		add_eidos3.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Eidos3(add_eidos3);
			}

		});

		add_save_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// check the value state is null or not

				if (valid_name != null && valid_epitheto != null
						&& valid_mob_number != null && valid_stathero != null
						&& valid_email != null && valid_eponimia_user != null
						&& valid_afm != null && valid_name.length() != 0
						&& valid_epitheto.length() != 0
						&& valid_mob_number.length() != 0
						&& valid_stathero.length() != 0
						&& valid_email.length() != 0
						&& valid_eidos.length() != 0
						&& valid_eponimia_user.length() != 0
						&& valid_afm.length() != 0) {

					dbHandler.Add_Contact(new Contact(valid_name,
							valid_epitheto, valid_mob_number, valid_stathero,
							valid_email, valid_eidos, valid_eponimia_user,
							valid_afm, valid_eidos2, valid_eidos3));
					Toast_msg = "Ο προμηθευτής εισάχθηκε επιτυχώς";
					Show_Toast(Toast_msg);
					Reset_Text();
					// na dioxnei to pliktrologio gia na fenete kalitera to
					// Emfanisi
					InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

					inputManager.hideSoftInputFromWindow(getCurrentFocus()
							.getWindowToken(),
							InputMethodManager.HIDE_NOT_ALWAYS);
					Intent add_user = new Intent(Update_User.this,
							Promitheutis.class);
					add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(add_user);
				} else {
					Toast_msg = "Κάποια πεδία είναι κενά\n συμπληρώστε τα υποχρεωτικα πεδία";
					Show_Toast(Toast_msg);
				}

			}
		});

		update_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				valid_name = add_name.getText().toString();
				valid_epitheto = add_epitheto.getText().toString();
				valid_mob_number = add_mobile.getText().toString();
				valid_stathero = add_stathero.getText().toString();
				valid_email = add_email.getText().toString();
				valid_eidos = add_eidos.getText().toString();
				valid_eponimia_user = add_eponimia_user.getText().toString();
				valid_afm = add_afm.getText().toString();
				valid_eidos2 = add_eidos2.getText().toString();
				valid_eidos3 = add_eidos3.getText().toString();

				// check the value state is null or not
				if (valid_name != null && valid_epitheto != null
						&& valid_mob_number != null 
						&& valid_name.length() != 0
						&& valid_epitheto.length() != 0
						&& valid_mob_number.length() != 0
					    && valid_eidos != null
						&& valid_eidos.length() != 0
						&& valid_eponimia_user != null
						&& valid_eponimia_user.length() != 0
						&& valid_afm != null && valid_afm.length() != 0) {

					dbHandler.Update_Contact(new Contact(USER_ID, valid_name,
							valid_epitheto, valid_mob_number, valid_stathero,
							valid_email, valid_eidos, valid_eponimia_user,
							valid_afm, valid_eidos2, valid_eidos3));
					dbHandler.close();
					Toast_msg = "Τα δεδομένα εισάχθηκαν επιτυχώς";
					Show_Toast(Toast_msg);
					Reset_Text();
					// na dioxnei to pliktrologio gia na fenete kalitera to
					// Emfanisi
					InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

					inputManager.hideSoftInputFromWindow(getCurrentFocus()
							.getWindowToken(),
							InputMethodManager.HIDE_NOT_ALWAYS);
					Intent add_user = new Intent(Update_User.this,
							Promitheutis.class);
					add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(add_user);
				} else {
					Toast_msg = "Κάποια πεδία είναι κενά\n συμπληρώστε τα υποχρεωτικα πεδία";
					Show_Toast(Toast_msg);
				}

			}
		});

	}

	public void Set_Add_Update_Screen() {

		add_name = (EditText) findViewById(R.id.add_name);
		add_epitheto = (EditText) findViewById(R.id.add_epitheto);
		add_mobile = (EditText) findViewById(R.id.add_mobile);
		add_stathero = (EditText) findViewById(R.id.add_stathero);
		add_email = (EditText) findViewById(R.id.add_email);
		add_eidos = (EditText) findViewById(R.id.add_eidos);
		add_eponimia_user = (EditText) findViewById(R.id.add_eponimia_user);
		add_afm = (EditText) findViewById(R.id.add_afm);
		add_eidos2 = (EditText) findViewById(R.id.add_eidos2);
		add_eidos3 = (EditText) findViewById(R.id.add_eidos3);

		// spinner = (Spinner) findViewById(R.id.spinner);

		add_save_btn = (Button) findViewById(R.id.add_save_btn);
		update_btn = (Button) findViewById(R.id.update_btn);

		add_view = (LinearLayout) findViewById(R.id.add_view);
		update_view = (LinearLayout) findViewById(R.id.update_view);

		add_view.setVisibility(View.GONE);
		update_view.setVisibility(View.GONE);

	}

	public void Is_Valid_Sign_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Αριθμούς μόνο");
			valid_mob_number = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError("Ελάχιστοι χαρακτήρες " + MinLen);
			valid_mob_number = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError("Μέγιστοι χαρακτήρες " + MaxLen);
			valid_mob_number = null;

		} else {
			valid_mob_number = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Sign_Number_Stathero_Validation(int MinLen,
			int MaxLen, EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Αριθμούς μόνο");
			valid_stathero = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError("Ελάχιστοι χαρακτήρες " + MinLen);
			valid_stathero = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError("Μέγιστοι χαρακτήρες " + MaxLen);
			valid_stathero = null;

		} else {
			valid_stathero = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Afm(int MinLen, int MaxLen, EditText edt)
			throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Αριθμούς μόνο");
			valid_afm = null;
		} else if (edt.getText().toString().length() < MinLen) {
			edt.setError("Ελάχιστοι χαρακτήρες " + MinLen);
			valid_afm = null;

		} else if (edt.getText().toString().length() > MaxLen) {
			edt.setError("Μέγιστοι χαρακτήρες " + MaxLen);
			valid_afm = null;

		} else {
			valid_afm = edt.getText().toString();

		}

	} // END OF Edittext validation

	public void Is_Valid_Email(EditText edt) {
		if (edt.getText().toString() == null) {
			edt.setError("Άκυρη διεύθυνση email");
			valid_email = null;
		} else if (isEmailValid(edt.getText().toString()) == false) {
			edt.setError("Άκυρη διεύθυνση email");
			valid_email = null;
		} else {
			valid_email = edt.getText().toString();
		}
	}

	boolean isEmailValid(CharSequence email) {
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	} // end of email matcher

	public void Is_Valid_Person_Name(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Εισάγεται όνομα");
			valid_name = null;
		} else if (!edt.getText().toString().matches("[a-zA-Zα-ωΑ-Ω ]+")) {
			edt.setError("Εισάγεται χαρακτήρες");
			valid_name = null;
		} else {
			valid_name = edt.getText().toString();
		}

	}

	public void Is_Valid_Person_Epitheto(EditText edt)
			throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Εισάγεται όνομα");
			valid_epitheto = null;
		} else if (!edt.getText().toString().matches("[a-zA-Zα-ωΑ-Ω ]+")) {
			edt.setError("Εισάγεται χαρακτήρες");
			valid_epitheto = null;
		} else {
			valid_epitheto = edt.getText().toString();
		}

	}

	public void Is_Valid_Eponimia_User(EditText edt)
			throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Εισάγεται όνομα");
			valid_eponimia_user = null;
		} else if (!edt.getText().toString().matches("[a-zA-Zα-ωΑ-Ω ]+")) {
			edt.setError("Εισάγεται χαρακτήρες");
			valid_eponimia_user = null;
		} else {
			valid_eponimia_user = edt.getText().toString();
		}

	}

	public void Is_Valid_Eidos(EditText edt) throws NumberFormatException {

		valid_eidos = edt.getText().toString();

	}

	public void Is_Valid_Eidos2(EditText edt) throws NumberFormatException {

		valid_eidos2 = edt.getText().toString();

	}

	public void Is_Valid_Eidos3(EditText edt) throws NumberFormatException {

		valid_eidos3 = edt.getText().toString();

	}

	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

	public void Reset_Text() {

		add_name.getText().clear();
		add_epitheto.getText().clear();
		add_mobile.getText().clear();
		add_stathero.getText().clear();
		add_email.getText().clear();
		add_eidos.getText().clear();
		add_eponimia_user.getText().clear();
		add_afm.getText().clear();
		add_eidos2.getText().clear();
		add_eidos3.getText().clear();

	}

}
