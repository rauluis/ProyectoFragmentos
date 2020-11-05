package elrizo.com.fragmentos.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import elrizo.com.fragmentos.R;
import elrizo.com.fragmentos.databinding.FragmentViejaEscuelaBinding;
import elrizo.com.fragmentos.gui.components.JuegosAdapter;
import elrizo.com.fragmentos.gui.components.NavigationIconClickListener;
import elrizo.com.fragmentos.model.Juego;

public class ViejaEscuela  extends Fragment {

    private FragmentViejaEscuelaBinding binding;
    private View view;
    private Context context;
    private List<Juego> juegos = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        configGlobals();
        configView(inflater,container);
        configToolbar();
        configUI();
        configRecycler();
        return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("viejaEscuelaFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentViejaEscuelaBinding.inflate(inflater,container,false);
        view = binding.getRoot();
        context = container.getContext();
    }

    private void configToolbar() {
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if(activity!=null){
            activity.setSupportActionBar(binding.appBar);
        }
        binding.appBar.setNavigationOnClickListener(new NavigationIconClickListener(
                context,
                view.findViewById(R.id.gridViejaEscuela),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            view.findViewById(R.id.gridViejaEscuela).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));

        }
    }

    private void configRecycler() {

     /*   juegos.add(new Juego(1,"runescape","Runescape",1,"Literalmente Vieja escuela"));
        juegos.add(new Juego(2,"tetris","Tetris",4,"Figuritas callendo"));
        juegos.add(new Juego(3,"mariokart","Mario Kart",3,"Un clasico"));
        juegos.add(new Juego(4,"pacman","Pac-Man",4,"Come quesitos"));
        juegos.add(new Juego(5,"uno","Uno",5,"Rompe amistades"));
*/


        binding.rclvViejaEscuela.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        binding.rclvViejaEscuela.setLayoutManager(layoutManager);
        binding.rclvViejaEscuela.setAdapter(new JuegosAdapter(juegos));

    }

}
