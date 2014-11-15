package ch.tranchida.android.pointcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class PointsCalculator extends Activity implements TextWatcher {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText proteinsEditText = (EditText) findViewById(R.id.proteins);
        proteinsEditText.addTextChangedListener(this);
        EditText glucidesEditText = (EditText) findViewById(R.id.glucides);
        glucidesEditText.addTextChangedListener(this);
        EditText lipidesEditText = (EditText) findViewById(R.id.lipides);
        lipidesEditText.addTextChangedListener(this);
        EditText fibresEditText = (EditText) findViewById(R.id.fibres);
        fibresEditText.addTextChangedListener(this);
        EditText poidEditText = (EditText) findViewById(R.id.poid);
        poidEditText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        EditText proteinsEditText = (EditText) findViewById(R.id.proteins);
        EditText glucidesEditText = (EditText) findViewById(R.id.glucides);
        EditText lipidesEditText = (EditText) findViewById(R.id.lipides);
        EditText fibresEditText = (EditText) findViewById(R.id.fibres);
        EditText poidEditText = (EditText) findViewById(R.id.poid);
        TextView pointsText = (TextView) findViewById(R.id.pointsText);

        try {
            double points = Math.round(
                    (Double.parseDouble(proteinsEditText.getText().toString()) / 11 +
                            Double.parseDouble(glucidesEditText.getText().toString()) / 9 +
                            Double.parseDouble(lipidesEditText.getText().toString()) / 4 +
                            Double.parseDouble(fibresEditText.getText().toString()) / 30) *
                            Double.parseDouble(poidEditText.getText().toString())
            ) / 100;

            pointsText.setText("Points : " + points);

        } catch (NumberFormatException e) {

            pointsText.setText("Points : N/A");

        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
