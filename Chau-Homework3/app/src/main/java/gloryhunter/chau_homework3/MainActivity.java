    package gloryhunter.chau_homework3;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private TextView tvDisplay;

        private Button btEqual;
        private Button btAdd;
        private Button btSub;
        private Button btMul;
        private Button btDiv;
        private Button btClear;
        private float num1 = 0;
        private float num2 = 0;
        private boolean add, sub, mul, div;
        private ImageButton ib_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = (TextView) findViewById(R.id.tv_display);

        btEqual = (Button) findViewById(R.id.bt_equal);
        btAdd = (Button) findViewById(R.id.bt_add);
        btSub = (Button) findViewById(R.id.bt_sub);
        btMul = (Button) findViewById(R.id.bt_mul);
        btDiv = (Button) findViewById(R.id.bt_div);
        btClear = (Button) findViewById(R.id.bt_clear);
        ib_del = (ImageButton) findViewById(R.id.ib_del);

        btEqual.setOnClickListener(this);
        btClear.setOnClickListener(this);
        btSub.setOnClickListener(this);
        btAdd.setOnClickListener(this);
        btMul.setOnClickListener(this);
        btDiv.setOnClickListener(this);
        ib_del.setOnClickListener(this);


    }


        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.bt_equal:
                   result();
                    break;

                case R.id.bt_add:
                    try {
                        if (tvDisplay.getText().equals("")){
                            add = true;
                            sub = false;
                            mul = false;
                            div = false;
                            backGroundButtonOperator();
                            break;
                        }

                        result();
                        addNumber1();
                        add = true;
                        sub = false;
                        mul = false;
                        div = false;
                        backGroundButtonOperator();
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }

                    break;

                case R.id.bt_sub:
                    try {
                        if (tvDisplay.getText().equals("")){
                            add = false;
                            sub = true;
                            mul = false;
                            div = false;
                            backGroundButtonOperator();
                            break;
                        }
                        result();
                        addNumber1();
                        add = false;
                        sub = true;
                        mul = false;
                        div = false;
                        backGroundButtonOperator();
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }
                    break;

                case R.id.bt_mul:
                    try {
                        if (tvDisplay.getText().equals("")){
                            add = false;
                            sub = false;
                            mul = true;
                            div = false;
                            backGroundButtonOperator();
                            break;
                        }
                        result();
                        addNumber1();
                        add = false;
                        sub = false;
                        mul = true;
                        div = false;
                        backGroundButtonOperator();
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }
                    break;

                case R.id.bt_div:
                    try {
                        if (tvDisplay.getText().equals("")){
                            add = false;
                            sub = false;
                            mul = false;
                            div = true;
                            backGroundButtonOperator();
                            break;
                        }
                        result();
                        addNumber1();
                        add = false;
                        sub = false;
                        mul = false;
                        div = true;
                        backGroundButtonOperator();
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }
                    break;

                case R.id.bt_clear:
                    tvDisplay.setText("");
                    num1 = 0;
                    num2 = 0;
                    add = false;
                    sub = false;
                    mul = false;
                    div = false;
                    backGroundButtonOperator();
                    break;

                case R.id.ib_del:
                    if (!tvDisplay.getText().equals("")) {
                        tvDisplay.setText(tvDisplay.getText().subSequence(0, tvDisplay.getText().toString().length() - 1));
                    }
                        break;

                default:
                    break;
            }
        }

        private void backGroundButtonOperator() {
            if (add){
                btAdd.setBackgroundColor(Color.GREEN);
                btSub.setBackgroundColor(Color.WHITE);
                btMul.setBackgroundColor(Color.WHITE);
                btDiv.setBackgroundColor(Color.WHITE);
            }
            if (sub){
                btAdd.setBackgroundColor(Color.WHITE);
                btSub.setBackgroundColor(Color.GREEN);
                btMul.setBackgroundColor(Color.WHITE);
                btDiv.setBackgroundColor(Color.WHITE);
            }
            if (mul){
                btAdd.setBackgroundColor(Color.WHITE);
                btSub.setBackgroundColor(Color.WHITE);
                btMul.setBackgroundColor(Color.GREEN);
                btDiv.setBackgroundColor(Color.WHITE);
            }
            if (div){
                btAdd.setBackgroundColor(Color.WHITE);
                btSub.setBackgroundColor(Color.WHITE);
                btMul.setBackgroundColor(Color.WHITE);
                btDiv.setBackgroundColor(Color.GREEN);
            }
            if (!div && !mul && !sub && !add){
                btAdd.setBackgroundColor(Color.WHITE);
                btSub.setBackgroundColor(Color.WHITE);
                btMul.setBackgroundColor(Color.WHITE);
                btDiv.setBackgroundColor(Color.WHITE);
            }
        }

        private void result() {
            try {
                num2 = Float.parseFloat(tvDisplay.getText().toString());
                if (add) {
                    tvDisplay.setText("" + (num1 + num2));
                    add = false;
                    btAdd.setBackgroundColor(Color.WHITE);
                }
                if (sub){
                    tvDisplay.setText("" + (num1 - num2));
                    sub = false;
                    btSub.setBackgroundColor(Color.WHITE);
                }
                if (mul){
                    tvDisplay.setText("" + (num1 * num2));
                    mul = false;
                    btMul.setBackgroundColor(Color.WHITE);
                }
                if (div){
                    tvDisplay.setText("" + (num1 / num2));
                    div = false;
                    btDiv.setBackgroundColor(Color.WHITE);
                }

            }catch (NumberFormatException ex){
                wrongnumber();

            }

        }

        private void addNumber1() {
            num1 = Float.parseFloat(tvDisplay.getText().toString());
            tvDisplay.setText("");
        }

        private void wrongnumber() {
            Toast toast = Toast.makeText(this, tvDisplay.getText() + "  -> Day khong phai so OK !", Toast.LENGTH_LONG);
            toast.show();
            tvDisplay.setText("");
        }

        public void onClickButton(View view) {
            Button b = (Button) view;
            String input = tvDisplay.getText().toString() + b.getText();
            tvDisplay.setText(input);
        }


    }
