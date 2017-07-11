package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CICCC-CIRAC on 2017-07-10.
 */

public class ToastExample extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String sizeStr;
    private StringBuilder orderReceiptMsg;
    private Button toastBtn;
    private EditText nameText;
    int basePrice;
    int toppingPrice;
    int totalPrice;
    public static final String SIZE_REGULAR = "REGULAR";
    public static final String SIZE_MEDIUM = "MEDIUM";
    public static final String SIZE_LARGE = "LARGE";
    List<String> toppingList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
        basePrice = 0;
        toppingPrice = 0;
        totalPrice = 0;

        sizeStr = "REGULAR";
        toppingList = new ArrayList<>();

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        toastBtn = (Button) findViewById(R.id.toastBtn);
        nameText = (EditText) findViewById(R.id.nameText);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) findViewById(checkedId);
                sizeStr = radioButton.getText().toString();
            }
        });

        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePizza();
                makeMessages();
                Context context = getApplicationContext();
                String msg = orderReceiptMsg.toString();
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(context, msg, duration);
                t.show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"saeko0032@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Order");
                intent.putExtra(Intent.EXTRA_TEXT, msg);

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        CheckBox tempCheck = (CheckBox) findViewById(view.getId());

        if (checked) {
            switch (tempCheck.getId()) {
                case R.id.peperoni:
                    toppingList.add("peperoni");
                    toppingPrice += 1;
                    break;
                case R.id.mushroom:
                    toppingList.add("mushroom");
                    toppingPrice += 2;
                    break;
                case R.id.blackOlives:
                    toppingList.add("blackOlives");
                    toppingPrice += 3;
                    break;
                case R.id.pinapple:
                    toppingList.add("pinapple");
                    toppingPrice += 4;
                    break;
            }
            // this event called when you clicked, so checked -> unchecked
        } else {
            switch (tempCheck.getId()) {
                case R.id.peperoni:
                    toppingList.remove("peperoni");
                    toppingPrice -= 1;
                    break;
                case R.id.mushroom:
                    toppingList.add("mushroom");
                    toppingPrice -= 2;
                    break;
                case R.id.blackOlives:
                    toppingList.add("blackOlives");
                    toppingPrice -= 3;
                    break;
                case R.id.pinapple:
                    toppingList.add("pinapple");
                    toppingPrice -= 4;
                    break;
            }
        }
    }

    public void calculatePizza() {
        checkPizzaSize();
        totalPrice = basePrice + toppingPrice;
    }

    public void checkPizzaSize() {
        if (sizeStr.equals(SIZE_REGULAR)) {
            basePrice = 10;
        } else if (sizeStr.equals(SIZE_MEDIUM)) {
            basePrice = 20;
        } else if (sizeStr.equals(SIZE_LARGE)) {
            basePrice = 30;
        } else {
            // error
        }
    }

    public void makeMessages() {
        orderReceiptMsg = new StringBuilder();
        // name
        orderReceiptMsg.append("Name : ");
        String orderName = nameText.getText().toString();
        if(orderName.equals("")) {
            orderName = "Clark Kent";
        }
        orderReceiptMsg.append(orderName + "\n");
        // size
        orderReceiptMsg.append("Size : " + sizeStr + "\n");
        // topping
        orderReceiptMsg.append("Topping : ");
        for(String str: toppingList) {
            orderReceiptMsg.append(str + "\n");
        }
        // price
        orderReceiptMsg.append("Price : " + Integer.toString(totalPrice) + "\n");
    }
}
