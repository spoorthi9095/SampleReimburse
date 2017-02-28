package com.bitjini.samplereimburse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    SignUpAdapter adapter;

    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();

    }

    private void initViews()
    {
        listView=(ListView) findViewById(R.id.signUp);

        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        enterDataInList();
    }

    private void enterDataInList() {
        ArrayList<String > values=new ArrayList<>();
        ArrayList<BeanSignUpField> arrayList=new ArrayList<>();
        values.add("Name");
        values.add("");
        values.add("Mobile");
        values.add("Email");
        values.add("Employee Id");
        values.add("");

        for (int i=0;i<values.size();i++)
        {
            BeanSignUpField beanSignUpField=new BeanSignUpField();
            beanSignUpField.setValue(values.get(i));
            arrayList.add(beanSignUpField);
        }
        SignUpAdapter adapter=new SignUpAdapter(SignUpActivity.this,arrayList);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.loginBtn:
                Intent intent=new Intent(SignUpActivity.this,HomePage.class);
                startActivity(intent);
                break;
        }
    }
}
