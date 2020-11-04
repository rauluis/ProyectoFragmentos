package elrizo.com.fragmentos.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import elrizo.com.fragmentos.R;
import elrizo.com.fragmentos.databinding.FragmentTopJuegosBinding;
import elrizo.com.fragmentos.gui.components.JuegosAdapter;
import elrizo.com.fragmentos.gui.components.NavigationHost;
import elrizo.com.fragmentos.gui.components.NavigationIconClickListener;
import elrizo.com.fragmentos.model.Juego;


public class TopJuegos extends Fragment {

    private FragmentTopJuegosBinding binding;
    private View view;
    private Context context;
    private List<Juego> juegos = new ArrayList<>();


    private static final String PATH_TOP= "topJuegos";//la raiz

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
        binding.fabCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((NavigationHost)getActivity()).navigateTo(new addFragment(), true);
            }
        });
        return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("topJuegosFragment",this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentTopJuegosBinding.inflate(inflater,container,false);
        view = binding.getRoot();
        context = container.getContext();
    }

    private void configToolbar() {
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if(activity!=null){
            activity.setSupportActionBar(binding.appBar);
        }
        binding.appBar.setNavigationOnClickListener(
                new NavigationIconClickListener(context,
                view.findViewById(R.id.gridTopJuegos),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridTopJuegos).
                    setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
}

    private void configRecycler() {
//        juegos.add(new Juego(1,"halo","Halo Reach",5,"Veo gente muerta"));
//        juegos.add(new Juego(2,"callofduty","Call of dutty",1,"Free Fire para fresas"));
//        juegos.add(new Juego(3,"mariokart","Mario Kart",3,"Un clasico"));
//        juegos.add(new Juego(4,"minecraft","Maincra",5,"Juego de cuadritos HD"));
     //   juegos.add(new Juego(5,"destiny2","Destiny",4,"El legado de Halo"));



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(PATH_TOP);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Juego juego = snapshot.getValue(Juego.class);

                if (!juegos.contains(juego)) {
                    juegos.add(juego);
                }
                binding.rclvTopJuegos.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Juego juego = snapshot.getValue(Juego.class);
                if (juego != null){
                    Log.i("juego","onChildChanged: " + juego.getIdJuego());
                }

                juegos.set(juegos.indexOf(juego),juego);
                binding.rclvTopJuegos.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

             //   Juego juego = snapshot.getValue(Juego.class);
               // juegos.remove(juego);

               // binding.rclvTopJuegos.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegos));


    }
}