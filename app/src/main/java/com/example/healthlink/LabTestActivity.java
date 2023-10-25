package com.example.healthlink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package 1 : Full Body Checkup","","","","10000"},
                    {"Package 2 : Covid-19 Test","","","","2000"},
                    {"Package 3 : Thyroid Test","","","","1500"},
                    {"Package 4 : Immunity Test ","","","","800"},
                    {"Package 5 : Blood Test","","","","500"}
            };

    private String[] package_details = {
      "Blood Glucose level\n"+
              "Complete Hemogram\n"+
              "HbA1c\n"+
              "Blood Iron/Hemoglobin level\n"+
              "Kidney Function test\n"+
              "Lipid Profile\n"+
              "Liver Function Test\n"+
              "Heart Condition",
            "Covid-19 Test- IgG",
            "Thyroid Test - ( T3,T4 & TSH Ultra-Sensitive)",
            "Complete Hemogram\n"+
                    "CRP (C reactive Protein) Quantitative,Serum\n"+
                    "Vitamin D Total-25 Hydroxy\n"+
                    "Lipid Profile\n"+
                    "Iron (Fe) Level",
            "Complete Hemogram\n"+
                    "Glucose Level\n"+
                    "Hemoglobin Level\n"+
                    "Oxygen Level"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button  btnGoToCart,btnBack;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonLDGoToCart);
        btnBack = findViewById(R.id.buttonBMDBack);
        listView = findViewById(R.id.listViewDD);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i< packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
       listView.setAdapter(sa);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
               it.putExtra("text1",packages[i][0]);
               it.putExtra("text2",package_details[i]);
               it.putExtra("text3",packages[i][4]);
               startActivity(it);
           }
       });
       btnGoToCart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
           }
       });
    }
}