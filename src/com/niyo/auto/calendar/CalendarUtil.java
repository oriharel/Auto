package com.niyo.auto.calendar;

import java.util.Map;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
//import android.provider.CalendarContract;
import android.text.format.Time;

public class CalendarUtil 
{
	
	public Map<String, Object> getMyNextEvent(Activity context)
	{
		ContentResolver resolver = context.getContentResolver();

//		Uri uri = CalendarContract.Events.CONTENT_URI;
//		String[] projection = new String[] {
//				CalendarContract.Events.TITLE,
//				CalendarContract.Events.DTSTART
//		};
//		
//		Time now = new Time();
//		now.setToNow();
//		String selection = CalendarContract.Events.DTSTART +">"+now.toMillis(false);
//		Cursor calendarCursor = context.managedQuery(uri, projection, selection, null, null);
//		String result = "";
//		calendarCursor.moveToFirst();
//		int counter = 0;
//		while (!calendarCursor.isAfterLast() && counter < 5)
//		{
//			result += calendarCursor.getString(calendarCursor.getColumnIndex(CalendarContract.Events.TITLE));
//			result += ",";
//			calendarCursor.moveToNext();
//			counter++;
//		}
		return null;
	}
}
