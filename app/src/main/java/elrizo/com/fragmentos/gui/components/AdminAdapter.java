package elrizo.com.fragmentos.gui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import elrizo.com.fragmentos.R;
import elrizo.com.fragmentos.model.Admin;
import elrizo.com.fragmentos.model.Juego;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ViewHolder> {
private List<Juego> admins;
private Context context;

    public AdminAdapter(List<Juego> admins) {
        this.admins = admins;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_admin, parent,false);
        context = parent.getContext();
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Juego administracion = admins.get(position);
        String imgUri = "@drawable/" + administracion.getImagen();
        int imgResourse = context.getResources().getIdentifier(imgUri,null, context.getPackageName());
        holder.imgJuego.setImageResource(imgResourse);
        holder.txtTitulo.setText(administracion.getTitulo());
        holder.rbClasificacion.setRating(administracion.getClasificacion());
        holder.txtDescripcion.setText(administracion.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return admins.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private AppCompatImageView imgJuego;
        private TextView txtTitulo;
        private AppCompatRatingBar rbClasificacion;
        private TextView txtDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgJuego = itemView.findViewById(R.id.imgJuego);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            rbClasificacion = itemView.findViewById(R.id.rbClasificacion);
            txtDescripcion= itemView.findViewById(R.id.txtDescripcion);
            this.view = itemView;
        }
    }

}
