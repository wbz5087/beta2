package com.example.wubingzhang.week9.note;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wubingzhang.week9.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class notes extends AppCompatActivity {
    private ListView notesList;
    ArrayList<noteClass> list = new ArrayList<noteClass>();
    Button addNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        addNotes = (Button)findViewById(R.id.addNotes);
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notes.this, com.example.wubingzhang.week9.note.addNotes.class);
                startActivityForResult(intent, 1);
                // finish();
            }
        });


        noteClass note1 = new noteClass("1","2");
        list.add(note1);
        //getData();
        populateList();
    }

    private void populateList(){
        notesList = (ListView)findViewById(R.id.notesList);

        notesAdapter adapter = new notesAdapter(this,R.layout.notes_cell,list);

        //ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        /*for(int i=0;i<list.size();i++)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", list.get(i).getTitle());
            map.put("ItemText", list.get(i).getContent());
            mylist.add(map);
        }
*/
        /*SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                mylist,//数据来源
                R.layout.notes_cell,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[] {"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.noteLabel,R.id.noteContent});*/
        //添加并且显示
        notesList.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent){
        //super.onActivityResult(requestCode,resultCode,data);
        //noteClass note2 = new noteClass("sae","asd");
        /*if(resultCode == RESULT_OK){

        }*/
        Serializable extra = intent.getSerializableExtra("note");
        if(extra!=null){
            noteClass note = (noteClass)extra;
            //note2.setTitle(note.getTitle());
            list.add(note);
        }

        populateList();
    }

/*    static class ViewHolder{
        public TextView title;
        public TextView content;
    }

    public void getData(){
        Serializable extra = getIntent().getSerializableExtra("note");
        if(extra!=null){
            noteClass note = (noteClass)extra;
            list.add(note);
        }
    }*/

    public class notesAdapter extends ArrayAdapter<noteClass> {

        private int layoutResource;

        public notesAdapter(Context context, int layoutResource, List<noteClass> noteList) {
            super(context, layoutResource, noteList);
            this.layoutResource = layoutResource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                view = layoutInflater.inflate(layoutResource, null);
            }

            noteClass note = getItem(position);

            if (note != null) {
                TextView label = (TextView) view.findViewById(R.id.noteLabel);
                TextView content = (TextView) view.findViewById(R.id.noteContent);

                if (label != null) {
                    label.setText(note.getTitle());
                }

                if (content != null) {
                    content.setText(note.getContent());
                }

            }

            return view;
        }

    /*public class notesAdapter extends BaseAdapter{
        private LayoutInflater mInflator;
        private int resource;   //item的布局
        private ArrayList<noteClass> notes = new ArrayList<noteClass>();
        private Context context;
        TextView label,content;

        public notesAdapter(Context context, ArrayList<noteClass> note,int recource) {
            this.context = context;
            this.resource = resource;
            this.notes = note;
        }
        @Override
        public int getCount() {
            return notes.size();
        }

        @Override
        public Object getItem(int position) {
            return notes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                mInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflator.inflate(R.layout.notes_cell, null);
                label = (TextView) findViewById(R.id.noteLabel);
                content = (TextView) findViewById(R.id.noteContent);
            }
            noteClass note = notes.get(position);
            label.setText(note.getTitle());
            content.setText(note.getContent());
            return convertView;
        }
    }*/
    }
}

