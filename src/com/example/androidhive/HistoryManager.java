package com.example.androidhive;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class HistoryManager 
{

	public static final String KEY_ROWID= "_id";
	public static final String KEY_CONTENT="content";
	public static final String KEY_BARCODE_TYPE="barcode_type";
	public static final String KEY_CONTENT_TYPE="content_type";
	
	
	private static final String DATABASE_NAME = "history_manager";
	private static final String DATABASE_TABLE = "history";
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContex;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{
	
		public DbHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE "+ DATABASE_TABLE + " ("+
					KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
					KEY_CONTENT+" TEXT NOT NULL, "+
					KEY_BARCODE_TYPE+" TEXT NOT NULL, "+
					KEY_CONTENT_TYPE+")"
					);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXIST"+DATABASE_TABLE);
			onCreate(db);
		}
	}
	public HistoryManager(Context c)
	{
		ourContex = c;
		
	}
	public HistoryManager open() throws SQLiteException
	{
		ourHelper = new DbHelper(ourContex);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close() {
		// TODO Auto-generated method stub
		ourHelper.close();
		
	}
	public long createEntry(String content, String barcode_type,String content_type) {
		// TODO Auto-generated method stub
		ContentValues cv =new ContentValues();
		
		cv.put(KEY_CONTENT, content);
		cv.put(KEY_BARCODE_TYPE, barcode_type);
		cv.put(KEY_CONTENT_TYPE, content_type);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}
	public String getData() {
		
		String [] columns = new String[]{KEY_ROWID,KEY_CONTENT,KEY_BARCODE_TYPE,KEY_CONTENT_TYPE};
		Cursor c = ourDatabase .query(DATABASE_TABLE,columns,null,null,null,null,null);
		String result="";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iContent = c.getColumnIndex(KEY_CONTENT);
		int iBarcode_type = c.getColumnIndex(KEY_BARCODE_TYPE);
		int iContent_type = c.getColumnIndex(KEY_CONTENT_TYPE);
		
		for (c.moveToFirst();!c.isAfterLast();c.moveToNext()) 
		{
			result = result + c.getString(iRow)+" "+c.getString(iContent)+" "+c.getString(iBarcode_type)+"\n";
			
		}
				
		return result;
	}
	public String getName(long l) 
	{
		String [] columns = new String[]{KEY_ROWID,KEY_CONTENT,KEY_BARCODE_TYPE,KEY_CONTENT_TYPE};
		Cursor c= ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="+l, null, null, null, null);
		if(c!=null)
		{
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}
	public String getHotness(long l) 
	{
		String [] columns = new String[]{KEY_ROWID,KEY_CONTENT,KEY_BARCODE_TYPE,KEY_CONTENT_TYPE};
		Cursor c= ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="+l, null, null, null, null);
		if(c!=null)
		{
			c.moveToFirst();
			String hotness = c.getString(2);
			return hotness;
		}
		return null;
	}
	public void updateEntry(long lRow, String eContent, String eContent_type,String eBarcode_type) 
	{
		ContentValues cv = new ContentValues();
		cv.put(KEY_ROWID, lRow);
		cv.put(KEY_CONTENT, eContent);
		cv.put(KEY_BARCODE_TYPE,eBarcode_type);
		cv.put(KEY_CONTENT_TYPE,eContent_type);
		
		ourDatabase.update(DATABASE_TABLE, cv, KEY_ROWID + "=" + lRow, null);
		
		
		
	}
	public void deleteEntry(long lRow1, String eName1, String eHotness1) 
	{
		
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "="+ lRow1, null);
		
	}
	 
	public ArrayList<String> getDatabaseContent() 
	{
		ArrayList<String> results = new ArrayList<String>();
		
		String [] columns = new String[]{KEY_ROWID,KEY_CONTENT,KEY_BARCODE_TYPE,KEY_CONTENT_TYPE};
		Cursor c = ourDatabase .query(DATABASE_TABLE,columns,null,null,null,null,null);
		
		int count=0;
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iContent = c.getColumnIndex(KEY_CONTENT);
		int iBarcode_type = c.getColumnIndex(KEY_BARCODE_TYPE);
		int iContent_type = c.getColumnIndex(KEY_CONTENT_TYPE);
		
		for (c.moveToFirst();!c.isAfterLast();c.moveToNext()) 
		{
			results.add(count+" :"+c.getString(c.getColumnIndex("id"))
		             +" "+c.getString(c.getColumnIndex("data"))
		             +" ("+c.getInt(c.getColumnIndex("format"))+")");
		}
				
		return results;
		
	}
	
	
	
}

