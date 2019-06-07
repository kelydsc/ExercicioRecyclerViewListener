package br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.R;
import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.digital.exerciciorecyclerviewlistener.professores.model.Professor;

public class RecyclerViewProfessorAdapter extends RecyclerView.Adapter<RecyclerViewProfessorAdapter.ViewHolder> {

    private List<Professor> professores;
    private RecyclerViewClickListener listener;

    public RecyclerViewProfessorAdapter(List<Professor> professores, RecyclerViewClickListener listener) {
        this.professores = professores;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewProfessorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.professor_recyclerview_item, viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewProfessorAdapter.ViewHolder viewHolder, int position) {

        final Professor professor = professores.get(position);
        viewHolder.setaProfessorNaTela(professor);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(professor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return professores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos dos elementos
        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewCurso;

        public ViewHolder(View itemview) {
            super(itemview);

            //Inicializamos as views
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewCurso = itemView.findViewById(R.id.textViewCurso);

        }

        //Atribui o as views os valores da variável contato
        public void setaProfessorNaTela(Professor professor){
            imageViewFoto.setImageDrawable(ContextCompat.getDrawable(
                    imageViewFoto.getContext(),professor.getFoto()));
            textViewNome.setText(professor.getNome());
            textViewCurso.setText(professor.getCurso());
        }
    }
}
