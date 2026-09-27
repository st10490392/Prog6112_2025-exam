/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitaloperationsapp;

/**
 *
 * @author ripfumelo vunene ngobeni
 */


public class Operations implements IOperations {

    @Override
    public int getTotal(int[][] data) {
        int total = 0;
        for (int[] year : data) {
            for (int quarter : year) {
                total += quarter;
            }
        }
        return total;
    }

    @Override
    public double getAverage(int[][] data) {
        int count = 0;
        int total = getTotal(data);

        for (int[] year : data) {
            for (int ignored : year) {
                count++;
            }
        }
        return (double) total / count;
    }

    @Override
    public int getMax(int[][] data) {
        int max = data[0][0];
        for (int[] year : data) {
            for (int quarter : year) {
                if (quarter > max)
                    max = quarter;
            }
        }
        return max;
    }

    @Override
    public int getMin(int[][] data) {
        int min = data[0][0];
        for (int[] year : data) {
            for (int quarter : year) {
                if (quarter < min)
                    min = quarter;
            }
        }
        return min;
    }

}

