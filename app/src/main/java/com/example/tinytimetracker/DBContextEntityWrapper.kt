package com.example.tinytimetracker
import android.content.Context
import android.text.format.DateUtils
import java.sql.Date
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DBContextEntityWrapper
{
    private var dbContext_: DBAccessor? = null;
    private var _context: Context? = null;
    constructor(context: Context, DBName: String = "Default.db"){
        this.dbContext_ = DBAccessor(context,DBName);
        this._context = context;
        CreateBookingTable()
        CreateStatusTable()

    }

    private fun CreateStatusTable(){
        val CREATE_STATUS_TABLE_QUERY: String = "CREATE TABLE IF NOT EXISTS Status (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR(256))"
        this.dbContext_?.executeSQLCommand(CREATE_STATUS_TABLE_QUERY);
    }

    private fun CreateBookingTable(){
        val CREATE_BOOKING_TABLE_QUERY: String = "CREATE TABLE IF NOT EXISTS Bookings (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR(256), TIMESTAMP VARCHAR(256))"
        this.dbContext_?.executeSQLCommand(CREATE_BOOKING_TABLE_QUERY);
    }

    fun getBookings(): List<Booking>?{
        var bookings: MutableList<Booking>? = null
        val result = this.dbContext_?.executeQuery("SELECT * FROM Bookings");
        if (result != null && result?.count > 0)
        {
            bookings = mutableListOf<Booking>()
            if (result.moveToFirst()) {
                do {
                    val book = Booking()
                    book.ID = result.getString(result.getColumnIndex("ID")).toInt()
                    book.Name = result.getString(result.getColumnIndex("NAME"))
                    var timeStringValue:String = result.getString(result.getColumnIndex("TIMESTAMP"))

                    var vale = Date.parse(timeStringValue);
                    var time = java.util.Calendar.getInstance().time as java.util.Date?
                    time?.time = vale;

                    bookings.add(book)
                }
                while (result.moveToNext())
            }
        }
        return bookings;
    }

    fun addBookingEntry (tableName: String){
        var time = java.util.Calendar.getInstance().time as java.util.Date?
        val val0:String? = time?.toString()
        val val1:String ="Test2";
        val result = this.dbContext_?.executeSQLCommand("INSERT INTO Bookings (ID, NAME,TIMESTAMP) VALUES (NULL,'" + val1 + "','"+ val0 + "')")
    }
}