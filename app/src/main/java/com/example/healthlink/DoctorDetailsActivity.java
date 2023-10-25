package com.example.healthlink;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit V.Saste","Clinic Address : Naupada Thane","Exp:5yrs","Phone num: 5469783551 ","600"},
                    {"Doctor Name : Prasad D.Pawar","Clinic Address : Kasarwadavli Thane","Exp:6yrs","Phone num: 9469783556","400"},
                    {"Doctor Name : Aparna P.Marathe","Clinic Address : Manisha Nagar Kalwa","Exp:5yrs","Phone num: 3569783551","800"},
                    {"Doctor Name : Atharv V.Agharkar","Clinic Address : Shimpoli Borivali","Exp:9yrs","Phone num: 8779040295","900"},
                    {"Doctor Name : Eve P.Mathew","Clinic Address : Charai Thane","Exp:4yrs","Phone num: 6969784869","700"},
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam P.Patil","Clinic Address : Naupada Thane","Exp:5yrs","Phone num: 5469783551","600"},
                    {"Doctor Name : Pramod D.Pawar","Clinic Address : Kasarwadavli Thane","Exp:6yrs","Phone num: 9469783556","400"},
                    {"Doctor Name : Archana P.sathe","Clinic Address : Manisha Nagar Kalwa","Exp:5yrs","Phone num: 3569783551","800"},
                    {"Doctor Name : Niraj A.Bade","Clinic Address : Shimpoli Borivali","Exp:9yrs","Phone num: 8779040295","900"},
                    {"Doctor Name : Mayuri A.Deshmukh","Clinic Address : Charai Thane","Exp:4yrs","Phone num: 6969784869","700"},
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Amol V.Bait","Clinic Address : Naupada Thane","Exp:5yrs","Phone num: 5469783551","600"},
                    {"Doctor Name : Yash D.Pawar","Clinic Address : Kasarwadavli Thane","Exp:6yrs","Phone num: 9469783556","400"},
                    {"Doctor Name : Ruturaj P.Barwe ","Clinic Address : Manisha Nagar Kalwa","Exp:15yrs","Phone num: 3569783551","800"},
                    {"Doctor Name : Bhargavi V.Agharkar","Clinic Address : Shimpoli Borivali","Exp:19yrs","Phone num: 8779040295","900"},
                    {"Doctor Name : Omkar V.Yadav","Clinic Address : Charai Thane","Exp:19yrs","Phone num: 6969784869","700"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Hema S.Chirputkar","Clinic Address : Naupada Thane","Exp:5yrs","Phone num: 5469783551","600"},
                    {"Doctor Name : Tanmay G.Gadre","Clinic Address : Kasarwadavli Thane","Exp:6yrs","Phone num: 9469783556","400"},
                    {"Doctor Name : Harsh P.Marathe","Clinic Address : Manisha Nagar Kalwa","Exp:15yrs","Phone num: 3569783551","800"},
                    {"Doctor Name : Pratiksha H.Dhepe ","Clinic Address : Shimpoli Borivali","Exp:19yrs","Phone num: 8779040295","900"},
                    {"Doctor Name : Gojou W.Satoru","Clinic Address : Charai Thane","Exp:14yrs","Phone num: 6969784869","700"},
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Pradnya k. More","Clinic Address : Naupada Thane","Exp:5yrs","Phone num: 5469783551","600"},
                    {"Doctor Name : Durgesh G. Palekar","Clinic Address : Kasarwadavli Thane","Exp:6yrs","Phone num: 9469783556","400"},
                    {"Doctor Name : Mohit N. Angre","Clinic Address : Manisha Nagar Kalwa","Exp:15yrs","Phone num: 3569783551","800"},
                    {"Doctor Name : Manisha J. Joshi","Clinic Address : Shimpoli Borivali","Exp:19yrs","Phone num: 8779040295","900"},
                    {"Doctor Name : Shreeya P. Angre","Clinic Address : Charai Thane","Exp:18yrs","Phone num: 6969784869","700"},
            };


    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @SuppressLint({"MissingInflatedId", "SuspiciousIndentation"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewBMDPackageName);
        btn = findViewById(R.id.buttonBMDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;


            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

            list = new ArrayList();
            for(int i=0;i<doctor_details.length;i++) {
                item = new HashMap<String, String>();
                item.put("line1", doctor_details[i][0]);
                item.put("line2", doctor_details[i][1]);
                item.put("line3", doctor_details[i][2]);
                item.put("line4", doctor_details[i][3]);
                item.put("line5","Fee : "+doctor_details[i][4] + "/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}