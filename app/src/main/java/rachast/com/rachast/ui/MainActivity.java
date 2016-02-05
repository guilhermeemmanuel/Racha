package rachast.com.rachast.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import rachast.com.rachast.R;
import rachast.com.rachast.adapter.PickUpGameAdapter;
import rachast.com.rachast.model.PUGameManager;
import rachast.com.rachast.model.PickUpGame;

public class MainActivity extends AppCompatActivity {

    PUGameManager controller;

    PickUpGameAdapter adapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = PUGameManager.getInstance();
        controller.newPickUpGame();
        controller.startCurrentPickUpGame();
        listView = (ListView) findViewById(R.id.pickup_game_list);
        List<PickUpGame> games = new ArrayList<>();
        games.add(controller.getCurrentPickUpGame());
        listView.setAdapter(new PickUpGameAdapter(this, games));
    }

    public void setAdapter() {
    }

    public void addPickUpGame (View view) {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
