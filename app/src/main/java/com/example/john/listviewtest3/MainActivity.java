package com.example.john.listviewtest3;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static ListView lv;
    Context context;
    static EditText enterIPCsEditText;
    static public int costOfUnits = 0;
    static TextView changeTextView;
    TextView unitQuantityTextView;
    Button summaryButton;

    public static int [] AnAImages = {R.drawable.infantry, R.drawable.artillery, R.drawable.tank, R.drawable.aaa,
                                        R.drawable.fighter,R.drawable.bomber, R.drawable.submarine, R.drawable.transport,
                                        R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                                        R.drawable.aircraftcarrier, R.drawable.industrialcomplex, R.drawable.repairindustrialcomplex};

    public int unitQuantityArray[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int unitPriceArray[] = {3,4,6,5,10,12,6,7,8,12,20,14,15,1};

    public String[] unitNamesStringArray = {"Infantry", "Artillery", "Tank", "AAA", "Fighter", "Bomber", "Submarine", "Transport",
                                            "Destroyer", "Cruiser", "Battleship", "Aircraft Carrier", "Industrial Complex",
                                            "Repair Industrial Complex"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("A&A UnitCalc"); //this displays white text color. create a style to change this
        setContentView(R.layout.activity_main);

        context=this;

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, AnAImages, unitQuantityArray,unitPriceArray ));

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View v, int pos, long id) {
                //set up dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.summary_dialog_layout);
                dialog.setCancelable(true);

                DialogBoxUnitInfo dialogBoxUnitInfo = new DialogBoxUnitInfo();

                TextView summaryTextView = (TextView) dialog.findViewById(R.id.summaryTextView);
                summaryTextView.setText(dialogBoxUnitInfo.makeUnitInfoString(pos));

                //This is setting up the button in the alert dialog box to close when pressed
                Button button = (Button) dialog.findViewById(R.id.cancelSummaryButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

                return true;
            }
        });

        enterIPCsEditText = (EditText) findViewById(R.id.enterIPCsEditText);
        changeTextView = (TextView) findViewById(R.id.changeTextView);
        unitQuantityTextView = (TextView) findViewById(R.id.unitQuantityTextView);
        summaryButton = (Button) findViewById(R.id.summaryButton);

        enterIPCsEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    ResetUnits();
                }
                return false;
            }
        });

        summaryButton.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
                //set up dialog
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.summary_dialog_layout);
                    dialog.setCancelable(true);

                    TextView summaryTextView = (TextView) dialog.findViewById(R.id.summaryTextView);
                    summaryTextView.setText(makeSummaryString());

                //set up button
                Button button = (Button) dialog.findViewById(R.id.cancelSummaryButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                    dialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.version) {
            Toast.makeText(context, "selection is working", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void minusUnitCostFromIPCs(int position){
        int IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
        costOfUnits +=  unitPriceArray[position];
        changeTextView.setText("Change: " + Integer.toString(IPCs - costOfUnits));
    }

    public static void addUnitCostToIPCs(int position){
        int IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
        costOfUnits -=  unitPriceArray[position];
        changeTextView.setText("Change: " + Integer.toString(IPCs - costOfUnits));
    }

    // This method is called by CustomAdapter to check if the user has entered an ipc amount
    public static boolean IPCsEmpty(){

        String enterIPCsString = enterIPCsEditText.getText().toString();

        if(enterIPCsString.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean notEnoughChange(int position){
        int IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
        int change = IPCs - costOfUnits;

        if(unitPriceArray[position] > change)
            return true;
        else
            return false;
    }

    public void Reset(View view){
        enterIPCsEditText.setText("");
        changeTextView.setText("Change: 0");
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, AnAImages, unitQuantityArray,unitPriceArray ));
    }

    //check to see if any code is really using this function, if not delete. Because is basically the same as ResetUnits
    public void ResetUnitsViewButton(View view){
        if(!IPCsEmpty()) {
            changeTextView.setText("Change: " + Integer.parseInt(enterIPCsEditText.getText().toString()));
        }
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, AnAImages, unitQuantityArray,unitPriceArray ));
    }

    public void ResetUnits(){
        if(!IPCsEmpty()) {
            changeTextView.setText("Change: " + Integer.parseInt(enterIPCsEditText.getText().toString()));
        }
        else{
            changeTextView.setText("Change: 0");
        }
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, AnAImages, unitQuantityArray,unitPriceArray ));
    }

    public String makeSummaryString(){

        int[] unitQuantityArray = CustomAdapter.getUnitQuantityArray();
        String summaryString = "";
        int IPCs = 0;
        int change = 0;

        if(!IPCsEmpty()) {
            IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
            change = IPCs - costOfUnits;
        }

        for(int i = 0; i < unitQuantityArray.length; i++){
            if(unitQuantityArray[i] > 0){
                summaryString += unitNamesStringArray[i] + ": " + unitQuantityArray[i] + "\n";
            }
        }

        summaryString += "Change: " + change;

        return summaryString;
    }

}
