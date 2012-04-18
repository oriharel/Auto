package com.niyo.auto;

import java.util.Calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
//import android.provider.CalendarContract;
import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;

public class NextEventsActivity extends Activity 
{
	private static final String LOG_TAG = NextEventsActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next_events_layout);

		ContentResolver resolver = getContentResolver();

//		Uri uri = CalendarContract.Events.CONTENT_URI;
//		String[] projection = new String[] {
//				CalendarContract.Events.TITLE,
//				CalendarContract.Events.DTSTART
//		};
		
		Time now = new Time();
		now.setToNow();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		
		Log.d(LOG_TAG, "end time is "+cal.get(Calendar.DAY_OF_WEEK));
//		String selection = CalendarContract.Events.DTSTART +">"+now.toMillis(false)+ " AND "+CalendarContract.Events.DTSTART+"<"+cal.getTimeInMillis();
//		Log.d(LOG_TAG, "selection is "+selection);
//		Cursor calendarCursor = managedQuery(uri, projection, selection, null, null);
		String result = "";
//		Log.d(LOG_TAG, "cursor get count is "+calendarCursor.getCount());
//		calendarCursor.moveToFirst();
		int counter = 0;
//		while (!calendarCursor.isAfterLast())
//		{
//			String title = calendarCursor.getString(calendarCursor.getColumnIndex(CalendarContract.Events.TITLE));
//			String dtStart = calendarCursor.getString(calendarCursor.getColumnIndex(CalendarContract.Events.DTSTART));
//			result += title+"_"+dtStart;
//			result += ",";
//			calendarCursor.moveToNext();
//		}
		
		TextView resultView = (TextView)findViewById(R.id.resultText);
		
		resultView.setText(result);
	}

}
