package xlw.android.researchgroup;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class FavoriteDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
		  MySQLiteHelper.COLUMN_NAME,
		  MySQLiteHelper.COLUMN_POSITION,
          MySQLiteHelper.COLUMN_DEPARTMENT,
          MySQLiteHelper.COLUMN_UNIVERSITY,
          MySQLiteHelper.COLUMN_INTEREST,
          MySQLiteHelper.COLUMN_RESEARCHAREA,
          MySQLiteHelper.COLUMN_PAGENUMBER,
          MySQLiteHelper.COLUMN_ELEMENT,	  
          MySQLiteHelper.COLUMN_COMMENT };

  public FavoriteDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Favorite createFavorite(String favorite,
		  CharSequence name,
          CharSequence position,
          CharSequence department,
          CharSequence university,
   CharSequence interest,
   int ResearchArea,
   int PageNumber,
   int element) {
    ContentValues values = new ContentValues();
    System.out.println("Favorite inserted with name: " + name.toString());
    values.put(MySQLiteHelper.COLUMN_NAME, name.toString());
    values.put(MySQLiteHelper.COLUMN_POSITION, position.toString());
    values.put(MySQLiteHelper.COLUMN_DEPARTMENT, department.toString());
    values.put(MySQLiteHelper.COLUMN_UNIVERSITY, university.toString());
    values.put(MySQLiteHelper.COLUMN_INTEREST, interest.toString());
    values.put(MySQLiteHelper.COLUMN_RESEARCHAREA, ResearchArea);
    values.put(MySQLiteHelper.COLUMN_PAGENUMBER, PageNumber);
    values.put(MySQLiteHelper.COLUMN_ELEMENT, element);
    values.put(MySQLiteHelper.COLUMN_COMMENT, favorite);
    
    long insertId = database.insert(MySQLiteHelper.TABLE_FAVORITES, null,
        values);
    
    System.out.println("Favorite inserted with id: " + insertId);
    
    Cursor cursor = database.query(MySQLiteHelper.TABLE_FAVORITES,
        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Favorite newFavorite = cursorToFavorite(cursor);
    cursor.close();
    
    
    return null;
  }

  public void deleteFavorite(Favorite favorite) {
    long id = favorite.getId();
    System.out.println("Favorite deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_FAVORITES, MySQLiteHelper.COLUMN_ID
        + " = " + id, null);
  }

  public List<Favorite> getAllFavorites() {
    List<Favorite> favorites = new ArrayList<Favorite>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_FAVORITES,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
    	Favorite favorite = cursorToFavorite(cursor);
      favorites.add(favorite);
      cursor.moveToNext();
    }
    // make sure to close the cursor
    cursor.close();
    return favorites;
  }

  Favorite cursorToFavorite(Cursor cursor) {
	  Favorite favorite = new Favorite();
    favorite.setId(cursor.getLong(0));
    favorite.setname(cursor.getString(1));
    favorite.setposition(cursor.getString(2));
    favorite.setdepartment(cursor.getString(3));
    favorite.setuniversity(cursor.getString(4));
    favorite.setinterest(cursor.getString(5));
    favorite.setResearchArea(cursor.getInt(6));
    favorite.setPageNumber(cursor.getInt(7));
    favorite.setelement(cursor.getInt(8));
    favorite.setComment(cursor.getString(9));
    return favorite;
  }
  
  Cursor queryfromFavorite(long column_id){
	  
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_FAVORITES,
              allColumns, MySQLiteHelper.COLUMN_ID + " = " + column_id, null,
              null, null, null);
	  
	  return cursor;
  }
  
  Cursor queryfromFavorite_ResearchArea_PageNumber(int ResearchArea, int PageNumber){
	  
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_FAVORITES,
              allColumns, MySQLiteHelper.COLUMN_RESEARCHAREA + " = " + ResearchArea+" AND "
              + MySQLiteHelper.COLUMN_PAGENUMBER + " = " + PageNumber, null,
              null, null, null);
	  
	  return cursor;
  }
  
  Cursor queryfromFavorite_Element(int Element){
	  
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_FAVORITES,
              allColumns, MySQLiteHelper.COLUMN_ELEMENT + " = " + Element, null,
              null, null, null);
	  
	  return cursor;
  }
  
  Cursor queryfromFavorite_Name(String Name){
	  
	  Cursor cursor = database.query(MySQLiteHelper.TABLE_FAVORITES,
              allColumns, MySQLiteHelper.COLUMN_NAME + " = '" + Name+"'", null,
              null, null, null);
	  
	  return cursor;
  }
  
  
  
  
} 
