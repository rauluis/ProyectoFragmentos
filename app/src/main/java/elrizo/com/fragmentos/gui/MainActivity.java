package elrizo.com.fragmentos.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

import elrizo.com.fragmentos.R;
import elrizo.com.fragmentos.core.FragmentosApplication;
import elrizo.com.fragmentos.databinding.ActivityMainBinding;
import elrizo.com.fragmentos.gui.components.NavigationHost;

public class MainActivity extends AppCompatActivity implements NavigationHost {

public  static HashMap <String, Object> GLOBALS = new HashMap<>();


    private MaterialButton mnTopgames;
    private MaterialButton mnTopRanked;
    private MaterialButton mnFreeToPlay;
    private MaterialButton mnMisJuegos;
    private MaterialButton mnCategorias;
    private MaterialButton mnViejaEscuela;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mnTopgames =findViewById(R.id.mnTopGames);
        mnTopRanked=findViewById(R.id.mnTopRanked);
        mnFreeToPlay=findViewById(R.id.mnFreeToPlay);
        mnMisJuegos=findViewById(R.id.mnMyGames);
        mnCategorias=findViewById(R.id.mnCategory);
        mnViejaEscuela=findViewById(R.id.mnOldSchool);

        setContentView(R.layout.activity_main);
        configContext();
        configGlobals();

        configFragmentManager(savedInstanceState);




    }






    private void configContext() {

        FragmentosApplication.setAppContext(getApplicationContext());
    }

    private void configGlobals() {
GLOBALS.put("app",this);
    }

    private void configFragmentManager(Bundle savedInstanceState) {

        if(savedInstanceState==null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, new TopJuegos())
                    .commit();

        }
          }




    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                .beginTransaction()
                        .setCustomAnimations(
                                R.animator.slide_in_left,
                                R.animator.slide_out_right,
                                R.animator.slide_in_right,
                                R.animator.slide_out_left)

                .replace(R.id.contentPanel,fragment);
        if(addToBackStack)
            transaction.addToBackStack(null);
        transaction.commit();

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.mnCategory:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new Categorias())
                        .commit();
                break;
            case R.id.mnFreeToPlay:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new FreeToPlay())
                        .commit();
                break;
            case R.id.mnMyGames:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new MisJuegos())
                        .commit();

                break;
            case R.id.mnOldSchool:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new ViejaEscuela())
                        .commit();

                break;
            case R.id.mnPerfil:
                break;
            case R.id.mnTopGames:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new TopJuegos())
                        .commit();
                break;
            case R.id.mnTopRanked:

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new TopRankeados())
                        .commit();
                break;

        }

    }
}