package com.mobilerepair.app.listview41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mAscButton;
    private Button mDescButton;
    private ListView mNameListView;

    private List<String> stringList;
    private StringAdapter stringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAscButton = (Button) findViewById(R.id.asc_button);
        mDescButton = (Button) findViewById(R.id.desc_button);
        mNameListView = (ListView) findViewById(R.id.name_list);

        stringList = new ArrayList<String>();
        stringList.add("Rajesh");
        stringList.add("Arjun");
        stringList.add("Santosh");
        stringList.add("Sanvi");
        stringList.add("Megha");
        stringList.add("Prajwal");

        stringAdapter = new StringAdapter(MainActivity.this, R.layout.sort_list_item, stringList);
        mNameListView.setAdapter(stringAdapter);

        mAscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(stringList, StringAscComparator);
                Toast.makeText(MainActivity.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();
                stringAdapter.notifyDataSetChanged();
            }
        });

        mDescButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(stringList, StringDescComparator);
                Toast.makeText(MainActivity.this, "Sorting in Descending Order", Toast.LENGTH_LONG).show();
                stringAdapter.notifyDataSetChanged();
            }
        });

    }

    public static Comparator<String> StringAscComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName1.compareToIgnoreCase(stringName2);
        }
    };

    //Comparator for Descending Order
    public static Comparator<String> StringDescComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName2.compareToIgnoreCase(stringName1);
        }
    };
}
