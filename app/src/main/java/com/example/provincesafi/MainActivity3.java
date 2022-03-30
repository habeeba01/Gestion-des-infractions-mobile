package com.example.provincesafi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    //declaration
    //EditText cin,name,type,date,adresse,pv,commune;
    ListView listView ;
    Button btnView,add,list,logout,delete;
    SearchView search ;
    EditText cin,name,type,address,pv;
    /*private final List<InfracteurModel>  everyInf= new ArrayList<InfracteurModel>();
    private final List<InfractionModel>  everyInfraction= new ArrayList<InfractionModel>();*/

   // private ArrayAdapter<InfracteurModel> infracteurModelArrayAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //find boutton
        btnView=findViewById(R.id.btnView);
        add=findViewById(R.id.add);
        list=findViewById(R.id.list);
        logout=findViewById(R.id.logout);
        /*cin=findViewById(R.id.cin);
        name=findViewById(R.id.name);
        type=findViewById(R.id.tp);
        date=findViewById(R.id.dt);
        adresse=findViewById(R.id.adr);
        pv=findViewById(R.id.pv);*/
        listView=findViewById(R.id.listView);
        //final Button delete=findViewById(R.id.delete);
        //commune=findViewById(R.id.com);
        search=findViewById(R.id.search);

        //boutton Listener
        btnView.setOnClickListener(v -> {

                Database database = new Database(MainActivity3.this);

                //
               // List<InfracteurModel> everyInfracteur = database.getEveryInfracteur();
                List<InfractionModel> everyInfraction = database.getEveryInfraction();
                //this.everyInf.add(everyInfracteur);
                //Toast.makeText(MainActivity3.this,everyInfracteur.toString(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity3.this,everyInfraction.toString(),Toast.LENGTH_SHORT).show();

                //infraction
                ArrayAdapter infractionArrayAdapter;
                infractionArrayAdapter = new ArrayAdapter<InfractionModel>(MainActivity3.this, android.R.layout.simple_list_item_1, android.R.id.text1, everyInfraction);
                listView.setAdapter(infractionArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        InfractionModel infractionModel=new InfractionModel() ;

                        //Toast.makeText(MainActivity3.this,"you clicked" + parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                        Database database = new Database(MainActivity3.this);
                        boolean success = database.deleteinfraction(infractionModel);
                        Toast.makeText(MainActivity3.this,"success" + success ,Toast.LENGTH_SHORT).show();
                    }
                });


        });
        //search
      /*search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
              MainActivity3.this.
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
              return false;
          }
      });*/
        //add
        add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            startActivity(intent);
        });
        //list
        list.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
            startActivity(intent);

        });
        //logout
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity3.this,"u've been logged out",Toast.LENGTH_SHORT).show();

        });

    }

   /* private class MyList extends ArrayAdapter<String>{
        //attribut
        private int layout ;
        //constructor
        private MyList(Context context,int resource,List<String> objects){
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
                        Toast.makeText(getContext(),"deleted" + position ,Toast.LENGTH_SHORT).show();;
                    }
                });
                convertView.setTag(viewHolder);
            }else{
                mainViewHolder=(ViewHolder)convertView.getTag();
                mainViewHolder.listView.setText(getItem(position));
            }
            return convertView ;
        }

}
public class ViewHolder{
         ListView listView ;
         Button delete ;
}*/
    //@Override
    // public boolean onCreateOptionsMenu(Menu menu) {
    //     getMenuInflater().inflate(R.menu.menu1,menu);
    //     return true;
    // }
}
