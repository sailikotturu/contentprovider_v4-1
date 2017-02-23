package com.example.sailik.contentprovidertask_20_feb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddItem extends Activity implements View.OnClickListener {

    private TextView malbumNametv;
    private TextView mtrackNametv;
    private EditText malbumNameet;
    private EditText mtrackNameet;
    private Button mOKbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        malbumNametv = (TextView)findViewById(R.id.album_tv);
        mtrackNametv = (TextView)findViewById(R.id.track_tv);
        malbumNameet = (EditText)findViewById(R.id.albumname_editText);
        mtrackNameet = (EditText)findViewById(R.id.trackname_editText);
        mOKbutton = (Button)findViewById(R.id.ok_button);

        mOKbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ok_button:


                String albumName = malbumNameet.getText().toString();
                String trackName = mtrackNameet.getText().toString();
                if(albumName.equals("")||trackName.equals("")||(albumName.equals("")&&trackName.equals(""))){
                    Toast.makeText(this,"Invalid Input!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    DbHelper dbHelper = new DbHelper(this);
                    dbHelper.insertMusicItem(albumName, trackName);

                    Intent i = new Intent(AddItem.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }
                break;
        }
    }
    @Override
    protected void onResume(){

        super.onResume();
    }

}
