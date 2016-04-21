package com.example.wubingzhang.week9.alarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.wubingzhang.week9.R;

import java.util.Calendar;

public class chooseTime extends AppCompatActivity {
    private int year; // 年
    private int month;
    private int day;
    private int hour;
    private int minute;

    private EditText editText;
    Button saveAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);

        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR_OF_DAY);
        minute=calendar.get(Calendar.MINUTE);

        editText = (EditText)findViewById(R.id.alarmlable);

        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                chooseTime.this.hour = hourOfDay;
                chooseTime.this.minute = minute;
                show(year, month, day, hourOfDay, minute);
            }
        });

        final alarmClass alarm = new alarmClass(true,"dd",chooseTime.this.hour,chooseTime.this.minute);

        editText = (EditText)findViewById(R.id.alarmlable);
        String label = editText.getText().toString();

        saveAlarm = (Button)findViewById(R.id.saveAlarm);
        saveAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String l = editText.getText().toString();
                //Log.i("xxxx", String.valueOf(alarm.getMinute()));
                Intent intent = new Intent(chooseTime.this,alarm.class);
                alarm.setLable(l);
                //Bundle bundle = new Bundle();
                intent.putExtra("alarm", alarm);
                //intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                //startActivity(intent);
                finish();
            }
        });

    }

    private void show(int year, int month, int day, int hour, int minute){
        String str=hour+":"+minute;
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        //year+"年"+(month+1)+"月"+day+"日"+
    }
}
