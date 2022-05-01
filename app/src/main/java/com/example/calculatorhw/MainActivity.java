package com.example.calculatorhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    Button button;
    TextView workingTextView;
    TextView resultTextView;
    String working="";
    String operator="";
    String oldNumber="";
    String newNumber="";
    boolean point=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializingText();
        display=findViewById(R.id.workingAreaTextView);
    }
    public  void initializingText()
    {
     workingTextView=(TextView)findViewById(R.id.workingAreaTextView);
     resultTextView=(TextView) findViewById(R.id.resultTextView);
    }
    public  void working(String s)
    {
        working=working+s;
        newNumber=working;
        workingTextView.setText(oldNumber+operator+newNumber);
    }

    public void clearOnClick(View view) {
        workingTextView.setText("");
        working="";
        oldNumber="";
        newNumber="";
        operator="";
        resultTextView.setText("");
        point=false;
    }
    public void equalsToOnClick(View view) {
        double result=0.0;

        switch (operator) {
            case "+":
                try {
                    result=Double.parseDouble(oldNumber)+Double.parseDouble(working);
                    resultTextView.setText(result+"");
                    workingTextView.setText(result+"");
                    working=Double.toString(result);
                    oldNumber=Double.toString(result);
                }
                catch (Exception ex)
                {
                    workingTextView.setText("");
                    working="";
                    oldNumber="";
                    newNumber="";
                    operator="";
                    resultTextView.setText("ERROR");
                }
                break;
            case "-":
                try {
                    result=Double.parseDouble(oldNumber)-Double.parseDouble(working);
                    resultTextView.setText(result+"");
                    workingTextView.setText(result+"");
                    working=Double.toString(result);
                    oldNumber=Double.toString(result);
                }
                catch (Exception ex)
                {
                    workingTextView.setText(" ");
                    working="";
                    oldNumber="";
                    newNumber="";
                    operator="";
                    resultTextView.setText("ERROR");
                }

                break;
            case "*":
                try {
                    result=Double.parseDouble(oldNumber)*Double.parseDouble(working);
                    resultTextView.setText(result+"");
                    workingTextView.setText(result+"");
                    working=Double.toString(result);
                    oldNumber=Double.toString(result);
                }
                catch (Exception ex)
                {
                    workingTextView.setText("");
                    working="";
                    oldNumber="";
                    newNumber="";
                    operator="";
                    resultTextView.setText("ERROR");
                }
                break;
            case "/":
                try {
                    result=Double.parseDouble(oldNumber)/Double.parseDouble(working);
                    resultTextView.setText(result+"");
                    workingTextView.setText(result+"");
                    working=Double.toString(result);
                    oldNumber=Double.toString(result);
                }
                catch (Exception ex)
                {
                    workingTextView.setText("");
                    working="";
                    oldNumber="";
                    newNumber="";
                    operator="";
                    resultTextView.setText("ERROR");
                }
                break;
        }
        int x=0;
        String y=Double.toString(result);
        try {
             x=Integer.parseInt(y);
             point=true;
        }
        catch (Exception e)
        {
            point=false;
        }
    }
    public void operationPerformed(View view)
    {
        oldNumber=working;
        working="";
            switch (view.getId())
            {
                case R.id.plusBTN:
                    operator = "+";
                    break;
                case R.id.minusBTN:
                    operator = "-";
                    break;
                case R.id.divideBTN:
                    operator = "/";
                    break;
                case R.id.multiplyBTN:
                    operator = "*";
                    break;
            }

                point=false;
            newNumber=newNumber + operator;
    }
    public void numberValueOnClick(View v) {
       Button pressedButton=(Button) v;

       String buttonText=pressedButton.getText().toString();
           working(buttonText);
    }
    public void decimalPoint(View view)
    {
       if (point==false)
       {
           working(".");
           point=true;
       }
       else{

       }
    }

}