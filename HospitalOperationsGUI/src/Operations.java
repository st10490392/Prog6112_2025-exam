/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ripfumelo vunene ngobeni
 */
public class Operations implements IOperations {
    private int year1Total;
    private int year2Total;

    public Operations(int year1Total, int year2Total) {
        this.year1Total = year1Total;
        this.year2Total = year2Total;
    }

    @Override
    public int getTotal() {
        return year1Total + year2Total;
    }

    @Override
    public int getYearTotal(int year) {
        if (year == 1) return year1Total;
        if (year == 2) return year2Total;
        throw new IllegalArgumentException("Year must be 1 or 2.");
    }

    // Optional setters/getters if needed
    public int getYear1Total() { return year1Total; }
    public int getYear2Total() { return year2Total; }
}