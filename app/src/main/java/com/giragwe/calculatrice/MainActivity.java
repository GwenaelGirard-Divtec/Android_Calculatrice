package com.giragwe.calculatrice;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

enum Operations {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("x"),
    DIVIDE("/");

    private String symbole;

    Operations(String symbole) {
        this.symbole = symbole;
    }

    @Override
    public String toString() {
        return symbole;
    }
}

public class MainActivity extends AppCompatActivity {

    private Button BT_0;
    private Button BT_1;
    private Button BT_2;
    private Button BT_3;
    private Button BT_4;
    private Button BT_5;
    private Button BT_6;
    private Button BT_7;
    private Button BT_8;
    private Button BT_9;
    private Button BT_Decimal;
    private Button BT_Add;
    private Button BT_Subtract;
    private Button BT_Multiply;
    private Button BT_Divide;
    private Button BT_Clear;
    private Button BT_ClearAll;
    private Button BT_Calculate;

    private TextView ED_Affichage;
    private TextView TXT_Memory;

    private String currentTerm = "";
    private boolean isDecimal = false;

    private boolean isOperation = false;

    private float term1 = 0;
    private float term2 = 0;
    private Operations op;
    private float result = 0;

    private boolean clearAll = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BT_0 = findViewById(R.id.button0);
        BT_1 = findViewById(R.id.button1);
        BT_2 = findViewById(R.id.button2);
        BT_3 = findViewById(R.id.button3);
        BT_4 = findViewById(R.id.button4);
        BT_5 = findViewById(R.id.button5);
        BT_6 = findViewById(R.id.button6);
        BT_7 = findViewById(R.id.button7);
        BT_8 = findViewById(R.id.button8);
        BT_9 = findViewById(R.id.button9);
        BT_Decimal = findViewById(R.id.buttonDecimal);
        BT_Add = findViewById(R.id.buttonAdd);
        BT_Subtract = findViewById(R.id.buttonSubtract);
        BT_Multiply = findViewById(R.id.buttonMultiply);
        BT_Divide = findViewById(R.id.buttonDivide);
        BT_Clear = findViewById(R.id.buttonClear);
        BT_ClearAll = findViewById(R.id.buttonClearAll);
        BT_Calculate = findViewById(R.id.buttonCalculate);

        ED_Affichage = findViewById(R.id.txtOperation);
        TXT_Memory = findViewById(R.id.txtMemory);
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*
        AJOUT DES EVENEMENT SUR LES BOUTONS
         */

        BT_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_0.getText());
            }
        });

        BT_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_1.getText());
            }
        });

        BT_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_2.getText());
            }
        });

        BT_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_3.getText());
            }
        });

        BT_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_4.getText());
            }
        });

        BT_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_5.getText());
            }
        });

        BT_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_6.getText());
            }
        });

        BT_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_7.getText());
            }
        });

        BT_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_8.getText());
            }
        });

        BT_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNbr((String) BT_9.getText());
            }
        });



        BT_Decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendDecimal();
            }
        });


        BT_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toucheOp(Operations.ADD);
            }
        });

        BT_Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toucheOp(Operations.SUBTRACT);
            }
        });

        BT_Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toucheOp(Operations.MULTIPLY);
            }
        });

        BT_Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toucheOp(Operations.DIVIDE);
            }
        });

        BT_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toucheEgal();
            }
        });


        BT_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTerm = "";
                isDecimal = false;
                ED_Affichage.setText(currentTerm);
            }
        });

        BT_ClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                term1 = 0;
                term2 = 0;
                result = 0;
                ED_Affichage.setText("");
                TXT_Memory.setText("");
                currentTerm = "";
                isDecimal = false;
                isOperation = false;
                ED_Affichage.setText(currentTerm);
            }
        });

    }

    private void appendNbr(String number) {
        if (!currentTerm.equals("0")) {
            currentTerm += number;
            ED_Affichage.setText(currentTerm);
        }
    }

    private void appendDecimal() {
        if (currentTerm != "" && !isDecimal) {
            currentTerm += ".";
            ED_Affichage.setText(currentTerm);
            isDecimal = true;
        }
    }

    private void toucheOp(Operations newOp) {

        if (isOperation) {
            toucheEgal();
        }

        op = newOp;

        if (!currentTerm.equals("")) {
            term1 = Float.parseFloat(currentTerm);
            String ligne = fmt(term1) + " " + op;
            TXT_Memory.setText(ligne);
            currentTerm = "";
            ED_Affichage.setText("");
            isDecimal = false;
            clearAll = false;
        } else {
            String ligne = fmt(term1) + " " + op;
            TXT_Memory.setText(ligne);
        }

        isOperation = true;

    }

    /**
     * Effectue l'opération
     */
    private void toucheEgal() {
        // si un nombre est entré par l'utilisateur
        if (!currentTerm.equals("")) {
            //Efface le champs "mémoire"
            TXT_Memory.setText("");
            //Stock le terme entré par l'utilisateur
            term2 = Float.parseFloat(currentTerm);

            //calcul le résultat et le stock dans une variable mais aussi à la place du premier terme
            result = calculate(term1, op, term2);
            term1 = result;
            term2 = 0;

            //efface l'ancien terme et affiche le résultat dans le champs de saisie
            currentTerm = "";
            ED_Affichage.setText(fmt(result));
            isDecimal = false;

            isOperation = false;
        }
    }

    /**
     * Calcul le résultat d'une opération en fonction des termes et du symbole de l'opération
     * @param term1 permier terme
     * @param op signe d'opération
     * @param term2 deuxième terme
     * @return le résultat
     */
    private float calculate(float term1, Operations op, float term2) {
        float result = 0;

        switch (op) {
            case ADD: result = term1 + term2;
                break;
            case SUBTRACT: result = term1 - term2;
                break;
            case MULTIPLY: result = term1 * term2;
                break;
            case DIVIDE: result = term1 / term2;
                break;
        }
        return result;
    }

    /**
     * Format un float en String pour l'afficher avec des virgules seulement si il en faut
     * @param nbrFloat le nombre de type float
     * @return la chaine de caractère formaté
     */
    public static String fmt(float nbrFloat) {
        String formatedString = "";

        if(nbrFloat == (long) nbrFloat)
            formatedString = format("%d",(long)nbrFloat);
        else
            formatedString = format("%s",nbrFloat);

        return formatedString;
    }
}