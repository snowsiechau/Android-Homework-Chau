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
                    try {
                        num2 = Float.parseFloat(tvDisplay.getText().toString());

                        if (add == true) {
                            tvDisplay.setText("" + (num1 + num2));
                            add = false;
                            btAdd.setBackgroundColor(Color.WHITE);
                        }
                        if (sub == true){
                            tvDisplay.setText("" + (num1 - num2));
                            sub = false;
                            btSub.setBackgroundColor(Color.WHITE);
                        }
                        if (mul == true){
                            tvDisplay.setText("" + (num1 * num2));
                            mul = false;
                            btMul.setBackgroundColor(Color.WHITE);
                        }
                        if (div == true){
                            tvDisplay.setText("" + (num1 / num2));
                            div = false;
                            btDiv.setBackgroundColor(Color.WHITE);
                        }

                    }catch (NumberFormatException ex){
                        wrongnumber();

                    }
                    break;

                case R.id.bt_add:
                    try {
                        addNumber1();
                        add = true;
                        btAdd.setBackgroundColor(Color.GREEN);
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }

                    break;

                case R.id.bt_sub:
                    try {
                        addNumber1();
                        sub = true;
                        btSub.setBackgroundColor(Color.GREEN);
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }
                    break;

                case R.id.bt_mul:
                    try {
                        addNumber1();
                        mul = true;
                        btMul.setBackgroundColor(Color.GREEN);
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }
                    break;

                case R.id.bt_div:
                    try {
                        addNumber1();
                        div = true;
                        btDiv.setBackgroundColor(Color.GREEN);
                    }catch (NumberFormatException ex){
                        wrongnumber();
                    }
                    break;

                case R.id.bt_clear:
                    tvDisplay.setText("");
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
