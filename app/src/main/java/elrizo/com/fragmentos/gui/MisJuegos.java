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
import elrizo.com.fragmentos.databinding.FragmentMisJuegosBinding;
import elrizo.com.fragmentos.gui.components.MisJuegosAdapter;
import elrizo.com.fragmentos.gui.components.NavigationIconClickListener;
import elrizo.com.fragmentos.model.Juego;
import elrizo.com.fragmentos.model.MiJuego;

public class MisJuegos extends Fragment {

    private FragmentMisJuegosBinding binding;
    private View view;
    private Context context;
    private List<MiJuego> misJuegos = new ArrayList<>();


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
        MainActivity.GLOBALS.put("misJuegosFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentMisJuegosBinding.inflate(inflater,container,false);

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
                view.findViewById(R.id.gridMisJuegos),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));

    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridMisJuegos).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {
        misJuegos.add(new MiJuego(1,"amongus","Among Us",5,"El funado"));
        misJuegos.add(new MiJuego(2,"halo","Halo Reach",5,"Master Chief es la onda!"));
        misJuegos.add(new MiJuego(3,"animalcrossing","Animal Crossing",5,"Simulando la vida con animalitos"));
        misJuegos.add(new MiJuego(4,"mariobros","Mario Bros",5,"Mario rojo y Mario verde"));
        misJuegos.add(new MiJuego(5,"smashbros","Smash Bros Ultimate",5,"Saca el switch chino"));
        misJuegos.add(new MiJuego(6,"zelda","The Legend of Zelda",4,"Pasate el zelda"));
        misJuegos.add(new MiJuego(7,"destiny2","Destiny",4,"El legado de Halo"));
        misJuegos.add(new MiJuego(8,"uno","Uno",5,"El rompe amistades"));
        misJuegos.add(new MiJuego(9,"worms","Worms",5,"Gusanos suicidas"));
        misJuegos.add(new MiJuego(10,"minecraft","Maincra",5,"Juego de cuadritos HD"));


        binding.rclvMisJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        binding.rclvMisJuegos.setLayoutManager(layoutManager);
        binding.rclvMisJuegos.setAdapter(new MisJuegosAdapter(misJuegos));
    }


}
