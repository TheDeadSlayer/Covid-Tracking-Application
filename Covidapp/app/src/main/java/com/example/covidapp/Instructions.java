package com.example.covidapp;

public class Instructions
{
    public String ChooseInstruction(String x)
    {
        switch (x)
        {
            case "PositiveVac":return "\nYou are Instructed to Quarantine yourself for 2 weeks in the Location shown above\nPlease avoid all contact with others for everyone's safety\nPlease instruct family members and friends to visit our medical centers to be tested";
            case "Positive": return "\nYou are Instructed to Quarantine yourself for 2 weeks in the Location shown above\nPlease avoid all contact with others for everyone's safety\nPlease instruct family members and friends to visit our medical centers to be tested \nIt is Recommended that you seek our medical centers to take the vaccine after 3 months after recovery";
            case "NegativeVac": return "\nPlease Follow all Covid precautions and Social Distancing rules for everyone's Safety";
            case "Negative":return "\nPlease Follow all Covid precautions and Social Distancing rules for everyone's Safety\nIt is Recommended that you seek our medical centers to take the vaccine as soon as possible";
            case "SuspectedVac":return"\nPlease visit our nearest medical center to do a PCR test\nMinimize all interactions";
            case "Suspected":return"\nPlease visit our nearest medical center to do a PCR test\nMinimize all interactions\nIt is Recommended that you seek our medical centers to take the vaccine as soon as possible";
            case "QuarantineVac":return "\nPlease follow the country's covid precautions to go through an Obligatory Quarantine for 1 week ";
            case "Quarantine":return "\nPlease follow the country's covid precautions to go through an Obligatory Quarantine for 1 week\nIt is Recommended that you seek  our medical centers to take the vaccine after the Quarantine period is over";
            default:return "Please follow Covid precautions";
        }
    }
}