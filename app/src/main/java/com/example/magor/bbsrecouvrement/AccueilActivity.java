package com.example.magor.bbsrecouvrement;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_LONG;
//
// import android.RequestQueue;

public class AccueilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public JSONArray reArray=new JSONArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //JSONArray reArray=new JSONArray();
        setContentView(R.layout.activity_accueil);
        //String link="http://51.254.200.129/recouvrement/recouvrement.php";
        String link="http://192.168.1.205/recouvrement/recouvrement.php";
        String url="";
        RequestQueue requete=Volley.newRequestQueue(this);
        /*StringRequest stringRequest=new StringRequest(Request.Method.POST, link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView samatext=(TextView)findViewById(R.id.samatext);
                        samatext.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextView samatext=(TextView)findViewById(R.id.samatext);
                samatext.setText("erreur de connection");
            }
        }
        );
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.POST, link, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                TextView samatext=(TextView)findViewById(R.id.samatext);
                String prenom="prenom";

                try {
                    samatext.setText("the response is =" + response.getString(prenom));
                }catch (Exception e){

                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                //
                TextView samatext=(TextView)findViewById(R.id.samatext);
                samatext.setText("the response is ="+error);
            }
        }
        );*/
        JsonArrayRequest requetbbs=new JsonArrayRequest(link,
                new Response.Listener<JSONArray>(){
                   @Override
                    public void onResponse(JSONArray jsonarray){
                       TextView samatext=(TextView)findViewById(R.id.samatext);
                       try {
                          // reArray=jsonarray;
                           int i=0;
                           TableLayout table=(TableLayout)findViewById(R.id.table);
                           for(i=0;i<jsonarray.length();i++){

                               TableRow ligne2=new TableRow(getApplicationContext());
                               ligne2.setBackgroundColor(Color.YELLOW);
                               TextView item6=new TextView(getApplicationContext());
                               TextView item7=new TextView(getApplicationContext());
                               TextView item8=new TextView(getApplicationContext());
                               TextView item9=new TextView(getApplicationContext());
                               Button item10=new Button(getApplicationContext());

                               try {
                                   JSONObject tuple=(JSONObject)jsonarray.get(i);
                                   item6.setText(tuple.getString("point"));
                                   item7.setText(tuple.getString("adresse"));
                                   item8.setText(tuple.getString("tel"));
                                   item9.setText(tuple.getString("montant"));
                               }catch (Exception e){

                               }
                               item10.setText("valider");

                               item6.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                               item7.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                               item8.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                               item8.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                               item9.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));

                               ligne2.addView(item6);
                               ligne2.addView(item7);
                               ligne2.addView(item8);
                               ligne2.addView(item9);
                               ligne2.addView(item10);

                               table.addView(ligne2);
                           }
                       }catch (Exception e){

                       }
                   }
                },new Response.ErrorListener(){
                  @Override
                    public void onErrorResponse(VolleyError v){

                    }

                   }
                );
        requete.add(requetbbs);
        Intent intent=getIntent();
        String id="";
        String pass="";

       if(intent!=null){
           //TableLayout table=(TableLayout)findViewById(R.id.table);
           // TextView samatext=(TextView)findViewById(R.id.samatext);
          /* // samatext.setText("connection reussi");
            TableLayout table=(TableLayout)findViewById(R.id.table);
            TableRow ligne=new TableRow(this);
            ligne.setBackgroundColor(Color.RED);
            TextView item1=new TextView(this);
            TextView item2=new TextView(this);
            TextView item3=new TextView(this);
            TextView item4=new TextView(this);
            Button item5=new Button(this);
            item1.setText("10-5-2018");
            item2.setText("modou");
            item3.setText("mbour");
            item4.setText("50000");
            item5.setText("valider");



            item1.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );
            item2.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );
            item3.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
            item4.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
            item5.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
            ligne.addView(item1);
            ligne.addView(item2);
            ligne.addView(item3);
            ligne.addView(item4);
            ligne.addView(item5);
            table.addView(ligne);*/
            /*int i=0;


            for(i=0;i<reArray.length();i++){

                TableRow ligne2=new TableRow(this);
                ligne2.setBackgroundColor(Color.YELLOW);
                TextView item6=new TextView(this);
                TextView item7=new TextView(this);
                TextView item8=new TextView(this);
                TextView item9=new TextView(this);
                Button item10=new Button(this);

                try {
                    JSONObject tuple=(JSONObject)reArray.get(0);
                    item6.setText(tuple.getString("point"));
                    item7.setText(tuple.getString("adresse"));
                    item8.setText(tuple.getString("tel"));
                    item9.setText(tuple.getString("montant"));
                }catch (Exception e){

                }
                item10.setText("valider");

                item6.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                item7.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                item8.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                item8.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));
                item9.setLayoutParams(new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ));

                ligne2.addView(item6);
                ligne2.addView(item7);
                ligne2.addView(item8);
                ligne2.addView(item9);
                ligne2.addView(item10);

                table.addView(ligne2);
            }*/

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
