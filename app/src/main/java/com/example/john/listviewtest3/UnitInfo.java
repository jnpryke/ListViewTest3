package com.example.john.listviewtest3;

/**
 * Created by John on 10/8/2016.
 */
public class UnitInfo {
    private int cost, attack, defense, movement;
    private String[] unitNamesStringArray = {"Infantry", "Artillery", "Tank", "AAA", "Fighter", "Bomber", "Submarine", "Transport",
            "Destroyer", "Cruiser", "Battleship", "Aircraft Carrier", "Industrial Complex",
            "Repair Industrial Complex"};

    private int[][] unitStatsInfo = {{3,1,2,1},{4,2,2,1},{6,3,3,2},{5,0,0,1},{10,3,4,4},{12,4,1,6},
            {6,2,1,2},{7,0,0,2},{8,2,2,2},{12,3,3,2},{20,4,4,2},{14,1,2,2},{15,0,0,0},{1,0,0,0}};



    public UnitInfo(){

    }

    public String makeUnitInfoString(int position){
        String unitInfoString = "";

        unitInfoString += unitNamesStringArray[position] + "\n";
        unitInfoString += "Cost: " + unitStatsInfo[position][0] + "\n";
        if(unitStatsInfo[position][1] != 0) {
            unitInfoString += "Attack: " + unitStatsInfo[position][1] + "\n";
        }
        if(unitStatsInfo[position][2] != 0) {
            unitInfoString += "Defense: " + unitStatsInfo[position][2] + "\n";
        }
        if(unitStatsInfo[position][3] != 0) {
            unitInfoString += "Movement: " + unitStatsInfo[position][3];
        }

        return unitInfoString;
    }
}
