package projects.arielcatli.aquabot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    private ImageView mMain_menu_graph;
    private ImageView mMain_menu_switch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_menu);

        mMain_menu_graph = (ImageView) findViewById(R.id.main_menu_graph);
        mMain_menu_switch = (ImageView) findViewById(R.id.main_menu_switch);

        setClicks(mMain_menu_graph, "Opening the graphing utility...", MainMenu_GraphActivity.class);
        setClicks(mMain_menu_switch, "Opening the switch controls...", MainMenu_SwitchActivity.class);

        /*
        mMain_menu_graph.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainMenuActivity.this, "Opening the graphing utility.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainMenuActivity.this, MainMenu_GraphActivity.class);
                startActivity(intent);
            }
        });
        */

    }


    private void setClicks(ImageView v, final String message, final Class<?> activityToStart)
    {
        v.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainMenuActivity.this, message, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainMenuActivity.this, activityToStart);
                startActivity(intent);
            }
        });
    }


}
