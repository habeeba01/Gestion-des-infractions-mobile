package com.example.provincesafi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    //declaration
    EditText cin,name,type,address,pv;
    //Spinner arr,conduite,commune ;
    Button btnInsert,add,list,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       //find button
        add=findViewById(R.id.add);
        list=findViewById(R.id.list);
        logout=findViewById(R.id.logout);
        btnInsert=findViewById(R.id.btnInsert);
        cin=findViewById(R.id.cin);
        name=findViewById(R.id.name);
        type=findViewById(R.id.tp);
        address =findViewById(R.id.adr);
        pv=findViewById(R.id.pv);
        /*arr=findViewById(R.id.sp1);
        conduite=findViewById(R.id.sp2);
        commune=findViewById(R.id.sp3);*/
        //button Listeners
        //insert
            btnInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InfractionModel infractionModel ;
                    //InfracteurModel infracteurModel ;
                    try {
                        infractionModel=new InfractionModel(1,name.getText().toString(),cin.getText().toString(),type.getText().toString(), address.getText().toString(),pv.getText().toString());
                        Toast.makeText(MainActivity2.this,infractionModel.toString(),Toast.LENGTH_SHORT).show();
                        //infracteurModel=new InfracteurModel(1,name.getText().toString(),cin.getText().toString());
                        //Toast.makeText(MainActivity2.this,infracteurModel.toString(),Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        Toast.makeText(MainActivity2.this,"erreur",Toast.LENGTH_SHORT).show();
                        infractionModel=new InfractionModel(-1,"error","error","error","error","error");
                        //infracteurModel=new InfracteurModel(-1,"error","error");

                    }
                    Database database = new Database(MainActivity2.this);
                    boolean success = database.addOne(infractionModel);
                    Toast.makeText(MainActivity2.this,"success" + success ,Toast.LENGTH_SHORT).show();
                }
            });
            //add
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                    startActivity(intent);
                }
            });
            //list
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);

            }
        });
           //logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this,"u've been logged out",Toast.LENGTH_SHORT).show();

            }
        });
    }

      /*  @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu1,menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item){
            switch(item.getItemId()){
                case R.id.de:
                    Intent intent=new Intent(menu.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.li:
                    Intent intent1=new Intent(menu.this,lister.class);
                    startActivity(intent1);
                    return true;
            }
        }*/
}
