package com.cooper.timologia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 26;

	// Database Name
	private static final String DATABASE_NAME = "contactsManager";

	// Contacts table name
	private static final String TABLE_CONTACTS = "contacts";
	private static final String TABLE_TIMOLOGIA = "timologia";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_EPITHETO = "epitheto";
	private static final String KEY_PH_NO = "phone_number";
	private static final String KEY_STATHERO = "stathero";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_EIDOS = "eidos";
	private static final String KEY_EPONIMIA_USER = "eponimia_user";
	private static final String KEY_AFM = "afm";
	private static final String KEY_EIDOS2 = "eidos2";
	private static final String KEY_EIDOS3 = "eidos3";

	// Timologia Table Columns names
	private static final String KEY_ID_TIM = "id_tim";
	private static final String KEY_EPONIMIA_TIM = "eponimia_tim";
	private static final String KEY_ARITHMOS_TIM = "arithmos_tim";
	private static final String KEY_TIMI_TIM = "timi_tim";
	private static final String KEY_DATE_TIM = "date_tim";
	private static final String KEY_EIDOS1_TIM = "eidos1_tim";
	private static final String KEY_EIDOS2_TIM = "eidos2_tim";
	private static final String KEY_EIDOS3_TIM = "eidos3_tim";
	private static final String KEY_EIDOS4_TIM = "eidos4_tim";
	private static final String KEY_EIDOS5_TIM = "eidos5_tim";
	private static final String KEY_EIDOS6_TIM = "eidos6_tim";
	private static final String KEY_EIDOS7_TIM = "eidos7_tim";
	private static final String KEY_EIDOS8_TIM = "eidos8_tim";
	private static final String KEY_POSOTITA1_TIM = "posotita1_tim";
	private static final String KEY_POSOTITA2_TIM = "posotita2_tim";
	private static final String KEY_POSOTITA3_TIM = "posotita3_tim";
	private static final String KEY_POSOTITA4_TIM = "posotita4_tim";
	private static final String KEY_POSOTITA5_TIM = "posotita5_tim";
	private static final String KEY_POSOTITA6_TIM = "posotita6_tim";
	private static final String KEY_POSOTITA7_TIM = "posotita7_tim";
	private static final String KEY_POSOTITA8_TIM = "posotita8_tim";

	private final ArrayList<Contact> contact_list = new ArrayList<Contact>();
	private final ArrayList<Timologia> timologia_list = new ArrayList<Timologia>();

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_EPITHETO + " TEXT," + KEY_PH_NO + " TEXT UNIQUE,"
				+ KEY_STATHERO + " TEXT," + KEY_EMAIL + " TEXT," + KEY_EIDOS
				+ " TEXT," + KEY_EPONIMIA_USER + " TEXT," + KEY_AFM + " TEXT,"
				+ KEY_EIDOS2 + " TEXT," + KEY_EIDOS3 + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
		String CREATE_TIMOLOGIA_TABLE = "CREATE TABLE " + TABLE_TIMOLOGIA + "("
				+ KEY_ID_TIM + " INTEGER PRIMARY KEY," + KEY_EPONIMIA_TIM
				+ " TEXT," + KEY_ARITHMOS_TIM + " TEXT UNIQUE," + KEY_TIMI_TIM
				+ " FLOAT," + KEY_DATE_TIM + " DATE," + KEY_EIDOS1_TIM
				+ " TEXT," + KEY_EIDOS2_TIM + " TEXT," + KEY_EIDOS3_TIM
				+ " TEXT," + KEY_EIDOS4_TIM + " TEXT," + KEY_EIDOS5_TIM
				+ " TEXT," + KEY_EIDOS6_TIM + " TEXT," + KEY_EIDOS7_TIM
				+ " TEXT," + KEY_EIDOS8_TIM + " TEXT," + KEY_POSOTITA1_TIM
				+ " REAL," + KEY_POSOTITA2_TIM + " REAL," + KEY_POSOTITA3_TIM
				+ " REAL," + KEY_POSOTITA4_TIM + " REAL," + KEY_POSOTITA5_TIM
				+ " REAL," + KEY_POSOTITA6_TIM + " REAL," + KEY_POSOTITA7_TIM
				+ " REAL," + KEY_POSOTITA8_TIM + " REAL" + ")";
		db.execSQL(CREATE_TIMOLOGIA_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIMOLOGIA);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	public void Add_Contact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName()); // Contact Name
		values.put(KEY_EPITHETO, contact.getEpitheto()); // Contact Epitheto
		values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone
		values.put(KEY_STATHERO, contact.getStathero()); // Contact Stathero
		values.put(KEY_EMAIL, contact.getEmail()); // Contact Email
		values.put(KEY_EIDOS, contact.getEidos()); // Contact Eidos
		values.put(KEY_EPONIMIA_USER, contact.getEponimiaUser()); // Contact
																	// Eponimia
																	// User
		values.put(KEY_AFM, contact.getAFM()); // Contact AFM
		values.put(KEY_EIDOS2, contact.getEidos2()); // Contact EIDOS2
		values.put(KEY_EIDOS3, contact.getEidos3()); // Contact EIDOS3
		// Inserting Row
		// Inserting Row
		try {
			db.insertOrThrow(TABLE_CONTACTS, null, values);
		} catch (Exception e) {
			Log.e("Already Stored", "true");
		}
		db.close(); // Closing database connection
	}

	// Adding new timologio
	public void Add_Timologio(Timologia timologia) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm",
				java.util.Locale.getDefault()); // morfi imerominias
		Date date = new Date();

		values.put(KEY_EPONIMIA_TIM, timologia.getEponimiaTim());
		values.put(KEY_ARITHMOS_TIM, timologia.getArithmoTim()); // Contact
																	// Arithmo
																	// timologiou
		values.put(KEY_TIMI_TIM, timologia.getTimiTim());
		values.put(KEY_DATE_TIM, dateFormat.format(date));
		values.put(KEY_EIDOS1_TIM, timologia.getEidos1Tim());
		values.put(KEY_EIDOS2_TIM, timologia.getEidos2Tim());
		values.put(KEY_EIDOS3_TIM, timologia.getEidos3Tim());
		values.put(KEY_EIDOS4_TIM, timologia.getEidos4Tim());
		values.put(KEY_EIDOS5_TIM, timologia.getEidos5Tim());
		values.put(KEY_EIDOS6_TIM, timologia.getEidos6Tim());
		values.put(KEY_EIDOS7_TIM, timologia.getEidos7Tim());
		values.put(KEY_EIDOS8_TIM, timologia.getEidos8Tim());
		values.put(KEY_POSOTITA1_TIM, timologia.getPosotita1Tim());
		values.put(KEY_POSOTITA2_TIM, timologia.getPosotita2Tim());
		values.put(KEY_POSOTITA3_TIM, timologia.getPosotita3Tim());
		values.put(KEY_POSOTITA4_TIM, timologia.getPosotita4Tim());
		values.put(KEY_POSOTITA5_TIM, timologia.getPosotita5Tim());
		values.put(KEY_POSOTITA6_TIM, timologia.getPosotita6Tim());
		values.put(KEY_POSOTITA7_TIM, timologia.getPosotita7Tim());
		values.put(KEY_POSOTITA8_TIM, timologia.getPosotita8Tim());

		// Inserting Row
		try {
			db.insertOrThrow(TABLE_TIMOLOGIA, null, values);
		} catch (Exception e) {
			Log.e("Already Stored", "true");
		}
		db.close(); // Closing database connection
	}

	// Getting single contact
	Contact Get_Contact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTS,
				new String[] { KEY_ID, KEY_NAME, KEY_EPITHETO, KEY_PH_NO,
						KEY_STATHERO, KEY_EMAIL, KEY_EIDOS, KEY_EPONIMIA_USER,
						KEY_AFM, KEY_EIDOS2, KEY_EIDOS3 }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(5), cursor.getString(6),
				cursor.getString(7), cursor.getString(8), cursor.getString(9),
				cursor.getString(10));
		// return contact
		cursor.close();
		db.close();

		return contact;
	}

	// Getting single timologio
	Timologia Get_Timologio(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_TIMOLOGIA, new String[] { KEY_ID_TIM,
				KEY_EPONIMIA_TIM, KEY_ARITHMOS_TIM, KEY_TIMI_TIM, KEY_DATE_TIM,
				KEY_EIDOS1_TIM, KEY_EIDOS2_TIM, KEY_EIDOS3_TIM, KEY_EIDOS4_TIM,
				KEY_EIDOS5_TIM, KEY_EIDOS6_TIM, KEY_EIDOS7_TIM, KEY_EIDOS8_TIM,
				KEY_POSOTITA1_TIM, KEY_POSOTITA2_TIM, KEY_POSOTITA3_TIM,
				KEY_POSOTITA4_TIM, KEY_POSOTITA5_TIM, KEY_POSOTITA6_TIM,
				KEY_POSOTITA7_TIM, KEY_POSOTITA8_TIM }, KEY_ID_TIM + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Timologia timologia = new Timologia(Integer.parseInt(cursor
				.getString(0)), cursor.getString(1), cursor.getString(2),
				cursor.getString(3), cursor.getString(4), cursor.getString(5),
				cursor.getString(6), cursor.getString(7), cursor.getString(8),
				cursor.getString(9), cursor.getString(10),
				cursor.getString(11), cursor.getString(12),
				cursor.getString(13), cursor.getString(14),
				cursor.getString(15), cursor.getString(16),
				cursor.getString(17), cursor.getString(18),
				cursor.getString(19), cursor.getString(20));
		// return contact
		cursor.close();
		db.close();

		return timologia;
	}

	// Getting All Contacts
	public ArrayList<Contact> Get_Contacts() {
		try {
			contact_list.clear();

			// Select All Query
			String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
					+ " ORDER BY id DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Contact contact = new Contact();
					contact.setID(Integer.parseInt(cursor.getString(0)));
					contact.setName(cursor.getString(1));
					contact.setEpitheto(cursor.getString(2));
					contact.setPhoneNumber(cursor.getString(3));
					contact.setStathero(cursor.getString(4));
					contact.setEmail(cursor.getString(5));
					contact.setEidos(cursor.getString(6));
					contact.setEponimiaUser(cursor.getString(7));
					contact.setAFM(cursor.getString(8));
					contact.setEidos2(cursor.getString(9));
					contact.setEidos3(cursor.getString(10));
					// Adding contact to list
					contact_list.add(contact);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return contact_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_contact", "" + e);
		}

		return contact_list;
	}

	// Getting Spinner DETAILS
	public ArrayList<Timologia> Get_SpinnerDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT  * FROM timologia WHERE eponimia_tim ='"
					+ SinolikoPosoPromitheuti.item + "'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting Spinner DETAILS Evdomadas
	public ArrayList<Timologia> Get_SpinnerDetailsEvdomadas() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT  * FROM timologia WHERE strftime('%W', date_tim) = strftime('%W', 'now')"
					+ "AND eponimia_tim ='"
					+ EvdomadieoPosoPromitheuti.evdomadieoitem + "'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// -----------------------------------------------------------------------------------------------------------
	// Getting All Timologia
	public ArrayList<Timologia> Get_Timologia() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT  * FROM " + TABLE_TIMOLOGIA
					+ " ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// -----------------------------------------------------------------------------------------------------------------------------

	// Updating single contact
	public int Update_Contact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_EPITHETO, contact.getEpitheto());
		values.put(KEY_PH_NO, contact.getPhoneNumber());
		values.put(KEY_STATHERO, contact.getStathero());
		values.put(KEY_EMAIL, contact.getEmail());
		values.put(KEY_EIDOS, contact.getEidos());
		values.put(KEY_EPONIMIA_USER, contact.getEponimiaUser());
		values.put(KEY_AFM, contact.getAFM());
		values.put(KEY_EIDOS2, contact.getEidos2());
		values.put(KEY_EIDOS3, contact.getEidos3());

		// updating row
		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
				new String[] { String.valueOf(contact.getID()) });
	}

	// Updating single timologio
	public int Update_Timologio(Timologia timologio) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(KEY_EPONIMIA_TIM, timologio.getEponimiaTim());
		values.put(KEY_ARITHMOS_TIM, timologio.getArithmoTim());
		values.put(KEY_TIMI_TIM, timologio.getTimiTim());
		values.put(KEY_DATE_TIM, timologio.getDateTim());
		values.put(KEY_EIDOS1_TIM, timologio.getEidos1Tim());
		values.put(KEY_EIDOS2_TIM, timologio.getEidos2Tim());
		values.put(KEY_EIDOS3_TIM, timologio.getEidos3Tim());
		values.put(KEY_EIDOS4_TIM, timologio.getEidos4Tim());
		values.put(KEY_EIDOS5_TIM, timologio.getEidos5Tim());
		values.put(KEY_EIDOS6_TIM, timologio.getEidos6Tim());
		values.put(KEY_EIDOS7_TIM, timologio.getEidos7Tim());
		values.put(KEY_EIDOS8_TIM, timologio.getEidos8Tim());
		values.put(KEY_POSOTITA1_TIM, timologio.getPosotita1Tim());
		values.put(KEY_POSOTITA2_TIM, timologio.getPosotita2Tim());
		values.put(KEY_POSOTITA3_TIM, timologio.getPosotita3Tim());
		values.put(KEY_POSOTITA4_TIM, timologio.getPosotita4Tim());
		values.put(KEY_POSOTITA5_TIM, timologio.getPosotita5Tim());
		values.put(KEY_POSOTITA6_TIM, timologio.getPosotita6Tim());
		values.put(KEY_POSOTITA7_TIM, timologio.getPosotita7Tim());
		values.put(KEY_POSOTITA8_TIM, timologio.getPosotita8Tim());

		// updating row
		return db.update(TABLE_TIMOLOGIA, values, KEY_ID_TIM + " = ?",
				new String[] { String.valueOf(timologio.getIDTim()) });
	}

	// Deleting single contact
	public void Delete_Contact(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
				new String[] { String.valueOf(id) });
		db.close();
	}

	// Deleting single timologio
	public void Delete_Timologia(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_TIMOLOGIA, KEY_ID_TIM + " = ?",
				new String[] { String.valueOf(id) });
		db.close();
	}

	// Getting contacts Count
	public int Get_Total_Contacts() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	// Getting timologia Count
	public int Get_Total_Timologia() {
		String countQuery = "SELECT  * FROM " + TABLE_TIMOLOGIA;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	// Getting KAFEDES DETAILS
	public ArrayList<Timologia> Get_KafedesDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Εσπρέσσο' " + "OR eidos1_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos1_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos1_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos1_tim = " + "'στικ ζάχαρη'" + "OR eidos1_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos1_tim = " + "'ζαχαρίνες'"
					+ "OR eidos1_tim = " + "'νόβο μακράς'" + "OR eidos1_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos1_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos1_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos1_tim = " + "'όρεο'"
					+ "OR eidos1_tim = " + "'σιρόπια'" + "OR eidos1_tim = "
					+ "'Νεσκαφέ'" + "OR eidos1_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos1_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos1_tim = " + "'Μαρασκίνο'" + "OR eidos1_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos1_tim = " + "'Ελληνικός'"
					+ "OR eidos1_tim = " + "'τρούφα'" + "OR eidos1_tim = "
					+ "'φίλλερ'" + "OR eidos1_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos1_tim = " + "'Frio'" + "OR eidos1_tim = "
					+ "'Freddoccino'" + "OR eidos1_tim = " + "'Latin Dance'"
					+ "OR eidos1_tim = " + "'Canderel'" + "OR eidos2_tim = "
					+ "'Εσπρέσσο'" + "OR eidos2_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos2_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos2_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos2_tim = " + "'στικ ζάχαρη'" + "OR eidos2_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos2_tim = " + "'ζαχαρίνες'"
					+ "OR eidos2_tim = " + "'νόβο μακράς'" + "OR eidos2_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos2_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos2_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos2_tim = " + "'όρεο'"
					+ "OR eidos2_tim = " + "'σιρόπια'" + "OR eidos2_tim = "
					+ "'Νεσκαφέ'" + "OR eidos2_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos2_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos2_tim = " + "'Μαρασκίνο'" + "OR eidos2_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos2_tim = " + "'Ελληνικός'"
					+ "OR eidos2_tim = " + "'τρούφα'" + "OR eidos2_tim = "
					+ "'φίλλερ'" + "OR eidos2_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos2_tim = " + "'Frio'" + "OR eidos2_tim = "
					+ "'Freddoccino'" + "OR eidos2_tim = " + "'Latin Dance'"
					+ "OR eidos2_tim = " + "'Canderel'" + "OR eidos3_tim = "
					+ "'Εσπρέσσο'" + "OR eidos3_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos3_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos3_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos3_tim = " + "'στικ ζάχαρη'" + "OR eidos3_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos3_tim = " + "'ζαχαρίνες'"
					+ "OR eidos3_tim = " + "'νόβο μακράς'" + "OR eidos3_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos3_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos3_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos3_tim = " + "'όρεο'"
					+ "OR eidos3_tim = " + "'σιρόπια'" + "OR eidos3_tim = "
					+ "'Νεσκαφέ'" + "OR eidos3_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos3_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos3_tim = " + "'Μαρασκίνο'" + "OR eidos3_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos3_tim = " + "'Ελληνικός'"
					+ "OR eidos3_tim = " + "'τρούφα'" + "OR eidos3_tim = "
					+ "'φίλλερ'" + "OR eidos3_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos3_tim = " + "'Frio'" + "OR eidos3_tim = "
					+ "'Freddoccino'" + "OR eidos3_tim = " + "'Latin Dance'"
					+ "OR eidos3_tim = " + "'Canderel'" + "OR eidos4_tim = "
					+ "'Εσπρέσσο'" + "OR eidos4_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos4_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos4_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos4_tim = " + "'στικ ζάχαρη'" + "OR eidos4_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos4_tim = " + "'ζαχαρίνες'"
					+ "OR eidos4_tim = " + "'νόβο μακράς'" + "OR eidos4_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos4_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos4_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos4_tim = " + "'όρεο'"
					+ "OR eidos4_tim = " + "'σιρόπια'" + "OR eidos4_tim = "
					+ "'Νεσκαφέ'" + "OR eidos4_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos4_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos4_tim = " + "'Μαρασκίνο'" + "OR eidos4_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos4_tim = " + "'Ελληνικός'"
					+ "OR eidos4_tim = " + "'τρούφα'" + "OR eidos4_tim = "
					+ "'φίλλερ'" + "OR eidos4_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos4_tim = " + "'Frio'" + "OR eidos4_tim = "
					+ "'Freddoccino'" + "OR eidos4_tim = " + "'Latin Dance'"
					+ "OR eidos4_tim = " + "'Canderel'" + "OR eidos5_tim = "
					+ "'Εσπρέσσο'" + "OR eidos5_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos5_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos5_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos5_tim = " + "'στικ ζάχαρη'" + "OR eidos5_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos5_tim = " + "'ζαχαρίνες'"
					+ "OR eidos5_tim = " + "'νόβο μακράς'" + "OR eidos5_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos5_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos5_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos5_tim = " + "'όρεο'"
					+ "OR eidos5_tim = " + "'σιρόπια'" + "OR eidos5_tim = "
					+ "'Νεσκαφέ'" + "OR eidos5_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos5_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos5_tim = " + "'Μαρασκίνο'" + "OR eidos5_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos5_tim = " + "'Ελληνικός'"
					+ "OR eidos5_tim = " + "'τρούφα'" + "OR eidos5_tim = "
					+ "'φίλλερ'" + "OR eidos5_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos5_tim = " + "'Frio'" + "OR eidos5_tim = "
					+ "'Freddoccino'" + "OR eidos5_tim = " + "'Latin Dance'"
					+ "OR eidos5_tim = " + "'Canderel'" + "OR eidos6_tim = "
					+ "'Εσπρέσσο'" + "OR eidos6_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos6_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos6_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos6_tim = " + "'στικ ζάχαρη'" + "OR eidos6_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos6_tim = " + "'ζαχαρίνες'"
					+ "OR eidos6_tim = " + "'νόβο μακράς'" + "OR eidos6_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos6_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos6_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos6_tim = " + "'όρεο'"
					+ "OR eidos6_tim = " + "'σιρόπια'" + "OR eidos6_tim = "
					+ "'Νεσκαφέ'" + "OR eidos6_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos6_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos6_tim = " + "'Μαρασκίνο'" + "OR eidos6_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos6_tim = " + "'Ελληνικός'"
					+ "OR eidos6_tim = " + "'τρούφα'" + "OR eidos6_tim = "
					+ "'φίλλερ'" + "OR eidos6_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos6_tim = " + "'Frio'" + "OR eidos6_tim = "
					+ "'Freddoccino'" + "OR eidos6_tim = " + "'Latin Dance'"
					+ "OR eidos6_tim = " + "'Canderel'" + "OR eidos7_tim = "
					+ "'Εσπρέσσο'" + "OR eidos7_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos7_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos7_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos7_tim = " + "'στικ ζάχαρη'" + "OR eidos7_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos7_tim = " + "'ζαχαρίνες'"
					+ "OR eidos7_tim = " + "'νόβο μακράς'" + "OR eidos7_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos7_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos7_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos7_tim = " + "'όρεο'"
					+ "OR eidos7_tim = " + "'σιρόπια'" + "OR eidos7_tim = "
					+ "'Νεσκαφέ'" + "OR eidos7_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos7_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos7_tim = " + "'Μαρασκίνο'" + "OR eidos7_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos7_tim = " + "'Ελληνικός'"
					+ "OR eidos7_tim = " + "'τρούφα'" + "OR eidos7_tim = "
					+ "'φίλλερ'" + "OR eidos7_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos7_tim = " + "'Frio'" + "OR eidos7_tim = "
					+ "'Freddoccino'" + "OR eidos7_tim = " + "'Latin Dance'"
					+ "OR eidos7_tim = " + "'Canderel'" + "OR eidos8_tim = "
					+ "'Εσπρέσσο'" + "OR eidos8_tim = " + "'Εσπρέσσο.ντεκάφ'"
					+ "OR eidos8_tim = " + "'σοκολάτα ζεστή'"
					+ "OR eidos8_tim = " + "'σοκολάτα κρύα'"
					+ "OR eidos8_tim = " + "'στικ ζάχαρη'" + "OR eidos8_tim = "
					+ "'στικ μάυρη ζαχ'" + "OR eidos8_tim = " + "'ζαχαρίνες'"
					+ "OR eidos8_tim = " + "'νόβο μακράς'" + "OR eidos8_tim = "
					+ "'νόβο εβαπορέ'" + "OR eidos8_tim = "
					+ "'Φρεντίτο βανίλ.'" + "OR eidos8_tim = "
					+ "'φρεντίτο σοκολ.'" + "OR eidos8_tim = " + "'όρεο'"
					+ "OR eidos8_tim = " + "'σιρόπια'" + "OR eidos8_tim = "
					+ "'Νεσκαφέ'" + "OR eidos8_tim = " + "'Νεσ. ντεκάφ'"
					+ "OR eidos8_tim = " + "'Ζάχαρη κιλού'"
					+ "OR eidos8_tim = " + "'Μαρασκίνο'" + "OR eidos8_tim = "
					+ "'σιρόπι βύσσινο'" + "OR eidos8_tim = " + "'Ελληνικός'"
					+ "OR eidos8_tim = " + "'τρούφα'" + "OR eidos8_tim = "
					+ "'φίλλερ'" + "OR eidos8_tim = " + "'σοκολάτα oreo'"
					+ "OR eidos8_tim = " + "'Frio'" + "OR eidos8_tim = "
					+ "'Freddoccino'" + "OR eidos8_tim = " + "'Latin Dance'"
					+ "OR eidos8_tim = " + "'Canderel'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting ΜΠΙΡΕΣ DETAILS
	public ArrayList<Timologia> Get_BiresDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'fix'" + "OR eidos1_tim = " + "'fix dark'"
					+ "OR eidos1_tim = " + "'κάϊσερ'" + "OR eidos1_tim = "
					+ "'κάϊσερ blonde'" + "OR eidos1_tim = " + "'carlsberg'"
					+ "OR eidos1_tim = " + "'corona'" + "OR eidos1_tim = "
					+ "'kilkeny'" + "OR eidos1_tim = " + "'fisher'"
					+ "OR eidos1_tim = " + "'somersby'" + "OR eidos1_tim = "
					+ "'bud'" + "OR eidos1_tim = " + "'μύθος'"
					+ "OR eidos1_tim = " + "'fix βαρέλι'" + "OR eidos1_tim = "
					+ "'κάϊσερ βαρέλι'" + "OR eidos1_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos1_tim = " + "'βόρεια pilsner'"
					+ "OR eidos1_tim = " + "'βόρεια india'"
					+ "OR eidos1_tim = " + "'heineken'" + "OR eidos1_tim = "
					+ "'amstel'" + "OR eidos1_tim = " + "'mcfarland'"
					+ "OR eidos1_tim = " + "'stella'" + "OR eidos1_tim = "
					+ "'erdinger'" + "OR eidos1_tim = " + "'paulaner'"
					+ "OR eidos1_tim = " + "'chimay'" + "OR eidos1_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos1_tim = " + "'fischer βαρέλι'"
					+ "OR eidos1_tim = " + "'buckler'" + "OR eidos1_tim = "
					+ "'desperados'" + "OR eidos1_tim = " + "'estrella'"
					+ "OR eidos1_tim = " + "'volkan'" + "OR eidos1_tim = "
					+ "'volkan black'" + "OR eidos2_tim = " + "'fix'"
					+ "OR eidos2_tim = " + "'fix dark'" + "OR eidos2_tim = "
					+ "'κάϊσερ'" + "OR eidos2_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos2_tim = " + "'carlsberg'" + "OR eidos2_tim = "
					+ "'corona'" + "OR eidos2_tim = " + "'kilkeny'"
					+ "OR eidos2_tim = " + "'fisher'" + "OR eidos2_tim = "
					+ "'somersby'" + "OR eidos2_tim = " + "'bud'"
					+ "OR eidos2_tim = " + "'μύθος'" + "OR eidos2_tim = "
					+ "'fix βαρέλι'" + "OR eidos2_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos2_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos2_tim = " + "'βόρεια pilsner'"
					+ "OR eidos2_tim = " + "'βόρεια india'"
					+ "OR eidos2_tim = " + "'heineken'" + "OR eidos2_tim = "
					+ "'amstel'" + "OR eidos2_tim = " + "'mcfarland'"
					+ "OR eidos2_tim = " + "'stella'" + "OR eidos2_tim = "
					+ "'erdinger'" + "OR eidos2_tim = " + "'paulaner'"
					+ "OR eidos2_tim = " + "'chimay'" + "OR eidos2_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos2_tim = " + "'fischer βαρέλι'"
					+ "OR eidos2_tim = " + "'buckler'" + "OR eidos2_tim = "
					+ "'desperados'" + "OR eidos2_tim = " + "'estrella'"
					+ "OR eidos2_tim = " + "'volkan'" + "OR eidos2_tim = "
					+ "'volkan black'" + "OR eidos3_tim = " + "'fix'"
					+ "OR eidos3_tim = " + "'fix dark'" + "OR eidos3_tim = "
					+ "'κάϊσερ'" + "OR eidos3_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos3_tim = " + "'carlsberg'" + "OR eidos3_tim = "
					+ "'corona'" + "OR eidos3_tim = " + "'kilkeny'"
					+ "OR eidos3_tim = " + "'fisher'" + "OR eidos3_tim = "
					+ "'somersby'" + "OR eidos3_tim = " + "'bud'"
					+ "OR eidos3_tim = " + "'μύθος'" + "OR eidos3_tim = "
					+ "'fix βαρέλι'" + "OR eidos3_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos3_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos3_tim = " + "'βόρεια pilsner'"
					+ "OR eidos3_tim = " + "'βόρεια india'"
					+ "OR eidos3_tim = " + "'heineken'" + "OR eidos3_tim = "
					+ "'amstel'" + "OR eidos3_tim = " + "'mcfarland'"
					+ "OR eidos3_tim = " + "'stella'" + "OR eidos3_tim = "
					+ "'erdinger'" + "OR eidos3_tim = " + "'paulaner'"
					+ "OR eidos3_tim = " + "'chimay'" + "OR eidos3_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos3_tim = " + "'fischer βαρέλι'"
					+ "OR eidos3_tim = " + "'buckler'" + "OR eidos3_tim = "
					+ "'desperados'" + "OR eidos3_tim = " + "'estrella'"
					+ "OR eidos3_tim = " + "'volkan'" + "OR eidos3_tim = "
					+ "'volkan black'" + "OR eidos4_tim = " + "'fix'"
					+ "OR eidos4_tim = " + "'fix dark'" + "OR eidos4_tim = "
					+ "'κάϊσερ'" + "OR eidos4_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos4_tim = " + "'carlsberg'" + "OR eidos4_tim = "
					+ "'corona'" + "OR eidos4_tim = " + "'kilkeny'"
					+ "OR eidos4_tim = " + "'fisher'" + "OR eidos4_tim = "
					+ "'somersby'" + "OR eidos4_tim = " + "'bud'"
					+ "OR eidos4_tim = " + "'μύθος'" + "OR eidos4_tim = "
					+ "'fix βαρέλι'" + "OR eidos4_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos4_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos4_tim = " + "'βόρεια pilsner'"
					+ "OR eidos4_tim = " + "'βόρεια india'"
					+ "OR eidos4_tim = " + "'heineken'" + "OR eidos4_tim = "
					+ "'amstel'" + "OR eidos4_tim = " + "'mcfarland'"
					+ "OR eidos4_tim = " + "'stella'" + "OR eidos4_tim = "
					+ "'erdinger'" + "OR eidos4_tim = " + "'paulaner'"
					+ "OR eidos4_tim = " + "'chimay'" + "OR eidos4_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos4_tim = " + "'fischer βαρέλι'"
					+ "OR eidos4_tim = " + "'buckler'" + "OR eidos4_tim = "
					+ "'desperados'" + "OR eidos4_tim = " + "'estrella'"
					+ "OR eidos4_tim = " + "'volkan'" + "OR eidos4_tim = "
					+ "'volkan black'" + "OR eidos5_tim = " + "'fix'"
					+ "OR eidos5_tim = " + "'fix dark'" + "OR eidos5_tim = "
					+ "'κάϊσερ'" + "OR eidos5_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos5_tim = " + "'carlsberg'" + "OR eidos5_tim = "
					+ "'corona'" + "OR eidos5_tim = " + "'kilkeny'"
					+ "OR eidos5_tim = " + "'fisher'" + "OR eidos5_tim = "
					+ "'somersby'" + "OR eidos5_tim = " + "'bud'"
					+ "OR eidos5_tim = " + "'μύθος'" + "OR eidos5_tim = "
					+ "'fix βαρέλι'" + "OR eidos5_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos5_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos5_tim = " + "'βόρεια pilsner'"
					+ "OR eidos5_tim = " + "'βόρεια india'"
					+ "OR eidos5_tim = " + "'heineken'" + "OR eidos5_tim = "
					+ "'amstel'" + "OR eidos5_tim = " + "'mcfarland'"
					+ "OR eidos5_tim = " + "'stella'" + "OR eidos5_tim = "
					+ "'erdinger'" + "OR eidos5_tim = " + "'paulaner'"
					+ "OR eidos5_tim = " + "'chimay'" + "OR eidos5_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos5_tim = " + "'fischer βαρέλι'"
					+ "OR eidos5_tim = " + "'buckler'" + "OR eidos5_tim = "
					+ "'desperados'" + "OR eidos5_tim = " + "'estrella'"
					+ "OR eidos5_tim = " + "'volkan'" + "OR eidos5_tim = "
					+ "'volkan black'" + "OR eidos6_tim = " + "'fix'"
					+ "OR eidos6_tim = " + "'fix dark'" + "OR eidos6_tim = "
					+ "'κάϊσερ'" + "OR eidos6_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos6_tim = " + "'carlsberg'" + "OR eidos6_tim = "
					+ "'corona'" + "OR eidos6_tim = " + "'kilkeny'"
					+ "OR eidos6_tim = " + "'fisher'" + "OR eidos6_tim = "
					+ "'somersby'" + "OR eidos6_tim = " + "'bud'"
					+ "OR eidos6_tim = " + "'μύθος'" + "OR eidos6_tim = "
					+ "'fix βαρέλι'" + "OR eidos6_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos6_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos6_tim = " + "'βόρεια pilsner'"
					+ "OR eidos6_tim = " + "'βόρεια india'"
					+ "OR eidos6_tim = " + "'heineken'" + "OR eidos6_tim = "
					+ "'amstel'" + "OR eidos6_tim = " + "'mcfarland'"
					+ "OR eidos6_tim = " + "'stella'" + "OR eidos6_tim = "
					+ "'erdinger'" + "OR eidos6_tim = " + "'paulaner'"
					+ "OR eidos6_tim = " + "'chimay'" + "OR eidos6_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos6_tim = " + "'fischer βαρέλι'"
					+ "OR eidos6_tim = " + "'buckler'" + "OR eidos6_tim = "
					+ "'desperados'" + "OR eidos6_tim = " + "'estrella'"
					+ "OR eidos6_tim = " + "'volkan'" + "OR eidos6_tim = "
					+ "'volkan black'" + "OR eidos7_tim = " + "'fix'"
					+ "OR eidos7_tim = " + "'fix dark'" + "OR eidos7_tim = "
					+ "'κάϊσερ'" + "OR eidos7_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos7_tim = " + "'carlsberg'" + "OR eidos7_tim = "
					+ "'corona'" + "OR eidos7_tim = " + "'kilkeny'"
					+ "OR eidos7_tim = " + "'fisher'" + "OR eidos7_tim = "
					+ "'somersby'" + "OR eidos7_tim = " + "'bud'"
					+ "OR eidos7_tim = " + "'μύθος'" + "OR eidos7_tim = "
					+ "'fix βαρέλι'" + "OR eidos7_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos7_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos7_tim = " + "'βόρεια pilsner'"
					+ "OR eidos7_tim = " + "'βόρεια india'"
					+ "OR eidos7_tim = " + "'heineken'" + "OR eidos7_tim = "
					+ "'amstel'" + "OR eidos7_tim = " + "'mcfarland'"
					+ "OR eidos7_tim = " + "'stella'" + "OR eidos7_tim = "
					+ "'erdinger'" + "OR eidos7_tim = " + "'paulaner'"
					+ "OR eidos7_tim = " + "'chimay'" + "OR eidos7_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos7_tim = " + "'fischer βαρέλι'"
					+ "OR eidos7_tim = " + "'buckler'" + "OR eidos7_tim = "
					+ "'desperados'" + "OR eidos7_tim = " + "'estrella'"
					+ "OR eidos7_tim = " + "'volkan'" + "OR eidos7_tim = "
					+ "'volkan black'" + "OR eidos8_tim = " + "'fix'"
					+ "OR eidos8_tim = " + "'fix dark'" + "OR eidos8_tim = "
					+ "'κάϊσερ'" + "OR eidos8_tim = " + "'κάϊσερ blonde'"
					+ "OR eidos8_tim = " + "'carlsberg'" + "OR eidos8_tim = "
					+ "'corona'" + "OR eidos8_tim = " + "'kilkeny'"
					+ "OR eidos8_tim = " + "'fisher'" + "OR eidos8_tim = "
					+ "'somersby'" + "OR eidos8_tim = " + "'bud'"
					+ "OR eidos8_tim = " + "'μύθος'" + "OR eidos8_tim = "
					+ "'fix βαρέλι'" + "OR eidos8_tim = " + "'κάϊσερ βαρέλι'"
					+ "OR eidos8_tim = " + "'μύθος βαρέλι'"
					+ "OR eidos8_tim = " + "'βόρεια pilsner'"
					+ "OR eidos8_tim = " + "'βόρεια india'"
					+ "OR eidos8_tim = " + "'heineken'" + "OR eidos8_tim = "
					+ "'amstel'" + "OR eidos8_tim = " + "'mcfarland'"
					+ "OR eidos8_tim = " + "'stella'" + "OR eidos8_tim = "
					+ "'erdinger'" + "OR eidos8_tim = " + "'paulaner'"
					+ "OR eidos8_tim = " + "'chimay'" + "OR eidos8_tim = "
					+ "'άλφα βαρέλι'" + "OR eidos8_tim = " + "'fischer βαρέλι'"
					+ "OR eidos8_tim = " + "'buckler'" + "OR eidos8_tim = "
					+ "'desperados'" + "OR eidos8_tim = " + "'estrella'"
					+ "OR eidos8_tim = " + "'volkan'" + "OR eidos8_tim = "
					+ "'volkan black'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting ANAPSIKTIKA DETAILS
	public ArrayList<Timologia> Get_AnapsiktikaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Γ.coca cola'" + "OR eidos1_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos1_tim = " + "'Γ.λεμονάδα'" + "OR eidos1_tim = "
					+ "'Γ.τόνικ'" + "OR eidos1_tim = " + "'Γ.σόδα'"
					+ "OR eidos1_tim = " + "'Γ.sprite'" + "OR eidos1_tim = "
					+ "'Π.coca cola'" + "OR eidos1_tim = " + "'Π.sprite'"
					+ "OR eidos1_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos1_tim = " + "'Π.λεμονάδα'" + "OR eidos1_tim = "
					+ "'Π.τόνικ'" + "OR eidos1_tim = " + "'Π.σόδα'"
					+ "OR eidos1_tim = " + "'Π.tuborg'" + "OR eidos1_tim = "
					+ "'Π.φράουλα'" + "OR eidos1_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos1_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos1_tim = " + "'χυμό μήλο'" + "OR eidos1_tim = "
					+ "'χυμό ρόδι'" + "OR eidos1_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos1_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos1_tim = " + "'χυμό ανανά'" + "OR eidos1_tim = "
					+ "'Γ.coca cola light'" + "OR eidos1_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos1_tim = " + "'Perrier'"
					+ "OR eidos1_tim = " + "'Π.coca cola light'"
					+ "OR eidos1_tim = " + "'Π.coca cola zero'"
					+ "OR eidos1_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos1_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos1_tim = " + "'χυμό λεμόνι'" + "OR eidos1_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos1_tim = "
					+ "'χυμό φράουλα'" + "OR eidos2_tim = " + "'Γ.coca cola'"
					+ "OR eidos2_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos2_tim = " + "'Γ.λεμονάδα'" + "OR eidos2_tim = "
					+ "'Γ.τόνικ'" + "OR eidos2_tim = " + "'Γ.σόδα'"
					+ "OR eidos2_tim = " + "'Γ.sprite'" + "OR eidos2_tim = "
					+ "'Π.coca cola'" + "OR eidos2_tim = " + "'Π.sprite'"
					+ "OR eidos2_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos2_tim = " + "'Π.λεμονάδα'" + "OR eidos2_tim = "
					+ "'Π.τόνικ'" + "OR eidos2_tim = " + "'Π.σόδα'"
					+ "OR eidos2_tim = " + "'Π.tuborg'" + "OR eidos2_tim = "
					+ "'Π.φράουλα'" + "OR eidos2_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos2_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos2_tim = " + "'χυμό μήλο'" + "OR eidos2_tim = "
					+ "'χυμό ρόδι'" + "OR eidos2_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos2_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos2_tim = " + "'χυμό ανανά'" + "OR eidos2_tim = "
					+ "'Γ.coca cola light'" + "OR eidos2_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos2_tim = " + "'Perrier'"
					+ "OR eidos2_tim = " + "'Π.coca cola light'"
					+ "OR eidos2_tim = " + "'Π.coca cola zero'"
					+ "OR eidos2_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos2_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos2_tim = " + "'χυμό λεμόνι'" + "OR eidos2_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos2_tim = "
					+ "'χυμό φράουλα'" + "OR eidos3_tim = " + "'Γ.coca cola'"
					+ "OR eidos3_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos3_tim = " + "'Γ.λεμονάδα'" + "OR eidos3_tim = "
					+ "'Γ.τόνικ'" + "OR eidos3_tim = " + "'Γ.σόδα'"
					+ "OR eidos3_tim = " + "'Γ.sprite'" + "OR eidos3_tim = "
					+ "'Π.coca cola'" + "OR eidos3_tim = " + "'Π.sprite'"
					+ "OR eidos3_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos3_tim = " + "'Π.λεμονάδα'" + "OR eidos3_tim = "
					+ "'Π.τόνικ'" + "OR eidos3_tim = " + "'Π.σόδα'"
					+ "OR eidos3_tim = " + "'Π.tuborg'" + "OR eidos3_tim = "
					+ "'Π.φράουλα'" + "OR eidos3_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos3_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos3_tim = " + "'χυμό μήλο'" + "OR eidos3_tim = "
					+ "'χυμό ρόδι'" + "OR eidos3_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos3_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos3_tim = " + "'χυμό ανανά'" + "OR eidos3_tim = "
					+ "'Γ.coca cola light'" + "OR eidos3_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos3_tim = " + "'Perrier'"
					+ "OR eidos3_tim = " + "'Π.coca cola light'"
					+ "OR eidos3_tim = " + "'Π.coca cola zero'"
					+ "OR eidos3_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos3_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos3_tim = " + "'χυμό λεμόνι'" + "OR eidos3_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos3_tim = "
					+ "'χυμό φράουλα'" + "OR eidos4_tim = " + "'Γ.coca cola'"
					+ "OR eidos4_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos4_tim = " + "'Γ.λεμονάδα'" + "OR eidos4_tim = "
					+ "'Γ.τόνικ'" + "OR eidos4_tim = " + "'Γ.σόδα'"
					+ "OR eidos4_tim = " + "'Γ.sprite'" + "OR eidos4_tim = "
					+ "'Π.coca cola'" + "OR eidos4_tim = " + "'Π.sprite'"
					+ "OR eidos4_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos4_tim = " + "'Π.λεμονάδα'" + "OR eidos4_tim = "
					+ "'Π.τόνικ'" + "OR eidos4_tim = " + "'Π.σόδα'"
					+ "OR eidos4_tim = " + "'Π.tuborg'" + "OR eidos4_tim = "
					+ "'Π.φράουλα'" + "OR eidos4_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos4_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos4_tim = " + "'χυμό μήλο'" + "OR eidos4_tim = "
					+ "'χυμό ρόδι'" + "OR eidos4_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos4_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos4_tim = " + "'χυμό ανανά'" + "OR eidos4_tim = "
					+ "'Γ.coca cola light'" + "OR eidos4_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos4_tim = " + "'Perrier'"
					+ "OR eidos4_tim = " + "'Π.coca cola light'"
					+ "OR eidos4_tim = " + "'Π.coca cola zero'"
					+ "OR eidos4_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos4_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos4_tim = " + "'χυμό λεμόνι'" + "OR eidos4_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos4_tim = "
					+ "'χυμό φράουλα'" + "OR eidos5_tim = " + "'Γ.coca cola'"
					+ "OR eidos5_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos5_tim = " + "'Γ.λεμονάδα'" + "OR eidos5_tim = "
					+ "'Γ.τόνικ'" + "OR eidos5_tim = " + "'Γ.σόδα'"
					+ "OR eidos5_tim = " + "'Γ.sprite'" + "OR eidos5_tim = "
					+ "'Π.coca cola'" + "OR eidos5_tim = " + "'Π.sprite'"
					+ "OR eidos5_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos5_tim = " + "'Π.λεμονάδα'" + "OR eidos5_tim = "
					+ "'Π.τόνικ'" + "OR eidos5_tim = " + "'Π.σόδα'"
					+ "OR eidos5_tim = " + "'Π.tuborg'" + "OR eidos5_tim = "
					+ "'Π.φράουλα'" + "OR eidos5_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos5_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos5_tim = " + "'χυμό μήλο'" + "OR eidos5_tim = "
					+ "'χυμό ρόδι'" + "OR eidos5_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos5_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos5_tim = " + "'χυμό ανανά'" + "OR eidos5_tim = "
					+ "'Γ.coca cola light'" + "OR eidos5_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos5_tim = " + "'Perrier'"
					+ "OR eidos5_tim = " + "'Π.coca cola light'"
					+ "OR eidos5_tim = " + "'Π.coca cola zero'"
					+ "OR eidos5_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos5_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos5_tim = " + "'χυμό λεμόνι'" + "OR eidos5_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos5_tim = "
					+ "'χυμό φράουλα'" + "OR eidos6_tim = " + "'Γ.coca cola'"
					+ "OR eidos6_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos6_tim = " + "'Γ.λεμονάδα'" + "OR eidos6_tim = "
					+ "'Γ.τόνικ'" + "OR eidos6_tim = " + "'Γ.σόδα'"
					+ "OR eidos6_tim = " + "'Γ.sprite'" + "OR eidos6_tim = "
					+ "'Π.coca cola'" + "OR eidos6_tim = " + "'Π.sprite'"
					+ "OR eidos6_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos6_tim = " + "'Π.λεμονάδα'" + "OR eidos6_tim = "
					+ "'Π.τόνικ'" + "OR eidos6_tim = " + "'Π.σόδα'"
					+ "OR eidos6_tim = " + "'Π.tuborg'" + "OR eidos6_tim = "
					+ "'Π.φράουλα'" + "OR eidos6_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos6_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos6_tim = " + "'χυμό μήλο'" + "OR eidos6_tim = "
					+ "'χυμό ρόδι'" + "OR eidos6_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos6_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos6_tim = " + "'χυμό ανανά'" + "OR eidos6_tim = "
					+ "'Γ.coca cola light'" + "OR eidos6_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos6_tim = " + "'Perrier'"
					+ "OR eidos6_tim = " + "'Π.coca cola light'"
					+ "OR eidos6_tim = " + "'Π.coca cola zero'"
					+ "OR eidos6_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos6_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos6_tim = " + "'χυμό λεμόνι'" + "OR eidos6_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos6_tim = "
					+ "'χυμό φράουλα'" + "OR eidos7_tim = " + "'Γ.coca cola'"
					+ "OR eidos7_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos7_tim = " + "'Γ.λεμονάδα'" + "OR eidos7_tim = "
					+ "'Γ.τόνικ'" + "OR eidos7_tim = " + "'Γ.σόδα'"
					+ "OR eidos7_tim = " + "'Γ.sprite'" + "OR eidos7_tim = "
					+ "'Π.coca cola'" + "OR eidos7_tim = " + "'Π.sprite'"
					+ "OR eidos7_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos7_tim = " + "'Π.λεμονάδα'" + "OR eidos7_tim = "
					+ "'Π.τόνικ'" + "OR eidos7_tim = " + "'Π.σόδα'"
					+ "OR eidos7_tim = " + "'Π.tuborg'" + "OR eidos7_tim = "
					+ "'Π.φράουλα'" + "OR eidos7_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos7_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos7_tim = " + "'χυμό μήλο'" + "OR eidos7_tim = "
					+ "'χυμό ρόδι'" + "OR eidos7_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos7_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos7_tim = " + "'χυμό ανανά'" + "OR eidos7_tim = "
					+ "'Γ.coca cola light'" + "OR eidos7_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos7_tim = " + "'Perrier'"
					+ "OR eidos7_tim = " + "'Π.coca cola light'"
					+ "OR eidos7_tim = " + "'Π.coca cola zero'"
					+ "OR eidos7_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos7_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos7_tim = " + "'χυμό λεμόνι'" + "OR eidos7_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos7_tim = "
					+ "'χυμό φράουλα'" + "OR eidos8_tim = " + "'Γ.coca cola'"
					+ "OR eidos8_tim = " + "'Γ.πορτοκαλάδα'"
					+ "OR eidos8_tim = " + "'Γ.λεμονάδα'" + "OR eidos8_tim = "
					+ "'Γ.τόνικ'" + "OR eidos8_tim = " + "'Γ.σόδα'"
					+ "OR eidos8_tim = " + "'Γ.sprite'" + "OR eidos8_tim = "
					+ "'Π.coca cola'" + "OR eidos8_tim = " + "'Π.sprite'"
					+ "OR eidos8_tim = " + "'Π.πορτοκαλάδα'"
					+ "OR eidos8_tim = " + "'Π.λεμονάδα'" + "OR eidos8_tim = "
					+ "'Π.τόνικ'" + "OR eidos8_tim = " + "'Π.σόδα'"
					+ "OR eidos8_tim = " + "'Π.tuborg'" + "OR eidos8_tim = "
					+ "'Π.φράουλα'" + "OR eidos8_tim = " + "'χυμό πορτοκάλι'"
					+ "OR eidos8_tim = " + "'χυμό ροδάκινο'"
					+ "OR eidos8_tim = " + "'χυμό μήλο'" + "OR eidos8_tim = "
					+ "'χυμό ρόδι'" + "OR eidos8_tim = " + "'χυμό κοκτέϊλ'"
					+ "OR eidos8_tim = " + "'χυμό μπανάνα'"
					+ "OR eidos8_tim = " + "'χυμό ανανά'" + "OR eidos8_tim = "
					+ "'Γ.coca cola light'" + "OR eidos8_tim = "
					+ "'Γ.coca cola zero'" + "OR eidos8_tim = " + "'Perrier'"
					+ "OR eidos8_tim = " + "'Π.coca cola light'"
					+ "OR eidos8_tim = " + "'Π.coca cola zero'"
					+ "OR eidos8_tim = " + "'χυμό βύσσινο'"
					+ "OR eidos8_tim = " + "'χυμό κρανμπερι'"
					+ "OR eidos8_tim = " + "'χυμό λεμόνι'" + "OR eidos8_tim = "
					+ "'χυμό ανάμεικτο'" + "OR eidos8_tim = "
					+ "'χυμό φράουλα'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting TSAI DETAILS
	public ArrayList<Timologia> Get_TsaiDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'τσάι απλό'" + "OR eidos1_tim = " + "'τσάι ροδάκινο'"
					+ "OR eidos1_tim = " + "'τσάι πράσινο'"
					+ "OR eidos1_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos1_tim = " + "'τσάι λεμόνι'" + "OR eidos1_tim = "
					+ "'τσάι φράουλα'" + "OR eidos1_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos1_tim = " + "'χαμομήλι'" + "OR eidos1_tim = "
					+ "'τσάι μαύρο'" + "OR eidos1_tim = " + "'τσάι βότανα'"
					+ "OR eidos2_tim = " + "'τσάι απλό'" + "OR eidos2_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos2_tim = " + "'τσάι πράσινο'"
					+ "OR eidos2_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos2_tim = " + "'τσάι λεμόνι'" + "OR eidos2_tim = "
					+ "'τσάι φράουλα'" + "OR eidos2_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos2_tim = " + "'χαμομήλι'" + "OR eidos2_tim = "
					+ "'τσάι μαύρο'" + "OR eidos2_tim = " + "'τσάι βότανα'"
					+ "OR eidos3_tim = " + "'τσάι απλό'" + "OR eidos3_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos3_tim = " + "'τσάι πράσινο'"
					+ "OR eidos3_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos3_tim = " + "'τσάι λεμόνι'" + "OR eidos3_tim = "
					+ "'τσάι φράουλα'" + "OR eidos3_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos3_tim = " + "'χαμομήλι'" + "OR eidos3_tim = "
					+ "'τσάι μαύρο'" + "OR eidos3_tim = " + "'τσάι βότανα'"
					+ "OR eidos4_tim = " + "'τσάι απλό'" + "OR eidos4_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos4_tim = " + "'τσάι πράσινο'"
					+ "OR eidos4_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos4_tim = " + "'τσάι λεμόνι'" + "OR eidos4_tim = "
					+ "'τσάι φράουλα'" + "OR eidos4_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos4_tim = " + "'χαμομήλι'" + "OR eidos4_tim = "
					+ "'τσάι μαύρο'" + "OR eidos4_tim = " + "'τσάι βότανα'"
					+ "OR eidos5_tim = " + "'τσάι απλό'" + "OR eidos5_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos5_tim = " + "'τσάι πράσινο'"
					+ "OR eidos5_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos5_tim = " + "'τσάι λεμόνι'" + "OR eidos5_tim = "
					+ "'τσάι φράουλα'" + "OR eidos5_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos5_tim = " + "'χαμομήλι'" + "OR eidos5_tim = "
					+ "'τσάι μαύρο'" + "OR eidos5_tim = " + "'τσάι βότανα'"
					+ "OR eidos6_tim = " + "'τσάι απλό'" + "OR eidos6_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos6_tim = " + "'τσάι πράσινο'"
					+ "OR eidos6_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos6_tim = " + "'τσάι λεμόνι'" + "OR eidos6_tim = "
					+ "'τσάι φράουλα'" + "OR eidos6_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos6_tim = " + "'χαμομήλι'" + "OR eidos6_tim = "
					+ "'τσάι μαύρο'" + "OR eidos6_tim = " + "'τσάι βότανα'"
					+ "OR eidos7_tim = " + "'τσάι απλό'" + "OR eidos7_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos7_tim = " + "'τσάι πράσινο'"
					+ "OR eidos7_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos7_tim = " + "'τσάι λεμόνι'" + "OR eidos7_tim = "
					+ "'τσάι φράουλα'" + "OR eidos7_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos7_tim = " + "'χαμομήλι'" + "OR eidos7_tim = "
					+ "'τσάι μαύρο'" + "OR eidos7_tim = " + "'τσάι βότανα'"
					+ "OR eidos8_tim = " + "'τσάι απλό'" + "OR eidos8_tim = "
					+ "'τσάι ροδάκινο'" + "OR eidos8_tim = " + "'τσάι πράσινο'"
					+ "OR eidos8_tim = " + "'τσάι καραμέλα'"
					+ "OR eidos8_tim = " + "'τσάι λεμόνι'" + "OR eidos8_tim = "
					+ "'τσάι φράουλα'" + "OR eidos8_tim = " + "'τσάι βανίλλια'"
					+ "OR eidos8_tim = " + "'χαμομήλι'" + "OR eidos8_tim = "
					+ "'τσάι μαύρο'" + "OR eidos8_tim = " + "'τσάι βότανα'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting PAGOTA DETAILS
	public ArrayList<Timologia> Get_PagotaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'παγωτό βανίλια'" + "OR eidos1_tim = "
					+ "'παγωτό σοκολάτα'" + "OR eidos1_tim = "
					+ "'παγωτό καραμέλα'" + "OR eidos1_tim = "
					+ "'παγωτό φράουλα'" + "OR eidos1_tim = "
					+ "'παγωτό μπανάνα'" + "OR eidos1_tim = " + "'παγωτό μόκα'"
					+ "OR eidos1_tim = " + "'παγωτό στρατσιατέλα'"
					+ "OR eidos1_tim = " + "'παγωτό λεμόνι'"
					+ "OR eidos2_tim = " + "'παγωτό βανίλια'"
					+ "OR eidos2_tim = " + "'παγωτό σοκολάτα'"
					+ "OR eidos2_tim = " + "'παγωτό καραμέλα'"
					+ "OR eidos2_tim = " + "'παγωτό φράουλα'"
					+ "OR eidos2_tim = " + "'παγωτό μπανάνα'"
					+ "OR eidos2_tim = " + "'παγωτό μόκα'" + "OR eidos2_tim = "
					+ "'παγωτό στρατσιατέλα'" + "OR eidos2_tim = "
					+ "'παγωτό λεμόνι'" + "OR eidos3_tim = "
					+ "'παγωτό βανίλια'" + "OR eidos3_tim = "
					+ "'παγωτό σοκολάτα'" + "OR eidos3_tim = "
					+ "'παγωτό καραμέλα'" + "OR eidos3_tim = "
					+ "'παγωτό φράουλα'" + "OR eidos3_tim = "
					+ "'παγωτό μπανάνα'" + "OR eidos3_tim = " + "'παγωτό μόκα'"
					+ "OR eidos3_tim = " + "'παγωτό στρατσιατέλα'"
					+ "OR eidos3_tim = " + "'παγωτό λεμόνι'"
					+ "OR eidos4_tim = " + "'παγωτό βανίλια'"
					+ "OR eidos4_tim = " + "'παγωτό σοκολάτα'"
					+ "OR eidos4_tim = " + "'παγωτό καραμέλα'"
					+ "OR eidos4_tim = " + "'παγωτό φράουλα'"
					+ "OR eidos4_tim = " + "'παγωτό μπανάνα'"
					+ "OR eidos4_tim = " + "'παγωτό μόκα'" + "OR eidos4_tim = "
					+ "'παγωτό στρατσιατέλα'" + "OR eidos4_tim = "
					+ "'παγωτό λεμόνι'" + "OR eidos5_tim = "
					+ "'παγωτό βανίλια'" + "OR eidos5_tim = "
					+ "'παγωτό σοκολάτα'" + "OR eidos5_tim = "
					+ "'παγωτό καραμέλα'" + "OR eidos5_tim = "
					+ "'παγωτό φράουλα'" + "OR eidos5_tim = "
					+ "'παγωτό μπανάνα'" + "OR eidos5_tim = " + "'παγωτό μόκα'"
					+ "OR eidos5_tim = " + "'παγωτό στρατσιατέλα'"
					+ "OR eidos5_tim = " + "'παγωτό λεμόνι'"
					+ "OR eidos6_tim = " + "'παγωτό βανίλια'"
					+ "OR eidos6_tim = " + "'παγωτό σοκολάτα'"
					+ "OR eidos6_tim = " + "'παγωτό καραμέλα'"
					+ "OR eidos6_tim = " + "'παγωτό φράουλα'"
					+ "OR eidos6_tim = " + "'παγωτό μπανάνα'"
					+ "OR eidos6_tim = " + "'παγωτό μόκα'" + "OR eidos6_tim = "
					+ "'παγωτό στρατσιατέλα'" + "OR eidos6_tim = "
					+ "'παγωτό λεμόνι'" + "OR eidos7_tim = "
					+ "'παγωτό βανίλια'" + "OR eidos7_tim = "
					+ "'παγωτό σοκολάτα'" + "OR eidos7_tim = "
					+ "'παγωτό καραμέλα'" + "OR eidos7_tim = "
					+ "'παγωτό φράουλα'" + "OR eidos7_tim = "
					+ "'παγωτό μπανάνα'" + "OR eidos7_tim = " + "'παγωτό μόκα'"
					+ "OR eidos7_tim = " + "'παγωτό στρατσιατέλα'"
					+ "OR eidos7_tim = " + "'παγωτό λεμόνι'"
					+ "OR eidos8_tim = " + "'παγωτό βανίλια'"
					+ "OR eidos8_tim = " + "'παγωτό σοκολάτα'"
					+ "OR eidos8_tim = " + "'παγωτό καραμέλα'"
					+ "OR eidos8_tim = " + "'παγωτό φράουλα'"
					+ "OR eidos8_tim = " + "'παγωτό μπανάνα'"
					+ "OR eidos8_tim = " + "'παγωτό μόκα'" + "OR eidos8_tim = "
					+ "'παγωτό στρατσιατέλα'" + "OR eidos8_tim = "
					+ "'παγωτό λεμόνι'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting OUZA_TSIPOURA DETAILS
	public ArrayList<Timologia> Get_Ouza_tsipouraDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos1_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos1_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos1_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos1_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos1_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos1_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos1_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos1_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos1_tim = " + "'Μπέη(200ml)'" + "OR eidos1_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos1_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos1_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos1_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos1_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos2_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos2_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos2_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos2_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos2_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos2_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos2_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos2_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos2_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos2_tim = " + "'Μπέη(200ml)'" + "OR eidos2_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos2_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos2_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos2_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos2_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos3_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos3_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos3_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos3_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos3_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos3_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos3_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos3_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos3_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos3_tim = " + "'Μπέη(200ml)'" + "OR eidos3_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos3_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos3_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos3_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos3_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos4_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos4_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos4_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos4_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos4_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos4_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos4_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos4_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos4_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos4_tim = " + "'Μπέη(200ml)'" + "OR eidos4_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos4_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos4_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos4_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos4_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos5_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos5_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos5_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos5_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos5_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos5_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos5_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos5_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos5_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos5_tim = " + "'Μπέη(200ml)'" + "OR eidos5_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos5_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos5_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos5_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos5_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos6_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos6_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos6_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos6_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos6_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos6_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos6_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos6_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos6_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos6_tim = " + "'Μπέη(200ml)'" + "OR eidos6_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos6_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos6_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos6_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos6_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos7_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos7_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos7_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos7_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos7_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos7_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos7_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos7_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos7_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos7_tim = " + "'Μπέη(200ml)'" + "OR eidos7_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos7_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos7_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos7_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos7_tim = "
					+ "'T.Βλαδίκα(χύμα)'" + "OR eidos8_tim = "
					+ "'Αλεξανδρίδη(100ml)'" + "OR eidos8_tim = "
					+ "'φραγκουλά(100ml)'" + "OR eidos8_tim = "
					+ "'Κουλάς(100ml)'" + "OR eidos8_tim = " + "'Μπέη(100ml)'"
					+ "OR eidos8_tim = " + "'Πεντάρι(100ml)'"
					+ "OR eidos8_tim = " + "'Αλεξανδρίδη(200ml)'"
					+ "OR eidos8_tim = " + "'Φραγκουλά(200ml)'"
					+ "OR eidos8_tim = " + "'Μπεσίρη(200ml)'"
					+ "OR eidos8_tim = " + "'Κουλάς(200ml)'"
					+ "OR eidos8_tim = " + "'Μπέη(200ml)'" + "OR eidos8_tim = "
					+ "'Πεντάρι(200ml)'" + "OR eidos8_tim = "
					+ "'T.Γιώμα Πέντ(200ml)'" + "OR eidos8_tim = "
					+ "'T.Αλεξανδρίδη(200ml)'" + "OR eidos8_tim = "
					+ "'T.Αγιονέρι(χύμα)'" + "OR eidos8_tim = "
					+ "'T.Βλαδίκα(χύμα)'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting KRASIA DETAILS
	public ArrayList<Timologia> Get_KrasiaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Λ.Ντάμα κούπα'" + "OR eidos1_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos1_tim = " + "'Λ.Μικρός'"
					+ "OR eidos1_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos1_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos1_tim = " + "'Λ.Βιβλία'" + "OR eidos1_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos1_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos1_tim = " + "'Λ.Ευπορία'" + "OR eidos1_tim = "
					+ "'Λ.Isari'" + "OR eidos1_tim = " + "'Λ.Cirinon'"
					+ "OR eidos1_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos1_tim = "
					+ "'Κ.Cirinon'" + "OR eidos1_tim = " + "'Κ.Idonida'"
					+ "OR eidos1_tim = " + "'Κ.Isari'" + "OR eidos1_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos1_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos1_tim = " + "'Κ.Chateau'" + "OR eidos1_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos1_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos1_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos1_tim = " + "'Κ.Μικρός'" + "OR eidos1_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos1_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos1_tim = " + "'Ρ.Βιβλία'" + "OR eidos1_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos1_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos1_tim = " + "'Ρ.Cirinon'" + "OR eidos1_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos1_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos1_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos1_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos1_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos1_tim = "
					+ "'Λ.Sangria'" + "OR eidos1_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Λ.Αμέθυστος'" + "OR eidos1_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos1_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos1_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos1_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos1_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos1_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos1_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos1_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos1_tim = "
					+ "'Λ.Visanto'" + "OR eidos1_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos1_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos1_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos1_tim = " + "'Κ.Sangria'"
					+ "OR eidos1_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Κ.Αμέθυστος'" + "OR eidos1_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos1_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos1_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos1_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos1_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos1_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos1_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos1_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos1_tim = "
					+ "'Κ.Visanto'" + "OR eidos1_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos1_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos1_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos1_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos1_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos1_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos1_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos1_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos1_tim = " + "'Ρ.Visanto'" + "OR eidos1_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos1_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos1_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos1_tim = " + "'Asti Martini'"
					+ "OR eidos1_tim = " + "'Asti μικρή'"
					+ "OR eidos1_tim = " + "'Gordon Rouge'"
					+ "OR eidos1_tim = " + "'Moschato D Asti'"
					+ "OR eidos1_tim = " + "'Dom Perignon'"
					+ "OR eidos1_tim = " + "'Moet et Chandon'"
					+ "OR eidos1_tim = " + "'Veuve Clickuot'"
					+ "OR eidos1_tim = " + "'Veuve aperitif'"
					+ "OR eidos2_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos2_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos2_tim = " + "'Λ.Μικρός'"
					+ "OR eidos2_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos2_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos2_tim = " + "'Λ.Βιβλία'" + "OR eidos2_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos2_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos2_tim = " + "'Λ.Ευπορία'" + "OR eidos2_tim = "
					+ "'Λ.Isari'" + "OR eidos2_tim = " + "'Λ.Cirinon'"
					+ "OR eidos2_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos2_tim = "
					+ "'Κ.Cirinon'" + "OR eidos2_tim = " + "'Κ.Idonida'"
					+ "OR eidos2_tim = " + "'Κ.Isari'" + "OR eidos2_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos2_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos2_tim = " + "'Κ.Chateau'" + "OR eidos2_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos2_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos2_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos2_tim = " + "'Κ.Μικρός'" + "OR eidos2_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos2_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos2_tim = " + "'Ρ.Βιβλία'" + "OR eidos2_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos2_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos2_tim = " + "'Ρ.Cirinon'" + "OR eidos2_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos2_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos2_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos2_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos2_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos2_tim = "
					+ "'Λ.Sangria'" + "OR eidos2_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Λ.Αμέθυστος'" + "OR eidos2_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos2_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos2_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos2_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos2_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos2_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos2_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos2_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos2_tim = "
					+ "'Λ.Visanto'" + "OR eidos2_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos2_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos2_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos2_tim = " + "'Κ.Sangria'"
					+ "OR eidos2_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Κ.Αμέθυστος'" + "OR eidos2_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos2_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos2_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos2_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos2_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos2_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos2_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos2_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos2_tim = "
					+ "'Κ.Visanto'" + "OR eidos2_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos2_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos2_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos2_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos2_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos2_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos2_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos2_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos2_tim = " + "'Ρ.Visanto'" + "OR eidos2_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos2_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos2_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos2_tim = " + "'Asti Martini'"
					+ "OR eidos2_tim = " + "'Asti μικρή'"
					+ "OR eidos2_tim = " + "'Gordon Rouge'"
					+ "OR eidos2_tim = " + "'Moschato D Asti'"
					+ "OR eidos2_tim = " + "'Dom Perignon'"
					+ "OR eidos2_tim = " + "'Moet et Chandon'"
					+ "OR eidos2_tim = " + "'Veuve Clickuot'"
					+ "OR eidos2_tim = " + "'Veuve aperitif'"
					+ "OR eidos3_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos3_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos3_tim = " + "'Λ.Μικρός'"
					+ "OR eidos3_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos3_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos3_tim = " + "'Λ.Βιβλία'" + "OR eidos3_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos3_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos3_tim = " + "'Λ.Ευπορία'" + "OR eidos3_tim = "
					+ "'Λ.Isari'" + "OR eidos3_tim = " + "'Λ.Cirinon'"
					+ "OR eidos3_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos3_tim = "
					+ "'Κ.Cirinon'" + "OR eidos3_tim = " + "'Κ.Idonida'"
					+ "OR eidos3_tim = " + "'Κ.Isari'" + "OR eidos3_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos3_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos3_tim = " + "'Κ.Chateau'" + "OR eidos3_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos3_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos3_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos3_tim = " + "'Κ.Μικρός'" + "OR eidos3_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos3_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos3_tim = " + "'Ρ.Βιβλία'" + "OR eidos3_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos3_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos3_tim = " + "'Ρ.Cirinon'" + "OR eidos3_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos3_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos3_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos3_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos3_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos3_tim = "
					+ "'Λ.Sangria'" + "OR eidos3_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Λ.Αμέθυστος'" + "OR eidos3_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos3_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos3_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos3_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos3_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos3_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos3_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos3_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos3_tim = "
					+ "'Λ.Visanto'" + "OR eidos3_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos3_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos3_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos3_tim = " + "'Κ.Sangria'"
					+ "OR eidos3_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Κ.Αμέθυστος'" + "OR eidos3_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos3_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos3_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos3_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos3_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos3_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos3_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos3_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos3_tim = "
					+ "'Κ.Visanto'" + "OR eidos3_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos3_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos3_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos3_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos3_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos3_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos3_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos3_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos3_tim = " + "'Ρ.Visanto'" + "OR eidos3_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos3_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos3_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos3_tim = " + "'Asti Martini'"
					+ "OR eidos3_tim = " + "'Asti μικρή'"
					+ "OR eidos3_tim = " + "'Gordon Rouge'"
					+ "OR eidos3_tim = " + "'Moschato D Asti'"
					+ "OR eidos3_tim = " + "'Dom Perignon'"
					+ "OR eidos3_tim = " + "'Moet et Chandon'"
					+ "OR eidos3_tim = " + "'Veuve Clickuot'"
					+ "OR eidos3_tim = " + "'Veuve aperitif'"
					+ "OR eidos4_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos4_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos4_tim = " + "'Λ.Μικρός'"
					+ "OR eidos4_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos4_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos4_tim = " + "'Λ.Βιβλία'" + "OR eidos4_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos4_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos4_tim = " + "'Λ.Ευπορία'" + "OR eidos4_tim = "
					+ "'Λ.Isari'" + "OR eidos4_tim = " + "'Λ.Cirinon'"
					+ "OR eidos4_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos4_tim = "
					+ "'Κ.Cirinon'" + "OR eidos4_tim = " + "'Κ.Idonida'"
					+ "OR eidos4_tim = " + "'Κ.Isari'" + "OR eidos4_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos4_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos4_tim = " + "'Κ.Chateau'" + "OR eidos4_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos4_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos4_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos4_tim = " + "'Κ.Μικρός'" + "OR eidos4_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos4_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos4_tim = " + "'Ρ.Βιβλία'" + "OR eidos4_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos4_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos4_tim = " + "'Ρ.Cirinon'" + "OR eidos4_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos4_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos4_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos4_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos4_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos4_tim = "
					+ "'Λ.Sangria'" + "OR eidos4_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Λ.Αμέθυστος'" + "OR eidos4_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos4_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos4_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos4_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos4_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos4_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos4_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos4_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos4_tim = "
					+ "'Λ.Visanto'" + "OR eidos4_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos4_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos4_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos4_tim = " + "'Κ.Sangria'"
					+ "OR eidos4_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Κ.Αμέθυστος'" + "OR eidos4_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos4_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos4_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos4_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos4_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos4_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos4_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos4_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos4_tim = "
					+ "'Κ.Visanto'" + "OR eidos4_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos4_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos4_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos4_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos4_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos4_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos4_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos4_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos4_tim = " + "'Ρ.Visanto'" + "OR eidos4_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos4_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos4_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos4_tim = " + "'Asti Martini'"
					+ "OR eidos4_tim = " + "'Asti μικρή'"
					+ "OR eidos4_tim = " + "'Gordon Rouge'"
					+ "OR eidos4_tim = " + "'Moschato D Asti'"
					+ "OR eidos4_tim = " + "'Dom Perignon'"
					+ "OR eidos4_tim = " + "'Moet et Chandon'"
					+ "OR eidos4_tim = " + "'Veuve Clickuot'"
					+ "OR eidos4_tim = " + "'Veuve aperitif'"
					+ "OR eidos5_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos5_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos5_tim = " + "'Λ.Μικρός'"
					+ "OR eidos5_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos5_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos5_tim = " + "'Λ.Βιβλία'" + "OR eidos5_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos5_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos5_tim = " + "'Λ.Ευπορία'" + "OR eidos5_tim = "
					+ "'Λ.Isari'" + "OR eidos5_tim = " + "'Λ.Cirinon'"
					+ "OR eidos5_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos5_tim = "
					+ "'Κ.Cirinon'" + "OR eidos5_tim = " + "'Κ.Idonida'"
					+ "OR eidos5_tim = " + "'Κ.Isari'" + "OR eidos5_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos5_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos5_tim = " + "'Κ.Chateau'" + "OR eidos5_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos5_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos5_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos5_tim = " + "'Κ.Μικρός'" + "OR eidos5_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos5_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos5_tim = " + "'Ρ.Βιβλία'" + "OR eidos5_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos5_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos5_tim = " + "'Ρ.Cirinon'" + "OR eidos5_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos5_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos5_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos5_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos5_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos5_tim = "
					+ "'Λ.Sangria'" + "OR eidos5_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Λ.Αμέθυστος'" + "OR eidos5_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos5_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos5_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos5_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos5_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos5_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos5_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos5_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos5_tim = "
					+ "'Λ.Visanto'" + "OR eidos5_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos5_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos5_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos5_tim = " + "'Κ.Sangria'"
					+ "OR eidos5_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Κ.Αμέθυστος'" + "OR eidos5_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos5_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos5_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos5_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos5_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos5_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos5_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos5_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos5_tim = "
					+ "'Κ.Visanto'" + "OR eidos5_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos5_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos5_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos5_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos5_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos5_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos5_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos5_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos5_tim = " + "'Ρ.Visanto'" + "OR eidos5_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos5_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos5_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos5_tim = " + "'Asti Martini'"
					+ "OR eidos5_tim = " + "'Asti μικρή'"
					+ "OR eidos5_tim = " + "'Gordon Rouge'"
					+ "OR eidos5_tim = " + "'Moschato D Asti'"
					+ "OR eidos5_tim = " + "'Dom Perignon'"
					+ "OR eidos5_tim = " + "'Moet et Chandon'"
					+ "OR eidos5_tim = " + "'Veuve Clickuot'"
					+ "OR eidos5_tim = " + "'Veuve aperitif'"
					+ "OR eidos6_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos6_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos6_tim = " + "'Λ.Μικρός'"
					+ "OR eidos6_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos6_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos6_tim = " + "'Λ.Βιβλία'" + "OR eidos6_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos6_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos6_tim = " + "'Λ.Ευπορία'" + "OR eidos6_tim = "
					+ "'Λ.Isari'" + "OR eidos6_tim = " + "'Λ.Cirinon'"
					+ "OR eidos6_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos6_tim = "
					+ "'Κ.Cirinon'" + "OR eidos6_tim = " + "'Κ.Idonida'"
					+ "OR eidos6_tim = " + "'Κ.Isari'" + "OR eidos6_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos6_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos6_tim = " + "'Κ.Chateau'" + "OR eidos6_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos6_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos6_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos6_tim = " + "'Κ.Μικρός'" + "OR eidos6_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos6_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos6_tim = " + "'Ρ.Βιβλία'" + "OR eidos6_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos6_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos6_tim = " + "'Ρ.Cirinon'" + "OR eidos6_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos6_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos6_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos6_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos6_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos6_tim = "
					+ "'Λ.Sangria'" + "OR eidos6_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Λ.Αμέθυστος'" + "OR eidos6_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos6_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos6_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos6_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos6_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos6_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos6_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos6_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos6_tim = "
					+ "'Λ.Visanto'" + "OR eidos6_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos6_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos6_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos6_tim = " + "'Κ.Sangria'"
					+ "OR eidos6_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Κ.Αμέθυστος'" + "OR eidos6_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos6_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos6_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos6_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos6_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos6_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos6_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos6_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos6_tim = "
					+ "'Κ.Visanto'" + "OR eidos6_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos6_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos6_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos6_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos6_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos6_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos6_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos6_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos6_tim = " + "'Ρ.Visanto'" + "OR eidos6_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos6_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos6_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos6_tim = " + "'Asti Martini'"
					+ "OR eidos6_tim = " + "'Asti μικρή'"
					+ "OR eidos6_tim = " + "'Gordon Rouge'"
					+ "OR eidos6_tim = " + "'Moschato D Asti'"
					+ "OR eidos6_tim = " + "'Dom Perignon'"
					+ "OR eidos6_tim = " + "'Moet et Chandon'"
					+ "OR eidos6_tim = " + "'Veuve Clickuot'"
					+ "OR eidos6_tim = " + "'Veuve aperitif'"
					+ "OR eidos7_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos7_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos7_tim = " + "'Λ.Μικρός'"
					+ "OR eidos7_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos7_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos7_tim = " + "'Λ.Βιβλία'" + "OR eidos7_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos7_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos7_tim = " + "'Λ.Ευπορία'" + "OR eidos7_tim = "
					+ "'Λ.Isari'" + "OR eidos7_tim = " + "'Λ.Cirinon'"
					+ "OR eidos7_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos7_tim = "
					+ "'Κ.Cirinon'" + "OR eidos7_tim = " + "'Κ.Idonida'"
					+ "OR eidos7_tim = " + "'Κ.Isari'" + "OR eidos7_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos7_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos7_tim = " + "'Κ.Chateau'" + "OR eidos7_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos7_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos7_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos7_tim = " + "'Κ.Μικρός'" + "OR eidos7_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos7_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos7_tim = " + "'Ρ.Βιβλία'" + "OR eidos7_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos7_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos7_tim = " + "'Ρ.Cirinon'" + "OR eidos7_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos7_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos7_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos7_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos7_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos7_tim = "
					+ "'Λ.Sangria'" + "OR eidos7_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Λ.Αμέθυστος'" + "OR eidos7_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos7_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos7_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos7_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos7_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos7_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos7_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos7_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos7_tim = "
					+ "'Λ.Visanto'" + "OR eidos7_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos7_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos7_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos7_tim = " + "'Κ.Sangria'"
					+ "OR eidos7_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Κ.Αμέθυστος'" + "OR eidos7_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos7_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos7_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos7_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos7_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos7_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos7_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos7_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos7_tim = "
					+ "'Κ.Visanto'" + "OR eidos7_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos7_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos7_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos7_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos7_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos7_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos7_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos7_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos7_tim = " + "'Ρ.Visanto'" + "OR eidos7_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos7_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos7_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos7_tim = " + "'Asti Martini'"
					+ "OR eidos7_tim = " + "'Asti μικρή'"
					+ "OR eidos7_tim = " + "'Gordon Rouge'"
					+ "OR eidos7_tim = " + "'Moschato D Asti'"
					+ "OR eidos7_tim = " + "'Dom Perignon'"
					+ "OR eidos7_tim = " + "'Moet et Chandon'"
					+ "OR eidos7_tim = " + "'Veuve Clickuot'"
					+ "OR eidos7_tim = " + "'Veuve aperitif'"
					+ "OR eidos8_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos8_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos8_tim = " + "'Λ.Μικρός'"
					+ "OR eidos8_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos8_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos8_tim = " + "'Λ.Βιβλία'" + "OR eidos8_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos8_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos8_tim = " + "'Λ.Ευπορία'" + "OR eidos8_tim = "
					+ "'Λ.Isari'" + "OR eidos8_tim = " + "'Λ.Cirinon'"
					+ "OR eidos8_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos8_tim = "
					+ "'Κ.Cirinon'" + "OR eidos8_tim = " + "'Κ.Idonida'"
					+ "OR eidos8_tim = " + "'Κ.Isari'" + "OR eidos8_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos8_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos8_tim = " + "'Κ.Chateau'" + "OR eidos8_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos8_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos8_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos8_tim = " + "'Κ.Μικρός'" + "OR eidos8_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos8_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos8_tim = " + "'Ρ.Βιβλία'" + "OR eidos8_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos8_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos8_tim = " + "'Ρ.Cirinon'" + "OR eidos8_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos8_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos8_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos8_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos8_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos8_tim = "
					+ "'Λ.Sangria'" + "OR eidos8_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Λ.Αμέθυστος'" + "OR eidos8_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos8_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos8_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos8_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos8_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos8_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos8_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos8_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos8_tim = "
					+ "'Λ.Visanto'" + "OR eidos8_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos8_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos8_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos8_tim = " + "'Κ.Sangria'"
					+ "OR eidos8_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Κ.Αμέθυστος'" + "OR eidos8_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos8_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos8_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos8_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos8_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos8_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos8_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos8_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos8_tim = "
					+ "'Κ.Visanto'" + "OR eidos8_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos8_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos8_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos8_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos8_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos8_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos8_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos8_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos8_tim = " + "'Ρ.Visanto'" + "OR eidos8_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos8_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos8_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos8_tim = " + "'Asti Martini'"
					+ "OR eidos8_tim = " + "'Asti μικρή'"
					+ "OR eidos8_tim = " + "'Gordon Rouge'"
					+ "OR eidos8_tim = " + "'Moschato D Asti'"
					+ "OR eidos8_tim = " + "'Dom Perignon'"
					+ "OR eidos8_tim = " + "'Moet et Chandon'"
					+ "OR eidos8_tim = " + "'Veuve Clickuot'"
					+ "OR eidos8_tim = " + "'Veuve aperitif'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting TROFIMA DETAILS
	public ArrayList<Timologia> Get_TrofimaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos1_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos1_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos1_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos1_tim = "
					+ "'ψωμάκια burger'" + "OR eidos1_tim = " + "'κάπαρη'"
					+ "OR eidos1_tim = " + "'πέννες'" + "OR eidos1_tim = "
					+ "'λινγκουϊνι'" + "OR eidos1_tim = " + "'κουβερτούρα'"
					+ "OR eidos1_tim = " + "'μπασμάζι'" + "OR eidos1_tim = "
					+ "'μέλι'" + "OR eidos1_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos1_tim = " + "'ψωμί τόστ'" + "OR eidos1_tim = "
					+ "'καλαμπόκι'" + "OR eidos1_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos1_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos1_tim = " + "'ελαιόλαδο'"
					+ "OR eidos1_tim = " + "'σπορέλαιο'" + "OR eidos1_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos1_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos1_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos1_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos1_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos1_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos1_tim = " + "'αυγά'"
					+ "OR eidos1_tim = " + "'ψαρονέφρι'" + "OR eidos1_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos1_tim = " + "'χαβιάρι'"
					+ "OR eidos1_tim = " + "'παπαρδέλες'" + "OR eidos1_tim = "
					+ "'αρμπόριο'" + "OR eidos1_tim = " + "'μπασμάτι'"
					+ "OR eidos1_tim = " + "'soya sause'" + "OR eidos1_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos1_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos1_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos1_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos1_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos1_tim = "
					+ "'ψωμάκια burger'" + "OR eidos1_tim = " + "'κάπαρη'"
					+ "OR eidos1_tim = " + "'πέννες'" + "OR eidos1_tim = "
					+ "'λινγκουϊνι'" + "OR eidos1_tim = " + "'κουβερτούρα'"
					+ "OR eidos1_tim = " + "'μπασμάζι'" + "OR eidos1_tim = "
					+ "'μέλι'" + "OR eidos1_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos1_tim = " + "'ψωμί τόστ'" + "OR eidos1_tim = "
					+ "'καλαμπόκι'" + "OR eidos1_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos1_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos1_tim = " + "'ελαιόλαδο'"
					+ "OR eidos1_tim = " + "'σπορέλαιο'" + "OR eidos1_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos1_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos1_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos1_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos1_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos1_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos1_tim = " + "'αυγά'"
					+ "OR eidos1_tim = " + "'ψαρονέφρι'" + "OR eidos1_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos1_tim = " + "'χαβιάρι'"
					+ "OR eidos1_tim = " + "'παπαρδέλες'" + "OR eidos1_tim = "
					+ "'αρμπόριο'" + "OR eidos1_tim = " + "'μπασμάτι'"
					+ "OR eidos1_tim = " + "'soya sause'" + "OR eidos1_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos1_tim = " + "'πάγος'"
					+ "OR eidos1_tim = " + "'cranberry'" + "OR eidos1_tim = "
					+ "'μέλι'" + "OR eidos1_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos1_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos1_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos1_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos1_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos1_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos1_tim = " + "'πιτάκια Select'"
					+ "OR eidos2_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos2_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos2_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos2_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos2_tim = " + "'ψωμάκια burger'"
					+ "OR eidos2_tim = " + "'κάπαρη'" + "OR eidos2_tim = "
					+ "'πέννες'" + "OR eidos2_tim = " + "'λινγκουϊνι'"
					+ "OR eidos2_tim = " + "'κουβερτούρα'" + "OR eidos2_tim = "
					+ "'μπασμάζι'" + "OR eidos2_tim = " + "'μέλι'"
					+ "OR eidos2_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos2_tim = " + "'ψωμί τόστ'" + "OR eidos2_tim = "
					+ "'καλαμπόκι'" + "OR eidos2_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos2_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos2_tim = " + "'ελαιόλαδο'"
					+ "OR eidos2_tim = " + "'σπορέλαιο'" + "OR eidos2_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos2_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos2_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos2_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos2_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos2_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos2_tim = " + "'αυγά'"
					+ "OR eidos2_tim = " + "'ψαρονέφρι'" + "OR eidos2_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos2_tim = " + "'χαβιάρι'"
					+ "OR eidos2_tim = " + "'παπαρδέλες'" + "OR eidos2_tim = "
					+ "'αρμπόριο'" + "OR eidos2_tim = " + "'μπασμάτι'"
					+ "OR eidos2_tim = " + "'soya sause'" + "OR eidos2_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos2_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos2_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos2_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos2_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos2_tim = "
					+ "'ψωμάκια burger'" + "OR eidos2_tim = " + "'κάπαρη'"
					+ "OR eidos2_tim = " + "'πέννες'" + "OR eidos2_tim = "
					+ "'λινγκουϊνι'" + "OR eidos2_tim = " + "'κουβερτούρα'"
					+ "OR eidos2_tim = " + "'μπασμάζι'" + "OR eidos2_tim = "
					+ "'μέλι'" + "OR eidos2_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos2_tim = " + "'ψωμί τόστ'" + "OR eidos2_tim = "
					+ "'καλαμπόκι'" + "OR eidos2_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos2_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos2_tim = " + "'ελαιόλαδο'"
					+ "OR eidos2_tim = " + "'σπορέλαιο'" + "OR eidos2_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos2_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos2_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos2_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos2_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos2_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos2_tim = " + "'αυγά'"
					+ "OR eidos2_tim = " + "'ψαρονέφρι'" + "OR eidos2_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos2_tim = " + "'χαβιάρι'"
					+ "OR eidos2_tim = " + "'παπαρδέλες'" + "OR eidos2_tim = "
					+ "'αρμπόριο'" + "OR eidos2_tim = " + "'μπασμάτι'"
					+ "OR eidos2_tim = " + "'soya sause'" + "OR eidos2_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos2_tim = " + "'πάγος'"
					+ "OR eidos2_tim = " + "'cranberry'" + "OR eidos2_tim = "
					+ "'μέλι'" + "OR eidos2_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos2_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos2_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos2_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos2_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos2_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos2_tim = " + "'πιτάκια Select'"
					+ "OR eidos3_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos3_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos3_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos3_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos3_tim = " + "'ψωμάκια burger'"
					+ "OR eidos3_tim = " + "'κάπαρη'" + "OR eidos3_tim = "
					+ "'πέννες'" + "OR eidos3_tim = " + "'λινγκουϊνι'"
					+ "OR eidos3_tim = " + "'κουβερτούρα'" + "OR eidos3_tim = "
					+ "'μπασμάζι'" + "OR eidos3_tim = " + "'μέλι'"
					+ "OR eidos3_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos3_tim = " + "'ψωμί τόστ'" + "OR eidos3_tim = "
					+ "'καλαμπόκι'" + "OR eidos3_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos3_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos3_tim = " + "'ελαιόλαδο'"
					+ "OR eidos3_tim = " + "'σπορέλαιο'" + "OR eidos3_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos3_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos3_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos3_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos3_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos3_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos3_tim = " + "'αυγά'"
					+ "OR eidos3_tim = " + "'ψαρονέφρι'" + "OR eidos3_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos3_tim = " + "'χαβιάρι'"
					+ "OR eidos3_tim = " + "'παπαρδέλες'" + "OR eidos3_tim = "
					+ "'αρμπόριο'" + "OR eidos3_tim = " + "'μπασμάτι'"
					+ "OR eidos3_tim = " + "'soya sause'" + "OR eidos3_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos3_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos3_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos3_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos3_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos3_tim = "
					+ "'ψωμάκια burger'" + "OR eidos3_tim = " + "'κάπαρη'"
					+ "OR eidos3_tim = " + "'πέννες'" + "OR eidos3_tim = "
					+ "'λινγκουϊνι'" + "OR eidos3_tim = " + "'κουβερτούρα'"
					+ "OR eidos3_tim = " + "'μπασμάζι'" + "OR eidos3_tim = "
					+ "'μέλι'" + "OR eidos3_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos3_tim = " + "'ψωμί τόστ'" + "OR eidos3_tim = "
					+ "'καλαμπόκι'" + "OR eidos3_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos3_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos3_tim = " + "'ελαιόλαδο'"
					+ "OR eidos3_tim = " + "'σπορέλαιο'" + "OR eidos3_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos3_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos3_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos3_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos3_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos3_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos3_tim = " + "'αυγά'"
					+ "OR eidos3_tim = " + "'ψαρονέφρι'" + "OR eidos3_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos3_tim = " + "'χαβιάρι'"
					+ "OR eidos3_tim = " + "'παπαρδέλες'" + "OR eidos3_tim = "
					+ "'αρμπόριο'" + "OR eidos3_tim = " + "'μπασμάτι'"
					+ "OR eidos3_tim = " + "'soya sause'" + "OR eidos3_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos3_tim = " + "'πάγος'"
					+ "OR eidos3_tim = " + "'cranberry'" + "OR eidos3_tim = "
					+ "'μέλι'" + "OR eidos3_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos3_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos3_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos3_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos3_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos3_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos3_tim = " + "'πιτάκια Select'"
					+ "OR eidos4_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos4_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos4_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos4_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos4_tim = " + "'ψωμάκια burger'"
					+ "OR eidos4_tim = " + "'κάπαρη'" + "OR eidos4_tim = "
					+ "'πέννες'" + "OR eidos4_tim = " + "'λινγκουϊνι'"
					+ "OR eidos4_tim = " + "'κουβερτούρα'" + "OR eidos4_tim = "
					+ "'μπασμάζι'" + "OR eidos4_tim = " + "'μέλι'"
					+ "OR eidos4_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos4_tim = " + "'ψωμί τόστ'" + "OR eidos4_tim = "
					+ "'καλαμπόκι'" + "OR eidos4_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos4_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos4_tim = " + "'ελαιόλαδο'"
					+ "OR eidos4_tim = " + "'σπορέλαιο'" + "OR eidos4_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos4_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos4_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos4_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos4_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos4_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos4_tim = " + "'αυγά'"
					+ "OR eidos4_tim = " + "'ψαρονέφρι'" + "OR eidos4_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos4_tim = " + "'χαβιάρι'"
					+ "OR eidos4_tim = " + "'παπαρδέλες'" + "OR eidos4_tim = "
					+ "'αρμπόριο'" + "OR eidos4_tim = " + "'μπασμάτι'"
					+ "OR eidos4_tim = " + "'soya sause'" + "OR eidos4_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos4_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos4_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos4_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos4_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos4_tim = "
					+ "'ψωμάκια burger'" + "OR eidos4_tim = " + "'κάπαρη'"
					+ "OR eidos4_tim = " + "'πέννες'" + "OR eidos4_tim = "
					+ "'λινγκουϊνι'" + "OR eidos4_tim = " + "'κουβερτούρα'"
					+ "OR eidos4_tim = " + "'μπασμάζι'" + "OR eidos4_tim = "
					+ "'μέλι'" + "OR eidos4_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos4_tim = " + "'ψωμί τόστ'" + "OR eidos4_tim = "
					+ "'καλαμπόκι'" + "OR eidos4_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos4_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos4_tim = " + "'ελαιόλαδο'"
					+ "OR eidos4_tim = " + "'σπορέλαιο'" + "OR eidos4_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos4_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos4_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos4_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos4_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos4_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos4_tim = " + "'αυγά'"
					+ "OR eidos4_tim = " + "'ψαρονέφρι'" + "OR eidos4_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos4_tim = " + "'χαβιάρι'"
					+ "OR eidos4_tim = " + "'παπαρδέλες'" + "OR eidos4_tim = "
					+ "'αρμπόριο'" + "OR eidos4_tim = " + "'μπασμάτι'"
					+ "OR eidos4_tim = " + "'soya sause'" + "OR eidos4_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos4_tim = " + "'πάγος'"
					+ "OR eidos4_tim = " + "'cranberry'" + "OR eidos4_tim = "
					+ "'μέλι'" + "OR eidos4_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos4_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos4_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos4_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos4_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos4_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos4_tim = " + "'πιτάκια Select'"
					+ "OR eidos5_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos5_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos5_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos5_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos5_tim = " + "'ψωμάκια burger'"
					+ "OR eidos5_tim = " + "'κάπαρη'" + "OR eidos5_tim = "
					+ "'πέννες'" + "OR eidos5_tim = " + "'λινγκουϊνι'"
					+ "OR eidos5_tim = " + "'κουβερτούρα'" + "OR eidos5_tim = "
					+ "'μπασμάζι'" + "OR eidos5_tim = " + "'μέλι'"
					+ "OR eidos5_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos5_tim = " + "'ψωμί τόστ'" + "OR eidos5_tim = "
					+ "'καλαμπόκι'" + "OR eidos5_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos5_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos5_tim = " + "'ελαιόλαδο'"
					+ "OR eidos5_tim = " + "'σπορέλαιο'" + "OR eidos5_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos5_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos5_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos5_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos5_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos5_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos5_tim = " + "'αυγά'"
					+ "OR eidos5_tim = " + "'ψαρονέφρι'" + "OR eidos5_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos5_tim = " + "'χαβιάρι'"
					+ "OR eidos5_tim = " + "'παπαρδέλες'" + "OR eidos5_tim = "
					+ "'αρμπόριο'" + "OR eidos5_tim = " + "'μπασμάτι'"
					+ "OR eidos5_tim = " + "'soya sause'" + "OR eidos5_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos5_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos5_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos5_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos5_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos5_tim = "
					+ "'ψωμάκια burger'" + "OR eidos5_tim = " + "'κάπαρη'"
					+ "OR eidos5_tim = " + "'πέννες'" + "OR eidos5_tim = "
					+ "'λινγκουϊνι'" + "OR eidos5_tim = " + "'κουβερτούρα'"
					+ "OR eidos5_tim = " + "'μπασμάζι'" + "OR eidos5_tim = "
					+ "'μέλι'" + "OR eidos5_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos5_tim = " + "'ψωμί τόστ'" + "OR eidos5_tim = "
					+ "'καλαμπόκι'" + "OR eidos5_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos5_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos5_tim = " + "'ελαιόλαδο'"
					+ "OR eidos5_tim = " + "'σπορέλαιο'" + "OR eidos5_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos5_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos5_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos5_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos5_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos5_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos5_tim = " + "'αυγά'"
					+ "OR eidos5_tim = " + "'ψαρονέφρι'" + "OR eidos5_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos5_tim = " + "'χαβιάρι'"
					+ "OR eidos5_tim = " + "'παπαρδέλες'" + "OR eidos5_tim = "
					+ "'αρμπόριο'" + "OR eidos5_tim = " + "'μπασμάτι'"
					+ "OR eidos5_tim = " + "'soya sause'" + "OR eidos5_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos5_tim = " + "'πάγος'"
					+ "OR eidos5_tim = " + "'cranberry'" + "OR eidos5_tim = "
					+ "'μέλι'" + "OR eidos5_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos5_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos5_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos5_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos5_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos5_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos5_tim = " + "'πιτάκια Select'"
					+ "OR eidos6_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos6_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos6_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos6_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos6_tim = " + "'ψωμάκια burger'"
					+ "OR eidos6_tim = " + "'κάπαρη'" + "OR eidos6_tim = "
					+ "'πέννες'" + "OR eidos6_tim = " + "'λινγκουϊνι'"
					+ "OR eidos6_tim = " + "'κουβερτούρα'" + "OR eidos6_tim = "
					+ "'μπασμάζι'" + "OR eidos6_tim = " + "'μέλι'"
					+ "OR eidos6_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos6_tim = " + "'ψωμί τόστ'" + "OR eidos6_tim = "
					+ "'καλαμπόκι'" + "OR eidos6_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos6_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos6_tim = " + "'ελαιόλαδο'"
					+ "OR eidos6_tim = " + "'σπορέλαιο'" + "OR eidos6_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos6_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos6_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos6_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos6_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos6_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos6_tim = " + "'αυγά'"
					+ "OR eidos6_tim = " + "'ψαρονέφρι'" + "OR eidos6_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos6_tim = " + "'χαβιάρι'"
					+ "OR eidos6_tim = " + "'παπαρδέλες'" + "OR eidos6_tim = "
					+ "'αρμπόριο'" + "OR eidos6_tim = " + "'μπασμάτι'"
					+ "OR eidos6_tim = " + "'soya sause'" + "OR eidos6_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos6_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos6_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos6_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos6_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos6_tim = "
					+ "'ψωμάκια burger'" + "OR eidos6_tim = " + "'κάπαρη'"
					+ "OR eidos6_tim = " + "'πέννες'" + "OR eidos6_tim = "
					+ "'λινγκουϊνι'" + "OR eidos6_tim = " + "'κουβερτούρα'"
					+ "OR eidos6_tim = " + "'μπασμάζι'" + "OR eidos6_tim = "
					+ "'μέλι'" + "OR eidos6_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos6_tim = " + "'ψωμί τόστ'" + "OR eidos6_tim = "
					+ "'καλαμπόκι'" + "OR eidos6_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos6_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos6_tim = " + "'ελαιόλαδο'"
					+ "OR eidos6_tim = " + "'σπορέλαιο'" + "OR eidos6_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos6_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos6_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos6_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos6_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos6_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos6_tim = " + "'αυγά'"
					+ "OR eidos6_tim = " + "'ψαρονέφρι'" + "OR eidos6_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos6_tim = " + "'χαβιάρι'"
					+ "OR eidos6_tim = " + "'παπαρδέλες'" + "OR eidos6_tim = "
					+ "'αρμπόριο'" + "OR eidos6_tim = " + "'μπασμάτι'"
					+ "OR eidos6_tim = " + "'soya sause'" + "OR eidos6_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos6_tim = " + "'πάγος'"
					+ "OR eidos6_tim = " + "'cranberry'" + "OR eidos6_tim = "
					+ "'μέλι'" + "OR eidos6_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos6_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos6_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos6_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos6_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos6_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos6_tim = " + "'πιτάκια Select'"
					+ "OR eidos7_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos7_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos7_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos7_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos7_tim = " + "'ψωμάκια burger'"
					+ "OR eidos7_tim = " + "'κάπαρη'" + "OR eidos7_tim = "
					+ "'πέννες'" + "OR eidos7_tim = " + "'λινγκουϊνι'"
					+ "OR eidos7_tim = " + "'κουβερτούρα'" + "OR eidos7_tim = "
					+ "'μπασμάζι'" + "OR eidos7_tim = " + "'μέλι'"
					+ "OR eidos7_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos7_tim = " + "'ψωμί τόστ'" + "OR eidos7_tim = "
					+ "'καλαμπόκι'" + "OR eidos7_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos7_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos7_tim = " + "'ελαιόλαδο'"
					+ "OR eidos7_tim = " + "'σπορέλαιο'" + "OR eidos7_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos7_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos7_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos7_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos7_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos7_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos7_tim = " + "'αυγά'"
					+ "OR eidos7_tim = " + "'ψαρονέφρι'" + "OR eidos7_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos7_tim = " + "'χαβιάρι'"
					+ "OR eidos7_tim = " + "'παπαρδέλες'" + "OR eidos7_tim = "
					+ "'αρμπόριο'" + "OR eidos7_tim = " + "'μπασμάτι'"
					+ "OR eidos7_tim = " + "'soya sause'" + "OR eidos7_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos7_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos7_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos7_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos7_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos7_tim = "
					+ "'ψωμάκια burger'" + "OR eidos7_tim = " + "'κάπαρη'"
					+ "OR eidos7_tim = " + "'πέννες'" + "OR eidos7_tim = "
					+ "'λινγκουϊνι'" + "OR eidos7_tim = " + "'κουβερτούρα'"
					+ "OR eidos7_tim = " + "'μπασμάζι'" + "OR eidos7_tim = "
					+ "'μέλι'" + "OR eidos7_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos7_tim = " + "'ψωμί τόστ'" + "OR eidos7_tim = "
					+ "'καλαμπόκι'" + "OR eidos7_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos7_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos7_tim = " + "'ελαιόλαδο'"
					+ "OR eidos7_tim = " + "'σπορέλαιο'" + "OR eidos7_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos7_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos7_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos7_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos7_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos7_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos7_tim = " + "'αυγά'"
					+ "OR eidos7_tim = " + "'ψαρονέφρι'" + "OR eidos7_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos7_tim = " + "'χαβιάρι'"
					+ "OR eidos7_tim = " + "'παπαρδέλες'" + "OR eidos7_tim = "
					+ "'αρμπόριο'" + "OR eidos7_tim = " + "'μπασμάτι'"
					+ "OR eidos7_tim = " + "'soya sause'" + "OR eidos7_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos7_tim = " + "'πάγος'"
					+ "OR eidos7_tim = " + "'cranberry'" + "OR eidos7_tim = "
					+ "'μέλι'" + "OR eidos7_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos7_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos7_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos7_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos7_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos7_tim = " + "'σιρόπι καρύδα'"
					+ "OR eidos7_tim = " + "'πιτάκια Select'"
					+ "OR eidos8_tim = " + "'χυμός λεμονιού'"
					+ "OR eidos8_tim = " + "'καλαμάρι κατεψυγμένο'"
					+ "OR eidos8_tim = " + "'πορτοκάλι γλυκό'"
					+ "OR eidos8_tim = " + "'σύκα αποξηραμένα'"
					+ "OR eidos8_tim = " + "'ψωμάκια burger'"
					+ "OR eidos8_tim = " + "'κάπαρη'" + "OR eidos8_tim = "
					+ "'πέννες'" + "OR eidos8_tim = " + "'λινγκουϊνι'"
					+ "OR eidos8_tim = " + "'κουβερτούρα'" + "OR eidos8_tim = "
					+ "'μπασμάζι'" + "OR eidos8_tim = " + "'μέλι'"
					+ "OR eidos8_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos8_tim = " + "'ψωμί τόστ'" + "OR eidos8_tim = "
					+ "'καλαμπόκι'" + "OR eidos8_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos8_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos8_tim = " + "'ελαιόλαδο'"
					+ "OR eidos8_tim = " + "'σπορέλαιο'" + "OR eidos8_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos8_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos8_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos8_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos8_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos8_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos8_tim = " + "'αυγά'"
					+ "OR eidos8_tim = " + "'ψαρονέφρι'" + "OR eidos8_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos8_tim = " + "'χαβιάρι'"
					+ "OR eidos8_tim = " + "'παπαρδέλες'" + "OR eidos8_tim = "
					+ "'αρμπόριο'" + "OR eidos8_tim = " + "'μπασμάτι'"
					+ "OR eidos8_tim = " + "'soya sause'" + "OR eidos8_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos8_tim = "
					+ "'χυμός λεμονιού'" + "OR eidos8_tim = "
					+ "'καλαμάρι κατεψυγμένο'" + "OR eidos8_tim = "
					+ "'πορτοκάλι γλυκό'" + "OR eidos8_tim = "
					+ "'σύκα αποξηραμένα'" + "OR eidos8_tim = "
					+ "'ψωμάκια burger'" + "OR eidos8_tim = " + "'κάπαρη'"
					+ "OR eidos8_tim = " + "'πέννες'" + "OR eidos8_tim = "
					+ "'λινγκουϊνι'" + "OR eidos8_tim = " + "'κουβερτούρα'"
					+ "OR eidos8_tim = " + "'μπασμάζι'" + "OR eidos8_tim = "
					+ "'μέλι'" + "OR eidos8_tim = " + "'μπαγκετάκια μικρά'"
					+ "OR eidos8_tim = " + "'ψωμί τόστ'" + "OR eidos8_tim = "
					+ "'καλαμπόκι'" + "OR eidos8_tim = "
					+ "'μπαγιάτικο ψωμί για κιμά'" + "OR eidos8_tim = "
					+ "'πεστό βασιλικού'" + "OR eidos8_tim = " + "'ελαιόλαδο'"
					+ "OR eidos8_tim = " + "'σπορέλαιο'" + "OR eidos8_tim = "
					+ "'σκουμπρί καπνιστό με ρίγανη'" + "OR eidos8_tim = "
					+ "'μπαγκέτα λευκή'" + "OR eidos8_tim = "
					+ "'μπαγκέτα μάυρη'" + "OR eidos8_tim = "
					+ "'μπαγκετάκι λευκό'" + "OR eidos8_tim = "
					+ "'γαρίδες Νο1'" + "OR eidos8_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos8_tim = " + "'αυγά'"
					+ "OR eidos8_tim = " + "'ψαρονέφρι'" + "OR eidos8_tim = "
					+ "'καπνιστός σολωμός'" + "OR eidos8_tim = " + "'χαβιάρι'"
					+ "OR eidos8_tim = " + "'παπαρδέλες'" + "OR eidos8_tim = "
					+ "'αρμπόριο'" + "OR eidos8_tim = " + "'μπασμάτι'"
					+ "OR eidos8_tim = " + "'soya sause'" + "OR eidos8_tim = "
					+ "'μύδια με κέλυφος'" + "OR eidos8_tim = " + "'πάγος'"
					+ "OR eidos8_tim = " + "'cranberry'" + "OR eidos8_tim = "
					+ "'μέλι'" + "OR eidos8_tim = " + "'σιρόπι βανίλια'"
					+ "OR eidos8_tim = " + "'σιρόπι καραμέλα'"
					+ "OR eidos8_tim = " + "'σιρόπι φράουλα'"
					+ "OR eidos8_tim = " + "'σιρόπι φουντούκι'"
					+ "OR eidos8_tim = " + "'σιρόπι βύσσινο'"
					+ "OR eidos8_tim = " + "'σιρόπι καρύδα'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting SINODEUTIKA DETAILS
	public ArrayList<Timologia> Get_SinodeutikaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'πατατάκια'" + "OR eidos1_tim = " + "'κουλουράκια'"
					+ "OR eidos1_tim = " + "'φυστίκια Αιγίνης'"
					+ "OR eidos1_tim = " + "'φιλέ-αμύγλαδο'"
					+ "OR eidos1_tim = " + "'φυστίκια'" + "OR eidos1_tim = "
					+ "'μαρασκίνο'" + "OR eidos1_tim = " + "'μαγιονέζα'"
					+ "OR eidos1_tim = " + "'κέτσαπ'" + "OR eidos1_tim = "
					+ "'μουστάρδα'" + "OR eidos1_tim = " + "'φύλλα Τορτίγιας'"
					+ "OR eidos1_tim = " + "'γλυκόξινη σάλτσα'"
					+ "OR eidos1_tim = " + "'στικ μουστάρδα'"
					+ "OR eidos1_tim = " + "'κριτσίνια πολύσπορα'"
					+ "OR eidos1_tim = " + "'κριτσίνια καλαμπόκι'"
					+ "OR eidos1_tim = " + "'νερό μικρό'" + "OR eidos1_tim = "
					+ "'νερό μεγάλο'" + "OR eidos1_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos2_tim = " + "'πατατάκια'" + "OR eidos2_tim = "
					+ "'κουλουράκια'" + "OR eidos2_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos2_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos2_tim = " + "'φυστίκια'"
					+ "OR eidos2_tim = " + "'μαρασκίνο'" + "OR eidos2_tim = "
					+ "'μαγιονέζα'" + "OR eidos2_tim = " + "'κέτσαπ'"
					+ "OR eidos2_tim = " + "'μουστάρδα'" + "OR eidos2_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos2_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos2_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos2_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos2_tim = "
					+ "'νερό μικρό'" + "OR eidos2_tim = " + "'νερό μεγάλο'"
					+ "OR eidos2_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos3_tim = " + "'πατατάκια'" + "OR eidos3_tim = "
					+ "'κουλουράκια'" + "OR eidos3_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos3_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos3_tim = " + "'φυστίκια'"
					+ "OR eidos3_tim = " + "'μαρασκίνο'" + "OR eidos3_tim = "
					+ "'μαγιονέζα'" + "OR eidos3_tim = " + "'κέτσαπ'"
					+ "OR eidos3_tim = " + "'μουστάρδα'" + "OR eidos3_tim = "
					+ "'φύλλα Τορτίγιας'" + "OR eidos3_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos3_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos3_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos3_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos3_tim = "
					+ "'νερό μικρό'" + "OR eidos3_tim = " + "'νερό μεγάλο'"
					+ "OR eidos3_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos4_tim = " + "'πατατάκια'" + "OR eidos4_tim = "
					+ "'κουλουράκια'" + "OR eidos4_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos4_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos4_tim = " + "'φυστίκια'"
					+ "OR eidos4_tim = " + "'μαρασκίνο'" + "OR eidos4_tim = "
					+ "'μαγιονέζα'" + "OR eidos4_tim = " + "'κέτσαπ'"
					+ "OR eidos4_tim = " + "'μουστάρδα'" + "OR eidos4_tim = "
					+ "'φύλλα Τορτίγιας'"  + "OR eidos4_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos4_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos4_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos4_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos4_tim = "
					+ "'νερό μικρό'" + "OR eidos4_tim = " + "'νερό μεγάλο'"
					+ "OR eidos4_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos5_tim = " + "'πατατάκια'" + "OR eidos5_tim = "
					+ "'κουλουράκια'" + "OR eidos5_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos5_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos5_tim = " + "'φυστίκια'"
					+ "OR eidos5_tim = " + "'μαρασκίνο'" + "OR eidos5_tim = "
					+ "'μαγιονέζα'" + "OR eidos5_tim = " + "'κέτσαπ'"
					+ "OR eidos5_tim = " + "'μουστάρδα'" + "OR eidos5_tim = "
					+ "'φύλλα Τορτίγιας'" + "OR eidos5_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos5_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos5_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos5_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos5_tim = "
					+ "'νερό μικρό'" + "OR eidos5_tim = " + "'νερό μεγάλο'"
					+ "OR eidos5_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos6_tim = " + "'πατατάκια'" + "OR eidos6_tim = "
					+ "'κουλουράκια'" + "OR eidos6_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos6_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos6_tim = " + "'φυστίκια'"
					+ "OR eidos6_tim = " + "'μαρασκίνο'" + "OR eidos6_tim = "
					+ "'μαγιονέζα'" + "OR eidos6_tim = " + "'κέτσαπ'"
					+ "OR eidos6_tim = " + "'μουστάρδα'" + "OR eidos6_tim = "
					+ "'φύλλα Τορτίγιας'" + "OR eidos6_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos6_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos6_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos6_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos6_tim = "
					+ "'νερό μικρό'" + "OR eidos6_tim = " + "'νερό μεγάλο'"
					+ "OR eidos6_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos7_tim = " + "'πατατάκια'" + "OR eidos7_tim = "
					+ "'κουλουράκια'" + "OR eidos7_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos7_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos7_tim = " + "'φυστίκια'"
					+ "OR eidos7_tim = " + "'μαρασκίνο'" + "OR eidos7_tim = "
					+ "'μαγιονέζα'" + "OR eidos7_tim = " + "'κέτσαπ'"
					+ "OR eidos7_tim = " + "'μουστάρδα'" + "OR eidos7_tim = "
					+ "'φύλλα Τορτίγιας'" + "OR eidos7_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos7_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos7_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos7_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos7_tim = "
					+ "'νερό μικρό'" + "OR eidos7_tim = " + "'νερό μεγάλο'"
					+ "OR eidos7_tim = " + "'κορπή ανθρακ.'"
					+ "OR eidos8_tim = " + "'πατατάκια'" + "OR eidos8_tim = "
					+ "'κουλουράκια'" + "OR eidos8_tim = "
					+ "'φυστίκια Αιγίνης'" + "OR eidos8_tim = "
					+ "'φιλέ-αμύγλαδο'" + "OR eidos8_tim = " + "'φυστίκια'"
					+ "OR eidos8_tim = " + "'μαρασκίνο'" + "OR eidos8_tim = "
					+ "'μαγιονέζα'" + "OR eidos8_tim = " + "'κέτσαπ'"
					+ "OR eidos8_tim = " + "'μουστάρδα'" + "OR eidos8_tim = "
					+ "'φύλλα Τορτίγιας'" + "OR eidos8_tim = "
					+ "'γλυκόξινη σάλτσα'" + "OR eidos8_tim = "
					+ "'στικ μουστάρδα'" + "OR eidos8_tim = "
					+ "'κριτσίνια πολύσπορα'" + "OR eidos8_tim = "
					+ "'κριτσίνια καλαμπόκι'" + "OR eidos8_tim = "
					+ "'νερό μικρό'" + "OR eidos8_tim = " + "'νερό μεγάλο'"
					+ "OR eidos8_tim = " + "'κορπή ανθρακ.'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting OUISKIA DETAILS
	public ArrayList<Timologia> Get_OuiskiaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Johnie'" + "OR eidos1_tim = " + "'Johnie black'"
					+ "OR eidos1_tim = " + "'Johnie platinum'"
					+ "OR eidos1_tim = " + "'Johnie gold'" + "OR eidos1_tim = "
					+ "'Johnie blue'" + "OR eidos1_tim = " + "'Dewars'"
					+ "OR eidos1_tim = " + "'Cutty Sark'" + "OR eidos1_tim = "
					+ "'Famous'" + "OR eidos1_tim = " + "'Haig'"
					+ "OR eidos1_tim = " + "'Ballandines'" + "OR eidos1_tim = "
					+ "'Bells'" + "OR eidos1_tim = " + "'Grands'"
					+ "OR eidos1_tim = " + "'Wild Turkey'" + "OR eidos1_tim = "
					+ "'Teachers'" + "OR eidos1_tim = " + "'J&B'"
					+ "OR eidos1_tim = " + "'Jim Beam'" + "OR eidos1_tim = "
					+ "'Four Roses'" + "OR eidos1_tim = " + "'Canadian'"
					+ "OR eidos1_tim = " + "'Jameson'" + "OR eidos1_tim = "
					+ "'Bushmills'" + "OR eidos1_tim = " + "'Comfort'"
					+ "OR eidos1_tim = " + "'Tullamore'" + "OR eidos1_tim = "
					+ "'Jameson 12'" + "OR eidos1_tim = " + "'Jack'"
					+ "OR eidos1_tim = " + "'Dimple'" + "OR eidos1_tim = "
					+ "'Chivas'" + "OR eidos1_tim = " + "'Cardhu'"
					+ "OR eidos1_tim = " + "'Cutty 12'" + "OR eidos1_tim = "
					+ "'Cutty 15'" + "OR eidos1_tim = " + "'Glenfiddich'"
					+ "OR eidos1_tim = " + "'Glenmorangie'"
					+ "OR eidos1_tim = " + "'Oban'" + "OR eidos1_tim = "
					+ "'Lagavulin'" + "OR eidos1_tim = " + "'Macallan'"
					+ "OR eidos1_tim = " + "'Johnie green'"
					+ "OR eidos1_tim = " + "'Makers Mark'" + "OR eidos1_tim = "
					+ "'Bushmills 10'" + "OR eidos1_tim = " + "'Comfort lime'"
					+ "OR eidos1_tim = " + "'Cutty 18'" + "OR eidos1_tim = "
					+ "'Dalwhinnie'" + "OR eidos1_tim = " + "'Glenlivet'"
					+ "OR eidos1_tim = " + "'Talisker'" + "OR eidos1_tim = "
					+ "'Dalmore'" + "OR eidos1_tim = " + "'Gragganmore'"
					+ "OR eidos1_tim = " + "'Caol ila'" + "OR eidos2_tim = "
					+ "'Johnie'" + "OR eidos2_tim = " + "'Johnie black'"
					+ "OR eidos2_tim = " + "'Johnie platinum'"
					+ "OR eidos2_tim = " + "'Johnie gold'" + "OR eidos2_tim = "
					+ "'Johnie blue'" + "OR eidos2_tim = " + "'Dewars'"
					+ "OR eidos2_tim = " + "'Cutty Sark'" + "OR eidos2_tim = "
					+ "'Famous'" + "OR eidos2_tim = " + "'Haig'"
					+ "OR eidos2_tim = " + "'Ballandines'" + "OR eidos2_tim = "
					+ "'Bells'" + "OR eidos2_tim = " + "'Grands'"
					+ "OR eidos2_tim = " + "'Wild Turkey'" + "OR eidos2_tim = "
					+ "'Teachers'" + "OR eidos2_tim = " + "'J&B'"
					+ "OR eidos2_tim = " + "'Jim Beam'" + "OR eidos2_tim = "
					+ "'Four Roses'" + "OR eidos2_tim = " + "'Canadian'"
					+ "OR eidos2_tim = " + "'Jameson'" + "OR eidos2_tim = "
					+ "'Bushmills'" + "OR eidos2_tim = " + "'Comfort'"
					+ "OR eidos2_tim = " + "'Tullamore'" + "OR eidos2_tim = "
					+ "'Jameson 12'" + "OR eidos2_tim = " + "'Jack'"
					+ "OR eidos2_tim = " + "'Dimple'" + "OR eidos2_tim = "
					+ "'Chivas'" + "OR eidos2_tim = " + "'Cardhu'"
					+ "OR eidos2_tim = " + "'Cutty 12'" + "OR eidos2_tim = "
					+ "'Cutty 15'" + "OR eidos2_tim = " + "'Glenfiddich'"
					+ "OR eidos2_tim = " + "'Glenmorangie'"
					+ "OR eidos2_tim = " + "'Oban'" + "OR eidos2_tim = "
					+ "'Lagavulin'" + "OR eidos2_tim = " + "'Macallan'"
					+ "OR eidos2_tim = " + "'Johnie green'"
					+ "OR eidos2_tim = " + "'Makers Mark'" + "OR eidos2_tim = "
					+ "'Bushmills 10'" + "OR eidos2_tim = " + "'Comfort lime'"
					+ "OR eidos2_tim = " + "'Cutty 18'" + "OR eidos2_tim = "
					+ "'Dalwhinnie'" + "OR eidos2_tim = " + "'Glenlivet'"
					+ "OR eidos2_tim = " + "'Talisker'" + "OR eidos2_tim = "
					+ "'Dalmore'" + "OR eidos2_tim = " + "'Gragganmore'"
					+ "OR eidos2_tim = " + "'Caol ila'" + "OR eidos3_tim = "
					+ "'Johnie'" + "OR eidos3_tim = " + "'Johnie black'"
					+ "OR eidos3_tim = " + "'Johnie platinum'"
					+ "OR eidos3_tim = " + "'Johnie gold'" + "OR eidos3_tim = "
					+ "'Johnie blue'" + "OR eidos3_tim = " + "'Dewars'"
					+ "OR eidos3_tim = " + "'Cutty Sark'" + "OR eidos3_tim = "
					+ "'Famous'" + "OR eidos3_tim = " + "'Haig'"
					+ "OR eidos3_tim = " + "'Ballandines'" + "OR eidos3_tim = "
					+ "'Bells'" + "OR eidos3_tim = " + "'Grands'"
					+ "OR eidos3_tim = " + "'Wild Turkey'" + "OR eidos3_tim = "
					+ "'Teachers'" + "OR eidos3_tim = " + "'J&B'"
					+ "OR eidos3_tim = " + "'Jim Beam'" + "OR eidos3_tim = "
					+ "'Four Roses'" + "OR eidos3_tim = " + "'Canadian'"
					+ "OR eidos3_tim = " + "'Jameson'" + "OR eidos3_tim = "
					+ "'Bushmills'" + "OR eidos3_tim = " + "'Comfort'"
					+ "OR eidos3_tim = " + "'Tullamore'" + "OR eidos3_tim = "
					+ "'Jameson 12'" + "OR eidos3_tim = " + "'Jack'"
					+ "OR eidos3_tim = " + "'Dimple'" + "OR eidos3_tim = "
					+ "'Chivas'" + "OR eidos3_tim = " + "'Cardhu'"
					+ "OR eidos3_tim = " + "'Cutty 12'" + "OR eidos3_tim = "
					+ "'Cutty 15'" + "OR eidos3_tim = " + "'Glenfiddich'"
					+ "OR eidos3_tim = " + "'Glenmorangie'"
					+ "OR eidos3_tim = " + "'Oban'" + "OR eidos3_tim = "
					+ "'Lagavulin'" + "OR eidos3_tim = " + "'Macallan'"
					+ "OR eidos3_tim = " + "'Johnie green'"
					+ "OR eidos3_tim = " + "'Makers Mark'" + "OR eidos3_tim = "
					+ "'Bushmills 10'" + "OR eidos3_tim = " + "'Comfort lime'"
					+ "OR eidos3_tim = " + "'Cutty 18'" + "OR eidos3_tim = "
					+ "'Dalwhinnie'" + "OR eidos3_tim = " + "'Glenlivet'"
					+ "OR eidos3_tim = " + "'Talisker'" + "OR eidos3_tim = "
					+ "'Dalmore'" + "OR eidos3_tim = " + "'Gragganmore'"
					+ "OR eidos3_tim = " + "'Caol ila'" + "OR eidos4_tim = "
					+ "'Johnie'" + "OR eidos4_tim = " + "'Johnie black'"
					+ "OR eidos4_tim = " + "'Johnie platinum'"
					+ "OR eidos4_tim = " + "'Johnie gold'" + "OR eidos4_tim = "
					+ "'Johnie blue'" + "OR eidos4_tim = " + "'Dewars'"
					+ "OR eidos4_tim = " + "'Cutty Sark'" + "OR eidos4_tim = "
					+ "'Famous'" + "OR eidos4_tim = " + "'Haig'"
					+ "OR eidos4_tim = " + "'Ballandines'" + "OR eidos4_tim = "
					+ "'Bells'" + "OR eidos4_tim = " + "'Grands'"
					+ "OR eidos4_tim = " + "'Wild Turkey'" + "OR eidos4_tim = "
					+ "'Teachers'" + "OR eidos4_tim = " + "'J&B'"
					+ "OR eidos4_tim = " + "'Jim Beam'" + "OR eidos4_tim = "
					+ "'Four Roses'" + "OR eidos4_tim = " + "'Canadian'"
					+ "OR eidos4_tim = " + "'Jameson'" + "OR eidos4_tim = "
					+ "'Bushmills'" + "OR eidos4_tim = " + "'Comfort'"
					+ "OR eidos4_tim = " + "'Tullamore'" + "OR eidos4_tim = "
					+ "'Jameson 12'" + "OR eidos4_tim = " + "'Jack'"
					+ "OR eidos4_tim = " + "'Dimple'" + "OR eidos4_tim = "
					+ "'Chivas'" + "OR eidos4_tim = " + "'Cardhu'"
					+ "OR eidos4_tim = " + "'Cutty 12'" + "OR eidos4_tim = "
					+ "'Cutty 15'" + "OR eidos4_tim = " + "'Glenfiddich'"
					+ "OR eidos4_tim = " + "'Glenmorangie'"
					+ "OR eidos4_tim = " + "'Oban'" + "OR eidos4_tim = "
					+ "'Lagavulin'" + "OR eidos4_tim = " + "'Macallan'"
					+ "OR eidos4_tim = " + "'Johnie green'"
					+ "OR eidos4_tim = " + "'Makers Mark'" + "OR eidos4_tim = "
					+ "'Bushmills 10'" + "OR eidos4_tim = " + "'Comfort lime'"
					+ "OR eidos4_tim = " + "'Cutty 18'" + "OR eidos4_tim = "
					+ "'Dalwhinnie'" + "OR eidos4_tim = " + "'Glenlivet'"
					+ "OR eidos4_tim = " + "'Talisker'" + "OR eidos4_tim = "
					+ "'Dalmore'" + "OR eidos4_tim = " + "'Gragganmore'"
					+ "OR eidos4_tim = " + "'Caol ila'" + "OR eidos5_tim = "
					+ "'Johnie'" + "OR eidos5_tim = " + "'Johnie black'"
					+ "OR eidos5_tim = " + "'Johnie platinum'"
					+ "OR eidos5_tim = " + "'Johnie gold'" + "OR eidos5_tim = "
					+ "'Johnie blue'" + "OR eidos5_tim = " + "'Dewars'"
					+ "OR eidos5_tim = " + "'Cutty Sark'" + "OR eidos5_tim = "
					+ "'Famous'" + "OR eidos5_tim = " + "'Haig'"
					+ "OR eidos5_tim = " + "'Ballandines'" + "OR eidos5_tim = "
					+ "'Bells'" + "OR eidos5_tim = " + "'Grands'"
					+ "OR eidos5_tim = " + "'Wild Turkey'" + "OR eidos5_tim = "
					+ "'Teachers'" + "OR eidos5_tim = " + "'J&B'"
					+ "OR eidos5_tim = " + "'Jim Beam'" + "OR eidos5_tim = "
					+ "'Four Roses'" + "OR eidos5_tim = " + "'Canadian'"
					+ "OR eidos5_tim = " + "'Jameson'" + "OR eidos5_tim = "
					+ "'Bushmills'" + "OR eidos5_tim = " + "'Comfort'"
					+ "OR eidos5_tim = " + "'Tullamore'" + "OR eidos5_tim = "
					+ "'Jameson 12'" + "OR eidos5_tim = " + "'Jack'"
					+ "OR eidos5_tim = " + "'Dimple'" + "OR eidos5_tim = "
					+ "'Chivas'" + "OR eidos5_tim = " + "'Cardhu'"
					+ "OR eidos5_tim = " + "'Cutty 12'" + "OR eidos5_tim = "
					+ "'Cutty 15'" + "OR eidos5_tim = " + "'Glenfiddich'"
					+ "OR eidos5_tim = " + "'Glenmorangie'"
					+ "OR eidos5_tim = " + "'Oban'" + "OR eidos5_tim = "
					+ "'Lagavulin'" + "OR eidos5_tim = " + "'Macallan'"
					+ "OR eidos5_tim = " + "'Johnie green'"
					+ "OR eidos5_tim = " + "'Makers Mark'" + "OR eidos5_tim = "
					+ "'Bushmills 10'" + "OR eidos5_tim = " + "'Comfort lime'"
					+ "OR eidos5_tim = " + "'Cutty 18'" + "OR eidos5_tim = "
					+ "'Dalwhinnie'" + "OR eidos5_tim = " + "'Glenlivet'"
					+ "OR eidos5_tim = " + "'Talisker'" + "OR eidos5_tim = "
					+ "'Dalmore'" + "OR eidos5_tim = " + "'Gragganmore'"
					+ "OR eidos5_tim = " + "'Caol ila'" + "OR eidos6_tim = "
					+ "'Johnie'" + "OR eidos6_tim = " + "'Johnie black'"
					+ "OR eidos6_tim = " + "'Johnie platinum'"
					+ "OR eidos6_tim = " + "'Johnie gold'" + "OR eidos6_tim = "
					+ "'Johnie blue'" + "OR eidos6_tim = " + "'Dewars'"
					+ "OR eidos6_tim = " + "'Cutty Sark'" + "OR eidos6_tim = "
					+ "'Famous'" + "OR eidos6_tim = " + "'Haig'"
					+ "OR eidos6_tim = " + "'Ballandines'" + "OR eidos6_tim = "
					+ "'Bells'" + "OR eidos6_tim = " + "'Grands'"
					+ "OR eidos6_tim = " + "'Wild Turkey'" + "OR eidos6_tim = "
					+ "'Teachers'" + "OR eidos6_tim = " + "'J&B'"
					+ "OR eidos6_tim = " + "'Jim Beam'" + "OR eidos6_tim = "
					+ "'Four Roses'" + "OR eidos6_tim = " + "'Canadian'"
					+ "OR eidos6_tim = " + "'Jameson'" + "OR eidos6_tim = "
					+ "'Bushmills'" + "OR eidos6_tim = " + "'Comfort'"
					+ "OR eidos6_tim = " + "'Tullamore'" + "OR eidos6_tim = "
					+ "'Jameson 12'" + "OR eidos6_tim = " + "'Jack'"
					+ "OR eidos6_tim = " + "'Dimple'" + "OR eidos6_tim = "
					+ "'Chivas'" + "OR eidos6_tim = " + "'Cardhu'"
					+ "OR eidos6_tim = " + "'Cutty 12'" + "OR eidos6_tim = "
					+ "'Cutty 15'" + "OR eidos6_tim = " + "'Glenfiddich'"
					+ "OR eidos6_tim = " + "'Glenmorangie'"
					+ "OR eidos6_tim = " + "'Oban'" + "OR eidos6_tim = "
					+ "'Lagavulin'" + "OR eidos6_tim = " + "'Macallan'"
					+ "OR eidos6_tim = " + "'Johnie green'"
					+ "OR eidos6_tim = " + "'Makers Mark'" + "OR eidos6_tim = "
					+ "'Bushmills 10'" + "OR eidos6_tim = " + "'Comfort lime'"
					+ "OR eidos6_tim = " + "'Cutty 18'" + "OR eidos6_tim = "
					+ "'Dalwhinnie'" + "OR eidos6_tim = " + "'Glenlivet'"
					+ "OR eidos6_tim = " + "'Talisker'" + "OR eidos6_tim = "
					+ "'Dalmore'" + "OR eidos6_tim = " + "'Gragganmore'"
					+ "OR eidos6_tim = " + "'Caol ila'" + "OR eidos7_tim = "
					+ "'Johnie'" + "OR eidos7_tim = " + "'Johnie black'"
					+ "OR eidos7_tim = " + "'Johnie platinum'"
					+ "OR eidos7_tim = " + "'Johnie gold'" + "OR eidos7_tim = "
					+ "'Johnie blue'" + "OR eidos7_tim = " + "'Dewars'"
					+ "OR eidos7_tim = " + "'Cutty Sark'" + "OR eidos7_tim = "
					+ "'Famous'" + "OR eidos7_tim = " + "'Haig'"
					+ "OR eidos7_tim = " + "'Ballandines'" + "OR eidos7_tim = "
					+ "'Bells'" + "OR eidos7_tim = " + "'Grands'"
					+ "OR eidos7_tim = " + "'Wild Turkey'" + "OR eidos7_tim = "
					+ "'Teachers'" + "OR eidos7_tim = " + "'J&B'"
					+ "OR eidos7_tim = " + "'Jim Beam'" + "OR eidos7_tim = "
					+ "'Four Roses'" + "OR eidos7_tim = " + "'Canadian'"
					+ "OR eidos7_tim = " + "'Jameson'" + "OR eidos7_tim = "
					+ "'Bushmills'" + "OR eidos7_tim = " + "'Comfort'"
					+ "OR eidos7_tim = " + "'Tullamore'" + "OR eidos7_tim = "
					+ "'Jameson 12'" + "OR eidos7_tim = " + "'Jack'"
					+ "OR eidos7_tim = " + "'Dimple'" + "OR eidos7_tim = "
					+ "'Chivas'" + "OR eidos7_tim = " + "'Cardhu'"
					+ "OR eidos7_tim = " + "'Cutty 12'" + "OR eidos7_tim = "
					+ "'Cutty 15'" + "OR eidos7_tim = " + "'Glenfiddich'"
					+ "OR eidos7_tim = " + "'Glenmorangie'"
					+ "OR eidos7_tim = " + "'Oban'" + "OR eidos7_tim = "
					+ "'Lagavulin'" + "OR eidos7_tim = " + "'Macallan'"
					+ "OR eidos7_tim = " + "'Johnie green'"
					+ "OR eidos7_tim = " + "'Makers Mark'" + "OR eidos7_tim = "
					+ "'Bushmills 10'" + "OR eidos7_tim = " + "'Comfort lime'"
					+ "OR eidos7_tim = " + "'Cutty 18'" + "OR eidos7_tim = "
					+ "'Dalwhinnie'" + "OR eidos7_tim = " + "'Glenlivet'"
					+ "OR eidos7_tim = " + "'Talisker'" + "OR eidos7_tim = "
					+ "'Dalmore'" + "OR eidos7_tim = " + "'Gragganmore'"
					+ "OR eidos7_tim = " + "'Caol ila'" + "OR eidos8_tim = "
					+ "'Johnie'" + "OR eidos8_tim = " + "'Johnie black'"
					+ "OR eidos8_tim = " + "'Johnie platinum'"
					+ "OR eidos8_tim = " + "'Johnie gold'" + "OR eidos8_tim = "
					+ "'Johnie blue'" + "OR eidos8_tim = " + "'Dewars'"
					+ "OR eidos8_tim = " + "'Cutty Sark'" + "OR eidos8_tim = "
					+ "'Famous'" + "OR eidos8_tim = " + "'Haig'"
					+ "OR eidos8_tim = " + "'Ballandines'" + "OR eidos8_tim = "
					+ "'Bells'" + "OR eidos8_tim = " + "'Grands'"
					+ "OR eidos8_tim = " + "'Wild Turkey'" + "OR eidos8_tim = "
					+ "'Teachers'" + "OR eidos8_tim = " + "'J&B'"
					+ "OR eidos8_tim = " + "'Jim Beam'" + "OR eidos8_tim = "
					+ "'Four Roses'" + "OR eidos8_tim = " + "'Canadian'"
					+ "OR eidos8_tim = " + "'Jameson'" + "OR eidos8_tim = "
					+ "'Bushmills'" + "OR eidos8_tim = " + "'Comfort'"
					+ "OR eidos8_tim = " + "'Tullamore'" + "OR eidos8_tim = "
					+ "'Jameson 12'" + "OR eidos8_tim = " + "'Jack'"
					+ "OR eidos8_tim = " + "'Dimple'" + "OR eidos8_tim = "
					+ "'Chivas'" + "OR eidos8_tim = " + "'Cardhu'"
					+ "OR eidos8_tim = " + "'Cutty 12'" + "OR eidos8_tim = "
					+ "'Cutty 15'" + "OR eidos8_tim = " + "'Glenfiddich'"
					+ "OR eidos8_tim = " + "'Glenmorangie'"
					+ "OR eidos8_tim = " + "'Oban'" + "OR eidos8_tim = "
					+ "'Lagavulin'" + "OR eidos8_tim = " + "'Macallan'"
					+ "OR eidos8_tim = " + "'Johnie green'"
					+ "OR eidos8_tim = " + "'Makers Mark'" + "OR eidos8_tim = "
					+ "'Bushmills 10'" + "OR eidos8_tim = " + "'Comfort lime'"
					+ "OR eidos8_tim = " + "'Cutty 18'" + "OR eidos8_tim = "
					+ "'Dalwhinnie'" + "OR eidos8_tim = " + "'Glenlivet'"
					+ "OR eidos8_tim = " + "'Talisker'" + "OR eidos8_tim = "
					+ "'Dalmore'" + "OR eidos8_tim = " + "'Gragganmore'"
					+ "OR eidos8_tim = " + "'Caol ila'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting VODKA DETAILS
	public ArrayList<Timologia> Get_VodkaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Smirnoff red'" + "OR eidos1_tim = "
					+ "'Smirnoff black'" + "OR eidos1_tim = " + "'North'"
					+ "OR eidos1_tim = " + "'Ursus'" + "OR eidos1_tim = "
					+ "'Stoli'" + "OR eidos1_tim = " + "'Absolut'"
					+ "OR eidos1_tim = " + "'Finlandia'" + "OR eidos1_tim = "
					+ "'Belvedere'" + "OR eidos1_tim = " + "'Ketel one'"
					+ "OR eidos1_tim = " + "'Grey goose'" + "OR eidos1_tim = "
					+ "'Ciroc'" + "OR eidos1_tim = " + "'Standar'"
					+ "OR eidos2_tim = " + "'Smirnoff red'"
					+ "OR eidos2_tim = " + "'Smirnoff black'"
					+ "OR eidos2_tim = " + "'North'" + "OR eidos2_tim = "
					+ "'Ursus'" + "OR eidos2_tim = " + "'Stoli'"
					+ "OR eidos2_tim = " + "'Absolut'" + "OR eidos2_tim = "
					+ "'Finlandia'" + "OR eidos2_tim = " + "'Belvedere'"
					+ "OR eidos2_tim = " + "'Ketel one'" + "OR eidos2_tim = "
					+ "'Grey goose'" + "OR eidos2_tim = " + "'Ciroc'"
					+ "OR eidos2_tim = " + "'Standar'" + "OR eidos3_tim = "
					+ "'Smirnoff red'" + "OR eidos3_tim = "
					+ "'Smirnoff black'" + "OR eidos3_tim = " + "'North'"
					+ "OR eidos3_tim = " + "'Ursus'" + "OR eidos3_tim = "
					+ "'Stoli'" + "OR eidos3_tim = " + "'Absolut'"
					+ "OR eidos3_tim = " + "'Finlandia'" + "OR eidos3_tim = "
					+ "'Belvedere'" + "OR eidos3_tim = " + "'Ketel one'"
					+ "OR eidos3_tim = " + "'Grey goose'" + "OR eidos3_tim = "
					+ "'Ciroc'" + "OR eidos3_tim = " + "'Standar'"
					+ "OR eidos4_tim = " + "'Smirnoff red'"
					+ "OR eidos4_tim = " + "'Smirnoff black'"
					+ "OR eidos4_tim = " + "'North'" + "OR eidos4_tim = "
					+ "'Ursus'" + "OR eidos4_tim = " + "'Stoli'"
					+ "OR eidos4_tim = " + "'Absolut'" + "OR eidos4_tim = "
					+ "'Finlandia'" + "OR eidos4_tim = " + "'Belvedere'"
					+ "OR eidos4_tim = " + "'Ketel one'" + "OR eidos4_tim = "
					+ "'Grey goose'" + "OR eidos4_tim = " + "'Ciroc'"
					+ "OR eidos4_tim = " + "'Standar'" + "OR eidos5_tim = "
					+ "'Smirnoff red'" + "OR eidos5_tim = "
					+ "'Smirnoff black'" + "OR eidos5_tim = " + "'North'"
					+ "OR eidos5_tim = " + "'Ursus'" + "OR eidos5_tim = "
					+ "'Stoli'" + "OR eidos5_tim = " + "'Absolut'"
					+ "OR eidos5_tim = " + "'Finlandia'" + "OR eidos5_tim = "
					+ "'Belvedere'" + "OR eidos5_tim = " + "'Ketel one'"
					+ "OR eidos5_tim = " + "'Grey goose'" + "OR eidos5_tim = "
					+ "'Ciroc'" + "OR eidos5_tim = " + "'Standar'"
					+ "OR eidos6_tim = " + "'Smirnoff red'"
					+ "OR eidos6_tim = " + "'Smirnoff black'"
					+ "OR eidos6_tim = " + "'North'" + "OR eidos6_tim = "
					+ "'Ursus'" + "OR eidos6_tim = " + "'Stoli'"
					+ "OR eidos6_tim = " + "'Absolut'" + "OR eidos6_tim = "
					+ "'Finlandia'" + "OR eidos6_tim = " + "'Belvedere'"
					+ "OR eidos6_tim = " + "'Ketel one'" + "OR eidos6_tim = "
					+ "'Grey goose'" + "OR eidos6_tim = " + "'Ciroc'"
					+ "OR eidos6_tim = " + "'Standar'" + "OR eidos7_tim = "
					+ "'Smirnoff red'" + "OR eidos7_tim = "
					+ "'Smirnoff black'" + "OR eidos7_tim = " + "'North'"
					+ "OR eidos7_tim = " + "'Ursus'" + "OR eidos7_tim = "
					+ "'Stoli'" + "OR eidos7_tim = " + "'Absolut'"
					+ "OR eidos7_tim = " + "'Finlandia'" + "OR eidos7_tim = "
					+ "'Belvedere'" + "OR eidos7_tim = " + "'Ketel one'"
					+ "OR eidos7_tim = " + "'Grey goose'" + "OR eidos7_tim = "
					+ "'Ciroc'" + "OR eidos7_tim = " + "'Standar'"
					+ "OR eidos8_tim = " + "'Smirnoff red'"
					+ "OR eidos8_tim = " + "'Smirnoff black'"
					+ "OR eidos8_tim = " + "'North'" + "OR eidos8_tim = "
					+ "'Ursus'" + "OR eidos8_tim = " + "'Stoli'"
					+ "OR eidos8_tim = " + "'Absolut'" + "OR eidos8_tim = "
					+ "'Finlandia'" + "OR eidos8_tim = " + "'Belvedere'"
					+ "OR eidos8_tim = " + "'Ketel one'" + "OR eidos8_tim = "
					+ "'Grey goose'" + "OR eidos8_tim = " + "'Ciroc'"
					+ "OR eidos8_tim = " + "'Standar'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting GIN DETAILS
	public ArrayList<Timologia> Get_GinDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Gordons'" + "OR eidos1_tim = " + "'Beefeater'"
					+ "OR eidos1_tim = " + "'Bombay'" + "OR eidos1_tim = "
					+ "'Tanqeauray'" + "OR eidos1_tim = " + "'Tanqeauray ten'"
					+ "OR eidos1_tim = " + "'Hendricks'" + "OR eidos1_tim = "
					+ "'Beefeater 24'" + "OR eidos2_tim = " + "'Gordons'"
					+ "OR eidos2_tim = " + "'Beefeater'" + "OR eidos2_tim = "
					+ "'Bombay'" + "OR eidos2_tim = " + "'Tanqeauray'"
					+ "OR eidos2_tim = " + "'Tanqeauray ten'"
					+ "OR eidos2_tim = " + "'Hendricks'" + "OR eidos2_tim = "
					+ "'Beefeater 24'" + "OR eidos3_tim = " + "'Gordons'"
					+ "OR eidos3_tim = " + "'Beefeater'" + "OR eidos3_tim = "
					+ "'Bombay'" + "OR eidos3_tim = " + "'Tanqeauray'"
					+ "OR eidos3_tim = " + "'Tanqeauray ten'"
					+ "OR eidos3_tim = " + "'Hendricks'" + "OR eidos3_tim = "
					+ "'Beefeater 24'" + "OR eidos4_tim = " + "'Gordons'"
					+ "OR eidos4_tim = " + "'Beefeater'" + "OR eidos4_tim = "
					+ "'Bombay'" + "OR eidos4_tim = " + "'Tanqeauray'"
					+ "OR eidos4_tim = " + "'Tanqeauray ten'"
					+ "OR eidos4_tim = " + "'Hendricks'" + "OR eidos4_tim = "
					+ "'Beefeater 24'" + "OR eidos5_tim = " + "'Gordons'"
					+ "OR eidos5_tim = " + "'Beefeater'" + "OR eidos5_tim = "
					+ "'Bombay'" + "OR eidos5_tim = " + "'Tanqeauray'"
					+ "OR eidos5_tim = " + "'Tanqeauray ten'"
					+ "OR eidos5_tim = " + "'Hendricks'" + "OR eidos5_tim = "
					+ "'Beefeater 24'" + "OR eidos6_tim = " + "'Gordons'"
					+ "OR eidos6_tim = " + "'Beefeater'" + "OR eidos6_tim = "
					+ "'Bombay'" + "OR eidos6_tim = " + "'Tanqeauray'"
					+ "OR eidos6_tim = " + "'Tanqeauray ten'"
					+ "OR eidos6_tim = " + "'Hendricks'" + "OR eidos6_tim = "
					+ "'Beefeater 24'" + "OR eidos7_tim = " + "'Gordons'"
					+ "OR eidos7_tim = " + "'Beefeater'" + "OR eidos7_tim = "
					+ "'Bombay'" + "OR eidos7_tim = " + "'Tanqeauray'"
					+ "OR eidos7_tim = " + "'Tanqeauray ten'"
					+ "OR eidos7_tim = " + "'Hendricks'" + "OR eidos7_tim = "
					+ "'Beefeater 24'" + "OR eidos8_tim = " + "'Gordons'"
					+ "OR eidos8_tim = " + "'Beefeater'" + "OR eidos8_tim = "
					+ "'Bombay'" + "OR eidos8_tim = " + "'Tanqeauray'"
					+ "OR eidos8_tim = " + "'Tanqeauray ten'"
					+ "OR eidos8_tim = " + "'Hendricks'" + "OR eidos8_tim = "
					+ "'Beefeater 24'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting TEQUILA DETAILS
	public ArrayList<Timologia> Get_TequilaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Cuervo κίτρινη'" + "OR eidos1_tim = "
					+ "'Cuervo λευκή'" + "OR eidos1_tim = " + "'Cuervo Black'"
					+ "OR eidos1_tim = " + "'Don Julio anejo'"
					+ "OR eidos1_tim = " + "'Cuervo especial'"
					+ "OR eidos1_tim = " + "'Cuervo reserva'"
					+ "OR eidos1_tim = " + "'Don julio black'"
					+ "OR eidos1_tim = " + "'Don julio reposado'"
					+ "OR eidos1_tim = " + "'Herrandura'" + "OR eidos1_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos1_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos1_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos1_tim = " + "'Jimador'"
					+ "OR eidos1_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos2_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos2_tim = " + "'Cuervo λευκή'"
					+ "OR eidos2_tim = " + "'Cuervo Black'"
					+ "OR eidos2_tim = " + "'Don Julio anejo'"
					+ "OR eidos2_tim = " + "'Cuervo especial'"
					+ "OR eidos2_tim = " + "'Cuervo reserva'"
					+ "OR eidos2_tim = " + "'Don julio black'"
					+ "OR eidos2_tim = " + "'Don julio reposado'"
					+ "OR eidos2_tim = " + "'Herrandura'" + "OR eidos2_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos2_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos2_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos2_tim = " + "'Jimador'"
					+ "OR eidos2_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos3_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos3_tim = " + "'Cuervo λευκή'"
					+ "OR eidos3_tim = " + "'Cuervo Black'"
					+ "OR eidos3_tim = " + "'Don Julio anejo'"
					+ "OR eidos3_tim = " + "'Cuervo especial'"
					+ "OR eidos3_tim = " + "'Cuervo reserva'"
					+ "OR eidos3_tim = " + "'Don julio black'"
					+ "OR eidos3_tim = " + "'Don julio reposado'"
					+ "OR eidos3_tim = " + "'Herrandura'" + "OR eidos3_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos3_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos3_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos3_tim = " + "'Jimador'"
					+ "OR eidos3_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos4_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos4_tim = " + "'Cuervo λευκή'"
					+ "OR eidos4_tim = " + "'Cuervo Black'"
					+ "OR eidos4_tim = " + "'Don Julio anejo'"
					+ "OR eidos4_tim = " + "'Cuervo especial'"
					+ "OR eidos4_tim = " + "'Cuervo reserva'"
					+ "OR eidos4_tim = " + "'Don julio black'"
					+ "OR eidos4_tim = " + "'Don julio reposado'"
					+ "OR eidos4_tim = " + "'Herrandura'" + "OR eidos4_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos4_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos4_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos4_tim = " + "'Jimador'"
					+ "OR eidos4_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos5_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos5_tim = " + "'Cuervo λευκή'"
					+ "OR eidos5_tim = " + "'Cuervo Black'"
					+ "OR eidos5_tim = " + "'Don Julio anejo'"
					+ "OR eidos5_tim = " + "'Cuervo especial'"
					+ "OR eidos5_tim = " + "'Cuervo reserva'"
					+ "OR eidos5_tim = " + "'Don julio black'"
					+ "OR eidos5_tim = " + "'Don julio reposado'"
					+ "OR eidos5_tim = " + "'Herrandura'" + "OR eidos5_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos5_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos5_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos5_tim = " + "'Jimador'"
					+ "OR eidos5_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos6_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos6_tim = " + "'Cuervo λευκή'"
					+ "OR eidos6_tim = " + "'Cuervo Black'"
					+ "OR eidos6_tim = " + "'Don Julio anejo'"
					+ "OR eidos6_tim = " + "'Cuervo especial'"
					+ "OR eidos6_tim = " + "'Cuervo reserva'"
					+ "OR eidos6_tim = " + "'Don julio black'"
					+ "OR eidos6_tim = " + "'Don julio reposado'"
					+ "OR eidos6_tim = " + "'Herrandura'" + "OR eidos6_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos6_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos6_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos6_tim = " + "'Jimador'"
					+ "OR eidos6_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos7_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos7_tim = " + "'Cuervo λευκή'"
					+ "OR eidos7_tim = " + "'Cuervo Black'"
					+ "OR eidos7_tim = " + "'Don Julio anejo'"
					+ "OR eidos7_tim = " + "'Cuervo especial'"
					+ "OR eidos7_tim = " + "'Cuervo reserva'"
					+ "OR eidos7_tim = " + "'Don julio black'"
					+ "OR eidos7_tim = " + "'Don julio reposado'"
					+ "OR eidos7_tim = " + "'Herrandura'" + "OR eidos7_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos7_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos7_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos7_tim = " + "'Jimador'"
					+ "OR eidos7_tim = " + "'Jimador κίτρινη'"
					+ "OR eidos8_tim = " + "'Cuervo κίτρινη'"
					+ "OR eidos8_tim = " + "'Cuervo λευκή'"
					+ "OR eidos8_tim = " + "'Cuervo Black'"
					+ "OR eidos8_tim = " + "'Don Julio anejo'"
					+ "OR eidos8_tim = " + "'Cuervo especial'"
					+ "OR eidos8_tim = " + "'Cuervo reserva'"
					+ "OR eidos8_tim = " + "'Don julio black'"
					+ "OR eidos8_tim = " + "'Don julio reposado'"
					+ "OR eidos8_tim = " + "'Herrandura'" + "OR eidos8_tim = "
					+ "'Herradura κίτρινη'" + "OR eidos8_tim = "
					+ "'Olmeca σοκολάτα'" + "OR eidos8_tim = "
					+ "'Olmeca κίτρινη'" + "OR eidos8_tim = " + "'Jimador'"
					+ "OR eidos8_tim = " + "'Jimador κίτρινη'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting RUM DETAILS
	public ArrayList<Timologia> Get_RumDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Bacardi 0,7'" + "OR eidos1_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos1_tim = " + "'Havana λευκή'"
					+ "OR eidos1_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos1_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos1_tim = " + "'Havana 7'" + "OR eidos1_tim = "
					+ "'CT Morgan'" + "OR eidos1_tim = " + "'Pampero λευκό'"
					+ "OR eidos1_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos1_tim = " + "'Varadero'"
					+ "OR eidos1_tim = " + "'Cachaca'"
					+ "OR eidos1_tim = " + "'Zacapa'"
					+ "OR eidos2_tim = " + "'Bacardi 0,7'"
					+ "OR eidos2_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos2_tim = " + "'Havana λευκή'"
					+ "OR eidos2_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos2_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos2_tim = " + "'Havana 7'" + "OR eidos2_tim = "
					+ "'CT Morgan'" + "OR eidos2_tim = " + "'Pampero λευκό'"
					+ "OR eidos2_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos2_tim = " + "'Varadero'"
					+ "OR eidos2_tim = " + "'Cachaca'"
					+ "OR eidos2_tim = " + "'Zacapa'"
					+ "OR eidos3_tim = " + "'Bacardi 0,7'"
					+ "OR eidos3_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos3_tim = " + "'Havana λευκή'"
					+ "OR eidos3_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos3_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos3_tim = " + "'Havana 7'" + "OR eidos3_tim = "
					+ "'CT Morgan'" + "OR eidos3_tim = " + "'Pampero λευκό'"
					+ "OR eidos3_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos3_tim = " + "'Varadero'"
					+ "OR eidos3_tim = " + "'Cachaca'"
					+ "OR eidos3_tim = " + "'Zacapa'"
					+ "OR eidos4_tim = " + "'Bacardi 0,7'"
					+ "OR eidos4_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos4_tim = " + "'Havana λευκή'"
					+ "OR eidos4_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos4_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos4_tim = " + "'Havana 7'" + "OR eidos4_tim = "
					+ "'CT Morgan'" + "OR eidos4_tim = " + "'Pampero λευκό'"
					+ "OR eidos4_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos4_tim = " + "'Varadero'"
					+ "OR eidos4_tim = " + "'Cachaca'"
					+ "OR eidos4_tim = " + "'Zacapa'"
					+ "OR eidos5_tim = " + "'Bacardi 0,7'"
					+ "OR eidos5_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos5_tim = " + "'Havana λευκή'"
					+ "OR eidos5_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos5_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos5_tim = " + "'Havana 7'" + "OR eidos5_tim = "
					+ "'CT Morgan'" + "OR eidos5_tim = " + "'Pampero λευκό'"
					+ "OR eidos5_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos5_tim = " + "'Varadero'"
					+ "OR eidos5_tim = " + "'Cachaca'"
					+ "OR eidos5_tim = " + "'Zacapa'"
					+ "OR eidos6_tim = " + "'Bacardi 0,7'"
					+ "OR eidos6_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos6_tim = " + "'Havana λευκή'"
					+ "OR eidos6_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos6_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos6_tim = " + "'Havana 7'" + "OR eidos6_tim = "
					+ "'CT Morgan'" + "OR eidos6_tim = " + "'Pampero λευκό'"
					+ "OR eidos6_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos6_tim = " + "'Varadero'"
					+ "OR eidos6_tim = " + "'Cachaca'"
					+ "OR eidos6_tim = " + "'Zacapa'"
					+ "OR eidos7_tim = " + "'Bacardi 0,7'"
					+ "OR eidos7_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos7_tim = " + "'Havana λευκή'"
					+ "OR eidos7_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos7_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos7_tim = " + "'Havana 7'" + "OR eidos7_tim = "
					+ "'CT Morgan'" + "OR eidos7_tim = " + "'Pampero λευκό'"
					+ "OR eidos7_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos7_tim = " + "'Varadero'"
					+ "OR eidos7_tim = " + "'Cachaca'"
					+ "OR eidos7_tim = " + "'Zacapa'"
					+ "OR eidos8_tim = " + "'Bacardi 0,7'"
					+ "OR eidos8_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos8_tim = " + "'Havana λευκή'"
					+ "OR eidos8_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos8_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos8_tim = " + "'Havana 7'" + "OR eidos8_tim = "
					+ "'CT Morgan'" + "OR eidos8_tim = " + "'Pampero λευκό'"
					+ "OR eidos8_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos8_tim = " + "'Varadero'"
					+ "OR eidos8_tim = " + "'Cachaca'"
					+ "OR eidos8_tim = " + "'Zacapa'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting COGNAQ DETAILS
	public ArrayList<Timologia> Get_CognaqDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Metaxa 5'" + "OR eidos1_tim = " + "'Metaxa 7'"
					+ "OR eidos1_tim = " + "'Courvoisier'" 
					+ "OR eidos1_tim = " + "'Benedictine'"
					+ "OR eidos1_tim = " + "'Remi Martin'"
					+ "OR eidos1_tim = " + "'Hennessy xo'"
					+ "OR eidos1_tim = " + "'Hennessy vsop'"
					+ "OR eidos1_tim = " + "'Martel vs'"
					+ "OR eidos1_tim = " + "'Armagnac'"
					+ "OR eidos1_tim = " + "'Calvados'"
					+ "OR eidos2_tim = " + "'Metaxa 5'"
					+ "OR eidos2_tim = " + "'Metaxa 7'"
					+ "OR eidos2_tim = " + "'Courvoisier'" 
					+ "OR eidos2_tim = " + "'Benedictine'"
					+ "OR eidos2_tim = " + "'Remi Martin'"
					+ "OR eidos2_tim = " + "'Hennessy xo'"
					+ "OR eidos2_tim = " + "'Hennessy vsop'"
					+ "OR eidos2_tim = " + "'Martel vs'"
					+ "OR eidos2_tim = " + "'Armagnac'"
					+ "OR eidos2_tim = " + "'Calvados'"
					+ "OR eidos3_tim = " + "'Metaxa 5'"
					+ "OR eidos3_tim = " + "'Metaxa 7'"
					+ "OR eidos3_tim = " + "'Courvoisier'" 
					+ "OR eidos3_tim = " + "'Benedictine'"
					+ "OR eidos3_tim = " + "'Remi Martin'"
					+ "OR eidos3_tim = " + "'Hennessy xo'"
					+ "OR eidos3_tim = " + "'Hennessy vsop'"
					+ "OR eidos3_tim = " + "'Martel vs'"
					+ "OR eidos3_tim = " + "'Armagnac'"
					+ "OR eidos3_tim = " + "'Calvados'"
					+ "OR eidos4_tim = " + "'Metaxa 5'"
					+ "OR eidos4_tim = " + "'Metaxa 7'"
					+ "OR eidos4_tim = " + "'Courvoisier'" 
					+ "OR eidos4_tim = " + "'Benedictine'"
					+ "OR eidos4_tim = " + "'Remi Martin'"
					+ "OR eidos4_tim = " + "'Hennessy xo'"
					+ "OR eidos4_tim = " + "'Hennessy vsop'"
					+ "OR eidos4_tim = " + "'Martel vs'"
					+ "OR eidos4_tim = " + "'Armagnac'"
					+ "OR eidos4_tim = " + "'Calvados'"
					+ "OR eidos5_tim = " + "'Metaxa 5'"
					+ "OR eidos5_tim = " + "'Metaxa 7'"
					+ "OR eidos5_tim = " + "'Courvoisier'" 
					+ "OR eidos5_tim = " + "'Benedictine'"
					+ "OR eidos5_tim = " + "'Remi Martin'"
					+ "OR eidos5_tim = " + "'Hennessy xo'"
					+ "OR eidos5_tim = " + "'Hennessy vsop'"
					+ "OR eidos5_tim = " + "'Martel vs'"
					+ "OR eidos5_tim = " + "'Armagnac'"
					+ "OR eidos5_tim = " + "'Calvados'"
					+ "OR eidos6_tim = " + "'Metaxa 5'"
					+ "OR eidos6_tim = " + "'Metaxa 7'"
					+ "OR eidos6_tim = " + "'Courvoisier'" 
					+ "OR eidos6_tim = " + "'Benedictine'"
					+ "OR eidos6_tim = " + "'Remi Martin'"
					+ "OR eidos6_tim = " + "'Hennessy xo'"
					+ "OR eidos6_tim = " + "'Hennessy vsop'"
					+ "OR eidos6_tim = " + "'Martel vs'"
					+ "OR eidos6_tim = " + "'Armagnac'"
					+ "OR eidos6_tim = " + "'Calvados'"
					+ "OR eidos7_tim = " + "'Metaxa 5'"
					+ "OR eidos7_tim = " + "'Metaxa 7'"
					+ "OR eidos7_tim = " + "'Courvoisier'" 
					+ "OR eidos7_tim = " + "'Benedictine'"
					+ "OR eidos7_tim = " + "'Remi Martin'"
					+ "OR eidos7_tim = " + "'Hennessy xo'"
					+ "OR eidos7_tim = " + "'Hennessy vsop'"
					+ "OR eidos7_tim = " + "'Martel vs'"
					+ "OR eidos7_tim = " + "'Armagnac'"
					+ "OR eidos7_tim = " + "'Calvados'"
					+ "OR eidos8_tim = " + "'Metaxa 5'"
					+ "OR eidos8_tim = " + "'Metaxa 7'"
					+ "OR eidos8_tim = " + "'Courvoisier'" 
					+ "OR eidos8_tim = " + "'Benedictine'"
					+ "OR eidos8_tim = " + "'Remi Martin'"
					+ "OR eidos8_tim = " + "'Hennessy xo'"
					+ "OR eidos8_tim = " + "'Hennessy vsop'"
					+ "OR eidos8_tim = " + "'Martel vs'"
					+ "OR eidos8_tim = " + "'Armagnac'"
					+ "OR eidos8_tim = " + "'Calvados'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting LIKER DETAILS
	public ArrayList<Timologia> Get_LikerDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Pimms'" + "OR eidos1_tim = " + "'Kahlua'"
					+ "OR eidos1_tim = " + "'Heering'"
					+ "OR eidos1_tim = " + "'Grand marnier'"
					+ "OR eidos1_tim = " + "'Tia maria'"
					+ "OR eidos1_tim = " + "'Aperol'"
					+ "OR eidos1_tim = " + "'Jagermeister'"
					+ "OR eidos1_tim = " + "'Skinos Mastiha'"
					+ "OR eidos1_tim = " + "'Limoncelo'"
					+ "OR eidos1_tim = " + "'Menta'"
					+ "OR eidos1_tim = " + "'Fernet'"
					+ "OR eidos1_tim = " + "'Batida'"
					+ "OR eidos1_tim = " + "'Passoa'"
					+ "OR eidos1_tim = " + "'Pisang'"
					+ "OR eidos1_tim = " + "'Blue Curacao'"
					+ "OR eidos1_tim = " + "'Malibu'"
					+ "OR eidos1_tim = " + "'Lime'"
					+ "OR eidos1_tim = " + "'Grenandine'"
					+ "OR eidos1_tim = " + "'Amareto'"
					+ "OR eidos1_tim = " + "'Grandberry'"
					+ "OR eidos1_tim = " + "'Baileys'"
					+ "OR eidos1_tim = " + "'Drambuie'"
					+ "OR eidos1_tim = " + "'Frangelico'"
					+ "OR eidos1_tim = " + "'Campari'"
					+ "OR eidos1_tim = " + "'Martini'"
					+ "OR eidos1_tim = " + "'Martini rosato'"
					+ "OR eidos1_tim = " + "'Martini dry'"
					+ "OR eidos1_tim = " + "'Sambucha kef'"
					+ "OR eidos1_tim = " + "'Sambucha black'"
					+ "OR eidos1_tim = " + "'Cointreau'"
					+ "OR eidos1_tim = " + "'Gordons Space'"
					+ "OR eidos1_tim = " + "'Red Bull'"
					+ "OR eidos1_tim = " + "'Shark'"
					+ "OR eidos1_tim = " + "'ice'"
					+ "OR eidos1_tim = " + "'breezer'"
					+ "OR eidos2_tim = " + "'Pimms'"
					+ "OR eidos2_tim = " + "'Kahlua'"
					+ "OR eidos2_tim = " + "'Heering'"
					+ "OR eidos2_tim = " + "'Grand marnier'"
					+ "OR eidos2_tim = " + "'Tia maria'"
					+ "OR eidos2_tim = " + "'Aperol'"
					+ "OR eidos2_tim = " + "'Jagermeister'"
					+ "OR eidos2_tim = " + "'Skinos Mastiha'"
					+ "OR eidos2_tim = " + "'Limoncelo'"
					+ "OR eidos2_tim = " + "'Menta'"
					+ "OR eidos2_tim = " + "'Fernet'"
					+ "OR eidos2_tim = " + "'Batida'"
					+ "OR eidos2_tim = " + "'Passoa'"
					+ "OR eidos2_tim = " + "'Pisang'"
					+ "OR eidos2_tim = " + "'Blue Curacao'"
					+ "OR eidos2_tim = " + "'Malibu'"
					+ "OR eidos2_tim = " + "'Lime'"
					+ "OR eidos2_tim = " + "'Grenandine'"
					+ "OR eidos2_tim = " + "'Amareto'"
					+ "OR eidos2_tim = " + "'Grandberry'"
					+ "OR eidos2_tim = " + "'Baileys'"
					+ "OR eidos2_tim = " + "'Drambuie'"
					+ "OR eidos2_tim = " + "'Frangelico'"
					+ "OR eidos2_tim = " + "'Campari'"
					+ "OR eidos2_tim = " + "'Martini'"
					+ "OR eidos2_tim = " + "'Martini rosato'"
					+ "OR eidos2_tim = " + "'Martini dry'"
					+ "OR eidos2_tim = " + "'Sambucha kef'"
					+ "OR eidos2_tim = " + "'Sambucha black'"
					+ "OR eidos2_tim = " + "'Cointreau'"
					+ "OR eidos2_tim = " + "'Gordons Space'"
					+ "OR eidos2_tim = " + "'Red Bull'"
					+ "OR eidos2_tim = " + "'Shark'"
					+ "OR eidos2_tim = " + "'ice'"
					+ "OR eidos2_tim = " + "'breezer'"
					+ "OR eidos3_tim = " + "'Pimms'"
					+ "OR eidos3_tim = " + "'Kahlua'"
					+ "OR eidos3_tim = " + "'Heering'"
					+ "OR eidos3_tim = " + "'Grand marnier'"
					+ "OR eidos3_tim = " + "'Tia maria'"
					+ "OR eidos3_tim = " + "'Aperol'"
					+ "OR eidos3_tim = " + "'Jagermeister'"
					+ "OR eidos3_tim = " + "'Skinos Mastiha'"
					+ "OR eidos3_tim = " + "'Limoncelo'"
					+ "OR eidos3_tim = " + "'Menta'"
					+ "OR eidos3_tim = " + "'Fernet'"
					+ "OR eidos3_tim = " + "'Batida'"
					+ "OR eidos3_tim = " + "'Passoa'"
					+ "OR eidos3_tim = " + "'Pisang'"
					+ "OR eidos3_tim = " + "'Blue Curacao'"
					+ "OR eidos3_tim = " + "'Malibu'"
					+ "OR eidos3_tim = " + "'Lime'"
					+ "OR eidos3_tim = " + "'Grenandine'"
					+ "OR eidos3_tim = " + "'Amareto'"
					+ "OR eidos3_tim = " + "'Grandberry'"
					+ "OR eidos3_tim = " + "'Baileys'"
					+ "OR eidos3_tim = " + "'Drambuie'"
					+ "OR eidos3_tim = " + "'Frangelico'"
					+ "OR eidos3_tim = " + "'Campari'"
					+ "OR eidos3_tim = " + "'Martini'"
					+ "OR eidos3_tim = " + "'Martini rosato'"
					+ "OR eidos3_tim = " + "'Martini dry'"
					+ "OR eidos3_tim = " + "'Sambucha kef'"
					+ "OR eidos3_tim = " + "'Sambucha black'"
					+ "OR eidos3_tim = " + "'Cointreau'"
					+ "OR eidos3_tim = " + "'Gordons Space'"
					+ "OR eidos3_tim = " + "'Red Bull'"
					+ "OR eidos3_tim = " + "'Shark'"
					+ "OR eidos3_tim = " + "'ice'"
					+ "OR eidos3_tim = " + "'breezer'"
					+ "OR eidos4_tim = " + "'Pimms'"
					+ "OR eidos4_tim = " + "'Kahlua'"
					+ "OR eidos4_tim = " + "'Heering'"
					+ "OR eidos4_tim = " + "'Grand marnier'"
					+ "OR eidos4_tim = " + "'Tia maria'"
					+ "OR eidos4_tim = " + "'Aperol'"
					+ "OR eidos4_tim = " + "'Jagermeister'"
					+ "OR eidos4_tim = " + "'Skinos Mastiha'"
					+ "OR eidos4_tim = " + "'Limoncelo'"
					+ "OR eidos4_tim = " + "'Menta'"
					+ "OR eidos4_tim = " + "'Fernet'"
					+ "OR eidos4_tim = " + "'Batida'"
					+ "OR eidos4_tim = " + "'Passoa'"
					+ "OR eidos4_tim = " + "'Pisang'"
					+ "OR eidos4_tim = " + "'Blue Curacao'"
					+ "OR eidos4_tim = " + "'Malibu'"
					+ "OR eidos4_tim = " + "'Lime'"
					+ "OR eidos4_tim = " + "'Grenandine'"
					+ "OR eidos4_tim = " + "'Amareto'"
					+ "OR eidos4_tim = " + "'Grandberry'"
					+ "OR eidos4_tim = " + "'Baileys'"
					+ "OR eidos4_tim = " + "'Drambuie'"
					+ "OR eidos4_tim = " + "'Frangelico'"
					+ "OR eidos4_tim = " + "'Campari'"
					+ "OR eidos4_tim = " + "'Martini'"
					+ "OR eidos4_tim = " + "'Martini rosato'"
					+ "OR eidos4_tim = " + "'Martini dry'"
					+ "OR eidos4_tim = " + "'Sambucha kef'"
					+ "OR eidos4_tim = " + "'Sambucha black'"
					+ "OR eidos4_tim = " + "'Cointreau'"
					+ "OR eidos4_tim = " + "'Gordons Space'"
					+ "OR eidos4_tim = " + "'Red Bull'"
					+ "OR eidos4_tim = " + "'Shark'"
					+ "OR eidos4_tim = " + "'ice'"
					+ "OR eidos4_tim = " + "'breezer'"
					+ "OR eidos5_tim = " + "'Pimms'"
					+ "OR eidos5_tim = " + "'Kahlua'"
					+ "OR eidos5_tim = " + "'Heering'"
					+ "OR eidos5_tim = " + "'Grand marnier'"
					+ "OR eidos5_tim = " + "'Tia maria'"
					+ "OR eidos5_tim = " + "'Aperol'"
					+ "OR eidos5_tim = " + "'Jagermeister'"
					+ "OR eidos5_tim = " + "'Skinos Mastiha'"
					+ "OR eidos5_tim = " + "'Limoncelo'"
					+ "OR eidos5_tim = " + "'Menta'"
					+ "OR eidos5_tim = " + "'Fernet'"
					+ "OR eidos5_tim = " + "'Batida'"
					+ "OR eidos5_tim = " + "'Passoa'"
					+ "OR eidos5_tim = " + "'Pisang'"
					+ "OR eidos5_tim = " + "'Blue Curacao'"
					+ "OR eidos5_tim = " + "'Malibu'"
					+ "OR eidos5_tim = " + "'Lime'"
					+ "OR eidos5_tim = " + "'Grenandine'"
					+ "OR eidos5_tim = " + "'Amareto'"
					+ "OR eidos5_tim = " + "'Grandberry'"
					+ "OR eidos5_tim = " + "'Baileys'"
					+ "OR eidos5_tim = " + "'Drambuie'"
					+ "OR eidos5_tim = " + "'Frangelico'"
					+ "OR eidos5_tim = " + "'Campari'"
					+ "OR eidos5_tim = " + "'Martini'"
					+ "OR eidos5_tim = " + "'Martini rosato'"
					+ "OR eidos5_tim = " + "'Martini dry'"
					+ "OR eidos5_tim = " + "'Sambucha kef'"
					+ "OR eidos5_tim = " + "'Sambucha black'"
					+ "OR eidos5_tim = " + "'Cointreau'"
					+ "OR eidos5_tim = " + "'Gordons Space'"
					+ "OR eidos5_tim = " + "'Red Bull'"
					+ "OR eidos5_tim = " + "'Shark'"
					+ "OR eidos5_tim = " + "'ice'"
					+ "OR eidos5_tim = " + "'breezer'"
					+ "OR eidos6_tim = " + "'Pimms'"
					+ "OR eidos6_tim = " + "'Kahlua'"
					+ "OR eidos6_tim = " + "'Heering'"
					+ "OR eidos6_tim = " + "'Grand marnier'"
					+ "OR eidos6_tim = " + "'Tia maria'"
					+ "OR eidos6_tim = " + "'Aperol'"
					+ "OR eidos6_tim = " + "'Jagermeister'"
					+ "OR eidos6_tim = " + "'Skinos Mastiha'"
					+ "OR eidos6_tim = " + "'Limoncelo'"
					+ "OR eidos6_tim = " + "'Menta'"
					+ "OR eidos6_tim = " + "'Fernet'"
					+ "OR eidos6_tim = " + "'Batida'"
					+ "OR eidos6_tim = " + "'Passoa'"
					+ "OR eidos6_tim = " + "'Pisang'"
					+ "OR eidos6_tim = " + "'Blue Curacao'"
					+ "OR eidos6_tim = " + "'Malibu'"
					+ "OR eidos6_tim = " + "'Lime'"
					+ "OR eidos6_tim = " + "'Grenandine'"
					+ "OR eidos6_tim = " + "'Amareto'"
					+ "OR eidos6_tim = " + "'Grandberry'"
					+ "OR eidos6_tim = " + "'Baileys'"
					+ "OR eidos6_tim = " + "'Drambuie'"
					+ "OR eidos6_tim = " + "'Frangelico'"
					+ "OR eidos6_tim = " + "'Campari'"
					+ "OR eidos6_tim = " + "'Martini'"
					+ "OR eidos6_tim = " + "'Martini rosato'"
					+ "OR eidos6_tim = " + "'Martini dry'"
					+ "OR eidos6_tim = " + "'Sambucha kef'"
					+ "OR eidos6_tim = " + "'Sambucha black'"
					+ "OR eidos6_tim = " + "'Cointreau'"
					+ "OR eidos6_tim = " + "'Gordons Space'"
					+ "OR eidos6_tim = " + "'Red Bull'"
					+ "OR eidos6_tim = " + "'Shark'"
					+ "OR eidos6_tim = " + "'ice'"
					+ "OR eidos6_tim = " + "'breezer'"
					+ "OR eidos7_tim = " + "'Pimms'"
					+ "OR eidos7_tim = " + "'Kahlua'"
					+ "OR eidos7_tim = " + "'Heering'"
					+ "OR eidos7_tim = " + "'Grand marnier'"
					+ "OR eidos7_tim = " + "'Tia maria'"
					+ "OR eidos7_tim = " + "'Aperol'"
					+ "OR eidos7_tim = " + "'Jagermeister'"
					+ "OR eidos7_tim = " + "'Skinos Mastiha'"
					+ "OR eidos7_tim = " + "'Limoncelo'"
					+ "OR eidos7_tim = " + "'Menta'"
					+ "OR eidos7_tim = " + "'Fernet'"
					+ "OR eidos7_tim = " + "'Batida'"
					+ "OR eidos7_tim = " + "'Passoa'"
					+ "OR eidos7_tim = " + "'Pisang'"
					+ "OR eidos7_tim = " + "'Blue Curacao'"
					+ "OR eidos7_tim = " + "'Malibu'"
					+ "OR eidos7_tim = " + "'Lime'"
					+ "OR eidos7_tim = " + "'Grenandine'"
					+ "OR eidos7_tim = " + "'Amareto'"
					+ "OR eidos7_tim = " + "'Grandberry'"
					+ "OR eidos7_tim = " + "'Baileys'"
					+ "OR eidos7_tim = " + "'Drambuie'"
					+ "OR eidos7_tim = " + "'Frangelico'"
					+ "OR eidos7_tim = " + "'Campari'"
					+ "OR eidos7_tim = " + "'Martini'"
					+ "OR eidos7_tim = " + "'Martini rosato'"
					+ "OR eidos7_tim = " + "'Martini dry'"
					+ "OR eidos7_tim = " + "'Sambucha kef'"
					+ "OR eidos7_tim = " + "'Sambucha black'"
					+ "OR eidos7_tim = " + "'Cointreau'"
					+ "OR eidos7_tim = " + "'Gordons Space'"
					+ "OR eidos7_tim = " + "'Red Bull'"
					+ "OR eidos7_tim = " + "'Shark'"
					+ "OR eidos7_tim = " + "'ice'"
					+ "OR eidos7_tim = " + "'breezer'"
					+ "OR eidos8_tim = " + "'Pimms'"
					+ "OR eidos8_tim = " + "'Kahlua'"
					+ "OR eidos8_tim = " + "'Heering'"
					+ "OR eidos8_tim = " + "'Grand marnier'"
					+ "OR eidos8_tim = " + "'Tia maria'"
					+ "OR eidos8_tim = " + "'Aperol'"
					+ "OR eidos8_tim = " + "'Jagermeister'"
					+ "OR eidos8_tim = " + "'Skinos Mastiha'"
					+ "OR eidos8_tim = " + "'Limoncelo'"
					+ "OR eidos8_tim = " + "'Menta'"
					+ "OR eidos8_tim = " + "'Fernet'"
					+ "OR eidos8_tim = " + "'Batida'"
					+ "OR eidos8_tim = " + "'Passoa'"
					+ "OR eidos8_tim = " + "'Pisang'"
					+ "OR eidos8_tim = " + "'Blue Curacao'"
					+ "OR eidos8_tim = " + "'Malibu'"
					+ "OR eidos8_tim = " + "'Lime'"
					+ "OR eidos8_tim = " + "'Grenandine'"
					+ "OR eidos8_tim = " + "'Amareto'"
					+ "OR eidos8_tim = " + "'Grandberry'"
					+ "OR eidos8_tim = " + "'Baileys'"
					+ "OR eidos8_tim = " + "'Drambuie'"
					+ "OR eidos8_tim = " + "'Frangelico'"
					+ "OR eidos8_tim = " + "'Campari'"
					+ "OR eidos8_tim = " + "'Martini'"
					+ "OR eidos8_tim = " + "'Martini rosato'"
					+ "OR eidos8_tim = " + "'Martini dry'"
					+ "OR eidos8_tim = " + "'Sambucha kef'"
					+ "OR eidos8_tim = " + "'Sambucha black'"
					+ "OR eidos8_tim = " + "'Cointreau'"
					+ "OR eidos8_tim = " + "'Gordons Space'"
					+ "OR eidos8_tim = " + "'Red Bull'"
					+ "OR eidos8_tim = " + "'Shark'"
					+ "OR eidos8_tim = " + "'ice'"
					+ "OR eidos8_tim = " + "'breezer'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting YLIKA DETAILS
	public ArrayList<Timologia> Get_YlikaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Χ.Κουζίνας'" + "OR eidos1_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos1_tim = " + "'Βετέξ'" + "OR eidos1_tim = "
					+ "'Σφουγγάρια'" + "OR eidos1_tim = " + "'Γάντια'"
					+ "OR eidos1_tim = " + "'Οδοντογλυφ.'" + "OR eidos1_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos1_tim = " + "'Κοντάρι'"
					+ "OR eidos1_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos1_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos1_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos1_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos1_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos1_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos1_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos1_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos1_tim = " + "'Υγρό ίνοξ'" + "OR eidos1_tim = "
					+ "'Υγρό λίπη'" + "OR eidos1_tim = " + "'Οινόπνευμα'"
					+ "OR eidos1_tim = " + "'Αναδευτήρες'" + "OR eidos1_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos1_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos1_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos1_tim = " + "'Χλωρίνη'"
					+ "OR eidos1_tim = " + "'Σύρμα'" + "OR eidos1_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos1_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos1_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos1_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos1_tim = " + "'πακέτα delivery'"
					+ "OR eidos1_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos1_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos1_tim = " + "'στεγνωτικό'" + "OR eidos1_tim = "
					+ "'στεγνωτικό'" + "OR eidos1_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos1_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos1_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos1_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos1_tim = " + "'αποσμυτικά'"
					+ "OR eidos1_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos1_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos2_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos2_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos2_tim = " + "'Βετέξ'" + "OR eidos2_tim = "
					+ "'Σφουγγάρια'" + "OR eidos2_tim = " + "'Γάντια'"
					+ "OR eidos2_tim = " + "'Οδοντογλυφ.'" + "OR eidos2_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos2_tim = " + "'Κοντάρι'"
					+ "OR eidos2_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos2_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos2_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos2_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos2_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos2_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos2_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos2_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos2_tim = " + "'Υγρό ίνοξ'" + "OR eidos2_tim = "
					+ "'Υγρό λίπη'" + "OR eidos2_tim = " + "'Οινόπνευμα'"
					+ "OR eidos2_tim = " + "'Αναδευτήρες'" + "OR eidos2_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos2_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos2_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos2_tim = " + "'Χλωρίνη'"
					+ "OR eidos2_tim = " + "'Σύρμα'" + "OR eidos2_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos2_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos2_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos2_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos2_tim = " + "'πακέτα delivery'"
					+ "OR eidos2_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos2_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos2_tim = " + "'στεγνωτικό'" + "OR eidos2_tim = "
					+ "'στεγνωτικό'" + "OR eidos2_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos2_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos2_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos2_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos2_tim = " + "'αποσμυτικά'"
					+ "OR eidos2_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos2_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos3_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos3_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos3_tim = " + "'Βετέξ'" + "OR eidos3_tim = "
					+ "'Σφουγγάρια'" + "OR eidos3_tim = " + "'Γάντια'"
					+ "OR eidos3_tim = " + "'Οδοντογλυφ.'" + "OR eidos3_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos3_tim = " + "'Κοντάρι'"
					+ "OR eidos3_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos3_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos3_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos3_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos3_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos3_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos3_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos3_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos3_tim = " + "'Υγρό ίνοξ'" + "OR eidos3_tim = "
					+ "'Υγρό λίπη'" + "OR eidos3_tim = " + "'Οινόπνευμα'"
					+ "OR eidos3_tim = " + "'Αναδευτήρες'" + "OR eidos3_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos3_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos3_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos3_tim = " + "'Χλωρίνη'"
					+ "OR eidos3_tim = " + "'Σύρμα'" + "OR eidos3_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos3_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos3_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos3_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos3_tim = " + "'πακέτα delivery'"
					+ "OR eidos3_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos3_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos3_tim = " + "'στεγνωτικό'" + "OR eidos3_tim = "
					+ "'στεγνωτικό'" + "OR eidos3_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos3_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos3_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos3_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos3_tim = " + "'αποσμυτικά'"
					+ "OR eidos3_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos3_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos4_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos4_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos4_tim = " + "'Βετέξ'" + "OR eidos4_tim = "
					+ "'Σφουγγάρια'" + "OR eidos4_tim = " + "'Γάντια'"
					+ "OR eidos4_tim = " + "'Οδοντογλυφ.'" + "OR eidos4_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos4_tim = " + "'Κοντάρι'"
					+ "OR eidos4_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos4_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos4_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos4_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos4_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos4_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos4_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos4_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos4_tim = " + "'Υγρό ίνοξ'" + "OR eidos4_tim = "
					+ "'Υγρό λίπη'" + "OR eidos4_tim = " + "'Οινόπνευμα'"
					+ "OR eidos4_tim = " + "'Αναδευτήρες'" + "OR eidos4_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos4_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos4_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos4_tim = " + "'Χλωρίνη'"
					+ "OR eidos4_tim = " + "'Σύρμα'" + "OR eidos4_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos4_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos4_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos4_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos4_tim = " + "'πακέτα delivery'"
					+ "OR eidos4_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos4_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos4_tim = " + "'στεγνωτικό'" + "OR eidos4_tim = "
					+ "'στεγνωτικό'" + "OR eidos4_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos4_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos4_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos4_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos4_tim = " + "'αποσμυτικά'"
					+ "OR eidos4_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos4_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos5_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos5_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos5_tim = " + "'Βετέξ'" + "OR eidos5_tim = "
					+ "'Σφουγγάρια'" + "OR eidos5_tim = " + "'Γάντια'"
					+ "OR eidos5_tim = " + "'Οδοντογλυφ.'" + "OR eidos5_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos5_tim = " + "'Κοντάρι'"
					+ "OR eidos5_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos5_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos5_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos5_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos5_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos5_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos5_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos5_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos5_tim = " + "'Υγρό ίνοξ'" + "OR eidos5_tim = "
					+ "'Υγρό λίπη'" + "OR eidos5_tim = " + "'Οινόπνευμα'"
					+ "OR eidos5_tim = " + "'Αναδευτήρες'" + "OR eidos5_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos5_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos5_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos5_tim = " + "'Χλωρίνη'"
					+ "OR eidos5_tim = " + "'Σύρμα'" + "OR eidos5_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos5_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos5_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos5_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos5_tim = " + "'πακέτα delivery'"
					+ "OR eidos5_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos5_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos5_tim = " + "'στεγνωτικό'" + "OR eidos5_tim = "
					+ "'στεγνωτικό'" + "OR eidos5_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos5_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos5_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos5_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos5_tim = " + "'αποσμυτικά'"
					+ "OR eidos5_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos5_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos6_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos6_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos6_tim = " + "'Βετέξ'" + "OR eidos6_tim = "
					+ "'Σφουγγάρια'" + "OR eidos6_tim = " + "'Γάντια'"
					+ "OR eidos6_tim = " + "'Οδοντογλυφ.'" + "OR eidos6_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos6_tim = " + "'Κοντάρι'"
					+ "OR eidos6_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos6_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos6_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos6_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos6_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos6_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos6_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos6_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos6_tim = " + "'Υγρό ίνοξ'" + "OR eidos6_tim = "
					+ "'Υγρό λίπη'" + "OR eidos6_tim = " + "'Οινόπνευμα'"
					+ "OR eidos6_tim = " + "'Αναδευτήρες'" + "OR eidos6_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos6_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos6_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos6_tim = " + "'Χλωρίνη'"
					+ "OR eidos6_tim = " + "'Σύρμα'" + "OR eidos6_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos6_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos6_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos6_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos6_tim = " + "'πακέτα delivery'"
					+ "OR eidos6_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos6_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos6_tim = " + "'στεγνωτικό'" + "OR eidos6_tim = "
					+ "'στεγνωτικό'" + "OR eidos6_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos6_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos6_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos6_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos6_tim = " + "'αποσμυτικά'"
					+ "OR eidos6_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos6_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos7_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos7_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos7_tim = " + "'Βετέξ'" + "OR eidos7_tim = "
					+ "'Σφουγγάρια'" + "OR eidos7_tim = " + "'Γάντια'"
					+ "OR eidos7_tim = " + "'Οδοντογλυφ.'" + "OR eidos7_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos7_tim = " + "'Κοντάρι'"
					+ "OR eidos7_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos7_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos7_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos7_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos7_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos7_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos7_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos7_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos7_tim = " + "'Υγρό ίνοξ'" + "OR eidos7_tim = "
					+ "'Υγρό λίπη'" + "OR eidos7_tim = " + "'Οινόπνευμα'"
					+ "OR eidos7_tim = " + "'Αναδευτήρες'" + "OR eidos7_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos7_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos7_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos7_tim = " + "'Χλωρίνη'"
					+ "OR eidos7_tim = " + "'Σύρμα'" + "OR eidos7_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos7_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos7_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos7_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos7_tim = " + "'πακέτα delivery'"
					+ "OR eidos7_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos7_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos7_tim = " + "'στεγνωτικό'" + "OR eidos7_tim = "
					+ "'στεγνωτικό'" + "OR eidos7_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos7_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos7_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos7_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos7_tim = " + "'αποσμυτικά'"
					+ "OR eidos7_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos7_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos8_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos8_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos8_tim = " + "'Βετέξ'" + "OR eidos8_tim = "
					+ "'Σφουγγάρια'" + "OR eidos8_tim = " + "'Γάντια'"
					+ "OR eidos8_tim = " + "'Οδοντογλυφ.'" + "OR eidos8_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos8_tim = " + "'Κοντάρι'"
					+ "OR eidos8_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos8_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos8_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos8_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos8_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos8_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos8_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos8_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos8_tim = " + "'Υγρό ίνοξ'" + "OR eidos8_tim = "
					+ "'Υγρό λίπη'" + "OR eidos8_tim = " + "'Οινόπνευμα'"
					+ "OR eidos8_tim = " + "'Αναδευτήρες'" + "OR eidos8_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos8_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos8_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos8_tim = " + "'Χλωρίνη'"
					+ "OR eidos8_tim = " + "'Σύρμα'" + "OR eidos8_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos8_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos8_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos8_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos8_tim = " + "'πακέτα delivery'"
					+ "OR eidos8_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos8_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos8_tim = " + "'στεγνωτικό'" + "OR eidos8_tim = "
					+ "'στεγνωτικό'" + "OR eidos8_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos8_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos8_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos8_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos8_tim = " + "'αποσμυτικά'"
					+ "OR eidos8_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos8_tim = " + "'χαρτιά παραγγελιών'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting FROUTA_LAX DETAILS
	public ArrayList<Timologia> Get_Frouta_laxDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'Ρόκα'" + "OR eidos1_tim = " + "'Μεσκλάν'"
					+ "OR eidos1_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos1_tim = " + "'Λολό ρόσσο'" + "OR eidos1_tim = "
					+ "'Ντομάτες'" + "OR eidos1_tim = " + "'Ντοματίνια'"
					+ "OR eidos1_tim = " + "'Πατάτες'" + "OR eidos1_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos1_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos1_tim = " + "'Μελιτζάνες'" + "OR eidos1_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos1_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos1_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos1_tim = "
					+ "'Αγγούρια'" + "OR eidos1_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos1_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos1_tim = " + "'Πατάτες baby'"
					+ "OR eidos1_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos1_tim = " + "'Βασιλικός'" + "OR eidos1_tim = "
					+ "'Δυόσμος'" + "OR eidos1_tim = " + "'Μαϊντανός'"
					+ "OR eidos1_tim = " + "'Σκοινόπρασο'" + "OR eidos1_tim = "
					+ "'Άνηθος'" + "OR eidos1_tim = " + "'Θυμάρι'"
					+ "OR eidos1_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos1_tim = " + "'Σκόρδο'" + "OR eidos1_tim = "
					+ "'Σπανάκι'" + "OR eidos1_tim = " + "'Μπρόκολο'"
					+ "OR eidos1_tim = " + "'Κουνουπίδι'" + "OR eidos1_tim = "
					+ "'Iceberg'" + "OR eidos1_tim = " + "'Πορτοκάλια'"
					+ "OR eidos1_tim = " + "'Λεμόνια'" + "OR eidos1_tim = "
					+ "'Καρότα'" + "OR eidos1_tim = " + "'Μήλα'"
					+ "OR eidos1_tim = " + "'Ελιές'" + "OR eidos1_tim = "
					+ "'Ακτινίδια'" + "OR eidos1_tim = " + "'Αχλάδια'"
					+ "OR eidos1_tim = " + "'Φράουλες'" + "OR eidos1_tim = "
					+ "'Πεπόνι'" + "OR eidos1_tim = " + "'Καρπούζι'"
					+ "OR eidos1_tim = " + "'Κεράσια'" + "OR eidos1_tim = "
					+ "'Μπανάνες'" + "OR eidos1_tim = " + "'Νεκταρίνια'"
					+ "OR eidos1_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos1_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos1_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos2_tim = " + "'Ρόκα'" + "OR eidos2_tim = "
					+ "'Μεσκλάν'" + "OR eidos2_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos2_tim = " + "'Λολό ρόσσο'" + "OR eidos2_tim = "
					+ "'Ντομάτες'" + "OR eidos2_tim = " + "'Ντοματίνια'"
					+ "OR eidos2_tim = " + "'Πατάτες'" + "OR eidos2_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos2_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos2_tim = " + "'Μελιτζάνες'" + "OR eidos2_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos2_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos2_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos2_tim = "
					+ "'Αγγούρια'" + "OR eidos2_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos2_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos2_tim = " + "'Πατάτες baby'"
					+ "OR eidos2_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos2_tim = " + "'Βασιλικός'" + "OR eidos2_tim = "
					+ "'Δυόσμος'" + "OR eidos2_tim = " + "'Μαϊντανός'"
					+ "OR eidos2_tim = " + "'Σκοινόπρασο'" + "OR eidos2_tim = "
					+ "'Άνηθος'" + "OR eidos2_tim = " + "'Θυμάρι'"
					+ "OR eidos2_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos2_tim = " + "'Σκόρδο'" + "OR eidos2_tim = "
					+ "'Σπανάκι'" + "OR eidos2_tim = " + "'Μπρόκολο'"
					+ "OR eidos2_tim = " + "'Κουνουπίδι'" + "OR eidos2_tim = "
					+ "'Iceberg'" + "OR eidos2_tim = " + "'Πορτοκάλια'"
					+ "OR eidos2_tim = " + "'Λεμόνια'" + "OR eidos2_tim = "
					+ "'Καρότα'" + "OR eidos2_tim = " + "'Μήλα'"
					+ "OR eidos2_tim = " + "'Ελιές'" + "OR eidos2_tim = "
					+ "'Ακτινίδια'" + "OR eidos2_tim = " + "'Αχλάδια'"
					+ "OR eidos2_tim = " + "'Φράουλες'" + "OR eidos2_tim = "
					+ "'Πεπόνι'" + "OR eidos2_tim = " + "'Καρπούζι'"
					+ "OR eidos2_tim = " + "'Κεράσια'" + "OR eidos2_tim = "
					+ "'Μπανάνες'" + "OR eidos2_tim = " + "'Νεκταρίνια'"
					+ "OR eidos2_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos2_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos2_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos3_tim = " + "'Ρόκα'" + "OR eidos3_tim = "
					+ "'Μεσκλάν'" + "OR eidos3_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos3_tim = " + "'Λολό ρόσσο'" + "OR eidos3_tim = "
					+ "'Ντομάτες'" + "OR eidos3_tim = " + "'Ντοματίνια'"
					+ "OR eidos3_tim = " + "'Πατάτες'" + "OR eidos3_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos3_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos3_tim = " + "'Μελιτζάνες'" + "OR eidos3_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos3_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos3_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos3_tim = "
					+ "'Αγγούρια'" + "OR eidos3_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos3_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos3_tim = " + "'Πατάτες baby'"
					+ "OR eidos3_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos3_tim = " + "'Βασιλικός'" + "OR eidos3_tim = "
					+ "'Δυόσμος'" + "OR eidos3_tim = " + "'Μαϊντανός'"
					+ "OR eidos3_tim = " + "'Σκοινόπρασο'" + "OR eidos3_tim = "
					+ "'Άνηθος'" + "OR eidos3_tim = " + "'Θυμάρι'"
					+ "OR eidos3_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos3_tim = " + "'Σκόρδο'" + "OR eidos3_tim = "
					+ "'Σπανάκι'" + "OR eidos3_tim = " + "'Μπρόκολο'"
					+ "OR eidos3_tim = " + "'Κουνουπίδι'" + "OR eidos3_tim = "
					+ "'Iceberg'" + "OR eidos3_tim = " + "'Πορτοκάλια'"
					+ "OR eidos3_tim = " + "'Λεμόνια'" + "OR eidos3_tim = "
					+ "'Καρότα'" + "OR eidos3_tim = " + "'Μήλα'"
					+ "OR eidos3_tim = " + "'Ελιές'" + "OR eidos3_tim = "
					+ "'Ακτινίδια'" + "OR eidos3_tim = " + "'Αχλάδια'"
					+ "OR eidos3_tim = " + "'Φράουλες'" + "OR eidos3_tim = "
					+ "'Πεπόνι'" + "OR eidos3_tim = " + "'Καρπούζι'"
					+ "OR eidos3_tim = " + "'Κεράσια'" + "OR eidos3_tim = "
					+ "'Μπανάνες'" + "OR eidos3_tim = " + "'Νεκταρίνια'"
					+ "OR eidos3_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos3_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos3_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos4_tim = " + "'Ρόκα'" + "OR eidos4_tim = "
					+ "'Μεσκλάν'" + "OR eidos4_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos4_tim = " + "'Λολό ρόσσο'" + "OR eidos4_tim = "
					+ "'Ντομάτες'" + "OR eidos4_tim = " + "'Ντοματίνια'"
					+ "OR eidos4_tim = " + "'Πατάτες'" + "OR eidos4_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos4_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos4_tim = " + "'Μελιτζάνες'" + "OR eidos4_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos4_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos4_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos4_tim = "
					+ "'Αγγούρια'" + "OR eidos4_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos4_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos4_tim = " + "'Πατάτες baby'"
					+ "OR eidos4_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos4_tim = " + "'Βασιλικός'" + "OR eidos4_tim = "
					+ "'Δυόσμος'" + "OR eidos4_tim = " + "'Μαϊντανός'"
					+ "OR eidos4_tim = " + "'Σκοινόπρασο'" + "OR eidos4_tim = "
					+ "'Άνηθος'" + "OR eidos4_tim = " + "'Θυμάρι'"
					+ "OR eidos4_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos4_tim = " + "'Σκόρδο'" + "OR eidos4_tim = "
					+ "'Σπανάκι'" + "OR eidos4_tim = " + "'Μπρόκολο'"
					+ "OR eidos4_tim = " + "'Κουνουπίδι'" + "OR eidos4_tim = "
					+ "'Iceberg'" + "OR eidos4_tim = " + "'Πορτοκάλια'"
					+ "OR eidos4_tim = " + "'Λεμόνια'" + "OR eidos4_tim = "
					+ "'Καρότα'" + "OR eidos4_tim = " + "'Μήλα'"
					+ "OR eidos4_tim = " + "'Ελιές'" + "OR eidos4_tim = "
					+ "'Ακτινίδια'" + "OR eidos4_tim = " + "'Αχλάδια'"
					+ "OR eidos4_tim = " + "'Φράουλες'" + "OR eidos4_tim = "
					+ "'Πεπόνι'" + "OR eidos4_tim = " + "'Καρπούζι'"
					+ "OR eidos4_tim = " + "'Κεράσια'" + "OR eidos4_tim = "
					+ "'Μπανάνες'" + "OR eidos4_tim = " + "'Νεκταρίνια'"
					+ "OR eidos4_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos4_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos4_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos5_tim = " + "'Ρόκα'" + "OR eidos5_tim = "
					+ "'Μεσκλάν'" + "OR eidos5_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos5_tim = " + "'Λολό ρόσσο'" + "OR eidos5_tim = "
					+ "'Ντομάτες'" + "OR eidos5_tim = " + "'Ντοματίνια'"
					+ "OR eidos5_tim = " + "'Πατάτες'" + "OR eidos5_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos5_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos5_tim = " + "'Μελιτζάνες'" + "OR eidos5_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos5_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos5_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos5_tim = "
					+ "'Αγγούρια'" + "OR eidos5_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos5_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos5_tim = " + "'Πατάτες baby'"
					+ "OR eidos5_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos5_tim = " + "'Βασιλικός'" + "OR eidos5_tim = "
					+ "'Δυόσμος'" + "OR eidos5_tim = " + "'Μαϊντανός'"
					+ "OR eidos5_tim = " + "'Σκοινόπρασο'" + "OR eidos5_tim = "
					+ "'Άνηθος'" + "OR eidos5_tim = " + "'Θυμάρι'"
					+ "OR eidos5_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos5_tim = " + "'Σκόρδο'" + "OR eidos5_tim = "
					+ "'Σπανάκι'" + "OR eidos5_tim = " + "'Μπρόκολο'"
					+ "OR eidos5_tim = " + "'Κουνουπίδι'" + "OR eidos5_tim = "
					+ "'Iceberg'" + "OR eidos5_tim = " + "'Πορτοκάλια'"
					+ "OR eidos5_tim = " + "'Λεμόνια'" + "OR eidos5_tim = "
					+ "'Καρότα'" + "OR eidos5_tim = " + "'Μήλα'"
					+ "OR eidos5_tim = " + "'Ελιές'" + "OR eidos5_tim = "
					+ "'Ακτινίδια'" + "OR eidos5_tim = " + "'Αχλάδια'"
					+ "OR eidos5_tim = " + "'Φράουλες'" + "OR eidos5_tim = "
					+ "'Πεπόνι'" + "OR eidos5_tim = " + "'Καρπούζι'"
					+ "OR eidos5_tim = " + "'Κεράσια'" + "OR eidos5_tim = "
					+ "'Μπανάνες'" + "OR eidos5_tim = " + "'Νεκταρίνια'"
					+ "OR eidos5_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos5_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos5_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos6_tim = " + "'Ρόκα'" + "OR eidos6_tim = "
					+ "'Μεσκλάν'" + "OR eidos6_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos6_tim = " + "'Λολό ρόσσο'" + "OR eidos6_tim = "
					+ "'Ντομάτες'" + "OR eidos6_tim = " + "'Ντοματίνια'"
					+ "OR eidos6_tim = " + "'Πατάτες'" + "OR eidos6_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos6_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos6_tim = " + "'Μελιτζάνες'" + "OR eidos6_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos6_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos6_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos6_tim = "
					+ "'Αγγούρια'" + "OR eidos6_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos6_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos6_tim = " + "'Πατάτες baby'"
					+ "OR eidos6_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos6_tim = " + "'Βασιλικός'" + "OR eidos6_tim = "
					+ "'Δυόσμος'" + "OR eidos6_tim = " + "'Μαϊντανός'"
					+ "OR eidos6_tim = " + "'Σκοινόπρασο'" + "OR eidos6_tim = "
					+ "'Άνηθος'" + "OR eidos6_tim = " + "'Θυμάρι'"
					+ "OR eidos6_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos6_tim = " + "'Σκόρδο'" + "OR eidos6_tim = "
					+ "'Σπανάκι'" + "OR eidos6_tim = " + "'Μπρόκολο'"
					+ "OR eidos6_tim = " + "'Κουνουπίδι'" + "OR eidos6_tim = "
					+ "'Iceberg'" + "OR eidos6_tim = " + "'Πορτοκάλια'"
					+ "OR eidos6_tim = " + "'Λεμόνια'" + "OR eidos6_tim = "
					+ "'Καρότα'" + "OR eidos6_tim = " + "'Μήλα'"
					+ "OR eidos6_tim = " + "'Ελιές'" + "OR eidos6_tim = "
					+ "'Ακτινίδια'" + "OR eidos6_tim = " + "'Αχλάδια'"
					+ "OR eidos6_tim = " + "'Φράουλες'" + "OR eidos6_tim = "
					+ "'Πεπόνι'" + "OR eidos6_tim = " + "'Καρπούζι'"
					+ "OR eidos6_tim = " + "'Κεράσια'" + "OR eidos6_tim = "
					+ "'Μπανάνες'" + "OR eidos6_tim = " + "'Νεκταρίνια'"
					+ "OR eidos6_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos6_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos6_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos7_tim = " + "'Ρόκα'" + "OR eidos7_tim = "
					+ "'Μεσκλάν'" + "OR eidos7_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos7_tim = " + "'Λολό ρόσσο'" + "OR eidos7_tim = "
					+ "'Ντομάτες'" + "OR eidos7_tim = " + "'Ντοματίνια'"
					+ "OR eidos7_tim = " + "'Πατάτες'" + "OR eidos7_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos7_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos7_tim = " + "'Μελιτζάνες'" + "OR eidos7_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos7_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos7_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos7_tim = "
					+ "'Αγγούρια'" + "OR eidos7_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos7_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos7_tim = " + "'Πατάτες baby'"
					+ "OR eidos7_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos7_tim = " + "'Βασιλικός'" + "OR eidos7_tim = "
					+ "'Δυόσμος'" + "OR eidos7_tim = " + "'Μαϊντανός'"
					+ "OR eidos7_tim = " + "'Σκοινόπρασο'" + "OR eidos7_tim = "
					+ "'Άνηθος'" + "OR eidos7_tim = " + "'Θυμάρι'"
					+ "OR eidos7_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos7_tim = " + "'Σκόρδο'" + "OR eidos7_tim = "
					+ "'Σπανάκι'" + "OR eidos7_tim = " + "'Μπρόκολο'"
					+ "OR eidos7_tim = " + "'Κουνουπίδι'" + "OR eidos7_tim = "
					+ "'Iceberg'" + "OR eidos7_tim = " + "'Πορτοκάλια'"
					+ "OR eidos7_tim = " + "'Λεμόνια'" + "OR eidos7_tim = "
					+ "'Καρότα'" + "OR eidos7_tim = " + "'Μήλα'"
					+ "OR eidos7_tim = " + "'Ελιές'" + "OR eidos7_tim = "
					+ "'Ακτινίδια'" + "OR eidos7_tim = " + "'Αχλάδια'"
					+ "OR eidos7_tim = " + "'Φράουλες'" + "OR eidos7_tim = "
					+ "'Πεπόνι'" + "OR eidos7_tim = " + "'Καρπούζι'"
					+ "OR eidos7_tim = " + "'Κεράσια'" + "OR eidos7_tim = "
					+ "'Μπανάνες'" + "OR eidos7_tim = " + "'Νεκταρίνια'"
					+ "OR eidos7_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos7_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos7_tim = " + "'Λιαστή ντομάτα'"
					+ "OR eidos8_tim = " + "'Ρόκα'" + "OR eidos8_tim = "
					+ "'Μεσκλάν'" + "OR eidos8_tim = " + "'Μαρούλι ίσιο'"
					+ "OR eidos8_tim = " + "'Λολό ρόσσο'" + "OR eidos8_tim = "
					+ "'Ντομάτες'" + "OR eidos8_tim = " + "'Ντοματίνια'"
					+ "OR eidos8_tim = " + "'Πατάτες'" + "OR eidos8_tim = "
					+ "'Πατάτες 10/18'" + "OR eidos8_tim = " + "'Κολοκυθάκια'"
					+ "OR eidos8_tim = " + "'Μελιτζάνες'" + "OR eidos8_tim = "
					+ "'Κρεμμύδι ξερό άσπρο'" + "OR eidos8_tim = "
					+ "'Κρεμμυδάκι φρέσκο'" + "OR eidos8_tim = "
					+ "'Μανιτάρια σαμπινιόν'" + "OR eidos8_tim = "
					+ "'Αγγούρια'" + "OR eidos8_tim = " + "'Πιπεριές φλωρίνης'"
					+ "OR eidos8_tim = " + "'Πιπεριές καυτερές'"
					+ "OR eidos8_tim = " + "'Πατάτες baby'"
					+ "OR eidos8_tim = " + "'Κινέζικο λάχανο'"
					+ "OR eidos8_tim = " + "'Βασιλικός'" + "OR eidos8_tim = "
					+ "'Δυόσμος'" + "OR eidos8_tim = " + "'Μαϊντανός'"
					+ "OR eidos8_tim = " + "'Σκοινόπρασο'" + "OR eidos8_tim = "
					+ "'Άνηθος'" + "OR eidos8_tim = " + "'Θυμάρι'"
					+ "OR eidos8_tim = " + "'Δεντρολίβανο'"
					+ "OR eidos8_tim = " + "'Σκόρδο'" + "OR eidos8_tim = "
					+ "'Σπανάκι'" + "OR eidos8_tim = " + "'Μπρόκολο'"
					+ "OR eidos8_tim = " + "'Κουνουπίδι'" + "OR eidos8_tim = "
					+ "'Iceberg'" + "OR eidos8_tim = " + "'Πορτοκάλια'"
					+ "OR eidos8_tim = " + "'Λεμόνια'" + "OR eidos8_tim = "
					+ "'Καρότα'" + "OR eidos8_tim = " + "'Μήλα'"
					+ "OR eidos8_tim = " + "'Ελιές'" + "OR eidos8_tim = "
					+ "'Ακτινίδια'" + "OR eidos8_tim = " + "'Αχλάδια'"
					+ "OR eidos8_tim = " + "'Φράουλες'" + "OR eidos8_tim = "
					+ "'Πεπόνι'" + "OR eidos8_tim = " + "'Καρπούζι'"
					+ "OR eidos8_tim = " + "'Κεράσια'" + "OR eidos8_tim = "
					+ "'Μπανάνες'" + "OR eidos8_tim = " + "'Νεκταρίνια'"
					+ "OR eidos8_tim = " + "'Ντομάτα κονκασέ'"
					+ "OR eidos8_tim = " + "'Πελτές ντομάτας'"
					+ "OR eidos8_tim = " + "'Λιαστή ντομάτα'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting Kreatika DETAILS
	public ArrayList<Timologia> Get_KreatikaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'ζωμός κότας'" + "OR eidos1_tim = " + "'μπέικον φέτες'"
					+ "OR eidos1_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos1_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos1_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos1_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos1_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos1_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos1_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos1_tim = " + "'ψαρονέφρι'" + "OR eidos1_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos1_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos1_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos1_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos1_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos1_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos2_tim = "
					+ "'ζωμός κότας'" + "OR eidos2_tim = " + "'μπέικον φέτες'"
					+ "OR eidos2_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos2_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos2_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos2_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos2_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos2_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos2_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos2_tim = " + "'ψαρονέφρι'" + "OR eidos2_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos2_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos2_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos2_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos2_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos2_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos3_tim = "
					+ "'ζωμός κότας'" + "OR eidos3_tim = " + "'μπέικον φέτες'"
					+ "OR eidos3_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos3_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos3_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos3_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos3_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos3_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos3_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos3_tim = " + "'ψαρονέφρι'" + "OR eidos3_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos3_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos3_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos3_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos3_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos3_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos4_tim = "
					+ "'ζωμός κότας'" + "OR eidos4_tim = " + "'μπέικον φέτες'"
					+ "OR eidos4_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos4_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos4_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos4_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos4_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos4_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos4_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos4_tim = " + "'ψαρονέφρι'" + "OR eidos4_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos4_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos4_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos4_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos4_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos4_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos5_tim = "
					+ "'ζωμός κότας'" + "OR eidos5_tim = " + "'μπέικον φέτες'"
					+ "OR eidos5_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos5_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos5_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos5_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos5_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos5_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos5_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos5_tim = " + "'ψαρονέφρι'" + "OR eidos5_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos5_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos5_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos5_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos5_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos5_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos6_tim = "
					+ "'ζωμός κότας'" + "OR eidos6_tim = " + "'μπέικον φέτες'"
					+ "OR eidos6_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos6_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos6_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos6_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos6_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos6_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos6_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos6_tim = " + "'ψαρονέφρι'" + "OR eidos6_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos6_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos6_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos6_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos6_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos6_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos7_tim = "
					+ "'ζωμός κότας'" + "OR eidos7_tim = " + "'μπέικον φέτες'"
					+ "OR eidos7_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos7_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos7_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos7_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos7_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos7_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos7_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos7_tim = " + "'ψαρονέφρι'" + "OR eidos7_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos7_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos7_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos7_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos7_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos7_tim = "
					+ "'μοσχαρίσιο rib-eye'" + "OR eidos8_tim = "
					+ "'ζωμός κότας'" + "OR eidos8_tim = " + "'μπέικον φέτες'"
					+ "OR eidos8_tim = " + "'γαλοπούλα φέτες'"
					+ "OR eidos8_tim = " + "'ζαμπόν φέτες'"
					+ "OR eidos8_tim = " + "'λουκάνικα πιπερόνε'"
					+ "OR eidos8_tim = " + "'σαλάμι μπύρας'"
					+ "OR eidos8_tim = " + "'σαλάμι αέρος'"
					+ "OR eidos8_tim = " + "'στήθος κοτόπουλο'"
					+ "OR eidos8_tim = " + "'μπούτι κοτόπουλο'"
					+ "OR eidos8_tim = " + "'ψαρονέφρι'" + "OR eidos8_tim = "
					+ "'χοιρινός λεμός'" + "OR eidos8_tim = "
					+ "'μοσχαρίσιος κυμάς'" + "OR eidos8_tim = "
					+ "'χοιρίνός κυμάς'" + "OR eidos8_tim = "
					+ "'χοιρινή παντσέτα χωρίς κόκκαλο'" + "OR eidos8_tim = "
					+ "'μοσχαρίσια γλώσσα'" + "OR eidos8_tim = "
					+ "'μοσχαρίσιο rib-eye'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting Tirokomika DETAILS
	public ArrayList<Timologia> Get_TirokomikaDetails() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE eidos1_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos1_tim = " + "'γιαούρτι'"
					+ "OR eidos1_tim = " + "'γκούντα φέτες'"
					+ "OR eidos1_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos1_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos1_tim = " + "'μανούρι'" + "OR eidos1_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos1_tim = " + "'χαλούμι'"
					+ "OR eidos1_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos1_tim = " + "'γραβιέρα'" + "OR eidos1_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos1_tim = "
					+ "'κρέμα τυριού'" + "OR eidos1_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos1_tim = " + "'μυζήθρα'"
					+ "OR eidos1_tim = " + "'lurpak'" + "OR eidos1_tim = "
					+ "'ρεγγάτο'" + "OR eidos1_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos1_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos1_tim = " + "'γάλα'" + "OR eidos2_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos2_tim = " + "'γιαούρτι'"
					+ "OR eidos2_tim = " + "'γκούντα φέτες'"
					+ "OR eidos2_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos2_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos2_tim = " + "'μανούρι'" + "OR eidos2_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos2_tim = " + "'χαλούμι'"
					+ "OR eidos2_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos2_tim = " + "'γραβιέρα'" + "OR eidos2_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos2_tim = "
					+ "'κρέμα τυριού'" + "OR eidos2_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos2_tim = " + "'μυζήθρα'"
					+ "OR eidos2_tim = " + "'lurpak'" + "OR eidos2_tim = "
					+ "'ρεγγάτο'" + "OR eidos2_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos2_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos2_tim = " + "'γάλα'" + "OR eidos3_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos3_tim = " + "'γιαούρτι'"
					+ "OR eidos3_tim = " + "'γκούντα φέτες'"
					+ "OR eidos3_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos3_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos3_tim = " + "'μανούρι'" + "OR eidos3_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos3_tim = " + "'χαλούμι'"
					+ "OR eidos3_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos3_tim = " + "'γραβιέρα'" + "OR eidos3_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos3_tim = "
					+ "'κρέμα τυριού'" + "OR eidos3_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos3_tim = " + "'μυζήθρα'"
					+ "OR eidos3_tim = " + "'lurpak'" + "OR eidos3_tim = "
					+ "'ρεγγάτο'" + "OR eidos3_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos3_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos3_tim = " + "'γάλα'" + "OR eidos3_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos3_tim = " + "'γιαούρτι'"
					+ "OR eidos3_tim = " + "'γκούντα φέτες'"
					+ "OR eidos3_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos3_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos3_tim = " + "'μανούρι'" + "OR eidos3_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos3_tim = " + "'χαλούμι'"
					+ "OR eidos3_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos3_tim = " + "'γραβιέρα'" + "OR eidos3_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos3_tim = "
					+ "'κρέμα τυριού'" + "OR eidos3_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos3_tim = " + "'μυζήθρα'"
					+ "OR eidos3_tim = " + "'lurpak'" + "OR eidos3_tim = "
					+ "'ρεγγάτο'" + "OR eidos3_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos3_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos3_tim = " + "'γάλα'" + "OR eidos4_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos4_tim = " + "'γιαούρτι'"
					+ "OR eidos4_tim = " + "'γκούντα φέτες'"
					+ "OR eidos4_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos4_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos4_tim = " + "'μανούρι'" + "OR eidos4_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos4_tim = " + "'χαλούμι'"
					+ "OR eidos4_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos4_tim = " + "'γραβιέρα'" + "OR eidos4_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos4_tim = "
					+ "'κρέμα τυριού'" + "OR eidos4_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos4_tim = " + "'μυζήθρα'"
					+ "OR eidos4_tim = " + "'lurpak'" + "OR eidos4_tim = "
					+ "'ρεγγάτο'" + "OR eidos4_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos4_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos4_tim = " + "'γάλα'" + "OR eidos5_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos5_tim = " + "'γιαούρτι'"
					+ "OR eidos5_tim = " + "'γκούντα φέτες'"
					+ "OR eidos5_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos5_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos5_tim = " + "'μανούρι'" + "OR eidos5_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos5_tim = " + "'χαλούμι'"
					+ "OR eidos5_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos5_tim = " + "'γραβιέρα'" + "OR eidos5_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos5_tim = "
					+ "'κρέμα τυριού'" + "OR eidos5_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos5_tim = " + "'μυζήθρα'"
					+ "OR eidos5_tim = " + "'lurpak'" + "OR eidos5_tim = "
					+ "'ρεγγάτο'" + "OR eidos5_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos5_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos5_tim = " + "'γάλα'" + "OR eidos6_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos6_tim = " + "'γιαούρτι'"
					+ "OR eidos6_tim = " + "'γκούντα φέτες'"
					+ "OR eidos6_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos6_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos6_tim = " + "'μανούρι'" + "OR eidos6_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos6_tim = " + "'χαλούμι'"
					+ "OR eidos6_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos6_tim = " + "'γραβιέρα'" + "OR eidos6_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos6_tim = "
					+ "'κρέμα τυριού'" + "OR eidos6_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos6_tim = " + "'μυζήθρα'"
					+ "OR eidos6_tim = " + "'lurpak'" + "OR eidos6_tim = "
					+ "'ρεγγάτο'" + "OR eidos6_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos6_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos6_tim = " + "'γάλα'" + "OR eidos7_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos7_tim = " + "'γιαούρτι'"
					+ "OR eidos7_tim = " + "'γκούντα φέτες'"
					+ "OR eidos7_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos7_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos7_tim = " + "'μανούρι'" + "OR eidos7_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos7_tim = " + "'χαλούμι'"
					+ "OR eidos7_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos7_tim = " + "'γραβιέρα'" + "OR eidos7_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos7_tim = "
					+ "'κρέμα τυριού'" + "OR eidos7_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos7_tim = " + "'μυζήθρα'"
					+ "OR eidos7_tim = " + "'lurpak'" + "OR eidos7_tim = "
					+ "'ρεγγάτο'" + "OR eidos7_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos7_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos7_tim = " + "'γάλα'" + "OR eidos8_tim = "
					+ "'κρέμα γάλακτος'" + "OR eidos8_tim = " + "'γιαούρτι'"
					+ "OR eidos8_tim = " + "'γκούντα φέτες'"
					+ "OR eidos8_tim = " + "'γκούντα τριμένη'"
					+ "OR eidos8_tim = " + "'παρμεζάνα τριμένη'"
					+ "OR eidos8_tim = " + "'μανούρι'" + "OR eidos8_tim = "
					+ "'μοτσαρέλα νερού'" + "OR eidos8_tim = " + "'χαλούμι'"
					+ "OR eidos8_tim = " + "'παρμεζάνα κεφάλι'"
					+ "OR eidos8_tim = " + "'γραβιέρα'" + "OR eidos8_tim = "
					+ "'κρέμα τυριού buko'" + "OR eidos8_tim = "
					+ "'κρέμα τυριού'" + "OR eidos8_tim = "
					+ "'ημίσκληρο κασέρι'" + "OR eidos8_tim = " + "'μυζήθρα'"
					+ "OR eidos8_tim = " + "'lurpak'" + "OR eidos8_tim = "
					+ "'ρεγγάτο'" + "OR eidos8_tim = " + "'βούτυρο 5kg'"
					+ "OR eidos8_tim = " + "'φέτα αγελαδινή'"
					+ "OR eidos8_tim = " + "'γάλα'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Hmerisia() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%d', date_tim) = strftime('%d', 'now') ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {

			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Evdomada() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%W', date_tim) = strftime('%W', 'now') ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {

			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Minas() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE date_tim >= date('now','-30 day') ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Etos() {
		try {
			timologia_list.clear();

			// Select All Query

			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Ianouario() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '01' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Fevrouario() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '02' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Martio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '03' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Aprilio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia strftime('%Y', date_tim)= strftime('%Y', 'now') AND WHERE strftime('%m', date_tim) = '04' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Maio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '05' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Iounio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '06' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Ioulio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '07' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Augousto() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '08' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Septevrio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '09' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Oktovrio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '10' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Noevrio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '11' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// Getting All Timologia
	public ArrayList<Timologia> Get_Dekevrio() {
		try {
			timologia_list.clear();

			// Select All Query
			String selectQuery = "SELECT * FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '12' ORDER BY date_tim DESC";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Timologia timologia = new Timologia();
					timologia.setIDTim(Integer.parseInt(cursor.getString(0)));

					timologia.setEponimiaTim(cursor.getString(1));
					timologia.setArithmoTim(cursor.getString(2));
					timologia.setTimiTim(cursor.getString(3));
					timologia.setDateTim(cursor.getString(4));
					timologia.setEidos1Tim(cursor.getString(5));
					timologia.setEidos2Tim(cursor.getString(6));
					timologia.setEidos3Tim(cursor.getString(7));
					timologia.setEidos4Tim(cursor.getString(8));
					timologia.setEidos5Tim(cursor.getString(9));
					timologia.setEidos6Tim(cursor.getString(10));
					timologia.setEidos7Tim(cursor.getString(11));
					timologia.setEidos8Tim(cursor.getString(12));
					timologia.setPosotita1Tim(cursor.getString(13));
					timologia.setPosotita2Tim(cursor.getString(14));
					timologia.setPosotita3Tim(cursor.getString(15));
					timologia.setPosotita4Tim(cursor.getString(16));
					timologia.setPosotita5Tim(cursor.getString(17));
					timologia.setPosotita6Tim(cursor.getString(18));
					timologia.setPosotita7Tim(cursor.getString(19));
					timologia.setPosotita8Tim(cursor.getString(20));

					// Adding contact to list
					timologia_list.add(timologia);
				} while (cursor.moveToNext());
			}

			// return contact list
			cursor.close();
			db.close();
			return timologia_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_timologia", "" + e);
		}

		return timologia_list;
	}

	// get SumPerMonth
	public String getSumPerWeek() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumIan() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '01'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumFeb() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '02'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumMar() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '03'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumApr() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '04'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumMai() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '05'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumIou() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '06'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumIul() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '07'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumAug() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '08'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumSep() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '09'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumOkt() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '10'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumNoe() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '11'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	// get SumPerMonth
	public String getSumDek() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim)= strftime('%Y', 'now') AND strftime('%m', date_tim) = '12'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumKafedes() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Εσπρέσσο' "
				+ "OR eidos1_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos1_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos1_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos1_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos1_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos1_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos1_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos1_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos1_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos1_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos1_tim = "
				+ "'όρεο'"
				+ "OR eidos1_tim = "
				+ "'σιρόπια'"
				+ "OR eidos1_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos1_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos1_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos1_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos1_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos1_tim = "
				+ "'τρούφα'"
				+ "OR eidos1_tim = "
				+ "'φίλλερ'"
				+ "OR eidos1_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos1_tim = "
				+ "'Frio'"
				+ "OR eidos1_tim = "
				+ "'Freddoccino'"
				+ "OR eidos1_tim = "
				+ "'Latin Dance'"
				+ "OR eidos1_tim = "
				+ "'Canderel'"
				+ "OR eidos2_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos2_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos2_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos2_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos2_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos2_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos2_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos2_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos2_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos2_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos2_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos2_tim = "
				+ "'όρεο'"
				+ "OR eidos2_tim = "
				+ "'σιρόπια'"
				+ "OR eidos2_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos2_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos2_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos2_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos2_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos2_tim = "
				+ "'τρούφα'"
				+ "OR eidos2_tim = "
				+ "'φίλλερ'"
				+ "OR eidos2_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos2_tim = "
				+ "'Frio'"
				+ "OR eidos2_tim = "
				+ "'Freddoccino'"
				+ "OR eidos2_tim = "
				+ "'Latin Dance'"
				+ "OR eidos2_tim = "
				+ "'Canderel'"
				+ "OR eidos3_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos3_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos3_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos3_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos3_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos3_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos3_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos3_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos3_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos3_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos3_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos3_tim = "
				+ "'όρεο'"
				+ "OR eidos3_tim = "
				+ "'σιρόπια'"
				+ "OR eidos3_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos3_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos3_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos3_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos3_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos3_tim = "
				+ "'τρούφα'"
				+ "OR eidos3_tim = "
				+ "'φίλλερ'"
				+ "OR eidos3_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos3_tim = "
				+ "'Frio'"
				+ "OR eidos3_tim = "
				+ "'Freddoccino'"
				+ "OR eidos3_tim = "
				+ "'Latin Dance'"
				+ "OR eidos3_tim = "
				+ "'Canderel'"
				+ "OR eidos4_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos4_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos4_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos4_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos4_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos4_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos4_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos4_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos4_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos4_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos4_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos4_tim = "
				+ "'όρεο'"
				+ "OR eidos4_tim = "
				+ "'σιρόπια'"
				+ "OR eidos4_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos4_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos4_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos4_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos4_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos4_tim = "
				+ "'τρούφα'"
				+ "OR eidos4_tim = "
				+ "'φίλλερ'"
				+ "OR eidos4_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos4_tim = "
				+ "'Frio'"
				+ "OR eidos4_tim = "
				+ "'Freddoccino'"
				+ "OR eidos4_tim = "
				+ "'Latin Dance'"
				+ "OR eidos4_tim = "
				+ "'Canderel'"
				+ "OR eidos5_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos5_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos5_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos5_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos5_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos5_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos5_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos5_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos5_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos5_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos5_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos5_tim = "
				+ "'όρεο'"
				+ "OR eidos5_tim = "
				+ "'σιρόπια'"
				+ "OR eidos5_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos5_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos5_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos5_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos5_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos5_tim = "
				+ "'τρούφα'"
				+ "OR eidos5_tim = "
				+ "'φίλλερ'"
				+ "OR eidos5_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos5_tim = "
				+ "'Frio'"
				+ "OR eidos5_tim = "
				+ "'Freddoccino'"
				+ "OR eidos5_tim = "
				+ "'Latin Dance'"
				+ "OR eidos5_tim = "
				+ "'Canderel'"
				+ "OR eidos6_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos6_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos6_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos6_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos6_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos6_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos6_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos6_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos6_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos6_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos6_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos6_tim = "
				+ "'όρεο'"
				+ "OR eidos6_tim = "
				+ "'σιρόπια'"
				+ "OR eidos6_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos6_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos6_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos6_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos6_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos6_tim = "
				+ "'τρούφα'"
				+ "OR eidos6_tim = "
				+ "'φίλλερ'"
				+ "OR eidos6_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos6_tim = "
				+ "'Frio'"
				+ "OR eidos6_tim = "
				+ "'Freddoccino'"
				+ "OR eidos6_tim = "
				+ "'Latin Dance'"
				+ "OR eidos6_tim = "
				+ "'Canderel'"
				+ "OR eidos7_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos7_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos7_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos7_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos7_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos7_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos7_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos7_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos7_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos7_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos7_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos7_tim = "
				+ "'όρεο'"
				+ "OR eidos7_tim = "
				+ "'σιρόπια'"
				+ "OR eidos7_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos7_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos7_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos7_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos7_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos7_tim = "
				+ "'τρούφα'"
				+ "OR eidos7_tim = "
				+ "'φίλλερ'"
				+ "OR eidos7_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos7_tim = "
				+ "'Frio'"
				+ "OR eidos7_tim = "
				+ "'Freddoccino'"
				+ "OR eidos7_tim = "
				+ "'Latin Dance'"
				+ "OR eidos7_tim = "
				+ "'Canderel'"
				+ "OR eidos8_tim = "
				+ "'Εσπρέσσο'"
				+ "OR eidos8_tim = "
				+ "'Εσπρέσσο.ντεκάφ'"
				+ "OR eidos8_tim = "
				+ "'σοκολάτα ζεστή'"
				+ "OR eidos8_tim = "
				+ "'σοκολάτα κρύα'"
				+ "OR eidos8_tim = "
				+ "'στικ ζάχαρη'"
				+ "OR eidos8_tim = "
				+ "'στικ μάυρη ζαχ'"
				+ "OR eidos8_tim = "
				+ "'ζαχαρίνες'"
				+ "OR eidos8_tim = "
				+ "'νόβο μακράς'"
				+ "OR eidos8_tim = "
				+ "'νόβο εβαπορέ'"
				+ "OR eidos8_tim = "
				+ "'Φρεντίτο βανίλ.'"
				+ "OR eidos8_tim = "
				+ "'φρεντίτο σοκολ.'"
				+ "OR eidos8_tim = "
				+ "'όρεο'"
				+ "OR eidos8_tim = "
				+ "'σιρόπια'"
				+ "OR eidos8_tim = "
				+ "'Νεσκαφέ'"
				+ "OR eidos8_tim = "
				+ "'Νεσ. ντεκάφ'"
				+ "OR eidos8_tim = "
				+ "'Ζάχαρη κιλού'"
				+ "OR eidos8_tim = "
				+ "'Μαρασκίνο'"
				+ "OR eidos8_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos8_tim = "
				+ "'Ελληνικός'"
				+ "OR eidos8_tim = "
				+ "'τρούφα'"
				+ "OR eidos8_tim = "
				+ "'φίλλερ'"
				+ "OR eidos8_tim = "
				+ "'σοκολάτα oreo'"
				+ "OR eidos8_tim = "
				+ "'Frio'"
				+ "OR eidos8_tim = "
				+ "'Freddoccino'"
				+ "OR eidos8_tim = "
				+ "'Latin Dance'"
				+ "OR eidos8_tim = " + "'Canderel'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumBires() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'fix'"
				+ "OR eidos1_tim = "
				+ "'fix dark'"
				+ "OR eidos1_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos1_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos1_tim = "
				+ "'carlsberg'"
				+ "OR eidos1_tim = "
				+ "'corona'"
				+ "OR eidos1_tim = "
				+ "'kilkeny'"
				+ "OR eidos1_tim = "
				+ "'fisher'"
				+ "OR eidos1_tim = "
				+ "'somersby'"
				+ "OR eidos1_tim = "
				+ "'bud'"
				+ "OR eidos1_tim = "
				+ "'μύθος'"
				+ "OR eidos1_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos1_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos1_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos1_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos1_tim = "
				+ "'βόρεια india'"
				+ "OR eidos1_tim = "
				+ "'heineken'"
				+ "OR eidos1_tim = "
				+ "'amstel'"
				+ "OR eidos1_tim = "
				+ "'mcfarland'"
				+ "OR eidos1_tim = "
				+ "'stella'"
				+ "OR eidos1_tim = "
				+ "'erdinger'"
				+ "OR eidos1_tim = "
				+ "'paulaner'"
				+ "OR eidos1_tim = "
				+ "'chimay'"
				+ "OR eidos1_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos1_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos1_tim = "
				+ "'buckler'"
				+ "OR eidos1_tim = "
				+ "'desperados'"
				+ "OR eidos1_tim = "
				+ "'estrella'"
				+ "OR eidos1_tim = "
				+ "'volkan'"
				+ "OR eidos1_tim = "
				+ "'volkan black'"
				+ "OR eidos2_tim = "
				+ "'fix'"
				+ "OR eidos2_tim = "
				+ "'fix dark'"
				+ "OR eidos2_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos2_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos2_tim = "
				+ "'carlsberg'"
				+ "OR eidos2_tim = "
				+ "'corona'"
				+ "OR eidos2_tim = "
				+ "'kilkeny'"
				+ "OR eidos2_tim = "
				+ "'fisher'"
				+ "OR eidos2_tim = "
				+ "'somersby'"
				+ "OR eidos2_tim = "
				+ "'bud'"
				+ "OR eidos2_tim = "
				+ "'μύθος'"
				+ "OR eidos2_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos2_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos2_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos2_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos2_tim = "
				+ "'βόρεια india'"
				+ "OR eidos2_tim = "
				+ "'heineken'"
				+ "OR eidos2_tim = "
				+ "'amstel'"
				+ "OR eidos2_tim = "
				+ "'mcfarland'"
				+ "OR eidos2_tim = "
				+ "'stella'"
				+ "OR eidos2_tim = "
				+ "'erdinger'"
				+ "OR eidos2_tim = "
				+ "'paulaner'"
				+ "OR eidos2_tim = "
				+ "'chimay'"
				+ "OR eidos2_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos2_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos2_tim = "
				+ "'buckler'"
				+ "OR eidos2_tim = "
				+ "'desperados'"
				+ "OR eidos2_tim = "
				+ "'estrella'"
				+ "OR eidos2_tim = "
				+ "'volkan'"
				+ "OR eidos2_tim = "
				+ "'volkan black'"
				+ "OR eidos3_tim = "
				+ "'fix'"
				+ "OR eidos3_tim = "
				+ "'fix dark'"
				+ "OR eidos3_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos3_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos3_tim = "
				+ "'carlsberg'"
				+ "OR eidos3_tim = "
				+ "'corona'"
				+ "OR eidos3_tim = "
				+ "'kilkeny'"
				+ "OR eidos3_tim = "
				+ "'fisher'"
				+ "OR eidos3_tim = "
				+ "'somersby'"
				+ "OR eidos3_tim = "
				+ "'bud'"
				+ "OR eidos3_tim = "
				+ "'μύθος'"
				+ "OR eidos3_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos3_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos3_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos3_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos3_tim = "
				+ "'βόρεια india'"
				+ "OR eidos3_tim = "
				+ "'heineken'"
				+ "OR eidos3_tim = "
				+ "'amstel'"
				+ "OR eidos3_tim = "
				+ "'mcfarland'"
				+ "OR eidos3_tim = "
				+ "'stella'"
				+ "OR eidos3_tim = "
				+ "'erdinger'"
				+ "OR eidos3_tim = "
				+ "'paulaner'"
				+ "OR eidos3_tim = "
				+ "'chimay'"
				+ "OR eidos3_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos3_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos3_tim = "
				+ "'buckler'"
				+ "OR eidos3_tim = "
				+ "'desperados'"
				+ "OR eidos3_tim = "
				+ "'estrella'"
				+ "OR eidos3_tim = "
				+ "'volkan'"
				+ "OR eidos3_tim = "
				+ "'volkan black'"
				+ "OR eidos4_tim = "
				+ "'fix'"
				+ "OR eidos4_tim = "
				+ "'fix dark'"
				+ "OR eidos4_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos4_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos4_tim = "
				+ "'carlsberg'"
				+ "OR eidos4_tim = "
				+ "'corona'"
				+ "OR eidos4_tim = "
				+ "'kilkeny'"
				+ "OR eidos4_tim = "
				+ "'fisher'"
				+ "OR eidos4_tim = "
				+ "'somersby'"
				+ "OR eidos4_tim = "
				+ "'bud'"
				+ "OR eidos4_tim = "
				+ "'μύθος'"
				+ "OR eidos4_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos4_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos4_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos4_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos4_tim = "
				+ "'βόρεια india'"
				+ "OR eidos4_tim = "
				+ "'heineken'"
				+ "OR eidos4_tim = "
				+ "'amstel'"
				+ "OR eidos4_tim = "
				+ "'mcfarland'"
				+ "OR eidos4_tim = "
				+ "'stella'"
				+ "OR eidos4_tim = "
				+ "'erdinger'"
				+ "OR eidos4_tim = "
				+ "'paulaner'"
				+ "OR eidos4_tim = "
				+ "'chimay'"
				+ "OR eidos4_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos4_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos4_tim = "
				+ "'buckler'"
				+ "OR eidos4_tim = "
				+ "'desperados'"
				+ "OR eidos4_tim = "
				+ "'estrella'"
				+ "OR eidos4_tim = "
				+ "'volkan'"
				+ "OR eidos4_tim = "
				+ "'volkan black'"
				+ "OR eidos5_tim = "
				+ "'fix'"
				+ "OR eidos5_tim = "
				+ "'fix dark'"
				+ "OR eidos5_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos5_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos5_tim = "
				+ "'carlsberg'"
				+ "OR eidos5_tim = "
				+ "'corona'"
				+ "OR eidos5_tim = "
				+ "'kilkeny'"
				+ "OR eidos5_tim = "
				+ "'fisher'"
				+ "OR eidos5_tim = "
				+ "'somersby'"
				+ "OR eidos5_tim = "
				+ "'bud'"
				+ "OR eidos5_tim = "
				+ "'μύθος'"
				+ "OR eidos5_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos5_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos5_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos5_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos5_tim = "
				+ "'βόρεια india'"
				+ "OR eidos5_tim = "
				+ "'heineken'"
				+ "OR eidos5_tim = "
				+ "'amstel'"
				+ "OR eidos5_tim = "
				+ "'mcfarland'"
				+ "OR eidos5_tim = "
				+ "'stella'"
				+ "OR eidos5_tim = "
				+ "'erdinger'"
				+ "OR eidos5_tim = "
				+ "'paulaner'"
				+ "OR eidos5_tim = "
				+ "'chimay'"
				+ "OR eidos5_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos5_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos5_tim = "
				+ "'buckler'"
				+ "OR eidos5_tim = "
				+ "'desperados'"
				+ "OR eidos5_tim = "
				+ "'estrella'"
				+ "OR eidos5_tim = "
				+ "'volkan'"
				+ "OR eidos5_tim = "
				+ "'volkan black'"
				+ "OR eidos6_tim = "
				+ "'fix'"
				+ "OR eidos6_tim = "
				+ "'fix dark'"
				+ "OR eidos6_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos6_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos6_tim = "
				+ "'carlsberg'"
				+ "OR eidos6_tim = "
				+ "'corona'"
				+ "OR eidos6_tim = "
				+ "'kilkeny'"
				+ "OR eidos6_tim = "
				+ "'fisher'"
				+ "OR eidos6_tim = "
				+ "'somersby'"
				+ "OR eidos6_tim = "
				+ "'bud'"
				+ "OR eidos6_tim = "
				+ "'μύθος'"
				+ "OR eidos6_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos6_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos6_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos6_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos6_tim = "
				+ "'βόρεια india'"
				+ "OR eidos6_tim = "
				+ "'heineken'"
				+ "OR eidos6_tim = "
				+ "'amstel'"
				+ "OR eidos6_tim = "
				+ "'mcfarland'"
				+ "OR eidos6_tim = "
				+ "'stella'"
				+ "OR eidos6_tim = "
				+ "'erdinger'"
				+ "OR eidos6_tim = "
				+ "'paulaner'"
				+ "OR eidos6_tim = "
				+ "'chimay'"
				+ "OR eidos6_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos6_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos6_tim = "
				+ "'buckler'"
				+ "OR eidos6_tim = "
				+ "'desperados'"
				+ "OR eidos6_tim = "
				+ "'estrella'"
				+ "OR eidos6_tim = "
				+ "'volkan'"
				+ "OR eidos6_tim = "
				+ "'volkan black'"
				+ "OR eidos7_tim = "
				+ "'fix'"
				+ "OR eidos7_tim = "
				+ "'fix dark'"
				+ "OR eidos7_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos7_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos7_tim = "
				+ "'carlsberg'"
				+ "OR eidos7_tim = "
				+ "'corona'"
				+ "OR eidos7_tim = "
				+ "'kilkeny'"
				+ "OR eidos7_tim = "
				+ "'fisher'"
				+ "OR eidos7_tim = "
				+ "'somersby'"
				+ "OR eidos7_tim = "
				+ "'bud'"
				+ "OR eidos7_tim = "
				+ "'μύθος'"
				+ "OR eidos7_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos7_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos7_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos7_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos7_tim = "
				+ "'βόρεια india'"
				+ "OR eidos7_tim = "
				+ "'heineken'"
				+ "OR eidos7_tim = "
				+ "'amstel'"
				+ "OR eidos7_tim = "
				+ "'mcfarland'"
				+ "OR eidos7_tim = "
				+ "'stella'"
				+ "OR eidos7_tim = "
				+ "'erdinger'"
				+ "OR eidos7_tim = "
				+ "'paulaner'"
				+ "OR eidos7_tim = "
				+ "'chimay'"
				+ "OR eidos7_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos7_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos7_tim = "
				+ "'buckler'"
				+ "OR eidos7_tim = "
				+ "'desperados'"
				+ "OR eidos7_tim = "
				+ "'estrella'"
				+ "OR eidos7_tim = "
				+ "'volkan'"
				+ "OR eidos7_tim = "
				+ "'volkan black'"
				+ "OR eidos8_tim = "
				+ "'fix'"
				+ "OR eidos8_tim = "
				+ "'fix dark'"
				+ "OR eidos8_tim = "
				+ "'κάϊσερ'"
				+ "OR eidos8_tim = "
				+ "'κάϊσερ blonde'"
				+ "OR eidos8_tim = "
				+ "'carlsberg'"
				+ "OR eidos8_tim = "
				+ "'corona'"
				+ "OR eidos8_tim = "
				+ "'kilkeny'"
				+ "OR eidos8_tim = "
				+ "'fisher'"
				+ "OR eidos8_tim = "
				+ "'somersby'"
				+ "OR eidos8_tim = "
				+ "'bud'"
				+ "OR eidos8_tim = "
				+ "'μύθος'"
				+ "OR eidos8_tim = "
				+ "'fix βαρέλι'"
				+ "OR eidos8_tim = "
				+ "'κάϊσερ βαρέλι'"
				+ "OR eidos8_tim = "
				+ "'μύθος βαρέλι'"
				+ "OR eidos8_tim = "
				+ "'βόρεια pilsner'"
				+ "OR eidos8_tim = "
				+ "'βόρεια india'"
				+ "OR eidos8_tim = "
				+ "'heineken'"
				+ "OR eidos8_tim = "
				+ "'amstel'"
				+ "OR eidos8_tim = "
				+ "'mcfarland'"
				+ "OR eidos8_tim = "
				+ "'stella'"
				+ "OR eidos8_tim = "
				+ "'erdinger'"
				+ "OR eidos8_tim = "
				+ "'paulaner'"
				+ "OR eidos8_tim = "
				+ "'chimay'"
				+ "OR eidos8_tim = "
				+ "'άλφα βαρέλι'"
				+ "OR eidos8_tim = "
				+ "'fischer βαρέλι'"
				+ "OR eidos8_tim = "
				+ "'buckler'"
				+ "OR eidos8_tim = "
				+ "'desperados'"
				+ "OR eidos8_tim = "
				+ "'estrella'"
				+ "OR eidos8_tim = "
				+ "'volkan'"
				+ "OR eidos8_tim = "
				+ "'volkan black'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumAnapsiktika() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos1_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos1_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos1_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos1_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos1_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos1_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos1_tim = "
				+ "'Π.sprite'"
				+ "OR eidos1_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos1_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos1_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos1_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos1_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos1_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos1_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos1_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos1_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos1_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos1_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos1_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos1_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos1_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos1_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos1_tim = "
				+ "'Perrier'"
				+ "OR eidos1_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos1_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos1_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos1_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos1_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos1_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos1_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos2_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos2_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos2_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos2_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos2_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos2_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos2_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos2_tim = "
				+ "'Π.sprite'"
				+ "OR eidos2_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos2_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos2_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos2_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos2_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos2_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos2_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos2_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos2_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos2_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos2_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos2_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos2_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos2_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos2_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos2_tim = "
				+ "'Perrier'"
				+ "OR eidos2_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos2_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos2_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos2_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos2_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos2_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos2_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos3_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos3_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos3_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos3_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos3_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos3_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos3_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos3_tim = "
				+ "'Π.sprite'"
				+ "OR eidos3_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos3_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos3_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos3_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos3_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos3_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos3_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos3_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos3_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos3_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos3_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos3_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos3_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos3_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos3_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos3_tim = "
				+ "'Perrier'"
				+ "OR eidos3_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos3_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos3_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos3_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos3_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos3_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos3_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos4_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos4_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos4_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos4_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos4_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos4_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos4_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos4_tim = "
				+ "'Π.sprite'"
				+ "OR eidos4_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos4_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos4_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos4_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos4_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos4_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos4_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos4_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos4_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos4_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos4_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos4_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos4_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos4_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos4_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos4_tim = "
				+ "'Perrier'"
				+ "OR eidos4_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos4_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos4_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos4_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos4_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos4_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos4_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos5_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos5_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos5_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos5_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos5_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos5_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos5_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos5_tim = "
				+ "'Π.sprite'"
				+ "OR eidos5_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos5_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos5_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos5_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos5_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos5_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos5_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos5_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos5_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos5_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos5_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos5_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos5_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos5_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos5_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos5_tim = "
				+ "'Perrier'"
				+ "OR eidos5_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos5_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos5_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos5_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos5_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos5_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos5_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos6_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos6_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos6_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos6_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos6_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos6_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos6_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos6_tim = "
				+ "'Π.sprite'"
				+ "OR eidos6_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos6_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos6_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos6_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos6_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos6_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos6_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos6_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos6_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos6_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos6_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos6_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos6_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos6_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos6_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos6_tim = "
				+ "'Perrier'"
				+ "OR eidos6_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos6_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos6_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos6_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos6_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos6_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos6_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos7_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos7_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos7_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos7_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos7_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos7_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos7_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos7_tim = "
				+ "'Π.sprite'"
				+ "OR eidos7_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos7_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos7_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos7_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos7_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos7_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos7_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos7_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos7_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos7_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos7_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos7_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos7_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos7_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos7_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos7_tim = "
				+ "'Perrier'"
				+ "OR eidos7_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos7_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos7_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos7_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos7_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos7_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos7_tim = "
				+ "'χυμό φράουλα'"
				+ "OR eidos8_tim = "
				+ "'Γ.coca cola'"
				+ "OR eidos8_tim = "
				+ "'Γ.πορτοκαλάδα'"
				+ "OR eidos8_tim = "
				+ "'Γ.λεμονάδα'"
				+ "OR eidos8_tim = "
				+ "'Γ.τόνικ'"
				+ "OR eidos8_tim = "
				+ "'Γ.σόδα'"
				+ "OR eidos8_tim = "
				+ "'Γ.sprite'"
				+ "OR eidos8_tim = "
				+ "'Π.coca cola'"
				+ "OR eidos8_tim = "
				+ "'Π.sprite'"
				+ "OR eidos8_tim = "
				+ "'Π.πορτοκαλάδα'"
				+ "OR eidos8_tim = "
				+ "'Π.λεμονάδα'"
				+ "OR eidos8_tim = "
				+ "'Π.τόνικ'"
				+ "OR eidos8_tim = "
				+ "'Π.σόδα'"
				+ "OR eidos8_tim = "
				+ "'Π.tuborg'"
				+ "OR eidos8_tim = "
				+ "'Π.φράουλα'"
				+ "OR eidos8_tim = "
				+ "'χυμό πορτοκάλι'"
				+ "OR eidos8_tim = "
				+ "'χυμό ροδάκινο'"
				+ "OR eidos8_tim = "
				+ "'χυμό μήλο'"
				+ "OR eidos8_tim = "
				+ "'χυμό ρόδι'"
				+ "OR eidos8_tim = "
				+ "'χυμό κοκτέϊλ'"
				+ "OR eidos8_tim = "
				+ "'χυμό μπανάνα'"
				+ "OR eidos8_tim = "
				+ "'χυμό ανανά'"
				+ "OR eidos8_tim = "
				+ "'Γ.coca cola light'"
				+ "OR eidos8_tim = "
				+ "'Γ.coca cola zero'"
				+ "OR eidos8_tim = "
				+ "'Perrier'"
				+ "OR eidos8_tim = "
				+ "'Π.coca cola light'"
				+ "OR eidos8_tim = "
				+ "'Π.coca cola zero'"
				+ "OR eidos8_tim = "
				+ "'χυμό βύσσινο'"
				+ "OR eidos8_tim = "
				+ "'χυμό κρανμπερι'"
				+ "OR eidos8_tim = "
				+ "'χυμό λεμόνι'"
				+ "OR eidos8_tim = "
				+ "'χυμό ανάμεικτο'"
				+ "OR eidos8_tim = " + "'χυμό φράουλα'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumTsai() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos1_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos1_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos1_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos1_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos1_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos1_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos1_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos1_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos1_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos2_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos2_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos2_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos2_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos2_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos2_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos2_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos2_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos2_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos2_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos3_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos3_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos3_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos3_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos3_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos3_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos3_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos3_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos3_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos3_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos4_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos4_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos4_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos4_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos4_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos4_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos4_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos4_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos4_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos4_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos5_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos5_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos5_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos5_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos5_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos5_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos5_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos5_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos5_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos5_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos6_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos6_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos6_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos6_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos6_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos6_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos6_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos6_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos6_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos6_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos7_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos7_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos7_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos7_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos7_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos7_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos7_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos7_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos7_tim = "
				+ "'τσάι μαύρο'"
				+ "OR eidos7_tim = "
				+ "'τσάι βότανα'"
				+ "OR eidos8_tim = "
				+ "'τσάι απλό'"
				+ "OR eidos8_tim = "
				+ "'τσάι ροδάκινο'"
				+ "OR eidos8_tim = "
				+ "'τσάι πράσινο'"
				+ "OR eidos8_tim = "
				+ "'τσάι καραμέλα'"
				+ "OR eidos8_tim = "
				+ "'τσάι λεμόνι'"
				+ "OR eidos8_tim = "
				+ "'τσάι φράουλα'"
				+ "OR eidos8_tim = "
				+ "'τσάι βανίλλια'"
				+ "OR eidos8_tim = "
				+ "'χαμομήλι'"
				+ "OR eidos8_tim = "
				+ "'τσάι μαύρο'" + "OR eidos8_tim = " + "'τσάι βότανα'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumPagota() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos1_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos1_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos1_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos1_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos1_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos1_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos1_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos2_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos2_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos2_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos2_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos2_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos2_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos2_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos2_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos3_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos3_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos3_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos3_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos3_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos3_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos3_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos3_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos4_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos4_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos4_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos4_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos4_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos4_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos4_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos4_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos5_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos5_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos5_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos5_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos5_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos5_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos5_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos5_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos6_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos6_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos6_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos6_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos6_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos6_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos6_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos6_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos7_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos7_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos7_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos7_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos7_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos7_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos7_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos7_tim = "
				+ "'παγωτό λεμόνι'"
				+ "OR eidos8_tim = "
				+ "'παγωτό βανίλια'"
				+ "OR eidos8_tim = "
				+ "'παγωτό σοκολάτα'"
				+ "OR eidos8_tim = "
				+ "'παγωτό καραμέλα'"
				+ "OR eidos8_tim = "
				+ "'παγωτό φράουλα'"
				+ "OR eidos8_tim = "
				+ "'παγωτό μπανάνα'"
				+ "OR eidos8_tim = "
				+ "'παγωτό μόκα'"
				+ "OR eidos8_tim = "
				+ "'παγωτό στρατσιατέλα'"
				+ "OR eidos8_tim = "
				+ "'παγωτό λεμόνι'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumKrasia() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
					+ "'Λ.Ντάμα κούπα'" + "OR eidos1_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos1_tim = " + "'Λ.Μικρός'"
					+ "OR eidos1_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos1_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos1_tim = " + "'Λ.Βιβλία'" + "OR eidos1_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos1_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos1_tim = " + "'Λ.Ευπορία'" + "OR eidos1_tim = "
					+ "'Λ.Isari'" + "OR eidos1_tim = " + "'Λ.Cirinon'"
					+ "OR eidos1_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos1_tim = "
					+ "'Κ.Cirinon'" + "OR eidos1_tim = " + "'Κ.Idonida'"
					+ "OR eidos1_tim = " + "'Κ.Isari'" + "OR eidos1_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos1_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos1_tim = " + "'Κ.Chateau'" + "OR eidos1_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos1_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos1_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos1_tim = " + "'Κ.Μικρός'" + "OR eidos1_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos1_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos1_tim = " + "'Ρ.Βιβλία'" + "OR eidos1_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos1_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos1_tim = " + "'Ρ.Cirinon'" + "OR eidos1_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos1_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos1_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos1_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos1_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos1_tim = "
					+ "'Λ.Sangria'" + "OR eidos1_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Λ.Αμέθυστος'" + "OR eidos1_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos1_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos1_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos1_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos1_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos1_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos1_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos1_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos1_tim = "
					+ "'Λ.Visanto'" + "OR eidos1_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos1_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos1_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos1_tim = " + "'Κ.Sangria'"
					+ "OR eidos1_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Κ.Αμέθυστος'" + "OR eidos1_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos1_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos1_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos1_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos1_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos1_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos1_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos1_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos1_tim = "
					+ "'Κ.Visanto'" + "OR eidos1_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos1_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos1_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos1_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos1_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos1_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos1_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos1_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos1_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos1_tim = " + "'Ρ.Visanto'" + "OR eidos1_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos1_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos1_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos1_tim = " + "'Asti Martini'"
					+ "OR eidos1_tim = " + "'Asti μικρή'"
					+ "OR eidos1_tim = " + "'Gordon Rouge'"
					+ "OR eidos1_tim = " + "'Moschato D Asti'"
					+ "OR eidos1_tim = " + "'Dom Perignon'"
					+ "OR eidos1_tim = " + "'Moet et Chandon'"
					+ "OR eidos1_tim = " + "'Veuve Clickuot'"
					+ "OR eidos1_tim = " + "'Veuve aperitif'"
					+ "OR eidos2_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos2_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos2_tim = " + "'Λ.Μικρός'"
					+ "OR eidos2_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos2_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos2_tim = " + "'Λ.Βιβλία'" + "OR eidos2_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos2_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos2_tim = " + "'Λ.Ευπορία'" + "OR eidos2_tim = "
					+ "'Λ.Isari'" + "OR eidos2_tim = " + "'Λ.Cirinon'"
					+ "OR eidos2_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos2_tim = "
					+ "'Κ.Cirinon'" + "OR eidos2_tim = " + "'Κ.Idonida'"
					+ "OR eidos2_tim = " + "'Κ.Isari'" + "OR eidos2_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos2_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos2_tim = " + "'Κ.Chateau'" + "OR eidos2_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos2_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos2_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos2_tim = " + "'Κ.Μικρός'" + "OR eidos2_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos2_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos2_tim = " + "'Ρ.Βιβλία'" + "OR eidos2_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos2_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos2_tim = " + "'Ρ.Cirinon'" + "OR eidos2_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos2_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos2_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos2_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos2_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos2_tim = "
					+ "'Λ.Sangria'" + "OR eidos2_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Λ.Αμέθυστος'" + "OR eidos2_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos2_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos2_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos2_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos2_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos2_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos2_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos2_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos2_tim = "
					+ "'Λ.Visanto'" + "OR eidos2_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos2_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos2_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos2_tim = " + "'Κ.Sangria'"
					+ "OR eidos2_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Κ.Αμέθυστος'" + "OR eidos2_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos2_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos2_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos2_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos2_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos2_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos2_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos2_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos2_tim = "
					+ "'Κ.Visanto'" + "OR eidos2_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos2_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos2_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos2_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos2_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos2_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos2_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos2_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos2_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos2_tim = " + "'Ρ.Visanto'" + "OR eidos2_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos2_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos2_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos2_tim = " + "'Asti Martini'"
					+ "OR eidos2_tim = " + "'Asti μικρή'"
					+ "OR eidos2_tim = " + "'Gordon Rouge'"
					+ "OR eidos2_tim = " + "'Moschato D Asti'"
					+ "OR eidos2_tim = " + "'Dom Perignon'"
					+ "OR eidos2_tim = " + "'Moet et Chandon'"
					+ "OR eidos2_tim = " + "'Veuve Clickuot'"
					+ "OR eidos2_tim = " + "'Veuve aperitif'"
					+ "OR eidos3_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos3_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos3_tim = " + "'Λ.Μικρός'"
					+ "OR eidos3_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos3_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos3_tim = " + "'Λ.Βιβλία'" + "OR eidos3_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos3_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos3_tim = " + "'Λ.Ευπορία'" + "OR eidos3_tim = "
					+ "'Λ.Isari'" + "OR eidos3_tim = " + "'Λ.Cirinon'"
					+ "OR eidos3_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos3_tim = "
					+ "'Κ.Cirinon'" + "OR eidos3_tim = " + "'Κ.Idonida'"
					+ "OR eidos3_tim = " + "'Κ.Isari'" + "OR eidos3_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos3_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos3_tim = " + "'Κ.Chateau'" + "OR eidos3_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos3_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos3_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos3_tim = " + "'Κ.Μικρός'" + "OR eidos3_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos3_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos3_tim = " + "'Ρ.Βιβλία'" + "OR eidos3_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos3_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos3_tim = " + "'Ρ.Cirinon'" + "OR eidos3_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos3_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos3_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos3_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos3_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos3_tim = "
					+ "'Λ.Sangria'" + "OR eidos3_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Λ.Αμέθυστος'" + "OR eidos3_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos3_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos3_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos3_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos3_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos3_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos3_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos3_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos3_tim = "
					+ "'Λ.Visanto'" + "OR eidos3_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos3_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos3_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos3_tim = " + "'Κ.Sangria'"
					+ "OR eidos3_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Κ.Αμέθυστος'" + "OR eidos3_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos3_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos3_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos3_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos3_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos3_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos3_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos3_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos3_tim = "
					+ "'Κ.Visanto'" + "OR eidos3_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos3_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos3_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos3_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos3_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos3_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos3_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos3_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos3_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos3_tim = " + "'Ρ.Visanto'" + "OR eidos3_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos3_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos3_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos3_tim = " + "'Asti Martini'"
					+ "OR eidos3_tim = " + "'Asti μικρή'"
					+ "OR eidos3_tim = " + "'Gordon Rouge'"
					+ "OR eidos3_tim = " + "'Moschato D Asti'"
					+ "OR eidos3_tim = " + "'Dom Perignon'"
					+ "OR eidos3_tim = " + "'Moet et Chandon'"
					+ "OR eidos3_tim = " + "'Veuve Clickuot'"
					+ "OR eidos3_tim = " + "'Veuve aperitif'"
					+ "OR eidos4_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos4_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos4_tim = " + "'Λ.Μικρός'"
					+ "OR eidos4_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos4_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos4_tim = " + "'Λ.Βιβλία'" + "OR eidos4_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos4_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos4_tim = " + "'Λ.Ευπορία'" + "OR eidos4_tim = "
					+ "'Λ.Isari'" + "OR eidos4_tim = " + "'Λ.Cirinon'"
					+ "OR eidos4_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos4_tim = "
					+ "'Κ.Cirinon'" + "OR eidos4_tim = " + "'Κ.Idonida'"
					+ "OR eidos4_tim = " + "'Κ.Isari'" + "OR eidos4_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos4_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos4_tim = " + "'Κ.Chateau'" + "OR eidos4_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos4_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos4_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos4_tim = " + "'Κ.Μικρός'" + "OR eidos4_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos4_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos4_tim = " + "'Ρ.Βιβλία'" + "OR eidos4_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos4_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos4_tim = " + "'Ρ.Cirinon'" + "OR eidos4_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos4_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos4_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos4_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos4_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos4_tim = "
					+ "'Λ.Sangria'" + "OR eidos4_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Λ.Αμέθυστος'" + "OR eidos4_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos4_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos4_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos4_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos4_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos4_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos4_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos4_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos4_tim = "
					+ "'Λ.Visanto'" + "OR eidos4_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos4_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos4_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos4_tim = " + "'Κ.Sangria'"
					+ "OR eidos4_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Κ.Αμέθυστος'" + "OR eidos4_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos4_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos4_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos4_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos4_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos4_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos4_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos4_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos4_tim = "
					+ "'Κ.Visanto'" + "OR eidos4_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos4_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos4_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos4_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos4_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos4_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos4_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos4_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos4_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos4_tim = " + "'Ρ.Visanto'" + "OR eidos4_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos4_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos4_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos4_tim = " + "'Asti Martini'"
					+ "OR eidos4_tim = " + "'Asti μικρή'"
					+ "OR eidos4_tim = " + "'Gordon Rouge'"
					+ "OR eidos4_tim = " + "'Moschato D Asti'"
					+ "OR eidos4_tim = " + "'Dom Perignon'"
					+ "OR eidos4_tim = " + "'Moet et Chandon'"
					+ "OR eidos4_tim = " + "'Veuve Clickuot'"
					+ "OR eidos4_tim = " + "'Veuve aperitif'"
					+ "OR eidos5_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos5_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos5_tim = " + "'Λ.Μικρός'"
					+ "OR eidos5_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos5_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos5_tim = " + "'Λ.Βιβλία'" + "OR eidos5_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos5_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos5_tim = " + "'Λ.Ευπορία'" + "OR eidos5_tim = "
					+ "'Λ.Isari'" + "OR eidos5_tim = " + "'Λ.Cirinon'"
					+ "OR eidos5_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos5_tim = "
					+ "'Κ.Cirinon'" + "OR eidos5_tim = " + "'Κ.Idonida'"
					+ "OR eidos5_tim = " + "'Κ.Isari'" + "OR eidos5_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos5_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos5_tim = " + "'Κ.Chateau'" + "OR eidos5_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos5_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos5_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos5_tim = " + "'Κ.Μικρός'" + "OR eidos5_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos5_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos5_tim = " + "'Ρ.Βιβλία'" + "OR eidos5_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos5_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos5_tim = " + "'Ρ.Cirinon'" + "OR eidos5_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos5_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos5_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos5_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos5_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos5_tim = "
					+ "'Λ.Sangria'" + "OR eidos5_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Λ.Αμέθυστος'" + "OR eidos5_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos5_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos5_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos5_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos5_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos5_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos5_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos5_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos5_tim = "
					+ "'Λ.Visanto'" + "OR eidos5_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos5_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos5_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos5_tim = " + "'Κ.Sangria'"
					+ "OR eidos5_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Κ.Αμέθυστος'" + "OR eidos5_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos5_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos5_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos5_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos5_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos5_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos5_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos5_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos5_tim = "
					+ "'Κ.Visanto'" + "OR eidos5_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos5_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos5_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos5_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos5_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos5_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos5_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos5_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos5_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos5_tim = " + "'Ρ.Visanto'" + "OR eidos5_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos5_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos5_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos5_tim = " + "'Asti Martini'"
					+ "OR eidos5_tim = " + "'Asti μικρή'"
					+ "OR eidos5_tim = " + "'Gordon Rouge'"
					+ "OR eidos5_tim = " + "'Moschato D Asti'"
					+ "OR eidos5_tim = " + "'Dom Perignon'"
					+ "OR eidos5_tim = " + "'Moet et Chandon'"
					+ "OR eidos5_tim = " + "'Veuve Clickuot'"
					+ "OR eidos5_tim = " + "'Veuve aperitif'"
					+ "OR eidos6_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos6_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos6_tim = " + "'Λ.Μικρός'"
					+ "OR eidos6_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos6_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos6_tim = " + "'Λ.Βιβλία'" + "OR eidos6_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos6_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos6_tim = " + "'Λ.Ευπορία'" + "OR eidos6_tim = "
					+ "'Λ.Isari'" + "OR eidos6_tim = " + "'Λ.Cirinon'"
					+ "OR eidos6_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos6_tim = "
					+ "'Κ.Cirinon'" + "OR eidos6_tim = " + "'Κ.Idonida'"
					+ "OR eidos6_tim = " + "'Κ.Isari'" + "OR eidos6_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos6_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos6_tim = " + "'Κ.Chateau'" + "OR eidos6_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos6_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos6_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos6_tim = " + "'Κ.Μικρός'" + "OR eidos6_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos6_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos6_tim = " + "'Ρ.Βιβλία'" + "OR eidos6_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos6_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos6_tim = " + "'Ρ.Cirinon'" + "OR eidos6_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos6_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos6_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos6_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos6_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos6_tim = "
					+ "'Λ.Sangria'" + "OR eidos6_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Λ.Αμέθυστος'" + "OR eidos6_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos6_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos6_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos6_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos6_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos6_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos6_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos6_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos6_tim = "
					+ "'Λ.Visanto'" + "OR eidos6_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos6_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos6_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos6_tim = " + "'Κ.Sangria'"
					+ "OR eidos6_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Κ.Αμέθυστος'" + "OR eidos6_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos6_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos6_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos6_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos6_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos6_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos6_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos6_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos6_tim = "
					+ "'Κ.Visanto'" + "OR eidos6_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos6_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos6_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos6_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos6_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos6_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos6_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos6_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos6_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos6_tim = " + "'Ρ.Visanto'" + "OR eidos6_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos6_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos6_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos6_tim = " + "'Asti Martini'"
					+ "OR eidos6_tim = " + "'Asti μικρή'"
					+ "OR eidos6_tim = " + "'Gordon Rouge'"
					+ "OR eidos6_tim = " + "'Moschato D Asti'"
					+ "OR eidos6_tim = " + "'Dom Perignon'"
					+ "OR eidos6_tim = " + "'Moet et Chandon'"
					+ "OR eidos6_tim = " + "'Veuve Clickuot'"
					+ "OR eidos6_tim = " + "'Veuve aperitif'"
					+ "OR eidos7_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos7_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos7_tim = " + "'Λ.Μικρός'"
					+ "OR eidos7_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos7_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos7_tim = " + "'Λ.Βιβλία'" + "OR eidos7_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos7_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos7_tim = " + "'Λ.Ευπορία'" + "OR eidos7_tim = "
					+ "'Λ.Isari'" + "OR eidos7_tim = " + "'Λ.Cirinon'"
					+ "OR eidos7_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos7_tim = "
					+ "'Κ.Cirinon'" + "OR eidos7_tim = " + "'Κ.Idonida'"
					+ "OR eidos7_tim = " + "'Κ.Isari'" + "OR eidos7_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos7_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos7_tim = " + "'Κ.Chateau'" + "OR eidos7_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos7_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos7_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos7_tim = " + "'Κ.Μικρός'" + "OR eidos7_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos7_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos7_tim = " + "'Ρ.Βιβλία'" + "OR eidos7_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos7_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos7_tim = " + "'Ρ.Cirinon'" + "OR eidos7_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos7_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos7_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos7_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos7_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos7_tim = "
					+ "'Λ.Sangria'" + "OR eidos7_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Λ.Αμέθυστος'" + "OR eidos7_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos7_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos7_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos7_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos7_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos7_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos7_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos7_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos7_tim = "
					+ "'Λ.Visanto'" + "OR eidos7_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos7_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos7_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos7_tim = " + "'Κ.Sangria'"
					+ "OR eidos7_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Κ.Αμέθυστος'" + "OR eidos7_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos7_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos7_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos7_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos7_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos7_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos7_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos7_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos7_tim = "
					+ "'Κ.Visanto'" + "OR eidos7_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos7_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos7_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos7_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos7_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos7_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos7_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos7_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos7_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos7_tim = " + "'Ρ.Visanto'" + "OR eidos7_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos7_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos7_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos7_tim = " + "'Asti Martini'"
					+ "OR eidos7_tim = " + "'Asti μικρή'"
					+ "OR eidos7_tim = " + "'Gordon Rouge'"
					+ "OR eidos7_tim = " + "'Moschato D Asti'"
					+ "OR eidos7_tim = " + "'Dom Perignon'"
					+ "OR eidos7_tim = " + "'Moet et Chandon'"
					+ "OR eidos7_tim = " + "'Veuve Clickuot'"
					+ "OR eidos7_tim = " + "'Veuve aperitif'"
					+ "OR eidos8_tim = " + "'Λ.Ντάμα κούπα'"
					+ "OR eidos8_tim = "
					+ "'Λ.Χρυσός Λέων'" + "OR eidos8_tim = " + "'Λ.Μικρός'"
					+ "OR eidos8_tim = " + "'Λ.Τέχνη Αλυπίας'"
					+ "OR eidos8_tim = " + "'Λ.Τέχνη Μαλαγού'"
					+ "OR eidos8_tim = " + "'Λ.Βιβλία'" + "OR eidos8_tim = "
					+ "'Λ.Αγκαθιά'" + "OR eidos8_tim = " + "'Λ.Μαγική πλαγιά'"
					+ "OR eidos8_tim = " + "'Λ.Ευπορία'" + "OR eidos8_tim = "
					+ "'Λ.Isari'" + "OR eidos8_tim = " + "'Λ.Cirinon'"
					+ "OR eidos8_tim = " + "'Κ.Βόρεια Γη'" + "OR eidos8_tim = "
					+ "'Κ.Cirinon'" + "OR eidos8_tim = " + "'Κ.Idonida'"
					+ "OR eidos8_tim = " + "'Κ.Isari'" + "OR eidos8_tim = "
					+ "'Κ.Τέχνη Αλυπίας'" + "OR eidos8_tim = " + "'Κ.Βιβλία'"
					+ "OR eidos8_tim = " + "'Κ.Chateau'" + "OR eidos8_tim = "
					+ "'Κ.Ρήγας κούπα'" + "OR eidos8_tim = " + "'Κ.Μαγικό'"
					+ "OR eidos8_tim = " + "'Κ.Μαύρος κύκνος'"
					+ "OR eidos8_tim = " + "'Κ.Μικρός'" + "OR eidos8_tim = "
					+ "'Ρ.Τέχνη Αλυπίας'" + "OR eidos8_tim = " + "'Ρ.Σκέρτσο'"
					+ "OR eidos8_tim = " + "'Ρ.Βιβλία'" + "OR eidos8_tim = "
					+ "'Ρ.Μικρός'" + "OR eidos8_tim = " + "'Ρ.Λαλίκος'"
					+ "OR eidos8_tim = " + "'Ρ.Cirinon'" + "OR eidos8_tim = "
					+ "'Λ.Μοσχοφίλερο μικρό'" + "OR eidos8_tim = "
					+ "'Λ.Μοσχοφίλερο μεγάλο'" + "OR eidos8_tim = "
					+ "'Λ.Ρωμαλίδης'" + "OR eidos8_tim = " + "'Λ.Μπίσκας'"
					+ "OR eidos8_tim = " + "'Λ.Ημίγλυκο'" + "OR eidos8_tim = "
					+ "'Λ.Sangria'" + "OR eidos8_tim = " + "'Λ.Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Λ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Λ.Αμέθυστος'" + "OR eidos8_tim = "
					+ "'Λ.Thema Παυλίδη'" + "OR eidos8_tim = "
					+ "'Λ.Κτήμα Άλφα'" + "OR eidos8_tim = "
					+ "'Λ.Μελισσόπετρα'" + "OR eidos8_tim = "
					+ "'Λ.Μαγικό Βουνό'" + "OR eidos8_tim = "
					+ "'Λ.Κτήμα Αβαντίς'" + "OR eidos8_tim = "
					+ "'Λ.Αβαντίς Charisma'" + "OR eidos8_tim = "
					+ "'Λ.Chateau Ν.Λαζαρίδη'" + "OR eidos8_tim = "
					+ "'Λ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos8_tim = "
					+ "'Λ.Visanto'" + "OR eidos8_tim = "
					+ "'Κ.Αγιωργίτικο μικρό'" + "OR eidos8_tim = "
					+ "'Κ.Ημίγλυκο μελίρρυτο μικρό'" + "OR eidos8_tim = "
					+ "'Κ.Ημίγλυκο 750ML'" + "OR eidos8_tim = " + "'Κ.Sangria'"
					+ "OR eidos8_tim = " + "'Κ.Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Κ.Chardonnay Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Κ.Αμέθυστος'" + "OR eidos8_tim = "
					+ "'Κ.Thema Παυλίδη'" + "OR eidos8_tim = "
					+ "'Κ.Κτήμα Άλφα'" + "OR eidos8_tim = "
					+ "'Κ.Μελισσόπετρα'" + "OR eidos8_tim = "
					+ "'Κ.Μαγικό Βουνό'" + "OR eidos8_tim = "
					+ "'Κ.Κτήμα Αβαντίς'" + "OR eidos8_tim = "
					+ "'Κ.Αβαντίς Charisma'" + "OR eidos8_tim = "
					+ "'Κ.Chateau Ν.Λαζαρίδη'" + "OR eidos8_tim = "
					+ "'Κ.Χατζηβαρύτη Γουμένισσα'" + "OR eidos8_tim = "
					+ "'Κ.Visanto'" + "OR eidos8_tim = " + "'Ρ.Γεροβασιλείου'"
					+ "OR eidos8_tim = " + "'Ρ.Thema Παυλίδη'"
					+ "OR eidos8_tim = " + "'Ρ.Κτήμα Άλφα'"
					+ "OR eidos8_tim = " + "'Ρ.Μελισσόπετρα'"
					+ "OR eidos8_tim = " + "'Ρ.Μαγικό Βουνό'"
					+ "OR eidos8_tim = " + "'Ρ.Κτήμα Αβαντίς'"
					+ "OR eidos8_tim = " + "'Ρ.Αβαντίς Charisma'"
					+ "OR eidos8_tim = " + "'Ρ.Chateau Ν.Λαζαρίδη'"
					+ "OR eidos8_tim = " + "'Ρ.Χατζηβαρύτη Γουμένισσα'"
					+ "OR eidos8_tim = " + "'Ρ.Visanto'" + "OR eidos8_tim = "
					+ "'Ξινόμαυρο Σκατζόχοιρος άλφα'" 
					+ "OR eidos8_tim = " + "'Λ.Sandeman Porto'"
					+ "OR eidos8_tim = " + "'Κ.Sandeman Porto'"
					+ "OR eidos8_tim = " + "'Asti Martini'"
					+ "OR eidos8_tim = " + "'Asti μικρή'"
					+ "OR eidos8_tim = " + "'Gordon Rouge'"
					+ "OR eidos8_tim = " + "'Moschato D Asti'"
					+ "OR eidos8_tim = " + "'Dom Perignon'"
					+ "OR eidos8_tim = " + "'Moet et Chandon'"
					+ "OR eidos8_tim = " + "'Veuve Clickuot'"
					+ "OR eidos8_tim = " + "'Veuve aperitif'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumOuza_tsipoura() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos1_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos1_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos1_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos1_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos1_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos1_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos1_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos1_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos1_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos1_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos1_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos1_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos1_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos1_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos2_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos2_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos2_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos2_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos2_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos2_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos2_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos2_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos2_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos2_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos2_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos2_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos2_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos2_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos2_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos3_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos3_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos3_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos3_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos3_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos3_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos3_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos3_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos3_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos3_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos3_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos3_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos3_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos3_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos3_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos4_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos4_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos4_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos4_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos4_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos4_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos4_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos4_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos4_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos4_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos4_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos4_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos4_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos4_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos4_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos5_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos5_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos5_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos5_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos5_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos5_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos5_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos5_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos5_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos5_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos5_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos5_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos5_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos5_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos5_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos6_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos6_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos6_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos6_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos6_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos6_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos6_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos6_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos6_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos6_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos6_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos6_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos6_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos6_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos6_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos7_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos7_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos7_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos7_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos7_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos7_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos7_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos7_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos7_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos7_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos7_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos7_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos7_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos7_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos7_tim = "
				+ "'T.Βλαδίκα(χύμα)'"
				+ "OR eidos8_tim = "
				+ "'Αλεξανδρίδη(100ml)'"
				+ "OR eidos8_tim = "
				+ "'φραγκουλά(100ml)'"
				+ "OR eidos8_tim = "
				+ "'Κουλάς(100ml)'"
				+ "OR eidos8_tim = "
				+ "'Μπέη(100ml)'"
				+ "OR eidos8_tim = "
				+ "'Πεντάρι(100ml)'"
				+ "OR eidos8_tim = "
				+ "'Αλεξανδρίδη(200ml)'"
				+ "OR eidos8_tim = "
				+ "'Φραγκουλά(200ml)'"
				+ "OR eidos8_tim = "
				+ "'Μπεσίρη(200ml)'"
				+ "OR eidos8_tim = "
				+ "'Κουλάς(200ml)'"
				+ "OR eidos8_tim = "
				+ "'Μπέη(200ml)'"
				+ "OR eidos8_tim = "
				+ "'Πεντάρι(200ml)'"
				+ "OR eidos8_tim = "
				+ "'T.Γιώμα Πέντ(200ml)'"
				+ "OR eidos8_tim = "
				+ "'T.Αλεξανδρίδη(200ml)'"
				+ "OR eidos8_tim = "
				+ "'T.Αγιονέρι(χύμα)'"
				+ "OR eidos8_tim = "
				+ "'T.Βλαδίκα(χύμα)'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumTrofima() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos1_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos1_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos1_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos1_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos1_tim = "
				+ "'κάπαρη'"
				+ "OR eidos1_tim = "
				+ "'πέννες'"
				+ "OR eidos1_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos1_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos1_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos1_tim = "
				+ "'μέλι'"
				+ "OR eidos1_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos1_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos1_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos1_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos1_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos1_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos1_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos1_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos1_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos1_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos1_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos1_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos1_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos1_tim = "
				+ "'αυγά'"
				+ "OR eidos1_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos1_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos1_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos1_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos1_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos1_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos1_tim = "
				+ "'soya sause'"
				+ "OR eidos1_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos1_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos1_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos1_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos1_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos1_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos1_tim = "
				+ "'κάπαρη'"
				+ "OR eidos1_tim = "
				+ "'πέννες'"
				+ "OR eidos1_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos1_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos1_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos1_tim = "
				+ "'μέλι'"
				+ "OR eidos1_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos1_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos1_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos1_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos1_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos1_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos1_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos1_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos1_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos1_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos1_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos1_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos1_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos1_tim = "
				+ "'αυγά'"
				+ "OR eidos1_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos1_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos1_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos1_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos1_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos1_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos1_tim = "
				+ "'soya sause'"
				+ "OR eidos1_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos1_tim = "
				+ "'πάγος'"
				+ "OR eidos1_tim = "
				+ "'cranberry'"
				+ "OR eidos1_tim = "
				+ "'μέλι'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos1_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos1_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos2_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos2_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos2_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos2_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos2_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos2_tim = "
				+ "'κάπαρη'"
				+ "OR eidos2_tim = "
				+ "'πέννες'"
				+ "OR eidos2_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos2_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos2_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos2_tim = "
				+ "'μέλι'"
				+ "OR eidos2_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos2_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos2_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos2_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos2_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos2_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos2_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos2_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos2_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos2_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos2_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos2_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos2_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos2_tim = "
				+ "'αυγά'"
				+ "OR eidos2_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos2_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos2_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos2_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos2_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos2_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos2_tim = "
				+ "'soya sause'"
				+ "OR eidos2_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos2_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos2_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos2_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos2_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos2_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos2_tim = "
				+ "'κάπαρη'"
				+ "OR eidos2_tim = "
				+ "'πέννες'"
				+ "OR eidos2_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos2_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos2_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos2_tim = "
				+ "'μέλι'"
				+ "OR eidos2_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos2_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos2_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos2_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos2_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos2_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos2_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos2_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos2_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos2_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos2_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos2_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos2_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos2_tim = "
				+ "'αυγά'"
				+ "OR eidos2_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos2_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos2_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos2_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos2_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos2_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos2_tim = "
				+ "'soya sause'"
				+ "OR eidos2_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos2_tim = "
				+ "'πάγος'"
				+ "OR eidos2_tim = "
				+ "'cranberry'"
				+ "OR eidos2_tim = "
				+ "'μέλι'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos2_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos2_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos3_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos3_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos3_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos3_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos3_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos3_tim = "
				+ "'κάπαρη'"
				+ "OR eidos3_tim = "
				+ "'πέννες'"
				+ "OR eidos3_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos3_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos3_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos3_tim = "
				+ "'μέλι'"
				+ "OR eidos3_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos3_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos3_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos3_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos3_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos3_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos3_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos3_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos3_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos3_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos3_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos3_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos3_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos3_tim = "
				+ "'αυγά'"
				+ "OR eidos3_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos3_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos3_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos3_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos3_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos3_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos3_tim = "
				+ "'soya sause'"
				+ "OR eidos3_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos3_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos3_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos3_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos3_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos3_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos3_tim = "
				+ "'κάπαρη'"
				+ "OR eidos3_tim = "
				+ "'πέννες'"
				+ "OR eidos3_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos3_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos3_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos3_tim = "
				+ "'μέλι'"
				+ "OR eidos3_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos3_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos3_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos3_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos3_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos3_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos3_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos3_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos3_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos3_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos3_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos3_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos3_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos3_tim = "
				+ "'αυγά'"
				+ "OR eidos3_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos3_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos3_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos3_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos3_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos3_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos3_tim = "
				+ "'soya sause'"
				+ "OR eidos3_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos3_tim = "
				+ "'πάγος'"
				+ "OR eidos3_tim = "
				+ "'cranberry'"
				+ "OR eidos3_tim = "
				+ "'μέλι'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos3_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos3_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos4_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos4_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos4_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos4_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos4_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos4_tim = "
				+ "'κάπαρη'"
				+ "OR eidos4_tim = "
				+ "'πέννες'"
				+ "OR eidos4_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos4_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos4_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos4_tim = "
				+ "'μέλι'"
				+ "OR eidos4_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos4_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos4_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos4_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos4_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos4_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos4_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos4_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos4_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos4_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos4_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos4_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos4_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos4_tim = "
				+ "'αυγά'"
				+ "OR eidos4_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos4_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos4_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos4_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos4_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos4_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos4_tim = "
				+ "'soya sause'"
				+ "OR eidos4_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos4_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos4_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos4_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos4_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos4_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos4_tim = "
				+ "'κάπαρη'"
				+ "OR eidos4_tim = "
				+ "'πέννες'"
				+ "OR eidos4_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos4_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos4_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos4_tim = "
				+ "'μέλι'"
				+ "OR eidos4_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos4_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos4_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos4_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos4_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos4_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos4_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos4_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos4_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos4_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos4_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos4_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos4_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos4_tim = "
				+ "'αυγά'"
				+ "OR eidos4_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos4_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos4_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos4_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos4_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos4_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos4_tim = "
				+ "'soya sause'"
				+ "OR eidos4_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos4_tim = "
				+ "'πάγος'"
				+ "OR eidos4_tim = "
				+ "'cranberry'"
				+ "OR eidos4_tim = "
				+ "'μέλι'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos4_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos4_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos5_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos5_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos5_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos5_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos5_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos5_tim = "
				+ "'κάπαρη'"
				+ "OR eidos5_tim = "
				+ "'πέννες'"
				+ "OR eidos5_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos5_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos5_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos5_tim = "
				+ "'μέλι'"
				+ "OR eidos5_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos5_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos5_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos5_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos5_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos5_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos5_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos5_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos5_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos5_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos5_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos5_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos5_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos5_tim = "
				+ "'αυγά'"
				+ "OR eidos5_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos5_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos5_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos5_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos5_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos5_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos5_tim = "
				+ "'soya sause'"
				+ "OR eidos5_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos5_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos5_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos5_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos5_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos5_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos5_tim = "
				+ "'κάπαρη'"
				+ "OR eidos5_tim = "
				+ "'πέννες'"
				+ "OR eidos5_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos5_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos5_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos5_tim = "
				+ "'μέλι'"
				+ "OR eidos5_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos5_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos5_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos5_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos5_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos5_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos5_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos5_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos5_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos5_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos5_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos5_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos5_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos5_tim = "
				+ "'αυγά'"
				+ "OR eidos5_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos5_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos5_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos5_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos5_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos5_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos5_tim = "
				+ "'soya sause'"
				+ "OR eidos5_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos5_tim = "
				+ "'πάγος'"
				+ "OR eidos5_tim = "
				+ "'cranberry'"
				+ "OR eidos5_tim = "
				+ "'μέλι'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos5_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos5_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos6_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos6_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos6_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos6_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos6_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos6_tim = "
				+ "'κάπαρη'"
				+ "OR eidos6_tim = "
				+ "'πέννες'"
				+ "OR eidos6_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos6_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos6_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos6_tim = "
				+ "'μέλι'"
				+ "OR eidos6_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos6_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos6_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos6_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos6_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos6_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos6_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos6_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos6_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos6_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos6_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos6_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos6_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos6_tim = "
				+ "'αυγά'"
				+ "OR eidos6_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos6_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos6_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos6_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos6_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos6_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos6_tim = "
				+ "'soya sause'"
				+ "OR eidos6_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos6_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos6_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos6_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos6_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos6_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos6_tim = "
				+ "'κάπαρη'"
				+ "OR eidos6_tim = "
				+ "'πέννες'"
				+ "OR eidos6_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos6_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos6_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos6_tim = "
				+ "'μέλι'"
				+ "OR eidos6_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos6_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos6_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos6_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos6_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos6_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos6_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos6_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos6_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos6_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos6_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos6_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos6_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos6_tim = "
				+ "'αυγά'"
				+ "OR eidos6_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos6_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos6_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos6_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos6_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos6_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos6_tim = "
				+ "'soya sause'"
				+ "OR eidos6_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos6_tim = "
				+ "'πάγος'"
				+ "OR eidos6_tim = "
				+ "'cranberry'"
				+ "OR eidos6_tim = "
				+ "'μέλι'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos6_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos6_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos7_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos7_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos7_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos7_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos7_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos7_tim = "
				+ "'κάπαρη'"
				+ "OR eidos7_tim = "
				+ "'πέννες'"
				+ "OR eidos7_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos7_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos7_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos7_tim = "
				+ "'μέλι'"
				+ "OR eidos7_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos7_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos7_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos7_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos7_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos7_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos7_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos7_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos7_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos7_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos7_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos7_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos7_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos7_tim = "
				+ "'αυγά'"
				+ "OR eidos7_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos7_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos7_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos7_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos7_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos7_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos7_tim = "
				+ "'soya sause'"
				+ "OR eidos7_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos7_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos7_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos7_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos7_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos7_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos7_tim = "
				+ "'κάπαρη'"
				+ "OR eidos7_tim = "
				+ "'πέννες'"
				+ "OR eidos7_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos7_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos7_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos7_tim = "
				+ "'μέλι'"
				+ "OR eidos7_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos7_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos7_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos7_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos7_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos7_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos7_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos7_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos7_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos7_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos7_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos7_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos7_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos7_tim = "
				+ "'αυγά'"
				+ "OR eidos7_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos7_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos7_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos7_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos7_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos7_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos7_tim = "
				+ "'soya sause'"
				+ "OR eidos7_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos7_tim = "
				+ "'πάγος'"
				+ "OR eidos7_tim = "
				+ "'cranberry'"
				+ "OR eidos7_tim = "
				+ "'μέλι'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι βύσσινο'"
				+ "OR eidos7_tim = "
				+ "'σιρόπι καρύδα'"
				+ "OR eidos7_tim = "
				+ "'πιτάκια Select'"
				+ "OR eidos8_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos8_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos8_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos8_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos8_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos8_tim = "
				+ "'κάπαρη'"
				+ "OR eidos8_tim = "
				+ "'πέννες'"
				+ "OR eidos8_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos8_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos8_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos8_tim = "
				+ "'μέλι'"
				+ "OR eidos8_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos8_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos8_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos8_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos8_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos8_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos8_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos8_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos8_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos8_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos8_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos8_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos8_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos8_tim = "
				+ "'αυγά'"
				+ "OR eidos8_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos8_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos8_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos8_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos8_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos8_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos8_tim = "
				+ "'soya sause'"
				+ "OR eidos8_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos8_tim = "
				+ "'χυμός λεμονιού'"
				+ "OR eidos8_tim = "
				+ "'καλαμάρι κατεψυγμένο'"
				+ "OR eidos8_tim = "
				+ "'πορτοκάλι γλυκό'"
				+ "OR eidos8_tim = "
				+ "'σύκα αποξηραμένα'"
				+ "OR eidos8_tim = "
				+ "'ψωμάκια burger'"
				+ "OR eidos8_tim = "
				+ "'κάπαρη'"
				+ "OR eidos8_tim = "
				+ "'πέννες'"
				+ "OR eidos8_tim = "
				+ "'λινγκουϊνι'"
				+ "OR eidos8_tim = "
				+ "'κουβερτούρα'"
				+ "OR eidos8_tim = "
				+ "'μπασμάζι'"
				+ "OR eidos8_tim = "
				+ "'μέλι'"
				+ "OR eidos8_tim = "
				+ "'μπαγκετάκια μικρά'"
				+ "OR eidos8_tim = "
				+ "'ψωμί τόστ'"
				+ "OR eidos8_tim = "
				+ "'καλαμπόκι'"
				+ "OR eidos8_tim = "
				+ "'μπαγιάτικο ψωμί για κιμά'"
				+ "OR eidos8_tim = "
				+ "'πεστό βασιλικού'"
				+ "OR eidos8_tim = "
				+ "'ελαιόλαδο'"
				+ "OR eidos8_tim = "
				+ "'σπορέλαιο'"
				+ "OR eidos8_tim = "
				+ "'σκουμπρί καπνιστό με ρίγανη'"
				+ "OR eidos8_tim = "
				+ "'μπαγκέτα λευκή'"
				+ "OR eidos8_tim = "
				+ "'μπαγκέτα μάυρη'"
				+ "OR eidos8_tim = "
				+ "'μπαγκετάκι λευκό'"
				+ "OR eidos8_tim = "
				+ "'γαρίδες Νο1'"
				+ "OR eidos8_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos8_tim = "
				+ "'αυγά'"
				+ "OR eidos8_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos8_tim = "
				+ "'καπνιστός σολωμός'"
				+ "OR eidos8_tim = "
				+ "'χαβιάρι'"
				+ "OR eidos8_tim = "
				+ "'παπαρδέλες'"
				+ "OR eidos8_tim = "
				+ "'αρμπόριο'"
				+ "OR eidos8_tim = "
				+ "'μπασμάτι'"
				+ "OR eidos8_tim = "
				+ "'soya sause'"
				+ "OR eidos8_tim = "
				+ "'μύδια με κέλυφος'"
				+ "OR eidos8_tim = "
				+ "'πάγος'"
				+ "OR eidos8_tim = "
				+ "'cranberry'"
				+ "OR eidos8_tim = "
				+ "'μέλι'"
				+ "OR eidos8_tim = "
				+ "'σιρόπι βανίλια'"
				+ "OR eidos8_tim = "
				+ "'σιρόπι καραμέλα'"
				+ "OR eidos8_tim = "
				+ "'σιρόπι φράουλα'"
				+ "OR eidos8_tim = "
				+ "'σιρόπι φουντούκι'"
				+ "OR eidos8_tim = "
				+ "'σιρόπι βύσσινο'" + "OR eidos8_tim = " + "'σιρόπι καρύδα'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumSinodeutika() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'πατατάκια'"
				+ "OR eidos1_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos1_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos1_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos1_tim = "
				+ "'φυστίκια'"
				+ "OR eidos1_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos1_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos1_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos1_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos1_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos1_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos1_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos1_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos1_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos1_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos1_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos1_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos2_tim = "
				+ "'πατατάκια'"
				+ "OR eidos2_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos2_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos2_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos2_tim = "
				+ "'φυστίκια'"
				+ "OR eidos2_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos2_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos2_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos2_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos2_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos2_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos2_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos2_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos2_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos2_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos2_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos2_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos3_tim = "
				+ "'πατατάκια'"
				+ "OR eidos3_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos3_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos3_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos3_tim = "
				+ "'φυστίκια'"
				+ "OR eidos3_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos3_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos3_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos3_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos3_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos3_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos3_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos3_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos3_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos3_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos3_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos3_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos4_tim = "
				+ "'πατατάκια'"
				+ "OR eidos4_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos4_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos4_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos4_tim = "
				+ "'φυστίκια'"
				+ "OR eidos4_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos4_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos4_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos4_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos4_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos4_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos4_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos4_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos4_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos4_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos4_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos4_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos5_tim = "
				+ "'πατατάκια'"
				+ "OR eidos5_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos5_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos5_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos5_tim = "
				+ "'φυστίκια'"
				+ "OR eidos5_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos5_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos5_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos5_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos5_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos5_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos5_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos5_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos5_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos5_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos5_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos5_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos6_tim = "
				+ "'πατατάκια'"
				+ "OR eidos6_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos6_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos6_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos6_tim = "
				+ "'φυστίκια'"
				+ "OR eidos6_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos6_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos6_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos6_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos6_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos6_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos6_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos6_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos6_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos6_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos6_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos6_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos7_tim = "
				+ "'πατατάκια'"
				+ "OR eidos7_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos7_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos7_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos7_tim = "
				+ "'φυστίκια'"
				+ "OR eidos7_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos7_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos7_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos7_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos7_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos7_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos7_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos7_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos7_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos7_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos7_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos7_tim = "
				+ "'κορπή ανθρακ.'"
				+ "OR eidos8_tim = "
				+ "'πατατάκια'"
				+ "OR eidos8_tim = "
				+ "'κουλουράκια'"
				+ "OR eidos8_tim = "
				+ "'φυστίκια Αιγίνης'"
				+ "OR eidos8_tim = "
				+ "'φιλέ-αμύγλαδο'"
				+ "OR eidos8_tim = "
				+ "'φυστίκια'"
				+ "OR eidos8_tim = "
				+ "'μαρασκίνο'"
				+ "OR eidos8_tim = "
				+ "'μαγιονέζα'"
				+ "OR eidos8_tim = "
				+ "'κέτσαπ'"
				+ "OR eidos8_tim = "
				+ "'μουστάρδα'"
				+ "OR eidos8_tim = "
				+ "'φύλλα Τορτίγιας'"
				+ "OR eidos8_tim = "
				+ "'γλυκόξινη σάλτσα'"
				+ "OR eidos8_tim = "
				+ "'στικ μουστάρδα'"
				+ "OR eidos8_tim = "
				+ "'κριτσίνια πολύσπορα'"
				+ "OR eidos8_tim = "
				+ "'κριτσίνια καλαμπόκι'"
				+ "OR eidos8_tim = "
				+ "'νερό μικρό'"
				+ "OR eidos8_tim = "
				+ "'νερό μεγάλο'"
				+ "OR eidos8_tim = "
				+ "'κορπή ανθρακ.'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumOuiskia() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Johnie'"
				+ "OR eidos1_tim = "
				+ "'Johnie black'"
				+ "OR eidos1_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos1_tim = "
				+ "'Johnie gold'"
				+ "OR eidos1_tim = "
				+ "'Johnie blue'"
				+ "OR eidos1_tim = "
				+ "'Dewars'"
				+ "OR eidos1_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos1_tim = "
				+ "'Famous'"
				+ "OR eidos1_tim = "
				+ "'Haig'"
				+ "OR eidos1_tim = "
				+ "'Ballandines'"
				+ "OR eidos1_tim = "
				+ "'Bells'"
				+ "OR eidos1_tim = "
				+ "'Grands'"
				+ "OR eidos1_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos1_tim = "
				+ "'Teachers'"
				+ "OR eidos1_tim = "
				+ "'J&B'"
				+ "OR eidos1_tim = "
				+ "'Jim Beam'"
				+ "OR eidos1_tim = "
				+ "'Four Roses'"
				+ "OR eidos1_tim = "
				+ "'Canadian'"
				+ "OR eidos1_tim = "
				+ "'Jameson'"
				+ "OR eidos1_tim = "
				+ "'Bushmills'"
				+ "OR eidos1_tim = "
				+ "'Comfort'"
				+ "OR eidos1_tim = "
				+ "'Tullamore'"
				+ "OR eidos1_tim = "
				+ "'Jameson 12'"
				+ "OR eidos1_tim = "
				+ "'Jack'"
				+ "OR eidos1_tim = "
				+ "'Dimple'"
				+ "OR eidos1_tim = "
				+ "'Chivas'"
				+ "OR eidos1_tim = "
				+ "'Cardhu'"
				+ "OR eidos1_tim = "
				+ "'Cutty 12'"
				+ "OR eidos1_tim = "
				+ "'Cutty 15'"
				+ "OR eidos1_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos1_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos1_tim = "
				+ "'Oban'"
				+ "OR eidos1_tim = "
				+ "'Lagavulin'"
				+ "OR eidos1_tim = "
				+ "'Macallan'"
				+ "OR eidos1_tim = "
				+ "'Johnie green'"
				+ "OR eidos1_tim = "
				+ "'Makers Mark'"
				+ "OR eidos1_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos1_tim = "
				+ "'Comfort lime'"
				+ "OR eidos1_tim = "
				+ "'Cutty 18'"
				+ "OR eidos1_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos1_tim = "
				+ "'Glenlivet'"
				+ "OR eidos1_tim = "
				+ "'Talisker'"
				+ "OR eidos1_tim = "
				+ "'Dalmore'"
				+ "OR eidos1_tim = "
				+ "'Gragganmore'"
				+ "OR eidos1_tim = "
				+ "'Caol ila'"
				+ "OR eidos2_tim = "
				+ "'Johnie'"
				+ "OR eidos2_tim = "
				+ "'Johnie black'"
				+ "OR eidos2_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos2_tim = "
				+ "'Johnie gold'"
				+ "OR eidos2_tim = "
				+ "'Johnie blue'"
				+ "OR eidos2_tim = "
				+ "'Dewars'"
				+ "OR eidos2_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos2_tim = "
				+ "'Famous'"
				+ "OR eidos2_tim = "
				+ "'Haig'"
				+ "OR eidos2_tim = "
				+ "'Ballandines'"
				+ "OR eidos2_tim = "
				+ "'Bells'"
				+ "OR eidos2_tim = "
				+ "'Grands'"
				+ "OR eidos2_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos2_tim = "
				+ "'Teachers'"
				+ "OR eidos2_tim = "
				+ "'J&B'"
				+ "OR eidos2_tim = "
				+ "'Jim Beam'"
				+ "OR eidos2_tim = "
				+ "'Four Roses'"
				+ "OR eidos2_tim = "
				+ "'Canadian'"
				+ "OR eidos2_tim = "
				+ "'Jameson'"
				+ "OR eidos2_tim = "
				+ "'Bushmills'"
				+ "OR eidos2_tim = "
				+ "'Comfort'"
				+ "OR eidos2_tim = "
				+ "'Tullamore'"
				+ "OR eidos2_tim = "
				+ "'Jameson 12'"
				+ "OR eidos2_tim = "
				+ "'Jack'"
				+ "OR eidos2_tim = "
				+ "'Dimple'"
				+ "OR eidos2_tim = "
				+ "'Chivas'"
				+ "OR eidos2_tim = "
				+ "'Cardhu'"
				+ "OR eidos2_tim = "
				+ "'Cutty 12'"
				+ "OR eidos2_tim = "
				+ "'Cutty 15'"
				+ "OR eidos2_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos2_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos2_tim = "
				+ "'Oban'"
				+ "OR eidos2_tim = "
				+ "'Lagavulin'"
				+ "OR eidos2_tim = "
				+ "'Macallan'"
				+ "OR eidos2_tim = "
				+ "'Johnie green'"
				+ "OR eidos2_tim = "
				+ "'Makers Mark'"
				+ "OR eidos2_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos2_tim = "
				+ "'Comfort lime'"
				+ "OR eidos2_tim = "
				+ "'Cutty 18'"
				+ "OR eidos2_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos2_tim = "
				+ "'Glenlivet'"
				+ "OR eidos2_tim = "
				+ "'Talisker'"
				+ "OR eidos2_tim = "
				+ "'Dalmore'"
				+ "OR eidos2_tim = "
				+ "'Gragganmore'"
				+ "OR eidos2_tim = "
				+ "'Caol ila'"
				+ "OR eidos3_tim = "
				+ "'Johnie'"
				+ "OR eidos3_tim = "
				+ "'Johnie black'"
				+ "OR eidos3_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos3_tim = "
				+ "'Johnie gold'"
				+ "OR eidos3_tim = "
				+ "'Johnie blue'"
				+ "OR eidos3_tim = "
				+ "'Dewars'"
				+ "OR eidos3_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos3_tim = "
				+ "'Famous'"
				+ "OR eidos3_tim = "
				+ "'Haig'"
				+ "OR eidos3_tim = "
				+ "'Ballandines'"
				+ "OR eidos3_tim = "
				+ "'Bells'"
				+ "OR eidos3_tim = "
				+ "'Grands'"
				+ "OR eidos3_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos3_tim = "
				+ "'Teachers'"
				+ "OR eidos3_tim = "
				+ "'J&B'"
				+ "OR eidos3_tim = "
				+ "'Jim Beam'"
				+ "OR eidos3_tim = "
				+ "'Four Roses'"
				+ "OR eidos3_tim = "
				+ "'Canadian'"
				+ "OR eidos3_tim = "
				+ "'Jameson'"
				+ "OR eidos3_tim = "
				+ "'Bushmills'"
				+ "OR eidos3_tim = "
				+ "'Comfort'"
				+ "OR eidos3_tim = "
				+ "'Tullamore'"
				+ "OR eidos3_tim = "
				+ "'Jameson 12'"
				+ "OR eidos3_tim = "
				+ "'Jack'"
				+ "OR eidos3_tim = "
				+ "'Dimple'"
				+ "OR eidos3_tim = "
				+ "'Chivas'"
				+ "OR eidos3_tim = "
				+ "'Cardhu'"
				+ "OR eidos3_tim = "
				+ "'Cutty 12'"
				+ "OR eidos3_tim = "
				+ "'Cutty 15'"
				+ "OR eidos3_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos3_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos3_tim = "
				+ "'Oban'"
				+ "OR eidos3_tim = "
				+ "'Lagavulin'"
				+ "OR eidos3_tim = "
				+ "'Macallan'"
				+ "OR eidos3_tim = "
				+ "'Johnie green'"
				+ "OR eidos3_tim = "
				+ "'Makers Mark'"
				+ "OR eidos3_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos3_tim = "
				+ "'Comfort lime'"
				+ "OR eidos3_tim = "
				+ "'Cutty 18'"
				+ "OR eidos3_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos3_tim = "
				+ "'Glenlivet'"
				+ "OR eidos3_tim = "
				+ "'Talisker'"
				+ "OR eidos3_tim = "
				+ "'Dalmore'"
				+ "OR eidos3_tim = "
				+ "'Gragganmore'"
				+ "OR eidos3_tim = "
				+ "'Caol ila'"
				+ "OR eidos4_tim = "
				+ "'Johnie'"
				+ "OR eidos4_tim = "
				+ "'Johnie black'"
				+ "OR eidos4_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos4_tim = "
				+ "'Johnie gold'"
				+ "OR eidos4_tim = "
				+ "'Johnie blue'"
				+ "OR eidos4_tim = "
				+ "'Dewars'"
				+ "OR eidos4_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos4_tim = "
				+ "'Famous'"
				+ "OR eidos4_tim = "
				+ "'Haig'"
				+ "OR eidos4_tim = "
				+ "'Ballandines'"
				+ "OR eidos4_tim = "
				+ "'Bells'"
				+ "OR eidos4_tim = "
				+ "'Grands'"
				+ "OR eidos4_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos4_tim = "
				+ "'Teachers'"
				+ "OR eidos4_tim = "
				+ "'J&B'"
				+ "OR eidos4_tim = "
				+ "'Jim Beam'"
				+ "OR eidos4_tim = "
				+ "'Four Roses'"
				+ "OR eidos4_tim = "
				+ "'Canadian'"
				+ "OR eidos4_tim = "
				+ "'Jameson'"
				+ "OR eidos4_tim = "
				+ "'Bushmills'"
				+ "OR eidos4_tim = "
				+ "'Comfort'"
				+ "OR eidos4_tim = "
				+ "'Tullamore'"
				+ "OR eidos4_tim = "
				+ "'Jameson 12'"
				+ "OR eidos4_tim = "
				+ "'Jack'"
				+ "OR eidos4_tim = "
				+ "'Dimple'"
				+ "OR eidos4_tim = "
				+ "'Chivas'"
				+ "OR eidos4_tim = "
				+ "'Cardhu'"
				+ "OR eidos4_tim = "
				+ "'Cutty 12'"
				+ "OR eidos4_tim = "
				+ "'Cutty 15'"
				+ "OR eidos4_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos4_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos4_tim = "
				+ "'Oban'"
				+ "OR eidos4_tim = "
				+ "'Lagavulin'"
				+ "OR eidos4_tim = "
				+ "'Macallan'"
				+ "OR eidos4_tim = "
				+ "'Johnie green'"
				+ "OR eidos4_tim = "
				+ "'Makers Mark'"
				+ "OR eidos4_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos4_tim = "
				+ "'Comfort lime'"
				+ "OR eidos4_tim = "
				+ "'Cutty 18'"
				+ "OR eidos4_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos4_tim = "
				+ "'Glenlivet'"
				+ "OR eidos4_tim = "
				+ "'Talisker'"
				+ "OR eidos4_tim = "
				+ "'Dalmore'"
				+ "OR eidos4_tim = "
				+ "'Gragganmore'"
				+ "OR eidos4_tim = "
				+ "'Caol ila'"
				+ "OR eidos5_tim = "
				+ "'Johnie'"
				+ "OR eidos5_tim = "
				+ "'Johnie black'"
				+ "OR eidos5_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos5_tim = "
				+ "'Johnie gold'"
				+ "OR eidos5_tim = "
				+ "'Johnie blue'"
				+ "OR eidos5_tim = "
				+ "'Dewars'"
				+ "OR eidos5_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos5_tim = "
				+ "'Famous'"
				+ "OR eidos5_tim = "
				+ "'Haig'"
				+ "OR eidos5_tim = "
				+ "'Ballandines'"
				+ "OR eidos5_tim = "
				+ "'Bells'"
				+ "OR eidos5_tim = "
				+ "'Grands'"
				+ "OR eidos5_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos5_tim = "
				+ "'Teachers'"
				+ "OR eidos5_tim = "
				+ "'J&B'"
				+ "OR eidos5_tim = "
				+ "'Jim Beam'"
				+ "OR eidos5_tim = "
				+ "'Four Roses'"
				+ "OR eidos5_tim = "
				+ "'Canadian'"
				+ "OR eidos5_tim = "
				+ "'Jameson'"
				+ "OR eidos5_tim = "
				+ "'Bushmills'"
				+ "OR eidos5_tim = "
				+ "'Comfort'"
				+ "OR eidos5_tim = "
				+ "'Tullamore'"
				+ "OR eidos5_tim = "
				+ "'Jameson 12'"
				+ "OR eidos5_tim = "
				+ "'Jack'"
				+ "OR eidos5_tim = "
				+ "'Dimple'"
				+ "OR eidos5_tim = "
				+ "'Chivas'"
				+ "OR eidos5_tim = "
				+ "'Cardhu'"
				+ "OR eidos5_tim = "
				+ "'Cutty 12'"
				+ "OR eidos5_tim = "
				+ "'Cutty 15'"
				+ "OR eidos5_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos5_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos5_tim = "
				+ "'Oban'"
				+ "OR eidos5_tim = "
				+ "'Lagavulin'"
				+ "OR eidos5_tim = "
				+ "'Macallan'"
				+ "OR eidos5_tim = "
				+ "'Johnie green'"
				+ "OR eidos5_tim = "
				+ "'Makers Mark'"
				+ "OR eidos5_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos5_tim = "
				+ "'Comfort lime'"
				+ "OR eidos5_tim = "
				+ "'Cutty 18'"
				+ "OR eidos5_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos5_tim = "
				+ "'Glenlivet'"
				+ "OR eidos5_tim = "
				+ "'Talisker'"
				+ "OR eidos5_tim = "
				+ "'Dalmore'"
				+ "OR eidos5_tim = "
				+ "'Gragganmore'"
				+ "OR eidos5_tim = "
				+ "'Caol ila'"
				+ "OR eidos6_tim = "
				+ "'Johnie'"
				+ "OR eidos6_tim = "
				+ "'Johnie black'"
				+ "OR eidos6_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos6_tim = "
				+ "'Johnie gold'"
				+ "OR eidos6_tim = "
				+ "'Johnie blue'"
				+ "OR eidos6_tim = "
				+ "'Dewars'"
				+ "OR eidos6_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos6_tim = "
				+ "'Famous'"
				+ "OR eidos6_tim = "
				+ "'Haig'"
				+ "OR eidos6_tim = "
				+ "'Ballandines'"
				+ "OR eidos6_tim = "
				+ "'Bells'"
				+ "OR eidos6_tim = "
				+ "'Grands'"
				+ "OR eidos6_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos6_tim = "
				+ "'Teachers'"
				+ "OR eidos6_tim = "
				+ "'J&B'"
				+ "OR eidos6_tim = "
				+ "'Jim Beam'"
				+ "OR eidos6_tim = "
				+ "'Four Roses'"
				+ "OR eidos6_tim = "
				+ "'Canadian'"
				+ "OR eidos6_tim = "
				+ "'Jameson'"
				+ "OR eidos6_tim = "
				+ "'Bushmills'"
				+ "OR eidos6_tim = "
				+ "'Comfort'"
				+ "OR eidos6_tim = "
				+ "'Tullamore'"
				+ "OR eidos6_tim = "
				+ "'Jameson 12'"
				+ "OR eidos6_tim = "
				+ "'Jack'"
				+ "OR eidos6_tim = "
				+ "'Dimple'"
				+ "OR eidos6_tim = "
				+ "'Chivas'"
				+ "OR eidos6_tim = "
				+ "'Cardhu'"
				+ "OR eidos6_tim = "
				+ "'Cutty 12'"
				+ "OR eidos6_tim = "
				+ "'Cutty 15'"
				+ "OR eidos6_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos6_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos6_tim = "
				+ "'Oban'"
				+ "OR eidos6_tim = "
				+ "'Lagavulin'"
				+ "OR eidos6_tim = "
				+ "'Macallan'"
				+ "OR eidos6_tim = "
				+ "'Johnie green'"
				+ "OR eidos6_tim = "
				+ "'Makers Mark'"
				+ "OR eidos6_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos6_tim = "
				+ "'Comfort lime'"
				+ "OR eidos6_tim = "
				+ "'Cutty 18'"
				+ "OR eidos6_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos6_tim = "
				+ "'Glenlivet'"
				+ "OR eidos6_tim = "
				+ "'Talisker'"
				+ "OR eidos6_tim = "
				+ "'Dalmore'"
				+ "OR eidos6_tim = "
				+ "'Gragganmore'"
				+ "OR eidos6_tim = "
				+ "'Caol ila'"
				+ "OR eidos7_tim = "
				+ "'Johnie'"
				+ "OR eidos7_tim = "
				+ "'Johnie black'"
				+ "OR eidos7_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos7_tim = "
				+ "'Johnie gold'"
				+ "OR eidos7_tim = "
				+ "'Johnie blue'"
				+ "OR eidos7_tim = "
				+ "'Dewars'"
				+ "OR eidos7_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos7_tim = "
				+ "'Famous'"
				+ "OR eidos7_tim = "
				+ "'Haig'"
				+ "OR eidos7_tim = "
				+ "'Ballandines'"
				+ "OR eidos7_tim = "
				+ "'Bells'"
				+ "OR eidos7_tim = "
				+ "'Grands'"
				+ "OR eidos7_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos7_tim = "
				+ "'Teachers'"
				+ "OR eidos7_tim = "
				+ "'J&B'"
				+ "OR eidos7_tim = "
				+ "'Jim Beam'"
				+ "OR eidos7_tim = "
				+ "'Four Roses'"
				+ "OR eidos7_tim = "
				+ "'Canadian'"
				+ "OR eidos7_tim = "
				+ "'Jameson'"
				+ "OR eidos7_tim = "
				+ "'Bushmills'"
				+ "OR eidos7_tim = "
				+ "'Comfort'"
				+ "OR eidos7_tim = "
				+ "'Tullamore'"
				+ "OR eidos7_tim = "
				+ "'Jameson 12'"
				+ "OR eidos7_tim = "
				+ "'Jack'"
				+ "OR eidos7_tim = "
				+ "'Dimple'"
				+ "OR eidos7_tim = "
				+ "'Chivas'"
				+ "OR eidos7_tim = "
				+ "'Cardhu'"
				+ "OR eidos7_tim = "
				+ "'Cutty 12'"
				+ "OR eidos7_tim = "
				+ "'Cutty 15'"
				+ "OR eidos7_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos7_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos7_tim = "
				+ "'Oban'"
				+ "OR eidos7_tim = "
				+ "'Lagavulin'"
				+ "OR eidos7_tim = "
				+ "'Macallan'"
				+ "OR eidos7_tim = "
				+ "'Johnie green'"
				+ "OR eidos7_tim = "
				+ "'Makers Mark'"
				+ "OR eidos7_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos7_tim = "
				+ "'Comfort lime'"
				+ "OR eidos7_tim = "
				+ "'Cutty 18'"
				+ "OR eidos7_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos7_tim = "
				+ "'Glenlivet'"
				+ "OR eidos7_tim = "
				+ "'Talisker'"
				+ "OR eidos7_tim = "
				+ "'Dalmore'"
				+ "OR eidos7_tim = "
				+ "'Gragganmore'"
				+ "OR eidos7_tim = "
				+ "'Caol ila'"
				+ "OR eidos8_tim = "
				+ "'Johnie'"
				+ "OR eidos8_tim = "
				+ "'Johnie black'"
				+ "OR eidos8_tim = "
				+ "'Johnie platinum'"
				+ "OR eidos8_tim = "
				+ "'Johnie gold'"
				+ "OR eidos8_tim = "
				+ "'Johnie blue'"
				+ "OR eidos8_tim = "
				+ "'Dewars'"
				+ "OR eidos8_tim = "
				+ "'Cutty Sark'"
				+ "OR eidos8_tim = "
				+ "'Famous'"
				+ "OR eidos8_tim = "
				+ "'Haig'"
				+ "OR eidos8_tim = "
				+ "'Ballandines'"
				+ "OR eidos8_tim = "
				+ "'Bells'"
				+ "OR eidos8_tim = "
				+ "'Grands'"
				+ "OR eidos8_tim = "
				+ "'Wild Turkey'"
				+ "OR eidos8_tim = "
				+ "'Teachers'"
				+ "OR eidos8_tim = "
				+ "'J&B'"
				+ "OR eidos8_tim = "
				+ "'Jim Beam'"
				+ "OR eidos8_tim = "
				+ "'Four Roses'"
				+ "OR eidos8_tim = "
				+ "'Canadian'"
				+ "OR eidos8_tim = "
				+ "'Jameson'"
				+ "OR eidos8_tim = "
				+ "'Bushmills'"
				+ "OR eidos8_tim = "
				+ "'Comfort'"
				+ "OR eidos8_tim = "
				+ "'Tullamore'"
				+ "OR eidos8_tim = "
				+ "'Jameson 12'"
				+ "OR eidos8_tim = "
				+ "'Jack'"
				+ "OR eidos8_tim = "
				+ "'Dimple'"
				+ "OR eidos8_tim = "
				+ "'Chivas'"
				+ "OR eidos8_tim = "
				+ "'Cardhu'"
				+ "OR eidos8_tim = "
				+ "'Cutty 12'"
				+ "OR eidos8_tim = "
				+ "'Cutty 15'"
				+ "OR eidos8_tim = "
				+ "'Glenfiddich'"
				+ "OR eidos8_tim = "
				+ "'Glenmorangie'"
				+ "OR eidos8_tim = "
				+ "'Oban'"
				+ "OR eidos8_tim = "
				+ "'Lagavulin'"
				+ "OR eidos8_tim = "
				+ "'Macallan'"
				+ "OR eidos8_tim = "
				+ "'Johnie green'"
				+ "OR eidos8_tim = "
				+ "'Makers Mark'"
				+ "OR eidos8_tim = "
				+ "'Bushmills 10'"
				+ "OR eidos8_tim = "
				+ "'Comfort lime'"
				+ "OR eidos8_tim = "
				+ "'Cutty 18'"
				+ "OR eidos8_tim = "
				+ "'Dalwhinnie'"
				+ "OR eidos8_tim = "
				+ "'Glenlivet'"
				+ "OR eidos8_tim = "
				+ "'Talisker'"
				+ "OR eidos8_tim = "
				+ "'Dalmore'"
				+ "OR eidos8_tim = "
				+ "'Gragganmore'"
				+ "OR eidos8_tim = " + "'Caol ila'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumVodka() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos1_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos1_tim = "
				+ "'North'"
				+ "OR eidos1_tim = "
				+ "'Ursus'"
				+ "OR eidos1_tim = "
				+ "'Stoli'"
				+ "OR eidos1_tim = "
				+ "'Absolut'"
				+ "OR eidos1_tim = "
				+ "'Finlandia'"
				+ "OR eidos1_tim = "
				+ "'Belvedere'"
				+ "OR eidos1_tim = "
				+ "'Ketel one'"
				+ "OR eidos1_tim = "
				+ "'Grey goose'"
				+ "OR eidos1_tim = "
				+ "'Ciroc'"
				+ "OR eidos1_tim = "
				+ "'Standar'"
				+ "OR eidos2_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos2_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos2_tim = "
				+ "'North'"
				+ "OR eidos2_tim = "
				+ "'Ursus'"
				+ "OR eidos2_tim = "
				+ "'Stoli'"
				+ "OR eidos2_tim = "
				+ "'Absolut'"
				+ "OR eidos2_tim = "
				+ "'Finlandia'"
				+ "OR eidos2_tim = "
				+ "'Belvedere'"
				+ "OR eidos2_tim = "
				+ "'Ketel one'"
				+ "OR eidos2_tim = "
				+ "'Grey goose'"
				+ "OR eidos2_tim = "
				+ "'Ciroc'"
				+ "OR eidos2_tim = "
				+ "'Standar'"
				+ "OR eidos3_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos3_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos3_tim = "
				+ "'North'"
				+ "OR eidos3_tim = "
				+ "'Ursus'"
				+ "OR eidos3_tim = "
				+ "'Stoli'"
				+ "OR eidos3_tim = "
				+ "'Absolut'"
				+ "OR eidos3_tim = "
				+ "'Finlandia'"
				+ "OR eidos3_tim = "
				+ "'Belvedere'"
				+ "OR eidos3_tim = "
				+ "'Ketel one'"
				+ "OR eidos3_tim = "
				+ "'Grey goose'"
				+ "OR eidos3_tim = "
				+ "'Ciroc'"
				+ "OR eidos3_tim = "
				+ "'Standar'"
				+ "OR eidos4_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos4_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos4_tim = "
				+ "'North'"
				+ "OR eidos4_tim = "
				+ "'Ursus'"
				+ "OR eidos4_tim = "
				+ "'Stoli'"
				+ "OR eidos4_tim = "
				+ "'Absolut'"
				+ "OR eidos4_tim = "
				+ "'Finlandia'"
				+ "OR eidos4_tim = "
				+ "'Belvedere'"
				+ "OR eidos4_tim = "
				+ "'Ketel one'"
				+ "OR eidos4_tim = "
				+ "'Grey goose'"
				+ "OR eidos4_tim = "
				+ "'Ciroc'"
				+ "OR eidos4_tim = "
				+ "'Standar'"
				+ "OR eidos5_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos5_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos5_tim = "
				+ "'North'"
				+ "OR eidos5_tim = "
				+ "'Ursus'"
				+ "OR eidos5_tim = "
				+ "'Stoli'"
				+ "OR eidos5_tim = "
				+ "'Absolut'"
				+ "OR eidos5_tim = "
				+ "'Finlandia'"
				+ "OR eidos5_tim = "
				+ "'Belvedere'"
				+ "OR eidos5_tim = "
				+ "'Ketel one'"
				+ "OR eidos5_tim = "
				+ "'Grey goose'"
				+ "OR eidos5_tim = "
				+ "'Ciroc'"
				+ "OR eidos5_tim = "
				+ "'Standar'"
				+ "OR eidos6_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos6_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos6_tim = "
				+ "'North'"
				+ "OR eidos6_tim = "
				+ "'Ursus'"
				+ "OR eidos6_tim = "
				+ "'Stoli'"
				+ "OR eidos6_tim = "
				+ "'Absolut'"
				+ "OR eidos6_tim = "
				+ "'Finlandia'"
				+ "OR eidos6_tim = "
				+ "'Belvedere'"
				+ "OR eidos6_tim = "
				+ "'Ketel one'"
				+ "OR eidos6_tim = "
				+ "'Grey goose'"
				+ "OR eidos6_tim = "
				+ "'Ciroc'"
				+ "OR eidos6_tim = "
				+ "'Standar'"
				+ "OR eidos7_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos7_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos7_tim = "
				+ "'North'"
				+ "OR eidos7_tim = "
				+ "'Ursus'"
				+ "OR eidos7_tim = "
				+ "'Stoli'"
				+ "OR eidos7_tim = "
				+ "'Absolut'"
				+ "OR eidos7_tim = "
				+ "'Finlandia'"
				+ "OR eidos7_tim = "
				+ "'Belvedere'"
				+ "OR eidos7_tim = "
				+ "'Ketel one'"
				+ "OR eidos7_tim = "
				+ "'Grey goose'"
				+ "OR eidos7_tim = "
				+ "'Ciroc'"
				+ "OR eidos7_tim = "
				+ "'Standar'"
				+ "OR eidos8_tim = "
				+ "'Smirnoff red'"
				+ "OR eidos8_tim = "
				+ "'Smirnoff black'"
				+ "OR eidos8_tim = "
				+ "'North'"
				+ "OR eidos8_tim = "
				+ "'Ursus'"
				+ "OR eidos8_tim = "
				+ "'Stoli'"
				+ "OR eidos8_tim = "
				+ "'Absolut'"
				+ "OR eidos8_tim = "
				+ "'Finlandia'"
				+ "OR eidos8_tim = "
				+ "'Belvedere'"
				+ "OR eidos8_tim = "
				+ "'Ketel one'"
				+ "OR eidos8_tim = "
				+ "'Grey goose'"
				+ "OR eidos8_tim = "
				+ "'Ciroc'"
				+ "OR eidos8_tim = " + "'Standar'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumGin() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Gordons'"
				+ "OR eidos1_tim = "
				+ "'Beefeater'"
				+ "OR eidos1_tim = "
				+ "'Bombay'"
				+ "OR eidos1_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos1_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos1_tim = "
				+ "'Hendricks'"
				+ "OR eidos1_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos2_tim = "
				+ "'Gordons'"
				+ "OR eidos2_tim = "
				+ "'Beefeater'"
				+ "OR eidos2_tim = "
				+ "'Bombay'"
				+ "OR eidos2_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos2_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos2_tim = "
				+ "'Hendricks'"
				+ "OR eidos2_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos3_tim = "
				+ "'Gordons'"
				+ "OR eidos3_tim = "
				+ "'Beefeater'"
				+ "OR eidos3_tim = "
				+ "'Bombay'"
				+ "OR eidos3_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos3_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos3_tim = "
				+ "'Hendricks'"
				+ "OR eidos3_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos4_tim = "
				+ "'Gordons'"
				+ "OR eidos4_tim = "
				+ "'Beefeater'"
				+ "OR eidos4_tim = "
				+ "'Bombay'"
				+ "OR eidos4_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos4_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos4_tim = "
				+ "'Hendricks'"
				+ "OR eidos4_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos5_tim = "
				+ "'Gordons'"
				+ "OR eidos5_tim = "
				+ "'Beefeater'"
				+ "OR eidos5_tim = "
				+ "'Bombay'"
				+ "OR eidos5_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos5_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos5_tim = "
				+ "'Hendricks'"
				+ "OR eidos5_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos6_tim = "
				+ "'Gordons'"
				+ "OR eidos6_tim = "
				+ "'Beefeater'"
				+ "OR eidos6_tim = "
				+ "'Bombay'"
				+ "OR eidos6_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos6_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos6_tim = "
				+ "'Hendricks'"
				+ "OR eidos6_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos7_tim = "
				+ "'Gordons'"
				+ "OR eidos7_tim = "
				+ "'Beefeater'"
				+ "OR eidos7_tim = "
				+ "'Bombay'"
				+ "OR eidos7_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos7_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos7_tim = "
				+ "'Hendricks'"
				+ "OR eidos7_tim = "
				+ "'Beefeater 24'"
				+ "OR eidos8_tim = "
				+ "'Gordons'"
				+ "OR eidos8_tim = "
				+ "'Beefeater'"
				+ "OR eidos8_tim = "
				+ "'Bombay'"
				+ "OR eidos8_tim = "
				+ "'Tanqeauray'"
				+ "OR eidos8_tim = "
				+ "'Tanqeauray ten'"
				+ "OR eidos8_tim = "
				+ "'Hendricks'" + "OR eidos8_tim = " + "'Beefeater 24'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumTequila() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos1_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos1_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos1_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos1_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos1_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos1_tim = "
				+ "'Don julio black'"
				+ "OR eidos1_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos1_tim = "
				+ "'Herrandura'"
				+ "OR eidos1_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos1_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos1_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos1_tim = "
				+ "'Jimador'"
				+ "OR eidos1_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos2_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos2_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos2_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos2_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos2_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos2_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos2_tim = "
				+ "'Don julio black'"
				+ "OR eidos2_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos2_tim = "
				+ "'Herrandura'"
				+ "OR eidos2_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos2_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos2_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos2_tim = "
				+ "'Jimador'"
				+ "OR eidos2_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos3_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos3_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos3_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos3_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos3_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos3_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos3_tim = "
				+ "'Don julio black'"
				+ "OR eidos3_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos3_tim = "
				+ "'Herrandura'"
				+ "OR eidos3_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos3_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos3_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos3_tim = "
				+ "'Jimador'"
				+ "OR eidos3_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos4_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos4_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos4_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos4_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos4_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos4_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos4_tim = "
				+ "'Don julio black'"
				+ "OR eidos4_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos4_tim = "
				+ "'Herrandura'"
				+ "OR eidos4_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos4_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos4_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos4_tim = "
				+ "'Jimador'"
				+ "OR eidos4_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos5_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos5_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos5_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos5_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos5_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos5_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos5_tim = "
				+ "'Don julio black'"
				+ "OR eidos5_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos5_tim = "
				+ "'Herrandura'"
				+ "OR eidos5_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos5_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos5_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos5_tim = "
				+ "'Jimador'"
				+ "OR eidos5_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos6_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos6_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos6_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos6_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos6_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos6_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos6_tim = "
				+ "'Don julio black'"
				+ "OR eidos6_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos6_tim = "
				+ "'Herrandura'"
				+ "OR eidos6_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos6_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos6_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos6_tim = "
				+ "'Jimador'"
				+ "OR eidos6_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos7_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos7_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos7_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos7_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos7_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos7_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos7_tim = "
				+ "'Don julio black'"
				+ "OR eidos7_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos7_tim = "
				+ "'Herrandura'"
				+ "OR eidos7_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos7_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos7_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos7_tim = "
				+ "'Jimador'"
				+ "OR eidos7_tim = "
				+ "'Jimador κίτρινη'"
				+ "OR eidos8_tim = "
				+ "'Cuervo κίτρινη'"
				+ "OR eidos8_tim = "
				+ "'Cuervo λευκή'"
				+ "OR eidos8_tim = "
				+ "'Cuervo Black'"
				+ "OR eidos8_tim = "
				+ "'Don Julio anejo'"
				+ "OR eidos8_tim = "
				+ "'Cuervo especial'"
				+ "OR eidos8_tim = "
				+ "'Cuervo reserva'"
				+ "OR eidos8_tim = "
				+ "'Don julio black'"
				+ "OR eidos8_tim = "
				+ "'Don julio reposado'"
				+ "OR eidos8_tim = "
				+ "'Herrandura'"
				+ "OR eidos8_tim = "
				+ "'Herradura κίτρινη'"
				+ "OR eidos8_tim = "
				+ "'Olmeca σοκολάτα'"
				+ "OR eidos8_tim = "
				+ "'Olmeca κίτρινη'"
				+ "OR eidos8_tim = "
				+ "'Jimador'"
				+ "OR eidos8_tim = " + "'Jimador κίτρινη'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumRum() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
					+ "'Bacardi 0,7'" + "OR eidos1_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos1_tim = " + "'Havana λευκή'"
					+ "OR eidos1_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos1_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos1_tim = " + "'Havana 7'" + "OR eidos1_tim = "
					+ "'CT Morgan'" + "OR eidos1_tim = " + "'Pampero λευκό'"
					+ "OR eidos1_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos1_tim = " + "'Varadero'"
					+ "OR eidos1_tim = " + "'Cachaca'"
					+ "OR eidos1_tim = " + "'Zacapa'"
					+ "OR eidos2_tim = " + "'Bacardi 0,7'"
					+ "OR eidos2_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos2_tim = " + "'Havana λευκή'"
					+ "OR eidos2_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos2_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos2_tim = " + "'Havana 7'" + "OR eidos2_tim = "
					+ "'CT Morgan'" + "OR eidos2_tim = " + "'Pampero λευκό'"
					+ "OR eidos2_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos2_tim = " + "'Varadero'"
					+ "OR eidos2_tim = " + "'Cachaca'"
					+ "OR eidos2_tim = " + "'Zacapa'"
					+ "OR eidos3_tim = " + "'Bacardi 0,7'"
					+ "OR eidos3_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos3_tim = " + "'Havana λευκή'"
					+ "OR eidos3_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos3_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos3_tim = " + "'Havana 7'" + "OR eidos3_tim = "
					+ "'CT Morgan'" + "OR eidos3_tim = " + "'Pampero λευκό'"
					+ "OR eidos3_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos3_tim = " + "'Varadero'"
					+ "OR eidos3_tim = " + "'Cachaca'"
					+ "OR eidos3_tim = " + "'Zacapa'"
					+ "OR eidos4_tim = " + "'Bacardi 0,7'"
					+ "OR eidos4_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos4_tim = " + "'Havana λευκή'"
					+ "OR eidos4_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos4_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos4_tim = " + "'Havana 7'" + "OR eidos4_tim = "
					+ "'CT Morgan'" + "OR eidos4_tim = " + "'Pampero λευκό'"
					+ "OR eidos4_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos4_tim = " + "'Varadero'"
					+ "OR eidos4_tim = " + "'Cachaca'"
					+ "OR eidos4_tim = " + "'Zacapa'"
					+ "OR eidos5_tim = " + "'Bacardi 0,7'"
					+ "OR eidos5_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos5_tim = " + "'Havana λευκή'"
					+ "OR eidos5_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos5_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos5_tim = " + "'Havana 7'" + "OR eidos5_tim = "
					+ "'CT Morgan'" + "OR eidos5_tim = " + "'Pampero λευκό'"
					+ "OR eidos5_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos5_tim = " + "'Varadero'"
					+ "OR eidos5_tim = " + "'Cachaca'"
					+ "OR eidos5_tim = " + "'Zacapa'"
					+ "OR eidos6_tim = " + "'Bacardi 0,7'"
					+ "OR eidos6_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos6_tim = " + "'Havana λευκή'"
					+ "OR eidos6_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos6_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos6_tim = " + "'Havana 7'" + "OR eidos6_tim = "
					+ "'CT Morgan'" + "OR eidos6_tim = " + "'Pampero λευκό'"
					+ "OR eidos6_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos6_tim = " + "'Varadero'"
					+ "OR eidos6_tim = " + "'Cachaca'"
					+ "OR eidos6_tim = " + "'Zacapa'"
					+ "OR eidos7_tim = " + "'Bacardi 0,7'"
					+ "OR eidos7_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos7_tim = " + "'Havana λευκή'"
					+ "OR eidos7_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos7_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos7_tim = " + "'Havana 7'" + "OR eidos7_tim = "
					+ "'CT Morgan'" + "OR eidos7_tim = " + "'Pampero λευκό'"
					+ "OR eidos7_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos7_tim = " + "'Varadero'"
					+ "OR eidos7_tim = " + "'Cachaca'"
					+ "OR eidos7_tim = " + "'Zacapa'"
					+ "OR eidos8_tim = " + "'Bacardi 0,7'"
					+ "OR eidos8_tim = " + "'Bacardi λίτρο'"
					+ "OR eidos8_tim = " + "'Havana λευκή'"
					+ "OR eidos8_tim = " + "'Havana 3 κίτρινη'"
					+ "OR eidos8_tim = " + "'Havana 5 μάυρη'"
					+ "OR eidos8_tim = " + "'Havana 7'" + "OR eidos8_tim = "
					+ "'CT Morgan'" + "OR eidos8_tim = " + "'Pampero λευκό'"
					+ "OR eidos8_tim = " + "'Pampero κίτρινο'"
					+ "OR eidos8_tim = " + "'Varadero'"
					+ "OR eidos8_tim = " + "'Cachaca'"
					+ "OR eidos8_tim = " + "'Zacapa'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumCognaq() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
					+ "'Metaxa 5'" + "OR eidos1_tim = " + "'Metaxa 7'"
					+ "OR eidos1_tim = " + "'Courvoisier'" 
					+ "OR eidos1_tim = " + "'Benedictine'"
					+ "OR eidos1_tim = " + "'Remi Martin'"
					+ "OR eidos1_tim = " + "'Hennessy xo'"
					+ "OR eidos1_tim = " + "'Hennessy vsop'"
					+ "OR eidos1_tim = " + "'Martel vs'"
					+ "OR eidos1_tim = " + "'Armagnac'"
					+ "OR eidos1_tim = " + "'Calvados'"
					+ "OR eidos2_tim = " + "'Metaxa 5'"
					+ "OR eidos2_tim = " + "'Metaxa 7'"
					+ "OR eidos2_tim = " + "'Courvoisier'" 
					+ "OR eidos2_tim = " + "'Benedictine'"
					+ "OR eidos2_tim = " + "'Remi Martin'"
					+ "OR eidos2_tim = " + "'Hennessy xo'"
					+ "OR eidos2_tim = " + "'Hennessy vsop'"
					+ "OR eidos2_tim = " + "'Martel vs'"
					+ "OR eidos2_tim = " + "'Armagnac'"
					+ "OR eidos2_tim = " + "'Calvados'"
					+ "OR eidos3_tim = " + "'Metaxa 5'"
					+ "OR eidos3_tim = " + "'Metaxa 7'"
					+ "OR eidos3_tim = " + "'Courvoisier'" 
					+ "OR eidos3_tim = " + "'Benedictine'"
					+ "OR eidos3_tim = " + "'Remi Martin'"
					+ "OR eidos3_tim = " + "'Hennessy xo'"
					+ "OR eidos3_tim = " + "'Hennessy vsop'"
					+ "OR eidos3_tim = " + "'Martel vs'"
					+ "OR eidos3_tim = " + "'Armagnac'"
					+ "OR eidos3_tim = " + "'Calvados'"
					+ "OR eidos4_tim = " + "'Metaxa 5'"
					+ "OR eidos4_tim = " + "'Metaxa 7'"
					+ "OR eidos4_tim = " + "'Courvoisier'" 
					+ "OR eidos4_tim = " + "'Benedictine'"
					+ "OR eidos4_tim = " + "'Remi Martin'"
					+ "OR eidos4_tim = " + "'Hennessy xo'"
					+ "OR eidos4_tim = " + "'Hennessy vsop'"
					+ "OR eidos4_tim = " + "'Martel vs'"
					+ "OR eidos4_tim = " + "'Armagnac'"
					+ "OR eidos4_tim = " + "'Calvados'"
					+ "OR eidos5_tim = " + "'Metaxa 5'"
					+ "OR eidos5_tim = " + "'Metaxa 7'"
					+ "OR eidos5_tim = " + "'Courvoisier'" 
					+ "OR eidos5_tim = " + "'Benedictine'"
					+ "OR eidos5_tim = " + "'Remi Martin'"
					+ "OR eidos5_tim = " + "'Hennessy xo'"
					+ "OR eidos5_tim = " + "'Hennessy vsop'"
					+ "OR eidos5_tim = " + "'Martel vs'"
					+ "OR eidos5_tim = " + "'Armagnac'"
					+ "OR eidos5_tim = " + "'Calvados'"
					+ "OR eidos6_tim = " + "'Metaxa 5'"
					+ "OR eidos6_tim = " + "'Metaxa 7'"
					+ "OR eidos6_tim = " + "'Courvoisier'" 
					+ "OR eidos6_tim = " + "'Benedictine'"
					+ "OR eidos6_tim = " + "'Remi Martin'"
					+ "OR eidos6_tim = " + "'Hennessy xo'"
					+ "OR eidos6_tim = " + "'Hennessy vsop'"
					+ "OR eidos6_tim = " + "'Martel vs'"
					+ "OR eidos6_tim = " + "'Armagnac'"
					+ "OR eidos6_tim = " + "'Calvados'"
					+ "OR eidos7_tim = " + "'Metaxa 5'"
					+ "OR eidos7_tim = " + "'Metaxa 7'"
					+ "OR eidos7_tim = " + "'Courvoisier'" 
					+ "OR eidos7_tim = " + "'Benedictine'"
					+ "OR eidos7_tim = " + "'Remi Martin'"
					+ "OR eidos7_tim = " + "'Hennessy xo'"
					+ "OR eidos7_tim = " + "'Hennessy vsop'"
					+ "OR eidos7_tim = " + "'Martel vs'"
					+ "OR eidos7_tim = " + "'Armagnac'"
					+ "OR eidos7_tim = " + "'Calvados'"
					+ "OR eidos8_tim = " + "'Metaxa 5'"
					+ "OR eidos8_tim = " + "'Metaxa 7'"
					+ "OR eidos8_tim = " + "'Courvoisier'" 
					+ "OR eidos8_tim = " + "'Benedictine'"
					+ "OR eidos8_tim = " + "'Remi Martin'"
					+ "OR eidos8_tim = " + "'Hennessy xo'"
					+ "OR eidos8_tim = " + "'Hennessy vsop'"
					+ "OR eidos8_tim = " + "'Martel vs'"
					+ "OR eidos8_tim = " + "'Armagnac'"
					+ "OR eidos8_tim = " + "'Calvados'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumLiker() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
					+ "'Pimms'" + "OR eidos1_tim = " + "'Kahlua'"
					+ "OR eidos1_tim = " + "'Heering'"
					+ "OR eidos1_tim = " + "'Grand marnier'"
					+ "OR eidos1_tim = " + "'Tia maria'"
					+ "OR eidos1_tim = " + "'Aperol'"
					+ "OR eidos1_tim = " + "'Jagermeister'"
					+ "OR eidos1_tim = " + "'Skinos Mastiha'"
					+ "OR eidos1_tim = " + "'Limoncelo'"
					+ "OR eidos1_tim = " + "'Menta'"
					+ "OR eidos1_tim = " + "'Fernet'"
					+ "OR eidos1_tim = " + "'Batida'"
					+ "OR eidos1_tim = " + "'Passoa'"
					+ "OR eidos1_tim = " + "'Pisang'"
					+ "OR eidos1_tim = " + "'Blue Curacao'"
					+ "OR eidos1_tim = " + "'Malibu'"
					+ "OR eidos1_tim = " + "'Lime'"
					+ "OR eidos1_tim = " + "'Grenandine'"
					+ "OR eidos1_tim = " + "'Amareto'"
					+ "OR eidos1_tim = " + "'Grandberry'"
					+ "OR eidos1_tim = " + "'Baileys'"
					+ "OR eidos1_tim = " + "'Drambuie'"
					+ "OR eidos1_tim = " + "'Frangelico'"
					+ "OR eidos1_tim = " + "'Campari'"
					+ "OR eidos1_tim = " + "'Martini'"
					+ "OR eidos1_tim = " + "'Martini rosato'"
					+ "OR eidos1_tim = " + "'Martini dry'"
					+ "OR eidos1_tim = " + "'Sambucha kef'"
					+ "OR eidos1_tim = " + "'Sambucha black'"
					+ "OR eidos1_tim = " + "'Cointreau'"
					+ "OR eidos1_tim = " + "'Gordons Space'"
					+ "OR eidos1_tim = " + "'Red Bull'"
					+ "OR eidos1_tim = " + "'Shark'"
					+ "OR eidos1_tim = " + "'ice'"
					+ "OR eidos1_tim = " + "'breezer'"
					+ "OR eidos2_tim = " + "'Pimms'"
					+ "OR eidos2_tim = " + "'Kahlua'"
					+ "OR eidos2_tim = " + "'Heering'"
					+ "OR eidos2_tim = " + "'Grand marnier'"
					+ "OR eidos2_tim = " + "'Tia maria'"
					+ "OR eidos2_tim = " + "'Aperol'"
					+ "OR eidos2_tim = " + "'Jagermeister'"
					+ "OR eidos2_tim = " + "'Skinos Mastiha'"
					+ "OR eidos2_tim = " + "'Limoncelo'"
					+ "OR eidos2_tim = " + "'Menta'"
					+ "OR eidos2_tim = " + "'Fernet'"
					+ "OR eidos2_tim = " + "'Batida'"
					+ "OR eidos2_tim = " + "'Passoa'"
					+ "OR eidos2_tim = " + "'Pisang'"
					+ "OR eidos2_tim = " + "'Blue Curacao'"
					+ "OR eidos2_tim = " + "'Malibu'"
					+ "OR eidos2_tim = " + "'Lime'"
					+ "OR eidos2_tim = " + "'Grenandine'"
					+ "OR eidos2_tim = " + "'Amareto'"
					+ "OR eidos2_tim = " + "'Grandberry'"
					+ "OR eidos2_tim = " + "'Baileys'"
					+ "OR eidos2_tim = " + "'Drambuie'"
					+ "OR eidos2_tim = " + "'Frangelico'"
					+ "OR eidos2_tim = " + "'Campari'"
					+ "OR eidos2_tim = " + "'Martini'"
					+ "OR eidos2_tim = " + "'Martini rosato'"
					+ "OR eidos2_tim = " + "'Martini dry'"
					+ "OR eidos2_tim = " + "'Sambucha kef'"
					+ "OR eidos2_tim = " + "'Sambucha black'"
					+ "OR eidos2_tim = " + "'Cointreau'"
					+ "OR eidos2_tim = " + "'Gordons Space'"
					+ "OR eidos2_tim = " + "'Red Bull'"
					+ "OR eidos2_tim = " + "'Shark'"
					+ "OR eidos2_tim = " + "'ice'"
					+ "OR eidos2_tim = " + "'breezer'"
					+ "OR eidos3_tim = " + "'Pimms'"
					+ "OR eidos3_tim = " + "'Kahlua'"
					+ "OR eidos3_tim = " + "'Heering'"
					+ "OR eidos3_tim = " + "'Grand marnier'"
					+ "OR eidos3_tim = " + "'Tia maria'"
					+ "OR eidos3_tim = " + "'Aperol'"
					+ "OR eidos3_tim = " + "'Jagermeister'"
					+ "OR eidos3_tim = " + "'Skinos Mastiha'"
					+ "OR eidos3_tim = " + "'Limoncelo'"
					+ "OR eidos3_tim = " + "'Menta'"
					+ "OR eidos3_tim = " + "'Fernet'"
					+ "OR eidos3_tim = " + "'Batida'"
					+ "OR eidos3_tim = " + "'Passoa'"
					+ "OR eidos3_tim = " + "'Pisang'"
					+ "OR eidos3_tim = " + "'Blue Curacao'"
					+ "OR eidos3_tim = " + "'Malibu'"
					+ "OR eidos3_tim = " + "'Lime'"
					+ "OR eidos3_tim = " + "'Grenandine'"
					+ "OR eidos3_tim = " + "'Amareto'"
					+ "OR eidos3_tim = " + "'Grandberry'"
					+ "OR eidos3_tim = " + "'Baileys'"
					+ "OR eidos3_tim = " + "'Drambuie'"
					+ "OR eidos3_tim = " + "'Frangelico'"
					+ "OR eidos3_tim = " + "'Campari'"
					+ "OR eidos3_tim = " + "'Martini'"
					+ "OR eidos3_tim = " + "'Martini rosato'"
					+ "OR eidos3_tim = " + "'Martini dry'"
					+ "OR eidos3_tim = " + "'Sambucha kef'"
					+ "OR eidos3_tim = " + "'Sambucha black'"
					+ "OR eidos3_tim = " + "'Cointreau'"
					+ "OR eidos3_tim = " + "'Gordons Space'"
					+ "OR eidos3_tim = " + "'Red Bull'"
					+ "OR eidos3_tim = " + "'Shark'"
					+ "OR eidos3_tim = " + "'ice'"
					+ "OR eidos3_tim = " + "'breezer'"
					+ "OR eidos4_tim = " + "'Pimms'"
					+ "OR eidos4_tim = " + "'Kahlua'"
					+ "OR eidos4_tim = " + "'Heering'"
					+ "OR eidos4_tim = " + "'Grand marnier'"
					+ "OR eidos4_tim = " + "'Tia maria'"
					+ "OR eidos4_tim = " + "'Aperol'"
					+ "OR eidos4_tim = " + "'Jagermeister'"
					+ "OR eidos4_tim = " + "'Skinos Mastiha'"
					+ "OR eidos4_tim = " + "'Limoncelo'"
					+ "OR eidos4_tim = " + "'Menta'"
					+ "OR eidos4_tim = " + "'Fernet'"
					+ "OR eidos4_tim = " + "'Batida'"
					+ "OR eidos4_tim = " + "'Passoa'"
					+ "OR eidos4_tim = " + "'Pisang'"
					+ "OR eidos4_tim = " + "'Blue Curacao'"
					+ "OR eidos4_tim = " + "'Malibu'"
					+ "OR eidos4_tim = " + "'Lime'"
					+ "OR eidos4_tim = " + "'Grenandine'"
					+ "OR eidos4_tim = " + "'Amareto'"
					+ "OR eidos4_tim = " + "'Grandberry'"
					+ "OR eidos4_tim = " + "'Baileys'"
					+ "OR eidos4_tim = " + "'Drambuie'"
					+ "OR eidos4_tim = " + "'Frangelico'"
					+ "OR eidos4_tim = " + "'Campari'"
					+ "OR eidos4_tim = " + "'Martini'"
					+ "OR eidos4_tim = " + "'Martini rosato'"
					+ "OR eidos4_tim = " + "'Martini dry'"
					+ "OR eidos4_tim = " + "'Sambucha kef'"
					+ "OR eidos4_tim = " + "'Sambucha black'"
					+ "OR eidos4_tim = " + "'Cointreau'"
					+ "OR eidos4_tim = " + "'Gordons Space'"
					+ "OR eidos4_tim = " + "'Red Bull'"
					+ "OR eidos4_tim = " + "'Shark'"
					+ "OR eidos4_tim = " + "'ice'"
					+ "OR eidos4_tim = " + "'breezer'"
					+ "OR eidos5_tim = " + "'Pimms'"
					+ "OR eidos5_tim = " + "'Kahlua'"
					+ "OR eidos5_tim = " + "'Heering'"
					+ "OR eidos5_tim = " + "'Grand marnier'"
					+ "OR eidos5_tim = " + "'Tia maria'"
					+ "OR eidos5_tim = " + "'Aperol'"
					+ "OR eidos5_tim = " + "'Jagermeister'"
					+ "OR eidos5_tim = " + "'Skinos Mastiha'"
					+ "OR eidos5_tim = " + "'Limoncelo'"
					+ "OR eidos5_tim = " + "'Menta'"
					+ "OR eidos5_tim = " + "'Fernet'"
					+ "OR eidos5_tim = " + "'Batida'"
					+ "OR eidos5_tim = " + "'Passoa'"
					+ "OR eidos5_tim = " + "'Pisang'"
					+ "OR eidos5_tim = " + "'Blue Curacao'"
					+ "OR eidos5_tim = " + "'Malibu'"
					+ "OR eidos5_tim = " + "'Lime'"
					+ "OR eidos5_tim = " + "'Grenandine'"
					+ "OR eidos5_tim = " + "'Amareto'"
					+ "OR eidos5_tim = " + "'Grandberry'"
					+ "OR eidos5_tim = " + "'Baileys'"
					+ "OR eidos5_tim = " + "'Drambuie'"
					+ "OR eidos5_tim = " + "'Frangelico'"
					+ "OR eidos5_tim = " + "'Campari'"
					+ "OR eidos5_tim = " + "'Martini'"
					+ "OR eidos5_tim = " + "'Martini rosato'"
					+ "OR eidos5_tim = " + "'Martini dry'"
					+ "OR eidos5_tim = " + "'Sambucha kef'"
					+ "OR eidos5_tim = " + "'Sambucha black'"
					+ "OR eidos5_tim = " + "'Cointreau'"
					+ "OR eidos5_tim = " + "'Gordons Space'"
					+ "OR eidos5_tim = " + "'Red Bull'"
					+ "OR eidos5_tim = " + "'Shark'"
					+ "OR eidos5_tim = " + "'ice'"
					+ "OR eidos5_tim = " + "'breezer'"
					+ "OR eidos6_tim = " + "'Pimms'"
					+ "OR eidos6_tim = " + "'Kahlua'"
					+ "OR eidos6_tim = " + "'Heering'"
					+ "OR eidos6_tim = " + "'Grand marnier'"
					+ "OR eidos6_tim = " + "'Tia maria'"
					+ "OR eidos6_tim = " + "'Aperol'"
					+ "OR eidos6_tim = " + "'Jagermeister'"
					+ "OR eidos6_tim = " + "'Skinos Mastiha'"
					+ "OR eidos6_tim = " + "'Limoncelo'"
					+ "OR eidos6_tim = " + "'Menta'"
					+ "OR eidos6_tim = " + "'Fernet'"
					+ "OR eidos6_tim = " + "'Batida'"
					+ "OR eidos6_tim = " + "'Passoa'"
					+ "OR eidos6_tim = " + "'Pisang'"
					+ "OR eidos6_tim = " + "'Blue Curacao'"
					+ "OR eidos6_tim = " + "'Malibu'"
					+ "OR eidos6_tim = " + "'Lime'"
					+ "OR eidos6_tim = " + "'Grenandine'"
					+ "OR eidos6_tim = " + "'Amareto'"
					+ "OR eidos6_tim = " + "'Grandberry'"
					+ "OR eidos6_tim = " + "'Baileys'"
					+ "OR eidos6_tim = " + "'Drambuie'"
					+ "OR eidos6_tim = " + "'Frangelico'"
					+ "OR eidos6_tim = " + "'Campari'"
					+ "OR eidos6_tim = " + "'Martini'"
					+ "OR eidos6_tim = " + "'Martini rosato'"
					+ "OR eidos6_tim = " + "'Martini dry'"
					+ "OR eidos6_tim = " + "'Sambucha kef'"
					+ "OR eidos6_tim = " + "'Sambucha black'"
					+ "OR eidos6_tim = " + "'Cointreau'"
					+ "OR eidos6_tim = " + "'Gordons Space'"
					+ "OR eidos6_tim = " + "'Red Bull'"
					+ "OR eidos6_tim = " + "'Shark'"
					+ "OR eidos6_tim = " + "'ice'"
					+ "OR eidos6_tim = " + "'breezer'"
					+ "OR eidos7_tim = " + "'Pimms'"
					+ "OR eidos7_tim = " + "'Kahlua'"
					+ "OR eidos7_tim = " + "'Heering'"
					+ "OR eidos7_tim = " + "'Grand marnier'"
					+ "OR eidos7_tim = " + "'Tia maria'"
					+ "OR eidos7_tim = " + "'Aperol'"
					+ "OR eidos7_tim = " + "'Jagermeister'"
					+ "OR eidos7_tim = " + "'Skinos Mastiha'"
					+ "OR eidos7_tim = " + "'Limoncelo'"
					+ "OR eidos7_tim = " + "'Menta'"
					+ "OR eidos7_tim = " + "'Fernet'"
					+ "OR eidos7_tim = " + "'Batida'"
					+ "OR eidos7_tim = " + "'Passoa'"
					+ "OR eidos7_tim = " + "'Pisang'"
					+ "OR eidos7_tim = " + "'Blue Curacao'"
					+ "OR eidos7_tim = " + "'Malibu'"
					+ "OR eidos7_tim = " + "'Lime'"
					+ "OR eidos7_tim = " + "'Grenandine'"
					+ "OR eidos7_tim = " + "'Amareto'"
					+ "OR eidos7_tim = " + "'Grandberry'"
					+ "OR eidos7_tim = " + "'Baileys'"
					+ "OR eidos7_tim = " + "'Drambuie'"
					+ "OR eidos7_tim = " + "'Frangelico'"
					+ "OR eidos7_tim = " + "'Campari'"
					+ "OR eidos7_tim = " + "'Martini'"
					+ "OR eidos7_tim = " + "'Martini rosato'"
					+ "OR eidos7_tim = " + "'Martini dry'"
					+ "OR eidos7_tim = " + "'Sambucha kef'"
					+ "OR eidos7_tim = " + "'Sambucha black'"
					+ "OR eidos7_tim = " + "'Cointreau'"
					+ "OR eidos7_tim = " + "'Gordons Space'"
					+ "OR eidos7_tim = " + "'Red Bull'"
					+ "OR eidos7_tim = " + "'Shark'"
					+ "OR eidos7_tim = " + "'ice'"
					+ "OR eidos7_tim = " + "'breezer'"
					+ "OR eidos8_tim = " + "'Pimms'"
					+ "OR eidos8_tim = " + "'Kahlua'"
					+ "OR eidos8_tim = " + "'Heering'"
					+ "OR eidos8_tim = " + "'Grand marnier'"
					+ "OR eidos8_tim = " + "'Tia maria'"
					+ "OR eidos8_tim = " + "'Aperol'"
					+ "OR eidos8_tim = " + "'Jagermeister'"
					+ "OR eidos8_tim = " + "'Skinos Mastiha'"
					+ "OR eidos8_tim = " + "'Limoncelo'"
					+ "OR eidos8_tim = " + "'Menta'"
					+ "OR eidos8_tim = " + "'Fernet'"
					+ "OR eidos8_tim = " + "'Batida'"
					+ "OR eidos8_tim = " + "'Passoa'"
					+ "OR eidos8_tim = " + "'Pisang'"
					+ "OR eidos8_tim = " + "'Blue Curacao'"
					+ "OR eidos8_tim = " + "'Malibu'"
					+ "OR eidos8_tim = " + "'Lime'"
					+ "OR eidos8_tim = " + "'Grenandine'"
					+ "OR eidos8_tim = " + "'Amareto'"
					+ "OR eidos8_tim = " + "'Grandberry'"
					+ "OR eidos8_tim = " + "'Baileys'"
					+ "OR eidos8_tim = " + "'Drambuie'"
					+ "OR eidos8_tim = " + "'Frangelico'"
					+ "OR eidos8_tim = " + "'Campari'"
					+ "OR eidos8_tim = " + "'Martini'"
					+ "OR eidos8_tim = " + "'Martini rosato'"
					+ "OR eidos8_tim = " + "'Martini dry'"
					+ "OR eidos8_tim = " + "'Sambucha kef'"
					+ "OR eidos8_tim = " + "'Sambucha black'"
					+ "OR eidos8_tim = " + "'Cointreau'"
					+ "OR eidos8_tim = " + "'Gordons Space'"
					+ "OR eidos8_tim = " + "'Red Bull'"
					+ "OR eidos8_tim = " + "'Shark'"
					+ "OR eidos8_tim = " + "'ice'"
					+ "OR eidos8_tim = " + "'breezer'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumYlika() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
					+ "'Χ.Κουζίνας'" + "OR eidos1_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos1_tim = " + "'Βετέξ'" + "OR eidos1_tim = "
					+ "'Σφουγγάρια'" + "OR eidos1_tim = " + "'Γάντια'"
					+ "OR eidos1_tim = " + "'Οδοντογλυφ.'" + "OR eidos1_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos1_tim = " + "'Κοντάρι'"
					+ "OR eidos1_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos1_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos1_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos1_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos1_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos1_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos1_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos1_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos1_tim = " + "'Υγρό ίνοξ'" + "OR eidos1_tim = "
					+ "'Υγρό λίπη'" + "OR eidos1_tim = " + "'Οινόπνευμα'"
					+ "OR eidos1_tim = " + "'Αναδευτήρες'" + "OR eidos1_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos1_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos1_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos1_tim = " + "'Χλωρίνη'"
					+ "OR eidos1_tim = " + "'Σύρμα'" + "OR eidos1_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos1_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos1_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos1_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos1_tim = " + "'πακέτα delivery'"
					+ "OR eidos1_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos1_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos1_tim = " + "'στεγνωτικό'" + "OR eidos1_tim = "
					+ "'στεγνωτικό'" + "OR eidos1_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos1_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos1_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos1_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos1_tim = " + "'αποσμυτικά'"
					+ "OR eidos1_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos1_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos2_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos2_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos2_tim = " + "'Βετέξ'" + "OR eidos2_tim = "
					+ "'Σφουγγάρια'" + "OR eidos2_tim = " + "'Γάντια'"
					+ "OR eidos2_tim = " + "'Οδοντογλυφ.'" + "OR eidos2_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos2_tim = " + "'Κοντάρι'"
					+ "OR eidos2_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos2_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos2_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos2_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos2_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos2_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos2_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos2_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos2_tim = " + "'Υγρό ίνοξ'" + "OR eidos2_tim = "
					+ "'Υγρό λίπη'" + "OR eidos2_tim = " + "'Οινόπνευμα'"
					+ "OR eidos2_tim = " + "'Αναδευτήρες'" + "OR eidos2_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos2_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos2_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos2_tim = " + "'Χλωρίνη'"
					+ "OR eidos2_tim = " + "'Σύρμα'" + "OR eidos2_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos2_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos2_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos2_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos2_tim = " + "'πακέτα delivery'"
					+ "OR eidos2_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos2_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos2_tim = " + "'στεγνωτικό'" + "OR eidos2_tim = "
					+ "'στεγνωτικό'" + "OR eidos2_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos2_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos2_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos2_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos2_tim = " + "'αποσμυτικά'"
					+ "OR eidos2_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos2_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos3_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos3_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos3_tim = " + "'Βετέξ'" + "OR eidos3_tim = "
					+ "'Σφουγγάρια'" + "OR eidos3_tim = " + "'Γάντια'"
					+ "OR eidos3_tim = " + "'Οδοντογλυφ.'" + "OR eidos3_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos3_tim = " + "'Κοντάρι'"
					+ "OR eidos3_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos3_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos3_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos3_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos3_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos3_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos3_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos3_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos3_tim = " + "'Υγρό ίνοξ'" + "OR eidos3_tim = "
					+ "'Υγρό λίπη'" + "OR eidos3_tim = " + "'Οινόπνευμα'"
					+ "OR eidos3_tim = " + "'Αναδευτήρες'" + "OR eidos3_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos3_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos3_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos3_tim = " + "'Χλωρίνη'"
					+ "OR eidos3_tim = " + "'Σύρμα'" + "OR eidos3_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos3_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos3_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos3_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos3_tim = " + "'πακέτα delivery'"
					+ "OR eidos3_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos3_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos3_tim = " + "'στεγνωτικό'" + "OR eidos3_tim = "
					+ "'στεγνωτικό'" + "OR eidos3_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos3_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos3_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos3_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos3_tim = " + "'αποσμυτικά'"
					+ "OR eidos3_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos3_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos4_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos4_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos4_tim = " + "'Βετέξ'" + "OR eidos4_tim = "
					+ "'Σφουγγάρια'" + "OR eidos4_tim = " + "'Γάντια'"
					+ "OR eidos4_tim = " + "'Οδοντογλυφ.'" + "OR eidos4_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos4_tim = " + "'Κοντάρι'"
					+ "OR eidos4_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos4_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos4_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos4_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos4_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos4_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos4_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos4_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos4_tim = " + "'Υγρό ίνοξ'" + "OR eidos4_tim = "
					+ "'Υγρό λίπη'" + "OR eidos4_tim = " + "'Οινόπνευμα'"
					+ "OR eidos4_tim = " + "'Αναδευτήρες'" + "OR eidos4_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos4_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos4_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos4_tim = " + "'Χλωρίνη'"
					+ "OR eidos4_tim = " + "'Σύρμα'" + "OR eidos4_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos4_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos4_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos4_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos4_tim = " + "'πακέτα delivery'"
					+ "OR eidos4_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos4_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos4_tim = " + "'στεγνωτικό'" + "OR eidos4_tim = "
					+ "'στεγνωτικό'" + "OR eidos4_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos4_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos4_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos4_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos4_tim = " + "'αποσμυτικά'"
					+ "OR eidos4_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos4_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos5_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos5_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos5_tim = " + "'Βετέξ'" + "OR eidos5_tim = "
					+ "'Σφουγγάρια'" + "OR eidos5_tim = " + "'Γάντια'"
					+ "OR eidos5_tim = " + "'Οδοντογλυφ.'" + "OR eidos5_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos5_tim = " + "'Κοντάρι'"
					+ "OR eidos5_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos5_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos5_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos5_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos5_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos5_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos5_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos5_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos5_tim = " + "'Υγρό ίνοξ'" + "OR eidos5_tim = "
					+ "'Υγρό λίπη'" + "OR eidos5_tim = " + "'Οινόπνευμα'"
					+ "OR eidos5_tim = " + "'Αναδευτήρες'" + "OR eidos5_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos5_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos5_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos5_tim = " + "'Χλωρίνη'"
					+ "OR eidos5_tim = " + "'Σύρμα'" + "OR eidos5_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos5_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos5_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos5_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos5_tim = " + "'πακέτα delivery'"
					+ "OR eidos5_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos5_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos5_tim = " + "'στεγνωτικό'" + "OR eidos5_tim = "
					+ "'στεγνωτικό'" + "OR eidos5_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos5_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos5_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos5_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos5_tim = " + "'αποσμυτικά'"
					+ "OR eidos5_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos5_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos6_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos6_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos6_tim = " + "'Βετέξ'" + "OR eidos6_tim = "
					+ "'Σφουγγάρια'" + "OR eidos6_tim = " + "'Γάντια'"
					+ "OR eidos6_tim = " + "'Οδοντογλυφ.'" + "OR eidos6_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos6_tim = " + "'Κοντάρι'"
					+ "OR eidos6_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos6_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos6_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos6_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos6_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos6_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos6_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos6_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos6_tim = " + "'Υγρό ίνοξ'" + "OR eidos6_tim = "
					+ "'Υγρό λίπη'" + "OR eidos6_tim = " + "'Οινόπνευμα'"
					+ "OR eidos6_tim = " + "'Αναδευτήρες'" + "OR eidos6_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos6_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos6_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos6_tim = " + "'Χλωρίνη'"
					+ "OR eidos6_tim = " + "'Σύρμα'" + "OR eidos6_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos6_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos6_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos6_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos6_tim = " + "'πακέτα delivery'"
					+ "OR eidos6_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos6_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos6_tim = " + "'στεγνωτικό'" + "OR eidos6_tim = "
					+ "'στεγνωτικό'" + "OR eidos6_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos6_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos6_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos6_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos6_tim = " + "'αποσμυτικά'"
					+ "OR eidos6_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos6_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos7_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos7_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos7_tim = " + "'Βετέξ'" + "OR eidos7_tim = "
					+ "'Σφουγγάρια'" + "OR eidos7_tim = " + "'Γάντια'"
					+ "OR eidos7_tim = " + "'Οδοντογλυφ.'" + "OR eidos7_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos7_tim = " + "'Κοντάρι'"
					+ "OR eidos7_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos7_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos7_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos7_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos7_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos7_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos7_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos7_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos7_tim = " + "'Υγρό ίνοξ'" + "OR eidos7_tim = "
					+ "'Υγρό λίπη'" + "OR eidos7_tim = " + "'Οινόπνευμα'"
					+ "OR eidos7_tim = " + "'Αναδευτήρες'" + "OR eidos7_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos7_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos7_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos7_tim = " + "'Χλωρίνη'"
					+ "OR eidos7_tim = " + "'Σύρμα'" + "OR eidos7_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos7_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos7_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos7_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos7_tim = " + "'πακέτα delivery'"
					+ "OR eidos7_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos7_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos7_tim = " + "'στεγνωτικό'" + "OR eidos7_tim = "
					+ "'στεγνωτικό'" + "OR eidos7_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos7_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos7_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos7_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos7_tim = " + "'αποσμυτικά'"
					+ "OR eidos7_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos7_tim = " + "'χαρτιά παραγγελιών'"
					+ "OR eidos8_tim = " + "'Χ.Κουζίνας'"
					+ "OR eidos8_tim = " + "'Χ.Υγείας επάγγ.'"
					+ "OR eidos8_tim = " + "'Βετέξ'" + "OR eidos8_tim = "
					+ "'Σφουγγάρια'" + "OR eidos8_tim = " + "'Γάντια'"
					+ "OR eidos8_tim = " + "'Οδοντογλυφ.'" + "OR eidos8_tim = "
					+ "'Σφουγγαρίστρες'" + "OR eidos8_tim = " + "'Κοντάρι'"
					+ "OR eidos8_tim = " + "'Σκούπα-Φαράσι'"
					+ "OR eidos8_tim = " + "'Κουβάς σκουγγ.'"
					+ "OR eidos8_tim = " + "'Καλαμάκια Εσπρ.'"
					+ "OR eidos8_tim = " + "'Καλαμάκια φραπέ'"
					+ "OR eidos8_tim = " + "'Καλαμάκια σοκολάτας'"
					+ "OR eidos8_tim = " + "'Υγρό πατωμάτων'"
					+ "OR eidos8_tim = " + "'Υγρό τζαμιών'"
					+ "OR eidos8_tim = " + "'Υγρό ποτηριών'"
					+ "OR eidos8_tim = " + "'Υγρό ίνοξ'" + "OR eidos8_tim = "
					+ "'Υγρό λίπη'" + "OR eidos8_tim = " + "'Οινόπνευμα'"
					+ "OR eidos8_tim = " + "'Αναδευτήρες'" + "OR eidos8_tim = "
					+ "'Σακούλες 80Χ1,10'" + "OR eidos8_tim = "
					+ "'Σακούλες 65Χ85'" + "OR eidos8_tim = "
					+ "'Σακούλες γραφείου'" + "OR eidos8_tim = " + "'Χλωρίνη'"
					+ "OR eidos8_tim = " + "'Σύρμα'" + "OR eidos8_tim = "
					+ "'Χειροπετσέτες'" + "OR eidos8_tim = "
					+ "'Αφρός σαπούνι'" + "OR eidos8_tim = "
					+ "'Χαρτοπετσέτες'" + "OR eidos8_tim = " + "'Κρεμοσάπουνο'"
					+ "OR eidos8_tim = " + "'πακέτα delivery'"
					+ "OR eidos8_tim = " + "'ποτήρια πλαστικά'"
					+ "OR eidos8_tim = " + "'απορυπαντικό πλυντηρίου'"
					+ "OR eidos8_tim = " + "'στεγνωτικό'" + "OR eidos8_tim = "
					+ "'στεγνωτικό'" + "OR eidos8_tim = "
					+ "'σακούλες για πακέτο'" + "OR eidos8_tim = "
					+ "'φίλτρα γαλλικού'" + "OR eidos8_tim = "
					+ "'φίλτρα τσάι'"
					+ "OR eidos8_tim = " + "'Σακούλες πάγου'"
					+ "OR eidos8_tim = " + "'αποσμυτικά'"
					+ "OR eidos8_tim = " + "'χαρτιά ταμειακής'"
					+ "OR eidos8_tim = " + "'χαρτιά παραγγελιών'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumFrouta_lax() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'Ρόκα'"
				+ "OR eidos1_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos1_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos1_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos1_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos1_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos1_tim = "
				+ "'Πατάτες'"
				+ "OR eidos1_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos1_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos1_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos1_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos1_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos1_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos1_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos1_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos1_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos1_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos1_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos1_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos1_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos1_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos1_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos1_tim = "
				+ "'Άνηθος'"
				+ "OR eidos1_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos1_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos1_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos1_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos1_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos1_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos1_tim = "
				+ "'Iceberg'"
				+ "OR eidos1_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos1_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos1_tim = "
				+ "'Καρότα'"
				+ "OR eidos1_tim = "
				+ "'Μήλα'"
				+ "OR eidos1_tim = "
				+ "'Ελιές'"
				+ "OR eidos1_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos1_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos1_tim = "
				+ "'Φράουλες'"
				+ "OR eidos1_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos1_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos1_tim = "
				+ "'Κεράσια'"
				+ "OR eidos1_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos1_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos1_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos1_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos1_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos2_tim = "
				+ "'Ρόκα'"
				+ "OR eidos2_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos2_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos2_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos2_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos2_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos2_tim = "
				+ "'Πατάτες'"
				+ "OR eidos2_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos2_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos2_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos2_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos2_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos2_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos2_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos2_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos2_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos2_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos2_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos2_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos2_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos2_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos2_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos2_tim = "
				+ "'Άνηθος'"
				+ "OR eidos2_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos2_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos2_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos2_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos2_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos2_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos2_tim = "
				+ "'Iceberg'"
				+ "OR eidos2_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos2_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos2_tim = "
				+ "'Καρότα'"
				+ "OR eidos2_tim = "
				+ "'Μήλα'"
				+ "OR eidos2_tim = "
				+ "'Ελιές'"
				+ "OR eidos2_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos2_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos2_tim = "
				+ "'Φράουλες'"
				+ "OR eidos2_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos2_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos2_tim = "
				+ "'Κεράσια'"
				+ "OR eidos2_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos2_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos2_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos2_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos2_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos3_tim = "
				+ "'Ρόκα'"
				+ "OR eidos3_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos3_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos3_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos3_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos3_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos3_tim = "
				+ "'Πατάτες'"
				+ "OR eidos3_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos3_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos3_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos3_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos3_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos3_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos3_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos3_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos3_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos3_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos3_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos3_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos3_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos3_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos3_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos3_tim = "
				+ "'Άνηθος'"
				+ "OR eidos3_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos3_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos3_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos3_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos3_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos3_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos3_tim = "
				+ "'Iceberg'"
				+ "OR eidos3_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos3_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos3_tim = "
				+ "'Καρότα'"
				+ "OR eidos3_tim = "
				+ "'Μήλα'"
				+ "OR eidos3_tim = "
				+ "'Ελιές'"
				+ "OR eidos3_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos3_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos3_tim = "
				+ "'Φράουλες'"
				+ "OR eidos3_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos3_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos3_tim = "
				+ "'Κεράσια'"
				+ "OR eidos3_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos3_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos3_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos3_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos3_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos4_tim = "
				+ "'Ρόκα'"
				+ "OR eidos4_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos4_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos4_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos4_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos4_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos4_tim = "
				+ "'Πατάτες'"
				+ "OR eidos4_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos4_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos4_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos4_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos4_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos4_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos4_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos4_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos4_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos4_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos4_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos4_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos4_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos4_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos4_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos4_tim = "
				+ "'Άνηθος'"
				+ "OR eidos4_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos4_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos4_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos4_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos4_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos4_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos4_tim = "
				+ "'Iceberg'"
				+ "OR eidos4_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos4_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos4_tim = "
				+ "'Καρότα'"
				+ "OR eidos4_tim = "
				+ "'Μήλα'"
				+ "OR eidos4_tim = "
				+ "'Ελιές'"
				+ "OR eidos4_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos4_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos4_tim = "
				+ "'Φράουλες'"
				+ "OR eidos4_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos4_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos4_tim = "
				+ "'Κεράσια'"
				+ "OR eidos4_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos4_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos4_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos4_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos4_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos5_tim = "
				+ "'Ρόκα'"
				+ "OR eidos5_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos5_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos5_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos5_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos5_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos5_tim = "
				+ "'Πατάτες'"
				+ "OR eidos5_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos5_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos5_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos5_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos5_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos5_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos5_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos5_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos5_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos5_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos5_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos5_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos5_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos5_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos5_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos5_tim = "
				+ "'Άνηθος'"
				+ "OR eidos5_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos5_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos5_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos5_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos5_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos5_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos5_tim = "
				+ "'Iceberg'"
				+ "OR eidos5_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos5_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos5_tim = "
				+ "'Καρότα'"
				+ "OR eidos5_tim = "
				+ "'Μήλα'"
				+ "OR eidos5_tim = "
				+ "'Ελιές'"
				+ "OR eidos5_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos5_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos5_tim = "
				+ "'Φράουλες'"
				+ "OR eidos5_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos5_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos5_tim = "
				+ "'Κεράσια'"
				+ "OR eidos5_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos5_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos5_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos5_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos5_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos6_tim = "
				+ "'Ρόκα'"
				+ "OR eidos6_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos6_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos6_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos6_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos6_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos6_tim = "
				+ "'Πατάτες'"
				+ "OR eidos6_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos6_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos6_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos6_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos6_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos6_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos6_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos6_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos6_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos6_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos6_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos6_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos6_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos6_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos6_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos6_tim = "
				+ "'Άνηθος'"
				+ "OR eidos6_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos6_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos6_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos6_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos6_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos6_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos6_tim = "
				+ "'Iceberg'"
				+ "OR eidos6_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos6_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos6_tim = "
				+ "'Καρότα'"
				+ "OR eidos6_tim = "
				+ "'Μήλα'"
				+ "OR eidos6_tim = "
				+ "'Ελιές'"
				+ "OR eidos6_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos6_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos6_tim = "
				+ "'Φράουλες'"
				+ "OR eidos6_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos6_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos6_tim = "
				+ "'Κεράσια'"
				+ "OR eidos6_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos6_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos6_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos6_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos6_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos7_tim = "
				+ "'Ρόκα'"
				+ "OR eidos7_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos7_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos7_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos7_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos7_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos7_tim = "
				+ "'Πατάτες'"
				+ "OR eidos7_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos7_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos7_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos7_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos7_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos7_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos7_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos7_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos7_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos7_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos7_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos7_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos7_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos7_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos7_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos7_tim = "
				+ "'Άνηθος'"
				+ "OR eidos7_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos7_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos7_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos7_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos7_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos7_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos7_tim = "
				+ "'Iceberg'"
				+ "OR eidos7_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos7_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos7_tim = "
				+ "'Καρότα'"
				+ "OR eidos7_tim = "
				+ "'Μήλα'"
				+ "OR eidos7_tim = "
				+ "'Ελιές'"
				+ "OR eidos7_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos7_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos7_tim = "
				+ "'Φράουλες'"
				+ "OR eidos7_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos7_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos7_tim = "
				+ "'Κεράσια'"
				+ "OR eidos7_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos7_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos7_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos7_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos7_tim = "
				+ "'Λιαστή ντομάτα'"
				+ "OR eidos8_tim = "
				+ "'Ρόκα'"
				+ "OR eidos8_tim = "
				+ "'Μεσκλάν'"
				+ "OR eidos8_tim = "
				+ "'Μαρούλι ίσιο'"
				+ "OR eidos8_tim = "
				+ "'Λολό ρόσσο'"
				+ "OR eidos8_tim = "
				+ "'Ντομάτες'"
				+ "OR eidos8_tim = "
				+ "'Ντοματίνια'"
				+ "OR eidos8_tim = "
				+ "'Πατάτες'"
				+ "OR eidos8_tim = "
				+ "'Πατάτες 10/18'"
				+ "OR eidos8_tim = "
				+ "'Κολοκυθάκια'"
				+ "OR eidos8_tim = "
				+ "'Μελιτζάνες'"
				+ "OR eidos8_tim = "
				+ "'Κρεμμύδι ξερό άσπρο'"
				+ "OR eidos8_tim = "
				+ "'Κρεμμυδάκι φρέσκο'"
				+ "OR eidos8_tim = "
				+ "'Μανιτάρια σαμπινιόν'"
				+ "OR eidos8_tim = "
				+ "'Αγγούρια'"
				+ "OR eidos8_tim = "
				+ "'Πιπεριές φλωρίνης'"
				+ "OR eidos8_tim = "
				+ "'Πιπεριές καυτερές'"
				+ "OR eidos8_tim = "
				+ "'Πατάτες baby'"
				+ "OR eidos8_tim = "
				+ "'Κινέζικο λάχανο'"
				+ "OR eidos8_tim = "
				+ "'Βασιλικός'"
				+ "OR eidos8_tim = "
				+ "'Δυόσμος'"
				+ "OR eidos8_tim = "
				+ "'Μαϊντανός'"
				+ "OR eidos8_tim = "
				+ "'Σκοινόπρασο'"
				+ "OR eidos8_tim = "
				+ "'Άνηθος'"
				+ "OR eidos8_tim = "
				+ "'Θυμάρι'"
				+ "OR eidos8_tim = "
				+ "'Δεντρολίβανο'"
				+ "OR eidos8_tim = "
				+ "'Σκόρδο'"
				+ "OR eidos8_tim = "
				+ "'Σπανάκι'"
				+ "OR eidos8_tim = "
				+ "'Μπρόκολο'"
				+ "OR eidos8_tim = "
				+ "'Κουνουπίδι'"
				+ "OR eidos8_tim = "
				+ "'Iceberg'"
				+ "OR eidos8_tim = "
				+ "'Πορτοκάλια'"
				+ "OR eidos8_tim = "
				+ "'Λεμόνια'"
				+ "OR eidos8_tim = "
				+ "'Καρότα'"
				+ "OR eidos8_tim = "
				+ "'Μήλα'"
				+ "OR eidos8_tim = "
				+ "'Ελιές'"
				+ "OR eidos8_tim = "
				+ "'Ακτινίδια'"
				+ "OR eidos8_tim = "
				+ "'Αχλάδια'"
				+ "OR eidos8_tim = "
				+ "'Φράουλες'"
				+ "OR eidos8_tim = "
				+ "'Πεπόνι'"
				+ "OR eidos8_tim = "
				+ "'Καρπούζι'"
				+ "OR eidos8_tim = "
				+ "'Κεράσια'"
				+ "OR eidos8_tim = "
				+ "'Μπανάνες'"
				+ "OR eidos8_tim = "
				+ "'Νεκταρίνια'"
				+ "OR eidos8_tim = "
				+ "'Ντομάτα κονκασέ'"
				+ "OR eidos8_tim = "
				+ "'Πελτές ντομάτας'"
				+ "OR eidos8_tim = "
				+ "'Λιαστή ντομάτα'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumKreatika() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos1_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos1_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos1_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos1_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos1_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos1_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos1_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos1_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos1_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos1_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos1_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos1_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos1_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos1_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos1_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos2_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos2_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos2_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos2_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos2_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos2_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos2_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos2_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos2_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos2_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos2_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos2_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos2_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos2_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos2_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos2_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos3_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos3_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos3_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos3_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos3_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos3_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos3_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos3_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos3_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos3_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos3_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos3_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos3_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos3_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos3_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos3_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos4_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos4_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos4_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos4_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos4_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos4_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos4_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos4_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos4_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos4_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos4_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos4_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos4_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos4_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos4_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos4_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos5_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos5_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos5_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos5_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos5_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos5_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos5_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos5_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos5_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos5_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos5_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos5_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos5_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos5_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos5_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos5_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos6_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos6_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos6_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos6_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos6_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos6_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos6_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos6_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos6_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos6_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos6_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos6_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos6_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos6_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos6_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos6_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos7_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos7_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos7_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos7_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos7_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos7_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos7_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos7_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos7_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos7_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos7_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos7_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos7_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos7_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos7_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos7_tim = "
				+ "'μοσχαρίσιο rib-eye'"
				+ "OR eidos8_tim = "
				+ "'ζωμός κότας'"
				+ "OR eidos8_tim = "
				+ "'μπέικον φέτες'"
				+ "OR eidos8_tim = "
				+ "'γαλοπούλα φέτες'"
				+ "OR eidos8_tim = "
				+ "'ζαμπόν φέτες'"
				+ "OR eidos8_tim = "
				+ "'λουκάνικα πιπερόνε'"
				+ "OR eidos8_tim = "
				+ "'σαλάμι μπύρας'"
				+ "OR eidos8_tim = "
				+ "'σαλάμι αέρος'"
				+ "OR eidos8_tim = "
				+ "'στήθος κοτόπουλο'"
				+ "OR eidos8_tim = "
				+ "'μπούτι κοτόπουλο'"
				+ "OR eidos8_tim = "
				+ "'ψαρονέφρι'"
				+ "OR eidos8_tim = "
				+ "'χοιρινός λεμός'"
				+ "OR eidos8_tim = "
				+ "'μοσχαρίσιος κυμάς'"
				+ "OR eidos8_tim = "
				+ "'χοιρίνός κυμάς'"
				+ "OR eidos8_tim = "
				+ "'χοιρινή παντσέτα χωρίς κόκκαλο'"
				+ "OR eidos8_tim = "
				+ "'μοσχαρίσια γλώσσα'"
				+ "OR eidos8_tim = "
				+ "'μοσχαρίσιο rib-eye'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumTirokomika() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eidos1_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos1_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos1_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos1_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos1_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos1_tim = "
				+ "'μανούρι'"
				+ "OR eidos1_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos1_tim = "
				+ "'χαλούμι'"
				+ "OR eidos1_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos1_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos1_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos1_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos1_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos1_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos1_tim = "
				+ "'lurpak'"
				+ "OR eidos1_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos1_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos1_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos1_tim = "
				+ "'γάλα'"
				+ "OR eidos2_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos2_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos2_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos2_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos2_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos2_tim = "
				+ "'μανούρι'"
				+ "OR eidos2_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos2_tim = "
				+ "'χαλούμι'"
				+ "OR eidos2_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos2_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos2_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos2_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos2_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos2_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos2_tim = "
				+ "'lurpak'"
				+ "OR eidos2_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos2_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos2_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos2_tim = "
				+ "'γάλα'"
				+ "OR eidos3_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos3_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos3_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos3_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos3_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos3_tim = "
				+ "'μανούρι'"
				+ "OR eidos3_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos3_tim = "
				+ "'χαλούμι'"
				+ "OR eidos3_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos3_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos3_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos3_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos3_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos3_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos3_tim = "
				+ "'lurpak'"
				+ "OR eidos3_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos3_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos3_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos3_tim = "
				+ "'γάλα'"
				+ "OR eidos3_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos3_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos3_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos3_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos3_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos3_tim = "
				+ "'μανούρι'"
				+ "OR eidos3_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos3_tim = "
				+ "'χαλούμι'"
				+ "OR eidos3_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos3_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos3_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos3_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos3_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos3_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos3_tim = "
				+ "'lurpak'"
				+ "OR eidos3_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos3_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos3_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos3_tim = "
				+ "'γάλα'"
				+ "OR eidos4_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos4_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos4_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos4_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos4_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos4_tim = "
				+ "'μανούρι'"
				+ "OR eidos4_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos4_tim = "
				+ "'χαλούμι'"
				+ "OR eidos4_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos4_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos4_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos4_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos4_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos4_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos4_tim = "
				+ "'lurpak'"
				+ "OR eidos4_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos4_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos4_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos4_tim = "
				+ "'γάλα'"
				+ "OR eidos5_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos5_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos5_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos5_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos5_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos5_tim = "
				+ "'μανούρι'"
				+ "OR eidos5_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos5_tim = "
				+ "'χαλούμι'"
				+ "OR eidos5_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos5_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos5_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos5_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos5_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos5_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos5_tim = "
				+ "'lurpak'"
				+ "OR eidos5_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos5_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos5_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos5_tim = "
				+ "'γάλα'"
				+ "OR eidos6_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos6_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos6_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos6_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos6_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos6_tim = "
				+ "'μανούρι'"
				+ "OR eidos6_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos6_tim = "
				+ "'χαλούμι'"
				+ "OR eidos6_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos6_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos6_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos6_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos6_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos6_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos6_tim = "
				+ "'lurpak'"
				+ "OR eidos6_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos6_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos6_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos6_tim = "
				+ "'γάλα'"
				+ "OR eidos7_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos7_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos7_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos7_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos7_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos7_tim = "
				+ "'μανούρι'"
				+ "OR eidos7_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos7_tim = "
				+ "'χαλούμι'"
				+ "OR eidos7_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos7_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos7_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos7_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos7_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos7_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos7_tim = "
				+ "'lurpak'"
				+ "OR eidos7_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos7_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos7_tim = "
				+ "'φέτα αγελαδινή'"
				+ "OR eidos7_tim = "
				+ "'γάλα'"
				+ "OR eidos8_tim = "
				+ "'κρέμα γάλακτος'"
				+ "OR eidos8_tim = "
				+ "'γιαούρτι'"
				+ "OR eidos8_tim = "
				+ "'γκούντα φέτες'"
				+ "OR eidos8_tim = "
				+ "'γκούντα τριμένη'"
				+ "OR eidos8_tim = "
				+ "'παρμεζάνα τριμένη'"
				+ "OR eidos8_tim = "
				+ "'μανούρι'"
				+ "OR eidos8_tim = "
				+ "'μοτσαρέλα νερού'"
				+ "OR eidos8_tim = "
				+ "'χαλούμι'"
				+ "OR eidos8_tim = "
				+ "'παρμεζάνα κεφάλι'"
				+ "OR eidos8_tim = "
				+ "'γραβιέρα'"
				+ "OR eidos8_tim = "
				+ "'κρέμα τυριού buko'"
				+ "OR eidos8_tim = "
				+ "'κρέμα τυριού'"
				+ "OR eidos8_tim = "
				+ "'ημίσκληρο κασέρι'"
				+ "OR eidos8_tim = "
				+ "'μυζήθρα'"
				+ "OR eidos8_tim = "
				+ "'lurpak'"
				+ "OR eidos8_tim = "
				+ "'ρεγγάτο'"
				+ "OR eidos8_tim = "
				+ "'βούτυρο 5kg'"
				+ "OR eidos8_tim = "
				+ "'φέτα αγελαδινή'" + "OR eidos8_tim = " + "'γάλα'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumEtos() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%Y', date_tim) = strftime('%Y', 'now')";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumHmerisia() {
		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%d', date_tim) = strftime('%d', 'now')";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumEvdomada() {
		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%W', date_tim) = strftime('%W', 'now')";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumAll() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia ";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public List<String> getAllEponimies() {
		List<String> eponimies = new ArrayList<String>();
		// Select All Query
		String selectQuery = "SELECT eponimia_user  FROM " + TABLE_CONTACTS;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				eponimies.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}

		// closing connection
		cursor.close();
		db.close();

		// returning lables
		return eponimies;
	}

	public String getSumPromitheuti() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE eponimia_tim ='"
				+ SinolikoPosoPromitheuti.item + "'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

	public String getSumPromitheutiEvdomadas() {

		String sumresult = null;
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT SUM(timi_tim) FROM timologia WHERE strftime('%W', date_tim) = strftime('%W', 'now')"
				+ "AND eponimia_tim ='"
				+ EvdomadieoPosoPromitheuti.evdomadieoitem + "'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				sumresult = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		return sumresult;
	}

}
