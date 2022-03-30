package com.example.provincesafi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<String>();
    TextView cin,name,type,adr,pv;
    Button delete,modify,btnView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnView=findViewById(R.id.btnView);
        ListView listView=(ListView) findViewById(R.id.listView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database database = new Database(MainActivity5.this);
                List<InfractionModel> everyInfraction = database.getEveryInfraction();

               // listView.setAdapter(new MyList(MainActivity5.this, android.R.layout.simple_list_item_1, android.R.id.text1, everyInfraction));


            }
        });
    }
     private class MyList extends ArrayAdapter<String> {
        //attribut
        private int layout ;
        //constructor
        private MyList(Context context, int resource, List<String> objects){
            super(context, resource, objects);
            layout=resource;
        }
        //méthode
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder mainViewHolder=null ;
            if(convertView==null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView=inflater.inflate(layout,parent,false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.listView=(ListView) convertView.findViewById(R.id.listView);
                viewHolder.delete=(Button) convertView.findViewById(R.id.delete);
                viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"deleted" + position , Toast.LENGTH_SHORT).show();;
                    }
                });
                convertView.setTag(viewHolder);
            }else{
                mainViewHolder=(ViewHolder)convertView.getTag();
               // mainViewHolder.listView.setText(getItem(position));
            }
            return convertView ;
        }

}
public class ViewHolder{
         ListView listView ;
         Button delete ;
}
}