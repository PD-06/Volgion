/********************************************************************************
 * Copyright (c) 2024 PD`06
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *******************************************************************************/

package Experimental;

import java.awt.event.*;
import javax.swing.*;

public class BMICalculator {
    JFrame fFrame;
    JTextField tFWeight;
    JTextField tFHeight;
    JLabel lWeigth;
    JLabel lHeight;
    JLabel lBMI;
    JLabel lBMIRes;
    JLabel lCategory;
    JLabel lCategoryRes;
    JButton bCalculate;

    BMICalculator() {
        lWeigth = new JLabel("Your weight in kg:");
        lWeigth.setBounds(100, 150, 200, 25);

        lHeight = new JLabel("Your height in cm:");
        lHeight.setBounds(100, 250, 200, 25);

        tFWeight = new JTextField();
        tFWeight.setBounds(178, 200, 45, 25);

        tFHeight = new JTextField();
        tFHeight.setBounds(178, 300, 45, 25);

        lBMI = new JLabel("You BMI Index is:");
        lBMI.setBounds(500, 150, 200, 25);

        lBMIRes = new JLabel();
        lBMIRes.setBounds(525, 200, 150, 25);

        lCategory = new JLabel("You're categorized as:");
        lCategory.setBounds(485, 250, 230, 25);

        lCategoryRes = new JLabel();
        lCategoryRes.setBounds(425, 300, 350, 25);

        bCalculate = new JButton("Calculate BMI");
        bCalculate.setBounds(325, 400, 150, 25);
        bCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(tFWeight.getText());
                double height = Double.parseDouble(tFHeight.getText());
                double bmi = weight / (height * height * 0.0001);
                lBMIRes.setText(Double.toString(bmi));

                String category;
                if (bmi < 16) {
                    category = "Underweight (Severe thinness)";
                } else if (bmi <= 16.9) {
                    category = "Underweight (Moderate thinness)";
                } else if (bmi <= 18.4) {
                    category = "Underweight (Mild thinness)";
                } else if (bmi < 24.9) {
                    category = "Normal";
                } else if (bmi <= 29.9) {
                    category = "Overweight (Pre-obese)";
                } else if (bmi <= 34.9) {
                    category = "Obese (Class I)";
                } else if (bmi <= 39.9) {
                    category = "Obese (Class II)";
                } else {
                    category = "Obese (Class III)";
                }
                lCategoryRes.setText(category);
            }
        });

        fFrame = new JFrame("Volgion: BMI Calculator");

        fFrame.add(lWeigth);
        fFrame.add(lHeight);
        fFrame.add(tFWeight);
        fFrame.add(tFHeight);
        fFrame.add(lBMI);
        fFrame.add(lBMIRes);
        fFrame.add(lCategory);
        fFrame.add(lCategoryRes);
        fFrame.add(bCalculate);

        fFrame.setSize(800, 500);
        fFrame.setLayout(null); // Use no layout manager
        fFrame.setVisible(true); // Make the frame visible; default is false, I think
        fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}