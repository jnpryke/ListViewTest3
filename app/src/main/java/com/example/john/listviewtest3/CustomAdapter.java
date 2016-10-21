package com.example.john.listviewtest3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by John on 8/30/2016.
 */
public class CustomAdapter extends BaseAdapter {
    int [] imageId, unitPriceArray;
    static int [] unitQuantityArray;
    Context context;
    private static LayoutInflater inflater = null;

    public CustomAdapter(MainActivity mainActivity, int[] AnAImages, int[] unitQuantityArray, int[] unitPriceArray){
        context = mainActivity;
        imageId = AnAImages;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.unitQuantityArray = unitQuantityArray;
        this.unitPriceArray = unitPriceArray;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    // Holds values for the listview
    public class Holder
    {
        ImageView img;
        TextView unitQuantityTextView;
    }

    // Sets up the listview
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View rowView;
        rowView = inflater.inflate(R.layout.list_layout, null);

        Holder holder = new Holder();
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.img.setImageResource(imageId[position]);
        holder.unitQuantityTextView = (TextView) rowView.findViewById(R.id.unitQuantityTextView);

        ImageButton plusButton = (ImageButton) rowView.findViewById(R.id.imagePlusButton);
        ImageButton minusButton = (ImageButton) rowView.findViewById(R.id.imageMinusButton);

        plusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(MainActivity.IPCsEmpty()){
                    Toast.makeText(context, "Enter IPCs", Toast.LENGTH_LONG).show();
                }
                else if(MainActivity.notEnoughChange(position)){
                    Toast.makeText(context, "You don't have enough IPCs", Toast.LENGTH_SHORT).show();
                }
                else {
                    unitQuantityArray[position] = unitQuantityArray[position] + 1;
                    MainActivity.minusUnitCostFromIPCs(position);
                    notifyDataSetChanged();
                }
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(MainActivity.IPCsEmpty()){
                    Toast.makeText(context, "Enter IPCs", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (unitQuantityArray[position] != 0) {
                        unitQuantityArray[position] = unitQuantityArray[position] - 1;
                        MainActivity.addUnitCostToIPCs(position);
                        notifyDataSetChanged();
                    }
                }
            }
        });


        holder.unitQuantityTextView.setText(Integer.toString(unitQuantityArray[position]));

        return rowView;
    }

    // Resets all elements of the unitQuantityArray to 0
    public static void reset(){

        for(int i = 0; i < unitQuantityArray.length; i++){
            unitQuantityArray[i] = 0;
        }
    }

    public static int[] getUnitQuantityArray(){
        return unitQuantityArray;
    }

}

