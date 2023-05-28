package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

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
                    {"Doctor Name : Laurel Serpico", "Hospital Address : Bawshar", "Exp : 17yrs", "Number : 95052528", "Fees : 70"},
                    {"Doctor Name : Noelle Dane", "Hospital Address : Seeb", "Exp : 7yrs", "Number : 97117584", "Fees : 40"},
                    {"Doctor Name : Nadia D'Amore", "Hospital Address : Ghubra", "Exp : 14yrs", "Number : 95830718", "Fees : 60"},
                    {"Doctor Name : Yolanda Farro", "Hospital Address : Al Bustan", "Exp : 6yrs", "Number : 98185922", "Fees : 45"},
                    {"Doctor Name : Mara Harford", "Hospital Address : Qurum", "Exp : 11yrs", "Number : 98599969", "Fees : 110"}
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Elisabeth Pastore", "Hospital Address : Ibri", "Exp : 5yrs", "Number : 91199581", "Fees : 80"},
                    {"Doctor Name : Carl Todd", "Hospital Address : Sur", "Exp : 17yrs", "Number : 99537528", "Fees : 30"},
                    {"Doctor Name : Farrah Krebs", "Hospital Address : Bawshar", "Exp : 14yrs", "Number : 94467023", "Fees : 60"},
                    {"Doctor Name : Durante Barros", "Hospital Address : Nizwa", "Exp : 6yrs", "Number : 97542958", "Fees : 75"},
                    {"Doctor Name : Rosmarie Noyer", "Hospital Address : Qurum", "Exp : 15yrs", "Number : 90965286", "Fees : 100"}
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Sabina Sniders", "Hospital Address : Salalah", "Exp : 11yrs", "Number : 92256784", "Fees : 40"},
                    {"Doctor Name : Cerdic Faolain", "Hospital Address : Seeb", "Exp : 4yrs", "Number : 91677465", "Fees : 80"},
                    {"Doctor Name : Octavia Schnell", "Hospital Address : Al Khuwayr", "Exp : 14yrs", "Number : 99525788", "Fees : 30"},
                    {"Doctor Name : Jamie Hedlund", "Hospital Address : Ghubra", "Exp : 9yrs", "Number : 91611962", "Fees : 55"},
                    {"Doctor Name : Marinko Valerio", "Hospital Address : Sur", "Exp : 13yrs", "Number : 92256938", "Fees : 90"}
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Minako Sama", "Hospital Address : Ibra", "Exp : 13yrs", "Number : 90864257", "Fees : 75"},
                    {"Doctor Name : Raul Stevens", "Hospital Address : Seeb", "Exp : 7yrs", "Number : 99258425", "Fees : 60"},
                    {"Doctor Name : Melisa Shin", "Hospital Address : Al Khuwayr", "Exp : 14yrs", "Number : 99753173", "Fees : 30"},
                    {"Doctor Name : Friderik Scully", "Hospital Address : Ibri", "Exp : 6yrs", "Number : 98642124", "Fees : 95"},
                    {"Doctor Name : Eva Christian", "Hospital Address : Qurum", "Exp : 11yrs", "Number : 95318530", "Fees : 40"}
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Nico Russo", "Hospital Address : Nizwa", "Exp : 6yrs", "Number : 90537884", "Fees : 60"},
                    {"Doctor Name : Mehdi Murgia", "Hospital Address : Seeb", "Exp : 4yrs", "Number : 95246742", "Fees : 30"},
                    {"Doctor Name : Nadia D'Amore", "Hospital Address : Sur", "Exp : 12yrs", "Number : 91620523", "Fees : 40"},
                    {"Doctor Name : Mick Kurata", "Hospital Address : Suhar", "Exp : 16yrs", "Number : 95546432", "Fees : 65"},
                    {"Doctor Name : Elena Abelli", "Hospital Address : Khasab", "Exp : 2yrs", "Number : 92568125", "Fees : 100"}
            };

    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons fees:" + doctor_details[i][4]);
            list.add( item );
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3",
                "line4", "line5"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}