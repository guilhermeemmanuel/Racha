package org.github.meuracha.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.github.jorgecastilloprz.FABProgressCircle;
import com.github.jorgecastilloprz.listeners.FABProgressListener;

import org.github.data.PickUpGameDAO;
import org.github.data.net.DataRequestCallBack;
import org.github.domain.model.PickUpGame;
import org.github.meuracha.R;

/**
 * Created by Cliente on 04/02/2016.
 */
public class AddPickUpGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pick_up_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText editText = (EditText) findViewById(R.id.et_pick_up_game_name);
        final FABProgressCircle fabProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
        fabProgressCircle.attachListener(new FABProgressListener() {
            @Override
            public void onFABProgressAnimationEnd() {
                Snackbar.make(fabProgressCircle, "Novo Racha salvo!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_save_pick_up_game);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabProgressCircle.show();
                PickUpGame pickUpGame = new PickUpGame(editText.getText().toString());
                PickUpGameDAO pickUpGameDAO = new PickUpGameDAO(getApplication());
                pickUpGameDAO.insertPickUpGame(pickUpGame, new DataRequestCallBack() {
                    @Override
                    public void onFailure(Exception e) {
                        try {
                            //TODO stop animation correctly
                            fabProgressCircle.hide();
                        } catch (Exception ignore) {
                            ignore.printStackTrace();
                        }
                        Snackbar.make(fabProgressCircle, "Falha, Verifique sua conexão com a internet.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null)
                                .show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(Object o) {
                        fabProgressCircle.beginFinalAnimation();


                    }
                });
            }
        });

    }

}
