package com.example.magor.bbsrecouvrement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_connection=findViewById(R.id.connection);
        button_connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView identifiant=(TextView)findViewById(R.id.identifiant);
                String id=identifiant.getText().toString();
                TextView password=(TextView) findViewById(R.id.password);
                String pass=password.getText().toString();
                if(id.compareTo("bbs")==0 && pass.compareTo("bbs")==0){
                    Intent accueilActivity=new Intent(MainActivity.this,AccueilActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("id",id);
                    bundle.putString("pass",pass);
                    accueilActivity.putExtras(bundle);
                    startActivity(accueilActivity);
                }else{
                    TextView text=findViewById(R.id.click);
                    text.setText("echec de l'hautentification");
                }

            }
        });
    }
}
