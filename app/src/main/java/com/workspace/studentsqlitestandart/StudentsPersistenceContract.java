package com.workspace.studentsqlitestandart;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.compat.BuildConfig;

/**
 * Created by ducviet on 30/08/2017.
 */

public class StudentsPersistenceContract {
    public static final String CONTENT_AUTHORITY = BuildConfig.APPLICATION_ID;
    public static final String CONTENT_TASK_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + StudentEntry.TABLE_NAME;
    public static final String CONTENT_TASK_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + StudentEntry.TABLE_NAME;
    public static final String VND_ANDROID_CURSOR_ITEM_VND = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".";
    private static final String CONTENT_SCHEME = "content://";
    public static final Uri BASE_CONTENT_URI = Uri.parse(CONTENT_SCHEME + CONTENT_AUTHORITY);
    private static final String VND_ANDROID_CURSOR_DIR_VND = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".";
    private static final String SEPARATOR = "/";

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StudentsPersistenceContract() {}

    public static Uri getBaseTaskUri(String taskId) {
        return Uri.parse(CONTENT_SCHEME + CONTENT_TASK_ITEM_TYPE + SEPARATOR + taskId);
    }

    /* Inner class that defines the table contents */
    public static abstract class StudentEntry implements BaseColumns {

        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL_= "email";
        public static final String COLUMN_NAME_AGE = "age";
        public static final Uri CONTENT_TASK_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        public static String[] TASKS_COLUMNS = new String[]{
                StudentEntry._ID,
                StudentEntry.COLUMN_NAME_ENTRY_ID,
                StudentEntry.COLUMN_NAME_NAME,
                StudentEntry.COLUMN_NAME_EMAIL_,
                StudentEntry.COLUMN_NAME_AGE};

        public static Uri buildTasksUriWith(long id) {
            return ContentUris.withAppendedId(CONTENT_TASK_URI, id);
        }

        public static Uri buildTasksUriWith(String id) {
            Uri uri = CONTENT_TASK_URI.buildUpon().appendPath(id).build();
            return uri;
        }

        public static Uri buildTasksUri() {
            return CONTENT_TASK_URI.buildUpon().build();
        }

    }
}
