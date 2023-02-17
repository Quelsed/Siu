package com.example.calculator;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView matchTextView;
    private EditText editTextNumber;
    private Button Answerbutton;
    private TextView answerTextView;
    private Button button2;
    private String[] commands;
    private int firstArg,secondArg;
    private Random random;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        commands =new String[]{"+","*"};
        random = new Random();
        setContentView(R.layout.activity_main);
        matchTextView = findViewById(R.id.matchTextView);
        editTextNumber=findViewById(R.id.editTextNumber);
        Answerbutton=findViewById(R.id.Answerbutton);
        answerTextView=findViewById(R.id.answerTextView);
        button2 =findViewById(R.id.button2);
        generateExsample();
        Answerbutton.setOnClickListener(view -> onAnswerClicked());
    }
    private void generateExsample(){
        firstArg=random.nextInt(99)+1;
        secondArg=random.nextInt(99)+1;
        String command = commands[random.nextInt(commands.length)];
        switch (command){
            case "+":
                result=firstArg + secondArg;
                break;
            case "*":
                result=firstArg*secondArg;
                break;
        }
        matchTextView.setText(firstArg + " " + command + " " + secondArg + " = ?");
    }
    private void onAnswerClicked(){
        boolean validate=false;
        try{
            int res = Integer.parseInt(editTextNumber.getText().toString());
            validate = result == res;
        }
        catch (Exception e){}
        Answerbutton.setVisibility(View.GONE);
        answerTextView.setBackgroundColor(validate ? getResources().getColor(R.color.green) : getResources().getColor(R.color.red));
        answerTextView.setText(validate ? R.string.right_answer : R.string.wrong_answer );
        answerTextView.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);

    }
}