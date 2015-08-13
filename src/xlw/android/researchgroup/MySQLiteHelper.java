package xlw.android.researchgroup;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_FAVORITES = "favorites";
  public static final String COLUMN_ID = "_id";
  
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_POSITION = "position";
  public static final String COLUMN_DEPARTMENT = "department";
  public static final String COLUMN_UNIVERSITY = "university";
  public static final String COLUMN_INTEREST = "interest";
  public static final String COLUMN_RESEARCHAREA = "research_area";
  public static final String COLUMN_PAGENUMBER = "page_number";
  public static final String COLUMN_ELEMENT = "element";
  
  public static final String COLUMN_COMMENT = "comment";

  private static final String DATABASE_NAME = "favorites.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_FAVORITES + "(" + COLUMN_ID
      + " integer primary key autoincrement," +
      COLUMN_NAME
      + " text,"+
      COLUMN_POSITION
      + " text not null,"+
      COLUMN_DEPARTMENT
      + " text not null,"+
      COLUMN_UNIVERSITY
      + " text not null,"+
      COLUMN_INTEREST
      + " text not null,"+
      COLUMN_RESEARCHAREA
      + " integer,"+
      COLUMN_PAGENUMBER
      + " INTEGER,"+
      COLUMN_ELEMENT
      + " INTEGER,"+
      COLUMN_COMMENT
      + " text"+");";

  public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
    onCreate(db);
  }

} 