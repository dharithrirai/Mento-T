package com.dharithri.mento_t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class Sem1admin extends AppCompatActivity {
    private RecyclerView recyclerView;
    sem1adapter myAdapter;
    AsyncHttpClient client;
    Workbook workbook;
    List<String> name, sub1, sub2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem1admin);
        recyclerView = (RecyclerView) findViewById(R.id.sem1lst);
        name = new ArrayList<>();
        sub1 = new ArrayList<>();
        sub2 = new ArrayList<>();
        String url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTZJWV12wz6w1uOs3SaQFWILO-qg5shohXl-qgmen1MvdFPo-P8SEauEUTadeWim4DU_HpPNsjgdr8c/pubhtml";


        client = new AsyncHttpClient();
        client.get(url, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(Sem1admin.this, "download fail", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                Toast.makeText(Sem1admin.this, "download success", Toast.LENGTH_SHORT).show();
                WorkbookSettings ws = new WorkbookSettings();
                ws.setGCDisabled(true);
                if (file != null) {
                    try {
                        workbook = workbook.getWorkbook(file);
                        System.out.println(file);
                        Sheet sheet = workbook.getSheet(0);
                        for (int i = 0; i < sheet.getRows(); i++) {
                            Cell[] row = sheet.getRow(i);
                            name.add(row[0].getContents());
                            sub1.add(row[1].getContents());
                            sub2.add(row[2].getContents());
                        }
                        showData();
                        Log.d("TAG", "onSuccess: " + name);

                    } catch (IOException | BiffException e) {
                        e.printStackTrace();
                    }


                }
            }


        });

    }


    private void showData() {
        myAdapter = new sem1adapter(this, name, sub1, sub2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
