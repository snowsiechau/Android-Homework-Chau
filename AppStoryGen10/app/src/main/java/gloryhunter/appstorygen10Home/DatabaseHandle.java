package gloryhunter.appstorygen10Home;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SNOW on 9/5/2017.
 */

public class DatabaseHandle {
    private static final String TAG = "ListStory";
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context){
        myDatabase = new MyDatabase(context);
    }

    private static DatabaseHandle databaseHandle;

    public static DatabaseHandle getInstance(Context context){
        if (databaseHandle == null) {
            databaseHandle = new DatabaseHandle(context);
        }
        return databaseHandle;
    }

    private SQLiteDatabase sqLiteDatabase;

    public List<StoryModel> getListStory(){
        List<StoryModel> storyModelList = new ArrayList<>();

        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor =  sqLiteDatabase.rawQuery("SELECT * FROM tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            // get data
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = cursor.getInt(6) != 0;

            StoryModel storyModel = new StoryModel(id, image, title, description, content, author, bookmark);

            storyModelList.add(storyModel);

            //next data
            cursor.moveToNext();
        }
        Log.d(TAG, "getHistory: " + storyModelList.toString());

        return storyModelList;
    }

}
