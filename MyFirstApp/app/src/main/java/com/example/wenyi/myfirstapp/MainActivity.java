package com.example.wenyi.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] func={"計算BMI","離開"};
    int[] icons ={R.drawable.pic_bmi,R.drawable.pic_exit};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView) findViewById(R.id.grid);
        IconAdapter gAdapter =new IconAdapter();
        grid.setAdapter(gAdapter);
        grid.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id ){


        switch(position){
            case 0:
                startActivity(
                        new Intent(this,bmi.class)
                );
                break;
            case 1:
                finish();
                break;
        }
    }



    class IconAdapter extends BaseAdapter {

        public int getCount() {
            return func.length;
        }

        public Object getItem(int position) {
            return func[position];
        }

        public long getItemId(int position) {
            return icons[position];
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row =convertView;
            if(row ==null){
                row =getLayoutInflater().inflate(R.layout.item_row,null);
                ImageView image =(ImageView) row.findViewById(R.id.item_image);
                TextView text =(TextView) row.findViewById(R.id.item_text);

                image.setImageResource(icons[position]);
                text.setText(func[position]);
            }
            return row;
        }




    }





}
