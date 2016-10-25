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
    private String versionName;

    UnitInfo(int version){
        setVersion(version);
    }

    public void setVersion(int version){
        //version 0 = Axis and Allies 1942 Second Edition
        if(version == 0){
            versionName="Axis and Allies 1942 second edition";
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
            versionName="Axis and Allies 1941";
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

        //version 2 = Axis and Allies 1940 Europe/Pacific Second Edition
        if(version == 2){
            versionName="Axis and Allies 1940 Europe/Pacific second edition 2012";
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,4,6,5,10,11,12,6,7,8,12,20,16,12,20,1,30,15,15};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Mechanized Infantry", "Tank", "AAA", "Fighter",
                    "Tactical Bomber", "Strategic Bomber", "Submarine", "Transport", "Destroyer", "Cruiser", "Battleship",
                    "Aircraft Carrier", "Minor Industrial Complex", "Upgrade Industrial Complex","Repair Industrial Complex",
                    "Major Industrial Complex", "Air Base","Naval Base"};
            AnAImages = new int[] {R.drawable.infantry, R.drawable.artillery, R.drawable.mechanizedinfantry, R.drawable.tank,
                    R.drawable.aaa, R.drawable.fighter,R.drawable.tacticalbomber2, R.drawable.bomber, R.drawable.submarine,
                    R.drawable.transport, R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                    R.drawable.aircraftcarrier, R.drawable.minorindustrialcomplex,  R.drawable.upgradeindustrialcomplex,
                    R.drawable.repairindustrialcomplex, R.drawable.industrialcomplex,  R.drawable.airbase2, R.drawable.navalbase};

            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{4,1,2,2},{6,3,3,2},{5,0,0,1},{10,3,4,4},{11,3,3,4},
                    {12,4,1,6},{6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{16,0,2,2},{12,0,0,0}, {20,0,0,0},
                    {1,0,0,0},{30,0,0,0},{15,0,0,0},{15,0,0,0}};

        }

        //version 3 = Axis and Allies 1942 Spring
        if(version == 3){
            versionName="Axis and Allies 1942 Spring";
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

        //!complete
        //version 4 = Axis and Allies Anniversary Edition
        if(version == 4){
            versionName="Axis and Allies Anniversary Edition";
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,6,5,10,12,6,7,8,12,20,14,15,1};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Tank", "AAA", "Fighter", "Bomber",
                    "Submarine", "Transport", "Destroyer", "Cruiser", "Battleship", "Aircraft Carrier",
                    "Industrial Complex", "Repair Industrial Complex"};
            AnAImages = new int[] {R.drawable.infantry, R.drawable.artillery, R.drawable.tank, R.drawable.aaa,
                    R.drawable.fighter,R.drawable.bomber, R.drawable.submarine, R.drawable.transport,
                    R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                    R.drawable.aircraftcarrier, R.drawable.industrialcomplex, R.drawable.repairindustrialcomplex};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{5,3,3,2},{6,0,1,1},{10,3,4,4},{12,4,1,6},
                    {6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{14,1,2,2},{15,0,0,0},{1,0,0,0}};

        }

        //version 5 = Axis and Allies 1940 Europe/Pacific
        if(version == 5){
            versionName="Axis and Allies 1940 Europe/Pacific 2010/2009";
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,4,6,6,10,11,12,6,7,8,12,20,16,12,20,1,30,15,15};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Mechanized Infantry", "Tank", "AAA", "Fighter",
                    "Tactical Bomber", "Strategic Bomber", "Submarine", "Transport", "Destroyer", "Cruiser", "Battleship",
                    "Aircraft Carrier", "Minor Industrial Complex", "Upgrade Industrial Complex","Repair Industrial Complex",
                    "Major Industrial Complex", "Air Base","Naval Base"};
            AnAImages = new int[] {R.drawable.infantry, R.drawable.artillery, R.drawable.mechanizedinfantry, R.drawable.tank,
                    R.drawable.aaa, R.drawable.fighter,R.drawable.tacticalbomber2, R.drawable.bomber, R.drawable.submarine,
                    R.drawable.transport, R.drawable.destroyer, R.drawable.cruiser, R.drawable.battleship,
                    R.drawable.aircraftcarrier, R.drawable.minorindustrialcomplex,  R.drawable.upgradeindustrialcomplex,
                    R.drawable.repairindustrialcomplex, R.drawable.industrialcomplex,  R.drawable.airbase2, R.drawable.navalbase};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{4,1,2,2},{6,3,3,2},{6,0,0,1},{10,3,4,4},{11,3,3,4},
                    {12,4,1,6},{6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{16,0,2,2},{12,0,0,0}, {20,0,0,0},
                    {1,0,0,0},{30,0,0,0},{15,0,0,0},{15,0,0,0}};

        }

        //version 6 = Axis and Allies 1914
        if(version == 6){
            versionName="Axis and Allies 1914 2013";
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,6,6,12,9,6,6};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Tank", "Fighter",
                    "Submarine", "Transport", "Cruiser", "Battleship"};
            AnAImages = new int[] {R.drawable.infantryww1, R.drawable.artilleryww1, R.drawable.tankww1,
                    R.drawable.fighterww1,R.drawable.submarine, R.drawable.transport,
                    R.drawable.cruiserww1, R.drawable.battleshipww1};
            unitStatsInfoArray = new int[][]{{3,2,3,1},{4,3,3,1},{6,2,3,1},{6,2,2,2},
                   {6,2,2,2},{6,0,0,2},{9,3,3,3},{12,4,4,2}};
        }

        //not complete
        //version 7 = Axis and Allies Europe
        if(version == 7){
            versionName="Axis and Allies Europe 1999";
            unitQuantityArray = new int[]{0,0,0,0,0,0,0,0,0,0};
            unitPriceArray = new int[]{3,4,5,5,12,15,8,8,12,24,18};
            unitNamesStringArray = new String[]{"Infantry", "Artillery", "Armor", "AntiAircraft Gun", "Fighter",
                    "Bomber","Submarine", "Transport", "Destroyer", "Battleship", "Aircraft Carrier"};
            AnAImages = new int[] {R.drawable.infantry1999, R.drawable.artillery1999, R.drawable.tank1999,
                    R.drawable.aaa1999,R.drawable.fighterww1,R.drawable.submarine, R.drawable.transport,
                    R.drawable.cruiserww1, R.drawable.battleshipww1};
            unitStatsInfoArray = new int[][]{{3,1,2,1},{4,2,2,1},{5,3,2,2},{5,0,1,1},{12,3,4,4},
                    {15,4,1,6},{8,2,2,2},{8,0,1,2},{12,3,3,2},{24,4,4,2},{18,1,3,2}};
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


