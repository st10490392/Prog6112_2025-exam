/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ripfumelo ngobeni
 */
public interface IOperations {
    // Returns total operations across all years
    int getTotal();
    // Returns total operations for a specific year (1-based index)
    int getYearTotal(int year);
}