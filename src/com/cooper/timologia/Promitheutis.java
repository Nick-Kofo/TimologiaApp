package com.cooper.timologia;


		
import java.util.ArrayList;







import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cooper.timologia.R;


public class Promitheutis extends Activity implements Comparable<Promitheutis>  {
    Button add_btn;
    ListView Contact_listview;
    ArrayList<Contact> contact_data = new ArrayList<Contact>();
    Contact_Adapter cAdapter;
    DatabaseHandler db;
    String Toast_msg,  eponimia, mobile, eidos;
    EditText search_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	try {
	    Contact_listview = (ListView) findViewById(R.id.list);
	    Contact_listview.setItemsCanFocus(false);
	    add_btn = (Button) findViewById(R.id.add_btn);
	    

	    Set_Referash_Data();
	    registerClickCallback();
	    
	    search_view = (EditText) findViewById(R.id.search_view);
	    
	    search_view.addTextChangedListener(new TextWatcher() {
	    	 
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = search_view.getText().toString().toLowerCase(Locale.getDefault());
                cAdapter.filter(text);
            }
 
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                    int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
 
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
            }
        });


	} catch (Exception e) {
	    // TODO: handle exception
	    Log.e("some error", "" + e);
	}
	add_btn.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent add_user = new Intent(Promitheutis.this,
			Add_Update_User.class);
		add_user.putExtra("called", "add");
		add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
			| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(add_user);
		finish();
	    }
	});

    }



    

    private void registerClickCallback() {
		// TODO Auto-generated method stub

		Contact_listview
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent,
							View viewClicked, int position, long id) {
						// TODO Auto-generated method stub

						Intent add_tim = new Intent(Promitheutis.this,
								SinoloPromitheuti.class);
						add_tim.putExtra("called", "add");
						add_tim.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
								| Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(add_tim);
						finish();
					}
				});

	}





	public void Set_Referash_Data() {
	contact_data.clear();
	db = new DatabaseHandler(this);
	ArrayList<Contact> contact_array_from_db = db.Get_Contacts();

	for (int i = 0; i < contact_array_from_db.size(); i++) {

	    int tidno = contact_array_from_db.get(i).getID();
	   
	     eponimia = contact_array_from_db.get(i).getEponimiaUser();
	     mobile = contact_array_from_db.get(i).getPhoneNumber();
	     eidos = contact_array_from_db.get(i).getEidos();
	    
	    Contact cnt = new Contact();
	    
	    cnt.setID(tidno);
	    cnt.setEponimiaUser(eponimia);
	    cnt.setEidos(eidos);
	    cnt.setPhoneNumber(mobile);

	   
	    
	    contact_data.add(cnt);
	    
	    Collections.sort(contact_data, new Comparator<Contact>() {
	        public int compare(Contact one, Contact other) {
	            return one.getEponimiaUser().compareTo(other.getEponimiaUser());
	        }
	    }); 
	    
	    Collections.sort(contact_data, Promitheutis.COMPARE_BY_EPONIMIA);
	}
	db.close();
	cAdapter = new Contact_Adapter(Promitheutis.this, contact_data);
	Contact_listview.setAdapter(cAdapter);
	cAdapter.notifyDataSetChanged();
    }

    public void Show_Toast(String msg) {
	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	Set_Referash_Data();

    }
    
    

    public class Contact_Adapter extends BaseAdapter   {
	
    	
	Context mContext;
	LayoutInflater inflater;
	private List<Contact> contactList = null;
	private ArrayList<Contact> contact_data;
	
	
	 public Contact_Adapter(Context context,
	            List<Contact> contactList) {
	        mContext = context;
	        this.contactList = contactList;
	        inflater = LayoutInflater.from(mContext);
	        this.contact_data = new ArrayList<Contact>();
	        this.contact_data.addAll(contactList);
	    }
	 
	 public	class UserHolder {
		    
		    TextView eponimia;
		    TextView eidos;
		    TextView number;
		    
		    Button edit;
		    Button delete;
		    Button call;
		}
	 
	 
	 @Override
	    public int getCount() {
	        return contactList.size();
	    }
	
	 @Override
	    public Contact getItem(int position) {
	        return contactList.get(position);
	    }
	 @Override
	    public long getItemId(int position) {
	        return position;
	    }
	

	
	public View getView(final int position, View View, ViewGroup parent) {
		final UserHolder holder;
		
		
	    

	    if (View == null) {
	    	
	    	holder = new UserHolder();
	    	View = inflater.inflate(R.layout.listview_row, null);
	    	
		

		
		
		
		holder.eponimia = (TextView) View.findViewById(R.id.user_eponimia_txt);
		holder.eidos = (TextView) View.findViewById(R.id.user_eidos_txt);
		holder.number = (TextView) View.findViewById(R.id.user_mobile_txt);
		holder.edit = (Button) View.findViewById(R.id.btn_update);
		holder.delete = (Button) View.findViewById(R.id.btn_delete);
		holder.call = (Button) View.findViewById(R.id.btn_call);
		View.setTag(holder);
	    } else {
		holder = (UserHolder) View.getTag();
	    }
	    holder.eponimia.setText(contactList.get(position).getEponimiaUser());
	    holder.eidos.setText(contactList.get(position).getEidos());
	    holder.number.setText(contactList.get(position).getPhoneNumber());
	    
	    holder.edit.setTag(contactList.get(position).getID());
	    holder.delete.setTag(contactList.get(position).getID());
	    holder.call.setTag(contactList.get(position).getID());
	    
	
	    final String phone_no= holder.number.getText().toString().replaceAll("-", "");
	    
	    
	   /* holder.number.setOnClickListener(new View.OnClickListener() {

	        @Override
	        public void onClick(View arg0) {
	            // TODO Auto-generated method stub
	            
	            Intent callIntent = new Intent(Intent.ACTION_CALL);
	            callIntent.setData(Uri.parse("tel:"+phone_no));
	            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	            startActivity(callIntent);
	        }
	    });*/
	    
	    
	

	    holder.edit.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		    // TODO Auto-generated method stub
		    Log.i("Edit Button Clicked", "**********");

		    Intent update_user = new Intent(mContext,
			    Update_User.class);
		    update_user.putExtra("called", "update");
		    update_user.putExtra("USER_ID", v.getTag().toString());
		    mContext.startActivity(update_user);
		    
		   
		}
	    });
	    
	    
	    holder.call.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			    // TODO Auto-generated method stub
				
				
				
				Intent callIntent = new Intent(Intent.ACTION_CALL);
	            callIntent.setData(Uri.parse("tel:"+phone_no));
	            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	            startActivity(callIntent);
			       
			}
		    });
	    
	    
	    
	    
	    
	    holder.delete.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(final View v) {
		    // TODO Auto-generated method stub

		    // show a message while loader is loading

		    AlertDialog.Builder adb = new AlertDialog.Builder(mContext);
		    adb.setTitle("Διαγραφή;");
		    adb.setMessage("Είστε σίγουρος για τη διαγραφή; ");
		    final int user_id = Integer.parseInt(v.getTag().toString());
		    adb.setNegativeButton("Άκυρο", null);
		    adb.setPositiveButton("Ok",
			    new AlertDialog.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog,
					int which) {
				    // MyDataObject.remove(positionToRemove);
				    DatabaseHandler dBHandler = new DatabaseHandler(
				    		mContext.getApplicationContext());
				    dBHandler.Delete_Contact(user_id);
				    Promitheutis.this.onResume();

				}
			    });
		    adb.show();
		}

	    });
	    return View;

	}
	
	
	
	public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        contactList.clear();
        if (charText.length() == 0) {
        	contactList.addAll(contact_data);
        } else {
            for (Contact cnt : contact_data) {
                if (cnt.getEponimiaUser().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                	contactList.add(cnt);
                }
            }
        }
        notifyDataSetChanged();
    }
	
	
	
	

    }

	@Override
	public int compareTo(Promitheutis another) {
		// TODO Auto-generated method stub
		return eponimia.compareTo(another.eponimia);
	}
	
	 public static Comparator<Contact> COMPARE_BY_EPONIMIA = new Comparator<Contact>() {
	        public int compare(Contact one, Contact other) {
	            return one._eponimia_user.compareTo(other._eponimia_user);
	        }
	    };
}

