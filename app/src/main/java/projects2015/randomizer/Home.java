package projects2015.randomizer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class Home extends ActionBarActivity {

    ArrayList<String> elements = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView countDisplay = (TextView) findViewById(R.id.counter);
        final TextView resultDisplay = (TextView) findViewById(R.id.textView);
        final EditText inputField = (EditText) findViewById(R.id.editText);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button doneButton = (Button) findViewById(R.id.randomizeButton);
        Button clearButton = (Button) findViewById(R.id.clearButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(inputField.getText().toString().isEmpty())){
                    queueEntry(inputField.getText().toString());
                    inputField.setText("");
                    countDisplay.setText(Integer.toString(elements.size()));
                }
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(elements.isEmpty())){
                    resultDisplay.setText(randomizeEntry());
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearQueue();
                countDisplay.setText(Integer.toString(elements.size()));
                resultDisplay.setText("Result");
            }
        });
    }

    public void queueEntry(String entry){
        elements.add(entry);
    }

    public String randomizeEntry(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(elements.size());
        return elements.get(randomIndex);
    }

    public void clearQueue(){
        elements.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
