package com.cristian.Calculator.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicCalculator   implements ActionListener {
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton add, subtract, multiply, divide, negative, decimal, clear, delete, equal;
    JFrame frame;
    JPanel panel;
    JTextField textField;
    Font myfont = new Font("Showcard Ghotic", Font.BOLD, 20);
    Color yellow = new Color(247, 187, 14);
    Color black = new Color(41, 40, 44);
    Color red = Color.decode("#F00000");
    char operator;
    JButton[] operations = new JButton[5];

    LogicCalculator logic = new LogicCalculator();

    public GraphicCalculator(){

        frame = new JFrame("Calculator By Cristian");
        frame.setLayout(null);
        frame.setSize(420,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(black);
        frame.setResizable(false);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(45, 20, 300, 50);
        textField.setFont(myfont);
        textField.setBackground(Color.GRAY);
        textField.setForeground(this.black);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(45, 150, 300, 300);
        panel.setBackground(this.black);

        add = new JButton("+");
        add.setText("+");
        subtract = new JButton("-");
        multiply = new JButton("x");
        divide = new JButton("/");
        negative = new JButton("(-)");
        decimal = new JButton(".");
        clear = new JButton("C");
        delete = new JButton("Delete");
        equal = new JButton("=");

        functions[0] = add;
        functions[1] = subtract;
        functions[2] = multiply;
        functions[3] = divide;
        functions[4] = negative;
        functions[5] = decimal;
        functions[6] = clear;
        functions[7] = delete;
        functions[8] = equal;

        for (JButton function : functions){
            function.setBackground(yellow);
            function.setForeground(Color.BLACK);
            function.setFocusable(false);
            function.setFont(myfont);
            function.addActionListener(this);
        }

        for(int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].setBackground(Color.GRAY);
            numbers[i].setForeground(black);
            numbers[i].setFont(myfont);
            numbers[i].setFocusable(false);
            numbers[i].addActionListener(this);
        }

        clear.setBounds(45, 80, 70, 50);
        negative.setBounds(130, 80, 80, 50);
        delete.setBounds(230, 80, 112, 50);
        delete.setBackground(red);

        operations[0] = add;
        operations[1] = subtract;
        operations[2] = divide;
        operations[3] = multiply;

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtract);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiply);
        panel.add(decimal);
        panel.add(numbers[0]);
        panel.add(divide);
        panel.add(negative);
        panel.add(equal);

        frame.add(clear);
        frame.add(negative);
        frame.add(delete);
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        Object source = e.getSource();

        if(source == negative && !(textField.getText().contains("-")))
            textField.setText("-"+textField.getText());

        for (int i = 0; i < 10; i++)
            if (e.getSource() == numbers[i]) textField.setText(textField.getText().concat(String.valueOf(i)));

        if(source == clear)
            textField.setText("");

        if(source == delete) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; i++)
                textField.setText(textField.getText()+string.charAt(i));
        }

        if(source == decimal && !(textField.getText().contains(".")))
            textField.setText(textField.getText().concat("."));

        for(JButton operation: operations){
            if(source == operation){
                logic.setNumber(Double.parseDouble(textField.getText()));
                operator = (operation.getText().charAt(0));
                textField.setText("");
            }
        }

        if(source == equal){
            logic.operator(operator);
            logic.setNumber(Double.parseDouble(textField.getText()));
            textField.setText(String.valueOf(logic.operation()));
            logic.setNumber(Double.parseDouble(textField.getText()));
            System.out.println(logic.toString());
        }

    }
}



/* ------------------------- innecesary code*/

   /*
        if(source == add){
            double number = Double.parseDouble(textField.getText());
            logic.setNumber(number);
            operator = '+';
            textField.setText("");
        }

        if(source == multiply){
            double number = Double.parseDouble(textField.getText());
            logic.setNumber(number);
            operator = 'x';
            textField.setText("");
        }

        if(source == subtract){
            logic.setNumber(Double.parseDouble(textField.getText()));
            operator = '-';
            textField.setText("");
        }

        if(source == divide){
            double number = Double.parseDouble(textField.getText());
            logic.setNumber(number);
            operator = '/';
            textField.setText("");
        }
         */ 