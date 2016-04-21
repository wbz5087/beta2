package com.example.wubingzhang.week9.alarm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wubingzhang.week9.R;
import com.example.wubingzhang.week9.note.noteClass;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class alarm extends AppCompatActivity {
    Button addAlarm;
    private ListView alarmLsit;
    ArrayList<alarmClass> list = new ArrayList<alarmClass>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        addAlarm = (Button)findViewById(R.id.addAlarm);
        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(alarm.this, chooseTime.class);
                startActivityForResult(intent, 2);
            }
        });

        alarmClass ala=new alarmClass(true,"cse208",9,00);
        list.add(ala);
        populateList();
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent){
        //super.onActivityResult(requestCode,resultCode,data);
        //noteClass note2 = new noteClass("sae","asd");
        /*if(resultCode == RESULT_OK){

        }*/
        Serializable extra = intent.getSerializableExtra("alarm");
        if(extra!=null){
            alarmClass alarm = (alarmClass)extra;
            //note2.setTitle(note.getTitle());
            list.add(alarm);
            //Log.i("xxxx", String.valueOf(alarm.getHour()));
        }

        populateList();
    }

    private void populateList(){
        alarmLsit = (ListView)findViewById(R.id.alarmList);

        alarmAdapter adapter = new alarmAdapter(this,R.layout.alarm_cell,list);

        alarmLsit.setAdapter(adapter);

    }

    public class alarmAdapter extends ArrayAdapter<alarmClass> {
        private int layoutResource;

        public alarmAdapter(Context context, int layoutResource, List<alarmClass> alarmClassList) {
            super(context, layoutResource, alarmClassList);
            this.layoutResource = layoutResource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                view = layoutInflater.inflate(layoutResource, null);
            }

            alarmClass alarm = getItem(position);
            if (alarm != null) {
                TextView time = (TextView) view.findViewById(R.id.alarmTime);
                TextView label = (TextView) view.findViewById(R.id.alarmLabel);

                if (time != null) {

                    String display = String.valueOf(alarm.getHour())+":"+String.valueOf(alarm.getMinute());
                    Log.i("dddd", display);
                    time.setText(display);
                }

                if (label != null) {
                    label.setText(alarm.getLable());
                }

            }

            return view;
        }
    }
}
