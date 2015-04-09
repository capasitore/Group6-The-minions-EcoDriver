package SQLiteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jied on 01/04/15.
 * DB connnector.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_RECORDS = "records";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_RECORD = "record";
    public static final String COLUMN_STARTPLACE = "startPlace";
    public static final String COLUMN_DESTINATION = "destination";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_DURATION = "timeDuration";
    public static final String COLUMN_AVGSPEED = "avgSpeed";
    public static final String COLUMN_AVGRPM = "avgRPM";
    public static final String COLUMN_FUEL = "fuelConsume";
    public static final String COLUMN_EMISSION = "emissionCO2";

    private static final String DATABASE_NAME = "drive_records.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + TABLE_RECORDS + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_RECORD + " text not null, "
            + COLUMN_STARTPLACE + " text, "
            + COLUMN_DESTINATION + " text, "
            + COLUMN_DISTANCE + " integer, "
            + COLUMN_DURATION + " text, "
            + COLUMN_AVGSPEED + " integer, "
            + COLUMN_AVGRPM + " integer, "
            + COLUMN_FUEL + " integer, "
            + COLUMN_EMISSION + " integer);";

    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion
                        + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORDS);
        onCreate(db);
    }
}