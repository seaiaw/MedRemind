package com.medremind.sg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	static final String dbName = "medRemindDB";
	static final String medicineTable = "Medicine";
	static final String colMedName = "MedicineName";
	static final String colMedDosage = "MedicineDosage";
	static final String colMedPhoto = "MedicinePhoto";
	
	static final String alarmTable = "Alarm";
	static final String colTime = "MedicineTime";
	static final String colRecurrence = "Recurrence";
	
	public DatabaseHelper (Context context){
		super(context, dbName, null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + medicineTable + " (" + colMedName + " TEXT PRIMARY KEY, ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}