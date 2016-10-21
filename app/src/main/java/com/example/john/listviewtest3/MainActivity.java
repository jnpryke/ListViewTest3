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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class MainActivity extends AppCompatActivity {

    static ListView lv;
    Context context;
    static EditText enterIPCsEditText;
    static public int costOfUnits = 0;
    static TextView changeTextView;
    TextView unitQuantityTextView;
    Button summaryButton;
    static UnitInfo unitInfo;
    static final String FILENAME = "AnA_version.txt";
    public File filePath;
    String path;


    FileOutputStream streamOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("A&A UnitCalc"); //this displays white text color. create a style to change this
        setContentView(R.layout.activity_main);

        context = this;

        filePath = this.getFilesDir();
        path = filePath.toString();

        File checkFile = new File(path, FILENAME);

        if (!checkFile.exists()) {
            File file = new File(path, FILENAME);

            try {
                streamOut = new FileOutputStream(file, false);
                streamOut.write("0".getBytes());
                streamOut.close();
                unitInfo = new UnitInfo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            File file = new File(path, FILENAME);
            int length = (int) file.length();
            byte[] bytes = new byte[length];

            try {
                FileInputStream streamIn = new FileInputStream(file);
                streamIn.read(bytes);
                streamIn.close();

                String contents = new String(bytes);
                unitInfo = new UnitInfo(Integer.parseInt(contents.trim()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

       // unitInfo.setVersion(1);

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, unitInfo.getAnAImages(), unitInfo.getUnitQuantityArray(),
                unitInfo.getUnitPriceArray()));

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View v, int pos, long id) {
                //set up dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.summary_dialog_layout);
                dialog.setCancelable(true);

                TextView summaryTextView = (TextView) dialog.findViewById(R.id.summaryTextView);
                summaryTextView.setText(makeUnitInfoString(pos));

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

        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            makeDialogBox();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void minusUnitCostFromIPCs(int position) {
        int[] unitPriceArray = unitInfo.getUnitPriceArray();
        int IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
        costOfUnits += unitPriceArray[position];
        changeTextView.setText("Change: " + Integer.toString(IPCs - costOfUnits));
    }

    public static void addUnitCostToIPCs(int position) {
        int[] unitPriceArray = unitInfo.getUnitPriceArray();
        int IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
        costOfUnits -= unitPriceArray[position];
        changeTextView.setText("Change: " + Integer.toString(IPCs - costOfUnits));
    }

    // This method is called by CustomAdapter to check if the user has entered an ipc amount
    public static boolean IPCsEmpty() {

        String enterIPCsString = enterIPCsEditText.getText().toString();

        if (enterIPCsString.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean notEnoughChange(int position) {
        int IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
        int change = IPCs - costOfUnits;
        int[] unitPriceArray = unitInfo.getUnitPriceArray();

        if (unitPriceArray[position] > change)
            return true;
        else
            return false;
    }

    public void Reset(View view) {
        enterIPCsEditText.setText("");
        changeTextView.setText("Change: 0");
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, unitInfo.getAnAImages(), unitInfo.getUnitQuantityArray(),
                unitInfo.getUnitPriceArray()));
    }

    public void ResetAll() {
        enterIPCsEditText.setText("");
        changeTextView.setText("Change: 0");
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, unitInfo.getAnAImages(), unitInfo.getUnitQuantityArray(),
                unitInfo.getUnitPriceArray()));
    }

    //check to see if any code is really using this function, if not delete. Because is basically the same as ResetUnits
    public void ResetUnitsViewButton(View view) {
        if (!IPCsEmpty()) {
            changeTextView.setText("Change: " + Integer.parseInt(enterIPCsEditText.getText().toString()));
        }
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, unitInfo.getAnAImages(), unitInfo.getUnitQuantityArray(),
                unitInfo.getUnitPriceArray()));
    }

    public void ResetUnits() {
        if (!IPCsEmpty()) {
            changeTextView.setText("Change: " + Integer.parseInt(enterIPCsEditText.getText().toString()));
        } else {
            changeTextView.setText("Change: 0");
        }
        costOfUnits = 0;
        CustomAdapter.reset();
        lv.setAdapter(new CustomAdapter(this, unitInfo.getAnAImages(), unitInfo.getUnitQuantityArray(),
                unitInfo.getUnitPriceArray()));
    }

    public String makeSummaryString() {
        String[] unitNamesStringArray = unitInfo.getUnitNamesStringArray();
        int[] unitQuantityArray = CustomAdapter.getUnitQuantityArray();
        String summaryString = "";
        int IPCs = 0;
        int change = 0;

        if (!IPCsEmpty()) {
            IPCs = Integer.parseInt(enterIPCsEditText.getText().toString());
            change = IPCs - costOfUnits;
        }

        for (int i = 0; i < unitQuantityArray.length; i++) {
            if (unitQuantityArray[i] > 0) {
                summaryString += unitNamesStringArray[i] + ": " + unitQuantityArray[i] + "\n";
            }
        }

        summaryString += "Change: " + change;

        return summaryString;
    }

    public String makeUnitInfoString(int position) {
        String unitInfoString = "";
        String[] unitNamesStringArray = unitInfo.getUnitNamesStringArray();
        int[][] unitStatsInfo = unitInfo.getUnitStatsInfoArray();

        unitInfoString += unitNamesStringArray[position] + "\n";
        unitInfoString += "Cost: " + unitStatsInfo[position][0] + "\n";
        if (unitStatsInfo[position][1] != 0) {
            unitInfoString += "Attack: " + unitStatsInfo[position][1] + "\n";
        }
        if (unitStatsInfo[position][2] != 0) {
            unitInfoString += "Defense: " + unitStatsInfo[position][2] + "\n";
        }
        if (unitStatsInfo[position][3] != 0) {
            unitInfoString += "Movement: " + unitStatsInfo[position][3];
        }

        return unitInfoString;
    }


    public void setAnAVersion() {
        File file = new File(path, FILENAME);
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        int version = 0;

        try {
            FileInputStream streamIn = new FileInputStream(file);
            streamIn.read(bytes);
            streamIn.close();

            String contents = new String(bytes);
            version = Integer.parseInt(contents.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }


        unitInfo.setVersion(version);

        ResetAll();
    }


    public void makeDialogBox(){

        SelectVersionDialogFragment selectVersionDialogFragment = new SelectVersionDialogFragment();
        selectVersionDialogFragment.show(getFragmentManager(),path);

    }

    public int getVersion(){
        File file = new File(path, FILENAME);
        int length = (int) file.length();
        byte[] bytes = new byte[length];

        try {
            FileInputStream streamIn = new FileInputStream(file);
            streamIn.read(bytes);
            streamIn.close();

            String contents = new String(bytes);
            return Integer.parseInt(contents.trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


}

