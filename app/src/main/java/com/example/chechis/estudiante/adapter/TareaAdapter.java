package com.example.chechis.estudiante.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chechis.estudiante.R;

import org.w3c.dom.Text;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaHolder> {

    private Context context;
    private List<Tarea> tareas;

    public TareaAdapter(Context context, List<Tarea> tareas) {
        this.context = context;
        this.tareas = tareas;
    }

    protected class TareaHolder extends RecyclerView.ViewHolder{
        protected TextView txtTarea, txtAsignatura, txtEstudiante, txtNota;

        public TareaHolder (View itemView){
            super(itemView);

            txtTarea=(TextView) itemView.findViewById(R.id.txt_tarea);
            txtAsignatura=(TextView) itemView.findViewById(R.id.txt_asignatura);
            txtEstudiante=(TextView) itemView.findViewById(R.id.txt_estudiante);
            txtNota=(TextView) itemView.findViewById(R.id.txt_nota);

        }

    }

    @Override
    public TareaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.plantilla, parent, false);
        return new TareaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TareaHolder holder, int position) {

        holder.txtTarea.setText("Tarea: "+tareas.get(position).getTarea());
        holder.txtAsignatura.setText("Estudiante: "+tareas.get(position).getAsignatura());
        holder.txtEstudiante.setText("Asignatura: "+tareas.get(position).getEstudiante());
        holder.txtNota.setText("Nota: "+tareas.get(position).getNota());
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }
}
