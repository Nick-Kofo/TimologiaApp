package com.cooper.timologia;

public class Contact {

    // private variables
    public int _id;
    public String _name;
    public String _epitheto;
    public String _phone_number;
    public String _stathero;
    public String _email;
    public String _eidos;
    public String _eponimia_user;
    public String _afm;
    public String _eidos2;
    public String _eidos3;

    public Contact() {
    }

    // constructor
    public Contact(int id, String name, String epitheto, String _phone_number,String _stathero, String _email, String _eidos, String _eponimia_user, String _afm, String _eidos2, String _eidos3) {
	this._id = id;
	this._name = name;
	this._epitheto = epitheto;
	this._phone_number = _phone_number;
	this._stathero = _stathero;
	this._email = _email;
	this._eidos = _eidos;
	this._eponimia_user = _eponimia_user;
	this._afm = _afm;
	this._eidos2 = _eidos2;
	this._eidos3 = _eidos3;
	

    }

    // constructor
    public Contact(String name,String epitheto, String _phone_number, String _stathero, String _email, String _eidos, String _eponimia_user, String _afm, String _eidos2, String _eidos3) {
	this._name = name;
	this._epitheto = epitheto;
	this._phone_number = _phone_number;
	this._stathero = _stathero;
	this._email = _email;
	this._eidos = _eidos;
	this._eponimia_user = _eponimia_user;
	this._afm = _afm;
	this._eidos2 = _eidos2;
	this._eidos3 = _eidos3;
    }
    
    public Contact(String epitheto,String _eidos, String _phone_number) {
    	this._epitheto = epitheto;
    	this._eidos = _eidos;
    	this._phone_number = _phone_number;
        }

    // getting ID
    public int getID() {
	return this._id;
    }

    // setting id
    public void setID(int id) {
	this._id = id;
    }

    // getting name
    public String getName() {
	return this._name;
    }

    // setting name
    public void setName(String name) {
	this._name = name;
    }
    
    // getting epitheto
    public String getEpitheto() {
	return this._epitheto;
    }

    // setting name
    public void setEpitheto(String epitheto) {
	this._epitheto = epitheto;
    }

    // getting phone number
    public String getPhoneNumber() {
	return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number) {
	this._phone_number = phone_number;
    }
    
    // getting phone number
    public String getStathero() {
	return this._stathero;
    }

    // setting phone number
    public void setStathero(String stathero) {
	this._stathero = stathero;
    }

    // getting email
    public String getEmail() {
	return this._email;
    }

    // setting email
    public void setEmail(String email) {
	this._email = email;
    }
    
    // getting eidos
    public String getEidos() {
	return this._eidos;
    }

    // setting eidos
    public void setEidos(String eidos) {
	this._eidos = eidos;
    }
    
    // getting eponimia user
    public String getEponimiaUser() {
	return this._eponimia_user;
    }

    // setting eponimia user
    public void setEponimiaUser(String eponimia_user) {
	this._eponimia_user = eponimia_user;
    }
    
    // getting afm
    public String getAFM() {
	return this._afm;
    }

    // setting afm
    public void setAFM(String afm) {
	this._afm = afm;
    }
    

    // getting eidos2
    public String getEidos2() {
	return this._eidos2;
    }

    // setting eidos2
    public void setEidos2(String eidos2) {
	this._eidos2 = eidos2;
    }
    
    // getting eidos3
    public String getEidos3() {
	return this._eidos3;
    }

    // setting eidos3
    public void setEidos3(String eidos3) {
	this._eidos3 = eidos3;
    }



}