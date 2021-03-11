package com.example.tinytimetracker

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"

public class DBAccessor (var context: Context, val dbName: String) : SQLiteOpenHelper(context, dbName, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        //db.execSQL(SQL_CREATE_ENTRIES)
        //this.db_ = db;
        //val createTable = "CREATE TABLE " + dbTable + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_AGE + " INTEGER)"
        //db?.execSQL(createTable)
    }
    private var db_: SQLiteDatabase? = null

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    public fun executeQuery(queryToExecute: String): Cursor?{
        var returnValue: Cursor? = null;

        try{

            returnValue = this.readableDatabase.rawQuery(queryToExecute,null);

        }
        catch (e:Exception){
            returnValue = null;

        }

        return returnValue;
    }

    public fun executeSQLCommand(commandToExecute: String): Object?{
        var returnValue: Object? = null;

        try{
            this.writableDatabase.execSQL(commandToExecute);

        }
        catch (e:Exception){
            returnValue = null;

        }

        return returnValue;
    }



    public fun getTest(Table: String): String{
        val db = this.readableDatabase
        val query = "Select * from $Table"
        val result = db.rawQuery(query, null)
        return result.toString();
    }

}