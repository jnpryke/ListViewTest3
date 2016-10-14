package com.example.john.listviewtest3;

/**
 * Created by John on 10/13/2016.
 */

public class UnitInfo {

    private int[] unitQuantityArray;
    private int[] unitPriceArray;
    private String[] unitNamesStringArray;
    private int[][] unitStatsInfoArray;
    private int [] AnAImages;

    UnitInfo(int version){
        setVersion(version);
    }

    public void setVersion(int version){
        //version 0 = Axis and Allies 1942 second edition
        if(version == 0){
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,6,5,10,12,6,7,8,12,20,14,15,1};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Tank", "AAA", "Fighter", "Bomber",
                    "Submarine", "Transport", "Destroyer", "Cruiser", "Battleship", "Aircraft Carrier",
                    "Industrial Complex", "Repair Industrial Complex"};
            AnAImages = new int[] {R.drawable.infantry, R.drawable.artillery, R.drawable.tank, R.drawable.aaa,
                    R.drawable.fighter,R.drawable.bomber, R.drawable.submarine, R.drawable.transport,
                    R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                    R.drawable.aircraftcarrier, R.drawable.industrialcomplex, R.drawable.repairindustrialcomplex};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{6,3,3,2},{5,0,0,1},{10,3,4,4},{12,4,1,6},
                    {6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{14,1,2,2},{15,0,0,0},{1,0,0,0}};

        }

        //version 1 = Axis and Allies 1941
        if(version == 1){
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,6,10,12,6,7,8,16,12};
            unitNamesStringArray = new String[]{"Infantry", "Tank", "Fighter", "Bomber",
                    "Submarine", "Transport", "Destroyer", "Battleship", "Aircraft Carrier"};
            AnAImages = new int[] {R.drawable.infantry, R.drawable.tank,
                    R.drawable.fighter,R.drawable.bomber, R.drawable.submarine, R.drawable.transport,
                    R.drawable.destroyer, R.drawable.battleship,R.drawable.aircraftcarrier};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{6,3,3,2},{10,3,4,4},{12,4,1,6},
                    {6,2,1,2},{7,0,0,2},{8,2,2,2},{16,4,4,2},{12,1,2,2}};

        }
        //!complete
        //version 2 = Axis and Allies 1940 Pacific/Europe second edition
        if(version == 2){
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,4,6,5,10,11,12,6,7,8,12,20,16,30,12,1,20,15,15};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Mechanized Infantry", "Tank", "AAA", "Fighter",
                    "Tactical Bomber", "Strategic Bomber", "Submarine", "Transport", "Destroyer", "Cruiser", "Battleship",
                    "Aircraft Carrier", "Major Industrial Complex", "Minor Industrial Complex","Repair Industrial Complex",
                    "Upgrade Industrial Complex","Air Base","Naval Base"};
            //!complete
            AnAImages = new int[] {R.drawable.infantry, R.drawable.artillery, R.drawable.tank, R.drawable.aaa,
                    R.drawable.fighter,R.drawable.bomber, R.drawable.submarine, R.drawable.transport,
                    R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                    R.drawable.aircraftcarrier, R.drawable.industrialcomplex, R.drawable.repairindustrialcomplex};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{4,1,2,2},{6,3,3,2},{5,0,0,1},{10,3,4,4},{11,3,3,4},
                    {12,4,1,6},{6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{16,1,2,2},{30,0,0,0}, {15,0,0,0},
                    {1,0,0,0},{20,0,0,0},{15,0,0,0},{15,0,0,0}};

        }

        //version 3 = Axis and Allies 1942 Spring
        if(version == 3){
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,6,5,10,12,6,7,8,12,20,14,15,1};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Tank", "AAA", "Fighter", "Bomber",
                    "Submarine", "Transport", "Destroyer", "Cruiser", "Battleship", "Aircraft Carrier",
                    "Industrial Complex", "Repair Industrial Complex"};
            AnAImages = new int[] {R.drawable.infantry, R.drawable.artillery, R.drawable.tank, R.drawable.aaa,
                    R.drawable.fighter,R.drawable.bomber, R.drawable.submarine, R.drawable.transport,
                    R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                    R.drawable.aircraftcarrier, R.drawable.industrialcomplex, R.drawable.repairindustrialcomplex};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{5,3,3,2},{6,0,0,1},{10,3,4,4},{12,4,1,6},
                    {6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{14,1,2,2},{15,0,0,0},{1,0,0,0}};

        }
    }

    public int[] getAnAImages() {
        return AnAImages;
    }

    public int[] getUnitPriceArray() {
        return unitPriceArray;
    }

    public int[] getUnitQuantityArray() {
        return unitQuantityArray;
    }

    public int[][] getUnitStatsInfoArray() {
        return unitStatsInfoArray;
    }

    public String[] getUnitNamesStringArray() {
        return unitNamesStringArray;
    }
}


